$(document).ready(function(){
    $(".addNewArticle").click(function(){
        $("#forum_id").val($(this).attr("data-forum-id"));
    });

    $(".addNewMessage").click(function(){
        $("#article_id").val($(this).attr("data-article-id"));
    });
});