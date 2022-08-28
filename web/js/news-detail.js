$(function () {
    findNewsStyle();
    let newsId = sessionStorage.getItem("newsId");
    findById(newsId);
})

function findById(id) {
    // $.ajax({});
    let res = myAjax("/back/newsDetail/findById", {id: id}, "get");
    console.log(res)
    setPageData(res);
}

function setPageData(data) {
//    查询的数据有可能有1条，2条，3条
    if (data.length == 1) {
        setLastData({title: "无"})
        setNormalData(data[0]);
        setNextData({title: "无"})
    }
    if (data.length == 2) {
        if (data[0].id == sessionStorage.getItem("newsId")) {
            setLastData({title: "无"})
            setNormalData(data[0]);
            setNextData(data[1])
        } else {
            setLastData(data[0])
            setNormalData(data[1]);
            setNextData({title: "无"})
        }

    }
    if (data.length == 3) {
        setLastData(data[0])
        setNormalData(data[1]);
        setNextData(data[2])
    }
}

function setNormalData(data) {
    $("#news-content").html(data.title);
}

function setLastData(data) {
    $("#lastTitle").html(" <div>上一篇：</div>\n" +
        "                            <div onclick='findById(" + data.id + ")'>" + data.title + "</div>");

}

function setNextData(data) {
    $("#nextTitle").html(" <div>下一篇：</div>\n" +
        "                            <div onclick='findById(" + data.id + ")'>" + data.title + "</div>");
}

function findNewsStyle() {
    let res = myAjax("/back/newsStyle/findAll", {}, "get");
    setNewsStyle(res);
}

function setNewsStyle(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<div onclick="gotoNewsPage(' + data[i].id + ')">' + data[i].name + '</div>';
    }
    $("#news-style").html(html);

}

function gotoNewsPage(id) {
    sessionStorage.setItem("newsStyleId", id);
    window.open("/html/news.html");
}