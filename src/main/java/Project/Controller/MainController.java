package Project.Controller;

import Project.Model.Article;
import Project.Model.Forum;
import Project.Model.Message;
import Project.Model.User;
import Project.Service.ArticleService;
import Project.Service.MessageService;
import Project.Service.UserService;
import Project.Service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main(ModelMap modelMap, HttpSession httpSession) {
        return "Main/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login(ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("User", new User());
        return "Main/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "forum")
    public String forum(ModelMap modelMap, HttpSession httpSession) {

        List<Forum> listForum = forumService.getAll();
        modelMap.addAttribute("listForum", listForum);
        modelMap.addAttribute("Forum", new Forum());
        modelMap.addAttribute("Article", new Article());

        return "Main/forum";
    }

    @RequestMapping(method = RequestMethod.GET, value = "article/{articleId}")
    public String article(@PathVariable(value = "articleId") int id, ModelMap modelMap, HttpSession httpSession) {

        Article article = articleService.get(id, true);

        Collections.reverse(article.getMessages());

        modelMap.addAttribute("article", article);
        modelMap.addAttribute("Message", new Message());
        return "Main/article";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMessage")
    public String addMessage(@RequestParam(value = "article_id") long article_id, @ModelAttribute("Message") @Valid Message message, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        if (result.hasErrors()) {
            return "redirect:/forum";
        }

        message.setUser((User) httpSession.getAttribute("User"));
        message.setArticle(articleService.get(article_id, false));

        messageService.add(message);
        return "redirect:/article/" + article_id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addForum")
    public String addForum(@ModelAttribute("Forum") @Valid Forum forum, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        if (result.hasErrors()) {
            return "redirect:/forum";
        }

        forumService.add(forum);
        return "redirect:/forum";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addArticle")
    public String addArticle(@RequestParam(value = "forum_id") long forum_id, @ModelAttribute("Article") @Valid Article article, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        if (result.hasErrors()) {
            return "redirect:/forum";
        }

        article.setForum(forumService.get(forum_id));
        articleService.add(article);
        return "redirect:/forum";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public String addUser(@ModelAttribute("User") @Valid User user, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        if (result.hasErrors()) {
            System.out.println("NOK");
            return "Main/signup";
        }

        user.setPwd(encodeSHA512(user.getPwd()));
        user.setNom(user.getNom().toUpperCase());

        userService.add(user);
        return "Main/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "signup")
    public String singup(ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("User", new User());
        return "Main/signup";
    }

    @RequestMapping(method = RequestMethod.GET, value = "generator")
    public String generator(ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("User", httpSession.getAttribute("User"));

        if (httpSession.getAttribute("User") == null) {
            return "redirect:/";
        }

        return "Main/generator";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getUser")
    public String getUser(@RequestParam(value = "email") String email, @RequestParam(value = "pwd") String pwd, ModelMap modelMap, HttpSession httpSession) {

        User u = userService.getByEmailPwd(email, encodeSHA512(pwd));
        if (u != null) {
            httpSession.setAttribute("User", u);
        } else {
            return "Main/login";
        }

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpSession httpSession) {

        if (httpSession.getAttribute("User") != null) {
            httpSession.invalidate();
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/account")
    public String account(HttpSession httpSession, ModelMap modelMap) {
        modelMap.addAttribute("User", httpSession.getAttribute("User"));

        if (httpSession.getAttribute("User") != null) {
            return "Main/account";
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public String updateUser(@ModelAttribute("User") @Valid User user, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        /*user.validate(user, result);*/
        if (result.hasErrors()) {
            return "Main/account";
        }

        if (httpSession.getAttribute("User") != null) {
            user.setId(((User) httpSession.getAttribute("User")).getId());
            user.setPwd(encodeSHA512(user.getPwd()));
            user.setNom(user.getNom().toUpperCase());
        }

        httpSession.setAttribute("User", user);

        userService.update(user);
        return "redirect:/";
    }

    public static String encodeSHA512(String plainPassword) {
        return new ShaPasswordEncoder(512).encodePassword(plainPassword, null);
    }

}
