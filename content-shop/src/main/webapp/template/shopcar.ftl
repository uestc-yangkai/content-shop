<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<#assign total = 0>
        <#if (!shopcar??) || (!shopcar?has_content)>
            <div class="n-result">
                <h3>购物车暂无内容！</h3>
            </div>
        <#else>
                <table class="m-table m-table-row n-table g-b3">
                    <colgroup><col/><col class="time"/><col class="price"/><col class="price"/><col class="price"/></colgroup>
                    <thead>
                    <tr><th>内容名称</th><th>当前价格</th><th>购买数量</th><th>操作</th></tr>
                    </thead>
                    <tbody>
                    <#list shopcar as x>
                        <#assign total = total + x.count*x.currentPrice>
                    <tr>
                        <td><h4><a href="/show?id=${x.content_id}">${x.title!""}</a></h4></td>
                        <td><span class="v-unit">¥</span><span class="value">${x.currentPrice!0}</span></td>
                        <td><span class="v-unit"></span><span class="value">${x.count!0}</span></td>
                        <td><span class="v-unit"></span><span class="value"><a href="/shopcar/delete?id=${x.id}">删除</a></span></td>
                    </tr>
                    </#list>
                    </tbody>
                    <tfoot>
                <tr>
                    <td colspan="1"><div class="total">总计：</div></td>
                    <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
                    <td><span class="v-unit"></span><a href="/bill/add"><span class="u-btn u-btn-primary">购买</span></a></td>
                </tr>
                </tfoot>
            </table>
        </#if>
<#include "./include/footer.ftl">
</body>
</html>