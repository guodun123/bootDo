$().ready(function () {
    validateRule();
});
$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    var toItemStr = [];
    $.map($('#soItemTable').bootstrapTable('getData'), function (row) {
        var item = {};
        item.skuCode =row.skuCode;
        item.skuName =row.skuName;
        item.qty =$("#qty_"+(row.index-1)).val();
        item.price =$("#price_"+(row.index-1)).val();
        item.amount =$("#amount_"+(row.index-1)).val();
        item.skuId =row.skuId;
        toItemStr.push(item);
        return row

    });
    $("#itemStr").val(JSON.stringify( toItemStr ));
    $.ajax({
        cache: true,
        type: "POST",
        url: "/so/save",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate();
}
