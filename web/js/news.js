$(function () {
    findNewsStyle();
    let newsStyleId = sessionStorage.getItem("newsStyleId");
    findAll(newsStyleId);
})

//查询新闻数据
function findAll(newsStyleId, obj) {
    //如果id为空：
    // if(newsStyleId!=null){
    //
    // }
    //$(obj).parents("div").children("div")
    console.log($("#news-style").children("div"))
    $("#news-style").children("div").each(function () {
        $(this).css({"background-color": ""})
    })
    $(obj).css({"background-color": "yellow"})
    let res = myAjax("/back/news/newsStyleId", {newsStyleId: newsStyleId}, "get");
    setNewsData(res);
}

function setNewsData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<div>\n' +
            '\n' +
            '                        <div>\n' +
            '                            <div><img src="../img/21.png" height="16" width="16"/></div>\n' +
            '                            <div>' + data[i].title + '\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '                        <div>' + data[i].createTime + '</div>\n' +
            '                    </div>';
    }
    $("#newContent").html(html);
}

function findNewsStyle() {
    let res = myAjax("/back/newsStyle/findAll", {}, "get");
    setNewsStyle(res);
}

function setNewsStyle(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<div  onclick="findAll(' + data[i].id + ',this)">' + data[i].name + '</div>';
    }
    $("#news-style").html(html);

}