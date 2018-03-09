<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <#if user?exists>
            <#if user.userType==1>卖家<#else>买家</#if>你好，<span class="name">${user.userName}</span>！<a href="/logout">[退出]</a>
        <#else>
            请<a href="/loginTable">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <#if user?exists && user.userType==0>
            <li><a href="/bill">账务</a></li>
                <li><a href="/shopcar">购物车</a></li>
            </#if>
            <#if user?exists && user.userType==1>
            <li><a href="/content/public">发布</a></li>
            </#if>
        </ul>
    </div>
</div>