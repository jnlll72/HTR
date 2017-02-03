package Project.Controller;

import Project.Model.User;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main(ModelMap modelMap, HttpSession httpSession) {
        return "Main/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "home")
    public String home(ModelMap modelMap, HttpSession httpSession) {
        return "Main/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login(ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("User", new User());
        return "Main/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "signup")
    public String singup(ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("User", new User());
        return "Main/signup";
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

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public String addUser(@ModelAttribute("User") @Valid User user, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        /*user.validate(user, result);*/
        if (result.hasErrors()) {
            if(user.getNom() == null){
                modelMap.addAttribute("errNom","champs obligatoire");
            }
            return "Main/signup";
        }

        user.setPwd(encodeSHA512(user.getPwd()));

        userService.add(user);
        return "Main/login";
    }

    public static String encodeSHA512(String plainPassword) {
        return new ShaPasswordEncoder(512).encodePassword(plainPassword, null);
    }


    /*@Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main(ModelMap modelMap, HttpSession httpSession){

        User userSession = (User) httpSession.getAttribute("User");
        if (userSession == null) {
            // Création de l'utilisateur
            long id = userService.add(new User("Mattieu", "Racine"));


            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> constraintViolations = validator.validate( new User("M", "Racine") );
            Iterator<ConstraintViolation<User>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            // Récupération de l'utilisateur
            userSession = userService.getById(id, false);

            // Création de 2 messages
            messageService.add(new Message("Message 1", userSession));
            messageService.add(new Message("Message 2", userSession));

            // Récupération de l'utilisateur
            userSession = userService.getById(id, true);

            // Sauvegarde de l'utilisateur dans la session
            httpSession.setAttribute("User", userSession);
        }

        // Ajouter les éléments à la vue
        modelMap.addAttribute("User", userSession);
        modelMap.addAttribute("Message", new Message());

        String messageEncode = userSession.getMessages().size() > 0 ? encodeSHA512(userSession.getMessages().get(userSession.getMessages().size()-1).getMessage()) : "Erreur, Aucun Message";
        modelMap.addAttribute("Encode", messageEncode);

        return "Main/index";
    }

    @RequestMapping( method = RequestMethod.POST , value = "/addMessage")
    public String addMessage(@ModelAttribute("Message") @Valid Message message, BindingResult result, ModelMap modelMap, HttpSession httpSession) {

        // Récupération de l'utilisateur courant
        User user = (User) httpSession.getAttribute("User");

        // Vérification des erreurs
        message.validate(message, result);
        if (result.hasErrors()) {
            return "Main/index";
        }

        // Ajout du Message
        message.setUser(user);
        messageService.add(message);

        user.getMessages().add(message);

        // Mise à jour de la session
        httpSession.setAttribute("User", user);

        // Ajouter les éléments à la vue
        modelMap.addAttribute("User", user);

        return "redirect:/";
    }

    @RequestMapping( method = RequestMethod.POST , value = "/deleteUser")
    public String deleteUser(HttpSession httpSession, SessionStatus status) {

        // Récupération de l'utilisateur courant
        User user = (User) httpSession.getAttribute("User");

        // Suppression de l'utilisateur
        userService.delete(user);

        // Suppression de la session
        status.setComplete();

        return "redirect:/";
    }

    @RequestMapping( method = RequestMethod.POST , value = "/deleteMessage")
    public String deleteMessage(HttpSession httpSession, SessionStatus status) {

        // Récupération de l'utilisateur courant
        User user = (User) httpSession.getAttribute("User");

        // Suppression de l'utilisateur
        messageService.deleteAll(user);
        user.setMessages(new ArrayList<Message>());

        // Mise à jour de la session
        httpSession.setAttribute("User", user);

        return "redirect:/";
    }

    public static String encodeSHA512(String plainPassword) {
        return new ShaPasswordEncoder(512).encodePassword(plainPassword, null);
    }*/
}
