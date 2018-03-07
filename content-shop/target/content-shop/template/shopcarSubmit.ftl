<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<#assign st =Request['status']!0>
<#assign productId = RequestParameters['id']!0>
<div class="g-doc">
    <#if st gt 0>
    <div class="n-result">
        <h3>添加到购物车成功！</h3>
        <p><a href="/shopcar">[查看购物车]</a><a href="/">[返回首页]</a></p>
    </div>
    <#else>
    <div class="n-result">
        <h3>添加到购物车失败！</h3>
        <p><a href="/show?id=${productId}">[重新添加]</a><a href="/">[返回首页]</a></p>
    </div>
    </#if>
</div>
<#include "./include/footer.ftl">
</body>
</html>