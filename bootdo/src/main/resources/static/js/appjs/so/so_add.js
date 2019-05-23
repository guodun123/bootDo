$().ready(function () {
    validateRule();
    load();
    loadType();
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
function loadType(){
    var html = "";
    $.ajax({
        url : '/common/dict/list/payment_way',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#soItemTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function load() {
    $('#soItemTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: false, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                uniqueId: 'index',
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'index',
                        title: '序号',//标题  可不加
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'skuCode',
                        title: '商品编码'
                    },
                    {
                        field: 'skuName',
                        title: '商品名称'
                    },
                    {
                        field: 'qty',
                        title: '商品数量'/*,
                        formatter: function (value, row, index) {return " <div class='col-sm-6'>" +
                            " <input id='qty_"+index + 1+"' name='qty' class='form-control' type='text'>" +
                            "</div>";}*/
                    },
                    {
                        field: 'price',
                        title: '商品单价'/*,
                        formatter: function (value, row, index) {return " <div class='col-sm-6'>" +
                            " <input id='price_"+index + 1+"' name='price' class='form-control' type='text'>" +
                            "</div>";}*/
                    },
                    {
                        field: 'amount',
                        title: '金额'/*,
                        formatter: function (value, row, index) {return " <div class='col-sm-6'>" +
                            " <input id='amount"+index + 1+"' name='amount' class='form-control' type='text'>" +
                            "</div>";}*/
                    },
                    {
                        field : 'skuId',
                        title : '',
                        visible:false
                    },
                    {
                        field: 'op',
                        title: '操作'
                    }]
            });
}