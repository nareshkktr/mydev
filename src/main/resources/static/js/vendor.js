/*
 AngularJS v1.6.1
 (c) 2010-2016 Google, Inc. http://angularjs.org
 License: MIT
*/
(function(z){'use strict';function M(a,b){b=b||Error;return function(){var d=arguments[0],c;c="["+(a?a+":":"")+d+"] http://errors.angularjs.org/1.6.1/"+(a?a+"/":"")+d;for(d=1;d<arguments.length;d++){c=c+(1==d?"?":"&")+"p"+(d-1)+"=";var f=encodeURIComponent,e;e=arguments[d];e="function"==typeof e?e.toString().replace(/ \{[\s\S]*$/,""):"undefined"==typeof e?"undefined":"string"!=typeof e?JSON.stringify(e):e;c+=f(e)}return new b(c)}}function ta(a){if(null==a||Wa(a))return!1;if(C(a)||E(a)||D&&a instanceof
D)return!0;var b="length"in Object(a)&&a.length;return Y(b)&&(0<=b&&(b-1 in a||a instanceof Array)||"function"===typeof a.item)}function q(a,b,d){var c,f;if(a)if(y(a))for(c in a)"prototype"!==c&&"length"!==c&&"name"!==c&&a.hasOwnProperty(c)&&b.call(d,a[c],c,a);else if(C(a)||ta(a)){var e="object"!==typeof a;c=0;for(f=a.length;c<f;c++)(e||c in a)&&b.call(d,a[c],c,a)}else if(a.forEach&&a.forEach!==q)a.forEach(b,d,a);else if(Dc(a))for(c in a)b.call(d,a[c],c,a);else if("function"===typeof a.hasOwnProperty)for(c in a)a.hasOwnProperty(c)&&
b.call(d,a[c],c,a);else for(c in a)va.call(a,c)&&b.call(d,a[c],c,a);return a}function Ec(a,b,d){for(var c=Object.keys(a).sort(),f=0;f<c.length;f++)b.call(d,a[c[f]],c[f]);return c}function Fc(a){return function(b,d){a(d,b)}}function ie(){return++rb}function Sb(a,b,d){for(var c=a.$$hashKey,f=0,e=b.length;f<e;++f){var g=b[f];if(F(g)||y(g))for(var h=Object.keys(g),k=0,l=h.length;k<l;k++){var m=h[k],n=g[m];d&&F(n)?fa(n)?a[m]=new Date(n.valueOf()):Xa(n)?a[m]=new RegExp(n):n.nodeName?a[m]=n.cloneNode(!0):
Tb(n)?a[m]=n.clone():(F(a[m])||(a[m]=C(n)?[]:{}),Sb(a[m],[n],!0)):a[m]=n}}c?a.$$hashKey=c:delete a.$$hashKey;return a}function R(a){return Sb(a,wa.call(arguments,1),!1)}function je(a){return Sb(a,wa.call(arguments,1),!0)}function Z(a){return parseInt(a,10)}function Ub(a,b){return R(Object.create(a),b)}function w(){}function Ya(a){return a}function ma(a){return function(){return a}}function Vb(a){return y(a.toString)&&a.toString!==na}function x(a){return"undefined"===typeof a}function v(a){return"undefined"!==
typeof a}function F(a){return null!==a&&"object"===typeof a}function Dc(a){return null!==a&&"object"===typeof a&&!Gc(a)}function E(a){return"string"===typeof a}function Y(a){return"number"===typeof a}function fa(a){return"[object Date]"===na.call(a)}function y(a){return"function"===typeof a}function Xa(a){return"[object RegExp]"===na.call(a)}function Wa(a){return a&&a.window===a}function Za(a){return a&&a.$evalAsync&&a.$watch}function Ia(a){return"boolean"===typeof a}function ke(a){return a&&Y(a.length)&&
le.test(na.call(a))}function Tb(a){return!(!a||!(a.nodeName||a.prop&&a.attr&&a.find))}function me(a){var b={};a=a.split(",");var d;for(d=0;d<a.length;d++)b[a[d]]=!0;return b}function xa(a){return P(a.nodeName||a[0]&&a[0].nodeName)}function $a(a,b){var d=a.indexOf(b);0<=d&&a.splice(d,1);return d}function Fa(a,b){function d(a,b){var d=b.$$hashKey,e;if(C(a)){e=0;for(var f=a.length;e<f;e++)b.push(c(a[e]))}else if(Dc(a))for(e in a)b[e]=c(a[e]);else if(a&&"function"===typeof a.hasOwnProperty)for(e in a)a.hasOwnProperty(e)&&
(b[e]=c(a[e]));else for(e in a)va.call(a,e)&&(b[e]=c(a[e]));d?b.$$hashKey=d:delete b.$$hashKey;return b}function c(a){if(!F(a))return a;var b=e.indexOf(a);if(-1!==b)return g[b];if(Wa(a)||Za(a))throw Ga("cpws");var b=!1,c=f(a);void 0===c&&(c=C(a)?[]:Object.create(Gc(a)),b=!0);e.push(a);g.push(c);return b?d(a,c):c}function f(a){switch(na.call(a)){case "[object Int8Array]":case "[object Int16Array]":case "[object Int32Array]":case "[object Float32Array]":case "[object Float64Array]":case "[object Uint8Array]":case "[object Uint8ClampedArray]":case "[object Uint16Array]":case "[object Uint32Array]":return new a.constructor(c(a.buffer),
a.byteOffset,a.length);case "[object ArrayBuffer]":if(!a.slice){var b=new ArrayBuffer(a.byteLength);(new Uint8Array(b)).set(new Uint8Array(a));return b}return a.slice(0);case "[object Boolean]":case "[object Number]":case "[object String]":case "[object Date]":return new a.constructor(a.valueOf());case "[object RegExp]":return b=new RegExp(a.source,a.toString().match(/[^/]*$/)[0]),b.lastIndex=a.lastIndex,b;case "[object Blob]":return new a.constructor([a],{type:a.type})}if(y(a.cloneNode))return a.cloneNode(!0)}
var e=[],g=[];if(b){if(ke(b)||"[object ArrayBuffer]"===na.call(b))throw Ga("cpta");if(a===b)throw Ga("cpi");C(b)?b.length=0:q(b,function(a,d){"$$hashKey"!==d&&delete b[d]});e.push(a);g.push(b);return d(a,b)}return c(a)}function qa(a,b){if(a===b)return!0;if(null===a||null===b)return!1;if(a!==a&&b!==b)return!0;var d=typeof a,c;if(d===typeof b&&"object"===d)if(C(a)){if(!C(b))return!1;if((d=a.length)===b.length){for(c=0;c<d;c++)if(!qa(a[c],b[c]))return!1;return!0}}else{if(fa(a))return fa(b)?qa(a.getTime(),
b.getTime()):!1;if(Xa(a))return Xa(b)?a.toString()===b.toString():!1;if(Za(a)||Za(b)||Wa(a)||Wa(b)||C(b)||fa(b)||Xa(b))return!1;d=W();for(c in a)if("$"!==c.charAt(0)&&!y(a[c])){if(!qa(a[c],b[c]))return!1;d[c]=!0}for(c in b)if(!(c in d)&&"$"!==c.charAt(0)&&v(b[c])&&!y(b[c]))return!1;return!0}return!1}function ab(a,b,d){return a.concat(wa.call(b,d))}function bb(a,b){var d=2<arguments.length?wa.call(arguments,2):[];return!y(b)||b instanceof RegExp?b:d.length?function(){return arguments.length?b.apply(a,
ab(d,arguments,0)):b.apply(a,d)}:function(){return arguments.length?b.apply(a,arguments):b.call(a)}}function Hc(a,b){var d=b;"string"===typeof a&&"$"===a.charAt(0)&&"$"===a.charAt(1)?d=void 0:Wa(b)?d="$WINDOW":b&&z.document===b?d="$DOCUMENT":Za(b)&&(d="$SCOPE");return d}function cb(a,b){if(!x(a))return Y(b)||(b=b?2:null),JSON.stringify(a,Hc,b)}function Ic(a){return E(a)?JSON.parse(a):a}function Jc(a,b){a=a.replace(ne,"");var d=Date.parse("Jan 01, 1970 00:00:00 "+a)/6E4;return ga(d)?b:d}function Wb(a,
b,d){d=d?-1:1;var c=a.getTimezoneOffset();b=Jc(b,c);d*=b-c;a=new Date(a.getTime());a.setMinutes(a.getMinutes()+d);return a}function ya(a){a=D(a).clone();try{a.empty()}catch(b){}var d=D("<div>").append(a).html();try{return a[0].nodeType===Ja?P(d):d.match(/^(<[^>]+>)/)[1].replace(/^<([\w-]+)/,function(a,b){return"<"+P(b)})}catch(c){return P(d)}}function Kc(a){try{return decodeURIComponent(a)}catch(b){}}function Lc(a){var b={};q((a||"").split("&"),function(a){var c,f,e;a&&(f=a=a.replace(/\+/g,"%20"),
c=a.indexOf("="),-1!==c&&(f=a.substring(0,c),e=a.substring(c+1)),f=Kc(f),v(f)&&(e=v(e)?Kc(e):!0,va.call(b,f)?C(b[f])?b[f].push(e):b[f]=[b[f],e]:b[f]=e))});return b}function Xb(a){var b=[];q(a,function(a,c){C(a)?q(a,function(a){b.push(ka(c,!0)+(!0===a?"":"="+ka(a,!0)))}):b.push(ka(c,!0)+(!0===a?"":"="+ka(a,!0)))});return b.length?b.join("&"):""}function db(a){return ka(a,!0).replace(/%26/gi,"&").replace(/%3D/gi,"=").replace(/%2B/gi,"+")}function ka(a,b){return encodeURIComponent(a).replace(/%40/gi,
"@").replace(/%3A/gi,":").replace(/%24/g,"$").replace(/%2C/gi,",").replace(/%3B/gi,";").replace(/%20/g,b?"%20":"+")}function oe(a,b){var d,c,f=Ka.length;for(c=0;c<f;++c)if(d=Ka[c]+b,E(d=a.getAttribute(d)))return d;return null}function pe(a,b){var d,c,f={};q(Ka,function(b){b+="app";!d&&a.hasAttribute&&a.hasAttribute(b)&&(d=a,c=a.getAttribute(b))});q(Ka,function(b){b+="app";var f;!d&&(f=a.querySelector("["+b.replace(":","\\:")+"]"))&&(d=f,c=f.getAttribute(b))});d&&(qe?(f.strictDi=null!==oe(d,"strict-di"),
b(d,c?[c]:[],f)):z.console.error("Angular: disabling automatic bootstrap. <script> protocol indicates an extension, document.location.href does not match."))}function Mc(a,b,d){F(d)||(d={});d=R({strictDi:!1},d);var c=function(){a=D(a);if(a.injector()){var c=a[0]===z.document?"document":ya(a);throw Ga("btstrpd",c.replace(/</,"&lt;").replace(/>/,"&gt;"));}b=b||[];b.unshift(["$provide",function(b){b.value("$rootElement",a)}]);d.debugInfoEnabled&&b.push(["$compileProvider",function(a){a.debugInfoEnabled(!0)}]);
b.unshift("ng");c=eb(b,d.strictDi);c.invoke(["$rootScope","$rootElement","$compile","$injector",function(a,b,d,c){a.$apply(function(){b.data("$injector",c);d(b)(a)})}]);return c},f=/^NG_ENABLE_DEBUG_INFO!/,e=/^NG_DEFER_BOOTSTRAP!/;z&&f.test(z.name)&&(d.debugInfoEnabled=!0,z.name=z.name.replace(f,""));if(z&&!e.test(z.name))return c();z.name=z.name.replace(e,"");$.resumeBootstrap=function(a){q(a,function(a){b.push(a)});return c()};y($.resumeDeferredBootstrap)&&$.resumeDeferredBootstrap()}function re(){z.name=
"NG_ENABLE_DEBUG_INFO!"+z.name;z.location.reload()}function se(a){a=$.element(a).injector();if(!a)throw Ga("test");return a.get("$$testability")}function Nc(a,b){b=b||"_";return a.replace(te,function(a,c){return(c?b:"")+a.toLowerCase()})}function ue(){var a;if(!Oc){var b=sb();(oa=x(b)?z.jQuery:b?z[b]:void 0)&&oa.fn.on?(D=oa,R(oa.fn,{scope:Oa.scope,isolateScope:Oa.isolateScope,controller:Oa.controller,injector:Oa.injector,inheritedData:Oa.inheritedData}),a=oa.cleanData,oa.cleanData=function(b){for(var c,
f=0,e;null!=(e=b[f]);f++)(c=oa._data(e,"events"))&&c.$destroy&&oa(e).triggerHandler("$destroy");a(b)}):D=X;$.element=D;Oc=!0}}function fb(a,b,d){if(!a)throw Ga("areq",b||"?",d||"required");return a}function tb(a,b,d){d&&C(a)&&(a=a[a.length-1]);fb(y(a),b,"not a function, got "+(a&&"object"===typeof a?a.constructor.name||"Object":typeof a));return a}function Pa(a,b){if("hasOwnProperty"===a)throw Ga("badname",b);}function Pc(a,b,d){if(!b)return a;b=b.split(".");for(var c,f=a,e=b.length,g=0;g<e;g++)c=
b[g],a&&(a=(f=a)[c]);return!d&&y(a)?bb(f,a):a}function ub(a){for(var b=a[0],d=a[a.length-1],c,f=1;b!==d&&(b=b.nextSibling);f++)if(c||a[f]!==b)c||(c=D(wa.call(a,0,f))),c.push(b);return c||a}function W(){return Object.create(null)}function Yb(a){if(null==a)return"";switch(typeof a){case "string":break;case "number":a=""+a;break;default:a=!Vb(a)||C(a)||fa(a)?cb(a):a.toString()}return a}function ve(a){function b(a,b,c){return a[b]||(a[b]=c())}var d=M("$injector"),c=M("ng");a=b(a,"angular",Object);a.$$minErr=
a.$$minErr||M;return b(a,"module",function(){var a={};return function(e,g,h){if("hasOwnProperty"===e)throw c("badname","module");g&&a.hasOwnProperty(e)&&(a[e]=null);return b(a,e,function(){function a(b,d,e,f){f||(f=c);return function(){f[e||"push"]([b,d,arguments]);return J}}function b(a,d,f){f||(f=c);return function(b,c){c&&y(c)&&(c.$$moduleName=e);f.push([a,d,arguments]);return J}}if(!g)throw d("nomod",e);var c=[],f=[],p=[],r=a("$injector","invoke","push",f),J={_invokeQueue:c,_configBlocks:f,_runBlocks:p,
requires:g,name:e,provider:b("$provide","provider"),factory:b("$provide","factory"),service:b("$provide","service"),value:a("$provide","value"),constant:a("$provide","constant","unshift"),decorator:b("$provide","decorator",f),animation:b("$animateProvider","register"),filter:b("$filterProvider","register"),controller:b("$controllerProvider","register"),directive:b("$compileProvider","directive"),component:b("$compileProvider","component"),config:r,run:function(a){p.push(a);return this}};h&&r(h);return J})}})}
function ra(a,b){if(C(a)){b=b||[];for(var d=0,c=a.length;d<c;d++)b[d]=a[d]}else if(F(a))for(d in b=b||{},a)if("$"!==d.charAt(0)||"$"!==d.charAt(1))b[d]=a[d];return b||a}function we(a){var b=[];return JSON.stringify(a,function(a,c){c=Hc(a,c);if(F(c)){if(0<=b.indexOf(c))return"...";b.push(c)}return c})}function xe(a){R(a,{bootstrap:Mc,copy:Fa,extend:R,merge:je,equals:qa,element:D,forEach:q,injector:eb,noop:w,bind:bb,toJson:cb,fromJson:Ic,identity:Ya,isUndefined:x,isDefined:v,isString:E,isFunction:y,
isObject:F,isNumber:Y,isElement:Tb,isArray:C,version:ye,isDate:fa,lowercase:P,uppercase:vb,callbacks:{$$counter:0},getTestability:se,reloadWithDebugInfo:re,$$minErr:M,$$csp:za,$$encodeUriSegment:db,$$encodeUriQuery:ka,$$stringify:Yb});Zb=ve(z);Zb("ng",["ngLocale"],["$provide",function(a){a.provider({$$sanitizeUri:ze});a.provider("$compile",Qc).directive({a:Ae,input:Rc,textarea:Rc,form:Be,script:Ce,select:De,option:Ee,ngBind:Fe,ngBindHtml:Ge,ngBindTemplate:He,ngClass:Ie,ngClassEven:Je,ngClassOdd:Ke,
ngCloak:Le,ngController:Me,ngForm:Ne,ngHide:Oe,ngIf:Pe,ngInclude:Qe,ngInit:Re,ngNonBindable:Se,ngPluralize:Te,ngRepeat:Ue,ngShow:Ve,ngStyle:We,ngSwitch:Xe,ngSwitchWhen:Ye,ngSwitchDefault:Ze,ngOptions:$e,ngTransclude:af,ngModel:bf,ngList:cf,ngChange:df,pattern:Sc,ngPattern:Sc,required:Tc,ngRequired:Tc,minlength:Uc,ngMinlength:Uc,maxlength:Vc,ngMaxlength:Vc,ngValue:ef,ngModelOptions:ff}).directive({ngInclude:gf}).directive(wb).directive(Wc);a.provider({$anchorScroll:hf,$animate:jf,$animateCss:kf,$$animateJs:lf,
$$animateQueue:mf,$$AnimateRunner:nf,$$animateAsyncRun:of,$browser:pf,$cacheFactory:qf,$controller:rf,$document:sf,$$isDocumentHidden:tf,$exceptionHandler:uf,$filter:Xc,$$forceReflow:vf,$interpolate:wf,$interval:xf,$http:yf,$httpParamSerializer:zf,$httpParamSerializerJQLike:Af,$httpBackend:Bf,$xhrFactory:Cf,$jsonpCallbacks:Df,$location:Ef,$log:Ff,$parse:Gf,$rootScope:Hf,$q:If,$$q:Jf,$sce:Kf,$sceDelegate:Lf,$sniffer:Mf,$templateCache:Nf,$templateRequest:Of,$$testability:Pf,$timeout:Qf,$window:Rf,$$rAF:Sf,
$$jqLite:Tf,$$HashMap:Uf,$$cookieReader:Vf})}])}function gb(a,b){return b.toUpperCase()}function xb(a){return a.replace(Wf,gb)}function Yc(a){a=a.nodeType;return 1===a||!a||9===a}function Zc(a,b){var d,c,f=b.createDocumentFragment(),e=[];if($b.test(a)){d=f.appendChild(b.createElement("div"));c=(Xf.exec(a)||["",""])[1].toLowerCase();c=ha[c]||ha._default;d.innerHTML=c[1]+a.replace(Yf,"<$1></$2>")+c[2];for(c=c[0];c--;)d=d.lastChild;e=ab(e,d.childNodes);d=f.firstChild;d.textContent=""}else e.push(b.createTextNode(a));
f.textContent="";f.innerHTML="";q(e,function(a){f.appendChild(a)});return f}function X(a){if(a instanceof X)return a;var b;E(a)&&(a=S(a),b=!0);if(!(this instanceof X)){if(b&&"<"!==a.charAt(0))throw ac("nosel");return new X(a)}if(b){b=z.document;var d;a=(d=Zf.exec(a))?[b.createElement(d[1])]:(d=Zc(a,b))?d.childNodes:[];bc(this,a)}else y(a)?$c(a):bc(this,a)}function cc(a){return a.cloneNode(!0)}function yb(a,b){b||hb(a);if(a.querySelectorAll)for(var d=a.querySelectorAll("*"),c=0,f=d.length;c<f;c++)hb(d[c])}
function ad(a,b,d,c){if(v(c))throw ac("offargs");var f=(c=zb(a))&&c.events,e=c&&c.handle;if(e)if(b){var g=function(b){var c=f[b];v(d)&&$a(c||[],d);v(d)&&c&&0<c.length||(a.removeEventListener(b,e),delete f[b])};q(b.split(" "),function(a){g(a);Ab[a]&&g(Ab[a])})}else for(b in f)"$destroy"!==b&&a.removeEventListener(b,e),delete f[b]}function hb(a,b){var d=a.ng339,c=d&&ib[d];c&&(b?delete c.data[b]:(c.handle&&(c.events.$destroy&&c.handle({},"$destroy"),ad(a)),delete ib[d],a.ng339=void 0))}function zb(a,
b){var d=a.ng339,d=d&&ib[d];b&&!d&&(a.ng339=d=++$f,d=ib[d]={events:{},data:{},handle:void 0});return d}function dc(a,b,d){if(Yc(a)){var c,f=v(d),e=!f&&b&&!F(b),g=!b;a=(a=zb(a,!e))&&a.data;if(f)a[xb(b)]=d;else{if(g)return a;if(e)return a&&a[xb(b)];for(c in b)a[xb(c)]=b[c]}}}function Bb(a,b){return a.getAttribute?-1<(" "+(a.getAttribute("class")||"")+" ").replace(/[\n\t]/g," ").indexOf(" "+b+" "):!1}function Cb(a,b){b&&a.setAttribute&&q(b.split(" "),function(b){a.setAttribute("class",S((" "+(a.getAttribute("class")||
"")+" ").replace(/[\n\t]/g," ").replace(" "+S(b)+" "," ")))})}function Db(a,b){if(b&&a.setAttribute){var d=(" "+(a.getAttribute("class")||"")+" ").replace(/[\n\t]/g," ");q(b.split(" "),function(a){a=S(a);-1===d.indexOf(" "+a+" ")&&(d+=a+" ")});a.setAttribute("class",S(d))}}function bc(a,b){if(b)if(b.nodeType)a[a.length++]=b;else{var d=b.length;if("number"===typeof d&&b.window!==b){if(d)for(var c=0;c<d;c++)a[a.length++]=b[c]}else a[a.length++]=b}}function bd(a,b){return Eb(a,"$"+(b||"ngController")+
"Controller")}function Eb(a,b,d){9===a.nodeType&&(a=a.documentElement);for(b=C(b)?b:[b];a;){for(var c=0,f=b.length;c<f;c++)if(v(d=D.data(a,b[c])))return d;a=a.parentNode||11===a.nodeType&&a.host}}function cd(a){for(yb(a,!0);a.firstChild;)a.removeChild(a.firstChild)}function Fb(a,b){b||yb(a);var d=a.parentNode;d&&d.removeChild(a)}function ag(a,b){b=b||z;if("complete"===b.document.readyState)b.setTimeout(a);else D(b).on("load",a)}function $c(a){function b(){z.document.removeEventListener("DOMContentLoaded",
b);z.removeEventListener("load",b);a()}"complete"===z.document.readyState?z.setTimeout(a):(z.document.addEventListener("DOMContentLoaded",b),z.addEventListener("load",b))}function dd(a,b){var d=Gb[b.toLowerCase()];return d&&ed[xa(a)]&&d}function bg(a,b){var d=function(c,d){c.isDefaultPrevented=function(){return c.defaultPrevented};var e=b[d||c.type],g=e?e.length:0;if(g){if(x(c.immediatePropagationStopped)){var h=c.stopImmediatePropagation;c.stopImmediatePropagation=function(){c.immediatePropagationStopped=
!0;c.stopPropagation&&c.stopPropagation();h&&h.call(c)}}c.isImmediatePropagationStopped=function(){return!0===c.immediatePropagationStopped};var k=e.specialHandlerWrapper||cg;1<g&&(e=ra(e));for(var l=0;l<g;l++)c.isImmediatePropagationStopped()||k(a,c,e[l])}};d.elem=a;return d}function cg(a,b,d){d.call(a,b)}function dg(a,b,d){var c=b.relatedTarget;c&&(c===a||eg.call(a,c))||d.call(a,b)}function Tf(){this.$get=function(){return R(X,{hasClass:function(a,b){a.attr&&(a=a[0]);return Bb(a,b)},addClass:function(a,
b){a.attr&&(a=a[0]);return Db(a,b)},removeClass:function(a,b){a.attr&&(a=a[0]);return Cb(a,b)}})}}function la(a,b){var d=a&&a.$$hashKey;if(d)return"function"===typeof d&&(d=a.$$hashKey()),d;d=typeof a;return d="function"===d||"object"===d&&null!==a?a.$$hashKey=d+":"+(b||ie)():d+":"+a}function Qa(a,b){if(b){var d=0;this.nextUid=function(){return++d}}q(a,this.put,this)}function fd(a){a=(Function.prototype.toString.call(a)+" ").replace(fg,"");return a.match(gg)||a.match(hg)}function ig(a){return(a=fd(a))?
"function("+(a[1]||"").replace(/[\s\r\n]+/," ")+")":"fn"}function eb(a,b){function d(a){return function(b,c){if(F(b))q(b,Fc(a));else return a(b,c)}}function c(a,b){Pa(a,"service");if(y(b)||C(b))b=p.instantiate(b);if(!b.$get)throw da("pget",a);return n[a+"Provider"]=b}function f(a,b){return function(){var c=O.invoke(b,this);if(x(c))throw da("undef",a);return c}}function e(a,b,d){return c(a,{$get:!1!==d?f(a,b):b})}function g(a){fb(x(a)||C(a),"modulesToLoad","not an array");var b=[],c;q(a,function(a){function d(a){var b,
c;b=0;for(c=a.length;b<c;b++){var e=a[b],f=p.get(e[0]);f[e[1]].apply(f,e[2])}}if(!m.get(a)){m.put(a,!0);try{E(a)?(c=Zb(a),b=b.concat(g(c.requires)).concat(c._runBlocks),d(c._invokeQueue),d(c._configBlocks)):y(a)?b.push(p.invoke(a)):C(a)?b.push(p.invoke(a)):tb(a,"module")}catch(e){throw C(a)&&(a=a[a.length-1]),e.message&&e.stack&&-1===e.stack.indexOf(e.message)&&(e=e.message+"\n"+e.stack),da("modulerr",a,e.stack||e.message||e);}}});return b}function h(a,c){function d(b,e){if(a.hasOwnProperty(b)){if(a[b]===
k)throw da("cdep",b+" <- "+l.join(" <- "));return a[b]}try{return l.unshift(b),a[b]=k,a[b]=c(b,e),a[b]}catch(f){throw a[b]===k&&delete a[b],f;}finally{l.shift()}}function e(a,c,f){var g=[];a=eb.$$annotate(a,b,f);for(var h=0,k=a.length;h<k;h++){var l=a[h];if("string"!==typeof l)throw da("itkn",l);g.push(c&&c.hasOwnProperty(l)?c[l]:d(l,f))}return g}return{invoke:function(a,b,c,d){"string"===typeof c&&(d=c,c=null);c=e(a,c,d);C(a)&&(a=a[a.length-1]);d=a;if(La||"function"!==typeof d)d=!1;else{var f=d.$$ngIsClass;
Ia(f)||(f=d.$$ngIsClass=/^(?:class\b|constructor\()/.test(Function.prototype.toString.call(d)+" "));d=f}return d?(c.unshift(null),new (Function.prototype.bind.apply(a,c))):a.apply(b,c)},instantiate:function(a,b,c){var d=C(a)?a[a.length-1]:a;a=e(a,b,c);a.unshift(null);return new (Function.prototype.bind.apply(d,a))},get:d,annotate:eb.$$annotate,has:function(b){return n.hasOwnProperty(b+"Provider")||a.hasOwnProperty(b)}}}b=!0===b;var k={},l=[],m=new Qa([],!0),n={$provide:{provider:d(c),factory:d(e),
service:d(function(a,b){return e(a,["$injector",function(a){return a.instantiate(b)}])}),value:d(function(a,b){return e(a,ma(b),!1)}),constant:d(function(a,b){Pa(a,"constant");n[a]=b;r[a]=b}),decorator:function(a,b){var c=p.get(a+"Provider"),d=c.$get;c.$get=function(){var a=O.invoke(d,c);return O.invoke(b,null,{$delegate:a})}}}},p=n.$injector=h(n,function(a,b){$.isString(b)&&l.push(b);throw da("unpr",l.join(" <- "));}),r={},J=h(r,function(a,b){var c=p.get(a+"Provider",b);return O.invoke(c.$get,c,
void 0,a)}),O=J;n.$injectorProvider={$get:ma(J)};var u=g(a),O=J.get("$injector");O.strictDi=b;q(u,function(a){a&&O.invoke(a)});return O}function hf(){var a=!0;this.disableAutoScrolling=function(){a=!1};this.$get=["$window","$location","$rootScope",function(b,d,c){function f(a){var b=null;Array.prototype.some.call(a,function(a){if("a"===xa(a))return b=a,!0});return b}function e(a){if(a){a.scrollIntoView();var c;c=g.yOffset;y(c)?c=c():Tb(c)?(c=c[0],c="fixed"!==b.getComputedStyle(c).position?0:c.getBoundingClientRect().bottom):
Y(c)||(c=0);c&&(a=a.getBoundingClientRect().top,b.scrollBy(0,a-c))}else b.scrollTo(0,0)}function g(a){a=E(a)?a:Y(a)?a.toString():d.hash();var b;a?(b=h.getElementById(a))?e(b):(b=f(h.getElementsByName(a)))?e(b):"top"===a&&e(null):e(null)}var h=b.document;a&&c.$watch(function(){return d.hash()},function(a,b){a===b&&""===a||ag(function(){c.$evalAsync(g)})});return g}]}function jb(a,b){if(!a&&!b)return"";if(!a)return b;if(!b)return a;C(a)&&(a=a.join(" "));C(b)&&(b=b.join(" "));return a+" "+b}function jg(a){E(a)&&
(a=a.split(" "));var b=W();q(a,function(a){a.length&&(b[a]=!0)});return b}function Aa(a){return F(a)?a:{}}function kg(a,b,d,c){function f(a){try{a.apply(null,wa.call(arguments,1))}finally{if(J--,0===J)for(;O.length;)try{O.pop()()}catch(b){d.error(b)}}}function e(){ia=null;g();h()}function g(){u=A();u=x(u)?null:u;qa(u,B)&&(u=B);B=u}function h(){if(U!==k.url()||H!==u)U=k.url(),H=u,q(K,function(a){a(k.url(),u)})}var k=this,l=a.location,m=a.history,n=a.setTimeout,p=a.clearTimeout,r={};k.isMock=!1;var J=
0,O=[];k.$$completeOutstandingRequest=f;k.$$incOutstandingRequestCount=function(){J++};k.notifyWhenNoOutstandingRequests=function(a){0===J?a():O.push(a)};var u,H,U=l.href,t=b.find("base"),ia=null,A=c.history?function(){try{return m.state}catch(a){}}:w;g();H=u;k.url=function(b,d,e){x(e)&&(e=null);l!==a.location&&(l=a.location);m!==a.history&&(m=a.history);if(b){var f=H===e;if(U===b&&(!c.history||f))return k;var h=U&&Ba(U)===Ba(b);U=b;H=e;!c.history||h&&f?(h||(ia=b),d?l.replace(b):h?(d=l,e=b.indexOf("#"),
e=-1===e?"":b.substr(e),d.hash=e):l.href=b,l.href!==b&&(ia=b)):(m[d?"replaceState":"pushState"](e,"",b),g(),H=u);ia&&(ia=b);return k}return ia||l.href.replace(/%27/g,"'")};k.state=function(){return u};var K=[],I=!1,B=null;k.onUrlChange=function(b){if(!I){if(c.history)D(a).on("popstate",e);D(a).on("hashchange",e);I=!0}K.push(b);return b};k.$$applicationDestroyed=function(){D(a).off("hashchange popstate",e)};k.$$checkUrlChange=h;k.baseHref=function(){var a=t.attr("href");return a?a.replace(/^(https?:)?\/\/[^/]*/,
""):""};k.defer=function(a,b){var c;J++;c=n(function(){delete r[c];f(a)},b||0);r[c]=!0;return c};k.defer.cancel=function(a){return r[a]?(delete r[a],p(a),f(w),!0):!1}}function pf(){this.$get=["$window","$log","$sniffer","$document",function(a,b,d,c){return new kg(a,c,b,d)}]}function qf(){this.$get=function(){function a(a,c){function f(a){a!==n&&(p?p===a&&(p=a.n):p=a,e(a.n,a.p),e(a,n),n=a,n.n=null)}function e(a,b){a!==b&&(a&&(a.p=b),b&&(b.n=a))}if(a in b)throw M("$cacheFactory")("iid",a);var g=0,h=
R({},c,{id:a}),k=W(),l=c&&c.capacity||Number.MAX_VALUE,m=W(),n=null,p=null;return b[a]={put:function(a,b){if(!x(b)){if(l<Number.MAX_VALUE){var c=m[a]||(m[a]={key:a});f(c)}a in k||g++;k[a]=b;g>l&&this.remove(p.key);return b}},get:function(a){if(l<Number.MAX_VALUE){var b=m[a];if(!b)return;f(b)}return k[a]},remove:function(a){if(l<Number.MAX_VALUE){var b=m[a];if(!b)return;b===n&&(n=b.p);b===p&&(p=b.n);e(b.n,b.p);delete m[a]}a in k&&(delete k[a],g--)},removeAll:function(){k=W();g=0;m=W();n=p=null},destroy:function(){m=
h=k=null;delete b[a]},info:function(){return R({},h,{size:g})}}}var b={};a.info=function(){var a={};q(b,function(b,f){a[f]=b.info()});return a};a.get=function(a){return b[a]};return a}}function Nf(){this.$get=["$cacheFactory",function(a){return a("templates")}]}function Qc(a,b){function d(a,b,c){var d=/^\s*([@&<]|=(\*?))(\??)\s*(\w*)\s*$/,e=W();q(a,function(a,f){if(a in n)e[f]=n[a];else{var g=a.match(d);if(!g)throw ea("iscp",b,f,a,c?"controller bindings definition":"isolate scope definition");e[f]=
{mode:g[1][0],collection:"*"===g[2],optional:"?"===g[3],attrName:g[4]||f};g[4]&&(n[a]=e[f])}});return e}function c(a){var b=a.charAt(0);if(!b||b!==P(b))throw ea("baddir",a);if(a!==a.trim())throw ea("baddir",a);}function f(a){var b=a.require||a.controller&&a.name;!C(b)&&F(b)&&q(b,function(a,c){var d=a.match(l);a.substring(d[0].length)||(b[c]=d[0]+c)});return b}var e={},g=/^\s*directive:\s*([\w-]+)\s+(.*)$/,h=/(([\w-]+)(?::([^;]+))?;?)/,k=me("ngSrc,ngSrcset,src,srcset"),l=/^(?:(\^\^?)?(\?)?(\^\^?)?)?/,
m=/^(on[a-z]+|formaction)$/,n=W();this.directive=function U(b,d){fb(b,"name");Pa(b,"directive");E(b)?(c(b),fb(d,"directiveFactory"),e.hasOwnProperty(b)||(e[b]=[],a.factory(b+"Directive",["$injector","$exceptionHandler",function(a,c){var d=[];q(e[b],function(e,g){try{var h=a.invoke(e);y(h)?h={compile:ma(h)}:!h.compile&&h.link&&(h.compile=ma(h.link));h.priority=h.priority||0;h.index=g;h.name=h.name||b;h.require=f(h);var k=h,l=h.restrict;if(l&&(!E(l)||!/[EACM]/.test(l)))throw ea("badrestrict",l,b);k.restrict=
l||"EA";h.$$moduleName=e.$$moduleName;d.push(h)}catch(m){c(m)}});return d}])),e[b].push(d)):q(b,Fc(U));return this};this.component=function(a,b){function c(a){function e(b){return y(b)||C(b)?function(c,d){return a.invoke(b,this,{$element:c,$attrs:d})}:b}var f=b.template||b.templateUrl?b.template:"",g={controller:d,controllerAs:lg(b.controller)||b.controllerAs||"$ctrl",template:e(f),templateUrl:e(b.templateUrl),transclude:b.transclude,scope:{},bindToController:b.bindings||{},restrict:"E",require:b.require};
q(b,function(a,b){"$"===b.charAt(0)&&(g[b]=a)});return g}var d=b.controller||function(){};q(b,function(a,b){"$"===b.charAt(0)&&(c[b]=a,y(d)&&(d[b]=a))});c.$inject=["$injector"];return this.directive(a,c)};this.aHrefSanitizationWhitelist=function(a){return v(a)?(b.aHrefSanitizationWhitelist(a),this):b.aHrefSanitizationWhitelist()};this.imgSrcSanitizationWhitelist=function(a){return v(a)?(b.imgSrcSanitizationWhitelist(a),this):b.imgSrcSanitizationWhitelist()};var p=!0;this.debugInfoEnabled=function(a){return v(a)?
(p=a,this):p};var r=!1;this.preAssignBindingsEnabled=function(a){return v(a)?(r=a,this):r};var J=10;this.onChangesTtl=function(a){return arguments.length?(J=a,this):J};var O=!0;this.commentDirectivesEnabled=function(a){return arguments.length?(O=a,this):O};var u=!0;this.cssClassDirectivesEnabled=function(a){return arguments.length?(u=a,this):u};this.$get=["$injector","$interpolate","$exceptionHandler","$templateRequest","$parse","$controller","$rootScope","$sce","$animate","$$sanitizeUri",function(a,
b,c,f,n,I,B,L,N,G){function T(){try{if(!--za)throw da=void 0,ea("infchng",J);B.$apply(function(){for(var a=[],b=0,c=da.length;b<c;++b)try{da[b]()}catch(d){a.push(d)}da=void 0;if(a.length)throw a;})}finally{za++}}function s(a,b){if(b){var c=Object.keys(b),d,e,f;d=0;for(e=c.length;d<e;d++)f=c[d],this[f]=b[f]}else this.$attr={};this.$$element=a}function Q(a,b,c){ua.innerHTML="<span "+b+">";b=ua.firstChild.attributes;var d=b[0];b.removeNamedItem(d.name);d.value=c;a.attributes.setNamedItem(d)}function Ma(a,
b){try{a.addClass(b)}catch(c){}}function ba(a,b,c,d,e){a instanceof D||(a=D(a));var f=Na(a,b,a,c,d,e);ba.$$addScopeClass(a);var g=null;return function(b,c,d){if(!a)throw ea("multilink");fb(b,"scope");e&&e.needsNewScope&&(b=b.$parent.$new());d=d||{};var h=d.parentBoundTranscludeFn,k=d.transcludeControllers;d=d.futureParentElement;h&&h.$$boundTransclude&&(h=h.$$boundTransclude);g||(g=(d=d&&d[0])?"foreignobject"!==xa(d)&&na.call(d).match(/SVG/)?"svg":"html":"html");d="html"!==g?D(ha(g,D("<div>").append(a).html())):
c?Oa.clone.call(a):a;if(k)for(var l in k)d.data("$"+l+"Controller",k[l].instance);ba.$$addScopeInfo(d,b);c&&c(d,b);f&&f(b,d,d,h);c||(a=f=null);return d}}function Na(a,b,c,d,e,f){function g(a,c,d,e){var f,k,l,m,n,p,r;if(K)for(r=Array(c.length),m=0;m<h.length;m+=3)f=h[m],r[f]=c[f];else r=c;m=0;for(n=h.length;m<n;)k=r[h[m++]],c=h[m++],f=h[m++],c?(c.scope?(l=a.$new(),ba.$$addScopeInfo(D(k),l)):l=a,p=c.transcludeOnThisElement?ja(a,c.transclude,e):!c.templateOnThisElement&&e?e:!e&&b?ja(a,b):null,c(f,l,
k,d,p)):f&&f(a,k.childNodes,void 0,e)}for(var h=[],k=C(a)||a instanceof D,l,m,n,p,K,r=0;r<a.length;r++){l=new s;11===La&&M(a,r,k);m=fc(a[r],[],l,0===r?d:void 0,e);(f=m.length?X(m,a[r],l,b,c,null,[],[],f):null)&&f.scope&&ba.$$addScopeClass(l.$$element);l=f&&f.terminal||!(n=a[r].childNodes)||!n.length?null:Na(n,f?(f.transcludeOnThisElement||!f.templateOnThisElement)&&f.transclude:b);if(f||l)h.push(r,f,l),p=!0,K=K||f;f=null}return p?g:null}function M(a,b,c){var d=a[b],e=d.parentNode,f;if(d.nodeType===
Ja)for(;;){f=e?d.nextSibling:a[b+1];if(!f||f.nodeType!==Ja)break;d.nodeValue+=f.nodeValue;f.parentNode&&f.parentNode.removeChild(f);c&&f===a[b+1]&&a.splice(b+1,1)}}function ja(a,b,c){function d(e,f,g,h,k){e||(e=a.$new(!1,k),e.$$transcluded=!0);return b(e,f,{parentBoundTranscludeFn:c,transcludeControllers:g,futureParentElement:h})}var e=d.$$slots=W(),f;for(f in b.$$slots)e[f]=b.$$slots[f]?ja(a,b.$$slots[f],c):null;return d}function fc(a,b,c,d,e){var f=c.$attr,g;switch(a.nodeType){case 1:g=xa(a);Y(b,
Ca(g),"E",d,e);for(var k,l,m,n,p=a.attributes,K=0,r=p&&p.length;K<r;K++){var A=!1,B=!1;k=p[K];l=k.name;m=k.value;k=Ca(l);(n=Ha.test(k))&&(l=l.replace(gd,"").substr(8).replace(/_(.)/g,function(a,b){return b.toUpperCase()}));(k=k.match(Ka))&&Z(k[1])&&(A=l,B=l.substr(0,l.length-5)+"end",l=l.substr(0,l.length-6));k=Ca(l.toLowerCase());f[k]=l;if(n||!c.hasOwnProperty(k))c[k]=m,dd(a,k)&&(c[k]=!0);ra(a,b,m,k,n);Y(b,k,"A",d,e,A,B)}"input"===g&&"hidden"===a.getAttribute("type")&&a.setAttribute("autocomplete",
"off");if(!Ga)break;f=a.className;F(f)&&(f=f.animVal);if(E(f)&&""!==f)for(;a=h.exec(f);)k=Ca(a[2]),Y(b,k,"C",d,e)&&(c[k]=S(a[3])),f=f.substr(a.index+a[0].length);break;case Ja:ma(b,a.nodeValue);break;case 8:if(!Fa)break;kb(a,b,c,d,e)}b.sort(ka);return b}function kb(a,b,c,d,e){try{var f=g.exec(a.nodeValue);if(f){var h=Ca(f[1]);Y(b,h,"M",d,e)&&(c[h]=S(f[2]))}}catch(k){}}function hd(a,b,c){var d=[],e=0;if(b&&a.hasAttribute&&a.hasAttribute(b)){do{if(!a)throw ea("uterdir",b,c);1===a.nodeType&&(a.hasAttribute(b)&&
e++,a.hasAttribute(c)&&e--);d.push(a);a=a.nextSibling}while(0<e)}else d.push(a);return D(d)}function id(a,b,c){return function(d,e,f,g,h){e=hd(e[0],b,c);return a(d,e,f,g,h)}}function gc(a,b,c,d,e,f){var g;return a?ba(b,c,d,e,f):function(){g||(g=ba(b,c,d,e,f),b=c=f=null);return g.apply(this,arguments)}}function X(a,b,d,e,f,g,h,k,l){function m(a,b,c,d){if(a){c&&(a=id(a,c,d));a.require=t.require;a.directiveName=L;if(B===t||t.$$isolateScope)a=sa(a,{isolateScope:!0});h.push(a)}if(b){c&&(b=id(b,c,d));b.require=
t.require;b.directiveName=L;if(B===t||t.$$isolateScope)b=sa(b,{isolateScope:!0});k.push(b)}}function n(a,e,f,g,l){function m(a,b,c,d){var e;Za(a)||(d=c,c=b,b=a,a=void 0);U&&(e=N);c||(c=U?L.parent():L);if(d){var f=l.$$slots[d];if(f)return f(a,b,e,c,Q);if(x(f))throw ea("noslot",d,ya(L));}else return l(a,b,e,c,Q)}var p,t,u,G,J,N,T,L;b===f?(g=d,L=d.$$element):(L=D(f),g=new s(L,d));J=e;B?G=e.$new(!0):K&&(J=e.$parent);l&&(T=m,T.$$boundTransclude=l,T.isSlotFilled=function(a){return!!l.$$slots[a]});A&&(N=
ca(L,g,T,A,G,e,B));B&&(ba.$$addScopeInfo(L,G,!0,!(I&&(I===B||I===B.$$originalDirective))),ba.$$addScopeClass(L,!0),G.$$isolateBindings=B.$$isolateBindings,t=oa(e,g,G,G.$$isolateBindings,B),t.removeWatches&&G.$on("$destroy",t.removeWatches));for(p in N){t=A[p];u=N[p];var Hb=t.$$bindings.bindToController;if(r){u.bindingInfo=Hb?oa(J,g,u.instance,Hb,t):{};var O=u();O!==u.instance&&(u.instance=O,L.data("$"+t.name+"Controller",O),u.bindingInfo.removeWatches&&u.bindingInfo.removeWatches(),u.bindingInfo=
oa(J,g,u.instance,Hb,t))}else u.instance=u(),L.data("$"+t.name+"Controller",u.instance),u.bindingInfo=oa(J,g,u.instance,Hb,t)}q(A,function(a,b){var c=a.require;a.bindToController&&!C(c)&&F(c)&&R(N[b].instance,V(b,c,L,N))});q(N,function(a){var b=a.instance;if(y(b.$onChanges))try{b.$onChanges(a.bindingInfo.initialChanges)}catch(d){c(d)}if(y(b.$onInit))try{b.$onInit()}catch(e){c(e)}y(b.$doCheck)&&(J.$watch(function(){b.$doCheck()}),b.$doCheck());y(b.$onDestroy)&&J.$on("$destroy",function(){b.$onDestroy()})});
p=0;for(t=h.length;p<t;p++)u=h[p],ta(u,u.isolateScope?G:e,L,g,u.require&&V(u.directiveName,u.require,L,N),T);var Q=e;B&&(B.template||null===B.templateUrl)&&(Q=G);a&&a(Q,f.childNodes,void 0,l);for(p=k.length-1;0<=p;p--)u=k[p],ta(u,u.isolateScope?G:e,L,g,u.require&&V(u.directiveName,u.require,L,N),T);q(N,function(a){a=a.instance;y(a.$postLink)&&a.$postLink()})}l=l||{};for(var p=-Number.MAX_VALUE,K=l.newScopeDirective,A=l.controllerDirectives,B=l.newIsolateScopeDirective,I=l.templateDirective,u=l.nonTlbTranscludeDirective,
J=!1,N=!1,U=l.hasElementTranscludeDirective,G=d.$$element=D(b),t,L,T,O=e,Q,v=!1,Ma=!1,w,z=0,E=a.length;z<E;z++){t=a[z];var Na=t.$$start,M=t.$$end;Na&&(G=hd(b,Na,M));T=void 0;if(p>t.priority)break;if(w=t.scope)t.templateUrl||(F(w)?($("new/isolated scope",B||K,t,G),B=t):$("new/isolated scope",B,t,G)),K=K||t;L=t.name;if(!v&&(t.replace&&(t.templateUrl||t.template)||t.transclude&&!t.$$tlb)){for(w=z+1;v=a[w++];)if(v.transclude&&!v.$$tlb||v.replace&&(v.templateUrl||v.template)){Ma=!0;break}v=!0}!t.templateUrl&&
t.controller&&(A=A||W(),$("'"+L+"' controller",A[L],t,G),A[L]=t);if(w=t.transclude)if(J=!0,t.$$tlb||($("transclusion",u,t,G),u=t),"element"===w)U=!0,p=t.priority,T=G,G=d.$$element=D(ba.$$createComment(L,d[L])),b=G[0],la(f,wa.call(T,0),b),T[0].$$parentNode=T[0].parentNode,O=gc(Ma,T,e,p,g&&g.name,{nonTlbTranscludeDirective:u});else{var ja=W();if(F(w)){T=[];var P=W(),kb=W();q(w,function(a,b){var c="?"===a.charAt(0);a=c?a.substring(1):a;P[a]=b;ja[b]=null;kb[b]=c});q(G.contents(),function(a){var b=P[Ca(xa(a))];
b?(kb[b]=!0,ja[b]=ja[b]||[],ja[b].push(a)):T.push(a)});q(kb,function(a,b){if(!a)throw ea("reqslot",b);});for(var ec in ja)ja[ec]&&(ja[ec]=gc(Ma,ja[ec],e))}else T=D(cc(b)).contents();G.empty();O=gc(Ma,T,e,void 0,void 0,{needsNewScope:t.$$isolateScope||t.$$newScope});O.$$slots=ja}if(t.template)if(N=!0,$("template",I,t,G),I=t,w=y(t.template)?t.template(G,d):t.template,w=Ea(w),t.replace){g=t;T=$b.test(w)?jd(ha(t.templateNamespace,S(w))):[];b=T[0];if(1!==T.length||1!==b.nodeType)throw ea("tplrt",L,"");
la(f,G,b);E={$attr:{}};w=fc(b,[],E);var Y=a.splice(z+1,a.length-(z+1));(B||K)&&aa(w,B,K);a=a.concat(w).concat(Y);fa(d,E);E=a.length}else G.html(w);if(t.templateUrl)N=!0,$("template",I,t,G),I=t,t.replace&&(g=t),n=ga(a.splice(z,a.length-z),G,d,f,J&&O,h,k,{controllerDirectives:A,newScopeDirective:K!==t&&K,newIsolateScopeDirective:B,templateDirective:I,nonTlbTranscludeDirective:u}),E=a.length;else if(t.compile)try{Q=t.compile(G,d,O);var Z=t.$$originalDirective||t;y(Q)?m(null,bb(Z,Q),Na,M):Q&&m(bb(Z,Q.pre),
bb(Z,Q.post),Na,M)}catch(da){c(da,ya(G))}t.terminal&&(n.terminal=!0,p=Math.max(p,t.priority))}n.scope=K&&!0===K.scope;n.transcludeOnThisElement=J;n.templateOnThisElement=N;n.transclude=O;l.hasElementTranscludeDirective=U;return n}function V(a,b,c,d){var e;if(E(b)){var f=b.match(l);b=b.substring(f[0].length);var g=f[1]||f[3],f="?"===f[2];"^^"===g?c=c.parent():e=(e=d&&d[b])&&e.instance;if(!e){var h="$"+b+"Controller";e=g?c.inheritedData(h):c.data(h)}if(!e&&!f)throw ea("ctreq",b,a);}else if(C(b))for(e=
[],g=0,f=b.length;g<f;g++)e[g]=V(a,b[g],c,d);else F(b)&&(e={},q(b,function(b,f){e[f]=V(a,b,c,d)}));return e||null}function ca(a,b,c,d,e,f,g){var h=W(),k;for(k in d){var l=d[k],m={$scope:l===g||l.$$isolateScope?e:f,$element:a,$attrs:b,$transclude:c},n=l.controller;"@"===n&&(n=b[l.name]);m=I(n,m,!0,l.controllerAs);h[l.name]=m;a.data("$"+l.name+"Controller",m.instance)}return h}function aa(a,b,c){for(var d=0,e=a.length;d<e;d++)a[d]=Ub(a[d],{$$isolateScope:b,$$newScope:c})}function Y(b,c,f,g,h,k,l){if(c===
h)return null;var m=null;if(e.hasOwnProperty(c)){h=a.get(c+"Directive");for(var n=0,p=h.length;n<p;n++)if(c=h[n],(x(g)||g>c.priority)&&-1!==c.restrict.indexOf(f)){k&&(c=Ub(c,{$$start:k,$$end:l}));if(!c.$$bindings){var K=m=c,r=c.name,A={isolateScope:null,bindToController:null};F(K.scope)&&(!0===K.bindToController?(A.bindToController=d(K.scope,r,!0),A.isolateScope={}):A.isolateScope=d(K.scope,r,!1));F(K.bindToController)&&(A.bindToController=d(K.bindToController,r,!0));if(A.bindToController&&!K.controller)throw ea("noctrl",
r);m=m.$$bindings=A;F(m.isolateScope)&&(c.$$isolateBindings=m.isolateScope)}b.push(c);m=c}}return m}function Z(b){if(e.hasOwnProperty(b))for(var c=a.get(b+"Directive"),d=0,f=c.length;d<f;d++)if(b=c[d],b.multiElement)return!0;return!1}function fa(a,b){var c=b.$attr,d=a.$attr;q(a,function(d,e){"$"!==e.charAt(0)&&(b[e]&&b[e]!==d&&(d=d.length?d+(("style"===e?";":" ")+b[e]):b[e]),a.$set(e,d,!0,c[e]))});q(b,function(b,e){a.hasOwnProperty(e)||"$"===e.charAt(0)||(a[e]=b,"class"!==e&&"style"!==e&&(d[e]=c[e]))})}
function ga(a,b,d,e,g,h,k,l){var m=[],n,p,K=b[0],r=a.shift(),u=Ub(r,{templateUrl:null,transclude:null,replace:null,$$originalDirective:r}),t=y(r.templateUrl)?r.templateUrl(b,d):r.templateUrl,B=r.templateNamespace;b.empty();f(t).then(function(c){var f,A;c=Ea(c);if(r.replace){c=$b.test(c)?jd(ha(B,S(c))):[];f=c[0];if(1!==c.length||1!==f.nodeType)throw ea("tplrt",r.name,t);c={$attr:{}};la(e,b,f);var I=fc(f,[],c);F(r.scope)&&aa(I,!0);a=I.concat(a);fa(d,c)}else f=K,b.html(c);a.unshift(u);n=X(a,f,d,g,b,
r,h,k,l);q(e,function(a,c){a===f&&(e[c]=b[0])});for(p=Na(b[0].childNodes,g);m.length;){c=m.shift();A=m.shift();var G=m.shift(),J=m.shift(),I=b[0];if(!c.$$destroyed){if(A!==K){var N=A.className;l.hasElementTranscludeDirective&&r.replace||(I=cc(f));la(G,D(A),I);Ma(D(I),N)}A=n.transcludeOnThisElement?ja(c,n.transclude,J):J;n(p,c,I,e,A)}}m=null}).catch(function(a){a instanceof Error&&c(a)}).catch(w);return function(a,b,c,d,e){a=e;b.$$destroyed||(m?m.push(b,c,d,a):(n.transcludeOnThisElement&&(a=ja(b,n.transclude,
e)),n(p,b,c,d,a)))}}function ka(a,b){var c=b.priority-a.priority;return 0!==c?c:a.name!==b.name?a.name<b.name?-1:1:a.index-b.index}function $(a,b,c,d){function e(a){return a?" (module: "+a+")":""}if(b)throw ea("multidir",b.name,e(b.$$moduleName),c.name,e(c.$$moduleName),a,ya(d));}function ma(a,c){var d=b(c,!0);d&&a.push({priority:0,compile:function(a){a=a.parent();var b=!!a.length;b&&ba.$$addBindingClass(a);return function(a,c){var e=c.parent();b||ba.$$addBindingClass(e);ba.$$addBindingInfo(e,d.expressions);
a.$watch(d,function(a){c[0].nodeValue=a})}}})}function ha(a,b){a=P(a||"html");switch(a){case "svg":case "math":var c=z.document.createElement("div");c.innerHTML="<"+a+">"+b+"</"+a+">";return c.childNodes[0].childNodes;default:return b}}function pa(a,b){if("srcdoc"===b)return L.HTML;var c=xa(a);if("src"===b||"ngSrc"===b){if(-1===["img","video","audio","source","track"].indexOf(c))return L.RESOURCE_URL}else if("xlinkHref"===b||"form"===c&&"action"===b||"link"===c&&"href"===b)return L.RESOURCE_URL}function ra(a,
c,d,e,f){var g=pa(a,e),h=k[e]||f,l=b(d,!f,g,h);if(l){if("multiple"===e&&"select"===xa(a))throw ea("selmulti",ya(a));if(m.test(e))throw ea("nodomevents");c.push({priority:100,compile:function(){return{pre:function(a,c,f){c=f.$$observers||(f.$$observers=W());var k=f[e];k!==d&&(l=k&&b(k,!0,g,h),d=k);l&&(f[e]=l(a),(c[e]||(c[e]=[])).$$inter=!0,(f.$$observers&&f.$$observers[e].$$scope||a).$watch(l,function(a,b){"class"===e&&a!==b?f.$updateClass(a,b):f.$set(e,a)}))}}}})}}function la(a,b,c){var d=b[0],e=
b.length,f=d.parentNode,g,h;if(a)for(g=0,h=a.length;g<h;g++)if(a[g]===d){a[g++]=c;h=g+e-1;for(var k=a.length;g<k;g++,h++)h<k?a[g]=a[h]:delete a[g];a.length-=e-1;a.context===d&&(a.context=c);break}f&&f.replaceChild(c,d);a=z.document.createDocumentFragment();for(g=0;g<e;g++)a.appendChild(b[g]);D.hasData(d)&&(D.data(c,D.data(d)),D(d).off("$destroy"));D.cleanData(a.querySelectorAll("*"));for(g=1;g<e;g++)delete b[g];b[0]=c;b.length=1}function sa(a,b){return R(function(){return a.apply(null,arguments)},
a,b)}function ta(a,b,d,e,f,g){try{a(b,d,e,f,g)}catch(h){c(h,ya(d))}}function oa(a,c,d,e,f){function g(b,c,e){!y(d.$onChanges)||c===e||c!==c&&e!==e||(da||(a.$$postDigest(T),da=[]),m||(m={},da.push(h)),m[b]&&(e=m[b].previousValue),m[b]=new Ib(e,c))}function h(){d.$onChanges(m);m=void 0}var k=[],l={},m;q(e,function(e,h){var m=e.attrName,p=e.optional,r,A,u,B;switch(e.mode){case "@":p||va.call(c,m)||(d[h]=c[m]=void 0);p=c.$observe(m,function(a){if(E(a)||Ia(a))g(h,a,d[h]),d[h]=a});c.$$observers[m].$$scope=
a;r=c[m];E(r)?d[h]=b(r)(a):Ia(r)&&(d[h]=r);l[h]=new Ib(hc,d[h]);k.push(p);break;case "=":if(!va.call(c,m)){if(p)break;c[m]=void 0}if(p&&!c[m])break;A=n(c[m]);B=A.literal?qa:function(a,b){return a===b||a!==a&&b!==b};u=A.assign||function(){r=d[h]=A(a);throw ea("nonassign",c[m],m,f.name);};r=d[h]=A(a);p=function(b){B(b,d[h])||(B(b,r)?u(a,b=d[h]):d[h]=b);return r=b};p.$stateful=!0;p=e.collection?a.$watchCollection(c[m],p):a.$watch(n(c[m],p),null,A.literal);k.push(p);break;case "<":if(!va.call(c,m)){if(p)break;
c[m]=void 0}if(p&&!c[m])break;A=n(c[m]);var I=A.literal,G=d[h]=A(a);l[h]=new Ib(hc,d[h]);p=a.$watch(A,function(a,b){if(b===a){if(b===G||I&&qa(b,G))return;b=G}g(h,a,b);d[h]=a},I);k.push(p);break;case "&":A=c.hasOwnProperty(m)?n(c[m]):w;if(A===w&&p)break;d[h]=function(b){return A(a,b)}}});return{initialChanges:l,removeWatches:k.length&&function(){for(var a=0,b=k.length;a<b;++a)k[a]()}}}var Da=/^\w/,ua=z.document.createElement("div"),Fa=O,Ga=u,za=J,da;s.prototype={$normalize:Ca,$addClass:function(a){a&&
0<a.length&&N.addClass(this.$$element,a)},$removeClass:function(a){a&&0<a.length&&N.removeClass(this.$$element,a)},$updateClass:function(a,b){var c=kd(a,b);c&&c.length&&N.addClass(this.$$element,c);(c=kd(b,a))&&c.length&&N.removeClass(this.$$element,c)},$set:function(a,b,d,e){var f=dd(this.$$element[0],a),g=ld[a],h=a;f?(this.$$element.prop(a,b),e=f):g&&(this[g]=b,h=g);this[a]=b;e?this.$attr[a]=e:(e=this.$attr[a])||(this.$attr[a]=e=Nc(a,"-"));f=xa(this.$$element);if("a"===f&&("href"===a||"xlinkHref"===
a)||"img"===f&&"src"===a)this[a]=b=G(b,"src"===a);else if("img"===f&&"srcset"===a&&v(b)){for(var f="",g=S(b),k=/(\s+\d+x\s*,|\s+\d+w\s*,|\s+,|,\s+)/,k=/\s/.test(g)?k:/(,)/,g=g.split(k),k=Math.floor(g.length/2),l=0;l<k;l++)var m=2*l,f=f+G(S(g[m]),!0),f=f+(" "+S(g[m+1]));g=S(g[2*l]).split(/\s/);f+=G(S(g[0]),!0);2===g.length&&(f+=" "+S(g[1]));this[a]=b=f}!1!==d&&(null===b||x(b)?this.$$element.removeAttr(e):Da.test(e)?this.$$element.attr(e,b):Q(this.$$element[0],e,b));(a=this.$$observers)&&q(a[h],function(a){try{a(b)}catch(d){c(d)}})},
$observe:function(a,b){var c=this,d=c.$$observers||(c.$$observers=W()),e=d[a]||(d[a]=[]);e.push(b);B.$evalAsync(function(){e.$$inter||!c.hasOwnProperty(a)||x(c[a])||b(c[a])});return function(){$a(e,b)}}};var Aa=b.startSymbol(),Ba=b.endSymbol(),Ea="{{"===Aa&&"}}"===Ba?Ya:function(a){return a.replace(/\{\{/g,Aa).replace(/}}/g,Ba)},Ha=/^ngAttr[A-Z]/,Ka=/^(.+)Start$/;ba.$$addBindingInfo=p?function(a,b){var c=a.data("$binding")||[];C(b)?c=c.concat(b):c.push(b);a.data("$binding",c)}:w;ba.$$addBindingClass=
p?function(a){Ma(a,"ng-binding")}:w;ba.$$addScopeInfo=p?function(a,b,c,d){a.data(c?d?"$isolateScopeNoTemplate":"$isolateScope":"$scope",b)}:w;ba.$$addScopeClass=p?function(a,b){Ma(a,b?"ng-isolate-scope":"ng-scope")}:w;ba.$$createComment=function(a,b){var c="";p&&(c=" "+(a||"")+": ",b&&(c+=b+" "));return z.document.createComment(c)};return ba}]}function Ib(a,b){this.previousValue=a;this.currentValue=b}function Ca(a){return a.replace(gd,"").replace(mg,gb)}function kd(a,b){var d="",c=a.split(/\s+/),
f=b.split(/\s+/),e=0;a:for(;e<c.length;e++){for(var g=c[e],h=0;h<f.length;h++)if(g===f[h])continue a;d+=(0<d.length?" ":"")+g}return d}function jd(a){a=D(a);var b=a.length;if(1>=b)return a;for(;b--;){var d=a[b];(8===d.nodeType||d.nodeType===Ja&&""===d.nodeValue.trim())&&ng.call(a,b,1)}return a}function lg(a,b){if(b&&E(b))return b;if(E(a)){var d=md.exec(a);if(d)return d[3]}}function rf(){var a={},b=!1;this.has=function(b){return a.hasOwnProperty(b)};this.register=function(b,c){Pa(b,"controller");F(b)?
R(a,b):a[b]=c};this.allowGlobals=function(){b=!0};this.$get=["$injector","$window",function(d,c){function f(a,b,c,d){if(!a||!F(a.$scope))throw M("$controller")("noscp",d,b);a.$scope[b]=c}return function(e,g,h,k){var l,m,n;h=!0===h;k&&E(k)&&(n=k);if(E(e)){k=e.match(md);if(!k)throw nd("ctrlfmt",e);m=k[1];n=n||k[3];e=a.hasOwnProperty(m)?a[m]:Pc(g.$scope,m,!0)||(b?Pc(c,m,!0):void 0);if(!e)throw nd("ctrlreg",m);tb(e,m,!0)}if(h)return h=(C(e)?e[e.length-1]:e).prototype,l=Object.create(h||null),n&&f(g,n,
l,m||e.name),R(function(){var a=d.invoke(e,l,g,m);a!==l&&(F(a)||y(a))&&(l=a,n&&f(g,n,l,m||e.name));return l},{instance:l,identifier:n});l=d.instantiate(e,g,m);n&&f(g,n,l,m||e.name);return l}}]}function sf(){this.$get=["$window",function(a){return D(a.document)}]}function tf(){this.$get=["$document","$rootScope",function(a,b){function d(){f=c.hidden}var c=a[0],f=c&&c.hidden;a.on("visibilitychange",d);b.$on("$destroy",function(){a.off("visibilitychange",d)});return function(){return f}}]}function uf(){this.$get=
["$log",function(a){return function(b,d){a.error.apply(a,arguments)}}]}function ic(a){return F(a)?fa(a)?a.toISOString():cb(a):a}function zf(){this.$get=function(){return function(a){if(!a)return"";var b=[];Ec(a,function(a,c){null===a||x(a)||(C(a)?q(a,function(a){b.push(ka(c)+"="+ka(ic(a)))}):b.push(ka(c)+"="+ka(ic(a))))});return b.join("&")}}}function Af(){this.$get=function(){return function(a){function b(a,f,e){null===a||x(a)||(C(a)?q(a,function(a,c){b(a,f+"["+(F(a)?c:"")+"]")}):F(a)&&!fa(a)?Ec(a,
function(a,c){b(a,f+(e?"":"[")+c+(e?"":"]"))}):d.push(ka(f)+"="+ka(ic(a))))}if(!a)return"";var d=[];b(a,"",!0);return d.join("&")}}}function jc(a,b){if(E(a)){var d=a.replace(og,"").trim();if(d){var c=b("Content-Type");(c=c&&0===c.indexOf(od))||(c=(c=d.match(pg))&&qg[c[0]].test(d));c&&(a=Ic(d))}}return a}function pd(a){var b=W(),d;E(a)?q(a.split("\n"),function(a){d=a.indexOf(":");var f=P(S(a.substr(0,d)));a=S(a.substr(d+1));f&&(b[f]=b[f]?b[f]+", "+a:a)}):F(a)&&q(a,function(a,d){var e=P(d),g=S(a);e&&
(b[e]=b[e]?b[e]+", "+g:g)});return b}function qd(a){var b;return function(d){b||(b=pd(a));return d?(d=b[P(d)],void 0===d&&(d=null),d):b}}function rd(a,b,d,c){if(y(c))return c(a,b,d);q(c,function(c){a=c(a,b,d)});return a}function yf(){var a=this.defaults={transformResponse:[jc],transformRequest:[function(a){return F(a)&&"[object File]"!==na.call(a)&&"[object Blob]"!==na.call(a)&&"[object FormData]"!==na.call(a)?cb(a):a}],headers:{common:{Accept:"application/json, text/plain, */*"},post:ra(kc),put:ra(kc),
patch:ra(kc)},xsrfCookieName:"XSRF-TOKEN",xsrfHeaderName:"X-XSRF-TOKEN",paramSerializer:"$httpParamSerializer",jsonpCallbackParam:"callback"},b=!1;this.useApplyAsync=function(a){return v(a)?(b=!!a,this):b};var d=this.interceptors=[];this.$get=["$browser","$httpBackend","$$cookieReader","$cacheFactory","$rootScope","$q","$injector","$sce",function(c,f,e,g,h,k,l,m){function n(b){function d(a,b){for(var c=0,e=b.length;c<e;){var f=b[c++],g=b[c++];a=a.then(f,g)}b.length=0;return a}function e(a,b){var c,
d={};q(a,function(a,e){y(a)?(c=a(b),null!=c&&(d[e]=c)):d[e]=a});return d}function f(a){var b=R({},a);b.data=rd(a.data,a.headers,a.status,g.transformResponse);a=a.status;return 200<=a&&300>a?b:k.reject(b)}if(!F(b))throw M("$http")("badreq",b);if(!E(m.valueOf(b.url)))throw M("$http")("badreq",b.url);var g=R({method:"get",transformRequest:a.transformRequest,transformResponse:a.transformResponse,paramSerializer:a.paramSerializer,jsonpCallbackParam:a.jsonpCallbackParam},b);g.headers=function(b){var c=
a.headers,d=R({},b.headers),f,g,h,c=R({},c.common,c[P(b.method)]);a:for(f in c){g=P(f);for(h in d)if(P(h)===g)continue a;d[f]=c[f]}return e(d,ra(b))}(b);g.method=vb(g.method);g.paramSerializer=E(g.paramSerializer)?l.get(g.paramSerializer):g.paramSerializer;c.$$incOutstandingRequestCount();var h=[],n=[];b=k.resolve(g);q(u,function(a){(a.request||a.requestError)&&h.unshift(a.request,a.requestError);(a.response||a.responseError)&&n.push(a.response,a.responseError)});b=d(b,h);b=b.then(function(b){var c=
b.headers,d=rd(b.data,qd(c),void 0,b.transformRequest);x(d)&&q(c,function(a,b){"content-type"===P(b)&&delete c[b]});x(b.withCredentials)&&!x(a.withCredentials)&&(b.withCredentials=a.withCredentials);return p(b,d).then(f,f)});b=d(b,n);return b=b.finally(function(){c.$$completeOutstandingRequest(w)})}function p(c,d){function g(a){if(a){var c={};q(a,function(a,d){c[d]=function(c){function d(){a(c)}b?h.$applyAsync(d):h.$$phase?d():h.$apply(d)}});return c}}function l(a,c,d,e){function f(){p(c,a,d,e)}N&&
(200<=a&&300>a?N.put(Q,[a,c,pd(d),e]):N.remove(Q));b?h.$applyAsync(f):(f(),h.$$phase||h.$apply())}function p(a,b,d,e){b=-1<=b?b:0;(200<=b&&300>b?B.resolve:B.reject)({data:a,status:b,headers:qd(d),config:c,statusText:e})}function K(a){p(a.data,a.status,ra(a.headers()),a.statusText)}function u(){var a=n.pendingRequests.indexOf(c);-1!==a&&n.pendingRequests.splice(a,1)}var B=k.defer(),L=B.promise,N,G,T=c.headers,s="jsonp"===P(c.method),Q=c.url;s?Q=m.getTrustedResourceUrl(Q):E(Q)||(Q=m.valueOf(Q));Q=r(Q,
c.paramSerializer(c.params));s&&(Q=J(Q,c.jsonpCallbackParam));n.pendingRequests.push(c);L.then(u,u);!c.cache&&!a.cache||!1===c.cache||"GET"!==c.method&&"JSONP"!==c.method||(N=F(c.cache)?c.cache:F(a.cache)?a.cache:O);N&&(G=N.get(Q),v(G)?G&&y(G.then)?G.then(K,K):C(G)?p(G[1],G[0],ra(G[2]),G[3]):p(G,200,{},"OK"):N.put(Q,L));x(G)&&((G=sd(c.url)?e()[c.xsrfCookieName||a.xsrfCookieName]:void 0)&&(T[c.xsrfHeaderName||a.xsrfHeaderName]=G),f(c.method,Q,d,l,T,c.timeout,c.withCredentials,c.responseType,g(c.eventHandlers),
g(c.uploadEventHandlers)));return L}function r(a,b){0<b.length&&(a+=(-1===a.indexOf("?")?"?":"&")+b);return a}function J(a,b){if(/[&?][^=]+=JSON_CALLBACK/.test(a))throw td("badjsonp",a);if((new RegExp("[&?]"+b+"=")).test(a))throw td("badjsonp",b,a);return a+=(-1===a.indexOf("?")?"?":"&")+b+"=JSON_CALLBACK"}var O=g("$http");a.paramSerializer=E(a.paramSerializer)?l.get(a.paramSerializer):a.paramSerializer;var u=[];q(d,function(a){u.unshift(E(a)?l.get(a):l.invoke(a))});n.pendingRequests=[];(function(a){q(arguments,
function(a){n[a]=function(b,c){return n(R({},c||{},{method:a,url:b}))}})})("get","delete","head","jsonp");(function(a){q(arguments,function(a){n[a]=function(b,c,d){return n(R({},d||{},{method:a,url:b,data:c}))}})})("post","put","patch");n.defaults=a;return n}]}function Cf(){this.$get=function(){return function(){return new z.XMLHttpRequest}}}function Bf(){this.$get=["$browser","$jsonpCallbacks","$document","$xhrFactory",function(a,b,d,c){return rg(a,c,a.defer,b,d[0])}]}function rg(a,b,d,c,f){function e(a,
b,d){a=a.replace("JSON_CALLBACK",b);var e=f.createElement("script"),m=null;e.type="text/javascript";e.src=a;e.async=!0;m=function(a){e.removeEventListener("load",m);e.removeEventListener("error",m);f.body.removeChild(e);e=null;var g=-1,r="unknown";a&&("load"!==a.type||c.wasCalled(b)||(a={type:"error"}),r=a.type,g="error"===a.type?404:200);d&&d(g,r)};e.addEventListener("load",m);e.addEventListener("error",m);f.body.appendChild(e);return m}return function(f,h,k,l,m,n,p,r,J,O){function u(){U&&U();t&&
t.abort()}h=h||a.url();if("jsonp"===P(f))var H=c.createCallback(h),U=e(h,H,function(a,b){var e=200===a&&c.getResponse(H);v(A)&&d.cancel(A);U=t=null;l(a,e,"",b);c.removeCallback(H)});else{var t=b(f,h);t.open(f,h,!0);q(m,function(a,b){v(a)&&t.setRequestHeader(b,a)});t.onload=function(){var a=t.statusText||"",b="response"in t?t.response:t.responseText,c=1223===t.status?204:t.status;0===c&&(c=b?200:"file"===Da(h).protocol?404:0);var e=t.getAllResponseHeaders();v(A)&&d.cancel(A);U=t=null;l(c,b,e,a)};f=
function(){v(A)&&d.cancel(A);U=t=null;l(-1,null,null,"")};t.onerror=f;t.onabort=f;t.ontimeout=f;q(J,function(a,b){t.addEventListener(b,a)});q(O,function(a,b){t.upload.addEventListener(b,a)});p&&(t.withCredentials=!0);if(r)try{t.responseType=r}catch(s){if("json"!==r)throw s;}t.send(x(k)?null:k)}if(0<n)var A=d(u,n);else n&&y(n.then)&&n.then(u)}}function wf(){var a="{{",b="}}";this.startSymbol=function(b){return b?(a=b,this):a};this.endSymbol=function(a){return a?(b=a,this):b};this.$get=["$parse","$exceptionHandler",
"$sce",function(d,c,f){function e(a){return"\\\\\\"+a}function g(c){return c.replace(n,a).replace(p,b)}function h(a,b,c,d){var e=a.$watch(function(a){e();return d(a)},b,c);return e}function k(e,k,n,p){function H(a){try{var b=a;a=n?f.getTrusted(n,b):f.valueOf(b);return p&&!v(a)?a:Yb(a)}catch(d){c(Ea.interr(e,d))}}if(!e.length||-1===e.indexOf(a)){var q;k||(k=g(e),q=ma(k),q.exp=e,q.expressions=[],q.$$watchDelegate=h);return q}p=!!p;var t,s,A=0,K=[],I=[];q=e.length;for(var B=[],L=[];A<q;)if(-1!==(t=e.indexOf(a,
A))&&-1!==(s=e.indexOf(b,t+l)))A!==t&&B.push(g(e.substring(A,t))),A=e.substring(t+l,s),K.push(A),I.push(d(A,H)),A=s+m,L.push(B.length),B.push("");else{A!==q&&B.push(g(e.substring(A)));break}n&&1<B.length&&Ea.throwNoconcat(e);if(!k||K.length){var N=function(a){for(var b=0,c=K.length;b<c;b++){if(p&&x(a[b]))return;B[L[b]]=a[b]}return B.join("")};return R(function(a){var b=0,d=K.length,f=Array(d);try{for(;b<d;b++)f[b]=I[b](a);return N(f)}catch(g){c(Ea.interr(e,g))}},{exp:e,expressions:K,$$watchDelegate:function(a,
b){var c;return a.$watchGroup(I,function(d,e){var f=N(d);y(b)&&b.call(this,f,d!==e?c:f,a);c=f})}})}}var l=a.length,m=b.length,n=new RegExp(a.replace(/./g,e),"g"),p=new RegExp(b.replace(/./g,e),"g");k.startSymbol=function(){return a};k.endSymbol=function(){return b};return k}]}function xf(){this.$get=["$rootScope","$window","$q","$$q","$browser",function(a,b,d,c,f){function e(e,k,l,m){function n(){p?e.apply(null,r):e(u)}var p=4<arguments.length,r=p?wa.call(arguments,4):[],J=b.setInterval,q=b.clearInterval,
u=0,H=v(m)&&!m,U=(H?c:d).defer(),t=U.promise;l=v(l)?l:0;t.$$intervalId=J(function(){H?f.defer(n):a.$evalAsync(n);U.notify(u++);0<l&&u>=l&&(U.resolve(u),q(t.$$intervalId),delete g[t.$$intervalId]);H||a.$apply()},k);g[t.$$intervalId]=U;return t}var g={};e.cancel=function(a){return a&&a.$$intervalId in g?(g[a.$$intervalId].promise.catch(w),g[a.$$intervalId].reject("canceled"),b.clearInterval(a.$$intervalId),delete g[a.$$intervalId],!0):!1};return e}]}function lc(a){a=a.split("/");for(var b=a.length;b--;)a[b]=
db(a[b]);return a.join("/")}function ud(a,b){var d=Da(a);b.$$protocol=d.protocol;b.$$host=d.hostname;b.$$port=Z(d.port)||sg[d.protocol]||null}function vd(a,b){if(tg.test(a))throw lb("badpath",a);var d="/"!==a.charAt(0);d&&(a="/"+a);var c=Da(a);b.$$path=decodeURIComponent(d&&"/"===c.pathname.charAt(0)?c.pathname.substring(1):c.pathname);b.$$search=Lc(c.search);b.$$hash=decodeURIComponent(c.hash);b.$$path&&"/"!==b.$$path.charAt(0)&&(b.$$path="/"+b.$$path)}function mc(a,b){return a.slice(0,b.length)===
b}function sa(a,b){if(mc(b,a))return b.substr(a.length)}function Ba(a){var b=a.indexOf("#");return-1===b?a:a.substr(0,b)}function mb(a){return a.replace(/(#.+)|#$/,"$1")}function nc(a,b,d){this.$$html5=!0;d=d||"";ud(a,this);this.$$parse=function(a){var d=sa(b,a);if(!E(d))throw lb("ipthprfx",a,b);vd(d,this);this.$$path||(this.$$path="/");this.$$compose()};this.$$compose=function(){var a=Xb(this.$$search),d=this.$$hash?"#"+db(this.$$hash):"";this.$$url=lc(this.$$path)+(a?"?"+a:"")+d;this.$$absUrl=b+
this.$$url.substr(1)};this.$$parseLinkUrl=function(c,f){if(f&&"#"===f[0])return this.hash(f.slice(1)),!0;var e,g;v(e=sa(a,c))?(g=e,g=d&&v(e=sa(d,e))?b+(sa("/",e)||e):a+g):v(e=sa(b,c))?g=b+e:b===c+"/"&&(g=b);g&&this.$$parse(g);return!!g}}function oc(a,b,d){ud(a,this);this.$$parse=function(c){var f=sa(a,c)||sa(b,c),e;x(f)||"#"!==f.charAt(0)?this.$$html5?e=f:(e="",x(f)&&(a=c,this.replace())):(e=sa(d,f),x(e)&&(e=f));vd(e,this);c=this.$$path;var f=a,g=/^\/[A-Z]:(\/.*)/;mc(e,f)&&(e=e.replace(f,""));g.exec(e)||
(c=(e=g.exec(c))?e[1]:c);this.$$path=c;this.$$compose()};this.$$compose=function(){var b=Xb(this.$$search),f=this.$$hash?"#"+db(this.$$hash):"";this.$$url=lc(this.$$path)+(b?"?"+b:"")+f;this.$$absUrl=a+(this.$$url?d+this.$$url:"")};this.$$parseLinkUrl=function(b,d){return Ba(a)===Ba(b)?(this.$$parse(b),!0):!1}}function wd(a,b,d){this.$$html5=!0;oc.apply(this,arguments);this.$$parseLinkUrl=function(c,f){if(f&&"#"===f[0])return this.hash(f.slice(1)),!0;var e,g;a===Ba(c)?e=c:(g=sa(b,c))?e=a+d+g:b===
c+"/"&&(e=b);e&&this.$$parse(e);return!!e};this.$$compose=function(){var b=Xb(this.$$search),f=this.$$hash?"#"+db(this.$$hash):"";this.$$url=lc(this.$$path)+(b?"?"+b:"")+f;this.$$absUrl=a+d+this.$$url}}function Jb(a){return function(){return this[a]}}function xd(a,b){return function(d){if(x(d))return this[a];this[a]=b(d);this.$$compose();return this}}function Ef(){var a="!",b={enabled:!1,requireBase:!0,rewriteLinks:!0};this.hashPrefix=function(b){return v(b)?(a=b,this):a};this.html5Mode=function(a){if(Ia(a))return b.enabled=
a,this;if(F(a)){Ia(a.enabled)&&(b.enabled=a.enabled);Ia(a.requireBase)&&(b.requireBase=a.requireBase);if(Ia(a.rewriteLinks)||E(a.rewriteLinks))b.rewriteLinks=a.rewriteLinks;return this}return b};this.$get=["$rootScope","$browser","$sniffer","$rootElement","$window",function(d,c,f,e,g){function h(a,b,d){var e=l.url(),f=l.$$state;try{c.url(a,b,d),l.$$state=c.state()}catch(g){throw l.url(e),l.$$state=f,g;}}function k(a,b){d.$broadcast("$locationChangeSuccess",l.absUrl(),a,l.$$state,b)}var l,m;m=c.baseHref();
var n=c.url(),p;if(b.enabled){if(!m&&b.requireBase)throw lb("nobase");p=n.substring(0,n.indexOf("/",n.indexOf("//")+2))+(m||"/");m=f.history?nc:wd}else p=Ba(n),m=oc;var r=p.substr(0,Ba(p).lastIndexOf("/")+1);l=new m(p,r,"#"+a);l.$$parseLinkUrl(n,n);l.$$state=c.state();var J=/^\s*(javascript|mailto):/i;e.on("click",function(a){var f=b.rewriteLinks;if(f&&!a.ctrlKey&&!a.metaKey&&!a.shiftKey&&2!==a.which&&2!==a.button){for(var h=D(a.target);"a"!==xa(h[0]);)if(h[0]===e[0]||!(h=h.parent())[0])return;if(!E(f)||
!x(h.attr(f))){var f=h.prop("href"),k=h.attr("href")||h.attr("xlink:href");F(f)&&"[object SVGAnimatedString]"===f.toString()&&(f=Da(f.animVal).href);J.test(f)||!f||h.attr("target")||a.isDefaultPrevented()||!l.$$parseLinkUrl(f,k)||(a.preventDefault(),l.absUrl()!==c.url()&&(d.$apply(),g.angular["ff-684208-preventDefault"]=!0))}}});mb(l.absUrl())!==mb(n)&&c.url(l.absUrl(),!0);var q=!0;c.onUrlChange(function(a,b){mc(a,r)?(d.$evalAsync(function(){var c=l.absUrl(),e=l.$$state,f;a=mb(a);l.$$parse(a);l.$$state=
b;f=d.$broadcast("$locationChangeStart",a,c,b,e).defaultPrevented;l.absUrl()===a&&(f?(l.$$parse(c),l.$$state=e,h(c,!1,e)):(q=!1,k(c,e)))}),d.$$phase||d.$digest()):g.location.href=a});d.$watch(function(){var a=mb(c.url()),b=mb(l.absUrl()),e=c.state(),g=l.$$replace,m=a!==b||l.$$html5&&f.history&&e!==l.$$state;if(q||m)q=!1,d.$evalAsync(function(){var b=l.absUrl(),c=d.$broadcast("$locationChangeStart",b,a,l.$$state,e).defaultPrevented;l.absUrl()===b&&(c?(l.$$parse(a),l.$$state=e):(m&&h(b,g,e===l.$$state?
null:l.$$state),k(a,e)))});l.$$replace=!1});return l}]}function Ff(){var a=!0,b=this;this.debugEnabled=function(b){return v(b)?(a=b,this):a};this.$get=["$window",function(d){function c(a){a instanceof Error&&(a.stack?a=a.message&&-1===a.stack.indexOf(a.message)?"Error: "+a.message+"\n"+a.stack:a.stack:a.sourceURL&&(a=a.message+"\n"+a.sourceURL+":"+a.line));return a}function f(a){var b=d.console||{},f=b[a]||b.log||w;a=!1;try{a=!!f.apply}catch(k){}return a?function(){var a=[];q(arguments,function(b){a.push(c(b))});
return f.apply(b,a)}:function(a,b){f(a,null==b?"":b)}}return{log:f("log"),info:f("info"),warn:f("warn"),error:f("error"),debug:function(){var c=f("debug");return function(){a&&c.apply(b,arguments)}}()}}]}function ug(a){return a+""}function vg(a,b){return"undefined"!==typeof a?a:b}function yd(a,b){return"undefined"===typeof a?b:"undefined"===typeof b?a:a+b}function V(a,b){var d,c,f;switch(a.type){case s.Program:d=!0;q(a.body,function(a){V(a.expression,b);d=d&&a.expression.constant});a.constant=d;break;
case s.Literal:a.constant=!0;a.toWatch=[];break;case s.UnaryExpression:V(a.argument,b);a.constant=a.argument.constant;a.toWatch=a.argument.toWatch;break;case s.BinaryExpression:V(a.left,b);V(a.right,b);a.constant=a.left.constant&&a.right.constant;a.toWatch=a.left.toWatch.concat(a.right.toWatch);break;case s.LogicalExpression:V(a.left,b);V(a.right,b);a.constant=a.left.constant&&a.right.constant;a.toWatch=a.constant?[]:[a];break;case s.ConditionalExpression:V(a.test,b);V(a.alternate,b);V(a.consequent,
b);a.constant=a.test.constant&&a.alternate.constant&&a.consequent.constant;a.toWatch=a.constant?[]:[a];break;case s.Identifier:a.constant=!1;a.toWatch=[a];break;case s.MemberExpression:V(a.object,b);a.computed&&V(a.property,b);a.constant=a.object.constant&&(!a.computed||a.property.constant);a.toWatch=[a];break;case s.CallExpression:d=f=a.filter?!b(a.callee.name).$stateful:!1;c=[];q(a.arguments,function(a){V(a,b);d=d&&a.constant;a.constant||c.push.apply(c,a.toWatch)});a.constant=d;a.toWatch=f?c:[a];
break;case s.AssignmentExpression:V(a.left,b);V(a.right,b);a.constant=a.left.constant&&a.right.constant;a.toWatch=[a];break;case s.ArrayExpression:d=!0;c=[];q(a.elements,function(a){V(a,b);d=d&&a.constant;a.constant||c.push.apply(c,a.toWatch)});a.constant=d;a.toWatch=c;break;case s.ObjectExpression:d=!0;c=[];q(a.properties,function(a){V(a.value,b);d=d&&a.value.constant&&!a.computed;a.value.constant||c.push.apply(c,a.value.toWatch)});a.constant=d;a.toWatch=c;break;case s.ThisExpression:a.constant=
!1;a.toWatch=[];break;case s.LocalsExpression:a.constant=!1,a.toWatch=[]}}function zd(a){if(1===a.length){a=a[0].expression;var b=a.toWatch;return 1!==b.length?b:b[0]!==a?b:void 0}}function Ad(a){return a.type===s.Identifier||a.type===s.MemberExpression}function Bd(a){if(1===a.body.length&&Ad(a.body[0].expression))return{type:s.AssignmentExpression,left:a.body[0].expression,right:{type:s.NGValueParameter},operator:"="}}function Cd(a){return 0===a.body.length||1===a.body.length&&(a.body[0].expression.type===
s.Literal||a.body[0].expression.type===s.ArrayExpression||a.body[0].expression.type===s.ObjectExpression)}function Dd(a,b){this.astBuilder=a;this.$filter=b}function Ed(a,b){this.astBuilder=a;this.$filter=b}function pc(a){return y(a.valueOf)?a.valueOf():wg.call(a)}function Gf(){var a=W(),b={"true":!0,"false":!1,"null":null,undefined:void 0},d,c;this.addLiteral=function(a,c){b[a]=c};this.setIdentifierFns=function(a,b){d=a;c=b;return this};this.$get=["$filter",function(f){function e(a,b){return null==
a||null==b?a===b:"object"===typeof a&&(a=pc(a),"object"===typeof a)?!1:a===b||a!==a&&b!==b}function g(a,b,c,d,f){var g=d.inputs,h;if(1===g.length){var k=e,g=g[0];return a.$watch(function(a){var b=g(a);e(b,k)||(h=d(a,void 0,void 0,[b]),k=b&&pc(b));return h},b,c,f)}for(var l=[],m=[],n=0,I=g.length;n<I;n++)l[n]=e,m[n]=null;return a.$watch(function(a){for(var b=!1,c=0,f=g.length;c<f;c++){var k=g[c](a);if(b||(b=!e(k,l[c])))m[c]=k,l[c]=k&&pc(k)}b&&(h=d(a,void 0,void 0,m));return h},b,c,f)}function h(a,
b,c,d,e){function f(a){return d(a)}function h(a,c,d){l=a;y(b)&&b(a,c,d);v(a)&&d.$$postDigest(function(){v(l)&&k()})}var k,l;return k=d.inputs?g(a,h,c,d,e):a.$watch(f,h,c)}function k(a,b,c,d){function e(a){var b=!0;q(a,function(a){v(a)||(b=!1)});return b}var f,g;return f=a.$watch(function(a){return d(a)},function(a,c,d){g=a;y(b)&&b(a,c,d);e(a)&&d.$$postDigest(function(){e(g)&&f()})},c)}function l(a,b,c,d){var e=a.$watch(function(a){e();return d(a)},b,c);return e}function m(a,b){if(!b)return a;var c=
a.$$watchDelegate,d=!1,c=c!==k&&c!==h?function(c,e,f,g){f=d&&g?g[0]:a(c,e,f,g);return b(f,c,e)}:function(c,d,e,f){e=a(c,d,e,f);c=b(e,c,d);return v(e)?c:e},d=!a.inputs;a.$$watchDelegate&&a.$$watchDelegate!==g?(c.$$watchDelegate=a.$$watchDelegate,c.inputs=a.inputs):b.$stateful||(c.$$watchDelegate=g,c.inputs=a.inputs?a.inputs:[a]);return c}var n={csp:za().noUnsafeEval,literals:Fa(b),isIdentifierStart:y(d)&&d,isIdentifierContinue:y(c)&&c};return function(b,c){var d,e,u;switch(typeof b){case "string":return u=
b=b.trim(),d=a[u],d||(":"===b.charAt(0)&&":"===b.charAt(1)&&(e=!0,b=b.substring(2)),d=new qc(n),d=(new rc(d,f,n)).parse(b),d.constant?d.$$watchDelegate=l:e?d.$$watchDelegate=d.literal?k:h:d.inputs&&(d.$$watchDelegate=g),a[u]=d),m(d,c);case "function":return m(b,c);default:return m(w,c)}}}]}function If(){var a=!0;this.$get=["$rootScope","$exceptionHandler",function(b,d){return Fd(function(a){b.$evalAsync(a)},d,a)}];this.errorOnUnhandledRejections=function(b){return v(b)?(a=b,this):a}}function Jf(){var a=
!0;this.$get=["$browser","$exceptionHandler",function(b,d){return Fd(function(a){b.defer(a)},d,a)}];this.errorOnUnhandledRejections=function(b){return v(b)?(a=b,this):a}}function Fd(a,b,d){function c(){return new f}function f(){var a=this.promise=new e;this.resolve=function(b){k(a,b)};this.reject=function(b){m(a,b)};this.notify=function(b){p(a,b)}}function e(){this.$$state={status:0}}function g(){for(;!v&&t.length;){var a=t.shift();if(!a.pur){a.pur=!0;var c=a.value,c="Possibly unhandled rejection: "+
("function"===typeof c?c.toString().replace(/ \{[\s\S]*$/,""):x(c)?"undefined":"string"!==typeof c?we(c):c);a.value instanceof Error?b(a.value,c):b(c)}}}function h(b){!d||b.pending||2!==b.status||b.pur||(0===v&&0===t.length&&a(g),t.push(b));!b.processScheduled&&b.pending&&(b.processScheduled=!0,++v,a(function(){var c,e,f;f=b.pending;b.processScheduled=!1;b.pending=void 0;try{for(var h=0,l=f.length;h<l;++h){b.pur=!0;e=f[h][0];c=f[h][b.status];try{y(c)?k(e,c(b.value)):1===b.status?k(e,b.value):m(e,
b.value)}catch(n){m(e,n)}}}finally{--v,d&&0===v&&a(g)}}))}function k(a,b){a.$$state.status||(b===a?n(a,H("qcycle",b)):l(a,b))}function l(a,b){function c(b){g||(g=!0,l(a,b))}function d(b){g||(g=!0,n(a,b))}function e(b){p(a,b)}var f,g=!1;try{if(F(b)||y(b))f=b.then;y(f)?(a.$$state.status=-1,f.call(b,c,d,e)):(a.$$state.value=b,a.$$state.status=1,h(a.$$state))}catch(k){d(k)}}function m(a,b){a.$$state.status||n(a,b)}function n(a,b){a.$$state.value=b;a.$$state.status=2;h(a.$$state)}function p(c,d){var e=
c.$$state.pending;0>=c.$$state.status&&e&&e.length&&a(function(){for(var a,c,f=0,g=e.length;f<g;f++){c=e[f][0];a=e[f][3];try{p(c,y(a)?a(d):d)}catch(h){b(h)}}})}function r(a){var b=new e;m(b,a);return b}function J(a,b,c){var d=null;try{y(c)&&(d=c())}catch(e){return r(e)}return d&&y(d.then)?d.then(function(){return b(a)},r):b(a)}function s(a,b,c,d){var f=new e;k(f,a);return f.then(b,c,d)}function u(a){if(!y(a))throw H("norslvr",a);var b=new e;a(function(a){k(b,a)},function(a){m(b,a)});return b}var H=
M("$q",TypeError),v=0,t=[];R(e.prototype,{then:function(a,b,c){if(x(a)&&x(b)&&x(c))return this;var d=new e;this.$$state.pending=this.$$state.pending||[];this.$$state.pending.push([d,a,b,c]);0<this.$$state.status&&h(this.$$state);return d},"catch":function(a){return this.then(null,a)},"finally":function(a,b){return this.then(function(b){return J(b,w,a)},function(b){return J(b,r,a)},b)}});var w=s;u.prototype=e.prototype;u.defer=c;u.reject=r;u.when=s;u.resolve=w;u.all=function(a){var b=new e,c=0,d=C(a)?
[]:{};q(a,function(a,e){c++;s(a).then(function(a){d[e]=a;--c||k(b,d)},function(a){m(b,a)})});0===c&&k(b,d);return b};u.race=function(a){var b=c();q(a,function(a){s(a).then(b.resolve,b.reject)});return b.promise};return u}function Sf(){this.$get=["$window","$timeout",function(a,b){var d=a.requestAnimationFrame||a.webkitRequestAnimationFrame,c=a.cancelAnimationFrame||a.webkitCancelAnimationFrame||a.webkitCancelRequestAnimationFrame,f=!!d,e=f?function(a){var b=d(a);return function(){c(b)}}:function(a){var c=
b(a,16.66,!1);return function(){b.cancel(c)}};e.supported=f;return e}]}function Hf(){function a(a){function b(){this.$$watchers=this.$$nextSibling=this.$$childHead=this.$$childTail=null;this.$$listeners={};this.$$listenerCount={};this.$$watchersCount=0;this.$id=++rb;this.$$ChildScope=null}b.prototype=a;return b}var b=10,d=M("$rootScope"),c=null,f=null;this.digestTtl=function(a){arguments.length&&(b=a);return b};this.$get=["$exceptionHandler","$parse","$browser",function(e,g,h){function k(a){a.currentScope.$$destroyed=
!0}function l(a){9===La&&(a.$$childHead&&l(a.$$childHead),a.$$nextSibling&&l(a.$$nextSibling));a.$parent=a.$$nextSibling=a.$$prevSibling=a.$$childHead=a.$$childTail=a.$root=a.$$watchers=null}function m(){this.$id=++rb;this.$$phase=this.$parent=this.$$watchers=this.$$nextSibling=this.$$prevSibling=this.$$childHead=this.$$childTail=null;this.$root=this;this.$$destroyed=!1;this.$$listeners={};this.$$listenerCount={};this.$$watchersCount=0;this.$$isolateBindings=null}function n(a){if(H.$$phase)throw d("inprog",
H.$$phase);H.$$phase=a}function p(a,b){do a.$$watchersCount+=b;while(a=a.$parent)}function r(a,b,c){do a.$$listenerCount[c]-=b,0===a.$$listenerCount[c]&&delete a.$$listenerCount[c];while(a=a.$parent)}function J(){}function s(){for(;ia.length;)try{ia.shift()()}catch(a){e(a)}f=null}function u(){null===f&&(f=h.defer(function(){H.$apply(s)}))}m.prototype={constructor:m,$new:function(b,c){var d;c=c||this;b?(d=new m,d.$root=this.$root):(this.$$ChildScope||(this.$$ChildScope=a(this)),d=new this.$$ChildScope);
d.$parent=c;d.$$prevSibling=c.$$childTail;c.$$childHead?(c.$$childTail.$$nextSibling=d,c.$$childTail=d):c.$$childHead=c.$$childTail=d;(b||c!==this)&&d.$on("$destroy",k);return d},$watch:function(a,b,d,e){var f=g(a);if(f.$$watchDelegate)return f.$$watchDelegate(this,b,d,f,a);var h=this,k=h.$$watchers,l={fn:b,last:J,get:f,exp:e||a,eq:!!d};c=null;y(b)||(l.fn=w);k||(k=h.$$watchers=[],k.$$digestWatchIndex=-1);k.unshift(l);k.$$digestWatchIndex++;p(this,1);return function(){var a=$a(k,l);0<=a&&(p(h,-1),
a<k.$$digestWatchIndex&&k.$$digestWatchIndex--);c=null}},$watchGroup:function(a,b){function c(){h=!1;k?(k=!1,b(e,e,g)):b(e,d,g)}var d=Array(a.length),e=Array(a.length),f=[],g=this,h=!1,k=!0;if(!a.length){var l=!0;g.$evalAsync(function(){l&&b(e,e,g)});return function(){l=!1}}if(1===a.length)return this.$watch(a[0],function(a,c,f){e[0]=a;d[0]=c;b(e,a===c?e:d,f)});q(a,function(a,b){var k=g.$watch(a,function(a,f){e[b]=a;d[b]=f;h||(h=!0,g.$evalAsync(c))});f.push(k)});return function(){for(;f.length;)f.shift()()}},
$watchCollection:function(a,b){function c(a){e=a;var b,d,g,h;if(!x(e)){if(F(e))if(ta(e))for(f!==n&&(f=n,u=f.length=0,l++),a=e.length,u!==a&&(l++,f.length=u=a),b=0;b<a;b++)h=f[b],g=e[b],d=h!==h&&g!==g,d||h===g||(l++,f[b]=g);else{f!==p&&(f=p={},u=0,l++);a=0;for(b in e)va.call(e,b)&&(a++,g=e[b],h=f[b],b in f?(d=h!==h&&g!==g,d||h===g||(l++,f[b]=g)):(u++,f[b]=g,l++));if(u>a)for(b in l++,f)va.call(e,b)||(u--,delete f[b])}else f!==e&&(f=e,l++);return l}}c.$stateful=!0;var d=this,e,f,h,k=1<b.length,l=0,m=
g(a,c),n=[],p={},r=!0,u=0;return this.$watch(m,function(){r?(r=!1,b(e,e,d)):b(e,h,d);if(k)if(F(e))if(ta(e)){h=Array(e.length);for(var a=0;a<e.length;a++)h[a]=e[a]}else for(a in h={},e)va.call(e,a)&&(h[a]=e[a]);else h=e})},$digest:function(){var a,g,k,l,m,p,r,u=b,q,w=[],x,ia;n("$digest");h.$$checkUrlChange();this===H&&null!==f&&(h.defer.cancel(f),s());c=null;do{r=!1;q=this;for(p=0;p<v.length;p++){try{ia=v[p],ia.scope.$eval(ia.expression,ia.locals)}catch(z){e(z)}c=null}v.length=0;a:do{if(p=q.$$watchers)for(p.$$digestWatchIndex=
p.length;p.$$digestWatchIndex--;)try{if(a=p[p.$$digestWatchIndex])if(m=a.get,(g=m(q))!==(k=a.last)&&!(a.eq?qa(g,k):ga(g)&&ga(k)))r=!0,c=a,a.last=a.eq?Fa(g,null):g,l=a.fn,l(g,k===J?g:k,q),5>u&&(x=4-u,w[x]||(w[x]=[]),w[x].push({msg:y(a.exp)?"fn: "+(a.exp.name||a.exp.toString()):a.exp,newVal:g,oldVal:k}));else if(a===c){r=!1;break a}}catch(D){e(D)}if(!(p=q.$$watchersCount&&q.$$childHead||q!==this&&q.$$nextSibling))for(;q!==this&&!(p=q.$$nextSibling);)q=q.$parent}while(q=p);if((r||v.length)&&!u--)throw H.$$phase=
null,d("infdig",b,w);}while(r||v.length);for(H.$$phase=null;A<t.length;)try{t[A++]()}catch(E){e(E)}t.length=A=0},$destroy:function(){if(!this.$$destroyed){var a=this.$parent;this.$broadcast("$destroy");this.$$destroyed=!0;this===H&&h.$$applicationDestroyed();p(this,-this.$$watchersCount);for(var b in this.$$listenerCount)r(this,this.$$listenerCount[b],b);a&&a.$$childHead===this&&(a.$$childHead=this.$$nextSibling);a&&a.$$childTail===this&&(a.$$childTail=this.$$prevSibling);this.$$prevSibling&&(this.$$prevSibling.$$nextSibling=
this.$$nextSibling);this.$$nextSibling&&(this.$$nextSibling.$$prevSibling=this.$$prevSibling);this.$destroy=this.$digest=this.$apply=this.$evalAsync=this.$applyAsync=w;this.$on=this.$watch=this.$watchGroup=function(){return w};this.$$listeners={};this.$$nextSibling=null;l(this)}},$eval:function(a,b){return g(a)(this,b)},$evalAsync:function(a,b){H.$$phase||v.length||h.defer(function(){v.length&&H.$digest()});v.push({scope:this,expression:g(a),locals:b})},$$postDigest:function(a){t.push(a)},$apply:function(a){try{n("$apply");
try{return this.$eval(a)}finally{H.$$phase=null}}catch(b){e(b)}finally{try{H.$digest()}catch(c){throw e(c),c;}}},$applyAsync:function(a){function b(){c.$eval(a)}var c=this;a&&ia.push(b);a=g(a);u()},$on:function(a,b){var c=this.$$listeners[a];c||(this.$$listeners[a]=c=[]);c.push(b);var d=this;do d.$$listenerCount[a]||(d.$$listenerCount[a]=0),d.$$listenerCount[a]++;while(d=d.$parent);var e=this;return function(){var d=c.indexOf(b);-1!==d&&(c[d]=null,r(e,1,a))}},$emit:function(a,b){var c=[],d,f=this,
g=!1,h={name:a,targetScope:f,stopPropagation:function(){g=!0},preventDefault:function(){h.defaultPrevented=!0},defaultPrevented:!1},k=ab([h],arguments,1),l,m;do{d=f.$$listeners[a]||c;h.currentScope=f;l=0;for(m=d.length;l<m;l++)if(d[l])try{d[l].apply(null,k)}catch(n){e(n)}else d.splice(l,1),l--,m--;if(g)return h.currentScope=null,h;f=f.$parent}while(f);h.currentScope=null;return h},$broadcast:function(a,b){var c=this,d=this,f={name:a,targetScope:this,preventDefault:function(){f.defaultPrevented=!0},
defaultPrevented:!1};if(!this.$$listenerCount[a])return f;for(var g=ab([f],arguments,1),h,k;c=d;){f.currentScope=c;d=c.$$listeners[a]||[];h=0;for(k=d.length;h<k;h++)if(d[h])try{d[h].apply(null,g)}catch(l){e(l)}else d.splice(h,1),h--,k--;if(!(d=c.$$listenerCount[a]&&c.$$childHead||c!==this&&c.$$nextSibling))for(;c!==this&&!(d=c.$$nextSibling);)c=c.$parent}f.currentScope=null;return f}};var H=new m,v=H.$$asyncQueue=[],t=H.$$postDigestQueue=[],ia=H.$$applyAsyncQueue=[],A=0;return H}]}function ze(){var a=
/^\s*(https?|ftp|mailto|tel|file):/,b=/^\s*((https?|ftp|file|blob):|data:image\/)/;this.aHrefSanitizationWhitelist=function(b){return v(b)?(a=b,this):a};this.imgSrcSanitizationWhitelist=function(a){return v(a)?(b=a,this):b};this.$get=function(){return function(d,c){var f=c?b:a,e;e=Da(d).href;return""===e||e.match(f)?d:"unsafe:"+e}}}function xg(a){if("self"===a)return a;if(E(a)){if(-1<a.indexOf("***"))throw ua("iwcard",a);a=Gd(a).replace(/\\\*\\\*/g,".*").replace(/\\\*/g,"[^:/.?&;]*");return new RegExp("^"+
a+"$")}if(Xa(a))return new RegExp("^"+a.source+"$");throw ua("imatcher");}function Hd(a){var b=[];v(a)&&q(a,function(a){b.push(xg(a))});return b}function Lf(){this.SCE_CONTEXTS=pa;var a=["self"],b=[];this.resourceUrlWhitelist=function(b){arguments.length&&(a=Hd(b));return a};this.resourceUrlBlacklist=function(a){arguments.length&&(b=Hd(a));return b};this.$get=["$injector",function(d){function c(a,b){return"self"===a?sd(b):!!a.exec(b.href)}function f(a){var b=function(a){this.$$unwrapTrustedValue=
function(){return a}};a&&(b.prototype=new a);b.prototype.valueOf=function(){return this.$$unwrapTrustedValue()};b.prototype.toString=function(){return this.$$unwrapTrustedValue().toString()};return b}var e=function(a){throw ua("unsafe");};d.has("$sanitize")&&(e=d.get("$sanitize"));var g=f(),h={};h[pa.HTML]=f(g);h[pa.CSS]=f(g);h[pa.URL]=f(g);h[pa.JS]=f(g);h[pa.RESOURCE_URL]=f(h[pa.URL]);return{trustAs:function(a,b){var c=h.hasOwnProperty(a)?h[a]:null;if(!c)throw ua("icontext",a,b);if(null===b||x(b)||
""===b)return b;if("string"!==typeof b)throw ua("itype",a);return new c(b)},getTrusted:function(d,f){if(null===f||x(f)||""===f)return f;var g=h.hasOwnProperty(d)?h[d]:null;if(g&&f instanceof g)return f.$$unwrapTrustedValue();if(d===pa.RESOURCE_URL){var g=Da(f.toString()),n,p,r=!1;n=0;for(p=a.length;n<p;n++)if(c(a[n],g)){r=!0;break}if(r)for(n=0,p=b.length;n<p;n++)if(c(b[n],g)){r=!1;break}if(r)return f;throw ua("insecurl",f.toString());}if(d===pa.HTML)return e(f);throw ua("unsafe");},valueOf:function(a){return a instanceof
g?a.$$unwrapTrustedValue():a}}}]}function Kf(){var a=!0;this.enabled=function(b){arguments.length&&(a=!!b);return a};this.$get=["$parse","$sceDelegate",function(b,d){if(a&&8>La)throw ua("iequirks");var c=ra(pa);c.isEnabled=function(){return a};c.trustAs=d.trustAs;c.getTrusted=d.getTrusted;c.valueOf=d.valueOf;a||(c.trustAs=c.getTrusted=function(a,b){return b},c.valueOf=Ya);c.parseAs=function(a,d){var e=b(d);return e.literal&&e.constant?e:b(d,function(b){return c.getTrusted(a,b)})};var f=c.parseAs,
e=c.getTrusted,g=c.trustAs;q(pa,function(a,b){var d=P(b);c[("parse_as_"+d).replace(sc,gb)]=function(b){return f(a,b)};c[("get_trusted_"+d).replace(sc,gb)]=function(b){return e(a,b)};c[("trust_as_"+d).replace(sc,gb)]=function(b){return g(a,b)}});return c}]}function Mf(){this.$get=["$window","$document",function(a,b){var d={},c=!(a.chrome&&(a.chrome.app&&a.chrome.app.runtime||!a.chrome.app&&a.chrome.runtime&&a.chrome.runtime.id))&&a.history&&a.history.pushState,f=Z((/android (\d+)/.exec(P((a.navigator||
{}).userAgent))||[])[1]),e=/Boxee/i.test((a.navigator||{}).userAgent),g=b[0]||{},h=g.body&&g.body.style,k=!1,l=!1;h&&(k=!!("transition"in h||"webkitTransition"in h),l=!!("animation"in h||"webkitAnimation"in h));return{history:!(!c||4>f||e),hasEvent:function(a){if("input"===a&&La)return!1;if(x(d[a])){var b=g.createElement("div");d[a]="on"+a in b}return d[a]},csp:za(),transitions:k,animations:l,android:f}}]}function Of(){var a;this.httpOptions=function(b){return b?(a=b,this):a};this.$get=["$exceptionHandler",
"$templateCache","$http","$q","$sce",function(b,d,c,f,e){function g(h,k){g.totalPendingRequests++;if(!E(h)||x(d.get(h)))h=e.getTrustedResourceUrl(h);var l=c.defaults&&c.defaults.transformResponse;C(l)?l=l.filter(function(a){return a!==jc}):l===jc&&(l=null);return c.get(h,R({cache:d,transformResponse:l},a)).finally(function(){g.totalPendingRequests--}).then(function(a){d.put(h,a.data);return a.data},function(a){k||(a=yg("tpload",h,a.status,a.statusText),b(a));return f.reject(a)})}g.totalPendingRequests=
0;return g}]}function Pf(){this.$get=["$rootScope","$browser","$location",function(a,b,d){return{findBindings:function(a,b,d){a=a.getElementsByClassName("ng-binding");var g=[];q(a,function(a){var c=$.element(a).data("$binding");c&&q(c,function(c){d?(new RegExp("(^|\\s)"+Gd(b)+"(\\s|\\||$)")).test(c)&&g.push(a):-1!==c.indexOf(b)&&g.push(a)})});return g},findModels:function(a,b,d){for(var g=["ng-","data-ng-","ng\\:"],h=0;h<g.length;++h){var k=a.querySelectorAll("["+g[h]+"model"+(d?"=":"*=")+'"'+b+'"]');
if(k.length)return k}},getLocation:function(){return d.url()},setLocation:function(b){b!==d.url()&&(d.url(b),a.$digest())},whenStable:function(a){b.notifyWhenNoOutstandingRequests(a)}}}]}function Qf(){this.$get=["$rootScope","$browser","$q","$$q","$exceptionHandler",function(a,b,d,c,f){function e(e,k,l){y(e)||(l=k,k=e,e=w);var m=wa.call(arguments,3),n=v(l)&&!l,p=(n?c:d).defer(),r=p.promise,q;q=b.defer(function(){try{p.resolve(e.apply(null,m))}catch(b){p.reject(b),f(b)}finally{delete g[r.$$timeoutId]}n||
a.$apply()},k);r.$$timeoutId=q;g[q]=p;return r}var g={};e.cancel=function(a){return a&&a.$$timeoutId in g?(g[a.$$timeoutId].promise.catch(w),g[a.$$timeoutId].reject("canceled"),delete g[a.$$timeoutId],b.defer.cancel(a.$$timeoutId)):!1};return e}]}function Da(a){La&&(ca.setAttribute("href",a),a=ca.href);ca.setAttribute("href",a);return{href:ca.href,protocol:ca.protocol?ca.protocol.replace(/:$/,""):"",host:ca.host,search:ca.search?ca.search.replace(/^\?/,""):"",hash:ca.hash?ca.hash.replace(/^#/,""):
"",hostname:ca.hostname,port:ca.port,pathname:"/"===ca.pathname.charAt(0)?ca.pathname:"/"+ca.pathname}}function sd(a){a=E(a)?Da(a):a;return a.protocol===Id.protocol&&a.host===Id.host}function Rf(){this.$get=ma(z)}function Jd(a){function b(a){try{return decodeURIComponent(a)}catch(b){return a}}var d=a[0]||{},c={},f="";return function(){var a,g,h,k,l;try{a=d.cookie||""}catch(m){a=""}if(a!==f)for(f=a,a=f.split("; "),c={},h=0;h<a.length;h++)g=a[h],k=g.indexOf("="),0<k&&(l=b(g.substring(0,k)),x(c[l])&&
(c[l]=b(g.substring(k+1))));return c}}function Vf(){this.$get=Jd}function Xc(a){function b(d,c){if(F(d)){var f={};q(d,function(a,c){f[c]=b(c,a)});return f}return a.factory(d+"Filter",c)}this.register=b;this.$get=["$injector",function(a){return function(b){return a.get(b+"Filter")}}];b("currency",Kd);b("date",Ld);b("filter",zg);b("json",Ag);b("limitTo",Bg);b("lowercase",Cg);b("number",Md);b("orderBy",Nd);b("uppercase",Dg)}function zg(){return function(a,b,d,c){if(!ta(a)){if(null==a)return a;throw M("filter")("notarray",
a);}c=c||"$";var f;switch(tc(b)){case "function":break;case "boolean":case "null":case "number":case "string":f=!0;case "object":b=Eg(b,d,c,f);break;default:return a}return Array.prototype.filter.call(a,b)}}function Eg(a,b,d,c){var f=F(a)&&d in a;!0===b?b=qa:y(b)||(b=function(a,b){if(x(a))return!1;if(null===a||null===b)return a===b;if(F(b)||F(a)&&!Vb(a))return!1;a=P(""+a);b=P(""+b);return-1!==a.indexOf(b)});return function(e){return f&&!F(e)?Ha(e,a[d],b,d,!1):Ha(e,a,b,d,c)}}function Ha(a,b,d,c,f,
e){var g=tc(a),h=tc(b);if("string"===h&&"!"===b.charAt(0))return!Ha(a,b.substring(1),d,c,f);if(C(a))return a.some(function(a){return Ha(a,b,d,c,f)});switch(g){case "object":var k;if(f){for(k in a)if("$"!==k.charAt(0)&&Ha(a[k],b,d,c,!0))return!0;return e?!1:Ha(a,b,d,c,!1)}if("object"===h){for(k in b)if(e=b[k],!y(e)&&!x(e)&&(g=k===c,!Ha(g?a:a[k],e,d,c,g,g)))return!1;return!0}return d(a,b);case "function":return!1;default:return d(a,b)}}function tc(a){return null===a?"null":typeof a}function Kd(a){var b=
a.NUMBER_FORMATS;return function(a,c,f){x(c)&&(c=b.CURRENCY_SYM);x(f)&&(f=b.PATTERNS[1].maxFrac);return null==a?a:Od(a,b.PATTERNS[1],b.GROUP_SEP,b.DECIMAL_SEP,f).replace(/\u00A4/g,c)}}function Md(a){var b=a.NUMBER_FORMATS;return function(a,c){return null==a?a:Od(a,b.PATTERNS[0],b.GROUP_SEP,b.DECIMAL_SEP,c)}}function Fg(a){var b=0,d,c,f,e,g;-1<(c=a.indexOf(Pd))&&(a=a.replace(Pd,""));0<(f=a.search(/e/i))?(0>c&&(c=f),c+=+a.slice(f+1),a=a.substring(0,f)):0>c&&(c=a.length);for(f=0;a.charAt(f)===uc;f++);
if(f===(g=a.length))d=[0],c=1;else{for(g--;a.charAt(g)===uc;)g--;c-=f;d=[];for(e=0;f<=g;f++,e++)d[e]=+a.charAt(f)}c>Qd&&(d=d.splice(0,Qd-1),b=c-1,c=1);return{d:d,e:b,i:c}}function Gg(a,b,d,c){var f=a.d,e=f.length-a.i;b=x(b)?Math.min(Math.max(d,e),c):+b;d=b+a.i;c=f[d];if(0<d){f.splice(Math.max(a.i,d));for(var g=d;g<f.length;g++)f[g]=0}else for(e=Math.max(0,e),a.i=1,f.length=Math.max(1,d=b+1),f[0]=0,g=1;g<d;g++)f[g]=0;if(5<=c)if(0>d-1){for(c=0;c>d;c--)f.unshift(0),a.i++;f.unshift(1);a.i++}else f[d-
1]++;for(;e<Math.max(0,b);e++)f.push(0);if(b=f.reduceRight(function(a,b,c,d){b+=a;d[c]=b%10;return Math.floor(b/10)},0))f.unshift(b),a.i++}function Od(a,b,d,c,f){if(!E(a)&&!Y(a)||isNaN(a))return"";var e=!isFinite(a),g=!1,h=Math.abs(a)+"",k="";if(e)k="\u221e";else{g=Fg(h);Gg(g,f,b.minFrac,b.maxFrac);k=g.d;h=g.i;f=g.e;e=[];for(g=k.reduce(function(a,b){return a&&!b},!0);0>h;)k.unshift(0),h++;0<h?e=k.splice(h,k.length):(e=k,k=[0]);h=[];for(k.length>=b.lgSize&&h.unshift(k.splice(-b.lgSize,k.length).join(""));k.length>
b.gSize;)h.unshift(k.splice(-b.gSize,k.length).join(""));k.length&&h.unshift(k.join(""));k=h.join(d);e.length&&(k+=c+e.join(""));f&&(k+="e+"+f)}return 0>a&&!g?b.negPre+k+b.negSuf:b.posPre+k+b.posSuf}function Kb(a,b,d,c){var f="";if(0>a||c&&0>=a)c?a=-a+1:(a=-a,f="-");for(a=""+a;a.length<b;)a=uc+a;d&&(a=a.substr(a.length-b));return f+a}function aa(a,b,d,c,f){d=d||0;return function(e){e=e["get"+a]();if(0<d||e>-d)e+=d;0===e&&-12===d&&(e=12);return Kb(e,b,c,f)}}function nb(a,b,d){return function(c,f){var e=
c["get"+a](),g=vb((d?"STANDALONE":"")+(b?"SHORT":"")+a);return f[g][e]}}function Rd(a){var b=(new Date(a,0,1)).getDay();return new Date(a,0,(4>=b?5:12)-b)}function Sd(a){return function(b){var d=Rd(b.getFullYear());b=+new Date(b.getFullYear(),b.getMonth(),b.getDate()+(4-b.getDay()))-+d;b=1+Math.round(b/6048E5);return Kb(b,a)}}function vc(a,b){return 0>=a.getFullYear()?b.ERAS[0]:b.ERAS[1]}function Ld(a){function b(a){var b;if(b=a.match(d)){a=new Date(0);var e=0,g=0,h=b[8]?a.setUTCFullYear:a.setFullYear,
k=b[8]?a.setUTCHours:a.setHours;b[9]&&(e=Z(b[9]+b[10]),g=Z(b[9]+b[11]));h.call(a,Z(b[1]),Z(b[2])-1,Z(b[3]));e=Z(b[4]||0)-e;g=Z(b[5]||0)-g;h=Z(b[6]||0);b=Math.round(1E3*parseFloat("0."+(b[7]||0)));k.call(a,e,g,h,b)}return a}var d=/^(\d{4})-?(\d\d)-?(\d\d)(?:T(\d\d)(?::?(\d\d)(?::?(\d\d)(?:\.(\d+))?)?)?(Z|([+-])(\d\d):?(\d\d))?)?$/;return function(c,d,e){var g="",h=[],k,l;d=d||"mediumDate";d=a.DATETIME_FORMATS[d]||d;E(c)&&(c=Hg.test(c)?Z(c):b(c));Y(c)&&(c=new Date(c));if(!fa(c)||!isFinite(c.getTime()))return c;
for(;d;)(l=Ig.exec(d))?(h=ab(h,l,1),d=h.pop()):(h.push(d),d=null);var m=c.getTimezoneOffset();e&&(m=Jc(e,m),c=Wb(c,e,!0));q(h,function(b){k=Jg[b];g+=k?k(c,a.DATETIME_FORMATS,m):"''"===b?"'":b.replace(/(^'|'$)/g,"").replace(/''/g,"'")});return g}}function Ag(){return function(a,b){x(b)&&(b=2);return cb(a,b)}}function Bg(){return function(a,b,d){b=Infinity===Math.abs(Number(b))?Number(b):Z(b);if(ga(b))return a;Y(a)&&(a=a.toString());if(!ta(a))return a;d=!d||isNaN(d)?0:Z(d);d=0>d?Math.max(0,a.length+
d):d;return 0<=b?wc(a,d,d+b):0===d?wc(a,b,a.length):wc(a,Math.max(0,d+b),d)}}function wc(a,b,d){return E(a)?a.slice(b,d):wa.call(a,b,d)}function Nd(a){function b(b){return b.map(function(b){var c=1,d=Ya;if(y(b))d=b;else if(E(b)){if("+"===b.charAt(0)||"-"===b.charAt(0))c="-"===b.charAt(0)?-1:1,b=b.substring(1);if(""!==b&&(d=a(b),d.constant))var f=d(),d=function(a){return a[f]}}return{get:d,descending:c}})}function d(a){switch(typeof a){case "number":case "boolean":case "string":return!0;default:return!1}}
function c(a,b){var c=0,d=a.type,k=b.type;if(d===k){var k=a.value,l=b.value;"string"===d?(k=k.toLowerCase(),l=l.toLowerCase()):"object"===d&&(F(k)&&(k=a.index),F(l)&&(l=b.index));k!==l&&(c=k<l?-1:1)}else c=d<k?-1:1;return c}return function(a,e,g,h){if(null==a)return a;if(!ta(a))throw M("orderBy")("notarray",a);C(e)||(e=[e]);0===e.length&&(e=["+"]);var k=b(e),l=g?-1:1,m=y(h)?h:c;a=Array.prototype.map.call(a,function(a,b){return{value:a,tieBreaker:{value:b,type:"number",index:b},predicateValues:k.map(function(c){var e=
c.get(a);c=typeof e;if(null===e)c="string",e="null";else if("object"===c)a:{if(y(e.valueOf)&&(e=e.valueOf(),d(e)))break a;Vb(e)&&(e=e.toString(),d(e))}return{value:e,type:c,index:b}})}});a.sort(function(a,b){for(var c=0,d=k.length;c<d;c++){var e=m(a.predicateValues[c],b.predicateValues[c]);if(e)return e*k[c].descending*l}return m(a.tieBreaker,b.tieBreaker)*l});return a=a.map(function(a){return a.value})}}function Ra(a){y(a)&&(a={link:a});a.restrict=a.restrict||"AC";return ma(a)}function Lb(a,b,d,
c,f){this.$$controls=[];this.$error={};this.$$success={};this.$pending=void 0;this.$name=f(b.name||b.ngForm||"")(d);this.$dirty=!1;this.$valid=this.$pristine=!0;this.$submitted=this.$invalid=!1;this.$$parentForm=Mb;this.$$element=a;this.$$animate=c;Td(this)}function Td(a){a.$$classCache={};a.$$classCache[Ud]=!(a.$$classCache[ob]=a.$$element.hasClass(ob))}function Vd(a){function b(a,b,c){c&&!a.$$classCache[b]?(a.$$animate.addClass(a.$$element,b),a.$$classCache[b]=!0):!c&&a.$$classCache[b]&&(a.$$animate.removeClass(a.$$element,
b),a.$$classCache[b]=!1)}function d(a,c,d){c=c?"-"+Nc(c,"-"):"";b(a,ob+c,!0===d);b(a,Ud+c,!1===d)}var c=a.set,f=a.unset;a.clazz.prototype.$setValidity=function(a,g,h){x(g)?(this.$pending||(this.$pending={}),c(this.$pending,a,h)):(this.$pending&&f(this.$pending,a,h),Wd(this.$pending)&&(this.$pending=void 0));Ia(g)?g?(f(this.$error,a,h),c(this.$$success,a,h)):(c(this.$error,a,h),f(this.$$success,a,h)):(f(this.$error,a,h),f(this.$$success,a,h));this.$pending?(b(this,"ng-pending",!0),this.$valid=this.$invalid=
void 0,d(this,"",null)):(b(this,"ng-pending",!1),this.$valid=Wd(this.$error),this.$invalid=!this.$valid,d(this,"",this.$valid));g=this.$pending&&this.$pending[a]?void 0:this.$error[a]?!1:this.$$success[a]?!0:null;d(this,a,g);this.$$parentForm.$setValidity(a,g,this)}}function Wd(a){if(a)for(var b in a)if(a.hasOwnProperty(b))return!1;return!0}function xc(a){a.$formatters.push(function(b){return a.$isEmpty(b)?b:b.toString()})}function Sa(a,b,d,c,f,e){var g=P(b[0].type);if(!f.android){var h=!1;b.on("compositionstart",
function(){h=!0});b.on("compositionend",function(){h=!1;l()})}var k,l=function(a){k&&(e.defer.cancel(k),k=null);if(!h){var f=b.val();a=a&&a.type;"password"===g||d.ngTrim&&"false"===d.ngTrim||(f=S(f));(c.$viewValue!==f||""===f&&c.$$hasNativeValidators)&&c.$setViewValue(f,a)}};if(f.hasEvent("input"))b.on("input",l);else{var m=function(a,b,c){k||(k=e.defer(function(){k=null;b&&b.value===c||l(a)}))};b.on("keydown",function(a){var b=a.keyCode;91===b||15<b&&19>b||37<=b&&40>=b||m(a,this,this.value)});if(f.hasEvent("paste"))b.on("paste cut",
m)}b.on("change",l);if(Xd[g]&&c.$$hasNativeValidators&&g===d.type)b.on("keydown wheel mousedown",function(a){if(!k){var b=this.validity,c=b.badInput,d=b.typeMismatch;k=e.defer(function(){k=null;b.badInput===c&&b.typeMismatch===d||l(a)})}});c.$render=function(){var a=c.$isEmpty(c.$viewValue)?"":c.$viewValue;b.val()!==a&&b.val(a)}}function Nb(a,b){return function(d,c){var f,e;if(fa(d))return d;if(E(d)){'"'===d.charAt(0)&&'"'===d.charAt(d.length-1)&&(d=d.substring(1,d.length-1));if(Kg.test(d))return new Date(d);
a.lastIndex=0;if(f=a.exec(d))return f.shift(),e=c?{yyyy:c.getFullYear(),MM:c.getMonth()+1,dd:c.getDate(),HH:c.getHours(),mm:c.getMinutes(),ss:c.getSeconds(),sss:c.getMilliseconds()/1E3}:{yyyy:1970,MM:1,dd:1,HH:0,mm:0,ss:0,sss:0},q(f,function(a,c){c<b.length&&(e[b[c]]=+a)}),new Date(e.yyyy,e.MM-1,e.dd,e.HH,e.mm,e.ss||0,1E3*e.sss||0)}return NaN}}function pb(a,b,d,c){return function(f,e,g,h,k,l,m){function n(a){return a&&!(a.getTime&&a.getTime()!==a.getTime())}function p(a){return v(a)&&!fa(a)?d(a)||
void 0:a}yc(f,e,g,h);Sa(f,e,g,h,k,l);var r=h&&h.$options.getOption("timezone"),q;h.$$parserName=a;h.$parsers.push(function(a){if(h.$isEmpty(a))return null;if(b.test(a))return a=d(a,q),r&&(a=Wb(a,r)),a});h.$formatters.push(function(a){if(a&&!fa(a))throw qb("datefmt",a);if(n(a))return(q=a)&&r&&(q=Wb(q,r,!0)),m("date")(a,c,r);q=null;return""});if(v(g.min)||g.ngMin){var s;h.$validators.min=function(a){return!n(a)||x(s)||d(a)>=s};g.$observe("min",function(a){s=p(a);h.$validate()})}if(v(g.max)||g.ngMax){var u;
h.$validators.max=function(a){return!n(a)||x(u)||d(a)<=u};g.$observe("max",function(a){u=p(a);h.$validate()})}}}function yc(a,b,d,c){(c.$$hasNativeValidators=F(b[0].validity))&&c.$parsers.push(function(a){var c=b.prop("validity")||{};return c.badInput||c.typeMismatch?void 0:a})}function Yd(a){a.$$parserName="number";a.$parsers.push(function(b){if(a.$isEmpty(b))return null;if(Lg.test(b))return parseFloat(b)});a.$formatters.push(function(b){if(!a.$isEmpty(b)){if(!Y(b))throw qb("numfmt",b);b=b.toString()}return b})}
function Ta(a){v(a)&&!Y(a)&&(a=parseFloat(a));return ga(a)?void 0:a}function zc(a){var b=a.toString(),d=b.indexOf(".");return-1===d?-1<a&&1>a&&(a=/e-(\d+)$/.exec(b))?Number(a[1]):0:b.length-d-1}function Zd(a,b,d){a=Number(a);if((a|0)!==a||(b|0)!==b||(d|0)!==d){var c=Math.max(zc(a),zc(b),zc(d)),c=Math.pow(10,c);a*=c;b*=c;d*=c}return 0===(a-b)%d}function $d(a,b,d,c,f){if(v(c)){a=a(c);if(!a.constant)throw qb("constexpr",d,c);return a(b)}return f}function Ac(a,b){function d(a,b){if(!a||!a.length)return[];
if(!b||!b.length)return a;var c=[],d=0;a:for(;d<a.length;d++){for(var e=a[d],f=0;f<b.length;f++)if(e===b[f])continue a;c.push(e)}return c}function c(a){var b=a;C(a)?b=a.map(c).join(" "):F(a)&&(b=Object.keys(a).filter(function(b){return a[b]}).join(" "));return b}function f(a){var b=a;if(C(a))b=a.map(f);else if(F(a)){var c=!1,b=Object.keys(a).filter(function(b){b=a[b];!c&&x(b)&&(c=!0);return b});c&&b.push(void 0)}return b}a="ngClass"+a;var e;return["$parse",function(g){return{restrict:"AC",link:function(h,
k,l){function m(a,b){var c=[];q(a,function(a){if(0<b||H[a])H[a]=(H[a]||0)+b,H[a]===+(0<b)&&c.push(a)});return c.join(" ")}function n(a){if(a===b){var c=t,c=m(c&&c.split(" "),1);l.$addClass(c)}else c=t,c=m(c&&c.split(" "),-1),l.$removeClass(c);w=a}function p(a){a=c(a);a!==t&&r(a)}function r(a){if(w===b){var c=t&&t.split(" "),e=a&&a.split(" "),f=d(c,e),c=d(e,c),f=m(f,-1),c=m(c,1);l.$addClass(c);l.$removeClass(f)}t=a}var s=l[a].trim(),v=":"===s.charAt(0)&&":"===s.charAt(1),s=g(s,v?f:c),u=v?p:r,H=k.data("$classCounts"),
w=!0,t;H||(H=W(),k.data("$classCounts",H));"ngClass"!==a&&(e||(e=g("$index",function(a){return a&1})),h.$watch(e,n));h.$watch(s,u,v)}}}]}function Ob(a,b,d,c,f,e,g,h,k){this.$modelValue=this.$viewValue=Number.NaN;this.$$rawModelValue=void 0;this.$validators={};this.$asyncValidators={};this.$parsers=[];this.$formatters=[];this.$viewChangeListeners=[];this.$untouched=!0;this.$touched=!1;this.$pristine=!0;this.$dirty=!1;this.$valid=!0;this.$invalid=!1;this.$error={};this.$$success={};this.$pending=void 0;
this.$name=k(d.name||"",!1)(a);this.$$parentForm=Mb;this.$options=Pb;this.$$parsedNgModel=f(d.ngModel);this.$$parsedNgModelAssign=this.$$parsedNgModel.assign;this.$$ngModelGet=this.$$parsedNgModel;this.$$ngModelSet=this.$$parsedNgModelAssign;this.$$pendingDebounce=null;this.$$parserValid=void 0;this.$$currentValidationRunId=0;this.$$scope=a;this.$$attr=d;this.$$element=c;this.$$animate=e;this.$$timeout=g;this.$$parse=f;this.$$q=h;this.$$exceptionHandler=b;Td(this);Mg(this)}function Mg(a){a.$$scope.$watch(function(){var b=
a.$$ngModelGet(a.$$scope);if(b!==a.$modelValue&&(a.$modelValue===a.$modelValue||b===b)){a.$modelValue=a.$$rawModelValue=b;a.$$parserValid=void 0;for(var d=a.$formatters,c=d.length,f=b;c--;)f=d[c](f);a.$viewValue!==f&&(a.$$updateEmptyClasses(f),a.$viewValue=a.$$lastCommittedViewValue=f,a.$render(),a.$$runValidators(a.$modelValue,a.$viewValue,w))}return b})}function Bc(a){this.$$options=a}function ae(a,b){q(b,function(b,c){v(a[c])||(a[c]=b)})}var Ng=/^\/(.+)\/([a-z]*)$/,va=Object.prototype.hasOwnProperty,
P=function(a){return E(a)?a.toLowerCase():a},vb=function(a){return E(a)?a.toUpperCase():a},La,D,oa,wa=[].slice,ng=[].splice,Og=[].push,na=Object.prototype.toString,Gc=Object.getPrototypeOf,Ga=M("ng"),$=z.angular||(z.angular={}),Zb,rb=0;La=z.document.documentMode;var ga=Number.isNaN||function(a){return a!==a};w.$inject=[];Ya.$inject=[];var C=Array.isArray,le=/^\[object (?:Uint8|Uint8Clamped|Uint16|Uint32|Int8|Int16|Int32|Float32|Float64)Array]$/,S=function(a){return E(a)?a.trim():a},Gd=function(a){return a.replace(/([-()[\]{}+?*.$^|,:#<!\\])/g,
"\\$1").replace(/\x08/g,"\\x08")},za=function(){if(!v(za.rules)){var a=z.document.querySelector("[ng-csp]")||z.document.querySelector("[data-ng-csp]");if(a){var b=a.getAttribute("ng-csp")||a.getAttribute("data-ng-csp");za.rules={noUnsafeEval:!b||-1!==b.indexOf("no-unsafe-eval"),noInlineStyle:!b||-1!==b.indexOf("no-inline-style")}}else{a=za;try{new Function(""),b=!1}catch(d){b=!0}a.rules={noUnsafeEval:b,noInlineStyle:!1}}}return za.rules},sb=function(){if(v(sb.name_))return sb.name_;var a,b,d=Ka.length,
c,f;for(b=0;b<d;++b)if(c=Ka[b],a=z.document.querySelector("["+c.replace(":","\\:")+"jq]")){f=a.getAttribute(c+"jq");break}return sb.name_=f},ne=/:/g,Ka=["ng-","data-ng-","ng:","x-ng-"],qe=function(a){if(!a.currentScript)return!0;var b=a.currentScript.getAttribute("src"),d=a.createElement("a");d.href=b;if(a.location.origin===d.origin)return!0;switch(d.protocol){case "http:":case "https:":case "ftp:":case "blob:":case "file:":case "data:":return!0;default:return!1}}(z.document),te=/[A-Z]/g,Oc=!1,Ja=
3,ye={full:"1.6.1",major:1,minor:6,dot:1,codeName:"promise-rectification"};X.expando="ng339";var ib=X.cache={},$f=1;X._data=function(a){return this.cache[a[this.expando]]||{}};var Wf=/-([a-z])/g,Pg=/^-ms-/,Ab={mouseleave:"mouseout",mouseenter:"mouseover"},ac=M("jqLite"),Zf=/^<([\w-]+)\s*\/?>(?:<\/\1>|)$/,$b=/<|&#?\w+;/,Xf=/<([\w:-]+)/,Yf=/<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:-]+)[^>]*)\/>/gi,ha={option:[1,'<select multiple="multiple">',"</select>"],thead:[1,"<table>","</table>"],
col:[2,"<table><colgroup>","</colgroup></table>"],tr:[2,"<table><tbody>","</tbody></table>"],td:[3,"<table><tbody><tr>","</tr></tbody></table>"],_default:[0,"",""]};ha.optgroup=ha.option;ha.tbody=ha.tfoot=ha.colgroup=ha.caption=ha.thead;ha.th=ha.td;var eg=z.Node.prototype.contains||function(a){return!!(this.compareDocumentPosition(a)&16)},Oa=X.prototype={ready:$c,toString:function(){var a=[];q(this,function(b){a.push(""+b)});return"["+a.join(", ")+"]"},eq:function(a){return 0<=a?D(this[a]):D(this[this.length+
a])},length:0,push:Og,sort:[].sort,splice:[].splice},Gb={};q("multiple selected checked disabled readOnly required open".split(" "),function(a){Gb[P(a)]=a});var ed={};q("input select option textarea button form details".split(" "),function(a){ed[a]=!0});var ld={ngMinlength:"minlength",ngMaxlength:"maxlength",ngMin:"min",ngMax:"max",ngPattern:"pattern",ngStep:"step"};q({data:dc,removeData:hb,hasData:function(a){for(var b in ib[a.ng339])return!0;return!1},cleanData:function(a){for(var b=0,d=a.length;b<
d;b++)hb(a[b])}},function(a,b){X[b]=a});q({data:dc,inheritedData:Eb,scope:function(a){return D.data(a,"$scope")||Eb(a.parentNode||a,["$isolateScope","$scope"])},isolateScope:function(a){return D.data(a,"$isolateScope")||D.data(a,"$isolateScopeNoTemplate")},controller:bd,injector:function(a){return Eb(a,"$injector")},removeAttr:function(a,b){a.removeAttribute(b)},hasClass:Bb,css:function(a,b,d){b=xb(b.replace(Pg,"ms-"));if(v(d))a.style[b]=d;else return a.style[b]},attr:function(a,b,d){var c=a.nodeType;
if(c!==Ja&&2!==c&&8!==c&&a.getAttribute){var c=P(b),f=Gb[c];if(v(d))null===d||!1===d&&f?a.removeAttribute(b):a.setAttribute(b,f?c:d);else return a=a.getAttribute(b),f&&null!==a&&(a=c),null===a?void 0:a}},prop:function(a,b,d){if(v(d))a[b]=d;else return a[b]},text:function(){function a(a,d){if(x(d)){var c=a.nodeType;return 1===c||c===Ja?a.textContent:""}a.textContent=d}a.$dv="";return a}(),val:function(a,b){if(x(b)){if(a.multiple&&"select"===xa(a)){var d=[];q(a.options,function(a){a.selected&&d.push(a.value||
a.text)});return d}return a.value}a.value=b},html:function(a,b){if(x(b))return a.innerHTML;yb(a,!0);a.innerHTML=b},empty:cd},function(a,b){X.prototype[b]=function(b,c){var f,e,g=this.length;if(a!==cd&&x(2===a.length&&a!==Bb&&a!==bd?b:c)){if(F(b)){for(f=0;f<g;f++)if(a===dc)a(this[f],b);else for(e in b)a(this[f],e,b[e]);return this}f=a.$dv;g=x(f)?Math.min(g,1):g;for(e=0;e<g;e++){var h=a(this[e],b,c);f=f?f+h:h}return f}for(f=0;f<g;f++)a(this[f],b,c);return this}});q({removeData:hb,on:function(a,b,d,
c){if(v(c))throw ac("onargs");if(Yc(a)){c=zb(a,!0);var f=c.events,e=c.handle;e||(e=c.handle=bg(a,f));c=0<=b.indexOf(" ")?b.split(" "):[b];for(var g=c.length,h=function(b,c,g){var h=f[b];h||(h=f[b]=[],h.specialHandlerWrapper=c,"$destroy"===b||g||a.addEventListener(b,e));h.push(d)};g--;)b=c[g],Ab[b]?(h(Ab[b],dg),h(b,void 0,!0)):h(b)}},off:ad,one:function(a,b,d){a=D(a);a.on(b,function f(){a.off(b,d);a.off(b,f)});a.on(b,d)},replaceWith:function(a,b){var d,c=a.parentNode;yb(a);q(new X(b),function(b){d?
c.insertBefore(b,d.nextSibling):c.replaceChild(b,a);d=b})},children:function(a){var b=[];q(a.childNodes,function(a){1===a.nodeType&&b.push(a)});return b},contents:function(a){return a.contentDocument||a.childNodes||[]},append:function(a,b){var d=a.nodeType;if(1===d||11===d){b=new X(b);for(var d=0,c=b.length;d<c;d++)a.appendChild(b[d])}},prepend:function(a,b){if(1===a.nodeType){var d=a.firstChild;q(new X(b),function(b){a.insertBefore(b,d)})}},wrap:function(a,b){var d=D(b).eq(0).clone()[0],c=a.parentNode;
c&&c.replaceChild(d,a);d.appendChild(a)},remove:Fb,detach:function(a){Fb(a,!0)},after:function(a,b){var d=a,c=a.parentNode;if(c){b=new X(b);for(var f=0,e=b.length;f<e;f++){var g=b[f];c.insertBefore(g,d.nextSibling);d=g}}},addClass:Db,removeClass:Cb,toggleClass:function(a,b,d){b&&q(b.split(" "),function(b){var f=d;x(f)&&(f=!Bb(a,b));(f?Db:Cb)(a,b)})},parent:function(a){return(a=a.parentNode)&&11!==a.nodeType?a:null},next:function(a){return a.nextElementSibling},find:function(a,b){return a.getElementsByTagName?
a.getElementsByTagName(b):[]},clone:cc,triggerHandler:function(a,b,d){var c,f,e=b.type||b,g=zb(a);if(g=(g=g&&g.events)&&g[e])c={preventDefault:function(){this.defaultPrevented=!0},isDefaultPrevented:function(){return!0===this.defaultPrevented},stopImmediatePropagation:function(){this.immediatePropagationStopped=!0},isImmediatePropagationStopped:function(){return!0===this.immediatePropagationStopped},stopPropagation:w,type:e,target:a},b.type&&(c=R(c,b)),b=ra(g),f=d?[c].concat(d):[c],q(b,function(b){c.isImmediatePropagationStopped()||
b.apply(a,f)})}},function(a,b){X.prototype[b]=function(b,c,f){for(var e,g=0,h=this.length;g<h;g++)x(e)?(e=a(this[g],b,c,f),v(e)&&(e=D(e))):bc(e,a(this[g],b,c,f));return v(e)?e:this}});X.prototype.bind=X.prototype.on;X.prototype.unbind=X.prototype.off;Qa.prototype={put:function(a,b){this[la(a,this.nextUid)]=b},get:function(a){return this[la(a,this.nextUid)]},remove:function(a){var b=this[a=la(a,this.nextUid)];delete this[a];return b}};var Uf=[function(){this.$get=[function(){return Qa}]}],gg=/^([^(]+?)=>/,
hg=/^[^(]*\(\s*([^)]*)\)/m,Qg=/,/,Rg=/^\s*(_?)(\S+?)\1\s*$/,fg=/((\/\/.*$)|(\/\*[\s\S]*?\*\/))/mg,da=M("$injector");eb.$$annotate=function(a,b,d){var c;if("function"===typeof a){if(!(c=a.$inject)){c=[];if(a.length){if(b)throw E(d)&&d||(d=a.name||ig(a)),da("strictdi",d);b=fd(a);q(b[1].split(Qg),function(a){a.replace(Rg,function(a,b,d){c.push(d)})})}a.$inject=c}}else C(a)?(b=a.length-1,tb(a[b],"fn"),c=a.slice(0,b)):tb(a,"fn",!0);return c};var be=M("$animate"),lf=function(){this.$get=w},mf=function(){var a=
new Qa,b=[];this.$get=["$$AnimateRunner","$rootScope",function(d,c){function f(a,b,c){var d=!1;b&&(b=E(b)?b.split(" "):C(b)?b:[],q(b,function(b){b&&(d=!0,a[b]=c)}));return d}function e(){q(b,function(b){var c=a.get(b);if(c){var d=jg(b.attr("class")),e="",f="";q(c,function(a,b){a!==!!d[b]&&(a?e+=(e.length?" ":"")+b:f+=(f.length?" ":"")+b)});q(b,function(a){e&&Db(a,e);f&&Cb(a,f)});a.remove(b)}});b.length=0}return{enabled:w,on:w,off:w,pin:w,push:function(g,h,k,l){l&&l();k=k||{};k.from&&g.css(k.from);
k.to&&g.css(k.to);if(k.addClass||k.removeClass)if(h=k.addClass,l=k.removeClass,k=a.get(g)||{},h=f(k,h,!0),l=f(k,l,!1),h||l)a.put(g,k),b.push(g),1===b.length&&c.$$postDigest(e);g=new d;g.complete();return g}}}]},jf=["$provide",function(a){var b=this;this.$$registeredAnimations=Object.create(null);this.register=function(d,c){if(d&&"."!==d.charAt(0))throw be("notcsel",d);var f=d+"-animation";b.$$registeredAnimations[d.substr(1)]=f;a.factory(f,c)};this.classNameFilter=function(a){if(1===arguments.length&&
(this.$$classNameFilter=a instanceof RegExp?a:null)&&/(\s+|\/)ng-animate(\s+|\/)/.test(this.$$classNameFilter.toString()))throw be("nongcls","ng-animate");return this.$$classNameFilter};this.$get=["$$animateQueue",function(a){function b(a,c,d){if(d){var h;a:{for(h=0;h<d.length;h++){var k=d[h];if(1===k.nodeType){h=k;break a}}h=void 0}!h||h.parentNode||h.previousElementSibling||(d=null)}d?d.after(a):c.prepend(a)}return{on:a.on,off:a.off,pin:a.pin,enabled:a.enabled,cancel:function(a){a.end&&a.end()},
enter:function(f,e,g,h){e=e&&D(e);g=g&&D(g);e=e||g.parent();b(f,e,g);return a.push(f,"enter",Aa(h))},move:function(f,e,g,h){e=e&&D(e);g=g&&D(g);e=e||g.parent();b(f,e,g);return a.push(f,"move",Aa(h))},leave:function(b,c){return a.push(b,"leave",Aa(c),function(){b.remove()})},addClass:function(b,c,g){g=Aa(g);g.addClass=jb(g.addclass,c);return a.push(b,"addClass",g)},removeClass:function(b,c,g){g=Aa(g);g.removeClass=jb(g.removeClass,c);return a.push(b,"removeClass",g)},setClass:function(b,c,g,h){h=Aa(h);
h.addClass=jb(h.addClass,c);h.removeClass=jb(h.removeClass,g);return a.push(b,"setClass",h)},animate:function(b,c,g,h,k){k=Aa(k);k.from=k.from?R(k.from,c):c;k.to=k.to?R(k.to,g):g;k.tempClasses=jb(k.tempClasses,h||"ng-inline-animate");return a.push(b,"animate",k)}}}]}],of=function(){this.$get=["$$rAF",function(a){function b(b){d.push(b);1<d.length||a(function(){for(var a=0;a<d.length;a++)d[a]();d=[]})}var d=[];return function(){var a=!1;b(function(){a=!0});return function(d){a?d():b(d)}}}]},nf=function(){this.$get=
["$q","$sniffer","$$animateAsyncRun","$$isDocumentHidden","$timeout",function(a,b,d,c,f){function e(a){this.setHost(a);var b=d();this._doneCallbacks=[];this._tick=function(a){c()?f(a,0,!1):b(a)};this._state=0}e.chain=function(a,b){function c(){if(d===a.length)b(!0);else a[d](function(a){!1===a?b(!1):(d++,c())})}var d=0;c()};e.all=function(a,b){function c(f){e=e&&f;++d===a.length&&b(e)}var d=0,e=!0;q(a,function(a){a.done(c)})};e.prototype={setHost:function(a){this.host=a||{}},done:function(a){2===
this._state?a():this._doneCallbacks.push(a)},progress:w,getPromise:function(){if(!this.promise){var b=this;this.promise=a(function(a,c){b.done(function(b){!1===b?c():a()})})}return this.promise},then:function(a,b){return this.getPromise().then(a,b)},"catch":function(a){return this.getPromise()["catch"](a)},"finally":function(a){return this.getPromise()["finally"](a)},pause:function(){this.host.pause&&this.host.pause()},resume:function(){this.host.resume&&this.host.resume()},end:function(){this.host.end&&
this.host.end();this._resolve(!0)},cancel:function(){this.host.cancel&&this.host.cancel();this._resolve(!1)},complete:function(a){var b=this;0===b._state&&(b._state=1,b._tick(function(){b._resolve(a)}))},_resolve:function(a){2!==this._state&&(q(this._doneCallbacks,function(b){b(a)}),this._doneCallbacks.length=0,this._state=2)}};return e}]},kf=function(){this.$get=["$$rAF","$q","$$AnimateRunner",function(a,b,d){return function(b,f){function e(){a(function(){g.addClass&&(b.addClass(g.addClass),g.addClass=
null);g.removeClass&&(b.removeClass(g.removeClass),g.removeClass=null);g.to&&(b.css(g.to),g.to=null);h||k.complete();h=!0});return k}var g=f||{};g.$$prepared||(g=Fa(g));g.cleanupStyles&&(g.from=g.to=null);g.from&&(b.css(g.from),g.from=null);var h,k=new d;return{start:e,end:e}}}]},ea=M("$compile"),hc=new function(){};Qc.$inject=["$provide","$$sanitizeUriProvider"];Ib.prototype.isFirstChange=function(){return this.previousValue===hc};var gd=/^((?:x|data)[:\-_])/i,mg=/[:\-_]+(.)/g,nd=M("$controller"),
md=/^(\S+)(\s+as\s+([\w$]+))?$/,vf=function(){this.$get=["$document",function(a){return function(b){b?!b.nodeType&&b instanceof D&&(b=b[0]):b=a[0].body;return b.offsetWidth+1}}]},od="application/json",kc={"Content-Type":od+";charset=utf-8"},pg=/^\[|^\{(?!\{)/,qg={"[":/]$/,"{":/}$/},og=/^\)]\}',?\n/,td=M("$http"),Ea=$.$interpolateMinErr=M("$interpolate");Ea.throwNoconcat=function(a){throw Ea("noconcat",a);};Ea.interr=function(a,b){return Ea("interr",a,b.toString())};var Df=function(){this.$get=["$window",
function(a){function b(a){var b=function(a){b.data=a;b.called=!0};b.id=a;return b}var d=a.angular.callbacks,c={};return{createCallback:function(a){a="_"+(d.$$counter++).toString(36);var e="angular.callbacks."+a,g=b(a);c[e]=d[a]=g;return e},wasCalled:function(a){return c[a].called},getResponse:function(a){return c[a].data},removeCallback:function(a){delete d[c[a].id];delete c[a]}}}]},Sg=/^([^?#]*)(\?([^#]*))?(#(.*))?$/,sg={http:80,https:443,ftp:21},lb=M("$location"),tg=/^\s*[\\/]{2,}/,Tg={$$absUrl:"",
$$html5:!1,$$replace:!1,absUrl:Jb("$$absUrl"),url:function(a){if(x(a))return this.$$url;var b=Sg.exec(a);(b[1]||""===a)&&this.path(decodeURIComponent(b[1]));(b[2]||b[1]||""===a)&&this.search(b[3]||"");this.hash(b[5]||"");return this},protocol:Jb("$$protocol"),host:Jb("$$host"),port:Jb("$$port"),path:xd("$$path",function(a){a=null!==a?a.toString():"";return"/"===a.charAt(0)?a:"/"+a}),search:function(a,b){switch(arguments.length){case 0:return this.$$search;case 1:if(E(a)||Y(a))a=a.toString(),this.$$search=
Lc(a);else if(F(a))a=Fa(a,{}),q(a,function(b,c){null==b&&delete a[c]}),this.$$search=a;else throw lb("isrcharg");break;default:x(b)||null===b?delete this.$$search[a]:this.$$search[a]=b}this.$$compose();return this},hash:xd("$$hash",function(a){return null!==a?a.toString():""}),replace:function(){this.$$replace=!0;return this}};q([wd,oc,nc],function(a){a.prototype=Object.create(Tg);a.prototype.state=function(b){if(!arguments.length)return this.$$state;if(a!==nc||!this.$$html5)throw lb("nostate");this.$$state=
x(b)?null:b;return this}});var Ua=M("$parse"),wg={}.constructor.prototype.valueOf,Qb=W();q("+ - * / % === !== == != < > <= >= && || ! = |".split(" "),function(a){Qb[a]=!0});var Ug={n:"\n",f:"\f",r:"\r",t:"\t",v:"\v","'":"'",'"':'"'},qc=function(a){this.options=a};qc.prototype={constructor:qc,lex:function(a){this.text=a;this.index=0;for(this.tokens=[];this.index<this.text.length;)if(a=this.text.charAt(this.index),'"'===a||"'"===a)this.readString(a);else if(this.isNumber(a)||"."===a&&this.isNumber(this.peek()))this.readNumber();
else if(this.isIdentifierStart(this.peekMultichar()))this.readIdent();else if(this.is(a,"(){}[].,;:?"))this.tokens.push({index:this.index,text:a}),this.index++;else if(this.isWhitespace(a))this.index++;else{var b=a+this.peek(),d=b+this.peek(2),c=Qb[b],f=Qb[d];Qb[a]||c||f?(a=f?d:c?b:a,this.tokens.push({index:this.index,text:a,operator:!0}),this.index+=a.length):this.throwError("Unexpected next character ",this.index,this.index+1)}return this.tokens},is:function(a,b){return-1!==b.indexOf(a)},peek:function(a){a=
a||1;return this.index+a<this.text.length?this.text.charAt(this.index+a):!1},isNumber:function(a){return"0"<=a&&"9">=a&&"string"===typeof a},isWhitespace:function(a){return" "===a||"\r"===a||"\t"===a||"\n"===a||"\v"===a||"\u00a0"===a},isIdentifierStart:function(a){return this.options.isIdentifierStart?this.options.isIdentifierStart(a,this.codePointAt(a)):this.isValidIdentifierStart(a)},isValidIdentifierStart:function(a){return"a"<=a&&"z">=a||"A"<=a&&"Z">=a||"_"===a||"$"===a},isIdentifierContinue:function(a){return this.options.isIdentifierContinue?
this.options.isIdentifierContinue(a,this.codePointAt(a)):this.isValidIdentifierContinue(a)},isValidIdentifierContinue:function(a,b){return this.isValidIdentifierStart(a,b)||this.isNumber(a)},codePointAt:function(a){return 1===a.length?a.charCodeAt(0):(a.charCodeAt(0)<<10)+a.charCodeAt(1)-56613888},peekMultichar:function(){var a=this.text.charAt(this.index),b=this.peek();if(!b)return a;var d=a.charCodeAt(0),c=b.charCodeAt(0);return 55296<=d&&56319>=d&&56320<=c&&57343>=c?a+b:a},isExpOperator:function(a){return"-"===
a||"+"===a||this.isNumber(a)},throwError:function(a,b,d){d=d||this.index;b=v(b)?"s "+b+"-"+this.index+" ["+this.text.substring(b,d)+"]":" "+d;throw Ua("lexerr",a,b,this.text);},readNumber:function(){for(var a="",b=this.index;this.index<this.text.length;){var d=P(this.text.charAt(this.index));if("."===d||this.isNumber(d))a+=d;else{var c=this.peek();if("e"===d&&this.isExpOperator(c))a+=d;else if(this.isExpOperator(d)&&c&&this.isNumber(c)&&"e"===a.charAt(a.length-1))a+=d;else if(!this.isExpOperator(d)||
c&&this.isNumber(c)||"e"!==a.charAt(a.length-1))break;else this.throwError("Invalid exponent")}this.index++}this.tokens.push({index:b,text:a,constant:!0,value:Number(a)})},readIdent:function(){var a=this.index;for(this.index+=this.peekMultichar().length;this.index<this.text.length;){var b=this.peekMultichar();if(!this.isIdentifierContinue(b))break;this.index+=b.length}this.tokens.push({index:a,text:this.text.slice(a,this.index),identifier:!0})},readString:function(a){var b=this.index;this.index++;
for(var d="",c=a,f=!1;this.index<this.text.length;){var e=this.text.charAt(this.index),c=c+e;if(f)"u"===e?(f=this.text.substring(this.index+1,this.index+5),f.match(/[\da-f]{4}/i)||this.throwError("Invalid unicode escape [\\u"+f+"]"),this.index+=4,d+=String.fromCharCode(parseInt(f,16))):d+=Ug[e]||e,f=!1;else if("\\"===e)f=!0;else{if(e===a){this.index++;this.tokens.push({index:b,text:c,constant:!0,value:d});return}d+=e}this.index++}this.throwError("Unterminated quote",b)}};var s=function(a,b){this.lexer=
a;this.options=b};s.Program="Program";s.ExpressionStatement="ExpressionStatement";s.AssignmentExpression="AssignmentExpression";s.ConditionalExpression="ConditionalExpression";s.LogicalExpression="LogicalExpression";s.BinaryExpression="BinaryExpression";s.UnaryExpression="UnaryExpression";s.CallExpression="CallExpression";s.MemberExpression="MemberExpression";s.Identifier="Identifier";s.Literal="Literal";s.ArrayExpression="ArrayExpression";s.Property="Property";s.ObjectExpression="ObjectExpression";
s.ThisExpression="ThisExpression";s.LocalsExpression="LocalsExpression";s.NGValueParameter="NGValueParameter";s.prototype={ast:function(a){this.text=a;this.tokens=this.lexer.lex(a);a=this.program();0!==this.tokens.length&&this.throwError("is an unexpected token",this.tokens[0]);return a},program:function(){for(var a=[];;)if(0<this.tokens.length&&!this.peek("}",")",";","]")&&a.push(this.expressionStatement()),!this.expect(";"))return{type:s.Program,body:a}},expressionStatement:function(){return{type:s.ExpressionStatement,
expression:this.filterChain()}},filterChain:function(){for(var a=this.expression();this.expect("|");)a=this.filter(a);return a},expression:function(){return this.assignment()},assignment:function(){var a=this.ternary();if(this.expect("=")){if(!Ad(a))throw Ua("lval");a={type:s.AssignmentExpression,left:a,right:this.assignment(),operator:"="}}return a},ternary:function(){var a=this.logicalOR(),b,d;return this.expect("?")&&(b=this.expression(),this.consume(":"))?(d=this.expression(),{type:s.ConditionalExpression,
test:a,alternate:b,consequent:d}):a},logicalOR:function(){for(var a=this.logicalAND();this.expect("||");)a={type:s.LogicalExpression,operator:"||",left:a,right:this.logicalAND()};return a},logicalAND:function(){for(var a=this.equality();this.expect("&&");)a={type:s.LogicalExpression,operator:"&&",left:a,right:this.equality()};return a},equality:function(){for(var a=this.relational(),b;b=this.expect("==","!=","===","!==");)a={type:s.BinaryExpression,operator:b.text,left:a,right:this.relational()};
return a},relational:function(){for(var a=this.additive(),b;b=this.expect("<",">","<=",">=");)a={type:s.BinaryExpression,operator:b.text,left:a,right:this.additive()};return a},additive:function(){for(var a=this.multiplicative(),b;b=this.expect("+","-");)a={type:s.BinaryExpression,operator:b.text,left:a,right:this.multiplicative()};return a},multiplicative:function(){for(var a=this.unary(),b;b=this.expect("*","/","%");)a={type:s.BinaryExpression,operator:b.text,left:a,right:this.unary()};return a},
unary:function(){var a;return(a=this.expect("+","-","!"))?{type:s.UnaryExpression,operator:a.text,prefix:!0,argument:this.unary()}:this.primary()},primary:function(){var a;this.expect("(")?(a=this.filterChain(),this.consume(")")):this.expect("[")?a=this.arrayDeclaration():this.expect("{")?a=this.object():this.selfReferential.hasOwnProperty(this.peek().text)?a=Fa(this.selfReferential[this.consume().text]):this.options.literals.hasOwnProperty(this.peek().text)?a={type:s.Literal,value:this.options.literals[this.consume().text]}:
this.peek().identifier?a=this.identifier():this.peek().constant?a=this.constant():this.throwError("not a primary expression",this.peek());for(var b;b=this.expect("(","[",".");)"("===b.text?(a={type:s.CallExpression,callee:a,arguments:this.parseArguments()},this.consume(")")):"["===b.text?(a={type:s.MemberExpression,object:a,property:this.expression(),computed:!0},this.consume("]")):"."===b.text?a={type:s.MemberExpression,object:a,property:this.identifier(),computed:!1}:this.throwError("IMPOSSIBLE");
return a},filter:function(a){a=[a];for(var b={type:s.CallExpression,callee:this.identifier(),arguments:a,filter:!0};this.expect(":");)a.push(this.expression());return b},parseArguments:function(){var a=[];if(")"!==this.peekToken().text){do a.push(this.filterChain());while(this.expect(","))}return a},identifier:function(){var a=this.consume();a.identifier||this.throwError("is not a valid identifier",a);return{type:s.Identifier,name:a.text}},constant:function(){return{type:s.Literal,value:this.consume().value}},
arrayDeclaration:function(){var a=[];if("]"!==this.peekToken().text){do{if(this.peek("]"))break;a.push(this.expression())}while(this.expect(","))}this.consume("]");return{type:s.ArrayExpression,elements:a}},object:function(){var a=[],b;if("}"!==this.peekToken().text){do{if(this.peek("}"))break;b={type:s.Property,kind:"init"};this.peek().constant?(b.key=this.constant(),b.computed=!1,this.consume(":"),b.value=this.expression()):this.peek().identifier?(b.key=this.identifier(),b.computed=!1,this.peek(":")?
(this.consume(":"),b.value=this.expression()):b.value=b.key):this.peek("[")?(this.consume("["),b.key=this.expression(),this.consume("]"),b.computed=!0,this.consume(":"),b.value=this.expression()):this.throwError("invalid key",this.peek());a.push(b)}while(this.expect(","))}this.consume("}");return{type:s.ObjectExpression,properties:a}},throwError:function(a,b){throw Ua("syntax",b.text,a,b.index+1,this.text,this.text.substring(b.index));},consume:function(a){if(0===this.tokens.length)throw Ua("ueoe",
this.text);var b=this.expect(a);b||this.throwError("is unexpected, expecting ["+a+"]",this.peek());return b},peekToken:function(){if(0===this.tokens.length)throw Ua("ueoe",this.text);return this.tokens[0]},peek:function(a,b,d,c){return this.peekAhead(0,a,b,d,c)},peekAhead:function(a,b,d,c,f){if(this.tokens.length>a){a=this.tokens[a];var e=a.text;if(e===b||e===d||e===c||e===f||!(b||d||c||f))return a}return!1},expect:function(a,b,d,c){return(a=this.peek(a,b,d,c))?(this.tokens.shift(),a):!1},selfReferential:{"this":{type:s.ThisExpression},
$locals:{type:s.LocalsExpression}}};Dd.prototype={compile:function(a){var b=this;a=this.astBuilder.ast(a);this.state={nextId:0,filters:{},fn:{vars:[],body:[],own:{}},assign:{vars:[],body:[],own:{}},inputs:[]};V(a,b.$filter);var d="",c;this.stage="assign";if(c=Bd(a))this.state.computing="assign",d=this.nextId(),this.recurse(c,d),this.return_(d),d="fn.assign="+this.generateFunction("assign","s,v,l");c=zd(a.body);b.stage="inputs";q(c,function(a,c){var d="fn"+c;b.state[d]={vars:[],body:[],own:{}};b.state.computing=
d;var h=b.nextId();b.recurse(a,h);b.return_(h);b.state.inputs.push(d);a.watchId=c});this.state.computing="fn";this.stage="main";this.recurse(a);d='"'+this.USE+" "+this.STRICT+'";\n'+this.filterPrefix()+"var fn="+this.generateFunction("fn","s,l,a,i")+d+this.watchFns()+"return fn;";d=(new Function("$filter","getStringValue","ifDefined","plus",d))(this.$filter,ug,vg,yd);this.state=this.stage=void 0;d.literal=Cd(a);d.constant=a.constant;return d},USE:"use",STRICT:"strict",watchFns:function(){var a=[],
b=this.state.inputs,d=this;q(b,function(b){a.push("var "+b+"="+d.generateFunction(b,"s"))});b.length&&a.push("fn.inputs=["+b.join(",")+"];");return a.join("")},generateFunction:function(a,b){return"function("+b+"){"+this.varsPrefix(a)+this.body(a)+"};"},filterPrefix:function(){var a=[],b=this;q(this.state.filters,function(d,c){a.push(d+"=$filter("+b.escape(c)+")")});return a.length?"var "+a.join(",")+";":""},varsPrefix:function(a){return this.state[a].vars.length?"var "+this.state[a].vars.join(",")+
";":""},body:function(a){return this.state[a].body.join("")},recurse:function(a,b,d,c,f,e){var g,h,k=this,l,m,n;c=c||w;if(!e&&v(a.watchId))b=b||this.nextId(),this.if_("i",this.lazyAssign(b,this.computedMember("i",a.watchId)),this.lazyRecurse(a,b,d,c,f,!0));else switch(a.type){case s.Program:q(a.body,function(b,c){k.recurse(b.expression,void 0,void 0,function(a){h=a});c!==a.body.length-1?k.current().body.push(h,";"):k.return_(h)});break;case s.Literal:m=this.escape(a.value);this.assign(b,m);c(b||m);
break;case s.UnaryExpression:this.recurse(a.argument,void 0,void 0,function(a){h=a});m=a.operator+"("+this.ifDefined(h,0)+")";this.assign(b,m);c(m);break;case s.BinaryExpression:this.recurse(a.left,void 0,void 0,function(a){g=a});this.recurse(a.right,void 0,void 0,function(a){h=a});m="+"===a.operator?this.plus(g,h):"-"===a.operator?this.ifDefined(g,0)+a.operator+this.ifDefined(h,0):"("+g+")"+a.operator+"("+h+")";this.assign(b,m);c(m);break;case s.LogicalExpression:b=b||this.nextId();k.recurse(a.left,
b);k.if_("&&"===a.operator?b:k.not(b),k.lazyRecurse(a.right,b));c(b);break;case s.ConditionalExpression:b=b||this.nextId();k.recurse(a.test,b);k.if_(b,k.lazyRecurse(a.alternate,b),k.lazyRecurse(a.consequent,b));c(b);break;case s.Identifier:b=b||this.nextId();d&&(d.context="inputs"===k.stage?"s":this.assign(this.nextId(),this.getHasOwnProperty("l",a.name)+"?l:s"),d.computed=!1,d.name=a.name);k.if_("inputs"===k.stage||k.not(k.getHasOwnProperty("l",a.name)),function(){k.if_("inputs"===k.stage||"s",function(){f&&
1!==f&&k.if_(k.isNull(k.nonComputedMember("s",a.name)),k.lazyAssign(k.nonComputedMember("s",a.name),"{}"));k.assign(b,k.nonComputedMember("s",a.name))})},b&&k.lazyAssign(b,k.nonComputedMember("l",a.name)));c(b);break;case s.MemberExpression:g=d&&(d.context=this.nextId())||this.nextId();b=b||this.nextId();k.recurse(a.object,g,void 0,function(){k.if_(k.notNull(g),function(){a.computed?(h=k.nextId(),k.recurse(a.property,h),k.getStringValue(h),f&&1!==f&&k.if_(k.not(k.computedMember(g,h)),k.lazyAssign(k.computedMember(g,
h),"{}")),m=k.computedMember(g,h),k.assign(b,m),d&&(d.computed=!0,d.name=h)):(f&&1!==f&&k.if_(k.isNull(k.nonComputedMember(g,a.property.name)),k.lazyAssign(k.nonComputedMember(g,a.property.name),"{}")),m=k.nonComputedMember(g,a.property.name),k.assign(b,m),d&&(d.computed=!1,d.name=a.property.name))},function(){k.assign(b,"undefined")});c(b)},!!f);break;case s.CallExpression:b=b||this.nextId();a.filter?(h=k.filter(a.callee.name),l=[],q(a.arguments,function(a){var b=k.nextId();k.recurse(a,b);l.push(b)}),
m=h+"("+l.join(",")+")",k.assign(b,m),c(b)):(h=k.nextId(),g={},l=[],k.recurse(a.callee,h,g,function(){k.if_(k.notNull(h),function(){q(a.arguments,function(b){k.recurse(b,a.constant?void 0:k.nextId(),void 0,function(a){l.push(a)})});m=g.name?k.member(g.context,g.name,g.computed)+"("+l.join(",")+")":h+"("+l.join(",")+")";k.assign(b,m)},function(){k.assign(b,"undefined")});c(b)}));break;case s.AssignmentExpression:h=this.nextId();g={};this.recurse(a.left,void 0,g,function(){k.if_(k.notNull(g.context),
function(){k.recurse(a.right,h);m=k.member(g.context,g.name,g.computed)+a.operator+h;k.assign(b,m);c(b||m)})},1);break;case s.ArrayExpression:l=[];q(a.elements,function(b){k.recurse(b,a.constant?void 0:k.nextId(),void 0,function(a){l.push(a)})});m="["+l.join(",")+"]";this.assign(b,m);c(b||m);break;case s.ObjectExpression:l=[];n=!1;q(a.properties,function(a){a.computed&&(n=!0)});n?(b=b||this.nextId(),this.assign(b,"{}"),q(a.properties,function(a){a.computed?(g=k.nextId(),k.recurse(a.key,g)):g=a.key.type===
s.Identifier?a.key.name:""+a.key.value;h=k.nextId();k.recurse(a.value,h);k.assign(k.member(b,g,a.computed),h)})):(q(a.properties,function(b){k.recurse(b.value,a.constant?void 0:k.nextId(),void 0,function(a){l.push(k.escape(b.key.type===s.Identifier?b.key.name:""+b.key.value)+":"+a)})}),m="{"+l.join(",")+"}",this.assign(b,m));c(b||m);break;case s.ThisExpression:this.assign(b,"s");c(b||"s");break;case s.LocalsExpression:this.assign(b,"l");c(b||"l");break;case s.NGValueParameter:this.assign(b,"v"),c(b||
"v")}},getHasOwnProperty:function(a,b){var d=a+"."+b,c=this.current().own;c.hasOwnProperty(d)||(c[d]=this.nextId(!1,a+"&&("+this.escape(b)+" in "+a+")"));return c[d]},assign:function(a,b){if(a)return this.current().body.push(a,"=",b,";"),a},filter:function(a){this.state.filters.hasOwnProperty(a)||(this.state.filters[a]=this.nextId(!0));return this.state.filters[a]},ifDefined:function(a,b){return"ifDefined("+a+","+this.escape(b)+")"},plus:function(a,b){return"plus("+a+","+b+")"},return_:function(a){this.current().body.push("return ",
a,";")},if_:function(a,b,d){if(!0===a)b();else{var c=this.current().body;c.push("if(",a,"){");b();c.push("}");d&&(c.push("else{"),d(),c.push("}"))}},not:function(a){return"!("+a+")"},isNull:function(a){return a+"==null"},notNull:function(a){return a+"!=null"},nonComputedMember:function(a,b){var d=/[^$_a-zA-Z0-9]/g;return/^[$_a-zA-Z][$_a-zA-Z0-9]*$/.test(b)?a+"."+b:a+'["'+b.replace(d,this.stringEscapeFn)+'"]'},computedMember:function(a,b){return a+"["+b+"]"},member:function(a,b,d){return d?this.computedMember(a,
b):this.nonComputedMember(a,b)},getStringValue:function(a){this.assign(a,"getStringValue("+a+")")},lazyRecurse:function(a,b,d,c,f,e){var g=this;return function(){g.recurse(a,b,d,c,f,e)}},lazyAssign:function(a,b){var d=this;return function(){d.assign(a,b)}},stringEscapeRegex:/[^ a-zA-Z0-9]/g,stringEscapeFn:function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)},escape:function(a){if(E(a))return"'"+a.replace(this.stringEscapeRegex,this.stringEscapeFn)+"'";if(Y(a))return a.toString();
if(!0===a)return"true";if(!1===a)return"false";if(null===a)return"null";if("undefined"===typeof a)return"undefined";throw Ua("esc");},nextId:function(a,b){var d="v"+this.state.nextId++;a||this.current().vars.push(d+(b?"="+b:""));return d},current:function(){return this.state[this.state.computing]}};Ed.prototype={compile:function(a){var b=this;a=this.astBuilder.ast(a);V(a,b.$filter);var d,c;if(d=Bd(a))c=this.recurse(d);d=zd(a.body);var f;d&&(f=[],q(d,function(a,c){var d=b.recurse(a);a.input=d;f.push(d);
a.watchId=c}));var e=[];q(a.body,function(a){e.push(b.recurse(a.expression))});d=0===a.body.length?w:1===a.body.length?e[0]:function(a,b){var c;q(e,function(d){c=d(a,b)});return c};c&&(d.assign=function(a,b,d){return c(a,d,b)});f&&(d.inputs=f);d.literal=Cd(a);d.constant=a.constant;return d},recurse:function(a,b,d){var c,f,e=this,g;if(a.input)return this.inputs(a.input,a.watchId);switch(a.type){case s.Literal:return this.value(a.value,b);case s.UnaryExpression:return f=this.recurse(a.argument),this["unary"+
a.operator](f,b);case s.BinaryExpression:return c=this.recurse(a.left),f=this.recurse(a.right),this["binary"+a.operator](c,f,b);case s.LogicalExpression:return c=this.recurse(a.left),f=this.recurse(a.right),this["binary"+a.operator](c,f,b);case s.ConditionalExpression:return this["ternary?:"](this.recurse(a.test),this.recurse(a.alternate),this.recurse(a.consequent),b);case s.Identifier:return e.identifier(a.name,b,d);case s.MemberExpression:return c=this.recurse(a.object,!1,!!d),a.computed||(f=a.property.name),
a.computed&&(f=this.recurse(a.property)),a.computed?this.computedMember(c,f,b,d):this.nonComputedMember(c,f,b,d);case s.CallExpression:return g=[],q(a.arguments,function(a){g.push(e.recurse(a))}),a.filter&&(f=this.$filter(a.callee.name)),a.filter||(f=this.recurse(a.callee,!0)),a.filter?function(a,c,d,e){for(var n=[],p=0;p<g.length;++p)n.push(g[p](a,c,d,e));a=f.apply(void 0,n,e);return b?{context:void 0,name:void 0,value:a}:a}:function(a,c,d,e){var n=f(a,c,d,e),p;if(null!=n.value){p=[];for(var r=0;r<
g.length;++r)p.push(g[r](a,c,d,e));p=n.value.apply(n.context,p)}return b?{value:p}:p};case s.AssignmentExpression:return c=this.recurse(a.left,!0,1),f=this.recurse(a.right),function(a,d,e,g){var n=c(a,d,e,g);a=f(a,d,e,g);n.context[n.name]=a;return b?{value:a}:a};case s.ArrayExpression:return g=[],q(a.elements,function(a){g.push(e.recurse(a))}),function(a,c,d,e){for(var f=[],p=0;p<g.length;++p)f.push(g[p](a,c,d,e));return b?{value:f}:f};case s.ObjectExpression:return g=[],q(a.properties,function(a){a.computed?
g.push({key:e.recurse(a.key),computed:!0,value:e.recurse(a.value)}):g.push({key:a.key.type===s.Identifier?a.key.name:""+a.key.value,computed:!1,value:e.recurse(a.value)})}),function(a,c,d,e){for(var f={},p=0;p<g.length;++p)g[p].computed?f[g[p].key(a,c,d,e)]=g[p].value(a,c,d,e):f[g[p].key]=g[p].value(a,c,d,e);return b?{value:f}:f};case s.ThisExpression:return function(a){return b?{value:a}:a};case s.LocalsExpression:return function(a,c){return b?{value:c}:c};case s.NGValueParameter:return function(a,
c,d){return b?{value:d}:d}}},"unary+":function(a,b){return function(d,c,f,e){d=a(d,c,f,e);d=v(d)?+d:0;return b?{value:d}:d}},"unary-":function(a,b){return function(d,c,f,e){d=a(d,c,f,e);d=v(d)?-d:-0;return b?{value:d}:d}},"unary!":function(a,b){return function(d,c,f,e){d=!a(d,c,f,e);return b?{value:d}:d}},"binary+":function(a,b,d){return function(c,f,e,g){var h=a(c,f,e,g);c=b(c,f,e,g);h=yd(h,c);return d?{value:h}:h}},"binary-":function(a,b,d){return function(c,f,e,g){var h=a(c,f,e,g);c=b(c,f,e,g);
h=(v(h)?h:0)-(v(c)?c:0);return d?{value:h}:h}},"binary*":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)*b(c,f,e,g);return d?{value:c}:c}},"binary/":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)/b(c,f,e,g);return d?{value:c}:c}},"binary%":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)%b(c,f,e,g);return d?{value:c}:c}},"binary===":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)===b(c,f,e,g);return d?{value:c}:c}},"binary!==":function(a,b,d){return function(c,f,e,g){c=a(c,
f,e,g)!==b(c,f,e,g);return d?{value:c}:c}},"binary==":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)==b(c,f,e,g);return d?{value:c}:c}},"binary!=":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)!=b(c,f,e,g);return d?{value:c}:c}},"binary<":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)<b(c,f,e,g);return d?{value:c}:c}},"binary>":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)>b(c,f,e,g);return d?{value:c}:c}},"binary<=":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,
g)<=b(c,f,e,g);return d?{value:c}:c}},"binary>=":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)>=b(c,f,e,g);return d?{value:c}:c}},"binary&&":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)&&b(c,f,e,g);return d?{value:c}:c}},"binary||":function(a,b,d){return function(c,f,e,g){c=a(c,f,e,g)||b(c,f,e,g);return d?{value:c}:c}},"ternary?:":function(a,b,d,c){return function(f,e,g,h){f=a(f,e,g,h)?b(f,e,g,h):d(f,e,g,h);return c?{value:f}:f}},value:function(a,b){return function(){return b?{context:void 0,
name:void 0,value:a}:a}},identifier:function(a,b,d){return function(c,f,e,g){c=f&&a in f?f:c;d&&1!==d&&c&&null==c[a]&&(c[a]={});f=c?c[a]:void 0;return b?{context:c,name:a,value:f}:f}},computedMember:function(a,b,d,c){return function(f,e,g,h){var k=a(f,e,g,h),l,m;null!=k&&(l=b(f,e,g,h),l+="",c&&1!==c&&k&&!k[l]&&(k[l]={}),m=k[l]);return d?{context:k,name:l,value:m}:m}},nonComputedMember:function(a,b,d,c){return function(f,e,g,h){f=a(f,e,g,h);c&&1!==c&&f&&null==f[b]&&(f[b]={});e=null!=f?f[b]:void 0;
return d?{context:f,name:b,value:e}:e}},inputs:function(a,b){return function(d,c,f,e){return e?e[b]:a(d,c,f)}}};var rc=function(a,b,d){this.lexer=a;this.$filter=b;this.options=d;this.ast=new s(a,d);this.astCompiler=d.csp?new Ed(this.ast,b):new Dd(this.ast,b)};rc.prototype={constructor:rc,parse:function(a){return this.astCompiler.compile(a)}};var ua=M("$sce"),pa={HTML:"html",CSS:"css",URL:"url",RESOURCE_URL:"resourceUrl",JS:"js"},sc=/_([a-z])/g,yg=M("$compile"),ca=z.document.createElement("a"),Id=
Da(z.location.href);Jd.$inject=["$document"];Xc.$inject=["$provide"];var Qd=22,Pd=".",uc="0";Kd.$inject=["$locale"];Md.$inject=["$locale"];var Jg={yyyy:aa("FullYear",4,0,!1,!0),yy:aa("FullYear",2,0,!0,!0),y:aa("FullYear",1,0,!1,!0),MMMM:nb("Month"),MMM:nb("Month",!0),MM:aa("Month",2,1),M:aa("Month",1,1),LLLL:nb("Month",!1,!0),dd:aa("Date",2),d:aa("Date",1),HH:aa("Hours",2),H:aa("Hours",1),hh:aa("Hours",2,-12),h:aa("Hours",1,-12),mm:aa("Minutes",2),m:aa("Minutes",1),ss:aa("Seconds",2),s:aa("Seconds",
1),sss:aa("Milliseconds",3),EEEE:nb("Day"),EEE:nb("Day",!0),a:function(a,b){return 12>a.getHours()?b.AMPMS[0]:b.AMPMS[1]},Z:function(a,b,d){a=-1*d;return a=(0<=a?"+":"")+(Kb(Math[0<a?"floor":"ceil"](a/60),2)+Kb(Math.abs(a%60),2))},ww:Sd(2),w:Sd(1),G:vc,GG:vc,GGG:vc,GGGG:function(a,b){return 0>=a.getFullYear()?b.ERANAMES[0]:b.ERANAMES[1]}},Ig=/((?:[^yMLdHhmsaZEwG']+)|(?:'(?:[^']|'')*')|(?:E+|y+|M+|L+|d+|H+|h+|m+|s+|a|Z|G+|w+))(.*)/,Hg=/^-?\d+$/;Ld.$inject=["$locale"];var Cg=ma(P),Dg=ma(vb);Nd.$inject=
["$parse"];var Ae=ma({restrict:"E",compile:function(a,b){if(!b.href&&!b.xlinkHref)return function(a,b){if("a"===b[0].nodeName.toLowerCase()){var f="[object SVGAnimatedString]"===na.call(b.prop("href"))?"xlink:href":"href";b.on("click",function(a){b.attr(f)||a.preventDefault()})}}}}),wb={};q(Gb,function(a,b){function d(a,d,f){a.$watch(f[c],function(a){f.$set(b,!!a)})}if("multiple"!==a){var c=Ca("ng-"+b),f=d;"checked"===a&&(f=function(a,b,f){f.ngModel!==f[c]&&d(a,b,f)});wb[c]=function(){return{restrict:"A",
priority:100,link:f}}}});q(ld,function(a,b){wb[b]=function(){return{priority:100,link:function(a,c,f){if("ngPattern"===b&&"/"===f.ngPattern.charAt(0)&&(c=f.ngPattern.match(Ng))){f.$set("ngPattern",new RegExp(c[1],c[2]));return}a.$watch(f[b],function(a){f.$set(b,a)})}}}});q(["src","srcset","href"],function(a){var b=Ca("ng-"+a);wb[b]=function(){return{priority:99,link:function(d,c,f){var e=a,g=a;"href"===a&&"[object SVGAnimatedString]"===na.call(c.prop("href"))&&(g="xlinkHref",f.$attr[g]="xlink:href",
e=null);f.$observe(b,function(b){b?(f.$set(g,b),La&&e&&c.prop(e,f[g])):"href"===a&&f.$set(g,null)})}}}});var Mb={$addControl:w,$$renameControl:function(a,b){a.$name=b},$removeControl:w,$setValidity:w,$setDirty:w,$setPristine:w,$setSubmitted:w};Lb.$inject=["$element","$attrs","$scope","$animate","$interpolate"];Lb.prototype={$rollbackViewValue:function(){q(this.$$controls,function(a){a.$rollbackViewValue()})},$commitViewValue:function(){q(this.$$controls,function(a){a.$commitViewValue()})},$addControl:function(a){Pa(a.$name,
"input");this.$$controls.push(a);a.$name&&(this[a.$name]=a);a.$$parentForm=this},$$renameControl:function(a,b){var d=a.$name;this[d]===a&&delete this[d];this[b]=a;a.$name=b},$removeControl:function(a){a.$name&&this[a.$name]===a&&delete this[a.$name];q(this.$pending,function(b,d){this.$setValidity(d,null,a)},this);q(this.$error,function(b,d){this.$setValidity(d,null,a)},this);q(this.$$success,function(b,d){this.$setValidity(d,null,a)},this);$a(this.$$controls,a);a.$$parentForm=Mb},$setDirty:function(){this.$$animate.removeClass(this.$$element,
Va);this.$$animate.addClass(this.$$element,Rb);this.$dirty=!0;this.$pristine=!1;this.$$parentForm.$setDirty()},$setPristine:function(){this.$$animate.setClass(this.$$element,Va,Rb+" ng-submitted");this.$dirty=!1;this.$pristine=!0;this.$submitted=!1;q(this.$$controls,function(a){a.$setPristine()})},$setUntouched:function(){q(this.$$controls,function(a){a.$setUntouched()})},$setSubmitted:function(){this.$$animate.addClass(this.$$element,"ng-submitted");this.$submitted=!0;this.$$parentForm.$setSubmitted()}};
Vd({clazz:Lb,set:function(a,b,d){var c=a[b];c?-1===c.indexOf(d)&&c.push(d):a[b]=[d]},unset:function(a,b,d){var c=a[b];c&&($a(c,d),0===c.length&&delete a[b])}});var ce=function(a){return["$timeout","$parse",function(b,d){function c(a){return""===a?d('this[""]').assign:d(a).assign||w}return{name:"form",restrict:a?"EAC":"E",require:["form","^^?form"],controller:Lb,compile:function(d,e){d.addClass(Va).addClass(ob);var g=e.name?"name":a&&e.ngForm?"ngForm":!1;return{pre:function(a,d,e,f){var n=f[0];if(!("action"in
e)){var p=function(b){a.$apply(function(){n.$commitViewValue();n.$setSubmitted()});b.preventDefault()};d[0].addEventListener("submit",p);d.on("$destroy",function(){b(function(){d[0].removeEventListener("submit",p)},0,!1)})}(f[1]||n.$$parentForm).$addControl(n);var r=g?c(n.$name):w;g&&(r(a,n),e.$observe(g,function(b){n.$name!==b&&(r(a,void 0),n.$$parentForm.$$renameControl(n,b),r=c(n.$name),r(a,n))}));d.on("$destroy",function(){n.$$parentForm.$removeControl(n);r(a,void 0);R(n,Mb)})}}}}}]},Be=ce(),
Ne=ce(!0),Kg=/^\d{4,}-[01]\d-[0-3]\dT[0-2]\d:[0-5]\d:[0-5]\d\.\d+(?:[+-][0-2]\d:[0-5]\d|Z)$/,Vg=/^[a-z][a-z\d.+-]*:\/*(?:[^:@]+(?::[^@]+)?@)?(?:[^\s:/?#]+|\[[a-f\d:]+])(?::\d+)?(?:\/[^?#]*)?(?:\?[^#]*)?(?:#.*)?$/i,Wg=/^(?=.{1,254}$)(?=.{1,64}@)[-!#$%&'*+/0-9=?A-Z^_`a-z{|}~]+(\.[-!#$%&'*+/0-9=?A-Z^_`a-z{|}~]+)*@[A-Za-z0-9]([A-Za-z0-9-]{0,61}[A-Za-z0-9])?(\.[A-Za-z0-9]([A-Za-z0-9-]{0,61}[A-Za-z0-9])?)*$/,Lg=/^\s*(-|\+)?(\d+|(\d*(\.\d*)))([eE][+-]?\d+)?\s*$/,de=/^(\d{4,})-(\d{2})-(\d{2})$/,ee=/^(\d{4,})-(\d\d)-(\d\d)T(\d\d):(\d\d)(?::(\d\d)(\.\d{1,3})?)?$/,
Cc=/^(\d{4,})-W(\d\d)$/,fe=/^(\d{4,})-(\d\d)$/,ge=/^(\d\d):(\d\d)(?::(\d\d)(\.\d{1,3})?)?$/,Xd=W();q(["date","datetime-local","month","time","week"],function(a){Xd[a]=!0});var he={text:function(a,b,d,c,f,e){Sa(a,b,d,c,f,e);xc(c)},date:pb("date",de,Nb(de,["yyyy","MM","dd"]),"yyyy-MM-dd"),"datetime-local":pb("datetimelocal",ee,Nb(ee,"yyyy MM dd HH mm ss sss".split(" ")),"yyyy-MM-ddTHH:mm:ss.sss"),time:pb("time",ge,Nb(ge,["HH","mm","ss","sss"]),"HH:mm:ss.sss"),week:pb("week",Cc,function(a,b){if(fa(a))return a;
if(E(a)){Cc.lastIndex=0;var d=Cc.exec(a);if(d){var c=+d[1],f=+d[2],e=d=0,g=0,h=0,k=Rd(c),f=7*(f-1);b&&(d=b.getHours(),e=b.getMinutes(),g=b.getSeconds(),h=b.getMilliseconds());return new Date(c,0,k.getDate()+f,d,e,g,h)}}return NaN},"yyyy-Www"),month:pb("month",fe,Nb(fe,["yyyy","MM"]),"yyyy-MM"),number:function(a,b,d,c,f,e){yc(a,b,d,c);Yd(c);Sa(a,b,d,c,f,e);var g,h;if(v(d.min)||d.ngMin)c.$validators.min=function(a){return c.$isEmpty(a)||x(g)||a>=g},d.$observe("min",function(a){g=Ta(a);c.$validate()});
if(v(d.max)||d.ngMax)c.$validators.max=function(a){return c.$isEmpty(a)||x(h)||a<=h},d.$observe("max",function(a){h=Ta(a);c.$validate()});if(v(d.step)||d.ngStep){var k;c.$validators.step=function(a,b){return c.$isEmpty(b)||x(k)||Zd(b,g||0,k)};d.$observe("step",function(a){k=Ta(a);c.$validate()})}},url:function(a,b,d,c,f,e){Sa(a,b,d,c,f,e);xc(c);c.$$parserName="url";c.$validators.url=function(a,b){var d=a||b;return c.$isEmpty(d)||Vg.test(d)}},email:function(a,b,d,c,f,e){Sa(a,b,d,c,f,e);xc(c);c.$$parserName=
"email";c.$validators.email=function(a,b){var d=a||b;return c.$isEmpty(d)||Wg.test(d)}},radio:function(a,b,d,c){var f=!d.ngTrim||"false"!==S(d.ngTrim);x(d.name)&&b.attr("name",++rb);b.on("click",function(a){var g;b[0].checked&&(g=d.value,f&&(g=S(g)),c.$setViewValue(g,a&&a.type))});c.$render=function(){var a=d.value;f&&(a=S(a));b[0].checked=a===c.$viewValue};d.$observe("value",c.$render)},range:function(a,b,d,c,f,e){function g(a,c){b.attr(a,d[a]);d.$observe(a,c)}function h(a){n=Ta(a);ga(c.$modelValue)||
(m?(a=b.val(),n>a&&(a=n,b.val(a)),c.$setViewValue(a)):c.$validate())}function k(a){p=Ta(a);ga(c.$modelValue)||(m?(a=b.val(),p<a&&(b.val(p),a=p<n?n:p),c.$setViewValue(a)):c.$validate())}function l(a){r=Ta(a);ga(c.$modelValue)||(m&&c.$viewValue!==b.val()?c.$setViewValue(b.val()):c.$validate())}yc(a,b,d,c);Yd(c);Sa(a,b,d,c,f,e);var m=c.$$hasNativeValidators&&"range"===b[0].type,n=m?0:void 0,p=m?100:void 0,r=m?1:void 0,q=b[0].validity;a=v(d.min);f=v(d.max);e=v(d.step);var s=c.$render;c.$render=m&&v(q.rangeUnderflow)&&
v(q.rangeOverflow)?function(){s();c.$setViewValue(b.val())}:s;a&&(c.$validators.min=m?function(){return!0}:function(a,b){return c.$isEmpty(b)||x(n)||b>=n},g("min",h));f&&(c.$validators.max=m?function(){return!0}:function(a,b){return c.$isEmpty(b)||x(p)||b<=p},g("max",k));e&&(c.$validators.step=m?function(){return!q.stepMismatch}:function(a,b){return c.$isEmpty(b)||x(r)||Zd(b,n||0,r)},g("step",l))},checkbox:function(a,b,d,c,f,e,g,h){var k=$d(h,a,"ngTrueValue",d.ngTrueValue,!0),l=$d(h,a,"ngFalseValue",
d.ngFalseValue,!1);b.on("click",function(a){c.$setViewValue(b[0].checked,a&&a.type)});c.$render=function(){b[0].checked=c.$viewValue};c.$isEmpty=function(a){return!1===a};c.$formatters.push(function(a){return qa(a,k)});c.$parsers.push(function(a){return a?k:l})},hidden:w,button:w,submit:w,reset:w,file:w},Rc=["$browser","$sniffer","$filter","$parse",function(a,b,d,c){return{restrict:"E",require:["?ngModel"],link:{pre:function(f,e,g,h){h[0]&&(he[P(g.type)]||he.text)(f,e,g,h[0],b,a,d,c)}}}}],Xg=/^(true|false|\d+)$/,
ef=function(){return{restrict:"A",priority:100,compile:function(a,b){return Xg.test(b.ngValue)?function(a,b,f){a=a.$eval(f.ngValue);b.prop("value",a);f.$set("value",a)}:function(a,b,f){a.$watch(f.ngValue,function(a){b.prop("value",a);f.$set("value",a)})}}}},Fe=["$compile",function(a){return{restrict:"AC",compile:function(b){a.$$addBindingClass(b);return function(b,c,f){a.$$addBindingInfo(c,f.ngBind);c=c[0];b.$watch(f.ngBind,function(a){c.textContent=Yb(a)})}}}}],He=["$interpolate","$compile",function(a,
b){return{compile:function(d){b.$$addBindingClass(d);return function(c,d,e){c=a(d.attr(e.$attr.ngBindTemplate));b.$$addBindingInfo(d,c.expressions);d=d[0];e.$observe("ngBindTemplate",function(a){d.textContent=x(a)?"":a})}}}}],Ge=["$sce","$parse","$compile",function(a,b,d){return{restrict:"A",compile:function(c,f){var e=b(f.ngBindHtml),g=b(f.ngBindHtml,function(b){return a.valueOf(b)});d.$$addBindingClass(c);return function(b,c,f){d.$$addBindingInfo(c,f.ngBindHtml);b.$watch(g,function(){var d=e(b);
c.html(a.getTrustedHtml(d)||"")})}}}}],df=ma({restrict:"A",require:"ngModel",link:function(a,b,d,c){c.$viewChangeListeners.push(function(){a.$eval(d.ngChange)})}}),Ie=Ac("",!0),Ke=Ac("Odd",0),Je=Ac("Even",1),Le=Ra({compile:function(a,b){b.$set("ngCloak",void 0);a.removeClass("ng-cloak")}}),Me=[function(){return{restrict:"A",scope:!0,controller:"@",priority:500}}],Wc={},Yg={blur:!0,focus:!0};q("click dblclick mousedown mouseup mouseover mouseout mousemove mouseenter mouseleave keydown keyup keypress submit focus blur copy cut paste".split(" "),
function(a){var b=Ca("ng-"+a);Wc[b]=["$parse","$rootScope",function(d,c){return{restrict:"A",compile:function(f,e){var g=d(e[b],null,!0);return function(b,d){d.on(a,function(d){var e=function(){g(b,{$event:d})};Yg[a]&&c.$$phase?b.$evalAsync(e):b.$apply(e)})}}}}]});var Pe=["$animate","$compile",function(a,b){return{multiElement:!0,transclude:"element",priority:600,terminal:!0,restrict:"A",$$tlb:!0,link:function(d,c,f,e,g){var h,k,l;d.$watch(f.ngIf,function(d){d?k||g(function(d,e){k=e;d[d.length++]=
b.$$createComment("end ngIf",f.ngIf);h={clone:d};a.enter(d,c.parent(),c)}):(l&&(l.remove(),l=null),k&&(k.$destroy(),k=null),h&&(l=ub(h.clone),a.leave(l).done(function(a){!1!==a&&(l=null)}),h=null))})}}}],Qe=["$templateRequest","$anchorScroll","$animate",function(a,b,d){return{restrict:"ECA",priority:400,terminal:!0,transclude:"element",controller:$.noop,compile:function(c,f){var e=f.ngInclude||f.src,g=f.onload||"",h=f.autoscroll;return function(c,f,m,n,p){var q=0,s,w,u,H=function(){w&&(w.remove(),
w=null);s&&(s.$destroy(),s=null);u&&(d.leave(u).done(function(a){!1!==a&&(w=null)}),w=u,u=null)};c.$watch(e,function(e){var m=function(a){!1===a||!v(h)||h&&!c.$eval(h)||b()},w=++q;e?(a(e,!0).then(function(a){if(!c.$$destroyed&&w===q){var b=c.$new();n.template=a;a=p(b,function(a){H();d.enter(a,null,f).done(m)});s=b;u=a;s.$emit("$includeContentLoaded",e);c.$eval(g)}},function(){c.$$destroyed||w!==q||(H(),c.$emit("$includeContentError",e))}),c.$emit("$includeContentRequested",e)):(H(),n.template=null)})}}}}],
gf=["$compile",function(a){return{restrict:"ECA",priority:-400,require:"ngInclude",link:function(b,d,c,f){na.call(d[0]).match(/SVG/)?(d.empty(),a(Zc(f.template,z.document).childNodes)(b,function(a){d.append(a)},{futureParentElement:d})):(d.html(f.template),a(d.contents())(b))}}}],Re=Ra({priority:450,compile:function(){return{pre:function(a,b,d){a.$eval(d.ngInit)}}}}),cf=function(){return{restrict:"A",priority:100,require:"ngModel",link:function(a,b,d,c){var f=d.ngList||", ",e="false"!==d.ngTrim,g=
e?S(f):f;c.$parsers.push(function(a){if(!x(a)){var b=[];a&&q(a.split(g),function(a){a&&b.push(e?S(a):a)});return b}});c.$formatters.push(function(a){if(C(a))return a.join(f)});c.$isEmpty=function(a){return!a||!a.length}}}},ob="ng-valid",Ud="ng-invalid",Va="ng-pristine",Rb="ng-dirty",qb=M("ngModel");Ob.$inject="$scope $exceptionHandler $attrs $element $parse $animate $timeout $q $interpolate".split(" ");Ob.prototype={$$initGetterSetters:function(){if(this.$options.getOption("getterSetter")){var a=
this.$$parse(this.$$attr.ngModel+"()"),b=this.$$parse(this.$$attr.ngModel+"($$$p)");this.$$ngModelGet=function(b){var c=this.$$parsedNgModel(b);y(c)&&(c=a(b));return c};this.$$ngModelSet=function(a,c){y(this.$$parsedNgModel(a))?b(a,{$$$p:c}):this.$$parsedNgModelAssign(a,c)}}else if(!this.$$parsedNgModel.assign)throw qb("nonassign",this.$$attr.ngModel,ya(this.$$element));},$render:w,$isEmpty:function(a){return x(a)||""===a||null===a||a!==a},$$updateEmptyClasses:function(a){this.$isEmpty(a)?(this.$$animate.removeClass(this.$$element,
"ng-not-empty"),this.$$animate.addClass(this.$$element,"ng-empty")):(this.$$animate.removeClass(this.$$element,"ng-empty"),this.$$animate.addClass(this.$$element,"ng-not-empty"))},$setPristine:function(){this.$dirty=!1;this.$pristine=!0;this.$$animate.removeClass(this.$$element,Rb);this.$$animate.addClass(this.$$element,Va)},$setDirty:function(){this.$dirty=!0;this.$pristine=!1;this.$$animate.removeClass(this.$$element,Va);this.$$animate.addClass(this.$$element,Rb);this.$$parentForm.$setDirty()},
$setUntouched:function(){this.$touched=!1;this.$untouched=!0;this.$$animate.setClass(this.$$element,"ng-untouched","ng-touched")},$setTouched:function(){this.$touched=!0;this.$untouched=!1;this.$$animate.setClass(this.$$element,"ng-touched","ng-untouched")},$rollbackViewValue:function(){this.$$timeout.cancel(this.$$pendingDebounce);this.$viewValue=this.$$lastCommittedViewValue;this.$render()},$validate:function(){if(!ga(this.$modelValue)){var a=this.$$lastCommittedViewValue,b=this.$$rawModelValue,
d=this.$valid,c=this.$modelValue,f=this.$options.getOption("allowInvalid"),e=this;this.$$runValidators(b,a,function(a){f||d===a||(e.$modelValue=a?b:void 0,e.$modelValue!==c&&e.$$writeModelToScope())})}},$$runValidators:function(a,b,d){function c(){var c=!0;q(k.$validators,function(d,f){var g=Boolean(d(a,b));c=c&&g;e(f,g)});return c?!0:(q(k.$asyncValidators,function(a,b){e(b,null)}),!1)}function f(){var c=[],d=!0;q(k.$asyncValidators,function(f,g){var h=f(a,b);if(!h||!y(h.then))throw qb("nopromise",
h);e(g,void 0);c.push(h.then(function(){e(g,!0)},function(){d=!1;e(g,!1)}))});c.length?k.$$q.all(c).then(function(){g(d)},w):g(!0)}function e(a,b){h===k.$$currentValidationRunId&&k.$setValidity(a,b)}function g(a){h===k.$$currentValidationRunId&&d(a)}this.$$currentValidationRunId++;var h=this.$$currentValidationRunId,k=this;(function(){var a=k.$$parserName||"parse";if(x(k.$$parserValid))e(a,null);else return k.$$parserValid||(q(k.$validators,function(a,b){e(b,null)}),q(k.$asyncValidators,function(a,
b){e(b,null)})),e(a,k.$$parserValid),k.$$parserValid;return!0})()?c()?f():g(!1):g(!1)},$commitViewValue:function(){var a=this.$viewValue;this.$$timeout.cancel(this.$$pendingDebounce);if(this.$$lastCommittedViewValue!==a||""===a&&this.$$hasNativeValidators)this.$$updateEmptyClasses(a),this.$$lastCommittedViewValue=a,this.$pristine&&this.$setDirty(),this.$$parseAndValidate()},$$parseAndValidate:function(){var a=this.$$lastCommittedViewValue,b=this;if(this.$$parserValid=x(a)?void 0:!0)for(var d=0;d<
this.$parsers.length;d++)if(a=this.$parsers[d](a),x(a)){this.$$parserValid=!1;break}ga(this.$modelValue)&&(this.$modelValue=this.$$ngModelGet(this.$$scope));var c=this.$modelValue,f=this.$options.getOption("allowInvalid");this.$$rawModelValue=a;f&&(this.$modelValue=a,b.$modelValue!==c&&b.$$writeModelToScope());this.$$runValidators(a,this.$$lastCommittedViewValue,function(d){f||(b.$modelValue=d?a:void 0,b.$modelValue!==c&&b.$$writeModelToScope())})},$$writeModelToScope:function(){this.$$ngModelSet(this.$$scope,
this.$modelValue);q(this.$viewChangeListeners,function(a){try{a()}catch(b){this.$$exceptionHandler(b)}},this)},$setViewValue:function(a,b){this.$viewValue=a;this.$options.getOption("updateOnDefault")&&this.$$debounceViewValueCommit(b)},$$debounceViewValueCommit:function(a){var b=this.$options.getOption("debounce");Y(b[a])?b=b[a]:Y(b["default"])&&(b=b["default"]);this.$$timeout.cancel(this.$$pendingDebounce);var d=this;0<b?this.$$pendingDebounce=this.$$timeout(function(){d.$commitViewValue()},b):this.$$scope.$root.$$phase?
this.$commitViewValue():this.$$scope.$apply(function(){d.$commitViewValue()})}};Vd({clazz:Ob,set:function(a,b){a[b]=!0},unset:function(a,b){delete a[b]}});var bf=["$rootScope",function(a){return{restrict:"A",require:["ngModel","^?form","^?ngModelOptions"],controller:Ob,priority:1,compile:function(b){b.addClass(Va).addClass("ng-untouched").addClass(ob);return{pre:function(a,b,f,e){var g=e[0];b=e[1]||g.$$parentForm;if(e=e[2])g.$options=e.$options;g.$$initGetterSetters();b.$addControl(g);f.$observe("name",
function(a){g.$name!==a&&g.$$parentForm.$$renameControl(g,a)});a.$on("$destroy",function(){g.$$parentForm.$removeControl(g)})},post:function(b,c,f,e){function g(){h.$setTouched()}var h=e[0];if(h.$options.getOption("updateOn"))c.on(h.$options.getOption("updateOn"),function(a){h.$$debounceViewValueCommit(a&&a.type)});c.on("blur",function(){h.$touched||(a.$$phase?b.$evalAsync(g):b.$apply(g))})}}}}}],Pb,Zg=/(\s+|^)default(\s+|$)/;Bc.prototype={getOption:function(a){return this.$$options[a]},createChild:function(a){var b=
!1;a=R({},a);q(a,function(d,c){"$inherit"===d?"*"===c?b=!0:(a[c]=this.$$options[c],"updateOn"===c&&(a.updateOnDefault=this.$$options.updateOnDefault)):"updateOn"===c&&(a.updateOnDefault=!1,a[c]=S(d.replace(Zg,function(){a.updateOnDefault=!0;return" "})))},this);b&&(delete a["*"],ae(a,this.$$options));ae(a,Pb.$$options);return new Bc(a)}};Pb=new Bc({updateOn:"",updateOnDefault:!0,debounce:0,getterSetter:!1,allowInvalid:!1,timezone:null});var ff=function(){function a(a,d){this.$$attrs=a;this.$$scope=
d}a.$inject=["$attrs","$scope"];a.prototype={$onInit:function(){var a=this.parentCtrl?this.parentCtrl.$options:Pb,d=this.$$scope.$eval(this.$$attrs.ngModelOptions);this.$options=a.createChild(d)}};return{restrict:"A",priority:10,require:{parentCtrl:"?^^ngModelOptions"},bindToController:!0,controller:a}},Se=Ra({terminal:!0,priority:1E3}),$g=M("ngOptions"),ah=/^\s*([\s\S]+?)(?:\s+as\s+([\s\S]+?))?(?:\s+group\s+by\s+([\s\S]+?))?(?:\s+disable\s+when\s+([\s\S]+?))?\s+for\s+(?:([$\w][$\w]*)|(?:\(\s*([$\w][$\w]*)\s*,\s*([$\w][$\w]*)\s*\)))\s+in\s+([\s\S]+?)(?:\s+track\s+by\s+([\s\S]+?))?$/,
$e=["$compile","$document","$parse",function(a,b,d){function c(a,b,c){function e(a,b,c,d,f){this.selectValue=a;this.viewValue=b;this.label=c;this.group=d;this.disabled=f}function f(a){var b;if(!q&&ta(a))b=a;else{b=[];for(var c in a)a.hasOwnProperty(c)&&"$"!==c.charAt(0)&&b.push(c)}return b}var n=a.match(ah);if(!n)throw $g("iexp",a,ya(b));var p=n[5]||n[7],q=n[6];a=/ as /.test(n[0])&&n[1];var s=n[9];b=d(n[2]?n[1]:p);var v=a&&d(a)||b,u=s&&d(s),w=s?function(a,b){return u(c,b)}:function(a){return la(a)},
x=function(a,b){return w(a,B(a,b))},t=d(n[2]||n[1]),z=d(n[3]||""),A=d(n[4]||""),K=d(n[8]),I={},B=q?function(a,b){I[q]=b;I[p]=a;return I}:function(a){I[p]=a;return I};return{trackBy:s,getTrackByValue:x,getWatchables:d(K,function(a){var b=[];a=a||[];for(var d=f(a),e=d.length,g=0;g<e;g++){var h=a===d?g:d[g],l=a[h],h=B(l,h),l=w(l,h);b.push(l);if(n[2]||n[1])l=t(c,h),b.push(l);n[4]&&(h=A(c,h),b.push(h))}return b}),getOptions:function(){for(var a=[],b={},d=K(c)||[],g=f(d),h=g.length,n=0;n<h;n++){var p=d===
g?n:g[n],q=B(d[p],p),r=v(c,q),p=w(r,q),u=t(c,q),I=z(c,q),q=A(c,q),r=new e(p,r,u,I,q);a.push(r);b[p]=r}return{items:a,selectValueMap:b,getOptionFromViewValue:function(a){return b[x(a)]},getViewValueFromOption:function(a){return s?Fa(a.viewValue):a.viewValue}}}}}var f=z.document.createElement("option"),e=z.document.createElement("optgroup");return{restrict:"A",terminal:!0,require:["select","ngModel"],link:{pre:function(a,b,c,d){d[0].registerOption=w},post:function(d,h,k,l){function m(a){var b=(a=t.getOptionFromViewValue(a))&&
a.element;b&&!b.selected&&(b.selected=!0);return a}function n(a,b){a.element=b;b.disabled=a.disabled;a.label!==b.label&&(b.label=a.label,b.textContent=a.label);b.value=a.selectValue}function p(){var a=t&&r.readValue();if(t)for(var b=t.items.length-1;0<=b;b--){var c=t.items[b];v(c.group)?Fb(c.element.parentNode):Fb(c.element)}t=y.getOptions();var d={};z&&h.prepend(r.emptyOption);t.items.forEach(function(a){var b;if(v(a.group)){b=d[a.group];b||(b=e.cloneNode(!1),A.appendChild(b),b.label=null===a.group?
"null":a.group,d[a.group]=b);var c=f.cloneNode(!1)}else b=A,c=f.cloneNode(!1);b.appendChild(c);n(a,c)});h[0].appendChild(A);s.$render();s.$isEmpty(a)||(b=r.readValue(),(y.trackBy||w?qa(a,b):a===b)||(s.$setViewValue(b),s.$render()))}var r=l[0],s=l[1],w=k.multiple;l=0;for(var u=h.children(),x=u.length;l<x;l++)if(""===u[l].value){r.hasEmptyOption=!0;r.emptyOption=u.eq(l);break}var z=!!r.emptyOption;D(f.cloneNode(!1)).val("?");var t,y=c(k.ngOptions,h,d),A=b[0].createDocumentFragment();r.generateUnknownOptionValue=
function(a){return"?"};w?(r.writeValue=function(a){var b=a&&a.map(m)||[];t.items.forEach(function(a){a.element.selected&&-1===Array.prototype.indexOf.call(b,a)&&(a.element.selected=!1)})},r.readValue=function(){var a=h.val()||[],b=[];q(a,function(a){(a=t.selectValueMap[a])&&!a.disabled&&b.push(t.getViewValueFromOption(a))});return b},y.trackBy&&d.$watchCollection(function(){if(C(s.$viewValue))return s.$viewValue.map(function(a){return y.getTrackByValue(a)})},function(){s.$render()})):(r.writeValue=
function(a){var b=t.selectValueMap[h.val()],c=t.getOptionFromViewValue(a);b&&b.element.removeAttribute("selected");c?(h[0].value!==c.selectValue&&(r.removeUnknownOption(),r.unselectEmptyOption(),h[0].value=c.selectValue,c.element.selected=!0),c.element.setAttribute("selected","selected")):z?r.selectEmptyOption():r.unknownOption.parent().length?r.updateUnknownOption(a):r.renderUnknownOption(a)},r.readValue=function(){var a=t.selectValueMap[h.val()];return a&&!a.disabled?(r.unselectEmptyOption(),r.removeUnknownOption(),
t.getViewValueFromOption(a)):null},y.trackBy&&d.$watch(function(){return y.getTrackByValue(s.$viewValue)},function(){s.$render()}));z&&(r.emptyOption.remove(),a(r.emptyOption)(d),8===r.emptyOption[0].nodeType?(r.hasEmptyOption=!1,r.registerOption=function(a,b){""===b.val()&&(r.hasEmptyOption=!0,r.emptyOption=b,r.emptyOption.removeClass("ng-scope"),s.$render(),b.on("$destroy",function(){r.hasEmptyOption=!1;r.emptyOption=void 0}))}):r.emptyOption.removeClass("ng-scope"));h.empty();p();d.$watchCollection(y.getWatchables,
p)}}}}],Te=["$locale","$interpolate","$log",function(a,b,d){var c=/{}/g,f=/^when(Minus)?(.+)$/;return{link:function(e,g,h){function k(a){g.text(a||"")}var l=h.count,m=h.$attr.when&&g.attr(h.$attr.when),n=h.offset||0,p=e.$eval(m)||{},r={},s=b.startSymbol(),v=b.endSymbol(),u=s+l+"-"+n+v,H=$.noop,y;q(h,function(a,b){var c=f.exec(b);c&&(c=(c[1]?"-":"")+P(c[2]),p[c]=g.attr(h.$attr[b]))});q(p,function(a,d){r[d]=b(a.replace(c,u))});e.$watch(l,function(b){var c=parseFloat(b),f=ga(c);f||c in p||(c=a.pluralCat(c-
n));c===y||f&&ga(y)||(H(),f=r[c],x(f)?(null!=b&&d.debug("ngPluralize: no rule defined for '"+c+"' in "+m),H=w,k()):H=e.$watch(f,k),y=c)})}}}],Ue=["$parse","$animate","$compile",function(a,b,d){var c=M("ngRepeat"),f=function(a,b,c,d,f,m,n){a[c]=d;f&&(a[f]=m);a.$index=b;a.$first=0===b;a.$last=b===n-1;a.$middle=!(a.$first||a.$last);a.$odd=!(a.$even=0===(b&1))};return{restrict:"A",multiElement:!0,transclude:"element",priority:1E3,terminal:!0,$$tlb:!0,compile:function(e,g){var h=g.ngRepeat,k=d.$$createComment("end ngRepeat",
h),l=h.match(/^\s*([\s\S]+?)\s+in\s+([\s\S]+?)(?:\s+as\s+([\s\S]+?))?(?:\s+track\s+by\s+([\s\S]+?))?\s*$/);if(!l)throw c("iexp",h);var m=l[1],n=l[2],p=l[3],r=l[4],l=m.match(/^(?:(\s*[$\w]+)|\(\s*([$\w]+)\s*,\s*([$\w]+)\s*\))$/);if(!l)throw c("iidexp",m);var s=l[3]||l[1],v=l[2];if(p&&(!/^[$a-zA-Z_][$a-zA-Z0-9_]*$/.test(p)||/^(null|undefined|this|\$index|\$first|\$middle|\$last|\$even|\$odd|\$parent|\$root|\$id)$/.test(p)))throw c("badident",p);var u,w,x,t,y={$id:la};r?u=a(r):(x=function(a,b){return la(b)},
t=function(a){return a});return function(a,d,e,g,l){u&&(w=function(b,c,d){v&&(y[v]=b);y[s]=c;y.$index=d;return u(a,y)});var m=W();a.$watchCollection(n,function(e){var g,n,r=d[0],u,y=W(),z,D,E,B,F,C,I;p&&(a[p]=e);if(ta(e))F=e,n=w||x;else for(I in n=w||t,F=[],e)va.call(e,I)&&"$"!==I.charAt(0)&&F.push(I);z=F.length;I=Array(z);for(g=0;g<z;g++)if(D=e===F?g:F[g],E=e[D],B=n(D,E,g),m[B])C=m[B],delete m[B],y[B]=C,I[g]=C;else{if(y[B])throw q(I,function(a){a&&a.scope&&(m[a.id]=a)}),c("dupes",h,B,E);I[g]={id:B,
scope:void 0,clone:void 0};y[B]=!0}for(u in m){C=m[u];B=ub(C.clone);b.leave(B);if(B[0].parentNode)for(g=0,n=B.length;g<n;g++)B[g].$$NG_REMOVED=!0;C.scope.$destroy()}for(g=0;g<z;g++)if(D=e===F?g:F[g],E=e[D],C=I[g],C.scope){u=r;do u=u.nextSibling;while(u&&u.$$NG_REMOVED);C.clone[0]!==u&&b.move(ub(C.clone),null,r);r=C.clone[C.clone.length-1];f(C.scope,g,s,E,v,D,z)}else l(function(a,c){C.scope=c;var d=k.cloneNode(!1);a[a.length++]=d;b.enter(a,null,r);r=d;C.clone=a;y[C.id]=C;f(C.scope,g,s,E,v,D,z)});m=
y})}}}}],Ve=["$animate",function(a){return{restrict:"A",multiElement:!0,link:function(b,d,c){b.$watch(c.ngShow,function(b){a[b?"removeClass":"addClass"](d,"ng-hide",{tempClasses:"ng-hide-animate"})})}}}],Oe=["$animate",function(a){return{restrict:"A",multiElement:!0,link:function(b,d,c){b.$watch(c.ngHide,function(b){a[b?"addClass":"removeClass"](d,"ng-hide",{tempClasses:"ng-hide-animate"})})}}}],We=Ra(function(a,b,d){a.$watch(d.ngStyle,function(a,d){d&&a!==d&&q(d,function(a,c){b.css(c,"")});a&&b.css(a)},
!0)}),Xe=["$animate","$compile",function(a,b){return{require:"ngSwitch",controller:["$scope",function(){this.cases={}}],link:function(d,c,f,e){var g=[],h=[],k=[],l=[],m=function(a,b){return function(c){!1!==c&&a.splice(b,1)}};d.$watch(f.ngSwitch||f.on,function(c){for(var d,f;k.length;)a.cancel(k.pop());d=0;for(f=l.length;d<f;++d){var s=ub(h[d].clone);l[d].$destroy();(k[d]=a.leave(s)).done(m(k,d))}h.length=0;l.length=0;(g=e.cases["!"+c]||e.cases["?"])&&q(g,function(c){c.transclude(function(d,e){l.push(e);
var f=c.element;d[d.length++]=b.$$createComment("end ngSwitchWhen");h.push({clone:d});a.enter(d,f.parent(),f)})})})}}}],Ye=Ra({transclude:"element",priority:1200,require:"^ngSwitch",multiElement:!0,link:function(a,b,d,c,f){a=d.ngSwitchWhen.split(d.ngSwitchWhenSeparator).sort().filter(function(a,b,c){return c[b-1]!==a});q(a,function(a){c.cases["!"+a]=c.cases["!"+a]||[];c.cases["!"+a].push({transclude:f,element:b})})}}),Ze=Ra({transclude:"element",priority:1200,require:"^ngSwitch",multiElement:!0,link:function(a,
b,d,c,f){c.cases["?"]=c.cases["?"]||[];c.cases["?"].push({transclude:f,element:b})}}),bh=M("ngTransclude"),af=["$compile",function(a){return{restrict:"EAC",terminal:!0,compile:function(b){var d=a(b.contents());b.empty();return function(a,b,e,g,h){function k(){d(a,function(a){b.append(a)})}if(!h)throw bh("orphan",ya(b));e.ngTransclude===e.$attr.ngTransclude&&(e.ngTransclude="");e=e.ngTransclude||e.ngTranscludeSlot;h(function(a,c){var d;if(d=a.length)a:{d=0;for(var e=a.length;d<e;d++){var g=a[d];if(g.nodeType!==
Ja||g.nodeValue.trim()){d=!0;break a}}d=void 0}d?b.append(a):(k(),c.$destroy())},null,e);e&&!h.isSlotFilled(e)&&k()}}}}],Ce=["$templateCache",function(a){return{restrict:"E",terminal:!0,compile:function(b,d){"text/ng-template"===d.type&&a.put(d.id,b[0].text)}}}],ch={$setViewValue:w,$render:w},dh=["$element","$scope",function(a,b){function d(){h||(h=!0,b.$$postDigest(function(){h=!1;e.ngModelCtrl.$render()}))}function c(a){k||(k=!0,b.$$postDigest(function(){b.$$destroyed||(k=!1,e.ngModelCtrl.$setViewValue(e.readValue()),
a&&e.ngModelCtrl.$render())}))}function f(a){a.prop("selected",!0);a.attr("selected",!0)}var e=this,g=new Qa;e.selectValueMap={};e.ngModelCtrl=ch;e.multiple=!1;e.unknownOption=D(z.document.createElement("option"));e.hasEmptyOption=!1;e.emptyOption=void 0;e.renderUnknownOption=function(b){b=e.generateUnknownOptionValue(b);e.unknownOption.val(b);a.prepend(e.unknownOption);f(e.unknownOption);a.val(b)};e.updateUnknownOption=function(b){b=e.generateUnknownOptionValue(b);e.unknownOption.val(b);f(e.unknownOption);
a.val(b)};e.generateUnknownOptionValue=function(a){return"? "+la(a)+" ?"};e.removeUnknownOption=function(){e.unknownOption.parent()&&e.unknownOption.remove()};e.selectEmptyOption=function(){e.emptyOption&&(a.val(""),f(e.emptyOption))};e.unselectEmptyOption=function(){e.hasEmptyOption&&e.emptyOption.removeAttr("selected")};b.$on("$destroy",function(){e.renderUnknownOption=w});e.readValue=function(){var b=a.val(),b=b in e.selectValueMap?e.selectValueMap[b]:b;return e.hasOption(b)?b:null};e.writeValue=
function(b){var c=a[0].options[a[0].selectedIndex];c&&c.removeAttribute("selected");e.hasOption(b)?(e.removeUnknownOption(),c=la(b),a.val(c in e.selectValueMap?c:b),f(D(a[0].options[a[0].selectedIndex]))):null==b&&e.emptyOption?(e.removeUnknownOption(),e.selectEmptyOption()):e.unknownOption.parent().length?e.updateUnknownOption(b):e.renderUnknownOption(b)};e.addOption=function(a,b){if(8!==b[0].nodeType){Pa(a,'"option value"');""===a&&(e.hasEmptyOption=!0,e.emptyOption=b);var c=g.get(a)||0;g.put(a,
c+1);d()}};e.removeOption=function(a){var b=g.get(a);b&&(1===b?(g.remove(a),""===a&&(e.hasEmptyOption=!1,e.emptyOption=void 0)):g.put(a,b-1))};e.hasOption=function(a){return!!g.get(a)};var h=!1,k=!1;e.registerOption=function(a,b,d,f,g){if(d.$attr.ngValue){var h,k=NaN;d.$observe("value",function(a){var d,f=b.prop("selected");v(k)&&(e.removeOption(h),delete e.selectValueMap[k],d=!0);k=la(a);h=a;e.selectValueMap[k]=a;e.addOption(a,b);b.attr("value",k);d&&f&&c()})}else f?d.$observe("value",function(a){e.readValue();
var d,f=b.prop("selected");v(h)&&(e.removeOption(h),d=!0);h=a;e.addOption(a,b);d&&f&&c()}):g?a.$watch(g,function(a,f){d.$set("value",a);var g=b.prop("selected");f!==a&&e.removeOption(f);e.addOption(a,b);f&&g&&c()}):e.addOption(d.value,b);d.$observe("disabled",function(a){if("true"===a||a&&b.prop("selected"))e.multiple?c(!0):(e.ngModelCtrl.$setViewValue(null),e.ngModelCtrl.$render())});b.on("$destroy",function(){var a=e.readValue(),b=d.value;e.removeOption(b);e.ngModelCtrl.$render();(e.multiple&&a&&
-1!==a.indexOf(b)||a===b)&&c(!0)})}}],De=function(){return{restrict:"E",require:["select","?ngModel"],controller:dh,priority:1,link:{pre:function(a,b,d,c){var f=c[0],e=c[1];if(e){if(f.ngModelCtrl=e,b.on("change",function(){f.removeUnknownOption();a.$apply(function(){e.$setViewValue(f.readValue())})}),d.multiple){f.multiple=!0;f.readValue=function(){var a=[];q(b.find("option"),function(b){b.selected&&!b.disabled&&(b=b.value,a.push(b in f.selectValueMap?f.selectValueMap[b]:b))});return a};f.writeValue=
function(a){var c=new Qa(a);q(b.find("option"),function(a){a.selected=v(c.get(a.value))||v(c.get(f.selectValueMap[a.value]))})};var g,h=NaN;a.$watch(function(){h!==e.$viewValue||qa(g,e.$viewValue)||(g=ra(e.$viewValue),e.$render());h=e.$viewValue});e.$isEmpty=function(a){return!a||0===a.length}}}else f.registerOption=w},post:function(a,b,d,c){var f=c[1];if(f){var e=c[0];f.$render=function(){e.writeValue(f.$viewValue)}}}}}},Ee=["$interpolate",function(a){return{restrict:"E",priority:100,compile:function(b,
d){var c,f;v(d.ngValue)||(v(d.value)?c=a(d.value,!0):(f=a(b.text(),!0))||d.$set("value",b.text()));return function(a,b,d){var k=b.parent();(k=k.data("$selectController")||k.parent().data("$selectController"))&&k.registerOption(a,b,d,c,f)}}}}],Tc=function(){return{restrict:"A",require:"?ngModel",link:function(a,b,d,c){c&&(d.required=!0,c.$validators.required=function(a,b){return!d.required||!c.$isEmpty(b)},d.$observe("required",function(){c.$validate()}))}}},Sc=function(){return{restrict:"A",require:"?ngModel",
link:function(a,b,d,c){if(c){var f,e=d.ngPattern||d.pattern;d.$observe("pattern",function(a){E(a)&&0<a.length&&(a=new RegExp("^"+a+"$"));if(a&&!a.test)throw M("ngPattern")("noregexp",e,a,ya(b));f=a||void 0;c.$validate()});c.$validators.pattern=function(a,b){return c.$isEmpty(b)||x(f)||f.test(b)}}}}},Vc=function(){return{restrict:"A",require:"?ngModel",link:function(a,b,d,c){if(c){var f=-1;d.$observe("maxlength",function(a){a=Z(a);f=ga(a)?-1:a;c.$validate()});c.$validators.maxlength=function(a,b){return 0>
f||c.$isEmpty(b)||b.length<=f}}}}},Uc=function(){return{restrict:"A",require:"?ngModel",link:function(a,b,d,c){if(c){var f=0;d.$observe("minlength",function(a){f=Z(a)||0;c.$validate()});c.$validators.minlength=function(a,b){return c.$isEmpty(b)||b.length>=f}}}}};z.angular.bootstrap?z.console&&console.log("WARNING: Tried to load angular more than once."):(ue(),xe($),$.module("ngLocale",[],["$provide",function(a){function b(a){a+="";var b=a.indexOf(".");return-1==b?0:a.length-b-1}a.value("$locale",
{DATETIME_FORMATS:{AMPMS:["AM","PM"],DAY:"Sunday Monday Tuesday Wednesday Thursday Friday Saturday".split(" "),ERANAMES:["Before Christ","Anno Domini"],ERAS:["BC","AD"],FIRSTDAYOFWEEK:6,MONTH:"January February March April May June July August September October November December".split(" "),SHORTDAY:"Sun Mon Tue Wed Thu Fri Sat".split(" "),SHORTMONTH:"Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec".split(" "),STANDALONEMONTH:"January February March April May June July August September October November December".split(" "),
WEEKENDRANGE:[5,6],fullDate:"EEEE, MMMM d, y",longDate:"MMMM d, y",medium:"MMM d, y h:mm:ss a",mediumDate:"MMM d, y",mediumTime:"h:mm:ss a","short":"M/d/yy h:mm a",shortDate:"M/d/yy",shortTime:"h:mm a"},NUMBER_FORMATS:{CURRENCY_SYM:"$",DECIMAL_SEP:".",GROUP_SEP:",",PATTERNS:[{gSize:3,lgSize:3,maxFrac:3,minFrac:0,minInt:1,negPre:"-",negSuf:"",posPre:"",posSuf:""},{gSize:3,lgSize:3,maxFrac:2,minFrac:2,minInt:1,negPre:"-\u00a4",negSuf:"",posPre:"\u00a4",posSuf:""}]},id:"en-us",localeID:"en_US",pluralCat:function(a,
c){var f=a|0,e=c;void 0===e&&(e=Math.min(b(a),3));Math.pow(10,e);return 1==f&&0==e?"one":"other"}})}]),D(function(){pe(z.document,Mc)}))})(window);!window.angular.$$csp().noInlineStyle&&window.angular.element(document.head).prepend('<style type="text/css">@charset "UTF-8";[ng\\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}ng\\:form{display:block;}.ng-animate-shim{visibility:hidden;}.ng-anchor{position:absolute;}</style>');
//# sourceMappingURL=angular.min.js.map

;/*
 AngularJS v1.6.1
 (c) 2010-2016 Google, Inc. http://angularjs.org
 License: MIT
*/
(function(U,C){'use strict';function Ea(a,b,c){if(!a)throw Oa("areq",b||"?",c||"required");return a}function Fa(a,b){if(!a&&!b)return"";if(!a)return b;if(!b)return a;X(a)&&(a=a.join(" "));X(b)&&(b=b.join(" "));return a+" "+b}function Pa(a){var b={};a&&(a.to||a.from)&&(b.to=a.to,b.from=a.from);return b}function Y(a,b,c){var d="";a=X(a)?a:a&&G(a)&&a.length?a.split(/\s+/):[];r(a,function(a,e){a&&0<a.length&&(d+=0<e?" ":"",d+=c?b+a:a+b)});return d}function Qa(a){if(a instanceof w)switch(a.length){case 0:return a;
case 1:if(1===a[0].nodeType)return a;break;default:return w(ua(a))}if(1===a.nodeType)return w(a)}function ua(a){if(!a[0])return a;for(var b=0;b<a.length;b++){var c=a[b];if(1===c.nodeType)return c}}function Ra(a,b,c){r(b,function(b){a.addClass(b,c)})}function Sa(a,b,c){r(b,function(b){a.removeClass(b,c)})}function Z(a){return function(b,c){c.addClass&&(Ra(a,b,c.addClass),c.addClass=null);c.removeClass&&(Sa(a,b,c.removeClass),c.removeClass=null)}}function oa(a){a=a||{};if(!a.$$prepared){var b=a.domOperation||
N;a.domOperation=function(){a.$$domOperationFired=!0;b();b=N};a.$$prepared=!0}return a}function ha(a,b){Ga(a,b);Ha(a,b)}function Ga(a,b){b.from&&(a.css(b.from),b.from=null)}function Ha(a,b){b.to&&(a.css(b.to),b.to=null)}function V(a,b,c){var d=b.options||{};c=c.options||{};var f=(d.addClass||"")+" "+(c.addClass||""),e=(d.removeClass||"")+" "+(c.removeClass||"");a=Ta(a.attr("class"),f,e);c.preparationClasses&&(d.preparationClasses=ea(c.preparationClasses,d.preparationClasses),delete c.preparationClasses);
f=d.domOperation!==N?d.domOperation:null;va(d,c);f&&(d.domOperation=f);d.addClass=a.addClass?a.addClass:null;d.removeClass=a.removeClass?a.removeClass:null;b.addClass=d.addClass;b.removeClass=d.removeClass;return d}function Ta(a,b,c){function d(a){G(a)&&(a=a.split(" "));var b={};r(a,function(a){a.length&&(b[a]=!0)});return b}var f={};a=d(a);b=d(b);r(b,function(a,b){f[b]=1});c=d(c);r(c,function(a,b){f[b]=1===f[b]?null:-1});var e={addClass:"",removeClass:""};r(f,function(b,c){var d,f;1===b?(d="addClass",
f=!a[c]||a[c+"-remove"]):-1===b&&(d="removeClass",f=a[c]||a[c+"-add"]);f&&(e[d].length&&(e[d]+=" "),e[d]+=c)});return e}function z(a){return a instanceof w?a[0]:a}function Ua(a,b,c){var d="";b&&(d=Y(b,"ng-",!0));c.addClass&&(d=ea(d,Y(c.addClass,"-add")));c.removeClass&&(d=ea(d,Y(c.removeClass,"-remove")));d.length&&(c.preparationClasses=d,a.addClass(d))}function pa(a,b){var c=b?"-"+b+"s":"";ka(a,[la,c]);return[la,c]}function wa(a,b){var c=b?"paused":"",d=$+"PlayState";ka(a,[d,c]);return[d,c]}function ka(a,
b){a.style[b[0]]=b[1]}function ea(a,b){return a?b?a+" "+b:a:b}function Ia(a,b,c){var d=Object.create(null),f=a.getComputedStyle(b)||{};r(c,function(a,b){var c=f[a];if(c){var y=c.charAt(0);if("-"===y||"+"===y||0<=y)c=Va(c);0===c&&(c=null);d[b]=c}});return d}function Va(a){var b=0;a=a.split(/\s*,\s*/);r(a,function(a){"s"===a.charAt(a.length-1)&&(a=a.substring(0,a.length-1));a=parseFloat(a)||0;b=b?Math.max(a,b):a});return b}function xa(a){return 0===a||null!=a}function Ja(a,b){var c=R,d=a+"s";b?c+="Duration":
d+=" linear all";return[c,d]}function Ka(){var a=Object.create(null);return{flush:function(){a=Object.create(null)},count:function(b){return(b=a[b])?b.total:0},get:function(b){return(b=a[b])&&b.value},put:function(b,c){a[b]?a[b].total++:a[b]={total:1,value:c}}}}function La(a,b,c){r(c,function(c){a[c]=ya(a[c])?a[c]:b.style.getPropertyValue(c)})}var R,za,$,Aa;void 0===U.ontransitionend&&void 0!==U.onwebkittransitionend?(R="WebkitTransition",za="webkitTransitionEnd transitionend"):(R="transition",za=
"transitionend");void 0===U.onanimationend&&void 0!==U.onwebkitanimationend?($="WebkitAnimation",Aa="webkitAnimationEnd animationend"):($="animation",Aa="animationend");var qa=$+"Delay",Ba=$+"Duration",la=R+"Delay",Ma=R+"Duration",Oa=C.$$minErr("ng"),Wa={transitionDuration:Ma,transitionDelay:la,transitionProperty:R+"Property",animationDuration:Ba,animationDelay:qa,animationIterationCount:$+"IterationCount"},Xa={transitionDuration:Ma,transitionDelay:la,animationDuration:Ba,animationDelay:qa},Ca,va,
r,X,ya,aa,Da,ra,G,K,w,N;C.module("ngAnimate",[],function(){N=C.noop;Ca=C.copy;va=C.extend;w=C.element;r=C.forEach;X=C.isArray;G=C.isString;ra=C.isObject;K=C.isUndefined;ya=C.isDefined;Da=C.isFunction;aa=C.isElement}).directive("ngAnimateSwap",["$animate","$rootScope",function(a,b){return{restrict:"A",transclude:"element",terminal:!0,priority:600,link:function(b,d,f,e,m){var A,y;b.$watchCollection(f.ngAnimateSwap||f["for"],function(f){A&&a.leave(A);y&&(y.$destroy(),y=null);if(f||0===f)y=b.$new(),m(y,
function(b){A=b;a.enter(b,null,d)})})}}}]).directive("ngAnimateChildren",["$interpolate",function(a){return{link:function(b,c,d){function f(a){c.data("$$ngAnimateChildren","on"===a||"true"===a)}var e=d.ngAnimateChildren;G(e)&&0===e.length?c.data("$$ngAnimateChildren",!0):(f(a(e)(b)),d.$observe("ngAnimateChildren",f))}}}]).factory("$$rAFScheduler",["$$rAF",function(a){function b(a){d=d.concat(a);c()}function c(){if(d.length){for(var b=d.shift(),m=0;m<b.length;m++)b[m]();f||a(function(){f||c()})}}var d,
f;d=b.queue=[];b.waitUntilQuiet=function(b){f&&f();f=a(function(){f=null;b();c()})};return b}]).provider("$$animateQueue",["$animateProvider",function(a){function b(a){if(!a)return null;a=a.split(" ");var b=Object.create(null);r(a,function(a){b[a]=!0});return b}function c(a,c){if(a&&c){var d=b(c);return a.split(" ").some(function(a){return d[a]})}}function d(a,b,c,d){return e[a].some(function(a){return a(b,c,d)})}function f(a,b){var c=0<(a.addClass||"").length,d=0<(a.removeClass||"").length;return b?
c&&d:c||d}var e=this.rules={skip:[],cancel:[],join:[]};e.join.push(function(a,b,c){return!b.structural&&f(b)});e.skip.push(function(a,b,c){return!b.structural&&!f(b)});e.skip.push(function(a,b,c){return"leave"===c.event&&b.structural});e.skip.push(function(a,b,c){return c.structural&&2===c.state&&!b.structural});e.cancel.push(function(a,b,c){return c.structural&&b.structural});e.cancel.push(function(a,b,c){return 2===c.state&&b.structural});e.cancel.push(function(a,b,d){if(d.structural)return!1;a=
b.addClass;b=b.removeClass;var f=d.addClass;d=d.removeClass;return K(a)&&K(b)||K(f)&&K(d)?!1:c(a,d)||c(b,f)});this.$get=["$$rAF","$rootScope","$rootElement","$document","$$HashMap","$$animation","$$AnimateRunner","$templateRequest","$$jqLite","$$forceReflow","$$isDocumentHidden",function(b,c,y,e,ba,Ya,O,v,H,S,P){function I(){var a=!1;return function(b){a?b():c.$$postDigest(function(){a=!0;b()})}}function B(a,b,c){var g=z(b),d=z(a),E=[];(a=t[c])&&r(a,function(a){J.call(a.node,g)?E.push(a.callback):
"leave"===c&&J.call(a.node,d)&&E.push(a.callback)});return E}function n(a,b,c){var g=ua(b);return a.filter(function(a){return!(a.node===g&&(!c||a.callback===c))})}function p(a,h,u){function p(c,g,d,h){y(function(){var c=B(S,a,g);c.length?b(function(){r(c,function(b){b(a,d,h)});"close"!==d||a[0].parentNode||sa.off(a)}):"close"!==d||a[0].parentNode||sa.off(a)});c.progress(g,d,h)}function n(b){var c=a,g=k;g.preparationClasses&&(c.removeClass(g.preparationClasses),g.preparationClasses=null);g.activeClasses&&
(c.removeClass(g.activeClasses),g.activeClasses=null);Na(a,k);ha(a,k);k.domOperation();e.complete(!b)}var k=Ca(u),t,S;if(a=Qa(a))t=z(a),S=a.parent();var k=oa(k),e=new O,y=I();X(k.addClass)&&(k.addClass=k.addClass.join(" "));k.addClass&&!G(k.addClass)&&(k.addClass=null);X(k.removeClass)&&(k.removeClass=k.removeClass.join(" "));k.removeClass&&!G(k.removeClass)&&(k.removeClass=null);k.from&&!ra(k.from)&&(k.from=null);k.to&&!ra(k.to)&&(k.to=null);if(!t)return n(),e;u=[t.getAttribute("class"),k.addClass,
k.removeClass].join(" ");if(!F(u))return n(),e;var s=0<=["enter","move","leave"].indexOf(h),x=P(),v=!ma||x||g.get(t);u=!v&&E.get(t)||{};var J=!!u.state;v||J&&1===u.state||(v=!L(a,S,h));if(v)return x&&p(e,h,"start"),n(),x&&p(e,h,"close"),e;s&&ta(a);x={structural:s,element:a,event:h,addClass:k.addClass,removeClass:k.removeClass,close:n,options:k,runner:e};if(J){if(d("skip",a,x,u)){if(2===u.state)return n(),e;V(a,u,x);return u.runner}if(d("cancel",a,x,u))if(2===u.state)u.runner.end();else if(u.structural)u.close();
else return V(a,u,x),u.runner;else if(d("join",a,x,u))if(2===u.state)V(a,x,{});else return Ua(a,s?h:null,k),h=x.event=u.event,k=V(a,u,x),u.runner}else V(a,x,{});(J=x.structural)||(J="animate"===x.event&&0<Object.keys(x.options.to||{}).length||f(x));if(!J)return n(),l(a),e;var H=(u.counter||0)+1;x.counter=H;Q(a,1,x);c.$$postDigest(function(){var b=E.get(t),c=!b,b=b||{},g=0<(a.parent()||[]).length&&("animate"===b.event||b.structural||f(b));if(c||b.counter!==H||!g){c&&(Na(a,k),ha(a,k));if(c||s&&b.event!==
h)k.domOperation(),e.end();g||l(a)}else h=!b.structural&&f(b,!0)?"setClass":b.event,Q(a,2),b=Ya(a,h,b.options),e.setHost(b),p(e,h,"start",{}),b.done(function(b){n(!b);(b=E.get(t))&&b.counter===H&&l(z(a));p(e,h,"close",{})})});return e}function ta(a){a=z(a).querySelectorAll("[data-ng-animate]");r(a,function(a){var b=parseInt(a.getAttribute("data-ng-animate"),10),c=E.get(a);if(c)switch(b){case 2:c.runner.end();case 1:E.remove(a)}})}function l(a){a=z(a);a.removeAttribute("data-ng-animate");E.remove(a)}
function k(a,b){return z(a)===z(b)}function L(a,b,c){c=w(e[0].body);var d=k(a,c)||"HTML"===a[0].nodeName,h=k(a,y),f=!1,B,p=g.get(z(a));(a=w.data(a[0],"$ngAnimatePin"))&&(b=a);for(b=z(b);b;){h||(h=k(b,y));if(1!==b.nodeType)break;a=E.get(b)||{};if(!f){var n=g.get(b);if(!0===n&&!1!==p){p=!0;break}else!1===n&&(p=!1);f=a.structural}if(K(B)||!0===B)a=w.data(b,"$$ngAnimateChildren"),ya(a)&&(B=a);if(f&&!1===B)break;d||(d=k(b,c));if(d&&h)break;if(!h&&(a=w.data(b,"$ngAnimatePin"))){b=z(a);continue}b=b.parentNode}return(!f||
B)&&!0!==p&&h&&d}function Q(a,b,c){c=c||{};c.state=b;a=z(a);a.setAttribute("data-ng-animate",b);c=(b=E.get(a))?va(b,c):c;E.put(a,c)}var E=new ba,g=new ba,ma=null,h=c.$watch(function(){return 0===v.totalPendingRequests},function(a){a&&(h(),c.$$postDigest(function(){c.$$postDigest(function(){null===ma&&(ma=!0)})}))}),t=Object.create(null),x=a.classNameFilter(),F=x?function(a){return x.test(a)}:function(){return!0},Na=Z(H),J=U.Node.prototype.contains||function(a){return this===a||!!(this.compareDocumentPosition(a)&
16)},sa={on:function(a,b,c){var g=ua(b);t[a]=t[a]||[];t[a].push({node:g,callback:c});w(b).on("$destroy",function(){E.get(g)||sa.off(a,b,c)})},off:function(a,b,c){if(1!==arguments.length||G(arguments[0])){var g=t[a];g&&(t[a]=1===arguments.length?null:n(g,b,c))}else for(g in b=arguments[0],t)t[g]=n(t[g],b)},pin:function(a,b){Ea(aa(a),"element","not an element");Ea(aa(b),"parentElement","not an element");a.data("$ngAnimatePin",b)},push:function(a,b,c,g){c=c||{};c.domOperation=g;return p(a,b,c)},enabled:function(a,
b){var c=arguments.length;if(0===c)b=!!ma;else if(aa(a)){var d=z(a);1===c?b=!g.get(d):g.put(d,!b)}else b=ma=!!a;return b}};return sa}]}]).provider("$$animation",["$animateProvider",function(a){var b=this.drivers=[];this.$get=["$$jqLite","$rootScope","$injector","$$AnimateRunner","$$HashMap","$$rAFScheduler",function(a,d,f,e,m,A){function y(a){function b(a){if(a.processed)return a;a.processed=!0;var d=a.domNode,n=d.parentNode;f.put(d,a);for(var p;n;){if(p=f.get(n)){p.processed||(p=b(p));break}n=n.parentNode}(p||
c).children.push(a);return a}var c={children:[]},d,f=new m;for(d=0;d<a.length;d++){var e=a[d];f.put(e.domNode,a[d]={domNode:e.domNode,fn:e.fn,children:[]})}for(d=0;d<a.length;d++)b(a[d]);return function(a){var b=[],c=[],d;for(d=0;d<a.children.length;d++)c.push(a.children[d]);a=c.length;var f=0,e=[];for(d=0;d<c.length;d++){var k=c[d];0>=a&&(a=f,f=0,b.push(e),e=[]);e.push(k.fn);k.children.forEach(function(a){f++;c.push(a)});a--}e.length&&b.push(e);return b}(c)}var s=[],ba=Z(a);return function(m,O,v){function H(a){a=
a.hasAttribute("ng-animate-ref")?[a]:a.querySelectorAll("[ng-animate-ref]");var b=[];r(a,function(a){var c=a.getAttribute("ng-animate-ref");c&&c.length&&b.push(a)});return b}function S(a){var b=[],c={};r(a,function(a,d){var h=z(a.element),k=0<=["enter","move"].indexOf(a.event),h=a.structural?H(h):[];if(h.length){var f=k?"to":"from";r(h,function(a){var b=a.getAttribute("ng-animate-ref");c[b]=c[b]||{};c[b][f]={animationID:d,element:w(a)}})}else b.push(a)});var d={},k={};r(c,function(c,f){var e=c.from,
B=c.to;if(e&&B){var p=a[e.animationID],n=a[B.animationID],l=e.animationID.toString();if(!k[l]){var m=k[l]={structural:!0,beforeStart:function(){p.beforeStart();n.beforeStart()},close:function(){p.close();n.close()},classes:P(p.classes,n.classes),from:p,to:n,anchors:[]};m.classes.length?b.push(m):(b.push(p),b.push(n))}k[l].anchors.push({out:e.element,"in":B.element})}else e=e?e.animationID:B.animationID,B=e.toString(),d[B]||(d[B]=!0,b.push(a[e]))});return b}function P(a,b){a=a.split(" ");b=b.split(" ");
for(var c=[],d=0;d<a.length;d++){var k=a[d];if("ng-"!==k.substring(0,3))for(var f=0;f<b.length;f++)if(k===b[f]){c.push(k);break}}return c.join(" ")}function I(a){for(var c=b.length-1;0<=c;c--){var d=f.get(b[c])(a);if(d)return d}}function B(a,b){function c(a){(a=a.data("$$animationRunner"))&&a.setHost(b)}a.from&&a.to?(c(a.from.element),c(a.to.element)):c(a.element)}function n(){var a=m.data("$$animationRunner");!a||"leave"===O&&v.$$domOperationFired||a.end()}function p(b){m.off("$destroy",n);m.removeData("$$animationRunner");
ba(m,v);ha(m,v);v.domOperation();L&&a.removeClass(m,L);m.removeClass("ng-animate");l.complete(!b)}v=oa(v);var ta=0<=["enter","move","leave"].indexOf(O),l=new e({end:function(){p()},cancel:function(){p(!0)}});if(!b.length)return p(),l;m.data("$$animationRunner",l);var k=Fa(m.attr("class"),Fa(v.addClass,v.removeClass)),L=v.tempClasses;L&&(k+=" "+L,v.tempClasses=null);var Q;ta&&(Q="ng-"+O+"-prepare",a.addClass(m,Q));s.push({element:m,classes:k,event:O,structural:ta,options:v,beforeStart:function(){m.addClass("ng-animate");
L&&a.addClass(m,L);Q&&(a.removeClass(m,Q),Q=null)},close:p});m.on("$destroy",n);if(1<s.length)return l;d.$$postDigest(function(){var a=[];r(s,function(b){b.element.data("$$animationRunner")?a.push(b):b.close()});s.length=0;var b=S(a),c=[];r(b,function(a){c.push({domNode:z(a.from?a.from.element:a.element),fn:function(){a.beforeStart();var b,c=a.close;if((a.anchors?a.from.element||a.to.element:a.element).data("$$animationRunner")){var d=I(a);d&&(b=d.start)}b?(b=b(),b.done(function(a){c(!a)}),B(a,b)):
c()}})});A(y(c))});return l}}]}]).provider("$animateCss",["$animateProvider",function(a){var b=Ka(),c=Ka();this.$get=["$window","$$jqLite","$$AnimateRunner","$timeout","$$forceReflow","$sniffer","$$rAFScheduler","$$animateQueue",function(a,f,e,m,A,y,s,ba){function C(a,b){var c=a.parentNode;return(c.$$ngAnimateParentKey||(c.$$ngAnimateParentKey=++P))+"-"+a.getAttribute("class")+"-"+b}function O(e,n,p,m){var l;0<b.count(p)&&(l=c.get(p),l||(n=Y(n,"-stagger"),f.addClass(e,n),l=Ia(a,e,m),l.animationDuration=
Math.max(l.animationDuration,0),l.transitionDuration=Math.max(l.transitionDuration,0),f.removeClass(e,n),c.put(p,l)));return l||{}}function v(a){I.push(a);s.waitUntilQuiet(function(){b.flush();c.flush();for(var a=A(),d=0;d<I.length;d++)I[d](a);I.length=0})}function H(c,f,e){f=b.get(e);f||(f=Ia(a,c,Wa),"infinite"===f.animationIterationCount&&(f.animationIterationCount=1));b.put(e,f);c=f;e=c.animationDelay;f=c.transitionDelay;c.maxDelay=e&&f?Math.max(e,f):e||f;c.maxDuration=Math.max(c.animationDuration*
c.animationIterationCount,c.transitionDuration);return c}var S=Z(f),P=0,I=[];return function(a,c){function d(){l()}function s(){l(!0)}function l(b){if(!(A||P&&J)){A=!0;J=!1;g.$$skipPreparationClasses||f.removeClass(a,ga);f.removeClass(a,ea);wa(h,!1);pa(h,!1);r(t,function(a){h.style[a[0]]=""});S(a,g);ha(a,g);Object.keys(I).length&&r(I,function(a,b){a?h.style.setProperty(b,a):h.style.removeProperty(b)});if(g.onDone)g.onDone();fa&&fa.length&&a.off(fa.join(" "),Q);var c=a.data("$$animateCss");c&&(m.cancel(c[0].timer),
a.removeData("$$animateCss"));w&&w.complete(!b)}}function k(a){q.blockTransition&&pa(h,a);q.blockKeyframeAnimation&&wa(h,!!a)}function L(){w=new e({end:d,cancel:s});v(N);l();return{$$willAnimate:!1,start:function(){return w},end:d}}function Q(a){a.stopPropagation();var b=a.originalEvent||a;a=b.$manualTimeStamp||Date.now();b=parseFloat(b.elapsedTime.toFixed(3));Math.max(a-V,0)>=K&&b>=M&&(P=!0,l())}function E(){function b(){if(!A){k(!1);r(t,function(a){h.style[a[0]]=a[1]});S(a,g);f.addClass(a,ea);if(q.recalculateTimingStyles){na=
h.getAttribute("class")+" "+ga;ja=C(h,na);D=H(h,na,ja);ca=D.maxDelay;u=Math.max(ca,0);M=D.maxDuration;if(0===M){l();return}q.hasTransitions=0<D.transitionDuration;q.hasAnimations=0<D.animationDuration}q.applyAnimationDelay&&(ca="boolean"!==typeof g.delay&&xa(g.delay)?parseFloat(g.delay):ca,u=Math.max(ca,0),D.animationDelay=ca,da=[qa,ca+"s"],t.push(da),h.style[da[0]]=da[1]);K=1E3*u;U=1E3*M;if(g.easing){var d,e=g.easing;q.hasTransitions&&(d=R+"TimingFunction",t.push([d,e]),h.style[d]=e);q.hasAnimations&&
(d=$+"TimingFunction",t.push([d,e]),h.style[d]=e)}D.transitionDuration&&fa.push(za);D.animationDuration&&fa.push(Aa);V=Date.now();var E=K+1.5*U;d=V+E;var e=a.data("$$animateCss")||[],n=!0;if(e.length){var p=e[0];(n=d>p.expectedEndTime)?m.cancel(p.timer):e.push(l)}n&&(E=m(c,E,!1),e[0]={timer:E,expectedEndTime:d},e.push(l),a.data("$$animateCss",e));if(fa.length)a.on(fa.join(" "),Q);g.to&&(g.cleanupStyles&&La(I,h,Object.keys(g.to)),Ha(a,g))}}function c(){var b=a.data("$$animateCss");if(b){for(var d=
1;d<b.length;d++)b[d]();a.removeData("$$animateCss")}}if(!A)if(h.parentNode){var d=function(a){if(P)J&&a&&(J=!1,l());else if(J=!a,D.animationDuration)if(a=wa(h,J),J)t.push(a);else{var b=t,c=b.indexOf(a);0<=a&&b.splice(c,1)}},e=0<aa&&(D.transitionDuration&&0===W.transitionDuration||D.animationDuration&&0===W.animationDuration)&&Math.max(W.animationDelay,W.transitionDelay);e?m(b,Math.floor(e*aa*1E3),!1):b();G.resume=function(){d(!0)};G.pause=function(){d(!1)}}else l()}var g=c||{};g.$$prepared||(g=oa(Ca(g)));
var I={},h=z(a);if(!h||!h.parentNode||!ba.enabled())return L();var t=[],x=a.attr("class"),F=Pa(g),A,J,P,w,G,u,K,M,U,V,fa=[];if(0===g.duration||!y.animations&&!y.transitions)return L();var ia=g.event&&X(g.event)?g.event.join(" "):g.event,Z="",T="";ia&&g.structural?Z=Y(ia,"ng-",!0):ia&&(Z=ia);g.addClass&&(T+=Y(g.addClass,"-add"));g.removeClass&&(T.length&&(T+=" "),T+=Y(g.removeClass,"-remove"));g.applyClassesEarly&&T.length&&S(a,g);var ga=[Z,T].join(" ").trim(),na=x+" "+ga,ea=Y(ga,"-active"),x=F.to&&
0<Object.keys(F.to).length;if(!(0<(g.keyframeStyle||"").length||x||ga))return L();var ja,W;0<g.stagger?(F=parseFloat(g.stagger),W={transitionDelay:F,animationDelay:F,transitionDuration:0,animationDuration:0}):(ja=C(h,na),W=O(h,ga,ja,Xa));g.$$skipPreparationClasses||f.addClass(a,ga);g.transitionStyle&&(F=[R,g.transitionStyle],ka(h,F),t.push(F));0<=g.duration&&(F=0<h.style[R].length,F=Ja(g.duration,F),ka(h,F),t.push(F));g.keyframeStyle&&(F=[$,g.keyframeStyle],ka(h,F),t.push(F));var aa=W?0<=g.staggerIndex?
g.staggerIndex:b.count(ja):0;(ia=0===aa)&&!g.skipBlocking&&pa(h,9999);var D=H(h,na,ja),ca=D.maxDelay;u=Math.max(ca,0);M=D.maxDuration;var q={};q.hasTransitions=0<D.transitionDuration;q.hasAnimations=0<D.animationDuration;q.hasTransitionAll=q.hasTransitions&&"all"===D.transitionProperty;q.applyTransitionDuration=x&&(q.hasTransitions&&!q.hasTransitionAll||q.hasAnimations&&!q.hasTransitions);q.applyAnimationDuration=g.duration&&q.hasAnimations;q.applyTransitionDelay=xa(g.delay)&&(q.applyTransitionDuration||
q.hasTransitions);q.applyAnimationDelay=xa(g.delay)&&q.hasAnimations;q.recalculateTimingStyles=0<T.length;if(q.applyTransitionDuration||q.applyAnimationDuration)M=g.duration?parseFloat(g.duration):M,q.applyTransitionDuration&&(q.hasTransitions=!0,D.transitionDuration=M,F=0<h.style[R+"Property"].length,t.push(Ja(M,F))),q.applyAnimationDuration&&(q.hasAnimations=!0,D.animationDuration=M,t.push([Ba,M+"s"]));if(0===M&&!q.recalculateTimingStyles)return L();if(null!=g.delay){var da;"boolean"!==typeof g.delay&&
(da=parseFloat(g.delay),u=Math.max(da,0));q.applyTransitionDelay&&t.push([la,da+"s"]);q.applyAnimationDelay&&t.push([qa,da+"s"])}null==g.duration&&0<D.transitionDuration&&(q.recalculateTimingStyles=q.recalculateTimingStyles||ia);K=1E3*u;U=1E3*M;g.skipBlocking||(q.blockTransition=0<D.transitionDuration,q.blockKeyframeAnimation=0<D.animationDuration&&0<W.animationDelay&&0===W.animationDuration);g.from&&(g.cleanupStyles&&La(I,h,Object.keys(g.from)),Ga(a,g));q.blockTransition||q.blockKeyframeAnimation?
k(M):g.skipBlocking||pa(h,!1);return{$$willAnimate:!0,end:d,start:function(){if(!A)return G={end:d,cancel:s,resume:null,pause:null},w=new e(G),v(E),w}}}}]}]).provider("$$animateCssDriver",["$$animationProvider",function(a){a.drivers.push("$$animateCssDriver");this.$get=["$animateCss","$rootScope","$$AnimateRunner","$rootElement","$sniffer","$$jqLite","$document",function(a,c,d,f,e,m,A){function y(a){return a.replace(/\bng-\S+\b/g,"")}function s(a,b){G(a)&&(a=a.split(" "));G(b)&&(b=b.split(" "));return a.filter(function(a){return-1===
b.indexOf(a)}).join(" ")}function ba(c,e,f){function m(a){var b={},c=z(a).getBoundingClientRect();r(["width","height","top","left"],function(a){var d=c[a];switch(a){case "top":d+=v.scrollTop;break;case "left":d+=v.scrollLeft}b[a]=Math.floor(d)+"px"});return b}function n(){var c=y(f.attr("class")||""),d=s(c,l),c=s(l,c),d=a(A,{to:m(f),addClass:"ng-anchor-in "+d,removeClass:"ng-anchor-out "+c,delay:!0});return d.$$willAnimate?d:null}function p(){A.remove();e.removeClass("ng-animate-shim");f.removeClass("ng-animate-shim")}
var A=w(z(e).cloneNode(!0)),l=y(A.attr("class")||"");e.addClass("ng-animate-shim");f.addClass("ng-animate-shim");A.addClass("ng-anchor");H.append(A);var k;c=function(){var c=a(A,{addClass:"ng-anchor-out",delay:!0,from:m(e)});return c.$$willAnimate?c:null}();if(!c&&(k=n(),!k))return p();var L=c||k;return{start:function(){function a(){c&&c.end()}var b,c=L.start();c.done(function(){c=null;if(!k&&(k=n()))return c=k.start(),c.done(function(){c=null;p();b.complete()}),c;p();b.complete()});return b=new d({end:a,
cancel:a})}}}function C(a,b,c,e){var f=O(a,N),m=O(b,N),y=[];r(e,function(a){(a=ba(c,a.out,a["in"]))&&y.push(a)});if(f||m||0!==y.length)return{start:function(){function a(){r(b,function(a){a.end()})}var b=[];f&&b.push(f.start());m&&b.push(m.start());r(y,function(a){b.push(a.start())});var c=new d({end:a,cancel:a});d.all(b,function(a){c.complete(a)});return c}}}function O(c){var d=c.element,e=c.options||{};c.structural&&(e.event=c.event,e.structural=!0,e.applyClassesEarly=!0,"leave"===c.event&&(e.onDone=
e.domOperation));e.preparationClasses&&(e.event=ea(e.event,e.preparationClasses));c=a(d,e);return c.$$willAnimate?c:null}if(!e.animations&&!e.transitions)return N;var v=A[0].body;c=z(f);var H=w(c.parentNode&&11===c.parentNode.nodeType||v.contains(c)?c:v);return function(a){return a.from&&a.to?C(a.from,a.to,a.classes,a.anchors):O(a)}}]}]).provider("$$animateJs",["$animateProvider",function(a){this.$get=["$injector","$$AnimateRunner","$$jqLite",function(b,c,d){function f(c){c=X(c)?c:c.split(" ");for(var d=
[],e={},f=0;f<c.length;f++){var r=c[f],w=a.$$registeredAnimations[r];w&&!e[r]&&(d.push(b.get(w)),e[r]=!0)}return d}var e=Z(d);return function(a,b,d,s){function w(){s.domOperation();e(a,s)}function C(a,b,d,e,f){switch(d){case "animate":b=[b,e.from,e.to,f];break;case "setClass":b=[b,G,P,f];break;case "addClass":b=[b,G,f];break;case "removeClass":b=[b,P,f];break;default:b=[b,f]}b.push(e);if(a=a.apply(a,b))if(Da(a.start)&&(a=a.start()),a instanceof c)a.done(f);else if(Da(a))return a;return N}function z(a,
b,d,e,f){var l=[];r(e,function(e){var m=e[f];m&&l.push(function(){var e,f,g=!1,h=function(a){g||(g=!0,(f||N)(a),e.complete(!a))};e=new c({end:function(){h()},cancel:function(){h(!0)}});f=C(m,a,b,d,function(a){h(!1===a)});return e})});return l}function v(a,b,d,e,f){var l=z(a,b,d,e,f);if(0===l.length){var h,m;"beforeSetClass"===f?(h=z(a,"removeClass",d,e,"beforeRemoveClass"),m=z(a,"addClass",d,e,"beforeAddClass")):"setClass"===f&&(h=z(a,"removeClass",d,e,"removeClass"),m=z(a,"addClass",d,e,"addClass"));
h&&(l=l.concat(h));m&&(l=l.concat(m))}if(0!==l.length)return function(a){var b=[];l.length&&r(l,function(a){b.push(a())});b.length?c.all(b,a):a();return function(a){r(b,function(b){a?b.cancel():b.end()})}}}var H=!1;3===arguments.length&&ra(d)&&(s=d,d=null);s=oa(s);d||(d=a.attr("class")||"",s.addClass&&(d+=" "+s.addClass),s.removeClass&&(d+=" "+s.removeClass));var G=s.addClass,P=s.removeClass,I=f(d),B,n;if(I.length){var p,K;"leave"===b?(K="leave",p="afterLeave"):(K="before"+b.charAt(0).toUpperCase()+
b.substr(1),p=b);"enter"!==b&&"move"!==b&&(B=v(a,b,s,I,K));n=v(a,b,s,I,p)}if(B||n){var l;return{$$willAnimate:!0,end:function(){l?l.end():(H=!0,w(),ha(a,s),l=new c,l.complete(!0));return l},start:function(){function b(c){H=!0;w();ha(a,s);l.complete(c)}if(l)return l;l=new c;var d,e=[];B&&e.push(function(a){d=B(a)});e.length?e.push(function(a){w();a(!0)}):w();n&&e.push(function(a){d=n(a)});l.setHost({end:function(){H||((d||N)(void 0),b(void 0))},cancel:function(){H||((d||N)(!0),b(!0))}});c.chain(e,
b);return l}}}}}]}]).provider("$$animateJsDriver",["$$animationProvider",function(a){a.drivers.push("$$animateJsDriver");this.$get=["$$animateJs","$$AnimateRunner",function(a,c){function d(c){return a(c.element,c.event,c.classes,c.options)}return function(a){if(a.from&&a.to){var b=d(a.from),m=d(a.to);if(b||m)return{start:function(){function a(){return function(){r(d,function(a){a.end()})}}var d=[];b&&d.push(b.start());m&&d.push(m.start());c.all(d,function(a){f.complete(a)});var f=new c({end:a(),cancel:a()});
return f}}}else return d(a)}}]}])})(window,window.angular);
//# sourceMappingURL=angular-animate.min.js.map

;/*
 AngularJS v1.6.3-build.5293+sha.b7ee5ee
 (c) 2010-2017 Google, Inc. http://angularjs.org
 License: MIT
*/
(function(n,c){'use strict';function l(b,a,g){var d=g.baseHref(),k=b[0];return function(b,e,f){var g,h;f=f||{};h=f.expires;g=c.isDefined(f.path)?f.path:d;c.isUndefined(e)&&(h="Thu, 01 Jan 1970 00:00:00 GMT",e="");c.isString(h)&&(h=new Date(h));e=encodeURIComponent(b)+"="+encodeURIComponent(e);e=e+(g?";path="+g:"")+(f.domain?";domain="+f.domain:"");e+=h?";expires="+h.toUTCString():"";e+=f.secure?";secure":"";f=e.length+1;4096<f&&a.warn("Cookie '"+b+"' possibly not set or overflowed because it was too large ("+
f+" > 4096 bytes)!");k.cookie=e}}c.module("ngCookies",["ng"]).provider("$cookies",[function(){var b=this.defaults={};this.$get=["$$cookieReader","$$cookieWriter",function(a,g){return{get:function(d){return a()[d]},getObject:function(d){return(d=this.get(d))?c.fromJson(d):d},getAll:function(){return a()},put:function(d,a,m){g(d,a,m?c.extend({},b,m):b)},putObject:function(d,b,a){this.put(d,c.toJson(b),a)},remove:function(a,k){g(a,void 0,k?c.extend({},b,k):b)}}}]}]);c.module("ngCookies").factory("$cookieStore",
["$cookies",function(b){return{get:function(a){return b.getObject(a)},put:function(a,c){b.putObject(a,c)},remove:function(a){b.remove(a)}}}]);l.$inject=["$document","$log","$browser"];c.module("ngCookies").provider("$$cookieWriter",function(){this.$get=l})})(window,window.angular);

/*
 AngularJS v1.6.2
 (c) 2010-2017 Google, Inc. http://angularjs.org
 License: MIT
*/
(function(y,l){'use strict';function w(){return["$animate",function(t){return{restrict:"AE",transclude:"element",priority:1,terminal:!0,require:"^^ngMessages",link:function(u,n,a,c,f){var e=n[0],d,r=a.ngMessage||a.when;a=a.ngMessageExp||a.whenExp;var k=function(a){d=a?p(a)?a:a.split(/[\s,]+/):null;c.reRender()};a?(k(u.$eval(a)),u.$watchCollection(a,k)):k(r);var g,s;c.register(e,s={test:function(a){var m=d;a=m?p(m)?0<=m.indexOf(a):m.hasOwnProperty(a):void 0;return a},attach:function(){g||f(function(a,
m){t.enter(a,null,n);g=a;var d=g.$$attachId=c.getAttachId();g.on("$destroy",function(){g&&g.$$attachId===d&&(c.deregister(e),s.detach());m.$destroy()})})},detach:function(){if(g){var a=g;g=null;t.leave(a)}}})}}}]}var v,p,q,x;l.module("ngMessages",[],function(){v=l.forEach;p=l.isArray;q=l.isString;x=l.element}).directive("ngMessages",["$animate",function(t){function u(a,c){return q(c)&&0===c.length||n(a.$eval(c))}function n(a){return q(a)?a.length:!!a}return{require:"ngMessages",restrict:"AE",controller:["$element",
"$scope","$attrs",function(a,c,f){function e(a,c){for(var b=c,d=[];b&&b!==a;){var h=b.$$ngMessageNode;if(h&&h.length)return g[h];b.childNodes.length&&-1===d.indexOf(b)?(d.push(b),b=b.childNodes[b.childNodes.length-1]):b.previousSibling?b=b.previousSibling:(b=b.parentNode,d.push(b))}}var d=this,r=0,k=0;this.getAttachId=function(){return k++};var g=this.messages={},s,l;this.render=function(m){m=m||{};s=!1;l=m;for(var g=u(c,f.ngMessagesMultiple)||u(c,f.multiple),b=[],e={},h=d.head,r=!1,k=0;null!=h;){k++;
var q=h.message,p=!1;r||v(m,function(a,b){!p&&n(a)&&q.test(b)&&!e[b]&&(p=e[b]=!0,q.attach())});p?r=!g:b.push(q);h=h.next}v(b,function(a){a.detach()});b.length!==k?t.setClass(a,"ng-active","ng-inactive"):t.setClass(a,"ng-inactive","ng-active")};c.$watchCollection(f.ngMessages||f["for"],d.render);a.on("$destroy",function(){v(g,function(a){a.message.detach()})});this.reRender=function(){s||(s=!0,c.$evalAsync(function(){s&&l&&d.render(l)}))};this.register=function(c,f){var b=r.toString();g[b]={message:f};
var k=a[0],h=g[b];d.head?(k=e(k,c))?(h.next=k.next,k.next=h):(h.next=d.head,d.head=h):d.head=h;c.$$ngMessageNode=b;r++;d.reRender()};this.deregister=function(c){var f=c.$$ngMessageNode;delete c.$$ngMessageNode;var b=g[f];(c=e(a[0],c))?c.next=b.next:d.head=b.next;delete g[f];d.reRender()}}]}}]).directive("ngMessagesInclude",["$templateRequest","$document","$compile",function(l,p,n){function a(a,f){var e=n.$$createComment?n.$$createComment("ngMessagesInclude",f):p[0].createComment(" ngMessagesInclude: "+
f+" "),e=x(e);a.after(e);a.remove()}return{restrict:"AE",require:"^^ngMessages",link:function(c,f,e){var d=e.ngMessagesInclude||e.src;l(d).then(function(e){c.$$destroyed||(q(e)&&!e.trim()?a(f,d):n(e)(c,function(c){f.after(c);a(f,d)}))})}}}]).directive("ngMessage",w()).directive("ngMessageExp",w())})(window,window.angular);
//# sourceMappingURL=angular-messages.min.js.map

;/*
Trix 0.9.2
Copyright © 2015 Basecamp, LLC
http://trix-editor.org/
 */
(function(){}).call(this),function(){var t;null==window.Set&&(window.Set=t=function(){function t(){this.clear()}return t.prototype.clear=function(){return this.values=[]},t.prototype.has=function(t){return-1!==this.values.indexOf(t)},t.prototype.add=function(t){return this.has(t)||this.values.push(t),this},t.prototype["delete"]=function(t){var e;return-1===(e=this.values.indexOf(t))?!1:(this.values.splice(e,1),!0)},t.prototype.forEach=function(){var t;return(t=this.values).forEach.apply(t,arguments)},t}())}.call(this),/*
https://github.com/taylorhakes/promise-polyfill
Copyright (c) 2014 Taylor Hakes
Copyright (c) 2014 Forbes Lindesay
*/
function(t){function e(t,e){return function(){t.apply(e,arguments)}}function n(t){if("object"!=typeof this)throw new TypeError("Promises must be constructed via new");if("function"!=typeof t)throw new TypeError("not a function");this._state=null,this._value=null,this._deferreds=[],u(t,e(o,this),e(r,this))}function i(t){var e=this;return null===this._state?void this._deferreds.push(t):void c(function(){var n=e._state?t.onFulfilled:t.onRejected;if(null===n)return void(e._state?t.resolve:t.reject)(e._value);var i;try{i=n(e._value)}catch(o){return void t.reject(o)}t.resolve(i)})}function o(t){try{if(t===this)throw new TypeError("A promise cannot be resolved with itself.");if(t&&("object"==typeof t||"function"==typeof t)){var n=t.then;if("function"==typeof n)return void u(e(n,t),e(o,this),e(r,this))}this._state=!0,this._value=t,s.call(this)}catch(i){r.call(this,i)}}function r(t){this._state=!1,this._value=t,s.call(this)}function s(){for(var t=0,e=this._deferreds.length;e>t;t++)i.call(this,this._deferreds[t]);this._deferreds=null}function a(t,e,n,i){this.onFulfilled="function"==typeof t?t:null,this.onRejected="function"==typeof e?e:null,this.resolve=n,this.reject=i}function u(t,e,n){var i=!1;try{t(function(t){i||(i=!0,e(t))},function(t){i||(i=!0,n(t))})}catch(o){if(i)return;i=!0,n(o)}}var c="function"==typeof setImmediate&&setImmediate||function(t){setTimeout(t,1)},l=Array.isArray||function(t){return"[object Array]"===Object.prototype.toString.call(t)};n.prototype["catch"]=function(t){return this.then(null,t)},n.prototype.then=function(t,e){var o=this;return new n(function(n,r){i.call(o,new a(t,e,n,r))})},n.all=function(){var t=Array.prototype.slice.call(1===arguments.length&&l(arguments[0])?arguments[0]:arguments);return new n(function(e,n){function i(r,s){try{if(s&&("object"==typeof s||"function"==typeof s)){var a=s.then;if("function"==typeof a)return void a.call(s,function(t){i(r,t)},n)}t[r]=s,0===--o&&e(t)}catch(u){n(u)}}if(0===t.length)return e([]);for(var o=t.length,r=0;r<t.length;r++)i(r,t[r])})},n.resolve=function(t){return t&&"object"==typeof t&&t.constructor===n?t:new n(function(e){e(t)})},n.reject=function(t){return new n(function(e,n){n(t)})},n.race=function(t){return new n(function(e,n){for(var i=0,o=t.length;o>i;i++)t[i].then(e,n)})},n._setImmediateFn=function(t){c=t},"undefined"!=typeof module&&module.exports?module.exports=n:t.Promise||(t.Promise=n)}(this),/**
 * @license
 * Copyright (c) 2014 The Polymer Project Authors. All rights reserved.
 * This code may only be used under the BSD style license found at http://polymer.github.io/LICENSE.txt
 * The complete set of authors may be found at http://polymer.github.io/AUTHORS.txt
 * The complete set of contributors may be found at http://polymer.github.io/CONTRIBUTORS.txt
 * Code distributed by Google as part of the polymer project is also
 * subject to an additional IP rights grant found at http://polymer.github.io/PATENTS.txt
 */
"undefined"==typeof WeakMap&&!function(){var t=Object.defineProperty,e=Date.now()%1e9,n=function(){this.name="__st"+(1e9*Math.random()>>>0)+(e++ +"__")};n.prototype={set:function(e,n){var i=e[this.name];return i&&i[0]===e?i[1]=n:t(e,this.name,{value:[e,n],writable:!0}),this},get:function(t){var e;return(e=t[this.name])&&e[0]===t?e[1]:void 0},"delete":function(t){var e=t[this.name];return e&&e[0]===t?(e[0]=e[1]=void 0,!0):!1},has:function(t){var e=t[this.name];return e?e[0]===t:!1}},window.WeakMap=n}(),function(t){function e(t){A.push(t),b||(b=!0,g(i))}function n(t){return window.ShadowDOMPolyfill&&window.ShadowDOMPolyfill.wrapIfNeeded(t)||t}function i(){b=!1;var t=A;A=[],t.sort(function(t,e){return t.uid_-e.uid_});var e=!1;t.forEach(function(t){var n=t.takeRecords();o(t),n.length&&(t.callback_(n,t),e=!0)}),e&&i()}function o(t){t.nodes_.forEach(function(e){var n=m.get(e);n&&n.forEach(function(e){e.observer===t&&e.removeTransientObservers()})})}function r(t,e){for(var n=t;n;n=n.parentNode){var i=m.get(n);if(i)for(var o=0;o<i.length;o++){var r=i[o],s=r.options;if(n===t||s.subtree){var a=e(s);a&&r.enqueue(a)}}}}function s(t){this.callback_=t,this.nodes_=[],this.records_=[],this.uid_=++x}function a(t,e){this.type=t,this.target=e,this.addedNodes=[],this.removedNodes=[],this.previousSibling=null,this.nextSibling=null,this.attributeName=null,this.attributeNamespace=null,this.oldValue=null}function u(t){var e=new a(t.type,t.target);return e.addedNodes=t.addedNodes.slice(),e.removedNodes=t.removedNodes.slice(),e.previousSibling=t.previousSibling,e.nextSibling=t.nextSibling,e.attributeName=t.attributeName,e.attributeNamespace=t.attributeNamespace,e.oldValue=t.oldValue,e}function c(t,e){return T=new a(t,e)}function l(t){return C?C:(C=u(T),C.oldValue=t,C)}function h(){T=C=void 0}function p(t){return t===C||t===T}function d(t,e){return t===e?t:C&&p(t)?C:null}function f(t,e,n){this.observer=t,this.target=e,this.options=n,this.transientObservedNodes=[]}var g,m=new WeakMap;if(/Trident|Edge/.test(navigator.userAgent))g=setTimeout;else if(window.setImmediate)g=window.setImmediate;else{var y=[],v=String(Math.random());window.addEventListener("message",function(t){if(t.data===v){var e=y;y=[],e.forEach(function(t){t()})}}),g=function(t){y.push(t),window.postMessage(v,"*")}}var b=!1,A=[],x=0;s.prototype={observe:function(t,e){if(t=n(t),!e.childList&&!e.attributes&&!e.characterData||e.attributeOldValue&&!e.attributes||e.attributeFilter&&e.attributeFilter.length&&!e.attributes||e.characterDataOldValue&&!e.characterData)throw new SyntaxError;var i=m.get(t);i||m.set(t,i=[]);for(var o,r=0;r<i.length;r++)if(i[r].observer===this){o=i[r],o.removeListeners(),o.options=e;break}o||(o=new f(this,t,e),i.push(o),this.nodes_.push(t)),o.addListeners()},disconnect:function(){this.nodes_.forEach(function(t){for(var e=m.get(t),n=0;n<e.length;n++){var i=e[n];if(i.observer===this){i.removeListeners(),e.splice(n,1);break}}},this),this.records_=[]},takeRecords:function(){var t=this.records_;return this.records_=[],t}};var T,C;f.prototype={enqueue:function(t){var n=this.observer.records_,i=n.length;if(n.length>0){var o=n[i-1],r=d(o,t);if(r)return void(n[i-1]=r)}else e(this.observer);n[i]=t},addListeners:function(){this.addListeners_(this.target)},addListeners_:function(t){var e=this.options;e.attributes&&t.addEventListener("DOMAttrModified",this,!0),e.characterData&&t.addEventListener("DOMCharacterDataModified",this,!0),e.childList&&t.addEventListener("DOMNodeInserted",this,!0),(e.childList||e.subtree)&&t.addEventListener("DOMNodeRemoved",this,!0)},removeListeners:function(){this.removeListeners_(this.target)},removeListeners_:function(t){var e=this.options;e.attributes&&t.removeEventListener("DOMAttrModified",this,!0),e.characterData&&t.removeEventListener("DOMCharacterDataModified",this,!0),e.childList&&t.removeEventListener("DOMNodeInserted",this,!0),(e.childList||e.subtree)&&t.removeEventListener("DOMNodeRemoved",this,!0)},addTransientObserver:function(t){if(t!==this.target){this.addListeners_(t),this.transientObservedNodes.push(t);var e=m.get(t);e||m.set(t,e=[]),e.push(this)}},removeTransientObservers:function(){var t=this.transientObservedNodes;this.transientObservedNodes=[],t.forEach(function(t){this.removeListeners_(t);for(var e=m.get(t),n=0;n<e.length;n++)if(e[n]===this){e.splice(n,1);break}},this)},handleEvent:function(t){switch(t.stopImmediatePropagation(),t.type){case"DOMAttrModified":var e=t.attrName,n=t.relatedNode.namespaceURI,i=t.target,o=new c("attributes",i);o.attributeName=e,o.attributeNamespace=n;var s=t.attrChange===MutationEvent.ADDITION?null:t.prevValue;r(i,function(t){return!t.attributes||t.attributeFilter&&t.attributeFilter.length&&-1===t.attributeFilter.indexOf(e)&&-1===t.attributeFilter.indexOf(n)?void 0:t.attributeOldValue?l(s):o});break;case"DOMCharacterDataModified":var i=t.target,o=c("characterData",i),s=t.prevValue;r(i,function(t){return t.characterData?t.characterDataOldValue?l(s):o:void 0});break;case"DOMNodeRemoved":this.addTransientObserver(t.target);case"DOMNodeInserted":var a,u,p=t.target;"DOMNodeInserted"===t.type?(a=[p],u=[]):(a=[],u=[p]);var d=p.previousSibling,f=p.nextSibling,o=c("childList",t.target.parentNode);o.addedNodes=a,o.removedNodes=u,o.previousSibling=d,o.nextSibling=f,r(t.relatedNode,function(t){return t.childList?o:void 0})}h()}},t.JsMutationObserver=s,t.MutationObserver||(t.MutationObserver=s)}(self),window.CustomElements=window.CustomElements||{flags:{}},function(t){var e=t.flags,n=[],i=function(t){n.push(t)},o=function(){n.forEach(function(e){e(t)})};t.addModule=i,t.initializeModules=o,t.hasNative=Boolean(document.registerElement),t.isIE=/Trident/.test(navigator.userAgent),t.useNative=!e.register&&t.hasNative&&!window.ShadowDOMPolyfill&&(!window.HTMLImports||window.HTMLImports.useNative)}(window.CustomElements),window.CustomElements.addModule(function(t){function e(t,e){n(t,function(t){return e(t)?!0:void i(t,e)}),i(t,e)}function n(t,e,i){var o=t.firstElementChild;if(!o)for(o=t.firstChild;o&&o.nodeType!==Node.ELEMENT_NODE;)o=o.nextSibling;for(;o;)e(o,i)!==!0&&n(o,e,i),o=o.nextElementSibling;return null}function i(t,n){for(var i=t.shadowRoot;i;)e(i,n),i=i.olderShadowRoot}function o(t,e){r(t,e,[])}function r(t,e,n){if(t=window.wrap(t),!(n.indexOf(t)>=0)){n.push(t);for(var i,o=t.querySelectorAll("link[rel="+s+"]"),a=0,u=o.length;u>a&&(i=o[a]);a++)i.import&&r(i.import,e,n);e(t)}}var s=window.HTMLImports?window.HTMLImports.IMPORT_LINK_TYPE:"none";t.forDocumentTree=o,t.forSubtree=e}),window.CustomElements.addModule(function(t){function e(t,e){return n(t,e)||i(t,e)}function n(e,n){return t.upgrade(e,n)?!0:void(n&&s(e))}function i(t,e){b(t,function(t){return n(t,e)?!0:void 0})}function o(t){C.push(t),T||(T=!0,setTimeout(r))}function r(){T=!1;for(var t,e=C,n=0,i=e.length;i>n&&(t=e[n]);n++)t();C=[]}function s(t){x?o(function(){a(t)}):a(t)}function a(t){t.__upgraded__&&!t.__attached&&(t.__attached=!0,t.attachedCallback&&t.attachedCallback())}function u(t){c(t),b(t,function(t){c(t)})}function c(t){x?o(function(){l(t)}):l(t)}function l(t){t.__upgraded__&&t.__attached&&(t.__attached=!1,t.detachedCallback&&t.detachedCallback())}function h(t){for(var e=t,n=window.wrap(document);e;){if(e==n)return!0;e=e.parentNode||e.nodeType===Node.DOCUMENT_FRAGMENT_NODE&&e.host}}function p(t){if(t.shadowRoot&&!t.shadowRoot.__watched){v.dom&&console.log("watching shadow-root for: ",t.localName);for(var e=t.shadowRoot;e;)g(e),e=e.olderShadowRoot}}function d(t,n){if(v.dom){var i=n[0];if(i&&"childList"===i.type&&i.addedNodes&&i.addedNodes){for(var o=i.addedNodes[0];o&&o!==document&&!o.host;)o=o.parentNode;var r=o&&(o.URL||o._URL||o.host&&o.host.localName)||"";r=r.split("/?").shift().split("/").pop()}console.group("mutations (%d) [%s]",n.length,r||"")}var s=h(t);n.forEach(function(t){"childList"===t.type&&(w(t.addedNodes,function(t){t.localName&&e(t,s)}),w(t.removedNodes,function(t){t.localName&&u(t)}))}),v.dom&&console.groupEnd()}function f(t){for(t=window.wrap(t),t||(t=window.wrap(document));t.parentNode;)t=t.parentNode;var e=t.__observer;e&&(d(t,e.takeRecords()),r())}function g(t){if(!t.__observer){var e=new MutationObserver(d.bind(this,t));e.observe(t,{childList:!0,subtree:!0}),t.__observer=e}}function m(t){t=window.wrap(t),v.dom&&console.group("upgradeDocument: ",t.baseURI.split("/").pop());var n=t===window.wrap(document);e(t,n),g(t),v.dom&&console.groupEnd()}function y(t){A(t,m)}var v=t.flags,b=t.forSubtree,A=t.forDocumentTree,x=!window.MutationObserver||window.MutationObserver===window.JsMutationObserver;t.hasPolyfillMutations=x;var T=!1,C=[],w=Array.prototype.forEach.call.bind(Array.prototype.forEach),E=Element.prototype.createShadowRoot;E&&(Element.prototype.createShadowRoot=function(){var t=E.call(this);return window.CustomElements.watchShadow(this),t}),t.watchShadow=p,t.upgradeDocumentTree=y,t.upgradeDocument=m,t.upgradeSubtree=i,t.upgradeAll=e,t.attached=s,t.takeRecords=f}),window.CustomElements.addModule(function(t){function e(e,i){if(!e.__upgraded__&&e.nodeType===Node.ELEMENT_NODE){var o=e.getAttribute("is"),r=t.getRegisteredDefinition(e.localName)||t.getRegisteredDefinition(o);if(r&&(o&&r.tag==e.localName||!o&&!r.extends))return n(e,r,i)}}function n(e,n,o){return s.upgrade&&console.group("upgrade:",e.localName),n.is&&e.setAttribute("is",n.is),i(e,n),e.__upgraded__=!0,r(e),o&&t.attached(e),t.upgradeSubtree(e,o),s.upgrade&&console.groupEnd(),e}function i(t,e){Object.__proto__?t.__proto__=e.prototype:(o(t,e.prototype,e.native),t.__proto__=e.prototype)}function o(t,e,n){for(var i={},o=e;o!==n&&o!==HTMLElement.prototype;){for(var r,s=Object.getOwnPropertyNames(o),a=0;r=s[a];a++)i[r]||(Object.defineProperty(t,r,Object.getOwnPropertyDescriptor(o,r)),i[r]=1);o=Object.getPrototypeOf(o)}}function r(t){t.createdCallback&&t.createdCallback()}var s=t.flags;t.upgrade=e,t.upgradeWithDefinition=n,t.implementPrototype=i}),window.CustomElements.addModule(function(t){function e(e,i){var u=i||{};if(!e)throw new Error("document.registerElement: first argument `name` must not be empty");if(e.indexOf("-")<0)throw new Error("document.registerElement: first argument ('name') must contain a dash ('-'). Argument provided was '"+String(e)+"'.");if(o(e))throw new Error("Failed to execute 'registerElement' on 'Document': Registration failed for type '"+String(e)+"'. The type name is invalid.");if(c(e))throw new Error("DuplicateDefinitionError: a type with name '"+String(e)+"' is already registered");return u.prototype||(u.prototype=Object.create(HTMLElement.prototype)),u.__name=e.toLowerCase(),u.lifecycle=u.lifecycle||{},u.ancestry=r(u.extends),s(u),a(u),n(u.prototype),l(u.__name,u),u.ctor=h(u),u.ctor.prototype=u.prototype,u.prototype.constructor=u.ctor,t.ready&&y(document),u.ctor}function n(t){if(!t.setAttribute._polyfilled){var e=t.setAttribute;t.setAttribute=function(t,n){i.call(this,t,n,e)};var n=t.removeAttribute;t.removeAttribute=function(t){i.call(this,t,null,n)},t.setAttribute._polyfilled=!0}}function i(t,e,n){t=t.toLowerCase();var i=this.getAttribute(t);n.apply(this,arguments);var o=this.getAttribute(t);this.attributeChangedCallback&&o!==i&&this.attributeChangedCallback(t,i,o)}function o(t){for(var e=0;e<T.length;e++)if(t===T[e])return!0}function r(t){var e=c(t);return e?r(e.extends).concat([e]):[]}function s(t){for(var e,n=t.extends,i=0;e=t.ancestry[i];i++)n=e.is&&e.tag;t.tag=n||t.__name,n&&(t.is=t.__name)}function a(t){if(!Object.__proto__){var e=HTMLElement.prototype;if(t.is){var n=document.createElement(t.tag);e=Object.getPrototypeOf(n)}for(var i,o=t.prototype,r=!1;o;)o==e&&(r=!0),i=Object.getPrototypeOf(o),i&&(o.__proto__=i),o=i;r||console.warn(t.tag+" prototype not found in prototype chain for "+t.is),t.native=e}}function u(t){return b(E(t.tag),t)}function c(t){return t?C[t.toLowerCase()]:void 0}function l(t,e){C[t]=e}function h(t){return function(){return u(t)}}function p(t,e,n){return t===w?d(e,n):S(t,e)}function d(t,e){t&&(t=t.toLowerCase()),e&&(e=e.toLowerCase());var n=c(e||t);if(n){if(t==n.tag&&e==n.is)return new n.ctor;if(!e&&!n.is)return new n.ctor}var i;return e?(i=d(t),i.setAttribute("is",e),i):(i=E(t),t.indexOf("-")>=0&&A(i,HTMLElement),i)}function f(t,e){var n=t[e];t[e]=function(){var t=n.apply(this,arguments);return v(t),t}}var g,m=t.isIE,y=t.upgradeDocumentTree,v=t.upgradeAll,b=t.upgradeWithDefinition,A=t.implementPrototype,x=t.useNative,T=["annotation-xml","color-profile","font-face","font-face-src","font-face-uri","font-face-format","font-face-name","missing-glyph"],C={},w="http://www.w3.org/1999/xhtml",E=document.createElement.bind(document),S=document.createElementNS.bind(document);g=Object.__proto__||x?function(t,e){return t instanceof e}:function(t,e){if(t instanceof e)return!0;for(var n=t;n;){if(n===e.prototype)return!0;n=n.__proto__}return!1},f(Node.prototype,"cloneNode"),f(document,"importNode"),m&&!function(){var t=document.importNode;document.importNode=function(){var e=t.apply(document,arguments);if(e.nodeType==e.DOCUMENT_FRAGMENT_NODE){var n=document.createDocumentFragment();return n.appendChild(e),n}return e}}(),document.registerElement=e,document.createElement=d,document.createElementNS=p,t.registry=C,t.instanceof=g,t.reservedTagList=T,t.getRegisteredDefinition=c,document.register=document.registerElement}),function(t){function e(){s(window.wrap(document)),window.CustomElements.ready=!0;var t=window.requestAnimationFrame||function(t){setTimeout(t,16)};t(function(){setTimeout(function(){window.CustomElements.readyTime=Date.now(),window.HTMLImports&&(window.CustomElements.elapsed=window.CustomElements.readyTime-window.HTMLImports.readyTime),document.dispatchEvent(new CustomEvent("WebComponentsReady",{bubbles:!0}))})})}var n=t.useNative,i=t.initializeModules,o=t.isIE;if(n){var r=function(){};t.watchShadow=r,t.upgrade=r,t.upgradeAll=r,t.upgradeDocumentTree=r,t.upgradeSubtree=r,t.takeRecords=r,t.instanceof=function(t,e){return t instanceof e}}else i();var s=t.upgradeDocumentTree,a=t.upgradeDocument;if(window.wrap||(window.ShadowDOMPolyfill?(window.wrap=window.ShadowDOMPolyfill.wrapIfNeeded,window.unwrap=window.ShadowDOMPolyfill.unwrapIfNeeded):window.wrap=window.unwrap=function(t){return t}),window.HTMLImports&&(window.HTMLImports.__importsParsingHook=function(t){t.import&&a(wrap(t.import))}),(!window.CustomEvent||o&&"function"!=typeof window.CustomEvent)&&(window.CustomEvent=function(t,e){e=e||{};var n=document.createEvent("CustomEvent");return n.initCustomEvent(t,Boolean(e.bubbles),Boolean(e.cancelable),e.detail),n.preventDefault=function(){Object.defineProperty(this,"defaultPrevented",{get:function(){return!0}})},n},window.CustomEvent.prototype=window.Event.prototype),"complete"===document.readyState||t.flags.eager)e();else if("interactive"!==document.readyState||window.attachEvent||window.HTMLImports&&!window.HTMLImports.ready){var u=window.HTMLImports&&!window.HTMLImports.ready?"HTMLImportsLoaded":"DOMContentLoaded";window.addEventListener(u,e)}else e()}(window.CustomElements),function(){}.call(this),function(){this.Trix={VERSION:"0.9.2",ZERO_WIDTH_SPACE:"\ufeff",NON_BREAKING_SPACE:"\xa0",OBJECT_REPLACEMENT_CHARACTER:"\ufffc",config:{}}}.call(this),function(){Trix.BasicObject=function(){function t(){}var e,n,i;return t.proxyMethod=function(t){var i,o,r,s,a;return r=n(t),i=r.name,s=r.toMethod,a=r.toProperty,o=r.optional,this.prototype[i]=function(){var t,n;return t=null!=s?o?"function"==typeof this[s]?this[s]():void 0:this[s]():null!=a?this[a]:void 0,o?(n=null!=t?t[i]:void 0,null!=n?e.call(n,t,arguments):void 0):(n=t[i],e.call(n,t,arguments))}},n=function(t){var e,n;if(!(n=t.match(i)))throw new Error("can't parse @proxyMethod expression: "+t);return e={name:n[4]},null!=n[2]?e.toMethod=n[1]:e.toProperty=n[1],null!=n[3]&&(e.optional=!0),e},e=Function.prototype.apply,i=/^(.+?)(\(\))?(\?)?\.(.+?)$/,t}()}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Object=function(e){function n(){this.id=++i}var i;return t(n,e),i=0,n.fromJSONString=function(t){return this.fromJSON(JSON.parse(t))},n.prototype.hasSameConstructorAs=function(t){return this.constructor===(null!=t?t.constructor:void 0)},n.prototype.isEqualTo=function(t){return this===t},n.prototype.inspect=function(){var t,e,n;return t=function(){var t,i,o;i=null!=(t=this.contentsForInspection())?t:{},o=[];for(e in i)n=i[e],o.push(e+"="+n);return o}.call(this),"#<"+this.constructor.name+":"+this.id+(t.length?" "+t.join(", "):"")+">"},n.prototype.contentsForInspection=function(){},n.prototype.toJSONString=function(){return JSON.stringify(this)},n.prototype.toUTF16String=function(){return Trix.UTF16String.box(this)},n.prototype.getCacheKey=function(){return this.id.toString()},n}(Trix.BasicObject)}.call(this),function(){Trix.extend=function(t){var e,n;for(e in t)n=t[e],this[e]=n;return this}}.call(this),function(){var t,e;Trix.extend({defer:function(t){return setTimeout(t,1)},memoize:function(t){var n;return n=e++,function(){var e;return null==this.memos&&(this.memos={}),null!=(e=this.memos)[n]?e[n]:e[n]=t.apply(this,arguments)}}}),e=0,t=function(t){var e,n;return null!=(e=null!=(n=null!=t&&"function"==typeof t.inspect?t.inspect():void 0)?n:function(){try{return JSON.stringify(t)}catch(e){}}())?e:t}}.call(this),function(){var t,e;Trix.extend({normalizeSpaces:function(t){return t.replace(RegExp(""+Trix.ZERO_WIDTH_SPACE,"g"),"").replace(RegExp(""+Trix.NON_BREAKING_SPACE,"g")," ")},summarizeStringChange:function(t,n){var i,o,r,s;return t=Trix.UTF16String.box(t),n=Trix.UTF16String.box(n),n.length<t.length?(o=e(t,n),s=o[0],i=o[1]):(r=e(n,t),i=r[0],s=r[1]),{added:i,removed:s}}}),e=function(e,n){var i,o,r,s,a;return e.isEqualTo(n)?["",""]:(o=t(e,n),s=o.utf16String.length,r=s?(a=o.offset,o,i=e.codepoints.slice(0,a).concat(e.codepoints.slice(a+s)),t(n,Trix.UTF16String.fromCodepoints(i))):t(n,e),[o.utf16String.toString(),r.utf16String.toString()])},t=function(t,e){var n,i,o;for(n=0,i=t.length,o=e.length;i>n&&t.charAt(n).isEqualTo(e.charAt(n));)n++;for(;i>n+1&&t.charAt(i-1).isEqualTo(e.charAt(o-1));)i--,o--;return{utf16String:t.slice(n,i),offset:n}}}.call(this),function(){Trix.extend({arraysAreEqual:function(t,e){var n,i,o,r;if(null==t&&(t=[]),null==e&&(e=[]),t.length!==e.length)return!1;for(i=n=0,o=t.length;o>n;i=++n)if(r=t[i],r!==e[i])return!1;return!0},objectsAreEqual:function(t,e){var n,i;if(null==t&&(t={}),null==e&&(e={}),Object.keys(t).length!==Object.keys(e).length)return!1;for(n in t)if(i=t[n],i!==e[n])return!1;return!0},summarizeArrayChange:function(t,e){var n,i,o,r,s,a,u,c,l,h,p;for(null==t&&(t=[]),null==e&&(e=[]),n=[],h=[],o=new Set,r=0,u=t.length;u>r;r++)p=t[r],o.add(p);for(i=new Set,s=0,c=e.length;c>s;s++)p=e[s],i.add(p),o.has(p)||n.push(p);for(a=0,l=t.length;l>a;a++)p=t[a],i.has(p)||h.push(p);return{added:n,removed:h}}})}.call(this),function(){var t,e,n,i,o;t=document.documentElement,e=null!=(n=null!=(i=null!=(o=t.matchesSelector)?o:t.webkitMatchesSelector)?i:t.msMatchesSelector)?n:t.mozMatchesSelector,Trix.extend({handleEvent:function(e,n){var i,o,r,s,a,u,c,l,h,p,d,f;return l=null!=n?n:{},u=l.onElement,a=l.matchingSelector,f=l.withCallback,s=l.inPhase,c=l.preventDefault,p=l.times,o=null!=u?u:t,h=a,i=f,d="capturing"===s,r=function(t){var e;return null!=p&&0===--p&&r.destroy(),e=Trix.findClosestElementFromNode(t.target,{matchingSelector:h}),null!=e&&(null!=f&&f.call(e,t,e),c)?t.preventDefault():void 0},r.destroy=function(){return o.removeEventListener(e,r,d)},o.addEventListener(e,r,d),r},handleEventOnce:function(t,e){return null==e&&(e={}),e.times=1,Trix.handleEvent(t,e)},triggerEvent:function(e,n){var i,o,r,s,a,u,c;return c=null!=n?n:{},u=c.onElement,o=c.bubbles,r=c.cancelable,i=c.attributes,s=null!=u?u:t,o=o!==!1,r=r!==!1,a=document.createEvent("Events"),a.initEvent(e,o,r),null!=i&&Trix.extend.call(a,i),s.dispatchEvent(a)},elementMatchesSelector:function(t,n){return 1===(null!=t?t.nodeType:void 0)?e.call(t,n):void 0},findClosestElementFromNode:function(t,e){var n;for(n=(null!=e?e:{}).matchingSelector;null!=t&&t.nodeType!==Node.ELEMENT_NODE;)t=t.parentNode;if(null==n)return t;for(;t;){if(Trix.elementMatchesSelector(t,n))return t;t=t.parentNode}},findInnerElement:function(t){for(;null!=t?t.firstElementChild:void 0;)t=t.firstElementChild;return t},innerElementIsActive:function(t){return document.activeElement!==t&&Trix.elementContainsNode(t,document.activeElement)},elementContainsNode:function(t,e){if(t&&e)for(;e;){if(e===t)return!0;e=e.parentNode}},findNodeFromContainerAndOffset:function(t,e){var n;if(t)return t.nodeType===Node.TEXT_NODE?t:0===e?null!=(n=t.firstChild)?n:t:t.childNodes.item(e-1)},findElementFromContainerAndOffset:function(t,e){var n;return n=Trix.findNodeFromContainerAndOffset(t,e),Trix.findClosestElementFromNode(n)},findChildIndexOfNode:function(t){var e;if(null!=t?t.parentNode:void 0){for(e=0;t=t.previousSibling;)e++;return e}},measureElement:function(t){return{width:t.offsetWidth,height:t.offsetHeight}},walkTree:function(t,e){var n,i,o,r,s;return o=null!=e?e:{},i=o.onlyNodesOfType,r=o.usingFilter,n=o.expandEntityReferences,s=function(){switch(i){case"element":return NodeFilter.SHOW_ELEMENT;case"text":return NodeFilter.SHOW_TEXT;case"comment":return NodeFilter.SHOW_COMMENT;default:return NodeFilter.SHOW_ALL}}(),document.createTreeWalker(t,s,null!=r?r:null,n===!0)},tagName:function(t){var e;return null!=t&&null!=(e=t.tagName)?e.toLowerCase():void 0},makeElement:function(t,e){var n,i,o,r,s,a,u,c,l,h;if(null==e&&(e={}),"object"==typeof t?(e=t,t=e.tagName):e={attributes:e},i=document.createElement(t),null!=e.editable&&(null==e.attributes&&(e.attributes={}),e.attributes.contenteditable=e.editable),e.attributes){a=e.attributes;for(r in a)h=a[r],i.setAttribute(r,h)}if(e.style){u=e.style;for(r in u)h=u[r],i.style[r]=h}if(e.data){c=e.data;for(r in c)h=c[r],i.dataset[r]=h}if(e.className)for(l=e.className.split(" "),o=0,s=l.length;s>o;o++)n=l[o],i.classList.add(n);return e.textContent&&(i.textContent=e.textContent),i},cloneFragment:function(t){var e,n,i,o,r;for(e=document.createDocumentFragment(),r=t.childNodes,n=0,i=r.length;i>n;n++)o=r[n],e.appendChild(o.cloneNode(!0));return e},makeFragment:function(t){var e,n,i;for(null==t&&(t=""),e=document.createElement("div"),e.innerHTML=t,n=document.createDocumentFragment();i=e.firstChild;)n.appendChild(i);return n},nodeIsBlockContainer:function(t){return Trix.nodeIsBlockStartComment(null!=t?t.firstChild:void 0)},nodeIsBlockStartComment:function(t){return Trix.nodeIsCommentNode(t)&&"block"===(null!=t?t.data:void 0)},nodeIsCommentNode:function(t){return(null!=t?t.nodeType:void 0)===Node.COMMENT_NODE},nodeIsCursorTarget:function(t){return t?Trix.nodeIsTextNode(t)?t.data===Trix.ZERO_WIDTH_SPACE:Trix.nodeIsCursorTarget(t.firstChild):void 0},nodeIsAttachmentElement:function(t){return Trix.elementMatchesSelector(t,Trix.AttachmentView.attachmentSelector)},nodeIsEmptyTextNode:function(t){return Trix.nodeIsTextNode(t)&&""===(null!=t?t.data:void 0)},nodeIsTextNode:function(t){return(null!=t?t.nodeType:void 0)===Node.TEXT_NODE}})}.call(this),function(){var t,e=function(t,e){function i(){this.constructor=t}for(var o in e)n.call(e,o)&&(t[o]=e[o]);return i.prototype=e.prototype,t.prototype=new i,t.__super__=e.prototype,t},n={}.hasOwnProperty;t=Trix.arraysAreEqual,Trix.Hash=function(n){function i(t){null==t&&(t={}),this.values=r(t),i.__super__.constructor.apply(this,arguments)}var o,r,s,a,u;return e(i,n),i.fromCommonAttributesOfObjects=function(t){var e,n,i,r,s,a;if(null==t&&(t=[]),!t.length)return new this;for(e=o(t[0]),i=e.getKeys(),a=t.slice(1),n=0,r=a.length;r>n;n++)s=a[n],i=e.getKeysCommonToHash(o(s)),e=e.slice(i);return e},i.box=function(t){return o(t)},i.prototype.add=function(t,e){return this.merge(a(t,e))},i.prototype.remove=function(t){return new Trix.Hash(r(this.values,t))},i.prototype.get=function(t){return this.values[t]},i.prototype.has=function(t){return t in this.values},i.prototype.merge=function(t){return new Trix.Hash(s(this.values,u(t)))},i.prototype.slice=function(t){var e,n,i,o;for(o={},e=0,i=t.length;i>e;e++)n=t[e],this.has(n)&&(o[n]=this.values[n]);return new Trix.Hash(o)},i.prototype.getKeys=function(){return Object.keys(this.values)},i.prototype.getKeysCommonToHash=function(t){var e,n,i,r,s;for(t=o(t),r=this.getKeys(),s=[],e=0,i=r.length;i>e;e++)n=r[e],this.values[n]===t.values[n]&&s.push(n);return s},i.prototype.isEqualTo=function(e){return t(this.toArray(),o(e).toArray())},i.prototype.isEmpty=function(){return 0===this.getKeys().length},i.prototype.toArray=function(){var t,e,n;return(null!=this.array?this.array:this.array=function(){var i;e=[],i=this.values;for(t in i)n=i[t],e.push(t,n);return e}.call(this)).slice(0)},i.prototype.toObject=function(){return r(this.values)},i.prototype.toJSON=function(){return this.toObject()},i.prototype.contentsForInspection=function(){return{values:JSON.stringify(this.values)}},a=function(t,e){var n;return n={},n[t]=e,n},s=function(t,e){var n,i,o;i=r(t);for(n in e)o=e[n],i[n]=o;return i},r=function(t,e){var n,i,o,r,s;for(r={},s=Object.keys(t).sort(),n=0,o=s.length;o>n;n++)i=s[n],i!==e&&(r[i]=t[i]);return r},o=function(t){return t instanceof Trix.Hash?t:new Trix.Hash(t)},u=function(t){return t instanceof Trix.Hash?t.values:t},i}(Trix.Object)}.call(this),function(){var t,e,n;Trix.extend({normalizeRange:e=function(e){var n;if(null!=e)return Array.isArray(e)||(e=[e,e]),[t(e[0]),t(null!=(n=e[1])?n:e[0])]},rangeIsCollapsed:function(t){var i,o,r;if(null!=t)return o=e(t),r=o[0],i=o[1],n(r,i)},rangesAreEqual:function(t,i){var o,r,s,a,u,c;if(null!=t&&null!=i)return s=e(t),r=s[0],o=s[1],a=e(i),c=a[0],u=a[1],n(r,c)&&n(o,u)}}),t=function(t){return"number"==typeof t?t:Trix.Hash.box(t).toObject()},n=function(t,e){return"number"==typeof t?t===e:Trix.Hash.box(t).isEqualTo(Trix.Hash.box(e))}}.call(this),function(){var t,e,n,i;t={extendsTagName:"div",css:"%t { display: block; }"},Trix.registerElement=function(e,o){var r,s,a,u,c,l,h;return null==o&&(o={}),e=e.toLowerCase(),c=i(o),u=null!=(h=c.extendsTagName)?h:t.extendsTagName,delete c.extendsTagName,s=c.defaultCSS,delete c.defaultCSS,null!=s&&u===t.extendsTagName?s+="\n"+t.css:s=t.css,n(s,e),a=Object.getPrototypeOf(document.createElement(u)),a.__super__=a,l=Object.create(a,c),r=document.registerElement(e,{prototype:l}),Object.defineProperty(l,"constructor",{value:r}),r},n=function(t,n){var i;return i=e(n),i.textContent=t.replace(/%t/g,n)},e=function(t){var e;return e=document.createElement("style"),e.setAttribute("type","text/css"),e.setAttribute("data-tag-name",t.toLowerCase()),document.head.insertBefore(e,document.head.firstChild),e},i=function(t){var e,n,i;n={};for(e in t)i=t[e],n[e]="function"==typeof i?{value:i}:i;return n}}.call(this),function(){}.call(this),function(){Trix.ObjectGroup=function(){function t(t,e){var n,i;this.objects=null!=t?t:[],i=e.depth,n=e.asTree,n&&(this.depth=i,this.objects=this.constructor.groupObjects(this.objects,{asTree:n,depth:this.depth+1}))}return t.groupObjects=function(t,e){var n,i,o,r,s,a,u,c,l;for(null==t&&(t=[]),l=null!=e?e:{},o=l.depth,n=l.asTree,n&&null==o&&(o=0),c=[],s=0,a=t.length;a>s;s++){if(u=t[s],r){if(("function"==typeof u.canBeGrouped?u.canBeGrouped(o):void 0)&&("function"==typeof(i=r[r.length-1]).canBeGroupedWith?i.canBeGroupedWith(u,o):void 0)){r.push(u);continue}c.push(new this(r,{depth:o,asTree:n})),r=null}("function"==typeof u.canBeGrouped?u.canBeGrouped(o):void 0)?r=[u]:c.push(u)}return r&&c.push(new this(r,{depth:o,asTree:n})),c},t.prototype.getObjects=function(){return this.objects},t.prototype.getDepth=function(){return this.depth},t.prototype.getCacheKey=function(){var t,e,n,i,o;for(e=["objectGroup"],o=this.getObjects(),t=0,n=o.length;n>t;t++)i=o[t],e.push(i.getCacheKey());return e.join("/")},t}()}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.ObjectMap=function(e){function n(t){var e,n,i,o,r;for(null==t&&(t=[]),this.objects={},i=0,o=t.length;o>i;i++)r=t[i],n=JSON.stringify(r),null==(e=this.objects)[n]&&(e[n]=r)}return t(n,e),n.prototype.find=function(t){var e;return e=JSON.stringify(t),this.objects[e]},n}(Trix.BasicObject)}.call(this),function(){Trix.ElementStore=function(){function t(t){this.reset(t)}var e;return t.prototype.add=function(t){var n;return n=e(t),this.elements[n]=t},t.prototype.remove=function(t){var n,i;return n=e(t),(i=this.elements[n])?(delete this.elements[n],i):void 0},t.prototype.reset=function(t){var e,n,i;for(null==t&&(t=[]),this.elements={},n=0,i=t.length;i>n;n++)e=t[n],this.add(e);return t},e=function(t){return t.dataset.trixStoreKey},t}()}.call(this),function(){}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Operation=function(e){function n(){return n.__super__.constructor.apply(this,arguments)}return t(n,e),n.prototype.isPerforming=function(){return this.performing===!0},n.prototype.hasPerformed=function(){return this.performed===!0},n.prototype.hasSucceeded=function(){return this.performed&&this.succeeded},n.prototype.hasFailed=function(){return this.performed&&!this.succeeded},n.prototype.getPromise=function(){return null!=this.promise?this.promise:this.promise=new Promise(function(t){return function(e,n){return t.performing=!0,t.perform(function(i,o){return t.succeeded=i,t.performing=!1,t.performed=!0,t.succeeded?e(o):n(o)})}}(this))},n.prototype.perform=function(t){return t(!1)},n.prototype.release=function(){var t;return null!=(t=this.promise)&&"function"==typeof t.cancel&&t.cancel(),this.promise=null,this.performing=null,this.performed=null,this.succeeded=null},n.proxyMethod("getPromise().then"),n.proxyMethod("getPromise().catch"),n}(Trix.BasicObject)}.call(this),function(){var t,e,n,i,o,r=function(t,e){function n(){this.constructor=t}for(var i in e)s.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},s={}.hasOwnProperty;Trix.UTF16String=function(t){function e(t,e){this.ucs2String=t,this.codepoints=e,this.length=this.codepoints.length,this.ucs2Length=this.ucs2String.length}return r(e,t),e.box=function(t){return null==t&&(t=""),t instanceof this?t:this.fromUCS2String(null!=t?t.toString():void 0)},e.fromUCS2String=function(t){return new this(t,i(t))},e.fromCodepoints=function(t){return new this(o(t),t)},e.prototype.offsetToUCS2Offset=function(t){return o(this.codepoints.slice(0,Math.max(0,t))).length},e.prototype.offsetFromUCS2Offset=function(t){return i(this.ucs2String.slice(0,Math.max(0,t))).length},e.prototype.slice=function(){var t;return this.constructor.fromCodepoints((t=this.codepoints).slice.apply(t,arguments))},e.prototype.charAt=function(t){return this.slice(t,t+1)},e.prototype.isEqualTo=function(t){return this.constructor.box(t).ucs2String===this.ucs2String},e.prototype.toJSON=function(){return this.ucs2String},e.prototype.getCacheKey=function(){return this.ucs2String},e.prototype.toString=function(){return this.ucs2String},e}(Trix.BasicObject),t=1===("function"==typeof Array.from?Array.from("\ud83d\udc7c").length:void 0),e=null!=("function"==typeof" ".codePointAt?" ".codePointAt(0):void 0),n=" \ud83d\udc7c"===("function"==typeof String.fromCodePoint?String.fromCodePoint(32,128124):void 0),i=t&&e?function(t){return Array.from(t).map(function(t){return t.codePointAt(0)})}:function(t){var e,n,i,o,r;for(o=[],e=0,i=t.length;i>e;)r=t.charCodeAt(e++),r>=55296&&56319>=r&&i>e&&(n=t.charCodeAt(e++),56320===(64512&n)?r=((1023&r)<<10)+(1023&n)+65536:e--),o.push(r);return o},o=n?function(t){return String.fromCodePoint.apply(String,t)}:function(t){var e,n,i;return e=function(){var e,o,r;for(r=[],e=0,o=t.length;o>e;e++)i=t[e],n="",i>65535&&(i-=65536,n+=String.fromCharCode(i>>>10&1023|55296),i=56320|1023&i),r.push(n+String.fromCharCode(i));return r}(),e.join("")}}.call(this),function(){}.call(this),function(){}.call(this),function(){Trix.config.lang={bold:"Bold",bullets:"Bullets","byte":"Byte",bytes:"Bytes",captionPlaceholder:"Type a caption here\u2026",code:"Code",editCaption:"Edit caption",indent:"Increase Level",italic:"Italic",link:"Link",numbers:"Numbers",outdent:"Decrease Level",quote:"Quote",redo:"Redo",remove:"Remove",strike:"Strikethrough",undo:"Undo",unlink:"Unlink",urlPlaceholder:"Enter a URL\u2026",GB:"GB",KB:"KB",MB:"MB",PB:"PB",TB:"TB"}}.call(this),function(){Trix.config.css={classNames:{attachment:{container:"attachment",typePrefix:"attachment-",caption:"caption",captionEdited:"caption-edited",captionEditor:"caption-editor",editingCaption:"caption-editing",progressBar:"progress",removeButton:"remove",size:"size"}}}
}.call(this),function(){var t;Trix.config.blockAttributes=t={"default":{tagName:"div",parse:!1},quote:{tagName:"blockquote",nestable:!0},code:{tagName:"pre",text:{plaintext:!0}},bulletList:{tagName:"ul",parse:!1},bullet:{tagName:"li",listAttribute:"bulletList",test:function(e){return Trix.tagName(e.parentNode)===t[this.listAttribute].tagName}},numberList:{tagName:"ol",parse:!1},number:{tagName:"li",listAttribute:"numberList",test:function(e){return Trix.tagName(e.parentNode)===t[this.listAttribute].tagName}}}}.call(this),function(){var t,e;t=Trix.config.lang,e=[t.bytes,t.KB,t.MB,t.GB,t.TB,t.PB],Trix.config.fileSize={prefix:"IEC",precision:2,formatter:function(n){var i,o,r,s,a;switch(n){case 0:return"0 "+t.bytes;case 1:return"1 "+t.byte;default:return i=function(){switch(this.prefix){case"SI":return 1e3;case"IEC":return 1024}}.call(this),o=Math.floor(Math.log(n)/Math.log(i)),r=n/Math.pow(i,o),s=r.toFixed(this.precision),a=s.replace(/0*$/,"").replace(/\.$/,""),a+" "+e[o]}}}}.call(this),function(){Trix.config.textAttributes={bold:{tagName:"strong",inheritable:!0,parser:function(t){var e;return e=window.getComputedStyle(t),"bold"===e.fontWeight||e.fontWeight>=700}},italic:{tagName:"em",inheritable:!0,parser:function(t){var e;return e=window.getComputedStyle(t),"italic"===e.fontStyle}},href:{groupTagName:"a",parser:function(t){var e,n,i;return e=Trix.AttachmentView.attachmentSelector,i="a:not("+e+")",(n=Trix.findClosestElementFromNode(t,{matchingSelector:i}))?n.getAttribute("href"):void 0}},strike:{tagName:"del",inheritable:!0},frozen:{style:{backgroundColor:"highlight"}}}}.call(this),function(){var t,e,n,i,o;o="[data-trix-serialize=false]",i=["contenteditable","data-trix-id","data-trix-store-key","data-trix-mutable"],e="data-trix-serialized-attributes",n="["+e+"]",t=new RegExp("<!--block-->","g"),Trix.extend({serializers:{"application/json":function(t){var e;if(t instanceof Trix.Document)e=t;else{if(!(t instanceof HTMLElement))throw new Error("unserializable object");e=Trix.Document.fromHTML(t.innerHTML)}return e.toSerializableDocument().toJSONString()},"text/html":function(r){var s,a,u,c,l,h,p,d,f,g,m,y,v,b,A,x,T;if(r instanceof Trix.Document)c=Trix.DocumentView.render(r);else{if(!(r instanceof HTMLElement))throw new Error("unserializable object");c=r.cloneNode(!0)}for(b=c.querySelectorAll(o),l=0,f=b.length;f>l;l++)u=b[l],u.parentNode.removeChild(u);for(h=0,g=i.length;g>h;h++)for(s=i[h],A=c.querySelectorAll("["+s+"]"),p=0,m=A.length;m>p;p++)u=A[p],u.removeAttribute(s);for(x=c.querySelectorAll(n),d=0,y=x.length;y>d;d++){u=x[d];try{a=JSON.parse(u.getAttribute(e)),u.removeAttribute(e);for(v in a)T=a[v],u.setAttribute(v,T)}catch(C){}}return c.innerHTML.replace(t,"")}},deserializers:{"application/json":function(t){return Trix.Document.fromJSONString(t)},"text/html":function(t){return Trix.Document.fromHTML(t)}},serializeToContentType:function(t,e){var n;if(n=Trix.serializers[e])return n(t);throw new Error("unknown content type: "+e)},deserializeFromContentType:function(t,e){var n;if(n=Trix.deserializers[e])return n(t);throw new Error("unknown content type: "+e)}})}.call(this),function(){var t,e;e=Trix.makeFragment,t=Trix.config.lang,Trix.config.toolbar={content:e('<div class="button_groups">\n  <span class="button_group text_tools">\n    <button type="button" class="bold" data-attribute="bold" data-key="b" title="'+t.bold+'">'+t.bold+'</button>\n    <button type="button" class="italic" data-attribute="italic" data-key="i" title="'+t.italic+'">'+t.italic+'</button>\n    <button type="button" class="strike" data-attribute="strike" title="'+t.strike+'">'+t.strike+'</button>\n    <button type="button" class="link" data-attribute="href" data-action="link" data-key="k" title="'+t.link+'">'+t.link+'</button>\n  </span>\n\n  <span class="button_group block_tools">\n    <button type="button" class="quote" data-attribute="quote" title="'+t.quote+'">'+t.quote+'</button>\n    <button type="button" class="code" data-attribute="code" title="'+t.code+'">'+t.code+'</button>\n    <button type="button" class="list bullets" data-attribute="bullet" title="'+t.bullets+'">'+t.bullets+'</button>\n    <button type="button" class="list numbers" data-attribute="number" title="'+t.numbers+'">'+t.numbers+'</button>\n    <button type="button" class="block-level decrease" data-action="decreaseBlockLevel" title="'+t.outdent+'">'+t.outdent+'</button>\n    <button type="button" class="block-level increase" data-action="increaseBlockLevel" title="'+t.indent+'">'+t.indent+'</button>\n  </span>\n\n  <span class="button_group history_tools">\n    <button type="button" class="undo" data-action="undo" data-key="z" title="'+t.undo+'">'+t.undo+'</button>\n    <button type="button" class="redo" data-action="redo" data-key="shift+z" title="'+t.redo+'">'+t.redo+'</button>\n  </span>\n</div>\n\n<div class="dialogs">\n  <div class="dialog link_dialog" data-attribute="href" data-dialog="href">\n    <div class="link_url_fields">\n      <input type="url" required name="href" placeholder="'+t.urlPlaceholder+'">\n      <div class="button_group">\n        <input type="button" value="'+t.link+'" data-method="setAttribute">\n        <input type="button" value="'+t.unlink+'" data-method="removeAttribute">\n      </div>\n    </div>\n  </div>\n</div>')}}.call(this),function(){Trix.config.undoInterval=5e3}.call(this),function(){}.call(this),function(){var t;t=Trix.cloneFragment,Trix.registerElement("trix-toolbar",{defaultCSS:"%t {\n  white-space: collapse;\n}\n\n%t .dialog {\n  display: none;\n}\n\n%t .dialog.active {\n  display: block;\n}\n\n%t .dialog input.validate:invalid {\n  background-color: #ffdddd;\n}\n\n%t[native] {\n  display: none;\n}",createdCallback:function(){return""===this.innerHTML?this.appendChild(t(Trix.config.toolbar.content)):void 0}})}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty,n=[].indexOf||function(t){for(var e=0,n=this.length;n>e;e++)if(e in this&&this[e]===t)return e;return-1};Trix.ObjectView=function(e){function i(t,e){this.object=t,this.options=null!=e?e:{},this.childViews=[],this.rootView=this}return t(i,e),i.prototype.getNodes=function(){var t,e,n,i,o;for(null==this.nodes&&(this.nodes=this.createNodes()),i=this.nodes,o=[],t=0,e=i.length;e>t;t++)n=i[t],o.push(n.cloneNode(!0));return o},i.prototype.invalidate=function(){var t;return this.nodes=null,null!=(t=this.parentView)?t.invalidate():void 0},i.prototype.invalidateViewForObject=function(t){var e;return null!=(e=this.findViewForObject(t))?e.invalidate():void 0},i.prototype.findOrCreateCachedChildView=function(t,e){var n;return(n=this.getCachedViewForObject(e))?this.recordChildView(n):(n=this.createChildView.apply(this,arguments),this.cacheViewForObject(n,e)),n},i.prototype.createChildView=function(t,e,n){var i;return null==n&&(n={}),e instanceof Trix.ObjectGroup&&(n.viewClass=t,t=Trix.ObjectGroupView),i=new t(e,n),this.recordChildView(i)},i.prototype.recordChildView=function(t){return t.parentView=this,t.rootView=this.rootView,this.childViews.push(t),t},i.prototype.getAllChildViews=function(){var t,e,n,i,o;for(o=[],i=this.childViews,e=0,n=i.length;n>e;e++)t=i[e],o.push(t),o=o.concat(t.getAllChildViews());return o},i.prototype.findElement=function(){return this.findElementForObject(this.object)},i.prototype.findElementForObject=function(t){var e;return(e=null!=t?t.id:void 0)?this.rootView.element.querySelector("[data-trix-id='"+e+"']"):void 0},i.prototype.findViewForObject=function(t){var e,n,i,o;for(i=this.getAllChildViews(),e=0,n=i.length;n>e;e++)if(o=i[e],o.object===t)return o},i.prototype.getViewCache=function(){return this.rootView!==this?this.rootView.getViewCache():this.isViewCachingEnabled()?null!=this.viewCache?this.viewCache:this.viewCache={}:void 0},i.prototype.isViewCachingEnabled=function(){return this.shouldCacheViews!==!1},i.prototype.enableViewCaching=function(){return this.shouldCacheViews=!0},i.prototype.disableViewCaching=function(){return this.shouldCacheViews=!1},i.prototype.getCachedViewForObject=function(t){var e;return null!=(e=this.getViewCache())?e[t.getCacheKey()]:void 0},i.prototype.cacheViewForObject=function(t,e){var n;return null!=(n=this.getViewCache())?n[e.getCacheKey()]=t:void 0},i.prototype.garbageCollectCachedViews=function(){var t,e,i,o,r,s;if(t=this.getViewCache()){s=this.getAllChildViews().concat(this),i=function(){var t,e,n;for(n=[],t=0,e=s.length;e>t;t++)r=s[t],n.push(r.object.getCacheKey());return n}(),o=[];for(e in t)n.call(i,e)<0&&o.push(delete t[e]);return o}},i}(Trix.BasicObject)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.ObjectGroupView=function(e){function n(){n.__super__.constructor.apply(this,arguments),this.objectGroup=this.object,this.viewClass=this.options.viewClass,delete this.options.viewClass}return t(n,e),n.prototype.getChildViews=function(){var t,e,n,i;if(!this.childViews.length)for(i=this.objectGroup.getObjects(),t=0,e=i.length;e>t;t++)n=i[t],this.findOrCreateCachedChildView(this.viewClass,n,this.options);return this.childViews},n.prototype.createNodes=function(){var t,e,n,i,o,r,s,a,u;for(t=this.createContainerElement(),s=this.getChildViews(),e=0,i=s.length;i>e;e++)for(u=s[e],a=u.getNodes(),n=0,o=a.length;o>n;n++)r=a[n],t.appendChild(r);return[t]},n.prototype.createContainerElement=function(t){return null==t&&(t=this.objectGroup.getDepth()),this.getChildViews()[0].createContainerElement(t)},n}(Trix.ObjectView)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Controller=function(e){function n(){return n.__super__.constructor.apply(this,arguments)}return t(n,e),n}(Trix.BasicObject)}.call(this),function(){var t,e,n,i,o,r=function(t,e){return function(){return t.apply(e,arguments)}},s=function(t,e){function n(){this.constructor=t}for(var i in e)a.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},a={}.hasOwnProperty,u=[].indexOf||function(t){for(var e=0,n=this.length;n>e;e++)if(e in this&&this[e]===t)return e;return-1};t=Trix.defer,e=Trix.findClosestElementFromNode,n=Trix.nodeIsEmptyTextNode,i=Trix.normalizeSpaces,o=Trix.summarizeStringChange,Trix.MutationObserver=function(t){function a(t){this.element=t,this.didMutate=r(this.didMutate,this),this.observer=new window.MutationObserver(this.didMutate),this.start()}var c,l;return s(a,t),c="[data-trix-mutable]",l={attributes:!0,childList:!0,characterData:!0,characterDataOldValue:!0,subtree:!0},a.prototype.start=function(){return this.reset(),this.observer.observe(this.element,l)},a.prototype.stop=function(){return this.observer.disconnect()},a.prototype.didMutate=function(t){var e,n;return(e=this.mutations).push.apply(e,this.findSignificantMutations(t)),this.mutations.length?(null!=(n=this.delegate)&&"function"==typeof n.elementDidMutate&&n.elementDidMutate(this.getMutationSummary()),this.reset()):void 0},a.prototype.reset=function(){return this.mutations=[]},a.prototype.findSignificantMutations=function(t){var e,n,i,o;for(o=[],e=0,n=t.length;n>e;e++)i=t[e],this.mutationIsSignificant(i)&&o.push(i);return o},a.prototype.mutationIsSignificant=function(t){var e,n,i,o;for(o=this.nodesModifiedByMutation(t),e=0,n=o.length;n>e;e++)if(i=o[e],this.nodeIsSignificant(i))return!0;return!1},a.prototype.nodeIsSignificant=function(t){return t!==this.element&&!this.nodeIsMutable(t)&&!n(t)},a.prototype.nodeIsMutable=function(t){return e(t,{matchingSelector:c})},a.prototype.nodesModifiedByMutation=function(t){var e;switch(e=[],t.type){case"attributes":e.push(t.target);break;case"characterData":e.push(t.target.parentNode),e.push(t.target);break;case"childList":e.push.apply(e,t.addedNodes),e.push.apply(e,t.removedNodes)}return e},a.prototype.getMutationSummary=function(){return this.getTextMutationSummary()},a.prototype.getTextMutationSummary=function(){var t,e,n,i,o,r,s,a,c,l,h;for(a=this.getTextChangesFromCharacterData(),n=a.additions,o=a.deletions,h=this.getTextChangesFromTextNodes(),c=h.additions,r=0,s=c.length;s>r;r++)e=c[r],u.call(n,e)<0&&n.push(e);return o.push.apply(o,h.deletions),l={},(t=n.join(""))&&(l.textAdded=t),(i=o.join(""))&&(l.textDeleted=i),l},a.prototype.getMutationsByType=function(t){var e,n,i,o,r;for(o=this.mutations,r=[],e=0,n=o.length;n>e;e++)i=o[e],i.type===t&&r.push(i);return r},a.prototype.getTextChangesFromTextNodes=function(){var t,e,n,o,r,s,a,u,c,l,h,p,d,f;for(l=[],h=[],p=this.getMutationsByType("childList"),t=0,r=p.length;r>t;t++){for(u=p[t],d=u.removedNodes,n=0,s=d.length;s>n;n++)c=d[n],c.nodeType===Node.TEXT_NODE&&h.push(c);for(f=u.addedNodes,o=0,a=f.length;a>o;o++)c=f[o],c.nodeType===Node.TEXT_NODE&&l.push(c)}return{additions:function(){var t,n,o,r;for(r=[],e=t=0,n=l.length;n>t;e=++t)c=l[e],c.data!==(null!=(o=h[e])?o.data:void 0)&&r.push(i(c.data));return r}(),deletions:function(){var t,n,o,r;for(r=[],e=t=0,n=h.length;n>t;e=++t)c=h[e],c.data!==(null!=(o=l[e])?o.data:void 0)&&r.push(i(c.data));return r}()}},a.prototype.getTextChangesFromCharacterData=function(){var t,e,n,r,s,a,u,c;return e=this.getMutationsByType("characterData"),e.length&&(c=e[0],n=e[e.length-1],s=i(c.oldValue),r=i(n.target.data),a=o(s,r),t=a.added,u=a.removed),{additions:t?[t]:[],deletions:u?[u]:[]}},a}(Trix.BasicObject)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.FileVerificationOperation=function(e){function n(t){this.file=t}return t(n,e),n.prototype.perform=function(t){var e;return e=new FileReader,e.onerror=function(){return t(!1)},e.onload=function(n){return function(){e.onerror=null;try{e.abort()}catch(i){}return t(!0,n.file)}}(this),e.readAsArrayBuffer(this.file)},n}(Trix.Operation)}.call(this),function(){var t,e,n,i,o,r,s,a,u,c,l,h,p,d,f=function(t,e){function n(){this.constructor=t}for(var i in e)g.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},g={}.hasOwnProperty,m=[].indexOf||function(t){for(var e=0,n=this.length;n>e;e++)if(e in this&&this[e]===t)return e;return-1};r=Trix.handleEvent,i=Trix.findClosestElementFromNode,o=Trix.findElementFromContainerAndOffset,e=Trix.defer,l=Trix.makeElement,s=Trix.innerElementIsActive,p=Trix.summarizeStringChange,Trix.InputController=function(e){function i(t){var e;this.element=t,this.resetInputSummary(),this.mutationObserver=new Trix.MutationObserver(this.element),this.mutationObserver.delegate=this;for(e in this.events)r(e,{onElement:this.element,withCallback:this.handlerFor(e),inPhase:"capturing"})}var o;return f(i,e),o=0,i.keyNames={8:"backspace",9:"tab",13:"return",37:"left",39:"right",46:"delete",68:"d",72:"h",79:"o"},i.prototype.handlerFor=function(t){return function(e){return function(n){return e.handleInput(function(){return s(this.element)?void 0:(this.eventName=t,this.events[t].call(this,n))})}}(this)},i.prototype.setInputSummary=function(t){var e,n;null==t&&(t={}),this.inputSummary.eventName=this.eventName;for(e in t)n=t[e],this.inputSummary[e]=n;return this.inputSummary},i.prototype.resetInputSummary=function(){return this.inputSummary={}},i.prototype.editorWillSyncDocumentView=function(){return this.mutationObserver.stop()},i.prototype.editorDidSyncDocumentView=function(){return this.mutationObserver.start()},i.prototype.requestRender=function(){var t;return null!=(t=this.delegate)&&"function"==typeof t.inputControllerDidRequestRender?t.inputControllerDidRequestRender():void 0},i.prototype.elementDidMutate=function(t){return this.inputSummary.composing?void 0:this.handleInput(function(){var e;return this.mutationIsExpected(t)||null!=(e=this.responder)&&e.replaceHTML(this.element.innerHTML),this.resetInputSummary(),this.requestRender(),Trix.selectionChangeObserver.reset()})},i.prototype.mutationIsExpected=function(t){var e,n;return this.inputSummary?null!=this.inputSummary.preferDocument?this.inputSummary.preferDocument:(e=t.textAdded!==this.inputSummary.textAdded,n=null!=t.textDeleted&&!this.inputSummary.didDelete,!(e||n)):void 0},i.prototype.attachFiles=function(t){var e,n;return n=function(){var n,i,o;for(o=[],n=0,i=t.length;i>n;n++)e=t[n],o.push(new Trix.FileVerificationOperation(e));return o}(),Promise.all(n).then(function(t){return function(n){return t.handleInput(function(){var t,i,o,r;for(null!=(o=this.delegate)&&o.inputControllerWillAttachFiles(),t=0,i=n.length;i>t;t++)e=n[t],null!=(r=this.responder)&&r.insertFile(e);return this.requestRender()})}}(this))},i.prototype.events={keydown:function(t){var e,n,i,o,r,s,u,c,l;if(this.inputSummary.composing||this.resetInputSummary(),o=this.constructor.keyNames[t.keyCode]){for(n=this.keys,c=["ctrl","alt","shift","meta"],i=0,s=c.length;s>i;i++)u=c[i],t[u+"Key"]&&("ctrl"===u&&(u="control"),n=null!=n?n[u]:void 0);null!=(null!=n?n[o]:void 0)&&(this.setInputSummary({keyName:o}),Trix.selectionChangeObserver.reset(),n[o].call(this,t))}return a(t)&&(e=String.fromCharCode(t.keyCode).toLowerCase())&&(r=function(){var e,n,i,o;for(i=["alt","shift"],o=[],e=0,n=i.length;n>e;e++)u=i[e],t[u+"Key"]&&o.push(u);return o}(),r.push(e),null!=(l=this.delegate)?l.inputControllerDidReceiveKeyboardCommand(r):void 0)?t.preventDefault():void 0},keypress:function(t){var e,n,i;if(null==this.inputSummary.eventName&&(!t.metaKey&&!t.ctrlKey||t.altKey)&&!c(t)&&!u(t))return null===t.which?e=String.fromCharCode(t.keyCode):0!==t.which&&0!==t.charCode&&(e=String.fromCharCode(t.charCode)),null!=e?(null!=(n=this.delegate)&&n.inputControllerWillPerformTyping(),null!=(i=this.responder)&&i.insertString(e),this.setInputSummary({textAdded:e,didDelete:this.selectionIsExpanded()})):void 0},dragenter:function(t){return t.preventDefault()},dragstart:function(t){var e,n,i;return i=t.target,this.serializeSelectionToDataTransfer(t.dataTransfer),this.draggedRange=null!=(e=this.responder)?e.getSelectedRange():void 0,null!=(n=this.delegate)&&"function"==typeof n.inputControllerDidStartDrag?n.inputControllerDidStartDrag():void 0},dragover:function(t){var e,n,i;return(this.draggedRange||this.canAcceptDataTransfer(t.dataTransfer))&&(t.preventDefault(),e={x:t.clientX,y:t.clientY},e.toString()!==(null!=(n=this.draggingPoint)?n.toString():void 0))?(this.draggingPoint=e,null!=(i=this.delegate)&&"function"==typeof i.inputControllerDidReceiveDragOverPoint?i.inputControllerDidReceiveDragOverPoint(this.draggingPoint):void 0):void 0},dragend:function(){var t;return null!=(t=this.delegate)&&"function"==typeof t.inputControllerDidCancelDrag&&t.inputControllerDidCancelDrag(),this.draggedRange=null,this.draggingPoint=null},drop:function(t){var e,n,i,o,r,s,a,u,c;return t.preventDefault(),i=null!=(r=t.dataTransfer)?r.files:void 0,o={x:t.clientX,y:t.clientY},null!=(s=this.responder)&&s.setLocationRangeFromPointRange(o),(null!=i?i.length:void 0)?this.attachFiles(i):this.draggedRange?(null!=(a=this.delegate)&&a.inputControllerWillMoveText(),null!=(u=this.responder)&&u.moveTextFromRange(this.draggedRange),this.draggedRange=null,this.requestRender()):(n=t.dataTransfer.getData("application/x-trix-document"))&&(e=Trix.Document.fromJSONString(n),null!=(c=this.responder)&&c.insertDocument(e),this.requestRender()),this.draggedRange=null,this.draggingPoint=null},cut:function(t){var e;return this.serializeSelectionToDataTransfer(t.clipboardData)&&t.preventDefault(),null!=(e=this.delegate)&&e.inputControllerWillCutText(),this.deleteInDirection("backward"),t.defaultPrevented?this.requestRender():void 0},copy:function(t){return this.serializeSelectionToDataTransfer(t.clipboardData)?t.preventDefault():void 0},paste:function(t){var e,i,r,s,a,u,c,l,p,d,f,g,y,v,b,A,x,T;return s=null!=(u=t.clipboardData)?u:t.testClipboardData,null!=s?(a={paste:s},h(t)?void this.getPastedHTMLUsingHiddenElement(function(t){return function(e){var n,i,o;return a.html=e,null!=(n=t.delegate)&&n.inputControllerWillPasteText(a),null!=(i=t.responder)&&i.insertHTML(e),t.requestRender(),null!=(o=t.delegate)?o.inputControllerDidPaste(a):void 0}}(this)):((r=s.getData("text/html"))?(a.html=r,null!=(c=this.delegate)&&c.inputControllerWillPasteText(a),null!=(d=this.responder)&&d.insertHTML(r),this.requestRender(),null!=(f=this.delegate)&&f.inputControllerDidPaste(a)):(T=s.getData("text/plain"))?(a.string=T,this.setInputSummary({textAdded:T,didDelete:this.selectionIsExpanded()}),null!=(g=this.delegate)&&g.inputControllerWillPasteText(a),null!=(y=this.responder)&&y.insertString(T),this.requestRender(),null!=(v=this.delegate)&&v.inputControllerDidPaste(a)):m.call(s.types,"Files")>=0&&(i=null!=(b=s.items)&&null!=(A=b[0])&&"function"==typeof A.getAsFile?A.getAsFile():void 0)&&(!i.name&&(e=n(i))&&(i.name="pasted-file-"+ ++o+"."+e),a.file=i,null!=(x=this.delegate)&&x.inputControllerWillAttachFiles(),null!=(l=this.responder)&&l.insertFile(i),this.requestRender(),null!=(p=this.delegate)&&p.inputControllerDidPaste(a)),t.preventDefault())):void 0},compositionstart:function(t){var e,n;return this.selectionIsExpanded()||"keypress"===this.inputSummary.eventName&&this.inputSummary.textAdded||(n=null!=(e=this.responder)?e.insertPlaceholder():void 0,this.setInputSummary({textAdded:n}),this.requestRender()),this.setInputSummary({composing:!0,compositionStart:t.data})},compositionupdate:function(t){var e,n;return(null!=(e=this.responder)?e.selectPlaceholder():void 0)&&null!=(n=this.responder)&&n.forgetPlaceholder(),this.setInputSummary({composing:!0,compositionUpdate:t.data})},compositionend:function(t){var e,n,i,o,r,s,a,u,c;return(null!=(o=this.responder)?o.selectPlaceholder():void 0)&&null!=(r=this.responder)&&r.forgetPlaceholder(),n=this.inputSummary.compositionStart,i=t.data,null!=n&&null!=i&&n!==i?(null!=(s=this.delegate)&&s.inputControllerWillPerformTyping(),null!=(a=this.responder)&&a.insertString(i),u=p(n,i),e=u.added,c=u.removed,this.setInputSummary({composing:!1,textAdded:e,didDelete:Boolean(c)})):void 0},input:function(t){return t.stopPropagation()}},i.prototype.keys={backspace:function(t){var e;return null!=(e=this.delegate)&&e.inputControllerWillPerformTyping(),this.deleteInDirection("backward",t)},"delete":function(t){var e;return null!=(e=this.delegate)&&e.inputControllerWillPerformTyping(),this.deleteInDirection("forward",t)},"return":function(){var t,e;return this.setInputSummary({preferDocument:!0}),null!=(t=this.delegate)&&t.inputControllerWillPerformTyping(),null!=(e=this.responder)?e.insertLineBreak():void 0},tab:function(t){var e,n;return(null!=(e=this.responder)?e.canIncreaseBlockAttributeLevel():void 0)?(null!=(n=this.responder)&&n.increaseBlockAttributeLevel(),this.requestRender(),t.preventDefault()):void 0},left:function(t){var e;return this.selectionIsInCursorTarget()?(t.preventDefault(),null!=(e=this.responder)?e.moveCursorInDirection("backward"):void 0):void 0},right:function(t){var e;return this.selectionIsInCursorTarget()?(t.preventDefault(),null!=(e=this.responder)?e.moveCursorInDirection("forward"):void 0):void 0},control:{d:function(t){var e;return null!=(e=this.delegate)&&e.inputControllerWillPerformTyping(),this.deleteInDirection("forward",t)},h:function(t){var e;return null!=(e=this.delegate)&&e.inputControllerWillPerformTyping(),this.deleteInDirection("backward",t)},o:function(t){var e,n;return t.preventDefault(),null!=(e=this.delegate)&&e.inputControllerWillPerformTyping(),null!=(n=this.responder)&&n.insertString("\n",{updatePosition:!1}),this.requestRender()}},shift:{"return":function(){var t,e;return null!=(t=this.delegate)&&t.inputControllerWillPerformTyping(),null!=(e=this.responder)?e.insertString("\n"):void 0},tab:function(t){var e,n;return(null!=(e=this.responder)?e.canDecreaseBlockAttributeLevel():void 0)?(null!=(n=this.responder)&&n.decreaseBlockAttributeLevel(),this.requestRender(),t.preventDefault()):void 0},left:function(t){return this.selectionIsInCursorTarget()?(t.preventDefault(),this.expandSelectionInDirection("backward")):void 0},right:function(t){return this.selectionIsInCursorTarget()?(t.preventDefault(),this.expandSelectionInDirection("forward")):void 0}},alt:{backspace:function(){var t;return this.setInputSummary({preferDocument:!1}),null!=(t=this.delegate)?t.inputControllerWillPerformTyping():void 0}},meta:{backspace:function(){var t;return this.setInputSummary({preferDocument:!1}),null!=(t=this.delegate)?t.inputControllerWillPerformTyping():void 0}}},i.prototype.handleInput=function(t){var e,n;try{return null!=(e=this.delegate)&&e.inputControllerWillHandleInput(),t.call(this)}finally{null!=(n=this.delegate)&&n.inputControllerDidHandleInput()}},i.prototype.deleteInDirection=function(t,e){var n;return(null!=(n=this.responder)?n.deleteInDirection(t):void 0)!==!1?this.setInputSummary({didDelete:!0}):e?(e.preventDefault(),this.requestRender()):void 0},i.prototype.serializeSelectionToDataTransfer=function(e){var n,i;if(t(e))return n=null!=(i=this.responder)?i.getSelectedDocument().toSerializableDocument():void 0,e.setData("application/x-trix-document",JSON.stringify(n)),e.setData("text/html",Trix.DocumentView.render(n).innerHTML),e.setData("text/plain",n.toString().replace(/\n$/,"")),!0},i.prototype.canAcceptDataTransfer=function(t){var e,n,i,o,r,s;for(s={},o=null!=(i=null!=t?t.types:void 0)?i:[],e=0,n=o.length;n>e;e++)r=o[e],s[r]=!0;return s.Files||s["application/x-trix-document"]||s["text/html"]||s["text/plain"]},i.prototype.getPastedHTMLUsingHiddenElement=function(t){var e,n,i,o;return i=null!=(n=this.responder)?n.getSelectedRange():void 0,o={position:"absolute",left:window.pageXOffset+"px",top:window.pageYOffset+"px",opacity:0},e=l({style:o,tagName:"div",editable:!0}),document.body.appendChild(e),e.focus(),requestAnimationFrame(function(n){return function(){var o,r;return o=e.innerHTML,document.body.removeChild(e),null!=(r=n.responder)&&r.setSelectedRange(i),t(o)}}(this))},i.proxyMethod("responder?.expandSelectionInDirection"),i.proxyMethod("responder?.selectionIsInCursorTarget"),i.proxyMethod("responder?.selectionIsExpanded"),i}(Trix.BasicObject),n=function(t){var e,n;return null!=(e=t.type)&&null!=(n=e.match(/\/(\w+)$/))?n[1]:void 0},c=function(t){return t.metaKey&&t.altKey&&!t.shiftKey&&94===t.keyCode},u=function(t){return t.metaKey&&t.altKey&&t.shiftKey&&9674===t.keyCode},a=function(t){return/Mac|^iP/.test(navigator.platform)?t.metaKey:t.ctrlKey},h=function(t){var e,n;return(n=null!=(e=t.clipboardData)?e.types:void 0)?m.call(n,"text/html")<0&&(m.call(n,"com.apple.webarchive")>=0||m.call(n,"com.apple.flat-rtfd")>=0):void 0},d={"application/x-trix-feature-detection":"test"},t=function(t){var e,n;if(null!=(null!=t?t.setData:void 0)){for(e in d)if(n=d[e],t.setData(e,n),t.getData(e)!==n)return;return!0}}}.call(this),function(){var t,e,n,i,o,r,s=function(t,e){return function(){return t.apply(e,arguments)}},a=function(t,e){function n(){this.constructor=t}for(var i in e)u.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},u={}.hasOwnProperty;e=Trix.handleEvent,o=Trix.makeElement,r=Trix.tagName,n=Trix.InputController.keyNames,i=Trix.config.lang,t=Trix.config.css.classNames,Trix.AttachmentEditorController=function(u){function c(t,e,n){this.attachmentPiece=t,this.element=e,this.container=n,this.uninstall=s(this.uninstall,this),this.didKeyDownCaption=s(this.didKeyDownCaption,this),this.didChangeCaption=s(this.didChangeCaption,this),this.didClickCaption=s(this.didClickCaption,this),this.didClickRemoveButton=s(this.didClickRemoveButton,this),this.attachment=this.attachmentPiece.attachment,"a"===r(this.element)&&(this.element=this.element.firstChild),this.install()}var l;return a(c,u),l=function(t){return function(){var e;return e=t.apply(this,arguments),e["do"](),null==this.undos&&(this.undos=[]),this.undos.push(e.undo)}},c.prototype.install=function(){return this.makeElementMutable(),this.attachment.isPreviewable()&&this.makeCaptionEditable(),this.addRemoveButton()},c.prototype.makeElementMutable=l(function(){return{"do":function(t){return function(){return t.element.dataset.trixMutable=!0}}(this),undo:function(t){return function(){return delete t.element.dataset.trixMutable}}(this)}}),c.prototype.makeCaptionEditable=l(function(){var t,n;return t=this.element.querySelector("figcaption"),n=null,{"do":function(i){return function(){return n=e("click",{onElement:t,withCallback:i.didClickCaption,inPhase:"capturing"})}}(this),undo:function(){return function(){return n.destroy()}}(this)}}),c.prototype.addRemoveButton=l(function(){var n;return n=o({tagName:"a",textContent:i.remove,className:t.attachment.removeButton,attributes:{href:"#",title:i.remove}}),e("click",{onElement:n,withCallback:this.didClickRemoveButton}),{"do":function(t){return function(){return t.element.appendChild(n)}}(this),undo:function(t){return function(){return t.element.removeChild(n)}}(this)}}),c.prototype.editCaption=l(function(){var n,r,s,a,u;return a=o({tagName:"textarea",className:t.attachment.captionEditor,attributes:{placeholder:i.captionPlaceholder}}),a.value=this.attachmentPiece.getCaption(),u=a.cloneNode(),u.classList.add("trix-autoresize-clone"),n=function(){return u.value=a.value,a.style.height=u.scrollHeight+"px"},e("input",{onElement:a,withCallback:n}),e("keydown",{onElement:a,withCallback:this.didKeyDownCaption}),e("change",{onElement:a,withCallback:this.didChangeCaption}),e("blur",{onElement:a,withCallback:this.uninstall}),s=this.element.querySelector("figcaption"),r=s.cloneNode(),{"do":function(){return s.style.display="none",r.appendChild(a),r.appendChild(u),r.classList.add(t.attachment.editingCaption),s.parentElement.insertBefore(r,s),n(),a.focus()},undo:function(){return r.parentNode.removeChild(r),s.style.display=null}}}),c.prototype.didClickRemoveButton=function(t){var e;return t.preventDefault(),t.stopPropagation(),null!=(e=this.delegate)?e.attachmentEditorDidRequestRemovalOfAttachment(this.attachment):void 0},c.prototype.didClickCaption=function(t){return t.preventDefault(),this.editCaption()},c.prototype.didChangeCaption=function(t){var e,n,i;return e=t.target.value.replace(/\s/g," ").trim(),e?null!=(n=this.delegate)&&"function"==typeof n.attachmentEditorDidRequestUpdatingAttributesForAttachment?n.attachmentEditorDidRequestUpdatingAttributesForAttachment({caption:e},this.attachment):void 0:null!=(i=this.delegate)&&"function"==typeof i.attachmentEditorDidRequestRemovingAttributeForAttachment?i.attachmentEditorDidRequestRemovingAttributeForAttachment("caption",this.attachment):void 0},c.prototype.didKeyDownCaption=function(t){var e;return"return"===n[t.keyCode]?(t.preventDefault(),this.didChangeCaption(t),null!=(e=this.delegate)&&"function"==typeof e.attachmentEditorDidRequestDeselectingAttachment?e.attachmentEditorDidRequestDeselectingAttachment(this.attachment):void 0):void 0},c.prototype.uninstall=function(){for(var t,e;e=this.undos.pop();)e();return null!=(t=this.delegate)?t.didUninstallAttachmentEditor(this):void 0},c}(Trix.BasicObject)}.call(this),function(){var t,e,n,i=function(t,e){function n(){this.constructor=t}for(var i in e)o.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},o={}.hasOwnProperty;n=Trix.makeElement,t=Trix.config.css.classNames,Trix.AttachmentView=function(o){function r(){r.__super__.constructor.apply(this,arguments),this.attachment=this.object,this.attachment.uploadProgressDelegate=this,this.attachmentPiece=this.options.piece}return i(r,o),r.attachmentSelector="[data-trix-attachment]",r.prototype.createContentNodes=function(){return[]},r.prototype.createNodes=function(){var e,i,o,r,s,a,u,c,l,h,p;if(r=n({tagName:"figure",className:this.getClassName()}),this.attachment.hasContent())r.innerHTML=this.attachment.getContent();else for(h=this.createContentNodes(),a=0,c=h.length;c>a;a++)l=h[a],r.appendChild(l);r.appendChild(this.createCaptionElement()),i={trixAttachment:JSON.stringify(this.attachment),trixContentType:this.attachment.getContentType(),trixId:this.attachment.id},e=this.attachmentPiece.getAttributesForAttachment(),e.isEmpty()||(i.trixAttributes=JSON.stringify(e)),this.attachment.isPending()&&(this.progressElement=n({tagName:"progress",attributes:{"class":t.attachment.progressBar,value:this.attachment.getUploadProgress(),max:100},data:{trixMutable:!0,trixStoreKey:this.attachment.getCacheKey("progressElement")}}),r.appendChild(this.progressElement),i.trixSerialize=!1),(s=this.getHref())?(o=n("a",{href:s}),o.appendChild(r)):o=r;for(u in i)p=i[u],o.dataset[u]=p;
return o.setAttribute("contenteditable",!1),[this.createCursorTarget(),o,this.createCursorTarget()]},r.prototype.createCaptionElement=function(){var e,i,o,r,s;return i=n({tagName:"figcaption",className:t.attachment.caption}),(e=this.attachmentPiece.getCaption())?(i.classList.add(t.attachment.captionEdited),i.textContent=e):(o=this.attachment.getFilename())&&(i.textContent=o,(r=this.attachment.getFormattedFilesize())&&(i.appendChild(document.createTextNode(" ")),s=n({tagName:"span",className:t.attachment.size,textContent:r}),i.appendChild(s))),i},r.prototype.getClassName=function(){var e,n;return n=[t.attachment.container,""+t.attachment.typePrefix+this.attachment.getType()],(e=this.attachment.getExtension())&&n.push(e),n.join(" ")},r.prototype.getHref=function(){return e(this.attachment.getContent(),"a")?void 0:this.attachment.getHref()},r.prototype.createCursorTarget=function(){return n({tagName:"span",textContent:Trix.ZERO_WIDTH_SPACE,data:{trixCursorTarget:!0,trixSerialize:!1}})},r.prototype.findProgressElement=function(){var t;return null!=(t=this.findElement())?t.querySelector("progress"):void 0},r.prototype.attachmentDidChangeUploadProgress=function(){var t,e;return e=this.attachment.getUploadProgress(),null!=(t=this.findProgressElement())?t.value=e:void 0},r}(Trix.ObjectView),e=function(t,e){var i;return i=n("div"),i.innerHTML=null!=t?t:"",i.querySelector(e)}}.call(this),function(){var t,e,n,i=function(t,e){function n(){this.constructor=t}for(var i in e)o.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},o={}.hasOwnProperty;t=Trix.defer,e=Trix.makeElement,n=Trix.measureElement,Trix.PreviewableAttachmentView=function(t){function n(){n.__super__.constructor.apply(this,arguments),this.attachment.previewDelegate=this}return i(n,t),n.prototype.createContentNodes=function(){return this.image=e({tagName:"img",attributes:{src:""},data:{trixMutable:!0,trixStoreKey:this.attachment.getCacheKey("imageElement")}}),this.refresh(this.image),[this.image]},n.prototype.refresh=function(t){var e;return null==t&&(t=null!=(e=this.findElement())?e.querySelector("img"):void 0),t?this.updateAttributesForImage(t):void 0},n.prototype.updateAttributesForImage=function(t){var e,n,i,o,r;return o=this.attachment.getURL(),n=this.attachment.getPreloadedURL(),t.src=n||o,n===o?t.removeAttribute("data-trix-serialized-attributes"):(i=JSON.stringify({src:o}),t.setAttribute("data-trix-serialized-attributes",i)),r=this.attachment.getWidth(),e=this.attachment.getHeight(),null!=r&&(t.width=r),null!=e?t.height=e:void 0},n.prototype.attachmentDidPreload=function(){return this.refresh(this.image),this.refresh()},n}(Trix.AttachmentView)}.call(this),function(){var t,e,n=function(t,e){function n(){this.constructor=t}for(var o in e)i.call(e,o)&&(t[o]=e[o]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},i={}.hasOwnProperty;e=Trix.makeElement,t=Trix.findInnerElement,Trix.PieceView=function(i){function o(){o.__super__.constructor.apply(this,arguments),this.piece=this.object,this.attributes=this.piece.getAttributes(),this.textConfig=this.options.textConfig,this.piece.attachment?this.attachment=this.piece.attachment:this.string=this.piece.toString()}var r;return n(o,i),o.prototype.createNodes=function(){var e,n,i,o,r,s;if(s=this.attachment?this.createAttachmentNodes():this.createStringNodes(),e=this.createElement()){for(i=t(e),n=0,o=s.length;o>n;n++)r=s[n],i.appendChild(r);s=[e]}return s},o.prototype.createAttachmentNodes=function(){var t,e;return t=this.attachment.isPreviewable()?Trix.PreviewableAttachmentView:Trix.AttachmentView,e=this.createChildView(t,this.piece.attachment,{piece:this.piece}),e.getNodes()},o.prototype.createStringNodes=function(){var t,n,i,o,s,a,u,c,l,h;if(null!=(c=this.textConfig)?c.plaintext:void 0)return[document.createTextNode(this.string)];for(u=[],l=this.string.split("\n"),i=n=0,o=l.length;o>n;i=++n)h=l[i],i>0&&(t=e("br"),u.push(t)),(s=h.length)&&(a=document.createTextNode(r(h)),u.push(a));return u},o.prototype.createElement=function(){var t,n,i,o,r,s,a,u;for(o in this.attributes)if((t=Trix.config.textAttributes[o])&&(t.tagName&&(r=e(t.tagName),i?(i.appendChild(r),i=r):n=i=r),t.style))if(a){s=t.style;for(o in s)u=s[o],a[o]=u}else a=t.style;if(a){null==n&&(n=e("span"));for(o in a)u=a[o],n.style[o]=u}return n},o.prototype.createContainerElement=function(){var t,n,i,o,r;o=this.attributes;for(i in o)if(r=o[i],(n=Trix.config.textAttributes[i])&&n.groupTagName)return t={},t[i]=r,e(n.groupTagName,t)},r=function(t){var e;return e=Trix.NON_BREAKING_SPACE,t.replace(/\ $/,e).replace(/(\S)\ {3}(\S)/g,"$1 "+e+" $2").replace(/\ {2}/g,e+" ").replace(/\ {2}/g," "+e).replace(/^\ /,e)},o}(Trix.ObjectView)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.TextView=function(e){function n(){n.__super__.constructor.apply(this,arguments),this.text=this.object,this.textConfig=this.options.textConfig}return t(n,e),n.prototype.createNodes=function(){var t,e,n,i,o,r,s,a;for(n=[],s=function(){var t,e,n,i;for(n=this.text.getPieces(),i=[],t=0,e=n.length;e>t;t++)r=n[t],r.hasAttribute("blockBreak")||i.push(r);return i}.call(this),o=Trix.ObjectGroup.groupObjects(s),t=0,e=o.length;e>t;t++)i=o[t],a=this.findOrCreateCachedChildView(Trix.PieceView,i,{textConfig:this.textConfig}),n.push.apply(n,a.getNodes());return n},n}(Trix.ObjectView)}.call(this),function(){var t,e=function(t,e){function i(){this.constructor=t}for(var o in e)n.call(e,o)&&(t[o]=e[o]);return i.prototype=e.prototype,t.prototype=new i,t.__super__=e.prototype,t},n={}.hasOwnProperty;t=Trix.makeElement,Trix.BlockView=function(n){function i(){i.__super__.constructor.apply(this,arguments),this.block=this.object,this.attributes=this.block.getAttributes()}return e(i,n),i.prototype.createNodes=function(){var e,n,i,o,r,s,a,u,c;if(e=document.createComment("block"),s=[e],this.block.isEmpty()?s.push(t("br")):(u=null!=(a=Trix.config.blockAttributes[this.block.getLastAttribute()])?a.text:void 0,c=this.findOrCreateCachedChildView(Trix.TextView,this.block.text,{textConfig:u}),s.push.apply(s,c.getNodes()),this.shouldAddExtraNewlineElement()&&s.push(t("br"))),this.attributes.length)return s;for(n=t(Trix.config.blockAttributes["default"].tagName),i=0,o=s.length;o>i;i++)r=s[i],n.appendChild(r);return[n]},i.prototype.createContainerElement=function(e){var n,i;return n=this.attributes[e],i=Trix.config.blockAttributes[n],t(i.tagName)},i.prototype.shouldAddExtraNewlineElement=function(){return/\n\n$/.test(this.block.toString())},i}(Trix.ObjectView)}.call(this),function(){var t,e,n=function(t,e){function n(){this.constructor=t}for(var o in e)i.call(e,o)&&(t[o]=e[o]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},i={}.hasOwnProperty;t=Trix.defer,e=Trix.makeElement,Trix.DocumentView=function(i){function o(){o.__super__.constructor.apply(this,arguments),this.element=this.options.element,this.elementStore=new Trix.ElementStore,this.setDocument(this.object)}var r,s,a;return n(o,i),o.render=function(t){var n,i;return n=e("div"),i=new this(t,{element:n}),i.render(),i.sync(),n},o.prototype.setDocument=function(t){return t.isEqualTo(this.document)?void 0:this.document=this.object=t},o.prototype.render=function(){var t,n,i,o,r,s,a;if(this.childViews=[],this.shadowElement=e("div"),!this.document.isEmpty()){for(r=Trix.ObjectGroup.groupObjects(this.document.getBlocks(),{asTree:!0}),s=[],t=0,n=r.length;n>t;t++)o=r[t],a=this.findOrCreateCachedChildView(Trix.BlockView,o),s.push(function(){var t,e,n,o;for(n=a.getNodes(),o=[],t=0,e=n.length;e>t;t++)i=n[t],o.push(this.shadowElement.appendChild(i));return o}.call(this));return s}},o.prototype.isSynced=function(){return r(this.shadowElement,this.element)},o.prototype.sync=function(){var t;for(t=this.createDocumentFragmentForSync();this.element.lastChild;)this.element.removeChild(this.element.lastChild);return this.element.appendChild(t),this.didSync()},o.prototype.didSync=function(){return this.elementStore.reset(s(this.element)),t(function(t){return function(){return t.garbageCollectCachedViews()}}(this))},o.prototype.createDocumentFragmentForSync=function(){var t,e,n,i,o,r,a,u,c,l;for(e=document.createDocumentFragment(),u=this.shadowElement.childNodes,n=0,o=u.length;o>n;n++)a=u[n],e.appendChild(a.cloneNode(!0));for(c=s(e),i=0,r=c.length;r>i;i++)t=c[i],(l=this.elementStore.remove(t))&&t.parentNode.replaceChild(l,t);return e},s=function(t){return t.querySelectorAll("[data-trix-store-key]")},r=function(t,e){return a(t.innerHTML)===a(e.innerHTML)},a=function(t){return t.replace(/&nbsp;/g," ")},o}(Trix.ObjectView)}.call(this),function(){var t,e,n,i,o,r,s=function(t,e){return function(){return t.apply(e,arguments)}},a=function(t,e){function n(){this.constructor=t}for(var i in e)u.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},u={}.hasOwnProperty;i=Trix.handleEvent,r=Trix.tagName,n=Trix.findClosestElementFromNode,o=Trix.innerElementIsActive,e=Trix.defer,t=Trix.AttachmentView.attachmentSelector,Trix.CompositionController=function(n){function r(e,n){this.element=e,this.composition=n,this.didClickAttachment=s(this.didClickAttachment,this),this.didBlur=s(this.didBlur,this),this.didFocus=s(this.didFocus,this),this.documentView=new Trix.DocumentView(this.composition.document,{element:this.element}),i("focus",{onElement:this.element,withCallback:this.didFocus}),i("blur",{onElement:this.element,withCallback:this.didBlur}),i("click",{onElement:this.element,matchingSelector:"a[contenteditable=false]",preventDefault:!0}),i("mousedown",{onElement:this.element,matchingSelector:t,withCallback:this.didClickAttachment}),i("click",{onElement:this.element,matchingSelector:"a"+t,preventDefault:!0})}return a(r,n),r.prototype.didFocus=function(){var t;return this.focused?void 0:(this.focused=!0,null!=(t=this.delegate)&&"function"==typeof t.compositionControllerDidFocus?t.compositionControllerDidFocus():void 0)},r.prototype.didBlur=function(){return e(function(t){return function(){var e;return o(t.element)?void 0:(t.focused=null,null!=(e=t.delegate)&&"function"==typeof e.compositionControllerDidBlur?e.compositionControllerDidBlur():void 0)}}(this))},r.prototype.didClickAttachment=function(t,e){var n,i;return n=this.findAttachmentForElement(e),null!=(i=this.delegate)&&"function"==typeof i.compositionControllerDidSelectAttachment?i.compositionControllerDidSelectAttachment(n):void 0},r.prototype.render=function(){var t,e,n;return this.revision!==this.composition.revision&&(this.documentView.setDocument(this.composition.document),this.documentView.render(),this.revision=this.composition.revision),this.documentView.isSynced()||(null!=(t=this.delegate)&&"function"==typeof t.compositionControllerWillSyncDocumentView&&t.compositionControllerWillSyncDocumentView(),this.documentView.sync(),this.reinstallAttachmentEditor(),null!=(e=this.delegate)&&"function"==typeof e.compositionControllerDidSyncDocumentView&&e.compositionControllerDidSyncDocumentView()),null!=(n=this.delegate)&&"function"==typeof n.compositionControllerDidRender?n.compositionControllerDidRender():void 0},r.prototype.rerenderViewForObject=function(t){return this.documentView.invalidateViewForObject(t),this.render()},r.prototype.isViewCachingEnabled=function(){return this.documentView.isViewCachingEnabled()},r.prototype.enableViewCaching=function(){return this.documentView.enableViewCaching()},r.prototype.disableViewCaching=function(){return this.documentView.disableViewCaching()},r.prototype.refreshViewCache=function(){return this.documentView.garbageCollectCachedViews()},r.prototype.installAttachmentEditorForAttachment=function(t){var e,n,i;if((null!=(i=this.attachmentEditor)?i.attachment:void 0)!==t&&(n=this.documentView.findElementForObject(t)))return this.uninstallAttachmentEditor(),e=this.composition.document.getAttachmentPieceForAttachment(t),this.attachmentEditor=new Trix.AttachmentEditorController(e,n,this.element),this.attachmentEditor.delegate=this},r.prototype.uninstallAttachmentEditor=function(){var t;return null!=(t=this.attachmentEditor)?t.uninstall():void 0},r.prototype.reinstallAttachmentEditor=function(){var t;return this.attachmentEditor?(t=this.attachmentEditor.attachment,this.uninstallAttachmentEditor(),this.installAttachmentEditorForAttachment(t)):void 0},r.prototype.editAttachmentCaption=function(){var t;return null!=(t=this.attachmentEditor)?t.editCaption():void 0},r.prototype.didUninstallAttachmentEditor=function(){return this.attachmentEditor=null,this.render()},r.prototype.attachmentEditorDidRequestUpdatingAttributesForAttachment=function(t,e){var n;return null!=(n=this.delegate)&&"function"==typeof n.compositionControllerWillUpdateAttachment&&n.compositionControllerWillUpdateAttachment(e),this.composition.updateAttributesForAttachment(t,e)},r.prototype.attachmentEditorDidRequestRemovingAttributeForAttachment=function(t,e){var n;return null!=(n=this.delegate)&&"function"==typeof n.compositionControllerWillUpdateAttachment&&n.compositionControllerWillUpdateAttachment(e),this.composition.removeAttributeForAttachment(t,e)},r.prototype.attachmentEditorDidRequestRemovalOfAttachment=function(t){var e;return null!=(e=this.delegate)&&"function"==typeof e.compositionControllerDidRequestRemovalOfAttachment?e.compositionControllerDidRequestRemovalOfAttachment(t):void 0},r.prototype.attachmentEditorDidRequestDeselectingAttachment=function(t){var e;return null!=(e=this.delegate)&&"function"==typeof e.compositionControllerDidRequestDeselectingAttachment?e.compositionControllerDidRequestDeselectingAttachment(t):void 0},r.prototype.findAttachmentForElement=function(t){return this.composition.document.getAttachmentById(parseInt(t.dataset.trixId,10))},r}(Trix.BasicObject)}.call(this),function(){var t,e,n,i=function(t,e){return function(){return t.apply(e,arguments)}},o=function(t,e){function n(){this.constructor=t}for(var i in e)r.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},r={}.hasOwnProperty;e=Trix.handleEvent,n=Trix.triggerEvent,t=Trix.findClosestElementFromNode,Trix.ToolbarController=function(r){function s(t){this.element=t,this.didKeyDownDialogInput=i(this.didKeyDownDialogInput,this),this.didClickDialogButton=i(this.didClickDialogButton,this),this.didClickAttributeButton=i(this.didClickAttributeButton,this),this.didClickActionButton=i(this.didClickActionButton,this),this.attributes={},this.actions={},this.resetDialogInputs(),e("mousedown",{onElement:this.element,matchingSelector:a,withCallback:this.didClickActionButton}),e("mousedown",{onElement:this.element,matchingSelector:c,withCallback:this.didClickAttributeButton}),e("click",{onElement:this.element,matchingSelector:y,preventDefault:!0}),e("click",{onElement:this.element,matchingSelector:l,withCallback:this.didClickDialogButton}),e("keydown",{onElement:this.element,matchingSelector:h,withCallback:this.didKeyDownDialogInput})}var a,u,c,l,h,p,d,f,g,m,y;return o(s,r),a="button[data-action]",c="button[data-attribute]",y=[a,c].join(", "),p=".dialog[data-dialog]",u=p+".active",l=p+" input[data-method]",h=p+" input[type=text], "+p+" input[type=url]",s.prototype.didClickActionButton=function(t,e){var n,i,o;return null!=(i=this.delegate)&&i.toolbarDidClickButton(),t.preventDefault(),n=d(e),this.getDialog(n)?this.toggleDialog(n):null!=(o=this.delegate)?o.toolbarDidInvokeAction(n):void 0},s.prototype.didClickAttributeButton=function(t,e){var n,i,o;return null!=(i=this.delegate)&&i.toolbarDidClickButton(),t.preventDefault(),n=f(e),this.getDialog(n)?this.toggleDialog(n):null!=(o=this.delegate)&&o.toolbarDidToggleAttribute(n),this.refreshAttributeButtons()},s.prototype.didClickDialogButton=function(e,n){var i,o;return i=t(n,{matchingSelector:p}),o=n.getAttribute("data-method"),this[o].call(this,i)},s.prototype.didKeyDownDialogInput=function(t,e){var n,i;return 13===t.keyCode&&(t.preventDefault(),n=e.getAttribute("name"),i=this.getDialog(n),this.setAttribute(i)),27===t.keyCode?(t.preventDefault(),this.hideDialog()):void 0},s.prototype.updateActions=function(t){return this.actions=t,this.refreshActionButtons()},s.prototype.refreshActionButtons=function(){return this.eachActionButton(function(t){return function(e,n){return e.disabled=t.actions[n]===!1}}(this))},s.prototype.eachActionButton=function(t){var e,n,i,o,r;for(o=this.element.querySelectorAll(a),r=[],n=0,i=o.length;i>n;n++)e=o[n],r.push(t(e,d(e)));return r},s.prototype.updateAttributes=function(t){return this.attributes=t,this.refreshAttributeButtons()},s.prototype.refreshAttributeButtons=function(){return this.eachAttributeButton(function(t){return function(e,n){return t.attributes[n]||t.dialogIsVisible(n)?e.classList.add("active"):e.classList.remove("active")}}(this))},s.prototype.eachAttributeButton=function(t){var e,n,i,o,r;for(o=this.element.querySelectorAll(c),r=[],n=0,i=o.length;i>n;n++)e=o[n],r.push(t(e,f(e)));return r},s.prototype.applyKeyboardCommand=function(t){var e,i,o,r,s,a,u;for(s=JSON.stringify(t.sort()),u=this.element.querySelectorAll("[data-key]"),r=0,a=u.length;a>r;r++)if(e=u[r],o=e.getAttribute("data-key").split("+"),i=JSON.stringify(o.sort()),i===s)return n("mousedown",{onElement:e}),!0;return!1},s.prototype.dialogIsVisible=function(t){var e;return(e=this.getDialog(t))?e.classList.contains("active"):void 0},s.prototype.toggleDialog=function(t){return this.dialogIsVisible(t)?this.hideDialog():this.showDialog(t)},s.prototype.showDialog=function(t){var e,n,i,o,r,s;return this.hideDialog(),null!=(o=this.delegate)&&o.toolbarWillShowDialog(),n=this.getDialog(t),n.classList.add("active"),(e=f(n))&&(i=m(n,t))&&(i.removeAttribute("disabled"),i.value=null!=(r=this.attributes[e])?r:"",i.select()),null!=(s=this.delegate)?s.toolbarDidShowDialog(t):void 0},s.prototype.setAttribute=function(t){var e,n,i;return e=f(t),n=m(t,e),n.willValidate&&!n.checkValidity()?(n.classList.add("validate"),n.focus()):(null!=(i=this.delegate)&&i.toolbarDidUpdateAttribute(e,n.value),this.hideDialog())},s.prototype.removeAttribute=function(t){var e,n;return e=f(t),null!=(n=this.delegate)&&n.toolbarDidRemoveAttribute(e),this.hideDialog()},s.prototype.hideDialog=function(){var t,e;return(t=this.element.querySelector(u))?(t.classList.remove("active"),this.resetDialogInputs(),null!=(e=this.delegate)?e.toolbarDidHideDialog(g(t)):void 0):void 0},s.prototype.resetDialogInputs=function(){var t,e,n,i,o;for(i=this.element.querySelectorAll(h),o=[],t=0,n=i.length;n>t;t++)e=i[t],e.setAttribute("disabled","disabled"),o.push(e.classList.remove("validate"));return o},s.prototype.getDialog=function(t){return this.element.querySelector(".dialog[data-dialog="+t+"]")},m=function(t,e){return null==e&&(e=f(t)),t.querySelector("input[name='"+e+"']")},d=function(t){return t.getAttribute("data-action")},f=function(t){return t.getAttribute("data-attribute")},g=function(t){return t.getAttribute("data-dialog")},s}(Trix.BasicObject)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.ImagePreloadOperation=function(e){function n(t){this.url=t}return t(n,e),n.prototype.perform=function(t){var e;return e=new Image,e.onload=function(n){return function(){return e.width=n.width=e.naturalWidth,e.height=n.height=e.naturalHeight,t(!0,e)}}(this),e.onerror=function(){return t(!1)},e.src=this.url},n}(Trix.Operation)}.call(this),function(){var t=function(t,e){return function(){return t.apply(e,arguments)}},e=function(t,e){function i(){this.constructor=t}for(var o in e)n.call(e,o)&&(t[o]=e[o]);return i.prototype=e.prototype,t.prototype=new i,t.__super__=e.prototype,t},n={}.hasOwnProperty;Trix.Attachment=function(n){function i(e){null==e&&(e={}),this.releaseFile=t(this.releaseFile,this),i.__super__.constructor.apply(this,arguments),this.attributes=Trix.Hash.box(e),this.didChangeAttributes()}return e(i,n),i.previewablePattern=/^image(\/(gif|png|jpe?g)|$)/,i.attachmentForFile=function(t){var e,n;return n=this.attributesForFile(t),e=new this(n),e.setFile(t),e},i.attributesForFile=function(t){return new Trix.Hash({filename:t.name,filesize:t.size,contentType:t.type})},i.fromJSON=function(t){return new this(t)},i.prototype.getAttribute=function(t){return this.attributes.get(t)},i.prototype.hasAttribute=function(t){return this.attributes.has(t)},i.prototype.getAttributes=function(){return this.attributes.toObject()},i.prototype.setAttributes=function(t){var e,n;return null==t&&(t={}),e=this.attributes.merge(t),this.attributes.isEqualTo(e)?void 0:(this.attributes=e,this.didChangeAttributes(),null!=(n=this.delegate)&&"function"==typeof n.attachmentDidChangeAttributes?n.attachmentDidChangeAttributes(this):void 0)},i.prototype.didChangeAttributes=function(){return this.isPreviewable()?this.preloadURL():void 0},i.prototype.isPending=function(){return null!=this.file&&!(this.getURL()||this.getHref())},i.prototype.isPreviewable=function(){return this.attributes.has("previewable")?this.attributes.get("previewable"):this.constructor.previewablePattern.test(this.getContentType())},i.prototype.getType=function(){return this.hasContent()?"content":this.isPreviewable()?"preview":"file"},i.prototype.getURL=function(){return this.attributes.get("url")},i.prototype.getHref=function(){return this.attributes.get("href")},i.prototype.getFilename=function(){var t;return null!=(t=this.attributes.get("filename"))?t:""},i.prototype.getFilesize=function(){return this.attributes.get("filesize")},i.prototype.getFormattedFilesize=function(){var t;return t=this.attributes.get("filesize"),"number"==typeof t?Trix.config.fileSize.formatter(t):""},i.prototype.getExtension=function(){var t;return null!=(t=this.getFilename().match(/\.(\w+)$/))?t[1].toLowerCase():void 0},i.prototype.getContentType=function(){return this.attributes.get("contentType")},i.prototype.hasContent=function(){return this.attributes.has("content")},i.prototype.getContent=function(){return this.attributes.get("content")},i.prototype.getWidth=function(){return this.attributes.get("width")},i.prototype.getHeight=function(){return this.attributes.get("height")},i.prototype.getFile=function(){return this.file},i.prototype.setFile=function(t){return this.file=t,this.isPreviewable()?this.preloadFile():void 0},i.prototype.releaseFile=function(){return this.releasePreloadedFile(),this.file=null},i.prototype.getUploadProgress=function(){var t;return null!=(t=this.uploadProgress)?t:0},i.prototype.setUploadProgress=function(t){var e;return this.uploadProgress!==t?(this.uploadProgress=t,null!=(e=this.uploadProgressDelegate)&&"function"==typeof e.attachmentDidChangeUploadProgress?e.attachmentDidChangeUploadProgress(this):void 0):void 0},i.prototype.toJSON=function(){return this.getAttributes()},i.prototype.getCacheKey=function(t){var e;return e=[i.__super__.getCacheKey.apply(this,arguments),this.attributes.getCacheKey(),this.getPreloadedURL()],t&&e.unshift(t),e.join("/")},i.prototype.getPreloadedURL=function(){return this.preloadedURL},i.prototype.preloadURL=function(){return this.preload(this.getURL(),this.releaseFile)},i.prototype.preloadFile=function(){return this.file?(this.fileObjectURL=URL.createObjectURL(this.file),this.preload(this.fileObjectURL)):void 0},i.prototype.releasePreloadedFile=function(){return this.fileObjectURL?(URL.revokeObjectURL(this.fileObjectURL),this.fileObjectURL=null):void 0},i.prototype.preload=function(t,e){var n;return t&&t!==this.preloadedURL?(null==this.preloadedURL&&(this.preloadedURL=t),n=new Trix.ImagePreloadOperation(t),n.then(function(n){return function(i){var o,r,s;return s=i.width,o=i.height,n.preloadedURL=t,n.setAttributes({width:s,height:o}),null!=(r=n.previewDelegate)&&"function"==typeof r.attachmentDidPreload&&r.attachmentDidPreload(),"function"==typeof e?e():void 0}}(this))):void 0},i}(Trix.Object)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Piece=function(e){function n(t,e){null==e&&(e={}),n.__super__.constructor.apply(this,arguments),this.attributes=Trix.Hash.box(e)}return t(n,e),n.types={},n.registerType=function(t,e){return e.type=t,this.types[t]=e},n.fromJSON=function(t){var e;return(e=this.types[t.type])?e.fromJSON(t):void 0},n.prototype.copyWithAttributes=function(t){return new this.constructor(this.getValue(),t)},n.prototype.copyWithAdditionalAttributes=function(t){return this.copyWithAttributes(this.attributes.merge(t))},n.prototype.copyWithoutAttribute=function(t){return this.copyWithAttributes(this.attributes.remove(t))},n.prototype.copy=function(){return this.copyWithAttributes(this.attributes)},n.prototype.getAttribute=function(t){return this.attributes.get(t)},n.prototype.getAttributesHash=function(){return this.attributes},n.prototype.getAttributes=function(){return this.attributes.toObject()},n.prototype.getCommonAttributes=function(){var t,e,n;return(n=pieceList.getPieceAtIndex(0))?(t=n.attributes,e=t.getKeys(),pieceList.eachPiece(function(n){return e=t.getKeysCommonToHash(n.attributes),t=t.slice(e)}),t.toObject()):{}},n.prototype.hasAttribute=function(t){return this.attributes.has(t)},n.prototype.hasSameStringValueAsPiece=function(t){return null!=t&&this.toString()===t.toString()},n.prototype.hasSameAttributesAsPiece=function(t){return null!=t&&(this.attributes===t.attributes||this.attributes.isEqualTo(t.attributes))},n.prototype.isBlockBreak=function(){return!1},n.prototype.isEqualTo=function(t){return n.__super__.isEqualTo.apply(this,arguments)||this.hasSameConstructorAs(t)&&this.hasSameStringValueAsPiece(t)&&this.hasSameAttributesAsPiece(t)},n.prototype.isEmpty=function(){return 0===this.length},n.prototype.isSerializable=function(){return!0},n.prototype.toJSON=function(){return{type:this.constructor.type,attributes:this.getAttributes()}},n.prototype.contentsForInspection=function(){return{type:this.constructor.type,attributes:this.attributes.inspect()}},n.prototype.canBeGrouped=function(){return this.hasAttribute("href")},n.prototype.canBeGroupedWith=function(t){return this.getAttribute("href")===t.getAttribute("href")},n.prototype.getLength=function(){return this.length},n.prototype.canBeConsolidatedWith=function(){return!1},n}(Trix.Object)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Piece.registerType("attachment",Trix.AttachmentPiece=function(e){function n(t){this.attachment=t,n.__super__.constructor.apply(this,arguments),this.length=1,this.ensureAttachmentExclusivelyHasAttribute("href")}return t(n,e),n.fromJSON=function(t){return new this(Trix.Attachment.fromJSON(t.attachment),t.attributes)},n.prototype.ensureAttachmentExclusivelyHasAttribute=function(t){return this.hasAttribute(t)&&this.attachment.hasAttribute(t)?this.attributes=this.attributes.remove(t):void 0},n.prototype.getValue=function(){return this.attachment},n.prototype.isSerializable=function(){return!this.attachment.isPending()},n.prototype.getCaption=function(){var t;return null!=(t=this.attributes.get("caption"))?t:""},n.prototype.getAttributesForAttachment=function(){return this.attributes.slice(["caption"])},n.prototype.canBeGrouped=function(){return n.__super__.canBeGrouped.apply(this,arguments)&&!this.attachment.hasAttribute("href")},n.prototype.isEqualTo=function(t){var e;return n.__super__.isEqualTo.apply(this,arguments)&&this.attachment.id===(null!=t&&null!=(e=t.attachment)?e.id:void 0)},n.prototype.toString=function(){return Trix.OBJECT_REPLACEMENT_CHARACTER},n.prototype.toJSON=function(){var t;return t=n.__super__.toJSON.apply(this,arguments),t.attachment=this.attachment,t},n.prototype.getCacheKey=function(){return[n.__super__.getCacheKey.apply(this,arguments),this.attachment.getCacheKey()].join("/")},n.prototype.toConsole=function(){return JSON.stringify(this.toString())},n}(Trix.Piece))}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Piece.registerType("string",Trix.StringPiece=function(e){function n(t){n.__super__.constructor.apply(this,arguments),this.string=t,this.length=this.string.length}return t(n,e),n.fromJSON=function(t){return new this(t.string,t.attributes)},n.prototype.getValue=function(){return this.string},n.prototype.toString=function(){return this.string.toString()},n.prototype.isBlockBreak=function(){return"\n"===this.toString()&&this.getAttribute("blockBreak")===!0},n.prototype.toJSON=function(){var t;return t=n.__super__.toJSON.apply(this,arguments),t.string=this.string,t},n.prototype.canBeConsolidatedWith=function(t){return null!=t&&this.hasSameConstructorAs(t)&&this.hasSameAttributesAsPiece(t)},n.prototype.consolidateWith=function(t){return new this.constructor(this.toString()+t.toString(),this.attributes)},n.prototype.splitAtOffset=function(t){var e,n;return 0===t?(e=null,n=this):t===this.length?(e=this,n=null):(e=new this.constructor(this.string.slice(0,t),this.attributes),n=new this.constructor(this.string.slice(t),this.attributes)),[e,n]},n.prototype.toConsole=function(){var t;return t=this.string,t.length>15&&(t=t.slice(0,14)+"\u2026"),JSON.stringify(t.toString())},n}(Trix.Piece))}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty,n=[].slice;Trix.SplittableList=function(e){function i(t){null==t&&(t=[]),i.__super__.constructor.apply(this,arguments),this.objects=t.slice(0),this.length=this.objects.length}var o,r,s;return t(i,e),i.box=function(t){return t instanceof this?t:new this(t)},i.prototype.eachObject=function(t){var e,n,i,o,r,s;for(r=this.objects,s=[],n=e=0,i=r.length;i>e;n=++e)o=r[n],s.push(t(o,n));return s},i.prototype.insertObjectAtIndex=function(t,e){var n;return n=this.objects.slice(0),n.splice(e,0,t),new this.constructor(n)},i.prototype.insertSplittableListAtIndex=function(t,e){var i;return i=this.objects.slice(0),i.splice.apply(i,[e,0].concat(n.call(t.objects))),new this.constructor(i)},i.prototype.insertSplittableListAtPosition=function(t,e){var n,i,o;return o=this.splitObjectAtPosition(e),i=o[0],n=o[1],new this.constructor(i).insertSplittableListAtIndex(t,n)},i.prototype.editObjectAtIndex=function(t,e){return this.replaceObjectAtIndex(e(this.objects[t]),t)},i.prototype.replaceObjectAtIndex=function(t,e){var n;return n=this.objects.slice(0),n.splice(e,1,t),new this.constructor(n)},i.prototype.removeObjectAtIndex=function(t){var e;return e=this.objects.slice(0),e.splice(t,1),new this.constructor(e)},i.prototype.getObjectAtIndex=function(t){return this.objects[t]},i.prototype.getSplittableListInRange=function(t){var e,n,i,o;return i=this.splitObjectsAtRange(t),n=i[0],e=i[1],o=i[2],new this.constructor(n.slice(e,o+1))},i.prototype.selectSplittableList=function(t){var e,n;return n=function(){var n,i,o,r;for(o=this.objects,r=[],n=0,i=o.length;i>n;n++)e=o[n],t(e)&&r.push(e);return r}.call(this),new this.constructor(n)},i.prototype.removeObjectsInRange=function(t){var e,n,i,o;return i=this.splitObjectsAtRange(t),n=i[0],e=i[1],o=i[2],n.splice(e,o-e+1),new this.constructor(n)},i.prototype.transformObjectsInRange=function(t,e){var n,i,o,r,s,a,u;return s=this.splitObjectsAtRange(t),r=s[0],i=s[1],a=s[2],u=function(){var t,s,u;for(u=[],n=t=0,s=r.length;s>t;n=++t)o=r[n],u.push(n>=i&&a>=n?e(o):o);return u}(),new this.constructor(u)},i.prototype.splitObjectsAtRange=function(t){var e,n,i,r,a,u;return r=this.splitObjectAtPosition(s(t)),n=r[0],e=r[1],i=r[2],a=new this.constructor(n).splitObjectAtPosition(o(t)+i),n=a[0],u=a[1],[n,e,u-1]},i.prototype.getObjectAtPosition=function(t){var e,n,i;return i=this.findIndexAndOffsetAtPosition(t),e=i.index,n=i.offset,this.objects[e]},i.prototype.splitObjectAtPosition=function(t){var e,n,i,o,r,s,a,u,c,l;return s=this.findIndexAndOffsetAtPosition(t),e=s.index,r=s.offset,o=this.objects.slice(0),null!=e?0===r?(c=e,l=0):(i=this.getObjectAtIndex(e),a=i.splitAtOffset(r),n=a[0],u=a[1],o.splice(e,1,n,u),c=e+1,l=n.getLength()-r):(c=o.length,l=0),[o,c,l]},i.prototype.consolidate=function(){var t,e,n,i,o,r;for(i=[],o=this.objects[0],r=this.objects.slice(1),t=0,e=r.length;e>t;t++)n=r[t],("function"==typeof o.canBeConsolidatedWith?o.canBeConsolidatedWith(n):void 0)?o=o.consolidateWith(n):(i.push(o),o=n);
return null!=o&&i.push(o),new this.constructor(i)},i.prototype.consolidateFromIndexToIndex=function(t,e){var i,o,r;return o=this.objects.slice(0),r=o.slice(t,e+1),i=new this.constructor(r).consolidate().toArray(),o.splice.apply(o,[t,r.length].concat(n.call(i))),new this.constructor(o)},i.prototype.findIndexAndOffsetAtPosition=function(t){var e,n,i,o,r,s,a;for(e=0,a=this.objects,i=n=0,o=a.length;o>n;i=++n){if(s=a[i],r=e+s.getLength(),t>=e&&r>t)return{index:i,offset:t-e};e=r}return{index:null,offset:null}},i.prototype.findPositionAtIndexAndOffset=function(t,e){var n,i,o,r,s,a;for(s=0,a=this.objects,n=i=0,o=a.length;o>i;n=++i)if(r=a[n],t>n)s+=r.getLength();else if(n===t){s+=e;break}return s},i.prototype.getEndPosition=function(){var t,e;return null!=this.endPosition?this.endPosition:this.endPosition=function(){var n,i,o;for(e=0,o=this.objects,n=0,i=o.length;i>n;n++)t=o[n],e+=t.getLength();return e}.call(this)},i.prototype.toString=function(){return this.objects.join("")},i.prototype.toArray=function(){return this.objects.slice(0)},i.prototype.toJSON=function(){return this.toArray()},i.prototype.isEqualTo=function(t){return i.__super__.isEqualTo.apply(this,arguments)||r(this.objects,null!=t?t.objects:void 0)},r=function(t,e){var n,i,o,r,s;if(null==e&&(e=[]),t.length!==e.length)return!1;for(s=!0,i=n=0,o=t.length;o>n;i=++n)r=t[i],s&&!r.isEqualTo(e[i])&&(s=!1);return s},i.prototype.contentsForInspection=function(){var t;return{objects:"["+function(){var e,n,i,o;for(i=this.objects,o=[],e=0,n=i.length;n>e;e++)t=i[e],o.push(t.inspect());return o}.call(this).join(", ")+"]"}},s=function(t){return t[0]},o=function(t){return t[1]},i}(Trix.Object)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.Text=function(e){function n(t){var e;null==t&&(t=[]),n.__super__.constructor.apply(this,arguments),this.pieceList=new Trix.SplittableList(function(){var n,i,o;for(o=[],n=0,i=t.length;i>n;n++)e=t[n],e.isEmpty()||o.push(e);return o}())}return t(n,e),n.textForAttachmentWithAttributes=function(t,e){var n;return n=new Trix.AttachmentPiece(t,e),new this([n])},n.textForStringWithAttributes=function(t,e){var n;return n=new Trix.StringPiece(t,e),new this([n])},n.fromJSON=function(t){var e,n;return n=function(){var n,i,o;for(o=[],n=0,i=t.length;i>n;n++)e=t[n],o.push(Trix.Piece.fromJSON(e));return o}(),new this(n)},n.prototype.copy=function(){return this.copyWithPieceList(this.pieceList)},n.prototype.copyWithPieceList=function(t){return new this.constructor(t.consolidate().toArray())},n.prototype.copyUsingObjectMap=function(t){var e,n;return n=function(){var n,i,o,r,s;for(o=this.getPieces(),s=[],n=0,i=o.length;i>n;n++)e=o[n],s.push(null!=(r=t.find(e))?r:e);return s}.call(this),new this.constructor(n)},n.prototype.appendText=function(t){return this.insertTextAtPosition(t,this.getLength())},n.prototype.insertTextAtPosition=function(t,e){return this.copyWithPieceList(this.pieceList.insertSplittableListAtPosition(t.pieceList,e))},n.prototype.removeTextAtRange=function(t){return this.copyWithPieceList(this.pieceList.removeObjectsInRange(t))},n.prototype.replaceTextAtRange=function(t,e){return this.removeTextAtRange(e).insertTextAtPosition(t,e[0])},n.prototype.moveTextFromRangeToPosition=function(t,e){var n,i;if(!(t[0]<=e&&e<=t[1]))return i=this.getTextAtRange(t),n=i.getLength(),t[0]<e&&(e-=n),this.removeTextAtRange(t).insertTextAtPosition(i,e)},n.prototype.addAttributeAtRange=function(t,e,n){var i;return i={},i[t]=e,this.addAttributesAtRange(i,n)},n.prototype.addAttributesAtRange=function(t,e){return this.copyWithPieceList(this.pieceList.transformObjectsInRange(e,function(e){return e.copyWithAdditionalAttributes(t)}))},n.prototype.removeAttributeAtRange=function(t,e){return this.copyWithPieceList(this.pieceList.transformObjectsInRange(e,function(e){return e.copyWithoutAttribute(t)}))},n.prototype.setAttributesAtRange=function(t,e){return this.copyWithPieceList(this.pieceList.transformObjectsInRange(e,function(e){return e.copyWithAttributes(t)}))},n.prototype.getAttributesAtPosition=function(t){var e,n;return null!=(e=null!=(n=this.pieceList.getObjectAtPosition(t))?n.getAttributes():void 0)?e:{}},n.prototype.getCommonAttributes=function(){var t,e;return t=function(){var t,n,i,o;for(i=this.pieceList.toArray(),o=[],t=0,n=i.length;n>t;t++)e=i[t],o.push(e.getAttributes());return o}.call(this),Trix.Hash.fromCommonAttributesOfObjects(t).toObject()},n.prototype.getCommonAttributesAtRange=function(t){var e;return null!=(e=this.getTextAtRange(t).getCommonAttributes())?e:{}},n.prototype.getExpandedRangeForAttributeAtOffset=function(t,e){var n,i,o;for(n=o=e,i=this.getLength();n>0&&this.getCommonAttributesAtRange([n-1,o])[t];)n--;for(;i>o&&this.getCommonAttributesAtRange([e,o+1])[t];)o++;return[n,o]},n.prototype.getTextAtRange=function(t){return this.copyWithPieceList(this.pieceList.getSplittableListInRange(t))},n.prototype.getStringAtRange=function(t){return this.pieceList.getSplittableListInRange(t).toString()},n.prototype.startsWithString=function(t){return this.getStringAtRange([0,t.length])===t},n.prototype.endsWithString=function(t){var e;return e=this.getLength(),this.getStringAtRange([e-t.length,e])===t},n.prototype.getAttachmentPieces=function(){var t,e,n,i,o;for(i=this.pieceList.toArray(),o=[],t=0,e=i.length;e>t;t++)n=i[t],null!=n.attachment&&o.push(n);return o},n.prototype.getAttachments=function(){var t,e,n,i,o;for(i=this.getAttachmentPieces(),o=[],t=0,e=i.length;e>t;t++)n=i[t],o.push(n.attachment);return o},n.prototype.getAttachmentAndPositionById=function(t){var e,n,i,o,r,s;for(o=0,r=this.pieceList.toArray(),e=0,n=r.length;n>e;e++){if(i=r[e],(null!=(s=i.attachment)?s.id:void 0)===t)return{attachment:i.attachment,position:o};o+=i.length}return{attachment:null,position:null}},n.prototype.getAttachmentById=function(t){var e,n,i;return i=this.getAttachmentAndPositionById(t),e=i.attachment,n=i.position,e},n.prototype.getRangeOfAttachment=function(t){var e,n;return n=this.getAttachmentAndPositionById(t.id),t=n.attachment,e=n.position,null!=t?[e,e+1]:void 0},n.prototype.updateAttributesForAttachment=function(t,e){var n;return(n=this.getRangeOfAttachment(e))?this.addAttributesAtRange(t,n):this},n.prototype.getLength=function(){return this.pieceList.getEndPosition()},n.prototype.isEmpty=function(){return 0===this.getLength()},n.prototype.isEqualTo=function(t){var e;return n.__super__.isEqualTo.apply(this,arguments)||(null!=t&&null!=(e=t.pieceList)?e.isEqualTo(this.pieceList):void 0)},n.prototype.isBlockBreak=function(){return 1===this.getLength()&&this.pieceList.getObjectAtIndex(0).isBlockBreak()},n.prototype.eachPiece=function(t){return this.pieceList.eachObject(t)},n.prototype.getPieces=function(){return this.pieceList.toArray()},n.prototype.getPieceAtPosition=function(t){return this.pieceList.getObjectAtPosition(t)},n.prototype.contentsForInspection=function(){return{pieceList:this.pieceList.inspect()}},n.prototype.toSerializableText=function(){var t;return t=this.pieceList.selectSplittableList(function(t){return t.isSerializable()}),this.copyWithPieceList(t)},n.prototype.toString=function(){return this.pieceList.toString()},n.prototype.toJSON=function(){return this.pieceList.toJSON()},n.prototype.toConsole=function(){var t;return JSON.stringify(function(){var e,n,i,o;for(i=this.pieceList.toArray(),o=[],e=0,n=i.length;n>e;e++)t=i[e],o.push(JSON.parse(t.toConsole()));return o}.call(this))},n}(Trix.Object)}.call(this),function(){var t,e=function(t,e){function i(){this.constructor=t}for(var o in e)n.call(e,o)&&(t[o]=e[o]);return i.prototype=e.prototype,t.prototype=new i,t.__super__=e.prototype,t},n={}.hasOwnProperty,i=[].slice;t=Trix.arraysAreEqual,Trix.Block=function(n){function o(t,e){null==t&&(t=new Trix.Text),null==e&&(e=[]),o.__super__.constructor.apply(this,arguments),this.text=s(t),this.attributes=e}var r,s,a,u,c,l,h,p;return e(o,n),o.fromJSON=function(t){var e;return e=Trix.Text.fromJSON(t.text),new this(e,t.attributes)},o.prototype.isEmpty=function(){return this.text.isBlockBreak()},o.prototype.isEqualTo=function(e){return o.__super__.isEqualTo.apply(this,arguments)||this.text.isEqualTo(null!=e?e.text:void 0)&&t(this.attributes,null!=e?e.attributes:void 0)},o.prototype.copyWithText=function(t){return new this.constructor(t,this.attributes)},o.prototype.copyWithoutText=function(){return this.copyWithText(null)},o.prototype.copyWithAttributes=function(t){return new this.constructor(this.text,t)},o.prototype.copyUsingObjectMap=function(t){var e;return this.copyWithText((e=t.find(this.text))?e:this.text.copyUsingObjectMap(t))},o.prototype.addAttribute=function(t){var e,n;return n=Trix.config.blockAttributes[t].listAttribute,e=this.attributes.concat(n?[n,t]:[t]),this.copyWithAttributes(e)},o.prototype.removeAttribute=function(t){var e,n;return n=Trix.config.blockAttributes[t].listAttribute,e=c(this.attributes,t),null!=n&&(e=c(e,n)),this.copyWithAttributes(e)},o.prototype.removeLastAttribute=function(){return this.removeAttribute(this.getLastAttribute())},o.prototype.getLastAttribute=function(){return u(this.attributes)},o.prototype.getAttributes=function(){return this.attributes.slice(0)},o.prototype.getAttributeLevel=function(){return this.attributes.length},o.prototype.getAttributeAtLevel=function(t){return this.attributes[t-1]},o.prototype.hasAttributes=function(){return this.getAttributeLevel()>0},o.prototype.getConfig=function(t){var e,n;if((e=this.getLastAttribute())&&(n=Trix.config.blockAttributes[e]))return t?n[t]:n},o.prototype.isListItem=function(){return null!=this.getConfig("listAttribute")},o.prototype.findLineBreakInDirectionFromPosition=function(t,e){var n,i;return i=this.toString(),n=function(){switch(t){case"forward":return i.indexOf("\n",e);case"backward":return i.slice(0,e).lastIndexOf("\n")}}(),-1!==n?n:void 0},o.prototype.contentsForInspection=function(){return{text:this.text.inspect(),attributes:this.attributes}},o.prototype.toString=function(){return this.text.toString()},o.prototype.toJSON=function(){return{text:this.text,attributes:this.attributes}},o.prototype.getLength=function(){return this.text.getLength()},o.prototype.canBeConsolidatedWith=function(t){return!this.hasAttributes()&&!t.hasAttributes()},o.prototype.consolidateWith=function(t){var e,n;return e=Trix.Text.textForStringWithAttributes("\n"),n=this.getTextWithoutBlockBreak().appendText(e),this.copyWithText(n.appendText(t.text))},o.prototype.splitAtOffset=function(t){var e,n;return 0===t?(e=null,n=this):t===this.getLength()?(e=this,n=null):(e=this.copyWithText(this.text.getTextAtRange([0,t])),n=this.copyWithText(this.text.getTextAtRange([t,this.getLength()]))),[e,n]},o.prototype.toString=function(){return this.text.toString()},o.prototype.getBlockBreakPosition=function(){return this.text.getLength()-1},o.prototype.getTextWithoutBlockBreak=function(){return l(this.text)?this.text.getTextAtRange([0,this.getBlockBreakPosition()]):this.text.copy()},o.prototype.canBeGrouped=function(t){return this.attributes[t]},o.prototype.canBeGroupedWith=function(t,e){var n,i,o,r;return n=this.attributes,i=t.getAttributes(),n[e]===i[e]?"bullet"!==(o=n[e])&&"number"!==o||"bulletList"===(r=i[e+1])||"numberList"===r?!0:!1:void 0},s=function(t){return t=p(t),t=r(t)},p=function(t){var e,n,o,r,s,a;return r=!1,a=t.getPieces(),n=2<=a.length?i.call(a,0,e=a.length-1):(e=0,[]),o=a[e++],null==o?t:(n=function(){var t,e,i;for(i=[],t=0,e=n.length;e>t;t++)s=n[t],s.isBlockBreak()?(r=!0,i.push(h(s))):i.push(s);return i}(),r?new Trix.Text(i.call(n).concat([o])):t)},a=Trix.Text.textForStringWithAttributes("\n",{blockBreak:!0}),r=function(t){return l(t)?t:t.appendText(a)},l=function(t){var e,n;return n=t.getLength(),0===n?!1:(e=t.getTextAtRange([n-1,n]),e.isBlockBreak())},h=function(t){return t.copyWithoutAttribute("blockBreak")},c=function(t,e){return u(t)===e?t.slice(0,-1):t},u=function(t){return t.slice(-1)[0]},o}(Trix.Object)}.call(this),function(){var t,e,n,i,o,r,s,a,u=function(t,e){function n(){this.constructor=t}for(var i in e)c.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},c={}.hasOwnProperty,l=[].indexOf||function(t){for(var e=0,n=this.length;n>e;e++)if(e in this&&this[e]===t)return e;return-1},h=[].slice;t=Trix.arraysAreEqual,r=Trix.normalizeSpaces,i=Trix.makeElement,s=Trix.tagName,a=Trix.walkTree,n=Trix.findClosestElementFromNode,e=Trix.elementContainsNode,o=Trix.nodeIsAttachmentElement,Trix.HTMLParser=function(c){function p(t,e){this.html=t,this.referenceElement=(null!=e?e:{}).referenceElement,this.blocks=[],this.blockElements=[],this.processedElements=[]}var d,f,g,m,y,v,b,A,x,T;return u(p,c),d="style href src width height class".split(" "),p.parse=function(t,e){var n;return n=new this(t,e),n.parse(),n},p.prototype.getDocument=function(){return Trix.Document.fromJSON(this.blocks)},p.prototype.parse=function(){var t,e;try{for(this.createHiddenContainer(),t=T(this.html),this.containerElement.innerHTML=t,e=a(this.containerElement,{usingFilter:v});e.nextNode();)this.processNode(e.currentNode);return this.translateBlockElementMarginsToNewlines()}finally{this.removeHiddenContainer()}},v=function(t){return"style"===s(t)?NodeFilter.FILTER_REJECT:NodeFilter.FILTER_ACCEPT},p.prototype.createHiddenContainer=function(){return this.referenceElement?(this.containerElement=this.referenceElement.cloneNode(!1),this.containerElement.removeAttribute("id"),this.containerElement.setAttribute("data-trix-internal",""),this.containerElement.style.display="none",this.referenceElement.parentNode.insertBefore(this.containerElement,this.referenceElement.nextSibling)):(this.containerElement=i({tagName:"div",style:{display:"none"}}),document.body.appendChild(this.containerElement))},p.prototype.removeHiddenContainer=function(){return this.containerElement.parentNode.removeChild(this.containerElement)},p.prototype.processNode=function(t){switch(t.nodeType){case Node.TEXT_NODE:return this.processTextNode(t);case Node.ELEMENT_NODE:return this.appendBlockForElement(t),this.processElement(t)}},p.prototype.appendBlockForElement=function(n){var i,o;if(this.isBlockElement(n)&&!this.isBlockElement(n.firstChild)){if(i=this.getBlockAttributes(n),!e(this.currentBlockElement,n)||!t(i,this.currentBlock.attributes))return this.currentBlock=this.appendBlockForAttributesWithElement(i,n),this.currentBlockElement=n}else if(this.currentBlockElement&&!e(this.currentBlockElement,n)&&!this.isBlockElement(n))return(o=this.findParentBlockElement(n))?this.appendBlockForElement(o):(this.currentBlock=this.appendEmptyBlock(),this.currentBlockElement=null)},p.prototype.findParentBlockElement=function(t){var e;for(e=t.parentElement;e&&e!==this.containerElement;){if(this.isBlockElement(e)&&l.call(this.blockElements,e)>=0)return e;e=e.parentElement}return null},p.prototype.isExtraBR=function(t){return"br"===s(t)&&this.isBlockElement(t.parentNode)&&t.parentNode.lastChild===t},p.prototype.isBlockElement=function(t){var e;if((null!=t?t.nodeType:void 0)===Node.ELEMENT_NODE&&!n(t,{matchingSelector:"td"}))return e=s(t),l.call(this.getBlockTagNames(),e)>=0||"block"===window.getComputedStyle(t).display},p.prototype.getBlockTagNames=function(){var t,e;return null!=this.blockTagNames?this.blockTagNames:this.blockTagNames=function(){var n,i;n=Trix.config.blockAttributes,i=[];for(t in n)e=n[t],i.push(e.tagName);return i}()},p.prototype.processTextNode=function(t){var e;return(e=r(t.data))?this.appendStringWithAttributes(e,this.getTextAttributes(t.parentNode)):void 0},p.prototype.processElement=function(t){var e,n,i,r,a;if(o(t))return e=g(t),Object.keys(e).length&&(r=this.getTextAttributes(t),this.appendAttachmentWithAttributes(e,r),t.innerHTML=""),this.processedElements.push(t);switch(s(t)){case"br":return this.isExtraBR(t)||this.isBlockElement(t.nextSibling)||this.appendStringWithAttributes("\n",this.getTextAttributes(t)),this.processedElements.push(t);case"img":e={url:t.getAttribute("src"),contentType:"image"},i=y(t);for(n in i)a=i[n],e[n]=a;return this.appendAttachmentWithAttributes(e,this.getTextAttributes(t)),this.processedElements.push(t);case"tr":if(t.parentNode.firstChild!==t)return this.appendStringWithAttributes("\n");break;case"td":if(t.parentNode.firstChild!==t)return this.appendStringWithAttributes(" | ")}},p.prototype.appendBlockForAttributesWithElement=function(t,e){var n;return this.blockElements.push(e),n=f(t),this.blocks.push(n),n},p.prototype.appendEmptyBlock=function(){return this.appendBlockForAttributesWithElement([],null)},p.prototype.appendStringWithAttributes=function(t,e){return this.appendPiece(A(t,e))},p.prototype.appendAttachmentWithAttributes=function(t,e){return this.appendPiece(b(t,e))},p.prototype.appendPiece=function(t){return 0===this.blocks.length&&this.appendEmptyBlock(),this.blocks[this.blocks.length-1].text.push(t)},p.prototype.appendStringToTextAtIndex=function(t,e){var n,i;return i=this.blocks[e].text,n=i[i.length-1],"string"===(null!=n?n.type:void 0)?n.string+=t:i.push(A(t))},p.prototype.prependStringToTextAtIndex=function(t,e){var n,i;return i=this.blocks[e].text,n=i[0],"string"===(null!=n?n.type:void 0)?n.string=t+n.string:i.unshift(A(t))},p.prototype.getTextAttributes=function(t){var e,n,i,r,a,u,c,l;n={},u=Trix.config.textAttributes;for(e in u)i=u[e],i.parser?(l=i.parser(t))&&(n[e]=l):i.tagName&&s(t)===i.tagName&&(n[e]=!0);if(o(t)&&(r=t.dataset.trixAttributes)){c=JSON.parse(r);for(a in c)l=c[a],n[a]=l}return n},p.prototype.getBlockAttributes=function(t){var e,n,i,o;for(n=[];t&&t!==this.containerElement;){o=Trix.config.blockAttributes;for(e in o)i=o[e],i.parse!==!1&&s(t)===i.tagName&&(("function"==typeof i.test?i.test(t):void 0)||!i.test)&&(n.push(e),i.listAttribute&&n.push(i.listAttribute));t=t.parentNode}return n.reverse()},p.prototype.getMarginOfBlockElementAtIndex=function(t){var e,n;return!(e=this.blockElements[t])||(n=s(e),l.call(this.getBlockTagNames(),n)>=0||l.call(this.processedElements,e)>=0)?void 0:m(e)},p.prototype.getMarginOfDefaultBlockElement=function(){var t;return t=i(Trix.config.blockAttributes["default"].tagName),this.containerElement.appendChild(t),m(t)},p.prototype.translateBlockElementMarginsToNewlines=function(){var t,e,n,i,o,r,s,a;for(e=this.getMarginOfDefaultBlockElement(),s=this.blocks,a=[],i=n=0,o=s.length;o>n;i=++n)t=s[i],(r=this.getMarginOfBlockElementAtIndex(i))&&(r.top>2*e.top&&this.prependStringToTextAtIndex("\n",i),a.push(r.bottom>2*e.bottom?this.appendStringToTextAtIndex("\n",i):void 0));return a},A=function(t,e){var n;return null==e&&(e={}),n="string",{string:t,attributes:e,type:n}},b=function(t,e){var n;return null==e&&(e={}),n="attachment",{attachment:t,attributes:e,type:n}},f=function(t){var e;return null==t&&(t={}),e=[],{text:e,attributes:t}},g=function(t){return JSON.parse(t.dataset.trixAttachment)},T=function(t){var e,n,i,o,r,s,u,c,p,f,g,m,y,v,b,A,T;for(t=x(t),n=document.implementation.createHTMLDocument(""),n.documentElement.innerHTML=t,e=n.body,o=n.head,v=o.querySelectorAll("style"),r=0,c=v.length;c>r;r++)A=v[r],e.appendChild(A);for(y=[],T=a(e);T.nextNode();)switch(m=T.currentNode,m.nodeType){case Node.ELEMENT_NODE:for(i=m,b=h.call(i.attributes),s=0,p=b.length;p>s;s++)g=b[s].name,l.call(d,g)>=0||0===g.indexOf("data-trix")||i.removeAttribute(g);break;case Node.COMMENT_NODE:y.push(m);break;case Node.TEXT_NODE:m.data.match(/^\s*$/)&&m.parentNode===e&&y.push(m)}for(u=0,f=y.length;f>u;u++)m=y[u],m.parentNode.removeChild(m);return e.innerHTML},x=function(t){return t.replace(/>\n+</g,"><").replace(/>\ +</g,"> <")},m=function(t){var e;return e=window.getComputedStyle(t),"block"===e.display?{top:parseInt(e.marginTop),bottom:parseInt(e.marginBottom)}:void 0},y=function(t){var e,n,i;return i=t.getAttribute("width"),n=t.getAttribute("height"),e={},i&&(e.width=parseInt(i,10)),n&&(e.height=parseInt(n,10)),e},p}(Trix.BasicObject)}.call(this),function(){var t,e,n,i=function(t,e){function n(){this.constructor=t}for(var i in e)o.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},o={}.hasOwnProperty,r=[].slice,s=[].indexOf||function(t){for(var e=0,n=this.length;n>e;e++)if(e in this&&this[e]===t)return e;return-1};t=Trix.arraysAreEqual,e=Trix.normalizeRange,n=Trix.rangeIsCollapsed,Trix.Document=function(o){function a(t){null==t&&(t=[]),a.__super__.constructor.apply(this,arguments),0===t.length&&(t=[new Trix.Block]),this.blockList=Trix.SplittableList.box(t)}var u;return i(a,o),a.fromJSON=function(t){var e,n;return n=function(){var n,i,o;for(o=[],n=0,i=t.length;i>n;n++)e=t[n],o.push(Trix.Block.fromJSON(e));return o}(),new this(n)},a.fromHTML=function(t,e){return Trix.HTMLParser.parse(t,e).getDocument()},a.fromString=function(t,e){var n;return n=Trix.Text.textForStringWithAttributes(t,e),new this([new Trix.Block(n)])},a.prototype.isEmpty=function(){var t;return 1===this.blockList.length&&(t=this.getBlockAtIndex(0),t.isEmpty()&&!t.hasAttributes())},a.prototype.copy=function(t){var e;return null==t&&(t={}),e=t.consolidateBlocks?this.blockList.consolidate().toArray():this.blockList.toArray(),new this.constructor(e)},a.prototype.copyUsingObjectsFromDocument=function(t){var e;return e=new Trix.ObjectMap(t.getObjects()),this.copyUsingObjectMap(e)},a.prototype.copyUsingObjectMap=function(t){var e,n,i;return n=function(){var n,o,r,s;for(r=this.getBlocks(),s=[],n=0,o=r.length;o>n;n++)e=r[n],s.push((i=t.find(e))?i:e.copyUsingObjectMap(t));return s}.call(this),new this.constructor(n)},a.prototype.copyWithBaseBlockAttributes=function(t){var e,n,i;return null==t&&(t=[]),i=function(){var i,o,r,s;for(r=this.getBlocks(),s=[],i=0,o=r.length;o>i;i++)n=r[i],e=t.concat(n.getAttributes()),s.push(n.copyWithAttributes(e));return s}.call(this),new this.constructor(i)},a.prototype.insertDocumentAtRange=function(t,i){var o,r,s,a,u,c,l;return r=t.blockList,u=(i=e(i))[0],c=this.locationFromPosition(u),s=c.index,a=c.offset,l=this,o=this.getBlockAtPosition(u),n(i)&&o.isEmpty()&&!o.hasAttributes()?l=new this.constructor(l.blockList.removeObjectAtIndex(s)):o.getBlockBreakPosition()===a&&u++,l=l.removeTextAtRange(i),new this.constructor(l.blockList.insertSplittableListAtPosition(r,u))},a.prototype.mergeDocumentAtRange=function(n,i){var o,r,s,a,u,c,l,h,p,d,f,g;return f=(i=e(i))[0],d=this.locationFromPosition(f),r=this.getBlockAtIndex(d.index).getAttributes(),o=n.getBaseBlockAttributes(),g=r.slice(-o.length),t(o,g)?(l=r.slice(0,-o.length),c=n.copyWithBaseBlockAttributes(l)):c=n.copy({consolidateBlocks:!0}).copyWithBaseBlockAttributes(r),s=c.getBlockCount(),a=c.getBlockAtIndex(0),t(r,a.getAttributes())?(u=a.getTextWithoutBlockBreak(),p=this.insertTextAtRange(u,i),s>1&&(c=new this.constructor(c.getBlocks().slice(1)),h=f+u.getLength(),p=p.insertDocumentAtRange(c,h))):p=this.insertDocumentAtRange(c,i),p},a.prototype.insertTextAtRange=function(t,n){var i,o,r,s,a;return a=(n=e(n))[0],s=this.locationFromPosition(a),o=s.index,r=s.offset,i=this.removeTextAtRange(n),new this.constructor(i.blockList.editObjectAtIndex(o,function(e){return e.copyWithText(e.text.insertTextAtPosition(t,r))}))},a.prototype.removeTextAtRange=function(t){var i,o,r,s,a,u,c,l,h,p,d,f,g,m,y,v,b;return h=t=e(t),y=h[0],s=h[1],n(t)?this:(c=this.locationFromPosition(y),u=c.index,a=this.getBlockAtIndex(u),l=a.text.getTextAtRange([0,c.offset]),g=this.locationFromPosition(s),f=g.index,d=this.getBlockAtIndex(f),m=d.text.getTextAtRange([g.offset,d.getLength()]),v=l.appendText(m),p=u!==f&&0===c.offset,b=p&&a.getAttributeLevel()>=d.getAttributeLevel(),o=b?d.copyWithText(v):a.copyWithText(v),r=this.blockList.toArray(),i=f+1-u,r.splice(u,i,o),new this.constructor(r))},a.prototype.moveTextFromRangeToPosition=function(t,n){var i,o,s,a,u,c,l,h,p,d;if(c=t=e(t),p=c[0],s=c[1],n>=p&&s>=n)return this;if(o=this.getDocumentAtRange(t),h=this.removeTextAtRange(t),u=n>p,u&&(n-=o.getLength()),!h.firstBlockInRangeIsEntirelySelected(t)){if(l=o.getBlocks(),a=l[0],i=2<=l.length?r.call(l,1):[],0===i.length?(d=a.getTextWithoutBlockBreak(),u&&(n+=1)):d=a.text,h=h.insertTextAtRange(d,n),0===i.length)return h;o=new this.constructor(i),n+=d.getLength()}return h.insertDocumentAtRange(o,n)},a.prototype.addAttributeAtRange=function(t,e,n){var i;return i=this.blockList,this.eachBlockAtRange(n,function(n,o,r){return i=i.editObjectAtIndex(r,function(){return Trix.config.blockAttributes[t]?n.addAttribute(t,e):o[0]===o[1]?n:n.copyWithText(n.text.addAttributeAtRange(t,e,o))})}),new this.constructor(i)},a.prototype.addAttribute=function(t,e){var n;return n=this.blockList,this.eachBlock(function(i,o){return n=n.editObjectAtIndex(o,function(){return i.addAttribute(t,e)})}),new this.constructor(n)},a.prototype.removeAttributeAtRange=function(t,e){var n;return n=this.blockList,this.eachBlockAtRange(e,function(e,i,o){return Trix.config.blockAttributes[t]?n=n.editObjectAtIndex(o,function(){return e.removeAttribute(t)}):i[0]!==i[1]?n=n.editObjectAtIndex(o,function(){return e.copyWithText(e.text.removeAttributeAtRange(t,i))}):void 0}),new this.constructor(n)},a.prototype.updateAttributesForAttachment=function(t,e){var n,i,o,r;return o=(i=this.getRangeOfAttachment(e))[0],n=this.locationFromPosition(o).index,r=this.getTextAtIndex(n),new this.constructor(this.blockList.editObjectAtIndex(n,function(n){return n.copyWithText(r.updateAttributesForAttachment(t,e))}))},a.prototype.removeAttributeForAttachment=function(t,e){var n;return n=this.getRangeOfAttachment(e),this.removeAttributeAtRange(t,n)},a.prototype.insertBlockBreakAtRange=function(t){var n,i,o,r;return r=(t=e(t))[0],o=this.locationFromPosition(r).offset,i=this.removeTextAtRange(t),0===o&&(n=[new Trix.Block]),new this.constructor(i.blockList.insertSplittableListAtPosition(new Trix.SplittableList(n),r))},a.prototype.applyBlockAttributeAtRange=function(t,e,n){var i,o,r;return o=this.expandRangeToLineBreaksAndSplitBlocks(n),i=o.document,n=o.range,Trix.config.blockAttributes[t].listAttribute?(i=i.removeLastListAttributeAtRange(n,{exceptAttributeName:t}),r=i.convertLineBreaksToBlockBreaksInRange(n),i=r.document,n=r.range):i=i.consolidateBlocksAtRange(n),i.addAttributeAtRange(t,e,n)},a.prototype.removeLastListAttributeAtRange=function(t,e){var n;return null==e&&(e={}),n=this.blockList,this.eachBlockAtRange(t,function(t,i,o){var r;if((r=t.getLastAttribute())&&Trix.config.blockAttributes[r].listAttribute&&r!==e.exceptAttributeName)return n=n.editObjectAtIndex(o,function(){return t.removeAttribute(r)})}),new this.constructor(n)},a.prototype.firstBlockInRangeIsEntirelySelected=function(t){var n,i,o,r,s,a;return r=t=e(t),a=r[0],n=r[1],i=this.locationFromPosition(a),s=this.locationFromPosition(n),0===i.offset&&i.index<s.index?!0:i.index===s.index?(o=this.getBlockAtIndex(i.index).getLength(),0===i.offset&&s.offset===o):!1},a.prototype.expandRangeToLineBreaksAndSplitBlocks=function(t){var n,i,o,r,s,a,u,c,l;return a=t=e(t),l=a[0],r=a[1],c=this.locationFromPosition(l),o=this.locationFromPosition(r),n=this,u=n.getBlockAtIndex(c.index),null!=(c.offset=u.findLineBreakInDirectionFromPosition("backward",c.offset))&&(s=n.positionFromLocation(c),n=n.insertBlockBreakAtRange([s,s+1]),o.index+=1,o.offset-=n.getBlockAtIndex(c.index).getLength(),c.index+=1),c.offset=0,0===o.offset&&o.index>c.index?(o.index-=1,o.offset=n.getBlockAtIndex(o.index).getBlockBreakPosition()):(i=n.getBlockAtIndex(o.index),"\n"===i.text.getStringAtRange([o.offset-1,o.offset])?o.offset-=1:o.offset=i.findLineBreakInDirectionFromPosition("forward",o.offset),o.offset!==i.getBlockBreakPosition()&&(s=n.positionFromLocation(o),n=n.insertBlockBreakAtRange([s,s+1]))),l=n.positionFromLocation(c),r=n.positionFromLocation(o),t=e([l,r]),{document:n,range:t}},a.prototype.convertLineBreaksToBlockBreaksInRange=function(t){var n,i,o;return i=(t=e(t))[0],o=this.getStringAtRange(t).slice(0,-1),n=this,o.replace(/.*?\n/g,function(t){return i+=t.length,n=n.insertBlockBreakAtRange([i-1,i])}),{document:n,range:t}},a.prototype.consolidateBlocksAtRange=function(t){var n,i,o,r,s;return o=t=e(t),s=o[0],i=o[1],r=this.locationFromPosition(s).index,n=this.locationFromPosition(i).index,new this.constructor(this.blockList.consolidateFromIndexToIndex(r,n))},a.prototype.getDocumentAtRange=function(t){var n;return t=e(t),n=this.blockList.getSplittableListInRange(t).toArray(),new this.constructor(n)},a.prototype.getStringAtRange=function(t){return this.getDocumentAtRange(t).toString()},a.prototype.getBlockAtIndex=function(t){return this.blockList.getObjectAtIndex(t)},a.prototype.getBlockAtPosition=function(t){var e;return e=this.locationFromPosition(t).index,this.getBlockAtIndex(e)},a.prototype.getTextAtIndex=function(t){var e;return null!=(e=this.getBlockAtIndex(t))?e.text:void 0},a.prototype.getTextAtPosition=function(t){var e;return e=this.locationFromPosition(t).index,this.getTextAtIndex(e)},a.prototype.getPieceAtPosition=function(t){var e,n,i;return i=this.locationFromPosition(t),e=i.index,n=i.offset,this.getTextAtIndex(e).getPieceAtPosition(t)},a.prototype.getCharacterAtPosition=function(t){var e,n,i;return i=this.locationFromPosition(t),e=i.index,n=i.offset,this.getTextAtIndex(e).getStringAtRange([n,n+1])},a.prototype.getLength=function(){return this.blockList.getEndPosition()},a.prototype.getBlocks=function(){return this.blockList.toArray()},a.prototype.getBlockCount=function(){return this.blockList.length},a.prototype.getEditCount=function(){return this.editCount},a.prototype.eachBlock=function(t){return this.blockList.eachObject(t)},a.prototype.eachBlockAtRange=function(t,n){var i,o,r,s,a,u,c,l,h,p,d,f;if(u=t=e(t),d=u[0],r=u[1],p=this.locationFromPosition(d),o=this.locationFromPosition(r),p.index===o.index)return i=this.getBlockAtIndex(p.index),f=[p.offset,o.offset],n(i,f,p.index);for(h=[],a=s=c=p.index,l=o.index;l>=c?l>=s:s>=l;a=l>=c?++s:--s)(i=this.getBlockAtIndex(a))?(f=function(){switch(a){case p.index:return[p.offset,i.text.getLength()];case o.index:return[0,o.offset];default:return[0,i.text.getLength()]}}(),h.push(n(i,f,a))):h.push(void 0);return h},a.prototype.getCommonAttributesAtRange=function(t){var i,o,r;return o=(t=e(t))[0],n(t)?this.getCommonAttributesAtPosition(o):(r=[],i=[],this.eachBlockAtRange(t,function(t,e){return e[0]!==e[1]?(r.push(t.text.getCommonAttributesAtRange(e)),i.push(u(t))):void 0}),Trix.Hash.fromCommonAttributesOfObjects(r).merge(Trix.Hash.fromCommonAttributesOfObjects(i)).toObject())},a.prototype.getCommonAttributesAtPosition=function(t){var e,n,i,o,r,a,c,l,h,p;if(h=this.locationFromPosition(t),r=h.index,l=h.offset,i=this.getBlockAtIndex(r),!i)return{};o=u(i),e=i.text.getAttributesAtPosition(l),n=i.text.getAttributesAtPosition(l-1),a=function(){var t,e;t=Trix.config.textAttributes,e=[];for(c in t)p=t[c],p.inheritable&&e.push(c);return e}();for(c in n)p=n[c],(p===e[c]||s.call(a,c)>=0)&&(o[c]=p);return o},a.prototype.getRangeOfCommonAttributeAtPosition=function(t,n){var i,o,r,s,a,u,c,l,h;return a=this.locationFromPosition(n),r=a.index,s=a.offset,h=this.getTextAtIndex(r),u=h.getExpandedRangeForAttributeAtOffset(t,s),l=u[0],o=u[1],c=this.positionFromLocation({index:r,offset:l}),i=this.positionFromLocation({index:r,offset:o}),e([c,i])},a.prototype.getBaseBlockAttributes=function(){var t,e,n,i,o,r,s;for(t=this.getBlockAtIndex(0).getAttributes(),n=i=1,s=this.getBlockCount();s>=1?s>i:i>s;n=s>=1?++i:--i)e=this.getBlockAtIndex(n).getAttributes(),r=Math.min(t.length,e.length),t=function(){var n,i,s;for(s=[],o=n=0,i=r;(i>=0?i>n:n>i)&&e[o]===t[o];o=i>=0?++n:--n)s.push(e[o]);return s}();return t},u=function(t){var e,n;return n={},(e=t.getLastAttribute())&&(n[e]=!0),n},a.prototype.getAttachmentById=function(t){var e,n,i,o;for(o=this.getAttachments(),n=0,i=o.length;i>n;n++)if(e=o[n],e.id===t)return e},a.prototype.getAttachmentPieces=function(){var t;return t=[],this.blockList.eachObject(function(e){var n;return n=e.text,t=t.concat(n.getAttachmentPieces())}),t},a.prototype.getAttachments=function(){var t,e,n,i,o;for(i=this.getAttachmentPieces(),o=[],t=0,e=i.length;e>t;t++)n=i[t],o.push(n.attachment);return o},a.prototype.getRangeOfAttachment=function(t){var n,i,o,r,s,a,u;for(r=0,s=this.blockList.toArray(),i=n=0,o=s.length;o>n;i=++n){if(a=s[i].text,u=a.getRangeOfAttachment(t))return e([r+u[0],r+u[1]]);r+=a.getLength()}},a.prototype.getAttachmentPieceForAttachment=function(t){var e,n,i,o;for(o=this.getAttachmentPieces(),e=0,n=o.length;n>e;e++)if(i=o[e],i.attachment===t)return i},a.prototype.rangeFromLocationRange=function(t){var i,o;return t=e(t),i=this.positionFromLocation(t[0]),n(t)||(o=this.positionFromLocation(t[1])),[i,null!=o?o:i]},a.prototype.locationFromPosition=function(t){var e,n;return n=this.blockList.findIndexAndOffsetAtPosition(Math.max(0,t)),null!=n.index?n:(e=this.getBlocks(),{index:e.length-1,offset:e[e.length-1].getLength()})
},a.prototype.positionFromLocation=function(t){return this.blockList.findPositionAtIndexAndOffset(t.index,t.offset)},a.prototype.locationRangeFromPosition=function(t){return e(this.locationFromPosition(t))},a.prototype.locationRangeFromRange=function(t){var n,i,o,r;if(t=e(t))return r=t[0],i=t[1],o=this.locationFromPosition(r),n=this.locationFromPosition(i),e([o,n])},a.prototype.rangeFromLocationRange=function(t){var i,o;return t=e(t),i=this.positionFromLocation(t[0]),n(t)||(o=this.positionFromLocation(t[1])),e([i,o])},a.prototype.isEqualTo=function(t){return this.blockList.isEqualTo(null!=t?t.blockList:void 0)},a.prototype.getTexts=function(){var t,e,n,i,o;for(i=this.getBlocks(),o=[],e=0,n=i.length;n>e;e++)t=i[e],o.push(t.text);return o},a.prototype.getPieces=function(){var t,e,n,i,o;for(n=[],i=this.getTexts(),t=0,e=i.length;e>t;t++)o=i[t],n.push.apply(n,o.getPieces());return n},a.prototype.getObjects=function(){return this.getBlocks().concat(this.getTexts()).concat(this.getPieces())},a.prototype.toSerializableDocument=function(){var t;return t=[],this.blockList.eachObject(function(e){return t.push(e.copyWithText(e.text.toSerializableText()))}),new this.constructor(t)},a.prototype.toString=function(){return this.blockList.toString()},a.prototype.toJSON=function(){return this.blockList.toJSON()},a.prototype.toConsole=function(){var t;return JSON.stringify(function(){var e,n,i,o;for(i=this.blockList.toArray(),o=[],e=0,n=i.length;n>e;e++)t=i[e],o.push(JSON.parse(t.text.toConsole()));return o}.call(this))},a}(Trix.Object)}.call(this),function(){var t,e,n,i,o,r=function(t,e){function n(){this.constructor=t}for(var i in e)s.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},s={}.hasOwnProperty;e=Trix.normalizeRange,i=Trix.rangesAreEqual,n=Trix.objectsAreEqual,o=Trix.summarizeArrayChange,t=Trix.extend,Trix.Composition=function(s){function a(){this.document=new Trix.Document,this.attachments=[],this.currentAttributes={},this.revision=0}var u;return r(a,s),a.prototype.setDocument=function(t){var e;return t.isEqualTo(this.document)?void 0:(this.document=t,this.refreshAttachments(),this.revision++,null!=(e=this.delegate)&&"function"==typeof e.compositionDidChangeDocument?e.compositionDidChangeDocument(t):void 0)},a.prototype.getSnapshot=function(){return{document:this.document,selectedRange:this.getSelectedRange()}},a.prototype.loadSnapshot=function(t){var e,n,i,o;return e=t.document,o=t.selectedRange,null!=(n=this.delegate)&&"function"==typeof n.compositionWillLoadSnapshot&&n.compositionWillLoadSnapshot(),this.setDocument(null!=e?e:new Trix.Document),this.setSelection(null!=o?o:[0,0]),null!=(i=this.delegate)&&"function"==typeof i.compositionDidLoadSnapshot?i.compositionDidLoadSnapshot():void 0},a.prototype.insertText=function(t,e){var n,i,o,r;return r=(null!=e?e:{updatePosition:!0}).updatePosition,i=this.getSelectedRange(),this.setDocument(this.document.insertTextAtRange(t,i)),o=i[0],n=o+t.getLength(),r&&this.setSelection(n),this.notifyDelegateOfInsertionAtRange([o,n])},a.prototype.insertBlock=function(t){var e;return null==t&&(t=new Trix.Block),e=new Trix.Document([t]),this.insertDocument(e)},a.prototype.insertDocument=function(t){var e,n,i;return null==t&&(t=new Trix.Document),n=this.getSelectedRange(),this.setDocument(this.document.insertDocumentAtRange(t,n)),i=n[0],e=i+t.getLength(),this.setSelection(e),this.notifyDelegateOfInsertionAtRange([i,e])},a.prototype.insertString=function(t,e){var n,i;return n=this.getCurrentTextAttributes(),i=Trix.Text.textForStringWithAttributes(t,n),this.insertText(i,e)},a.prototype.insertBlockBreak=function(){var t,e,n;return e=this.getSelectedRange(),this.setDocument(this.document.insertBlockBreakAtRange(e)),n=e[0],t=n+1,this.setSelection(t),this.notifyDelegateOfInsertionAtRange([n,t])},a.prototype.breakFormattedBlock=function(){var t,e,n,i,o,r,s,a;return r=this.getPosition(),s=[r-1,r],e=this.document,a=e.locationFromPosition(r),n=a.index,o=a.offset,t=e.getBlockAtIndex(n),t.getBlockBreakPosition()===o?(e=e.removeTextAtRange(s),s=[r,r]):"\n"===t.text.getStringAtRange([o,o+1])?s=[r-1,r+1]:r+=1,i=new Trix.Document([t.removeLastAttribute().copyWithoutText()]),this.setDocument(e.insertDocumentAtRange(i,s)),this.setSelection(r)},a.prototype.insertLineBreak=function(){var t,e,n,i,o,r,s;return o=this.getSelectedRange(),s=o[0],i=o[1],r=this.document.locationFromPosition(s),n=this.document.locationFromPosition(i),t=this.document.getBlockAtIndex(n.index),t.hasAttributes()?t.isListItem()?t.isEmpty()?(this.decreaseListLevel(),this.setSelection(s)):0===r.offset?(e=new Trix.Document([t.copyWithoutText()]),this.insertDocument(e)):this.insertBlockBreak():t.isEmpty()?this.removeLastBlockAttribute():"\n"===t.text.getStringAtRange([n.offset-1,n.offset])?this.breakFormattedBlock():this.insertString("\n"):this.insertString("\n")},a.prototype.insertHTML=function(t){var e,n,i,o,r;return r=this.getPosition(),o=this.document.getLength(),e=Trix.Document.fromHTML(t),this.setDocument(this.document.mergeDocumentAtRange(e,this.getSelectedRange())),n=this.document.getLength(),i=r+(n-o),this.setSelection(i),this.notifyDelegateOfInsertionAtRange([i,i])},a.prototype.replaceHTML=function(t){var e,n;return e=Trix.Document.fromHTML(t).copyUsingObjectsFromDocument(this.document),n=this.getSelectedPointRange(),this.setDocument(e),this.setSelectionPointRange(n)},a.prototype.insertFile=function(t){var e,n;return(null!=(n=this.delegate)?n.compositionShouldAcceptFile(t):void 0)?(e=Trix.Attachment.attachmentForFile(t),this.insertAttachment(e)):void 0},a.prototype.insertAttachment=function(t){var e;return e=Trix.Text.textForAttachmentWithAttributes(t,this.currentAttributes),this.insertText(e)},a.prototype.deleteInDirection=function(t){var e,n,i,o,r,s,a;if(r=this.getSelectedRange(),a=r[0],i=r[1],o=r,n=this.getBlock(),a===i){if(s=this.document.locationFromPosition(a),"backward"===t&&0===s.offset&&this.canDecreaseBlockAttributeLevel()&&(n.isListItem()?this.decreaseListLevel():this.decreaseBlockAttributeLevel(),this.setSelection(a),n.isEmpty()))return;o=this.getExpandedRangeInDirection(t),"backward"===t&&(e=this.getAttachmentAtRange(o))}return e?(this.editAttachment(e),!1):(this.setDocument(this.document.removeTextAtRange(o)),this.setSelection(o[0]),n.isListItem()?!1:void 0)},a.prototype.moveTextFromRange=function(t){var e;return e=this.getSelectedRange()[0],this.setDocument(this.document.moveTextFromRangeToPosition(t,e)),this.setSelection(e)},a.prototype.removeAttachment=function(t){var e;return(e=this.document.getRangeOfAttachment(t))?(this.stopEditingAttachment(),this.setDocument(this.document.removeTextAtRange(e)),this.setSelection(e[0])):void 0},a.prototype.removeLastBlockAttribute=function(){var t,e,n,i;return n=this.getSelectedRange(),i=n[0],e=n[1],t=this.document.getBlockAtPosition(e),this.removeCurrentAttribute(t.getLastAttribute()),this.setSelection(i)},u=" ",a.prototype.insertPlaceholder=function(){return this.placeholderPosition=this.getPosition(),this.insertString(u),u},a.prototype.selectPlaceholder=function(){return null!=this.placeholderPosition?(this.setSelectedRange([this.placeholderPosition,this.placeholderPosition+u.length]),!0):void 0},a.prototype.forgetPlaceholder=function(){return this.placeholderPosition=null},a.prototype.hasCurrentAttribute=function(t){return null!=this.currentAttributes[t]},a.prototype.toggleCurrentAttribute=function(t){var e;return(e=!this.currentAttributes[t])?this.setCurrentAttribute(t,e):this.removeCurrentAttribute(t)},a.prototype.canSetCurrentAttribute=function(t){switch(t){case"href":return!this.selectionContainsAttachmentWithAttribute(t);default:return!0}},a.prototype.setCurrentAttribute=function(t,e){return Trix.config.blockAttributes[t]?this.setBlockAttribute(t,e):(this.setTextAttribute(t,e),this.currentAttributes[t]=e,this.notifyDelegateOfCurrentAttributesChange())},a.prototype.setTextAttribute=function(t,e){var n,i,o,r;if(i=this.getSelectedRange())return o=i[0],n=i[1],o!==n?this.setDocument(this.document.addAttributeAtRange(t,e,i)):"href"===t?(r=Trix.Text.textForStringWithAttributes(e,{href:e}),this.insertText(r)):void 0},a.prototype.setBlockAttribute=function(t,e){var n;if(n=this.getSelectedRange())return this.setDocument(this.document.applyBlockAttributeAtRange(t,e,n)),this.setSelection(n)},a.prototype.removeCurrentAttribute=function(t){return Trix.config.blockAttributes[t]?(this.removeBlockAttribute(t),this.updateCurrentAttributes()):(this.removeTextAttribute(t),delete this.currentAttributes[t],this.notifyDelegateOfCurrentAttributesChange())},a.prototype.removeTextAttribute=function(t){var e;if(e=this.getSelectedRange())return this.setDocument(this.document.removeAttributeAtRange(t,e))},a.prototype.removeBlockAttribute=function(t){var e;if(e=this.getSelectedRange())return this.setDocument(this.document.removeAttributeAtRange(t,e))},a.prototype.increaseBlockAttributeLevel=function(){var t,e;return(t=null!=(e=this.getBlock())?e.getLastAttribute():void 0)?this.setCurrentAttribute(t):void 0},a.prototype.decreaseBlockAttributeLevel=function(){var t,e;return(t=null!=(e=this.getBlock())?e.getLastAttribute():void 0)?this.removeCurrentAttribute(t):void 0},a.prototype.decreaseListLevel=function(){var t,e,n,i,o,r;for(r=this.getSelectedRange()[0],o=this.document.locationFromPosition(r).index,n=o,t=this.getBlock().getAttributeLevel();(e=this.document.getBlockAtIndex(n+1))&&e.isListItem()&&e.getAttributeLevel()>t;)n++;return r=this.document.positionFromLocation({index:o,offset:0}),i=this.document.positionFromLocation({index:n,offset:0}),this.setDocument(this.document.removeLastListAttributeAtRange([r,i]))},a.prototype.canIncreaseBlockAttributeLevel=function(){var t,e,n,i;if(t=this.getBlock())return n=t.getConfig("nestable"),null!=n?n:t.isListItem()&&(i=this.getPreviousBlock())?(e=t.getAttributeLevel(),i.getAttributeAtLevel(e)===t.getAttributeAtLevel(e)):void 0},a.prototype.canDecreaseBlockAttributeLevel=function(){var t;return(null!=(t=this.getBlock())?t.getAttributeLevel():void 0)>0},a.prototype.updateCurrentAttributes=function(){var t,e;return(e=this.getSelectedRange({ignoreLock:!0}))&&(t=this.document.getCommonAttributesAtRange(e),!n(t,this.currentAttributes))?(this.currentAttributes=t,this.notifyDelegateOfCurrentAttributesChange()):void 0},a.prototype.getCurrentAttributes=function(){return t.call({},this.currentAttributes)},a.prototype.getCurrentTextAttributes=function(){var t,e,n,i;t={},n=this.currentAttributes;for(e in n)i=n[e],Trix.config.textAttributes[e]&&(t[e]=i);return t},a.prototype.freezeSelection=function(){return this.setCurrentAttribute("frozen",!0)},a.prototype.thawSelection=function(){return this.removeCurrentAttribute("frozen")},a.prototype.hasFrozenSelection=function(){return this.hasCurrentAttribute("frozen")},a.proxyMethod("getSelectionManager().getSelectedPointRange"),a.proxyMethod("getSelectionManager().setLocationRangeFromPointRange"),a.proxyMethod("getSelectionManager().locationIsCursorTarget"),a.proxyMethod("getSelectionManager().selectionIsExpanded"),a.proxyMethod("delegate?.getSelectionManager"),a.prototype.setSelection=function(t){var e,n;return e=this.document.locationRangeFromRange(t),null!=(n=this.delegate)?n.compositionDidRequestChangingSelection({locationRange:e}):void 0},a.prototype.setSelectionPointRange=function(t){var e;return null!=(e=this.delegate)?e.compositionDidRequestChangingSelection({pointRange:t}):void 0},a.prototype.getSelectedRange=function(){var t;return(t=this.getLocationRange())?this.document.rangeFromLocationRange(t):void 0},a.prototype.setSelectedRange=function(t){var e;return e=this.document.locationRangeFromRange(t),this.getSelectionManager().setLocationRange(e)},a.prototype.getPosition=function(){var t;return(t=this.getLocationRange())?this.document.positionFromLocation(t[0]):void 0},a.prototype.getLocationRange=function(){var t;return null!=(t=this.getSelectionManager().getLocationRange())?t:e({index:0,offset:0})},a.prototype.getExpandedRangeInDirection=function(t){var n,i,o;return i=this.getSelectedRange(),o=i[0],n=i[1],"backward"===t?o=this.translateUTF16PositionFromOffset(o,-1):n=this.translateUTF16PositionFromOffset(n,1),e([o,n])},a.prototype.moveCursorInDirection=function(t){var e,n,o,r;return this.editingAttachment?o=this.document.getRangeOfAttachment(this.editingAttachment):(r=this.getSelectedRange(),o=this.getExpandedRangeInDirection(t),n=!i(r,o)),this.setSelectedRange("backward"===t?o[0]:o[1]),n&&(e=this.getAttachmentAtRange(o))?this.editAttachment(e):void 0},a.prototype.expandSelectionInDirection=function(t){var e;return e=this.getExpandedRangeInDirection(t),this.setSelectedRange(e)},a.prototype.expandSelectionForEditing=function(){return this.hasCurrentAttribute("href")?this.expandSelectionAroundCommonAttribute("href"):void 0},a.prototype.expandSelectionAroundCommonAttribute=function(t){var e,n;return e=this.getPosition(),n=this.document.getRangeOfCommonAttributeAtPosition(t,e),this.setSelectedRange(n)},a.prototype.selectionContainsAttachmentWithAttribute=function(t){var e,n,i,o,r;if(r=this.getSelectedRange()){for(o=this.document.getDocumentAtRange(r).getAttachments(),n=0,i=o.length;i>n;n++)if(e=o[n],e.hasAttribute(t))return!0;return!1}},a.prototype.selectionIsInCursorTarget=function(){return this.editingAttachment||this.positionIsCursorTarget(this.getPosition())},a.prototype.positionIsCursorTarget=function(t){var e;return(e=this.document.locationFromPosition(t))?this.locationIsCursorTarget(e):void 0},a.prototype.getSelectedDocument=function(){var t;return(t=this.getSelectedRange())?this.document.getDocumentAtRange(t):void 0},a.prototype.getAttachments=function(){return this.attachments.slice(0)},a.prototype.refreshAttachments=function(){var t,e,n,i,r,s,a,u,c,l,h;for(n=this.document.getAttachments(),u=o(this.attachments,n),t=u.added,h=u.removed,i=0,s=h.length;s>i;i++)e=h[i],e.delegate=null,null!=(c=this.delegate)&&"function"==typeof c.compositionDidRemoveAttachment&&c.compositionDidRemoveAttachment(e);for(r=0,a=t.length;a>r;r++)e=t[r],e.delegate=this,null!=(l=this.delegate)&&"function"==typeof l.compositionDidAddAttachment&&l.compositionDidAddAttachment(e);return this.attachments=n},a.prototype.attachmentDidChangeAttributes=function(t){var e;return this.revision++,null!=(e=this.delegate)&&"function"==typeof e.compositionDidEditAttachment?e.compositionDidEditAttachment(t):void 0},a.prototype.editAttachment=function(t){var e;if(t!==this.editingAttachment)return this.stopEditingAttachment(),this.editingAttachment=t,null!=(e=this.delegate)&&"function"==typeof e.compositionDidStartEditingAttachment?e.compositionDidStartEditingAttachment(this.editingAttachment):void 0},a.prototype.stopEditingAttachment=function(){var t;if(this.editingAttachment)return null!=(t=this.delegate)&&"function"==typeof t.compositionDidStopEditingAttachment&&t.compositionDidStopEditingAttachment(this.editingAttachment),this.editingAttachment=null},a.prototype.canEditAttachmentCaption=function(){var t;return null!=(t=this.editingAttachment)?t.isPreviewable():void 0},a.prototype.updateAttributesForAttachment=function(t,e){return this.setDocument(this.document.updateAttributesForAttachment(t,e))},a.prototype.removeAttributeForAttachment=function(t,e){return this.setDocument(this.document.removeAttributeForAttachment(t,e))},a.prototype.getPreviousBlock=function(){var t,e;return(e=this.getLocationRange())&&(t=e[0].index,t>0)?this.document.getBlockAtIndex(t-1):void 0},a.prototype.getBlock=function(){var t;return(t=this.getLocationRange())?this.document.getBlockAtIndex(t[0].index):void 0},a.prototype.getAttachmentAtRange=function(t){var e;return e=this.document.getDocumentAtRange(t),e.toString()===Trix.OBJECT_REPLACEMENT_CHARACTER+"\n"?e.getAttachments()[0]:void 0},a.prototype.notifyDelegateOfCurrentAttributesChange=function(){var t;return null!=(t=this.delegate)&&"function"==typeof t.compositionDidChangeCurrentAttributes?t.compositionDidChangeCurrentAttributes(this.currentAttributes):void 0},a.prototype.notifyDelegateOfInsertionAtRange=function(t){var e;return null!=(e=this.delegate)&&"function"==typeof e.compositionDidPerformInsertionAtRange?e.compositionDidPerformInsertionAtRange(t):void 0},a.prototype.translateUTF16PositionFromOffset=function(t,e){var n,i;return i=this.document.toUTF16String(),n=i.offsetFromUCS2Offset(t),i.offsetToUCS2Offset(n+e)},a}(Trix.BasicObject)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.UndoManager=function(e){function n(t){this.composition=t,this.undoEntries=[],this.redoEntries=[]}var i;return t(n,e),n.prototype.recordUndoEntry=function(t,e){var n,o,r,s,a;return s=null!=e?e:{},o=s.context,n=s.consolidatable,r=this.undoEntries.slice(-1)[0],n&&i(r,t,o)?void 0:(a=this.createEntry({description:t,context:o}),this.undoEntries.push(a),this.redoEntries=[])},n.prototype.undo=function(){var t,e;return(e=this.undoEntries.pop())?(t=this.createEntry(e),this.redoEntries.push(t),this.composition.loadSnapshot(e.snapshot)):void 0},n.prototype.redo=function(){var t,e;return(t=this.redoEntries.pop())?(e=this.createEntry(t),this.undoEntries.push(e),this.composition.loadSnapshot(t.snapshot)):void 0},n.prototype.canUndo=function(){return this.undoEntries.length>0},n.prototype.canRedo=function(){return this.redoEntries.length>0},n.prototype.createEntry=function(t){var e,n,i;return i=null!=t?t:{},n=i.description,e=i.context,{description:null!=n?n.toString():void 0,context:JSON.stringify(e),snapshot:this.composition.getSnapshot()}},i=function(t,e,n){return(null!=t?t.description:void 0)===(null!=e?e.toString():void 0)&&(null!=t?t.context:void 0)===JSON.stringify(n)},n}(Trix.BasicObject)}.call(this),function(){Trix.Editor=function(){function t(t,e,n){this.composition=t,this.selectionManager=e,this.element=n,this.undoManager=new Trix.UndoManager(this.composition)}return t.prototype.loadDocument=function(t){return this.loadSnapshot({document:t,selectedRange:[0,0]})},t.prototype.loadHTML=function(t){return null==t&&(t=""),this.loadDocument(Trix.Document.fromHTML(t,{referenceElement:this.element}))},t.prototype.loadJSON=function(t){var e,n;return e=t.document,n=t.selectedRange,e=Trix.Document.fromJSON(e),this.loadSnapshot({document:e,selectedRange:n})},t.prototype.loadSnapshot=function(t){return this.undoManager=new Trix.UndoManager(this.composition),this.composition.loadSnapshot(t)},t.prototype.getDocument=function(){return this.composition.document},t.prototype.getSelectedDocument=function(){return this.composition.getSelectedDocument()},t.prototype.getSnapshot=function(){return this.composition.getSnapshot()},t.prototype.toJSON=function(){return this.getSnapshot()},t.prototype.deleteInDirection=function(t){return this.composition.deleteInDirection(t)},t.prototype.insertAttachment=function(t){return this.composition.insertAttachment(t)},t.prototype.insertDocument=function(t){return this.composition.insertDocument(t)},t.prototype.insertFile=function(t){return this.composition.insertFile(t)},t.prototype.insertHTML=function(t){return this.composition.insertHTML(t)},t.prototype.insertString=function(t){return this.composition.insertString(t)},t.prototype.insertText=function(t){return this.composition.insertText(t)},t.prototype.insertLineBreak=function(){return this.composition.insertLineBreak()},t.prototype.getSelectedRange=function(){return this.composition.getSelectedRange()},t.prototype.getPosition=function(){return this.composition.getPosition()},t.prototype.getClientRectAtPosition=function(t){var e;return e=this.getDocument().locationRangeFromRange([t,t+1]),this.selectionManager.getClientRectAtLocationRange(e)},t.prototype.expandSelectionInDirection=function(t){return this.composition.expandSelectionInDirection(t)},t.prototype.moveCursorInDirection=function(t){return this.composition.moveCursorInDirection(t)},t.prototype.setSelectedRange=function(t){return this.composition.setSelectedRange(t)},t.prototype.activateAttribute=function(t,e){return null==e&&(e=!0),this.composition.setCurrentAttribute(t,e)},t.prototype.attributeIsActive=function(t){return this.composition.hasCurrentAttribute(t)},t.prototype.canActivateAttribute=function(t){return this.composition.canSetCurrentAttribute(t)},t.prototype.deactivateAttribute=function(t){return this.composition.removeCurrentAttribute(t)},t.prototype.canDecreaseIndentationLevel=function(){return this.composition.canDecreaseBlockAttributeLevel()},t.prototype.canIncreaseIndentationLevel=function(){return this.composition.canIncreaseBlockAttributeLevel()},t.prototype.decreaseIndentationLevel=function(){return this.canDecreaseIndentationLevel()?this.composition.decreaseBlockAttributeLevel():void 0},t.prototype.increaseIndentationLevel=function(){return this.canIncreaseIndentationLevel()?this.composition.increaseBlockAttributeLevel():void 0},t.prototype.canRedo=function(){return this.undoManager.canRedo()},t.prototype.canUndo=function(){return this.undoManager.canUndo()},t.prototype.recordUndoEntry=function(t,e){var n,i,o;return o=null!=e?e:{},i=o.context,n=o.consolidatable,this.undoManager.recordUndoEntry(t,{context:i,consolidatable:n})},t.prototype.redo=function(){return this.canRedo()?this.undoManager.redo():void 0},t.prototype.undo=function(){return this.canUndo()?this.undoManager.undo():void 0},t}()}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.ManagedAttachment=function(e){function n(t,e){var n;this.attachmentManager=t,this.attachment=e,n=this.attachment,this.id=n.id,this.file=n.file}return t(n,e),n.prototype.remove=function(){return this.attachmentManager.requestRemovalOfAttachment(this.attachment)},n.proxyMethod("attachment.getAttribute"),n.proxyMethod("attachment.hasAttribute"),n.proxyMethod("attachment.setAttribute"),n.proxyMethod("attachment.getAttributes"),n.proxyMethod("attachment.setAttributes"),n.proxyMethod("attachment.isPending"),n.proxyMethod("attachment.isPreviewable"),n.proxyMethod("attachment.getURL"),n.proxyMethod("attachment.getHref"),n.proxyMethod("attachment.getFilename"),n.proxyMethod("attachment.getFilesize"),n.proxyMethod("attachment.getFormattedFilesize"),n.proxyMethod("attachment.getExtension"),n.proxyMethod("attachment.getContentType"),n.proxyMethod("attachment.getFile"),n.proxyMethod("attachment.setFile"),n.proxyMethod("attachment.releaseFile"),n.proxyMethod("attachment.getUploadProgress"),n.proxyMethod("attachment.setUploadProgress"),n}(Trix.BasicObject)}.call(this),function(){var t=function(t,n){function i(){this.constructor=t}for(var o in n)e.call(n,o)&&(t[o]=n[o]);return i.prototype=n.prototype,t.prototype=new i,t.__super__=n.prototype,t},e={}.hasOwnProperty;Trix.AttachmentManager=function(e){function n(t){var e,n,i;for(null==t&&(t=[]),this.managedAttachments={},n=0,i=t.length;i>n;n++)e=t[n],this.manageAttachment(e)}return t(n,e),n.prototype.getAttachments=function(){var t,e,n,i;n=this.managedAttachments,i=[];for(e in n)t=n[e],i.push(t);return i},n.prototype.manageAttachment=function(t){var e,n;return null!=(e=this.managedAttachments)[n=t.id]?e[n]:e[n]=new Trix.ManagedAttachment(this,t)},n.prototype.attachmentIsManaged=function(t){return t.id in this.managedAttachments},n.prototype.requestRemovalOfAttachment=function(t){var e;return this.attachmentIsManaged(t)&&null!=(e=this.delegate)&&"function"==typeof e.attachmentManagerDidRequestRemovalOfAttachment?e.attachmentManagerDidRequestRemovalOfAttachment(t):void 0},n.prototype.unmanageAttachment=function(t){var e;return e=this.managedAttachments[t.id],delete this.managedAttachments[t.id],e},n}(Trix.BasicObject)}.call(this),function(){var t,e,n,i,o,r,s,a,u,c,l,h;t=Trix.elementContainsNode,e=Trix.findChildIndexOfNode,n=Trix.findClosestElementFromNode,i=Trix.findNodeFromContainerAndOffset,s=Trix.nodeIsBlockStartComment,r=Trix.nodeIsBlockContainer,a=Trix.nodeIsCursorTarget,u=Trix.nodeIsEmptyTextNode,c=Trix.nodeIsTextNode,o=Trix.nodeIsAttachmentElement,l=Trix.tagName,h=Trix.walkTree,Trix.LocationMapper=function(){function n(t){this.element=t}var i,p,d,f;return n.prototype.findLocationFromContainerAndOffset=function(n,i){var o,r,u,l,f,g;for(r=0,u=!1,l={index:0,offset:0},(o=this.findAttachmentElementParentForNode(n))&&(n=o.parentNode,i=e(o)),g=h(this.element,{usingFilter:d});g.nextNode();){if(f=g.currentNode,f===n&&c(n)){a(f)||(l.offset+=i);break}if(f.parentNode===n){if(r++===i)break}else if(!t(n,f)&&r>0)break;s(f)?(u&&l.index++,l.offset=0,u=!0):l.offset+=p(f)}return l},n.prototype.findContainerAndOffsetFromLocation=function(t){var n,i,o,s,a,u;if(0===t.index&&0===t.offset){for(n=this.element,s=0;n.firstChild;)if(n=n.firstChild,r(n)){s=1;break}return[n,s]}if(a=this.findNodeAndOffsetFromLocation(t),i=a[0],o=a[1],i){if(c(i))n=i,u=i.textContent,s=t.offset-o;else{if(n=i.parentNode,!r(n))for(;i===n.lastChild&&(i=n,n=n.parentNode,!r(n)););s=e(i),0!==t.offset&&s++}return[n,s]}},n.prototype.findNodeAndOffsetFromLocation=function(t){var e,n,i,o,r,s,u,l;for(u=0,l=this.getSignificantNodesForIndex(t.index),n=0,i=l.length;i>n;n++){if(e=l[n],o=p(e),t.offset<=u+o)if(c(e)){if(r=e,s=u,t.offset===s&&a(r))break}else r||(r=e,s=u);if(u+=o,u>t.offset)break}return[r,s]},n.prototype.findAttachmentElementParentForNode=function(t){for(;t&&t!==this.element;){if(o(t))return t;t=t.parentNode}},n.prototype.getSignificantNodesForIndex=function(t){var e,n,o,r,a;for(o=[],a=h(this.element,{usingFilter:i}),r=!1;a.nextNode();)if(n=a.currentNode,s(n)){if("undefined"!=typeof e&&null!==e?e++:e=0,e===t)r=!0;else if(r)break}else r&&o.push(n);return o},p=function(t){var e;return t.nodeType===Node.TEXT_NODE?a(t)?0:(e=t.textContent,e.length):"br"===l(t)||o(t)?1:0},i=function(t){return f(t)===NodeFilter.FILTER_ACCEPT?d(t):NodeFilter.FILTER_REJECT},f=function(t){return u(t)?NodeFilter.FILTER_REJECT:NodeFilter.FILTER_ACCEPT},d=function(t){return o(t.parentNode)?NodeFilter.FILTER_REJECT:NodeFilter.FILTER_ACCEPT},n}()}.call(this),function(){var t=function(t,e){return function(){return t.apply(e,arguments)}},e=function(t,e){function i(){this.constructor=t}for(var o in e)n.call(e,o)&&(t[o]=e[o]);return i.prototype=e.prototype,t.prototype=new i,t.__super__=e.prototype,t},n={}.hasOwnProperty,i=[].indexOf||function(t){for(var e=0,n=this.length;n>e;e++)if(e in this&&this[e]===t)return e;return-1};Trix.SelectionChangeObserver=function(n){function o(){this.run=t(this.run,this),this.update=t(this.update,this),this.selectionManagers=[]}var r,s;return e(o,n),o.prototype.start=function(){return this.started?void 0:(this.started=!0,"onselectionchange"in document?document.addEventListener("selectionchange",this.update,!0):this.run())},o.prototype.stop=function(){return this.started?(this.started=!1,document.removeEventListener("selectionchange",this.update,!0)):void 0},o.prototype.registerSelectionManager=function(t){return i.call(this.selectionManagers,t)<0?(this.selectionManagers.push(t),this.start()):void 0},o.prototype.unregisterSelectionManager=function(t){var e;return this.selectionManagers=function(){var n,i,o,r;for(o=this.selectionManagers,r=[],n=0,i=o.length;i>n;n++)e=o[n],e!==t&&r.push(e);return r}.call(this),0===this.selectionManagers.length?this.stop():void 0},o.prototype.notifySelectionManagersOfSelectionChange=function(){var t,e,n,i,o;for(n=this.selectionManagers,i=[],t=0,e=n.length;e>t;t++)o=n[t],i.push(o.selectionDidChange());return i},o.prototype.update=function(){var t;return t=s(),r(t,this.domRange)?void 0:(this.domRange=t,this.notifySelectionManagersOfSelectionChange())},o.prototype.reset=function(){return this.domRange=null,this.update()},o.prototype.run=function(){return this.started?(this.update(),requestAnimationFrame(this.run)):void 0},s=function(){var t;return t=window.getSelection(),t.rangeCount>0?t.getRangeAt(0):void 0},r=function(t,e){return(null!=t?t.startContainer:void 0)===(null!=e?e.startContainer:void 0)&&(null!=t?t.startOffset:void 0)===(null!=e?e.startOffset:void 0)&&(null!=t?t.endContainer:void 0)===(null!=e?e.endContainer:void 0)&&(null!=t?t.endOffset:void 0)===(null!=e?e.endOffset:void 0)},o}(Trix.BasicObject),null==Trix.selectionChangeObserver&&(Trix.selectionChangeObserver=new Trix.SelectionChangeObserver)}.call(this),function(){var t,e,n,i,o,r,s,a,u,c,l=function(t,e){return function(){return t.apply(e,arguments)}},h=function(t,e){function n(){this.constructor=t}for(var i in e)p.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},p={}.hasOwnProperty,d=[].slice;t=Trix.defer,e=Trix.elementContainsNode,s=Trix.nodeIsCursorTarget,o=Trix.innerElementIsActive,r=Trix.makeElement,n=Trix.handleEvent,i=Trix.handleEventOnce,a=Trix.normalizeRange,u=Trix.rangeIsCollapsed,c=Trix.rangesAreEqual,Trix.SelectionManager=function(t){function i(t){this.element=t,this.selectionDidChange=l(this.selectionDidChange,this),this.didMouseDown=l(this.didMouseDown,this),this.locationMapper=new Trix.LocationMapper(this.element),this.lockCount=0,n("mousedown",{onElement:this.element,withCallback:this.didMouseDown})}var p,f,g,m,y,v,b;return h(i,t),i.prototype.getLocationRange=function(t){var e,n;return null==t&&(t={}),e=t.ignoreLock?this.currentLocationRange:null!=(n=this.lockedLocationRange)?n:this.currentLocationRange},i.prototype.setLocationRange=function(t){var e;if(!this.lockedLocationRange)return t=a(t),(e=this.createDOMRangeFromLocationRange(t))?(b(e),this.updateCurrentLocationRange(t)):void 0},i.prototype.getSelectedPointRange=function(){var t;return null!=(t=v())?t:g()},i.prototype.setLocationRangeFromPointRange=function(t){var e,n,i,o;return t=a(t),o=null!=(n=this.getLocationRangeAtPoint(t[0]))?n[0]:void 0,e=null!=(i=this.getLocationRangeAtPoint(t[1]))?i[0]:void 0,this.setLocationRange([o,e])},i.prototype.getClientRectAtLocationRange=function(t){var e,n;return(e=this.createDOMRangeFromLocationRange(t))?(n=d.call(e.getClientRects()),n.slice(-1)[0]):void 0},i.prototype.locationIsCursorTarget=function(t){var e,n,i;return i=this.findNodeAndOffsetFromLocation(t),e=i[0],n=i[1],s(e)},i.prototype.lock=function(){return 0===this.lockCount++?(this.updateCurrentLocationRange(),this.lockedLocationRange=this.getLocationRange()):void 0},i.prototype.unlock=function(){var t;return 0===--this.lockCount&&(t=this.lockedLocationRange,this.lockedLocationRange=null,null!=t)?this.setLocationRange(t):void 0},i.prototype.clearSelection=function(){var t;return null!=(t=y())?t.removeAllRanges():void 0},i.prototype.selectionIsCollapsed=function(){var t;return(null!=(t=m())?t.collapsed:void 0)===!0},i.prototype.selectionIsExpanded=function(){return!this.selectionIsCollapsed()},i.proxyMethod("locationMapper.findLocationFromContainerAndOffset"),i.proxyMethod("locationMapper.findContainerAndOffsetFromLocation"),i.proxyMethod("locationMapper.findNodeAndOffsetFromLocation"),i.prototype.didMouseDown=function(){return this.pauseTemporarily()},i.prototype.pauseTemporarily=function(){var t,i,o,r;return this.paused=!0,i=function(t){return function(){var n,i,s;for(t.paused=!1,clearTimeout(r),i=0,s=o.length;s>i;i++)n=o[i],n.destroy();return e(document,t.element)?t.selectionDidChange():void 0}}(this),r=setTimeout(i,200),o=function(){var e,o,r,s;for(r=["mousemove","keydown"],s=[],e=0,o=r.length;o>e;e++)t=r[e],s.push(n(t,{onElement:document,withCallback:i}));return s}()},i.prototype.selectionDidChange=function(){return this.paused||o(this.element)?void 0:this.updateCurrentLocationRange()},i.prototype.updateCurrentLocationRange=function(t){var e,n;return null==t&&(t=this.createLocationRangeFromDOMRange(m())),c(t,this.currentLocationRange)?void 0:(this.currentLocationRange=t,null!=(e=this.delegate)&&"function"==typeof e.locationRangeDidChange?e.locationRangeDidChange(null!=(n=this.currentLocationRange)?n.slice(0):void 0):void 0)},i.prototype.createDOMRangeFromLocationRange=function(t){var e,n,i,o;return i=this.findContainerAndOffsetFromLocation(t[0]),n=u(t)?i:null!=(o=this.findContainerAndOffsetFromLocation(t[1]))?o:i,null!=i&&null!=n?(e=document.createRange(),e.setStart.apply(e,i),e.setEnd.apply(e,n),e):void 0},i.prototype.createLocationRangeFromDOMRange=function(t){var e,n;if(null!=t&&this.domRangeWithinElement(t)&&(n=this.findLocationFromContainerAndOffset(t.startContainer,t.startOffset)))return t.collapsed||(e=this.findLocationFromContainerAndOffset(t.endContainer,t.endOffset)),a([n,e])},i.prototype.domRangeWithinElement=function(t){return t.collapsed?e(this.element,t.startContainer):e(this.element,t.startContainer)&&e(this.element,t.endContainer)},i.prototype.getLocationRangeAtPoint=function(t){var e,n,i,o,r,s,a,u;if(a=t.x,u=t.y,document.caretPositionFromPoint)r=document.caretPositionFromPoint(a,u),i=r.offsetNode,n=r.offset,e=document.createRange(),e.setStart(i,n);
else if(document.caretRangeFromPoint)e=document.caretRangeFromPoint(a,u);else if(document.body.createTextRange){o=m();try{s=document.body.createTextRange(),s.moveToPoint(a,u),s.select()}catch(c){}e=m(),b(o)}return this.createLocationRangeFromDOMRange(e)},p=r({tagName:"span",style:{marginLeft:"-0.01em"},data:{trixMutable:!0,trixSerialize:!1}}),g=function(){var t,e,n,i;if(t=m()){e=p.cloneNode(!0);try{t.insertNode(e),n=e.getBoundingClientRect()}finally{e.parentNode.removeChild(e)}return i={x:n.left,y:n.top+1},a(i)}},v=function(){var t,e,n,i,o,r;if(t=m())return i=t.getClientRects(),i.length>0?(r=i[0],n=i[i.length-1],o={x:r.left,y:r.top+1},e={x:n.right,y:n.top+1},a(o,e)):void 0},y=function(){var t;return t=window.getSelection(),t.rangeCount>0?t:void 0},m=function(){var t;return null!=(t=y())?t.getRangeAt(0):void 0},b=function(t){var e;return e=window.getSelection(),e.removeAllRanges(),e.addRange(t),Trix.selectionChangeObserver.update()},f=function(){var t,e;return t=null!=(e=m())?e.getClientRects():void 0,(null!=t?t.length:void 0)?t:void 0},i}(Trix.BasicObject)}.call(this),function(){var t,e,n,i=function(t,e){function n(){this.constructor=t}for(var i in e)o.call(e,i)&&(t[i]=e[i]);return n.prototype=e.prototype,t.prototype=new n,t.__super__=e.prototype,t},o={}.hasOwnProperty,r=[].slice;e=Trix.rangeIsCollapsed,n=Trix.rangesAreEqual,t=Trix.objectsAreEqual,Trix.EditorController=function(o){function s(t){var e,n;this.editorElement=t.editorElement,e=t.document,n=t.html,this.selectionManager=new Trix.SelectionManager(this.editorElement),this.selectionManager.delegate=this,this.composition=new Trix.Composition,this.composition.delegate=this,this.attachmentManager=new Trix.AttachmentManager(this.composition.getAttachments()),this.attachmentManager.delegate=this,this.inputController=new Trix.InputController(this.editorElement),this.inputController.delegate=this,this.inputController.responder=this.composition,this.compositionController=new Trix.CompositionController(this.editorElement,this.composition),this.compositionController.delegate=this,this.toolbarController=new Trix.ToolbarController(this.editorElement.toolbarElement),this.toolbarController.delegate=this,this.editor=new Trix.Editor(this.composition,this.selectionManager,this.editorElement),null!=e?this.editor.loadDocument(e):this.editor.loadHTML(n)}return i(s,o),s.prototype.registerSelectionManager=function(){return Trix.selectionChangeObserver.registerSelectionManager(this.selectionManager)},s.prototype.unregisterSelectionManager=function(){return Trix.selectionChangeObserver.unregisterSelectionManager(this.selectionManager)},s.prototype.compositionDidChangeDocument=function(){return this.editorElement.notify("document-change"),this.handlingInput?void 0:this.render()},s.prototype.compositionDidChangeCurrentAttributes=function(t){return this.currentAttributes=t,this.toolbarController.updateAttributes(this.currentAttributes),this.updateCurrentActions(),this.editorElement.notify("attributes-change",{attributes:this.currentAttributes})},s.prototype.compositionDidPerformInsertionAtRange=function(t){return this.pasting?this.pastedRange=t:void 0},s.prototype.compositionShouldAcceptFile=function(t){return this.editorElement.notify("file-accept",{file:t})},s.prototype.compositionDidAddAttachment=function(t){var e;return e=this.attachmentManager.manageAttachment(t),this.editorElement.notify("attachment-add",{attachment:e})},s.prototype.compositionDidEditAttachment=function(t){var e;return this.compositionController.rerenderViewForObject(t),e=this.attachmentManager.manageAttachment(t),this.editorElement.notify("attachment-edit",{attachment:e}),this.editorElement.notify("change")},s.prototype.compositionDidRemoveAttachment=function(t){var e;return e=this.attachmentManager.unmanageAttachment(t),this.editorElement.notify("attachment-remove",{attachment:e})},s.prototype.compositionDidStartEditingAttachment=function(t){var e,n;return n=this.composition.document,e=n.getRangeOfAttachment(t),this.attachmentLocationRange=n.locationRangeFromRange(e),this.compositionController.installAttachmentEditorForAttachment(t),this.selectionManager.setLocationRange(this.attachmentLocationRange)},s.prototype.compositionDidStopEditingAttachment=function(){return this.compositionController.uninstallAttachmentEditor(),this.attachmentLocationRange=null},s.prototype.compositionDidRequestChangingSelection=function(t){return!this.loadingSnapshot||this.isFocused()?(this.requestedSelection=t,this.documentWhenSelectionRequested=this.composition.document,this.handlingInput?void 0:this.render()):void 0},s.prototype.compositionWillLoadSnapshot=function(){return this.loadingSnapshot=!0},s.prototype.compositionDidLoadSnapshot=function(){return this.compositionController.refreshViewCache(),this.render(),this.loadingSnapshot=!1},s.prototype.getSelectionManager=function(){return this.selectionManager},s.proxyMethod("getSelectionManager().setLocationRange"),s.proxyMethod("getSelectionManager().getLocationRange"),s.prototype.attachmentManagerDidRequestRemovalOfAttachment=function(t){return this.removeAttachment(t)},s.prototype.compositionControllerWillSyncDocumentView=function(){return this.inputController.editorWillSyncDocumentView(),this.selectionManager.lock(),this.selectionManager.clearSelection()},s.prototype.compositionControllerDidSyncDocumentView=function(){return this.inputController.editorDidSyncDocumentView(),this.selectionManager.unlock(),this.updateCurrentActions(),this.editorElement.notify("sync")},s.prototype.compositionControllerDidRender=function(){var t,e,n;return null!=this.requestedSelection&&(this.documentWhenSelectionRequested.isEqualTo(this.composition.document)&&(n=this.requestedSelection,t=n.locationRange,e=n.pointRange,t?this.selectionManager.setLocationRange(t):e&&this.selectionManager.setLocationRangeFromPointRange(e)),this.composition.updateCurrentAttributes(),this.requestedSelection=null,this.documentWhenSelectionRequested=null),this.editorElement.notify("render")},s.prototype.compositionControllerDidFocus=function(){return this.toolbarController.hideDialog(),this.editorElement.notify("focus")},s.prototype.compositionControllerDidBlur=function(){return this.editorElement.notify("blur")},s.prototype.compositionControllerDidSelectAttachment=function(t){return this.composition.editAttachment(t)},s.prototype.compositionControllerDidRequestDeselectingAttachment=function(){return this.attachmentLocationRange?this.selectionManager.setLocationRange(this.attachmentLocationRange[1]):void 0},s.prototype.compositionControllerWillUpdateAttachment=function(t){return this.editor.recordUndoEntry("Edit Attachment",{context:t.id,consolidatable:!0})},s.prototype.compositionControllerDidRequestRemovalOfAttachment=function(t){return this.removeAttachment(t)},s.prototype.inputControllerWillHandleInput=function(){return this.handlingInput=!0,this.requestedRender=!1},s.prototype.inputControllerDidRequestRender=function(){return this.requestedRender=!0},s.prototype.inputControllerDidHandleInput=function(){return this.handlingInput=!1,this.requestedRender?(this.requestedRender=!1,this.render()):void 0},s.prototype.inputControllerWillPerformTyping=function(){return this.recordTypingUndoEntry()},s.prototype.inputControllerWillCutText=function(){return this.editor.recordUndoEntry("Cut")},s.prototype.inputControllerWillPasteText=function(){return this.editor.recordUndoEntry("Paste"),this.pasting=!0},s.prototype.inputControllerDidPaste=function(t){var e;return e=this.pastedRange,this.pastedRange=null,this.pasting=null,this.editorElement.notify("paste",{pasteData:t,range:e}),this.render()},s.prototype.inputControllerWillMoveText=function(){return this.editor.recordUndoEntry("Move")},s.prototype.inputControllerWillAttachFiles=function(){return this.editor.recordUndoEntry("Drop Files")},s.prototype.inputControllerDidReceiveKeyboardCommand=function(t){return this.toolbarController.applyKeyboardCommand(t)},s.prototype.inputControllerDidStartDrag=function(){return this.locationRangeBeforeDrag=this.selectionManager.getLocationRange()},s.prototype.inputControllerDidReceiveDragOverPoint=function(t){return this.selectionManager.setLocationRangeFromPointRange(t)},s.prototype.inputControllerDidCancelDrag=function(){return this.selectionManager.setLocationRange(this.locationRangeBeforeDrag),this.locationRangeBeforeDrag=null},s.prototype.locationRangeDidChange=function(t){return this.composition.updateCurrentAttributes(),this.updateCurrentActions(),this.attachmentLocationRange&&!n(this.attachmentLocationRange,t)&&this.composition.stopEditingAttachment(),this.editorElement.notify("selection-change")},s.prototype.toolbarDidClickButton=function(){return this.getLocationRange()?void 0:this.setLocationRange({index:0,offset:0})},s.prototype.toolbarDidInvokeAction=function(t){return this.invokeAction(t)},s.prototype.toolbarDidToggleAttribute=function(t){return this.recordFormattingUndoEntry(),this.composition.toggleCurrentAttribute(t),this.render(),this.editorElement.focus()},s.prototype.toolbarDidUpdateAttribute=function(t,e){return this.recordFormattingUndoEntry(),this.composition.setCurrentAttribute(t,e),this.render(),this.editorElement.focus()},s.prototype.toolbarDidRemoveAttribute=function(t){return this.recordFormattingUndoEntry(),this.composition.removeCurrentAttribute(t),this.render(),this.editorElement.focus()},s.prototype.toolbarWillShowDialog=function(){return this.composition.expandSelectionForEditing(),this.freezeSelection()},s.prototype.toolbarDidShowDialog=function(t){return this.editorElement.notify("toolbar-dialog-show",{dialogName:t})},s.prototype.toolbarDidHideDialog=function(t){return this.editorElement.focus(),this.thawSelection(),this.editorElement.notify("toolbar-dialog-hide",{dialogName:t})},s.prototype.freezeSelection=function(){return this.selectionFrozen?void 0:(this.selectionManager.lock(),this.composition.freezeSelection(),this.selectionFrozen=!0,this.render())},s.prototype.thawSelection=function(){return this.selectionFrozen?(this.composition.thawSelection(),this.selectionManager.unlock(),this.selectionFrozen=!1,this.render()):void 0},s.prototype.actions={undo:{test:function(){return this.editor.canUndo()},perform:function(){return this.editor.undo()}},redo:{test:function(){return this.editor.canRedo()},perform:function(){return this.editor.redo()}},link:{test:function(){return this.editor.canActivateAttribute("href")}},increaseBlockLevel:{test:function(){return this.editor.canIncreaseIndentationLevel()},perform:function(){return this.editor.increaseIndentationLevel()&&this.render()}},decreaseBlockLevel:{test:function(){return this.editor.canDecreaseIndentationLevel()},perform:function(){return this.editor.decreaseIndentationLevel()&&this.render()}}},s.prototype.canInvokeAction=function(t){var e,n;return this.actionIsExternal(t)?!0:!!(null!=(e=this.actions[t])&&null!=(n=e.test)?n.call(this):void 0)},s.prototype.invokeAction=function(t){var e,n;return this.actionIsExternal(t)?this.editorElement.notify("action-invoke",{actionName:t}):null!=(e=this.actions[t])&&null!=(n=e.perform)?n.call(this):void 0},s.prototype.actionIsExternal=function(t){return/^x-./.test(t)},s.prototype.getCurrentActions=function(){var t,e;e={};for(t in this.actions)e[t]=this.canInvokeAction(t);return e},s.prototype.updateCurrentActions=function(){var e;return e=this.getCurrentActions(),t(e,this.currentActions)?void 0:(this.currentActions=e,this.toolbarController.updateActions(this.currentActions),this.editorElement.notify("actions-change",{actions:this.currentActions}))},s.prototype.reparse=function(){return this.composition.replaceHTML(this.editorElement.innerHTML)},s.prototype.render=function(){return this.compositionController.render()},s.prototype.removeAttachment=function(t){return this.editor.recordUndoEntry("Delete Attachment"),this.composition.removeAttachment(t),this.render()},s.prototype.recordFormattingUndoEntry=function(){var t;return t=this.selectionManager.getLocationRange(),e(t)?void 0:this.editor.recordUndoEntry("Formatting",{context:this.getUndoContext(),consolidatable:!0})},s.prototype.recordTypingUndoEntry=function(){return this.editor.recordUndoEntry("Typing",{context:this.getUndoContext(this.currentAttributes),consolidatable:!0})},s.prototype.getUndoContext=function(){var t;return t=1<=arguments.length?r.call(arguments,0):[],[this.getLocationContext(),this.getTimeContext()].concat(r.call(t))},s.prototype.getLocationContext=function(){var t;return t=this.selectionManager.getLocationRange(),e(t)?t[0].index:t},s.prototype.getTimeContext=function(){return Trix.config.undoInterval>0?Math.floor((new Date).getTime()/Trix.config.undoInterval):0},s.prototype.isFocused=function(){var t;return this.editorElement===(null!=(t=this.editorElement.ownerDocument)?t.activeElement:void 0)},s}(Trix.Controller)}.call(this),function(){var t,e,n,i,o,r;o=Trix.makeElement,r=Trix.triggerEvent,n=Trix.handleEvent,i=Trix.handleEventOnce,e=Trix.defer,t=Trix.AttachmentView.attachmentSelector,Trix.registerElement("trix-editor",function(){var e,s,a,u,c,l;return u=0,e=function(t){return!document.querySelector(":focus")&&t.hasAttribute("autofocus")&&document.querySelector("[autofocus]")===t?t.focus():void 0},c=function(t){return t.hasAttribute("contenteditable")?void 0:(t.setAttribute("contenteditable",""),i("focus",{onElement:t,withCallback:function(){return s(t)}}))},s=function(t){return a(t),l(t)},a=function(t){return("function"==typeof document.queryCommandSupported?document.queryCommandSupported("enableObjectResizing"):void 0)?(document.execCommand("enableObjectResizing",!1,!1),n("mscontrolselect",{onElement:t,preventDefault:!0})):void 0},l=function(){var t;return("function"==typeof document.queryCommandSupported?document.queryCommandSupported("DefaultParagraphSeparator"):void 0)&&(t=Trix.config.blockAttributes["default"].tagName,"div"===t||"p"===t)?document.execCommand("DefaultParagraphSeparator",!1,t):void 0},{defaultCSS:"%t:empty:not(:focus)::before {\n  content: attr(placeholder);\n  color: graytext;\n}\n\n%t a[contenteditable=false] {\n  cursor: text;\n}\n\n%t img {\n  max-width: 100%;\n  height: auto;\n}\n\n%t "+t+" figcaption textarea {\n  resize: none;\n}\n\n%t "+t+" figcaption textarea.trix-autoresize-clone {\n  position: absolute;\n  left: -9999px;\n  max-height: 0px;\n}",trixId:{get:function(){return this.hasAttribute("trix-id")?this.getAttribute("trix-id"):(this.setAttribute("trix-id",++u),this.trixId)}},toolbarElement:{get:function(){var t,e,n;return this.hasAttribute("toolbar")?null!=(e=this.ownerDocument)?e.getElementById(this.getAttribute("toolbar")):void 0:this.parentElement?(n="trix-toolbar-"+this.trixId,this.setAttribute("toolbar",n),t=o("trix-toolbar",{id:n}),this.parentElement.insertBefore(t,this),t):void 0}},inputElement:{get:function(){var t,e,n;return this.hasAttribute("input")?null!=(n=this.ownerDocument)?n.getElementById(this.getAttribute("input")):void 0:this.parentElement?(e="trix-input-"+this.trixId,this.setAttribute("input",e),t=o("input",{type:"hidden",id:e}),this.parentElement.insertBefore(t,this.nextElementSibling),t):void 0}},editor:{get:function(){var t;return null!=(t=this.editorController)?t.editor:void 0}},name:{get:function(){var t;return null!=(t=this.inputElement)?t.name:void 0}},value:{get:function(){var t;return null!=(t=this.inputElement)?t.value:void 0},set:function(t){var e;return this.defaultValue=t,null!=(e=this.editor)?e.loadHTML(this.defaultValue):void 0}},notify:function(t,e){var n;switch(t){case"document-change":this.documentChangedSinceLastRender=!0;break;case"render":this.documentChangedSinceLastRender&&(this.documentChangedSinceLastRender=!1,this.notify("change"));break;case"change":case"attachment-add":case"attachment-edit":case"attachment-remove":null!=(n=this.inputElement)&&(n.value=Trix.serializeToContentType(this,"text/html"))}return this.editorController?r("trix-"+t,{onElement:this,attributes:e}):void 0},createdCallback:function(){return c(this)},attachedCallback:function(){return this.hasAttribute("data-trix-internal")?void 0:(e(this),null==this.editorController&&(this.editorController=new Trix.EditorController({editorElement:this,html:this.defaultValue=this.value})),this.editorController.registerSelectionManager(),this.registerResetListener(),requestAnimationFrame(function(t){return function(){return t.notify("initialize")}}(this)))},detachedCallback:function(){var t;return null!=(t=this.editorController)&&t.unregisterSelectionManager(),this.unregisterResetListener()},registerResetListener:function(){return this.resetListener=this.resetBubbled.bind(this),window.addEventListener("reset",this.resetListener,!1)},unregisterResetListener:function(){return window.removeEventListener("reset",this.resetListener,!1)},resetBubbled:function(t){var e;return t.target!==(null!=(e=this.inputElement)?e.form:void 0)||t.defaultPrevented?void 0:this.reset()},reset:function(){return this.value=this.defaultValue}}}())}.call(this);
/**
 * State-based routing for AngularJS
 * @version v0.3.2
 * @link http://angular-ui.github.com/
 * @license MIT License, http://www.opensource.org/licenses/MIT
 */
"undefined"!=typeof module&&"undefined"!=typeof exports&&module.exports===exports&&(module.exports="ui.router"),function(a,b,c){"use strict";function d(a,b){return S(new(S(function(){},{prototype:a})),b)}function e(a){return R(arguments,function(b){b!==a&&R(b,function(b,c){a.hasOwnProperty(c)||(a[c]=b)})}),a}function f(a,b){var c=[];for(var d in a.path){if(a.path[d]!==b.path[d])break;c.push(a.path[d])}return c}function g(a){if(Object.keys)return Object.keys(a);var b=[];return R(a,function(a,c){b.push(c)}),b}function h(a,b){if(Array.prototype.indexOf)return a.indexOf(b,Number(arguments[2])||0);var c=a.length>>>0,d=Number(arguments[2])||0;for(d=d<0?Math.ceil(d):Math.floor(d),d<0&&(d+=c);d<c;d++)if(d in a&&a[d]===b)return d;return-1}function i(a,b,c,d){var e,i=f(c,d),j={},k=[];for(var l in i)if(i[l]&&i[l].params&&(e=g(i[l].params),e.length))for(var m in e)h(k,e[m])>=0||(k.push(e[m]),j[e[m]]=a[e[m]]);return S({},j,b)}function j(a,b,c){if(!c){c=[];for(var d in a)c.push(d)}for(var e=0;e<c.length;e++){var f=c[e];if(a[f]!=b[f])return!1}return!0}function k(a,b){var c={};return R(a,function(a){c[a]=b[a]}),c}function l(a){var b={},c=Array.prototype.concat.apply(Array.prototype,Array.prototype.slice.call(arguments,1));return R(c,function(c){c in a&&(b[c]=a[c])}),b}function m(a){var b={},c=Array.prototype.concat.apply(Array.prototype,Array.prototype.slice.call(arguments,1));for(var d in a)h(c,d)==-1&&(b[d]=a[d]);return b}function n(a,b){var c=Q(a),d=c?[]:{};return R(a,function(a,e){b(a,e)&&(d[c?d.length:e]=a)}),d}function o(a,b){var c=Q(a)?[]:{};return R(a,function(a,d){c[d]=b(a,d)}),c}function p(a){return a.then(c,function(){})&&a}function q(a,b){var d=1,f=2,i={},j=[],k=i,l=S(a.when(i),{$$promises:i,$$values:i});this.study=function(i){function n(a,c){if(s[c]!==f){if(r.push(c),s[c]===d)throw r.splice(0,h(r,c)),new Error("Cyclic dependency: "+r.join(" -> "));if(s[c]=d,O(a))q.push(c,[function(){return b.get(a)}],j);else{var e=b.annotate(a);R(e,function(a){a!==c&&i.hasOwnProperty(a)&&n(i[a],a)}),q.push(c,a,e)}r.pop(),s[c]=f}}function o(a){return P(a)&&a.then&&a.$$promises}if(!P(i))throw new Error("'invocables' must be an object");var p=g(i||{}),q=[],r=[],s={};return R(i,n),i=r=s=null,function(d,f,g){function h(){--u||(v||e(t,f.$$values),r.$$values=t,r.$$promises=r.$$promises||!0,delete r.$$inheritedValues,n.resolve(t))}function i(a){r.$$failure=a,n.reject(a)}function j(c,e,f){function j(a){l.reject(a),i(a)}function k(){if(!M(r.$$failure))try{l.resolve(b.invoke(e,g,t)),l.promise.then(function(a){t[c]=a,h()},j)}catch(a){j(a)}}var l=a.defer(),m=0;R(f,function(a){s.hasOwnProperty(a)&&!d.hasOwnProperty(a)&&(m++,s[a].then(function(b){t[a]=b,--m||k()},j))}),m||k(),s[c]=l.promise}if(o(d)&&g===c&&(g=f,f=d,d=null),d){if(!P(d))throw new Error("'locals' must be an object")}else d=k;if(f){if(!o(f))throw new Error("'parent' must be a promise returned by $resolve.resolve()")}else f=l;var n=a.defer(),r=n.promise,s=r.$$promises={},t=S({},d),u=1+q.length/3,v=!1;if(M(f.$$failure))return i(f.$$failure),r;f.$$inheritedValues&&e(t,m(f.$$inheritedValues,p)),S(s,f.$$promises),f.$$values?(v=e(t,m(f.$$values,p)),r.$$inheritedValues=m(f.$$values,p),h()):(f.$$inheritedValues&&(r.$$inheritedValues=m(f.$$inheritedValues,p)),f.then(h,i));for(var w=0,x=q.length;w<x;w+=3)d.hasOwnProperty(q[w])?h():j(q[w],q[w+1],q[w+2]);return r}},this.resolve=function(a,b,c,d){return this.study(a)(b,c,d)}}function r(a,b,c){this.fromConfig=function(a,b,c){return M(a.template)?this.fromString(a.template,b):M(a.templateUrl)?this.fromUrl(a.templateUrl,b):M(a.templateProvider)?this.fromProvider(a.templateProvider,b,c):null},this.fromString=function(a,b){return N(a)?a(b):a},this.fromUrl=function(c,d){return N(c)&&(c=c(d)),null==c?null:a.get(c,{cache:b,headers:{Accept:"text/html"}}).then(function(a){return a.data})},this.fromProvider=function(a,b,d){return c.invoke(a,null,d||{params:b})}}function s(a,b,e){function f(b,c,d,e){if(q.push(b),o[b])return o[b];if(!/^\w+([-.]+\w+)*(?:\[\])?$/.test(b))throw new Error("Invalid parameter name '"+b+"' in pattern '"+a+"'");if(p[b])throw new Error("Duplicate parameter name '"+b+"' in pattern '"+a+"'");return p[b]=new V.Param(b,c,d,e),p[b]}function g(a,b,c,d){var e=["",""],f=a.replace(/[\\\[\]\^$*+?.()|{}]/g,"\\$&");if(!b)return f;switch(c){case!1:e=["(",")"+(d?"?":"")];break;case!0:f=f.replace(/\/$/,""),e=["(?:/(",")|/)?"];break;default:e=["("+c+"|",")?"]}return f+e[0]+b+e[1]}function h(e,f){var g,h,i,j,k;return g=e[2]||e[3],k=b.params[g],i=a.substring(m,e.index),h=f?e[4]:e[4]||("*"==e[1]?".*":null),h&&(j=V.type(h)||d(V.type("string"),{pattern:new RegExp(h,b.caseInsensitive?"i":c)})),{id:g,regexp:h,segment:i,type:j,cfg:k}}b=S({params:{}},P(b)?b:{});var i,j=/([:*])([\w\[\]]+)|\{([\w\[\]]+)(?:\:\s*((?:[^{}\\]+|\\.|\{(?:[^{}\\]+|\\.)*\})+))?\}/g,k=/([:]?)([\w\[\].-]+)|\{([\w\[\].-]+)(?:\:\s*((?:[^{}\\]+|\\.|\{(?:[^{}\\]+|\\.)*\})+))?\}/g,l="^",m=0,n=this.segments=[],o=e?e.params:{},p=this.params=e?e.params.$$new():new V.ParamSet,q=[];this.source=a;for(var r,s,t;(i=j.exec(a))&&(r=h(i,!1),!(r.segment.indexOf("?")>=0));)s=f(r.id,r.type,r.cfg,"path"),l+=g(r.segment,s.type.pattern.source,s.squash,s.isOptional),n.push(r.segment),m=j.lastIndex;t=a.substring(m);var u=t.indexOf("?");if(u>=0){var v=this.sourceSearch=t.substring(u);if(t=t.substring(0,u),this.sourcePath=a.substring(0,m+u),v.length>0)for(m=0;i=k.exec(v);)r=h(i,!0),s=f(r.id,r.type,r.cfg,"search"),m=j.lastIndex}else this.sourcePath=a,this.sourceSearch="";l+=g(t)+(b.strict===!1?"/?":"")+"$",n.push(t),this.regexp=new RegExp(l,b.caseInsensitive?"i":c),this.prefix=n[0],this.$$paramNames=q}function t(a){S(this,a)}function u(){function a(a){return null!=a?a.toString().replace(/(~|\/)/g,function(a){return{"~":"~~","/":"~2F"}[a]}):a}function e(a){return null!=a?a.toString().replace(/(~~|~2F)/g,function(a){return{"~~":"~","~2F":"/"}[a]}):a}function f(){return{strict:p,caseInsensitive:m}}function i(a){return N(a)||Q(a)&&N(a[a.length-1])}function j(){for(;w.length;){var a=w.shift();if(a.pattern)throw new Error("You cannot override a type's .pattern at runtime.");b.extend(r[a.name],l.invoke(a.def))}}function k(a){S(this,a||{})}V=this;var l,m=!1,p=!0,q=!1,r={},v=!0,w=[],x={string:{encode:a,decode:e,is:function(a){return null==a||!M(a)||"string"==typeof a},pattern:/[^\/]*/},int:{encode:a,decode:function(a){return parseInt(a,10)},is:function(a){return M(a)&&this.decode(a.toString())===a},pattern:/\d+/},bool:{encode:function(a){return a?1:0},decode:function(a){return 0!==parseInt(a,10)},is:function(a){return a===!0||a===!1},pattern:/0|1/},date:{encode:function(a){return this.is(a)?[a.getFullYear(),("0"+(a.getMonth()+1)).slice(-2),("0"+a.getDate()).slice(-2)].join("-"):c},decode:function(a){if(this.is(a))return a;var b=this.capture.exec(a);return b?new Date(b[1],b[2]-1,b[3]):c},is:function(a){return a instanceof Date&&!isNaN(a.valueOf())},equals:function(a,b){return this.is(a)&&this.is(b)&&a.toISOString()===b.toISOString()},pattern:/[0-9]{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2][0-9]|3[0-1])/,capture:/([0-9]{4})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])/},json:{encode:b.toJson,decode:b.fromJson,is:b.isObject,equals:b.equals,pattern:/[^\/]*/},any:{encode:b.identity,decode:b.identity,equals:b.equals,pattern:/.*/}};u.$$getDefaultValue=function(a){if(!i(a.value))return a.value;if(!l)throw new Error("Injectable functions cannot be called at configuration time");return l.invoke(a.value)},this.caseInsensitive=function(a){return M(a)&&(m=a),m},this.strictMode=function(a){return M(a)&&(p=a),p},this.defaultSquashPolicy=function(a){if(!M(a))return q;if(a!==!0&&a!==!1&&!O(a))throw new Error("Invalid squash policy: "+a+". Valid policies: false, true, arbitrary-string");return q=a,a},this.compile=function(a,b){return new s(a,S(f(),b))},this.isMatcher=function(a){if(!P(a))return!1;var b=!0;return R(s.prototype,function(c,d){N(c)&&(b=b&&M(a[d])&&N(a[d]))}),b},this.type=function(a,b,c){if(!M(b))return r[a];if(r.hasOwnProperty(a))throw new Error("A type named '"+a+"' has already been defined.");return r[a]=new t(S({name:a},b)),c&&(w.push({name:a,def:c}),v||j()),this},R(x,function(a,b){r[b]=new t(S({name:b},a))}),r=d(r,{}),this.$get=["$injector",function(a){return l=a,v=!1,j(),R(x,function(a,b){r[b]||(r[b]=new t(a))}),this}],this.Param=function(a,d,e,f){function j(a){var b=P(a)?g(a):[],c=h(b,"value")===-1&&h(b,"type")===-1&&h(b,"squash")===-1&&h(b,"array")===-1;return c&&(a={value:a}),a.$$fn=i(a.value)?a.value:function(){return a.value},a}function k(c,d,e){if(c.type&&d)throw new Error("Param '"+a+"' has two type configurations.");return d?d:c.type?b.isString(c.type)?r[c.type]:c.type instanceof t?c.type:new t(c.type):"config"===e?r.any:r.string}function m(){var b={array:"search"===f&&"auto"},c=a.match(/\[\]$/)?{array:!0}:{};return S(b,c,e).array}function p(a,b){var c=a.squash;if(!b||c===!1)return!1;if(!M(c)||null==c)return q;if(c===!0||O(c))return c;throw new Error("Invalid squash policy: '"+c+"'. Valid policies: false, true, or arbitrary string")}function s(a,b,d,e){var f,g,i=[{from:"",to:d||b?c:""},{from:null,to:d||b?c:""}];return f=Q(a.replace)?a.replace:[],O(e)&&f.push({from:e,to:c}),g=o(f,function(a){return a.from}),n(i,function(a){return h(g,a.from)===-1}).concat(f)}function u(){if(!l)throw new Error("Injectable functions cannot be called at configuration time");var a=l.invoke(e.$$fn);if(null!==a&&a!==c&&!x.type.is(a))throw new Error("Default value ("+a+") for parameter '"+x.id+"' is not an instance of Type ("+x.type.name+")");return a}function v(a){function b(a){return function(b){return b.from===a}}function c(a){var c=o(n(x.replace,b(a)),function(a){return a.to});return c.length?c[0]:a}return a=c(a),M(a)?x.type.$normalize(a):u()}function w(){return"{Param:"+a+" "+d+" squash: '"+A+"' optional: "+z+"}"}var x=this;e=j(e),d=k(e,d,f);var y=m();d=y?d.$asArray(y,"search"===f):d,"string"!==d.name||y||"path"!==f||e.value!==c||(e.value="");var z=e.value!==c,A=p(e,z),B=s(e,y,z,A);S(this,{id:a,type:d,location:f,array:y,squash:A,replace:B,isOptional:z,value:v,dynamic:c,config:e,toString:w})},k.prototype={$$new:function(){return d(this,S(new k,{$$parent:this}))},$$keys:function(){for(var a=[],b=[],c=this,d=g(k.prototype);c;)b.push(c),c=c.$$parent;return b.reverse(),R(b,function(b){R(g(b),function(b){h(a,b)===-1&&h(d,b)===-1&&a.push(b)})}),a},$$values:function(a){var b={},c=this;return R(c.$$keys(),function(d){b[d]=c[d].value(a&&a[d])}),b},$$equals:function(a,b){var c=!0,d=this;return R(d.$$keys(),function(e){var f=a&&a[e],g=b&&b[e];d[e].type.equals(f,g)||(c=!1)}),c},$$validates:function(a){var d,e,f,g,h,i=this.$$keys();for(d=0;d<i.length&&(e=this[i[d]],f=a[i[d]],f!==c&&null!==f||!e.isOptional);d++){if(g=e.type.$normalize(f),!e.type.is(g))return!1;if(h=e.type.encode(g),b.isString(h)&&!e.type.pattern.exec(h))return!1}return!0},$$parent:c},this.ParamSet=k}function v(a,d){function e(a){var b=/^\^((?:\\[^a-zA-Z0-9]|[^\\\[\]\^$*+?.()|{}]+)*)/.exec(a.source);return null!=b?b[1].replace(/\\(.)/g,"$1"):""}function f(a,b){return a.replace(/\$(\$|\d{1,2})/,function(a,c){return b["$"===c?0:Number(c)]})}function g(a,b,c){if(!c)return!1;var d=a.invoke(b,b,{$match:c});return!M(d)||d}function h(d,e,f,g,h){function m(a,b,c){return"/"===q?a:b?q.slice(0,-1)+a:c?q.slice(1)+a:a}function n(a){function b(a){var b=a(f,d);return!!b&&(O(b)&&d.replace().url(b),!0)}if(!a||!a.defaultPrevented){p&&d.url()===p;p=c;var e,g=j.length;for(e=0;e<g;e++)if(b(j[e]))return;k&&b(k)}}function o(){return i=i||e.$on("$locationChangeSuccess",n)}var p,q=g.baseHref(),r=d.url();return l||o(),{sync:function(){n()},listen:function(){return o()},update:function(a){return a?void(r=d.url()):void(d.url()!==r&&(d.url(r),d.replace()))},push:function(a,b,e){var f=a.format(b||{});null!==f&&b&&b["#"]&&(f+="#"+b["#"]),d.url(f),p=e&&e.$$avoidResync?d.url():c,e&&e.replace&&d.replace()},href:function(c,e,f){if(!c.validates(e))return null;var g=a.html5Mode();b.isObject(g)&&(g=g.enabled),g=g&&h.history;var i=c.format(e);if(f=f||{},g||null===i||(i="#"+a.hashPrefix()+i),null!==i&&e&&e["#"]&&(i+="#"+e["#"]),i=m(i,g,f.absolute),!f.absolute||!i)return i;var j=!g&&i?"/":"",k=d.port();return k=80===k||443===k?"":":"+k,[d.protocol(),"://",d.host(),k,j,i].join("")}}}var i,j=[],k=null,l=!1;this.rule=function(a){if(!N(a))throw new Error("'rule' must be a function");return j.push(a),this},this.otherwise=function(a){if(O(a)){var b=a;a=function(){return b}}else if(!N(a))throw new Error("'rule' must be a function");return k=a,this},this.when=function(a,b){var c,h=O(b);if(O(a)&&(a=d.compile(a)),!h&&!N(b)&&!Q(b))throw new Error("invalid 'handler' in when()");var i={matcher:function(a,b){return h&&(c=d.compile(b),b=["$match",function(a){return c.format(a)}]),S(function(c,d){return g(c,b,a.exec(d.path(),d.search()))},{prefix:O(a.prefix)?a.prefix:""})},regex:function(a,b){if(a.global||a.sticky)throw new Error("when() RegExp must not be global or sticky");return h&&(c=b,b=["$match",function(a){return f(c,a)}]),S(function(c,d){return g(c,b,a.exec(d.path()))},{prefix:e(a)})}},j={matcher:d.isMatcher(a),regex:a instanceof RegExp};for(var k in j)if(j[k])return this.rule(i[k](a,b));throw new Error("invalid 'what' in when()")},this.deferIntercept=function(a){a===c&&(a=!0),l=a},this.$get=h,h.$inject=["$location","$rootScope","$injector","$browser","$sniffer"]}function w(a,e){function f(a){return 0===a.indexOf(".")||0===a.indexOf("^")}function m(a,b){if(!a)return c;var d=O(a),e=d?a:a.name,g=f(e);if(g){if(!b)throw new Error("No reference point given for path '"+e+"'");b=m(b);for(var h=e.split("."),i=0,j=h.length,k=b;i<j;i++)if(""!==h[i]||0!==i){if("^"!==h[i])break;if(!k.parent)throw new Error("Path '"+e+"' not valid for state '"+b.name+"'");k=k.parent}else k=b;h=h.slice(i).join("."),e=k.name+(k.name&&h?".":"")+h}var l=A[e];return!l||!d&&(d||l!==a&&l.self!==a)?c:l}function n(a,b){B[a]||(B[a]=[]),B[a].push(b)}function q(a){for(var b=B[a]||[];b.length;)r(b.shift())}function r(b){b=d(b,{self:b,resolve:b.resolve||{},toString:function(){return this.name}});var c=b.name;if(!O(c)||c.indexOf("@")>=0)throw new Error("State must have a valid name");if(A.hasOwnProperty(c))throw new Error("State '"+c+"' is already defined");var e=c.indexOf(".")!==-1?c.substring(0,c.lastIndexOf(".")):O(b.parent)?b.parent:P(b.parent)&&O(b.parent.name)?b.parent.name:"";if(e&&!A[e])return n(e,b.self);for(var f in D)N(D[f])&&(b[f]=D[f](b,D.$delegates[f]));return A[c]=b,!b[C]&&b.url&&a.when(b.url,["$match","$stateParams",function(a,c){z.$current.navigable==b&&j(a,c)||z.transitionTo(b,a,{inherit:!0,location:!1})}]),q(c),b}function s(a){return a.indexOf("*")>-1}function t(a){for(var b=a.split("."),c=z.$current.name.split("."),d=0,e=b.length;d<e;d++)"*"===b[d]&&(c[d]="*");return"**"===b[0]&&(c=c.slice(h(c,b[1])),c.unshift("**")),"**"===b[b.length-1]&&(c.splice(h(c,b[b.length-2])+1,Number.MAX_VALUE),c.push("**")),b.length==c.length&&c.join("")===b.join("")}function u(a,b){return O(a)&&!M(b)?D[a]:N(b)&&O(a)?(D[a]&&!D.$delegates[a]&&(D.$delegates[a]=D[a]),D[a]=b,this):this}function v(a,b){return P(a)?b=a:b.name=a,r(b),this}function w(a,e,f,h,l,n,q,r,u){function v(b,c,d,f){var g=a.$broadcast("$stateNotFound",b,c,d);if(g.defaultPrevented)return q.update(),F;if(!g.retry)return null;if(f.$retry)return q.update(),G;var h=z.transition=e.when(g.retry);return h.then(function(){return h!==z.transition?(a.$broadcast("$stateChangeCancel",b.to,b.toParams,c,d),D):(b.options.$retry=!0,z.transitionTo(b.to,b.toParams,b.options))},function(){return F}),q.update(),h}function w(a,c,d,g,i,j){function m(){var c=[];return R(a.views,function(d,e){var g=d.resolve&&d.resolve!==a.resolve?d.resolve:{};g.$template=[function(){return f.load(e,{view:d,locals:i.globals,params:n,notify:j.notify})||""}],c.push(l.resolve(g,i.globals,i.resolve,a).then(function(c){if(N(d.controllerProvider)||Q(d.controllerProvider)){var f=b.extend({},g,i.globals);c.$$controller=h.invoke(d.controllerProvider,null,f)}else c.$$controller=d.controller;c.$$state=a,c.$$controllerAs=d.controllerAs,c.$$resolveAs=d.resolveAs,i[e]=c}))}),e.all(c).then(function(){return i.globals})}var n=d?c:k(a.params.$$keys(),c),o={$stateParams:n};i.resolve=l.resolve(a.resolve,o,i.resolve,a);var p=[i.resolve.then(function(a){i.globals=a})];return g&&p.push(g),e.all(p).then(m).then(function(a){return i})}var B=new Error("transition superseded"),D=p(e.reject(B)),E=p(e.reject(new Error("transition prevented"))),F=p(e.reject(new Error("transition aborted"))),G=p(e.reject(new Error("transition failed")));return y.locals={resolve:null,globals:{$stateParams:{}}},z={params:{},current:y.self,$current:y,transition:null},z.reload=function(a){return z.transitionTo(z.current,n,{reload:a||!0,inherit:!1,notify:!0})},z.go=function(a,b,c){return z.transitionTo(a,b,S({inherit:!0,relative:z.$current},c))},z.transitionTo=function(b,c,f){c=c||{},f=S({location:!0,inherit:!1,relative:null,notify:!0,reload:!1,$retry:!1},f||{});var g,j=z.$current,l=z.params,o=j.path,p=m(b,f.relative),r=c["#"];if(!M(p)){var s={to:b,toParams:c,options:f},t=v(s,j.self,l,f);if(t)return t;if(b=s.to,c=s.toParams,f=s.options,p=m(b,f.relative),!M(p)){if(!f.relative)throw new Error("No such state '"+b+"'");throw new Error("Could not resolve '"+b+"' from state '"+f.relative+"'")}}if(p[C])throw new Error("Cannot transition to abstract state '"+b+"'");if(f.inherit&&(c=i(n,c||{},z.$current,p)),!p.params.$$validates(c))return G;c=p.params.$$values(c),b=p;var u=b.path,A=0,F=u[A],H=y.locals,I=[];if(f.reload){if(O(f.reload)||P(f.reload)){if(P(f.reload)&&!f.reload.name)throw new Error("Invalid reload state object");var J=f.reload===!0?o[0]:m(f.reload);if(f.reload&&!J)throw new Error("No such reload state '"+(O(f.reload)?f.reload:f.reload.name)+"'");for(;F&&F===o[A]&&F!==J;)H=I[A]=F.locals,A++,F=u[A]}}else for(;F&&F===o[A]&&F.ownParams.$$equals(c,l);)H=I[A]=F.locals,A++,F=u[A];if(x(b,c,j,l,H,f))return r&&(c["#"]=r),z.params=c,T(z.params,n),T(k(b.params.$$keys(),n),b.locals.globals.$stateParams),f.location&&b.navigable&&b.navigable.url&&(q.push(b.navigable.url,c,{$$avoidResync:!0,replace:"replace"===f.location}),q.update(!0)),z.transition=null,e.when(z.current);if(c=k(b.params.$$keys(),c||{}),r&&(c["#"]=r),f.notify&&a.$broadcast("$stateChangeStart",b.self,c,j.self,l,f).defaultPrevented)return a.$broadcast("$stateChangeCancel",b.self,c,j.self,l),null==z.transition&&q.update(),E;for(var K=e.when(H),L=A;L<u.length;L++,F=u[L])H=I[L]=d(H),K=w(F,c,F===b,K,H,f);var N=z.transition=K.then(function(){var d,e,g;if(z.transition!==N)return a.$broadcast("$stateChangeCancel",b.self,c,j.self,l),D;for(d=o.length-1;d>=A;d--)g=o[d],g.self.onExit&&h.invoke(g.self.onExit,g.self,g.locals.globals),g.locals=null;for(d=A;d<u.length;d++)e=u[d],e.locals=I[d],e.self.onEnter&&h.invoke(e.self.onEnter,e.self,e.locals.globals);return z.transition!==N?(a.$broadcast("$stateChangeCancel",b.self,c,j.self,l),D):(z.$current=b,z.current=b.self,z.params=c,T(z.params,n),z.transition=null,f.location&&b.navigable&&q.push(b.navigable.url,b.navigable.locals.globals.$stateParams,{$$avoidResync:!0,replace:"replace"===f.location}),f.notify&&a.$broadcast("$stateChangeSuccess",b.self,c,j.self,l),q.update(!0),z.current)}).then(null,function(d){return d===B?D:z.transition!==N?(a.$broadcast("$stateChangeCancel",b.self,c,j.self,l),D):(z.transition=null,g=a.$broadcast("$stateChangeError",b.self,c,j.self,l,d),g.defaultPrevented||q.update(),e.reject(d))});return N},z.is=function(a,b,d){d=S({relative:z.$current},d||{});var e=m(a,d.relative);return M(e)?z.$current===e&&(!b||j(e.params.$$values(b),n)):c},z.includes=function(a,b,d){if(d=S({relative:z.$current},d||{}),O(a)&&s(a)){if(!t(a))return!1;a=z.$current.name}var e=m(a,d.relative);if(!M(e))return c;if(!M(z.$current.includes[e.name]))return!1;if(!b)return!0;for(var f=g(b),h=0;h<f.length;h++){var i=f[h],j=e.params[i];if(j&&!j.type.equals(n[i],b[i]))return!1}return!0},z.href=function(a,b,d){d=S({lossy:!0,inherit:!0,absolute:!1,relative:z.$current},d||{});var e=m(a,d.relative);if(!M(e))return null;d.inherit&&(b=i(n,b||{},z.$current,e));var f=e&&d.lossy?e.navigable:e;return f&&f.url!==c&&null!==f.url?q.href(f.url,k(e.params.$$keys().concat("#"),b||{}),{absolute:d.absolute}):null},z.get=function(a,b){if(0===arguments.length)return o(g(A),function(a){return A[a].self});var c=m(a,b||z.$current);return c&&c.self?c.self:null},z}function x(a,b,c,d,e,f){function g(a,b,c){function d(b){return"search"!=a.params[b].location}var e=a.params.$$keys().filter(d),f=l.apply({},[a.params].concat(e)),g=new V.ParamSet(f);return g.$$equals(b,c)}if(!f.reload&&a===c&&(e===c.locals||a.self.reloadOnSearch===!1&&g(c,d,b)))return!0}var y,z,A={},B={},C="abstract",D={parent:function(a){if(M(a.parent)&&a.parent)return m(a.parent);var b=/^(.+)\.[^.]+$/.exec(a.name);return b?m(b[1]):y},data:function(a){return a.parent&&a.parent.data&&(a.data=a.self.data=d(a.parent.data,a.data)),a.data},url:function(a){var b=a.url,c={params:a.params||{}};if(O(b))return"^"==b.charAt(0)?e.compile(b.substring(1),c):(a.parent.navigable||y).url.concat(b,c);if(!b||e.isMatcher(b))return b;throw new Error("Invalid url '"+b+"' in state '"+a+"'")},navigable:function(a){return a.url?a:a.parent?a.parent.navigable:null},ownParams:function(a){var b=a.url&&a.url.params||new V.ParamSet;return R(a.params||{},function(a,c){b[c]||(b[c]=new V.Param(c,null,a,"config"))}),b},params:function(a){var b=l(a.ownParams,a.ownParams.$$keys());return a.parent&&a.parent.params?S(a.parent.params.$$new(),b):new V.ParamSet},views:function(a){var b={};return R(M(a.views)?a.views:{"":a},function(c,d){d.indexOf("@")<0&&(d+="@"+a.parent.name),c.resolveAs=c.resolveAs||a.resolveAs||"$resolve",b[d]=c}),b},path:function(a){return a.parent?a.parent.path.concat(a):[]},includes:function(a){var b=a.parent?S({},a.parent.includes):{};return b[a.name]=!0,b},$delegates:{}};y=r({name:"",url:"^",views:null,abstract:!0}),y.navigable=null,this.decorator=u,this.state=v,this.$get=w,w.$inject=["$rootScope","$q","$view","$injector","$resolve","$stateParams","$urlRouter","$location","$urlMatcherFactory"]}function x(){function a(a,b){return{load:function(a,c){var d,e={template:null,controller:null,view:null,locals:null,notify:!0,async:!0,params:{}};return c=S(e,c),c.view&&(d=b.fromConfig(c.view,c.params,c.locals)),d}}}this.$get=a,a.$inject=["$rootScope","$templateFactory"]}function y(){var a=!1;this.useAnchorScroll=function(){a=!0},this.$get=["$anchorScroll","$timeout",function(b,c){return a?b:function(a){return c(function(){a[0].scrollIntoView()},0,!1)}}]}function z(a,c,d,e,f){function g(){return c.has?function(a){return c.has(a)?c.get(a):null}:function(a){try{return c.get(a)}catch(a){return null}}}function h(a,c){var d=function(){return{enter:function(a,b,c){b.after(a),c()},leave:function(a,b){a.remove(),b()}}};if(k)return{enter:function(a,c,d){b.version.minor>2?k.enter(a,null,c).then(d):k.enter(a,null,c,d)},leave:function(a,c){b.version.minor>2?k.leave(a).then(c):k.leave(a,c)}};if(j){var e=j&&j(c,a);return{enter:function(a,b,c){e.enter(a,null,b),c()},leave:function(a,b){e.leave(a),b()}}}return d()}var i=g(),j=i("$animator"),k=i("$animate"),l={restrict:"ECA",terminal:!0,priority:400,transclude:"element",compile:function(c,g,i){return function(c,g,j){function k(){if(m&&(m.remove(),m=null),o&&(o.$destroy(),o=null),n){var a=n.data("$uiViewAnim");s.leave(n,function(){a.$$animLeave.resolve(),m=null}),m=n,n=null}}function l(h){var l,m=B(c,j,g,e),t=m&&a.$current&&a.$current.locals[m];if(h||t!==p){l=c.$new(),p=a.$current.locals[m],l.$emit("$viewContentLoading",m);var u=i(l,function(a){var e=f.defer(),h=f.defer(),i={$animEnter:e.promise,$animLeave:h.promise,$$animLeave:h};a.data("$uiViewAnim",i),s.enter(a,g,function(){e.resolve(),o&&o.$emit("$viewContentAnimationEnded"),(b.isDefined(r)&&!r||c.$eval(r))&&d(a)}),k()});n=u,o=l,o.$emit("$viewContentLoaded",m),o.$eval(q)}}var m,n,o,p,q=j.onload||"",r=j.autoscroll,s=h(j,c);g.inheritedData("$uiView");c.$on("$stateChangeSuccess",function(){l(!1)}),l(!0)}}};return l}function A(a,c,d,e){return{restrict:"ECA",priority:-400,compile:function(f){var g=f.html();return function(f,h,i){var j=d.$current,k=B(f,i,h,e),l=j&&j.locals[k];if(l){h.data("$uiView",{name:k,state:l.$$state}),h.html(l.$template?l.$template:g);var m=b.extend({},l);f[l.$$resolveAs]=m;var n=a(h.contents());if(l.$$controller){l.$scope=f,l.$element=h;var o=c(l.$$controller,l);l.$$controllerAs&&(f[l.$$controllerAs]=o,f[l.$$controllerAs][l.$$resolveAs]=m),N(o.$onInit)&&o.$onInit(),h.data("$ngControllerController",o),h.children().data("$ngControllerController",o)}n(f)}}}}}function B(a,b,c,d){var e=d(b.uiView||b.name||"")(a),f=c.inheritedData("$uiView");return e.indexOf("@")>=0?e:e+"@"+(f?f.state.name:"")}function C(a,b){var c,d=a.match(/^\s*({[^}]*})\s*$/);if(d&&(a=b+"("+d[1]+")"),c=a.replace(/\n/g," ").match(/^([^(]+?)\s*(\((.*)\))?$/),!c||4!==c.length)throw new Error("Invalid state ref '"+a+"'");return{state:c[1],paramExpr:c[3]||null}}function D(a){var b=a.parent().inheritedData("$uiView");if(b&&b.state&&b.state.name)return b.state}function E(a){var b="[object SVGAnimatedString]"===Object.prototype.toString.call(a.prop("href")),c="FORM"===a[0].nodeName;return{attr:c?"action":b?"xlink:href":"href",isAnchor:"A"===a.prop("tagName").toUpperCase(),clickable:!c}}function F(a,b,c,d,e){return function(f){var g=f.which||f.button,h=e();if(!(g>1||f.ctrlKey||f.metaKey||f.shiftKey||a.attr("target"))){var i=c(function(){b.go(h.state,h.params,h.options)});f.preventDefault();var j=d.isAnchor&&!h.href?1:0;f.preventDefault=function(){j--<=0&&c.cancel(i)}}}}function G(a,b){return{relative:D(a)||b.$current,inherit:!0}}function H(a,c){return{restrict:"A",require:["?^uiSrefActive","?^uiSrefActiveEq"],link:function(d,e,f,g){var h,i=C(f.uiSref,a.current.name),j={state:i.state,href:null,params:null},k=E(e),l=g[1]||g[0],m=null;j.options=S(G(e,a),f.uiSrefOpts?d.$eval(f.uiSrefOpts):{});var n=function(c){c&&(j.params=b.copy(c)),j.href=a.href(i.state,j.params,j.options),m&&m(),l&&(m=l.$$addStateInfo(i.state,j.params)),null!==j.href&&f.$set(k.attr,j.href)};i.paramExpr&&(d.$watch(i.paramExpr,function(a){a!==j.params&&n(a)},!0),j.params=b.copy(d.$eval(i.paramExpr))),n(),k.clickable&&(h=F(e,a,c,k,function(){return j}),e[e.on?"on":"bind"]("click",h),d.$on("$destroy",function(){e[e.off?"off":"unbind"]("click",h)}))}}}function I(a,b){return{restrict:"A",require:["?^uiSrefActive","?^uiSrefActiveEq"],link:function(c,d,e,f){function g(b){m.state=b[0],m.params=b[1],m.options=b[2],m.href=a.href(m.state,m.params,m.options),n&&n(),j&&(n=j.$$addStateInfo(m.state,m.params)),m.href&&e.$set(i.attr,m.href)}var h,i=E(d),j=f[1]||f[0],k=[e.uiState,e.uiStateParams||null,e.uiStateOpts||null],l="["+k.map(function(a){return a||"null"}).join(", ")+"]",m={state:null,params:null,options:null,href:null},n=null;c.$watch(l,g,!0),g(c.$eval(l)),i.clickable&&(h=F(d,a,b,i,function(){return m}),d[d.on?"on":"bind"]("click",h),c.$on("$destroy",function(){d[d.off?"off":"unbind"]("click",h)}))}}}function J(a,b,c){return{restrict:"A",controller:["$scope","$element","$attrs","$timeout",function(b,d,e,f){function g(b,c,e){var f=a.get(b,D(d)),g=h(b,c),i={state:f||{name:b},params:c,hash:g};return p.push(i),q[g]=e,function(){var a=p.indexOf(i);a!==-1&&p.splice(a,1)}}function h(a,c){if(!O(a))throw new Error("state should be a string");return P(c)?a+U(c):(c=b.$eval(c),P(c)?a+U(c):a)}function i(){for(var a=0;a<p.length;a++)l(p[a].state,p[a].params)?j(d,q[p[a].hash]):k(d,q[p[a].hash]),m(p[a].state,p[a].params)?j(d,n):k(d,n)}function j(a,b){f(function(){a.addClass(b)})}function k(a,b){a.removeClass(b)}function l(b,c){return a.includes(b.name,c)}function m(b,c){return a.is(b.name,c)}var n,o,p=[],q={};n=c(e.uiSrefActiveEq||"",!1)(b);try{o=b.$eval(e.uiSrefActive)}catch(a){}o=o||c(e.uiSrefActive||"",!1)(b),P(o)&&R(o,function(c,d){if(O(c)){var e=C(c,a.current.name);g(e.state,b.$eval(e.paramExpr),d)}}),this.$$addStateInfo=function(a,b){if(!(P(o)&&p.length>0)){var c=g(a,b,o);return i(),c}},b.$on("$stateChangeSuccess",i),i()}]}}function K(a){var b=function(b,c){return a.is(b,c)};return b.$stateful=!0,b}function L(a){var b=function(b,c,d){return a.includes(b,c,d)};return b.$stateful=!0,b}var M=b.isDefined,N=b.isFunction,O=b.isString,P=b.isObject,Q=b.isArray,R=b.forEach,S=b.extend,T=b.copy,U=b.toJson;b.module("ui.router.util",["ng"]),b.module("ui.router.router",["ui.router.util"]),b.module("ui.router.state",["ui.router.router","ui.router.util"]),b.module("ui.router",["ui.router.state"]),b.module("ui.router.compat",["ui.router"]),q.$inject=["$q","$injector"],b.module("ui.router.util").service("$resolve",q),r.$inject=["$http","$templateCache","$injector"],b.module("ui.router.util").service("$templateFactory",r);var V;s.prototype.concat=function(a,b){var c={caseInsensitive:V.caseInsensitive(),strict:V.strictMode(),squash:V.defaultSquashPolicy()};return new s(this.sourcePath+a+this.sourceSearch,S(c,b),this)},s.prototype.toString=function(){return this.source},s.prototype.exec=function(a,b){function c(a){function b(a){return a.split("").reverse().join("")}function c(a){return a.replace(/\\-/g,"-")}var d=b(a).split(/-(?!\\)/),e=o(d,b);return o(e,c).reverse()}var d=this.regexp.exec(a);if(!d)return null;b=b||{};var e,f,g,h=this.parameters(),i=h.length,j=this.segments.length-1,k={};if(j!==d.length-1)throw new Error("Unbalanced capture group in route '"+this.source+"'");var l,m;for(e=0;e<j;e++){for(g=h[e],l=this.params[g],m=d[e+1],f=0;f<l.replace.length;f++)l.replace[f].from===m&&(m=l.replace[f].to);m&&l.array===!0&&(m=c(m)),M(m)&&(m=l.type.decode(m)),k[g]=l.value(m)}for(;e<i;e++){for(g=h[e],k[g]=this.params[g].value(b[g]),l=this.params[g],m=b[g],f=0;f<l.replace.length;f++)l.replace[f].from===m&&(m=l.replace[f].to);M(m)&&(m=l.type.decode(m)),k[g]=l.value(m)}return k},s.prototype.parameters=function(a){return M(a)?this.params[a]||null:this.$$paramNames},s.prototype.validates=function(a){return this.params.$$validates(a)},s.prototype.format=function(a){function b(a){return encodeURIComponent(a).replace(/-/g,function(a){return"%5C%"+a.charCodeAt(0).toString(16).toUpperCase()})}a=a||{};var c=this.segments,d=this.parameters(),e=this.params;if(!this.validates(a))return null;var f,g=!1,h=c.length-1,i=d.length,j=c[0];for(f=0;f<i;f++){var k=f<h,l=d[f],m=e[l],n=m.value(a[l]),p=m.isOptional&&m.type.equals(m.value(),n),q=!!p&&m.squash,r=m.type.encode(n);if(k){var s=c[f+1],t=f+1===h;if(q===!1)null!=r&&(j+=Q(r)?o(r,b).join("-"):encodeURIComponent(r)),j+=s;else if(q===!0){var u=j.match(/\/$/)?/\/?(.*)/:/(.*)/;j+=s.match(u)[1]}else O(q)&&(j+=q+s);t&&m.squash===!0&&"/"===j.slice(-1)&&(j=j.slice(0,-1))}else{if(null==r||p&&q!==!1)continue;if(Q(r)||(r=[r]),0===r.length)continue;r=o(r,encodeURIComponent).join("&"+l+"="),j+=(g?"&":"?")+(l+"="+r),g=!0}}return j},t.prototype.is=function(a,b){return!0},t.prototype.encode=function(a,b){return a},t.prototype.decode=function(a,b){return a},t.prototype.equals=function(a,b){return a==b},t.prototype.$subPattern=function(){var a=this.pattern.toString();return a.substr(1,a.length-2)},t.prototype.pattern=/.*/,t.prototype.toString=function(){return"{Type:"+this.name+"}"},t.prototype.$normalize=function(a){return this.is(a)?a:this.decode(a)},t.prototype.$asArray=function(a,b){function d(a,b){function d(a,b){return function(){return a[b].apply(a,arguments)}}function e(a){return Q(a)?a:M(a)?[a]:[]}function f(a){switch(a.length){case 0:return c;case 1:return"auto"===b?a[0]:a;default:return a}}function g(a){return!a}function h(a,b){return function(c){if(Q(c)&&0===c.length)return c;c=e(c);var d=o(c,a);return b===!0?0===n(d,g).length:f(d)}}function i(a){return function(b,c){var d=e(b),f=e(c);if(d.length!==f.length)return!1;for(var g=0;g<d.length;g++)if(!a(d[g],f[g]))return!1;return!0}}this.encode=h(d(a,"encode")),this.decode=h(d(a,"decode")),this.is=h(d(a,"is"),!0),this.equals=i(d(a,"equals")),this.pattern=a.pattern,this.$normalize=h(d(a,"$normalize")),this.name=a.name,this.$arrayMode=b}if(!a)return this;if("auto"===a&&!b)throw new Error("'auto' array mode is for query parameters only");return new d(this,a);
},b.module("ui.router.util").provider("$urlMatcherFactory",u),b.module("ui.router.util").run(["$urlMatcherFactory",function(a){}]),v.$inject=["$locationProvider","$urlMatcherFactoryProvider"],b.module("ui.router.router").provider("$urlRouter",v),w.$inject=["$urlRouterProvider","$urlMatcherFactoryProvider"],b.module("ui.router.state").factory("$stateParams",function(){return{}}).constant("$state.runtime",{autoinject:!0}).provider("$state",w).run(["$injector",function(a){a.get("$state.runtime").autoinject&&a.get("$state")}]),x.$inject=[],b.module("ui.router.state").provider("$view",x),b.module("ui.router.state").provider("$uiViewScroll",y),z.$inject=["$state","$injector","$uiViewScroll","$interpolate","$q"],A.$inject=["$compile","$controller","$state","$interpolate"],b.module("ui.router.state").directive("uiView",z),b.module("ui.router.state").directive("uiView",A),H.$inject=["$state","$timeout"],I.$inject=["$state","$timeout"],J.$inject=["$state","$stateParams","$interpolate"],b.module("ui.router.state").directive("uiSref",H).directive("uiSrefActive",J).directive("uiSrefActiveEq",J).directive("uiState",I),K.$inject=["$state"],L.$inject=["$state"],b.module("ui.router.state").filter("isState",K).filter("includedByState",L)}(window,window.angular);
/*! ngTagsInput v3.1.1 License: MIT */!function(){"use strict";var a={backspace:8,tab:9,enter:13,escape:27,space:32,up:38,down:40,left:37,right:39,"delete":46,comma:188},b=9007199254740991,c=["text","email","url"],d=angular.module("ngTagsInput",[]);d.directive("tagsInput",["$timeout","$document","$window","$q","tagsInputConfig","tiUtil",function(d,e,f,g,h,i){function j(a,b,c,d){var e,f,h,j,k={};return e=function(b){return i.safeToString(b[a.displayProperty])},f=function(b,c){b[a.displayProperty]=c},h=function(b){var d=e(b),f=d&&d.length>=a.minLength&&d.length<=a.maxLength&&a.allowedTagsPattern.test(d)&&!i.findInObjectArray(k.items,b,a.keyProperty||a.displayProperty);return g.when(f&&c({$tag:b})).then(i.promisifyValue)},j=function(a){return g.when(d({$tag:a})).then(i.promisifyValue)},k.items=[],k.addText=function(a){var b={};return f(b,a),k.add(b)},k.add=function(c){var d=e(c);return a.replaceSpacesWithDashes&&(d=i.replaceSpacesWithDashes(d)),f(c,d),h(c).then(function(){k.items.push(c),b.trigger("tag-added",{$tag:c})})["catch"](function(){d&&b.trigger("invalid-tag",{$tag:c})})},k.remove=function(a){var c=k.items[a];return j(c).then(function(){return k.items.splice(a,1),k.clearSelection(),b.trigger("tag-removed",{$tag:c}),c})},k.select=function(a){0>a?a=k.items.length-1:a>=k.items.length&&(a=0),k.index=a,k.selected=k.items[a]},k.selectPrior=function(){k.select(--k.index)},k.selectNext=function(){k.select(++k.index)},k.removeSelected=function(){return k.remove(k.index)},k.clearSelection=function(){k.selected=null,k.index=-1},k.clearSelection(),k}function k(a){return-1!==c.indexOf(a)}return{restrict:"E",require:"ngModel",scope:{tags:"=ngModel",text:"=?",templateScope:"=?",tagClass:"&",onTagAdding:"&",onTagAdded:"&",onInvalidTag:"&",onTagRemoving:"&",onTagRemoved:"&",onTagClicked:"&"},replace:!1,transclude:!0,templateUrl:"ngTagsInput/tags-input.html",controller:["$scope","$attrs","$element",function(a,c,d){a.events=i.simplePubSub(),h.load("tagsInput",a,c,{template:[String,"ngTagsInput/tag-item.html"],type:[String,"text",k],placeholder:[String,"Add a tag"],tabindex:[Number,null],removeTagSymbol:[String,String.fromCharCode(215)],replaceSpacesWithDashes:[Boolean,!0],minLength:[Number,3],maxLength:[Number,b],addOnEnter:[Boolean,!0],addOnSpace:[Boolean,!1],addOnComma:[Boolean,!0],addOnBlur:[Boolean,!0],addOnPaste:[Boolean,!1],pasteSplitPattern:[RegExp,/,/],allowedTagsPattern:[RegExp,/.+/],enableEditingLastTag:[Boolean,!1],minTags:[Number,0],maxTags:[Number,b],displayProperty:[String,"text"],keyProperty:[String,""],allowLeftoverText:[Boolean,!1],addFromAutocompleteOnly:[Boolean,!1],spellcheck:[Boolean,!0]}),a.tagList=new j(a.options,a.events,i.handleUndefinedResult(a.onTagAdding,!0),i.handleUndefinedResult(a.onTagRemoving,!0)),this.registerAutocomplete=function(){d.find("input");return{addTag:function(b){return a.tagList.add(b)},getTags:function(){return a.tagList.items},getCurrentTagText:function(){return a.newTag.text()},getOptions:function(){return a.options},getTemplateScope:function(){return a.templateScope},on:function(b,c){return a.events.on(b,c,!0),this}}},this.registerTagItem=function(){return{getOptions:function(){return a.options},removeTag:function(b){a.disabled||a.tagList.remove(b)}}}}],link:function(b,c,g,h){var j,k,l=[a.enter,a.comma,a.space,a.backspace,a["delete"],a.left,a.right],m=b.tagList,n=b.events,o=b.options,p=c.find("input"),q=["minTags","maxTags","allowLeftoverText"];j=function(){h.$setValidity("maxTags",m.items.length<=o.maxTags),h.$setValidity("minTags",m.items.length>=o.minTags),h.$setValidity("leftoverText",b.hasFocus||o.allowLeftoverText?!0:!b.newTag.text())},k=function(){d(function(){p[0].focus()})},h.$isEmpty=function(a){return!a||!a.length},b.newTag={text:function(a){return angular.isDefined(a)?(b.text=a,void n.trigger("input-change",a)):b.text||""},invalid:null},b.track=function(a){return a[o.keyProperty||o.displayProperty]},b.getTagClass=function(a,c){var d=a===m.selected;return[b.tagClass({$tag:a,$index:c,$selected:d}),{selected:d}]},b.$watch("tags",function(a){a?(m.items=i.makeObjectArray(a,o.displayProperty),b.tags=m.items):m.items=[]}),b.$watch("tags.length",function(){j(),h.$validate()}),g.$observe("disabled",function(a){b.disabled=a}),b.eventHandlers={input:{keydown:function(a){n.trigger("input-keydown",a)},focus:function(){b.hasFocus||(b.hasFocus=!0,n.trigger("input-focus"))},blur:function(){d(function(){var a=e.prop("activeElement"),d=a===p[0],f=c[0].contains(a);!d&&f||(b.hasFocus=!1,n.trigger("input-blur"))})},paste:function(a){a.getTextData=function(){var b=a.clipboardData||a.originalEvent&&a.originalEvent.clipboardData;return b?b.getData("text/plain"):f.clipboardData.getData("Text")},n.trigger("input-paste",a)}},host:{click:function(){b.disabled||k()}},tag:{click:function(a){n.trigger("tag-clicked",{$tag:a})}}},n.on("tag-added",b.onTagAdded).on("invalid-tag",b.onInvalidTag).on("tag-removed",b.onTagRemoved).on("tag-clicked",b.onTagClicked).on("tag-added",function(){b.newTag.text("")}).on("tag-added tag-removed",function(){b.tags=m.items,h.$setDirty(),k()}).on("invalid-tag",function(){b.newTag.invalid=!0}).on("option-change",function(a){-1!==q.indexOf(a.name)&&j()}).on("input-change",function(){m.clearSelection(),b.newTag.invalid=null}).on("input-focus",function(){c.triggerHandler("focus"),h.$setValidity("leftoverText",!0)}).on("input-blur",function(){o.addOnBlur&&!o.addFromAutocompleteOnly&&m.addText(b.newTag.text()),c.triggerHandler("blur"),j()}).on("input-keydown",function(c){var d,e,f,g,h=c.keyCode,j={};i.isModifierOn(c)||-1===l.indexOf(h)||(j[a.enter]=o.addOnEnter,j[a.comma]=o.addOnComma,j[a.space]=o.addOnSpace,d=!o.addFromAutocompleteOnly&&j[h],e=(h===a.backspace||h===a["delete"])&&m.selected,g=h===a.backspace&&0===b.newTag.text().length&&o.enableEditingLastTag,f=(h===a.backspace||h===a.left||h===a.right)&&0===b.newTag.text().length&&!o.enableEditingLastTag,d?m.addText(b.newTag.text()):g?(m.selectPrior(),m.removeSelected().then(function(a){a&&b.newTag.text(a[o.displayProperty])})):e?m.removeSelected():f&&(h===a.left||h===a.backspace?m.selectPrior():h===a.right&&m.selectNext()),(d||f||e||g)&&c.preventDefault())}).on("input-paste",function(a){if(o.addOnPaste){var b=a.getTextData(),c=b.split(o.pasteSplitPattern);c.length>1&&(c.forEach(function(a){m.addText(a)}),a.preventDefault())}})}}}]),d.directive("tiTagItem",["tiUtil",function(a){return{restrict:"E",require:"^tagsInput",template:'<ng-include src="$$template"></ng-include>',scope:{$scope:"=scope",data:"="},link:function(b,c,d,e){var f=e.registerTagItem(),g=f.getOptions();b.$$template=g.template,b.$$removeTagSymbol=g.removeTagSymbol,b.$getDisplayText=function(){return a.safeToString(b.data[g.displayProperty])},b.$removeTag=function(){f.removeTag(b.$index)},b.$watch("$parent.$index",function(a){b.$index=a})}}}]),d.directive("autoComplete",["$document","$timeout","$sce","$q","tagsInputConfig","tiUtil",function(b,c,d,e,f,g){function h(a,b,c){var d,f,h,i={};return h=function(){return b.tagsInput.keyProperty||b.tagsInput.displayProperty},d=function(a,c){return a.filter(function(a){return!g.findInObjectArray(c,a,h(),function(a,c){return b.tagsInput.replaceSpacesWithDashes&&(a=g.replaceSpacesWithDashes(a),c=g.replaceSpacesWithDashes(c)),g.defaultComparer(a,c)})})},i.reset=function(){f=null,i.items=[],i.visible=!1,i.index=-1,i.selected=null,i.query=null},i.show=function(){b.selectFirstMatch?i.select(0):i.selected=null,i.visible=!0},i.load=g.debounce(function(c,j){i.query=c;var k=e.when(a({$query:c}));f=k,k.then(function(a){k===f&&(a=g.makeObjectArray(a.data||a,h()),a=d(a,j),i.items=a.slice(0,b.maxResultsToShow),i.items.length>0?i.show():i.reset())})},b.debounceDelay),i.selectNext=function(){i.select(++i.index)},i.selectPrior=function(){i.select(--i.index)},i.select=function(a){0>a?a=i.items.length-1:a>=i.items.length&&(a=0),i.index=a,i.selected=i.items[a],c.trigger("suggestion-selected",a)},i.reset(),i}function i(a,b){var c=a.find("li").eq(b),d=c.parent(),e=c.prop("offsetTop"),f=c.prop("offsetHeight"),g=d.prop("clientHeight"),h=d.prop("scrollTop");h>e?d.prop("scrollTop",e):e+f>g+h&&d.prop("scrollTop",e+f-g)}return{restrict:"E",require:"^tagsInput",scope:{source:"&",matchClass:"&"},templateUrl:"ngTagsInput/auto-complete.html",controller:["$scope","$element","$attrs",function(a,b,c){a.events=g.simplePubSub(),f.load("autoComplete",a,c,{template:[String,"ngTagsInput/auto-complete-match.html"],debounceDelay:[Number,100],minLength:[Number,3],highlightMatchedText:[Boolean,!0],maxResultsToShow:[Number,10],loadOnDownArrow:[Boolean,!1],loadOnEmpty:[Boolean,!1],loadOnFocus:[Boolean,!1],selectFirstMatch:[Boolean,!0],displayProperty:[String,""]}),a.suggestionList=new h(a.source,a.options,a.events),this.registerAutocompleteMatch=function(){return{getOptions:function(){return a.options},getQuery:function(){return a.suggestionList.query}}}}],link:function(b,c,d,e){var f,h=[a.enter,a.tab,a.escape,a.up,a.down],j=b.suggestionList,k=e.registerAutocomplete(),l=b.options,m=b.events;l.tagsInput=k.getOptions(),f=function(a){return a&&a.length>=l.minLength||!a&&l.loadOnEmpty},b.templateScope=k.getTemplateScope(),b.addSuggestionByIndex=function(a){j.select(a),b.addSuggestion()},b.addSuggestion=function(){var a=!1;return j.selected&&(k.addTag(angular.copy(j.selected)),j.reset(),a=!0),a},b.track=function(a){return a[l.tagsInput.keyProperty||l.tagsInput.displayProperty]},b.getSuggestionClass=function(a,c){var d=a===j.selected;return[b.matchClass({$match:a,$index:c,$selected:d}),{selected:d}]},k.on("tag-added tag-removed invalid-tag input-blur",function(){j.reset()}).on("input-change",function(a){f(a)?j.load(a,k.getTags()):j.reset()}).on("input-focus",function(){var a=k.getCurrentTagText();l.loadOnFocus&&f(a)&&j.load(a,k.getTags())}).on("input-keydown",function(c){var d=c.keyCode,e=!1;if(!g.isModifierOn(c)&&-1!==h.indexOf(d))return j.visible?d===a.down?(j.selectNext(),e=!0):d===a.up?(j.selectPrior(),e=!0):d===a.escape?(j.reset(),e=!0):d!==a.enter&&d!==a.tab||(e=b.addSuggestion()):d===a.down&&b.options.loadOnDownArrow&&(j.load(k.getCurrentTagText(),k.getTags()),e=!0),e?(c.preventDefault(),c.stopImmediatePropagation(),!1):void 0}),m.on("suggestion-selected",function(a){i(c,a)})}}}]),d.directive("tiAutocompleteMatch",["$sce","tiUtil",function(a,b){return{restrict:"E",require:"^autoComplete",template:'<ng-include src="$$template"></ng-include>',scope:{$scope:"=scope",data:"="},link:function(c,d,e,f){var g=f.registerAutocompleteMatch(),h=g.getOptions();c.$$template=h.template,c.$index=c.$parent.$index,c.$highlight=function(c){return h.highlightMatchedText&&(c=b.safeHighlight(c,g.getQuery())),a.trustAsHtml(c)},c.$getDisplayText=function(){return b.safeToString(c.data[h.displayProperty||h.tagsInput.displayProperty])}}}}]),d.directive("tiTranscludeAppend",function(){return function(a,b,c,d,e){e(function(a){b.append(a)})}}),d.directive("tiAutosize",["tagsInputConfig",function(a){return{restrict:"A",require:"ngModel",link:function(b,c,d,e){var f,g,h=a.getTextAutosizeThreshold();f=angular.element('<span class="input"></span>'),f.css("display","none").css("visibility","hidden").css("width","auto").css("white-space","pre"),c.parent().append(f),g=function(a){var b,e=a;return angular.isString(e)&&0===e.length&&(e=d.placeholder),e&&(f.text(e),f.css("display",""),b=f.prop("offsetWidth"),f.css("display","none")),c.css("width",b?b+h+"px":""),a},e.$parsers.unshift(g),e.$formatters.unshift(g),d.$observe("placeholder",function(a){e.$modelValue||g(a)})}}}]),d.directive("tiBindAttrs",function(){return function(a,b,c){a.$watch(c.tiBindAttrs,function(a){angular.forEach(a,function(a,b){c.$set(b,a)})},!0)}}),d.provider("tagsInputConfig",function(){var a={},b={},c=3;this.setDefaults=function(b,c){return a[b]=c,this},this.setActiveInterpolation=function(a,c){return b[a]=c,this},this.setTextAutosizeThreshold=function(a){return c=a,this},this.$get=["$interpolate",function(d){var e={};return e[String]=function(a){return a},e[Number]=function(a){return parseInt(a,10)},e[Boolean]=function(a){return"true"===a.toLowerCase()},e[RegExp]=function(a){return new RegExp(a)},{load:function(c,f,g,h){var i=function(){return!0};f.options={},angular.forEach(h,function(h,j){var k,l,m,n,o,p;k=h[0],l=h[1],m=h[2]||i,n=e[k],o=function(){var b=a[c]&&a[c][j];return angular.isDefined(b)?b:l},p=function(a){f.options[j]=a&&m(a)?n(a):o()},b[c]&&b[c][j]?g.$observe(j,function(a){p(a),f.events.trigger("option-change",{name:j,newValue:a})}):p(g[j]&&d(g[j])(f.$parent))})},getTextAutosizeThreshold:function(){return c}}}]}),d.factory("tiUtil",["$timeout","$q",function(a,b){var c={};return c.debounce=function(b,c){var d;return function(){var e=arguments;a.cancel(d),d=a(function(){b.apply(null,e)},c)}},c.makeObjectArray=function(a,b){if(!angular.isArray(a)||0===a.length||angular.isObject(a[0]))return a;var c=[];return a.forEach(function(a){var d={};d[b]=a,c.push(d)}),c},c.findInObjectArray=function(a,b,d,e){var f=null;return e=e||c.defaultComparer,a.some(function(a){return e(a[d],b[d])?(f=a,!0):void 0}),f},c.defaultComparer=function(a,b){return c.safeToString(a).toLowerCase()===c.safeToString(b).toLowerCase()},c.safeHighlight=function(a,b){function d(a){return a.replace(/([.?*+^$[\]\\(){}|-])/g,"\\$1")}if(!b)return a;a=c.encodeHTML(a),b=c.encodeHTML(b);var e=new RegExp("&[^;]+;|"+d(b),"gi");return a.replace(e,function(a){return a.toLowerCase()===b.toLowerCase()?"<em>"+a+"</em>":a})},c.safeToString=function(a){return angular.isUndefined(a)||null==a?"":a.toString().trim()},c.encodeHTML=function(a){return c.safeToString(a).replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;")},c.handleUndefinedResult=function(a,b){return function(){var c=a.apply(null,arguments);return angular.isUndefined(c)?b:c}},c.replaceSpacesWithDashes=function(a){return c.safeToString(a).replace(/\s/g,"-")},c.isModifierOn=function(a){return a.shiftKey||a.ctrlKey||a.altKey||a.metaKey},c.promisifyValue=function(a){return a=angular.isUndefined(a)?!0:a,b[a?"when":"reject"]()},c.simplePubSub=function(){var a={};return{on:function(b,c,d){return b.split(" ").forEach(function(b){a[b]||(a[b]=[]);var e=d?[].unshift:[].push;e.call(a[b],c)}),this},trigger:function(b,d){var e=a[b]||[];return e.every(function(a){return c.handleUndefinedResult(a,!0)(d)}),this}}},c}]),d.run(["$templateCache",function(a){a.put("ngTagsInput/tags-input.html",'<div class="host" tabindex="-1" ng-click="eventHandlers.host.click()" ti-transclude-append><div class="tags" ng-class="{focused: hasFocus}"><ul class="tag-list"><li class="tag-item" ng-repeat="tag in tagList.items track by track(tag)" ng-class="getTagClass(tag, $index)" ng-click="eventHandlers.tag.click(tag)"><ti-tag-item scope="templateScope" data="::tag"></ti-tag-item></li></ul><input class="input" autocomplete="off" ng-model="newTag.text" ng-model-options="{getterSetter: true}" ng-keydown="eventHandlers.input.keydown($event)" ng-focus="eventHandlers.input.focus($event)" ng-blur="eventHandlers.input.blur($event)" ng-paste="eventHandlers.input.paste($event)" ng-trim="false" ng-class="{\'invalid-tag\': newTag.invalid}" ng-disabled="disabled" ti-bind-attrs="{type: options.type, placeholder: options.placeholder, tabindex: options.tabindex, spellcheck: options.spellcheck}" ti-autosize></div></div>'),a.put("ngTagsInput/tag-item.html",'<span ng-bind="$getDisplayText()"></span> <a class="remove-button" ng-click="$removeTag()" ng-bind="::$$removeTagSymbol"></a>'),a.put("ngTagsInput/auto-complete.html",'<div class="autocomplete" ng-if="suggestionList.visible"><ul class="suggestion-list"><li class="suggestion-item" ng-repeat="item in suggestionList.items track by track(item)" ng-class="getSuggestionClass(item, $index)" ng-click="addSuggestionByIndex($index)" ng-mouseenter="suggestionList.select($index)"><ti-autocomplete-match scope="templateScope" data="::item"></ti-autocomplete-match></li></ul></div>'),a.put("ngTagsInput/auto-complete-match.html",'<span ng-bind-html="$highlight($getDisplayText())"></span>')}])}();
/**
 * swagger-client - swagger-client is a javascript client for use with swaggering APIs.
 * @version v2.1.23
 * @link http://swagger.io
 * @license Apache-2.0
 */
(function(f){if(typeof exports==="object"&&typeof module!=="undefined"){module.exports=f()}else if(typeof define==="function"&&define.amd){define([],f)}else{var g;if(typeof window!=="undefined"){g=window}else if(typeof global!=="undefined"){g=global}else if(typeof self!=="undefined"){g=self}else{g=this}g.SwaggerClient = f()}})(function(){var define,module,exports;return (function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
"use strict";var auth=require("./lib/auth"),helpers=require("./lib/helpers"),SwaggerClient=require("./lib/client"),deprecationWrapper=function(e,r){return helpers.log('This is deprecated, use "new SwaggerClient" instead.'),new SwaggerClient(e,r)};Array.prototype.indexOf||(Array.prototype.indexOf=function(e,r){for(var t=r||0,i=this.length;i>t;t++)if(this[t]===e)return t;return-1}),String.prototype.trim||(String.prototype.trim=function(){return this.replace(/^\s+|\s+$/g,"")}),String.prototype.endsWith||(String.prototype.endsWith=function(e){return-1!==this.indexOf(e,this.length-e.length)}),module.exports=SwaggerClient,SwaggerClient.ApiKeyAuthorization=auth.ApiKeyAuthorization,SwaggerClient.PasswordAuthorization=auth.PasswordAuthorization,SwaggerClient.CookieAuthorization=auth.CookieAuthorization,SwaggerClient.SwaggerApi=deprecationWrapper,SwaggerClient.SwaggerClient=deprecationWrapper,SwaggerClient.SchemaMarkup=require("./lib/schema-markup");
},{"./lib/auth":2,"./lib/client":3,"./lib/helpers":4,"./lib/schema-markup":7}],2:[function(require,module,exports){
"use strict";var helpers=require("./helpers"),btoa=require("btoa"),CookieJar=require("cookiejar").CookieJar,_={each:require("lodash-compat/collection/each"),includes:require("lodash-compat/collection/includes"),isObject:require("lodash-compat/lang/isObject"),isArray:require("lodash-compat/lang/isArray")},SwaggerAuthorizations=module.exports.SwaggerAuthorizations=function(e){this.authz=e||{}};SwaggerAuthorizations.prototype.add=function(e,t){if(_.isObject(e))for(var o in e)this.authz[o]=e[o];else"string"==typeof e&&(this.authz[e]=t);return t},SwaggerAuthorizations.prototype.remove=function(e){return delete this.authz[e]},SwaggerAuthorizations.prototype.apply=function(e,t){var o=!0,i=!t,r=[],a=e.clientAuthorizations||this.authz;return _.each(t,function(e,t){"string"==typeof t&&r.push(t),_.each(e,function(e,t){r.push(t)})}),_.each(a,function(t,a){if(i||_.includes(r,a)){var n=t.apply(e);o=o&&!!n}}),o};var ApiKeyAuthorization=module.exports.ApiKeyAuthorization=function(e,t,o){this.name=e,this.value=t,this.type=o};ApiKeyAuthorization.prototype.apply=function(e){if("query"===this.type){var t;if(e.url.indexOf("?")>0){t=e.url.substring(e.url.indexOf("?")+1);var o=t.split("&");if(o&&o.length>0)for(var i=0;i<o.length;i++){var r=o[i].split("=");if(r&&r.length>0&&r[0]===this.name)return!1}}return e.url.indexOf("?")>0?e.url=e.url+"&"+this.name+"="+this.value:e.url=e.url+"?"+this.name+"="+this.value,!0}return"header"===this.type?("undefined"==typeof e.headers[this.name]&&(e.headers[this.name]=this.value),!0):void 0};var CookieAuthorization=module.exports.CookieAuthorization=function(e){this.cookie=e};CookieAuthorization.prototype.apply=function(e){return e.cookieJar=e.cookieJar||new CookieJar,e.cookieJar.setCookie(this.cookie),!0};var PasswordAuthorization=module.exports.PasswordAuthorization=function(e,t){3===arguments.length&&(helpers.log("PasswordAuthorization: the 'name' argument has been removed, pass only username and password"),e=arguments[1],t=arguments[2]),this.username=e,this.password=t};PasswordAuthorization.prototype.apply=function(e){return"undefined"==typeof e.headers.Authorization&&(e.headers.Authorization="Basic "+btoa(this.username+":"+this.password)),!0};


},{"./helpers":4,"btoa":13,"cookiejar":18,"lodash-compat/collection/each":52,"lodash-compat/collection/includes":55,"lodash-compat/lang/isArray":140,"lodash-compat/lang/isObject":144}],3:[function(require,module,exports){
"use strict";var _={bind:require("lodash-compat/function/bind"),cloneDeep:require("lodash-compat/lang/cloneDeep"),find:require("lodash-compat/collection/find"),forEach:require("lodash-compat/collection/forEach"),indexOf:require("lodash-compat/array/indexOf"),isArray:require("lodash-compat/lang/isArray"),isObject:require("lodash-compat/lang/isObject"),isFunction:require("lodash-compat/lang/isFunction"),isPlainObject:require("lodash-compat/lang/isPlainObject"),isUndefined:require("lodash-compat/lang/isUndefined")},auth=require("./auth"),helpers=require("./helpers"),Model=require("./types/model"),Operation=require("./types/operation"),OperationGroup=require("./types/operationGroup"),Resolver=require("./resolver"),SwaggerHttp=require("./http"),SwaggerSpecConverter=require("./spec-converter"),Q=require("q"),reservedClientTags=["apis","authorizationScheme","authorizations","basePath","build","buildFrom1_1Spec","buildFrom1_2Spec","buildFromSpec","clientAuthorizations","convertInfo","debug","defaultErrorCallback","defaultSuccessCallback","enableCookies","fail","failure","finish","help","host","idFromOp","info","initialize","isBuilt","isValid","modelPropertyMacro","models","modelsArray","options","parameterMacro","parseUri","progress","resourceCount","sampleModels","selfReflect","setConsolidatedModels","spec","supportedSubmitMethods","swaggerRequestHeaders","tagFromLabel","title","url","useJQuery","jqueryAjaxCache"],reservedApiTags=["apis","asCurl","description","externalDocs","help","label","name","operation","operations","operationsArray","path","tag"],supportedOperationMethods=["delete","get","head","options","patch","post","put"],SwaggerClient=module.exports=function(e,t){return this.authorizations=null,this.authorizationScheme=null,this.basePath=null,this.debug=!1,this.enableCookies=!1,this.info=null,this.isBuilt=!1,this.isValid=!1,this.modelsArray=[],this.resourceCount=0,this.url=null,this.useJQuery=!1,this.jqueryAjaxCache=!1,this.swaggerObject={},this.deferredClient=void 0,this.clientAuthorizations=new auth.SwaggerAuthorizations,"undefined"!=typeof e?this.initialize(e,t):this};SwaggerClient.prototype.initialize=function(e,t){return this.models={},this.sampleModels={},"string"==typeof e?this.url=e:_.isObject(e)&&(t=e,this.url=t.url),this.url&&-1===this.url.indexOf("http:")&&-1===this.url.indexOf("https:")&&"undefined"!=typeof window&&window&&window.location&&(this.url=window.location.origin+this.url),t=t||{},this.clientAuthorizations.add(t.authorizations),this.swaggerRequestHeaders=t.swaggerRequestHeaders||"application/json;charset=utf-8,*/*",this.defaultSuccessCallback=t.defaultSuccessCallback||null,this.defaultErrorCallback=t.defaultErrorCallback||null,this.modelPropertyMacro=t.modelPropertyMacro||null,this.connectionAgent=t.connectionAgent||null,this.parameterMacro=t.parameterMacro||null,this.usePromise=t.usePromise||null,this.timeout=t.timeout||null,this.fetchSpecTimeout="undefined"!=typeof t.fetchSpecTimeout?t.fetchSpecTimeout:t.timeout||null,this.usePromise&&(this.deferredClient=Q.defer()),"function"==typeof t.success&&(this.success=t.success),t.useJQuery&&(this.useJQuery=t.useJQuery),t.jqueryAjaxCache&&(this.jqueryAjaxCache=t.jqueryAjaxCache),t.enableCookies&&(this.enableCookies=t.enableCookies),this.options=t||{},this.options.timeout=this.timeout,this.options.fetchSpecTimeout=this.fetchSpecTimeout,this.supportedSubmitMethods=t.supportedSubmitMethods||[],this.failure=t.failure||function(e){throw e},this.progress=t.progress||function(){},this.spec=_.cloneDeep(t.spec),t.scheme&&(this.scheme=t.scheme),this.usePromise||"function"==typeof t.success?(this.ready=!0,this.build()):void 0},SwaggerClient.prototype.build=function(e){if(this.isBuilt)return this;var t=this;this.spec?this.progress("fetching resource list; Please wait."):this.progress("fetching resource list: "+this.url+"; Please wait.");var i={useJQuery:this.useJQuery,jqueryAjaxCache:this.jqueryAjaxCache,connectionAgent:this.connectionAgent,url:this.url,method:"get",headers:{accept:this.swaggerRequestHeaders},on:{error:function(e){return"http"!==t.url.substring(0,4)?t.fail("Please specify the protocol for "+t.url):!e.errObj||"ECONNABORTED"!==e.errObj.code&&-1===e.errObj.message.indexOf("timeout")?0===e.status?t.fail("Can't read from server.  It may not have the appropriate access-control-origin settings."):404===e.status?t.fail("Can't read swagger JSON from "+t.url):t.fail(e.status+" : "+e.statusText+" "+t.url):t.fail("Request timed out after "+t.fetchSpecTimeout+"ms")},response:function(e){var i=e.obj;if(!i)return t.fail("failed to parse JSON/YAML response");if(t.swaggerVersion=i.swaggerVersion,t.swaggerObject=i,i.swagger&&2===parseInt(i.swagger))t.swaggerVersion=i.swagger,(new Resolver).resolve(i,t.url,t.buildFromSpec,t),t.isValid=!0;else{var s=new SwaggerSpecConverter;t.oldSwaggerObject=t.swaggerObject,s.setDocumentationLocation(t.url),s.convert(i,t.clientAuthorizations,t.options,function(e){t.swaggerObject=e,(new Resolver).resolve(e,t.url,t.buildFromSpec,t),t.isValid=!0})}}}};if(this.fetchSpecTimeout&&(i.timeout=this.fetchSpecTimeout),this.spec)t.swaggerObject=this.spec,setTimeout(function(){(new Resolver).resolve(t.spec,t.url,t.buildFromSpec,t)},10);else{if(this.clientAuthorizations.apply(i),e)return i;(new SwaggerHttp).execute(i,this.options)}return this.usePromise?this.deferredClient.promise:this},SwaggerClient.prototype.buildFromSpec=function(e){if(this.isBuilt)return this;this.apis={},this.apisArray=[],this.basePath=e.basePath||"",this.consumes=e.consumes,this.host=e.host||"",this.info=e.info||{},this.produces=e.produces,this.schemes=e.schemes||[],this.securityDefinitions=_.cloneDeep(e.securityDefinitions),this.security=e.security,this.title=e.title||"";var t,i,s,r,o={},n=this;if(e.externalDocs&&(this.externalDocs=e.externalDocs),this.authSchemes=this.securityDefinitions,this.securityDefinitions)for(t in this.securityDefinitions){var a=this.securityDefinitions[t];a.vendorExtensions={};for(var h in a)if(helpers.extractExtensions(h,a),"scopes"===h){var c=a[h];if("object"==typeof c){c.vendorExtensions={};for(var l in c)helpers.extractExtensions(l,c)}}}if(Array.isArray(e.tags))for(o={},i=0;i<e.tags.length;i++){var p=_.cloneDeep(e.tags[i]);o[p.name]=p;for(r in p){if("externalDocs"===r&&"object"==typeof p[r])for(var u in p[r])helpers.extractExtensions(u,p[r]);helpers.extractExtensions(r,p)}}if("string"==typeof this.url){if(s=this.parseUri(this.url),"undefined"==typeof this.scheme&&"undefined"==typeof this.schemes||0===this.schemes.length)"undefined"!=typeof window?this.scheme=window.location.protocol.replace(":",""):this.scheme=s.scheme||"http";else if("undefined"==typeof this.scheme)if("undefined"!=typeof window){var f=window.location.protocol.replace(":","");"https"===f&&-1===this.schemes.indexOf(f)?(helpers.log("Cannot call a http server from https inside a browser!"),this.scheme="http"):-1!==this.schemes.indexOf(f)?this.scheme=f:-1!==this.schemes.indexOf("https")?this.scheme="https":this.scheme="http"}else this.scheme=this.schemes[0]||s.scheme;"undefined"!=typeof this.host&&""!==this.host||(this.host=s.host,s.port&&(this.host=this.host+":"+s.port))}else"undefined"==typeof this.schemes||0===this.schemes.length?this.scheme="http":"undefined"==typeof this.scheme&&(this.scheme=this.schemes[0]);this.definitions=e.definitions;for(t in this.definitions){var d=new Model(t,this.definitions[t],this.models,this.modelPropertyMacro);d&&(this.models[t]=d)}n.apis.help=_.bind(n.help,n),_.forEach(e.paths,function(e,t){_.isPlainObject(e)&&_.forEach(supportedOperationMethods,function(i){var s=e[i];if(!_.isUndefined(s)){if(!_.isPlainObject(s))return void helpers.log("The '"+i+"' operation for '"+t+"' path is not an Operation Object");var a=s.tags;!_.isUndefined(a)&&_.isArray(a)&&0!==a.length||(a=s.tags=["default"]);var h=n.idFromOp(t,i,s),c=new Operation(n,s.scheme,h,i,t,s,n.definitions,n.models,n.clientAuthorizations);c.vendorExtensions={};for(r in s)helpers.extractExtensions(r,c,s[r]);if(c.externalDocs=s.externalDocs,c.externalDocs){c.externalDocs=_.cloneDeep(c.externalDocs),c.externalDocs.vendorExtensions={};for(r in c.externalDocs)helpers.extractExtensions(r,c.externalDocs)}_.forEach(a,function(e){var t=_.indexOf(reservedClientTags,e)>-1?"_"+e:e,i=_.indexOf(reservedApiTags,e)>-1?"_"+e:e,s=n[t];if(t!==e&&helpers.log("The '"+e+"' tag conflicts with a SwaggerClient function/property name.  Use 'client."+t+"' or 'client.apis."+e+"' instead of 'client."+e+"'."),i!==e&&helpers.log("The '"+e+"' tag conflicts with a SwaggerClient operation function/property name.  Use 'client.apis."+i+"' instead of 'client.apis."+e+"'."),_.indexOf(reservedApiTags,h)>-1&&(helpers.log("The '"+h+"' operationId conflicts with a SwaggerClient operation function/property name.  Use 'client.apis."+i+"._"+h+"' instead of 'client.apis."+i+"."+h+"'."),h="_"+h,c.nickname=h),_.isUndefined(s)){s=n[t]=n.apis[i]={},s.operations={},s.label=i,s.apis={};var r=o[e];_.isUndefined(r)||(s.description=r.description,s.externalDocs=r.externalDocs,s.vendorExtensions=r.vendorExtensions),n[t].help=_.bind(n.help,s),n.apisArray.push(new OperationGroup(e,s.description,s.externalDocs,c))}h=n.makeUniqueOperationId(h,n.apis[i]),_.isFunction(s.help)||(s.help=_.bind(n.help,s)),n.apis[i][h]=s[h]=_.bind(c.execute,c),n.apis[i][h].help=s[h].help=_.bind(c.help,c),n.apis[i][h].asCurl=s[h].asCurl=_.bind(c.asCurl,c),s.apis[h]=s.operations[h]=c;var a=_.find(n.apisArray,function(t){return t.tag===e});a&&a.operationsArray.push(c)})}})});var g=[];return _.forEach(Object.keys(o),function(e){var t;for(t in n.apisArray){var i=n.apisArray[t];i&&e===i.name&&(g.push(i),n.apisArray[t]=null)}}),_.forEach(n.apisArray,function(e){e&&g.push(e)}),n.apisArray=g,_.forEach(e.definitions,function(e,t){e.id=t.toLowerCase(),e.name=t,n.modelsArray.push(e)}),this.isBuilt=!0,this.usePromise?(this.isValid=!0,this.isBuilt=!0,this.deferredClient.resolve(this),this.deferredClient.promise):(this.success&&this.success(),this)},SwaggerClient.prototype.makeUniqueOperationId=function(e,t){for(var i=0,s=e;;){var r=!1;if(_.forEach(t.operations,function(e){e.nickname===s&&(r=!0)}),!r)return s;s=e+"_"+i,i++}return e},SwaggerClient.prototype.parseUri=function(e){var t=/^(((([^:\/#\?]+:)?(?:(\/\/)((?:(([^:@\/#\?]+)(?:\:([^:@\/#\?]+))?)@)?(([^:\/#\?\]\[]+|\[[^\/\]@#?]+\])(?:\:([0-9]+))?))?)?)?((\/?(?:[^\/\?#]+\/+)*)([^\?#]*)))?(\?[^#]+)?)(#.*)?/,i=t.exec(e);return{scheme:i[4]?i[4].replace(":",""):void 0,host:i[11],port:i[12],path:i[15]}},SwaggerClient.prototype.help=function(e){var t="";return this instanceof SwaggerClient?_.forEach(this.apis,function(e,i){_.isPlainObject(e)&&(t+="operations for the '"+i+"' tag\n",_.forEach(e.operations,function(e,i){t+="  * "+i+": "+e.summary+"\n"}))}):(this instanceof OperationGroup||_.isPlainObject(this))&&(t+="operations for the '"+this.label+"' tag\n",_.forEach(this.apis,function(e,i){t+="  * "+i+": "+e.summary+"\n"})),e?t:(helpers.log(t),t)},SwaggerClient.prototype.tagFromLabel=function(e){return e},SwaggerClient.prototype.idFromOp=function(e,t,i){i&&i.operationId||(i=i||{},i.operationId=t+"_"+e);var s=i.operationId.replace(/[\s!@#$%^&*()_+=\[{\]};:<>|.\/?,\\'""-]/g,"_")||e.substring(1)+"_"+t;return s=s.replace(/((_){2,})/g,"_"),s=s.replace(/^(_)*/g,""),s=s.replace(/([_])*$/g,"")},SwaggerClient.prototype.setHost=function(e){this.host=e,this.apis&&_.forEach(this.apis,function(t){t.operations&&_.forEach(t.operations,function(t){t.host=e})})},SwaggerClient.prototype.setBasePath=function(e){this.basePath=e,this.apis&&_.forEach(this.apis,function(t){t.operations&&_.forEach(t.operations,function(t){t.basePath=e})})},SwaggerClient.prototype.setSchemes=function(e){this.schemes=e,e&&e.length>0&&this.apis&&_.forEach(this.apis,function(t){t.operations&&_.forEach(t.operations,function(t){t.scheme=e[0]})})},SwaggerClient.prototype.fail=function(e){return this.usePromise?(this.deferredClient.reject(e),this.deferredClient.promise):void(this.failure?this.failure(e):this.failure(e))};


},{"./auth":2,"./helpers":4,"./http":5,"./resolver":6,"./spec-converter":8,"./types/model":9,"./types/operation":10,"./types/operationGroup":11,"lodash-compat/array/indexOf":49,"lodash-compat/collection/find":53,"lodash-compat/collection/forEach":54,"lodash-compat/function/bind":58,"lodash-compat/lang/cloneDeep":138,"lodash-compat/lang/isArray":140,"lodash-compat/lang/isFunction":142,"lodash-compat/lang/isObject":144,"lodash-compat/lang/isPlainObject":145,"lodash-compat/lang/isUndefined":148,"q":157}],4:[function(require,module,exports){
(function (process){
"use strict";var _={isPlainObject:require("lodash-compat/lang/isPlainObject"),indexOf:require("lodash-compat/array/indexOf")};module.exports.__bind=function(e,n){return function(){return e.apply(n,arguments)}};var log=module.exports.log=function(){console&&"test"!==process.env.NODE_ENV&&console.log(Array.prototype.slice.call(arguments)[0])};module.exports.fail=function(e){log(e)},module.exports.optionHtml=function(e,n){return'<tr><td class="optionName">'+e+":</td><td>"+n+"</td></tr>"};var resolveSchema=module.exports.resolveSchema=function(e){return _.isPlainObject(e.schema)&&(e=resolveSchema(e.schema)),e};module.exports.simpleRef=function(e){return"undefined"==typeof e?null:0===e.indexOf("#/definitions/")?e.substring("#/definitions/".length):e},module.exports.extractExtensions=function(e,n,o){e&&n&&"string"==typeof e&&0===e.indexOf("x-")&&(n.vendorExtensions=n.vendorExtensions||{},o?n.vendorExtensions[e]=o:n.vendorExtensions[e]=n[e])};


}).call(this,require('_process'))
},{"_process":12,"lodash-compat/array/indexOf":49,"lodash-compat/lang/isPlainObject":145}],5:[function(require,module,exports){
(function (Buffer){
"use strict";var helpers=require("./helpers"),request=require("superagent"),jsyaml=require("js-yaml"),_={isObject:require("lodash-compat/lang/isObject"),keys:require("lodash-compat/object/keys")},JQueryHttpClient=function(){this.type="JQueryHttpClient"},SuperagentHttpClient=function(){this.type="SuperagentHttpClient"},SwaggerHttp=module.exports=function(){};SwaggerHttp.prototype.execute=function(e,t){var r;r=t&&t.client?t.client:new SuperagentHttpClient(t),r.opts=t||{};var n=!1;if("undefined"!=typeof window&&"undefined"!=typeof window.jQuery&&(n=!0),"options"===e.method.toLowerCase()&&"SuperagentHttpClient"===r.type&&(log("forcing jQuery as OPTIONS are not supported by SuperAgent"),e.useJQuery=!0),this.isInternetExplorer()&&(e.useJQuery===!1||!n))throw new Error("Unsupported configuration! JQuery is required but not available");(e&&e.useJQuery===!0||this.isInternetExplorer()&&n)&&(r=new JQueryHttpClient(t));var o=e.on.response,s=e.on.error,a=function(e){return t&&t.requestInterceptor&&(e=t.requestInterceptor.apply(e)),e},i=function(e){return t&&t.responseInterceptor&&(e=t.responseInterceptor.apply(e)),o(e)},u=function(e){t&&t.responseInterceptor&&(e=t.responseInterceptor.apply(e)),s(e)};return e.on.error=function(e){u(e)},e.on.response=function(e){i(e)},_.isObject(e)&&_.isObject(e.body)&&e.body.type&&"formData"===e.body.type&&t.useJQuery&&(e.contentType=!1,e.processData=!1,delete e.headers["Content-Type"]),e=a(e)||e,e.beforeSend?e.beforeSend(function(t){r.execute(t||e)}):r.execute(e),e.deferred?e.deferred.promise:e},SwaggerHttp.prototype.isInternetExplorer=function(){var e=!1;if("undefined"!=typeof navigator&&navigator.userAgent){var t=navigator.userAgent.toLowerCase();if(-1!==t.indexOf("msie")){var r=parseInt(t.split("msie")[1]);8>=r&&(e=!0)}}return e},JQueryHttpClient.prototype.execute=function(e){var t=this.jQuery||"undefined"!=typeof window&&window.jQuery,r=e.on,n=e;if("undefined"==typeof t||t===!1)throw new Error("Unsupported configuration! JQuery is required but not available");return e.type=e.method,e.cache=e.jqueryAjaxCache,e.data=e.body,delete e.jqueryAjaxCache,delete e.useJQuery,delete e.body,e.complete=function(e){for(var t={},o=e.getAllResponseHeaders().split("\n"),s=0;s<o.length;s++){var a=o[s].trim();if(0!==a.length){var i=a.indexOf(":");if(-1!==i){var u=a.substring(0,i).trim(),p=a.substring(i+1).trim();t[u]=p}else t[a]=null}}var d={url:n.url,method:n.method,status:e.status,statusText:e.statusText,data:e.responseText,headers:t};try{var f=e.responseJSON||jsyaml.safeLoad(e.responseText);d.obj="string"==typeof f?{}:f}catch(l){helpers.log("unable to parse JSON/YAML content")}if(d.obj=d.obj||null,e.status>=200&&e.status<300)r.response(d);else{if(!(0===e.status||e.status>=400&&e.status<599))return r.response(d);r.error(d)}},t.support.cors=!0,t.ajax(e)},SuperagentHttpClient.prototype.execute=function(e){var t=e.connectionAgent,r=e.method.toLowerCase(),n=e.timeout;"delete"===r&&(r="del");var o=e.headers||{},s=request[r](e.url);t&&s.agent(t),n&&s.timeout(n),e.enableCookies&&s.withCredentials();var a=e.headers.Accept;if(this.binaryRequest(a)&&s.on("request",function(){this.xhr&&(this.xhr.responseType="blob")}),e.body)if(_.isObject(e.body)){var i=e.headers["Content-Type"]||"";if(0===i.indexOf("multipart/form-data"))if(delete o["Content-Type"],"[object FormData]"==={}.toString.apply(e.body))s.send(e.body);else{var u,p,d;for(u in e.body)if(p=e.body[u],Array.isArray(p))for(d in p)s.field(u,d);else s.field(u,p)}else _.isObject(e.body)&&(e.body=JSON.stringify(e.body),s.send(e.body))}else s.send(e.body);var f;for(f in o)s.set(f,o[f]);"function"==typeof s.buffer&&s.buffer(),s.end(function(t,r){r=r||{status:0,headers:{error:"no response from server"}};var n,o={url:e.url,method:e.method,headers:r.headers};if(!t&&r.error&&(t=r.error),t&&e.on&&e.on.error){if(o.errObj=t,o.status=r?r.status:500,o.statusText=r?r.text:t.message,r.headers&&r.headers["content-type"]&&r.headers["content-type"].indexOf("application/json")>=0)try{o.obj=JSON.parse(o.statusText)}catch(s){o.obj=null}n=e.on.error}else if(r&&e.on&&e.on.response){var a;if(r.body&&_.keys(r.body).length>0)a=r.body;else try{a=jsyaml.safeLoad(r.text),a="string"==typeof a?null:a}catch(s){helpers.log("cannot parse JSON/YAML content")}"function"==typeof Buffer&&Buffer.isBuffer(a)?o.data=a:o.obj="object"==typeof a?a:null,o.status=r.status,o.statusText=r.text,n=e.on.response}r.xhr&&r.xhr.response?o.data=r.xhr.response:o.data||(o.data=o.statusText),n&&n(o)})},SuperagentHttpClient.prototype.binaryRequest=function(e){return e?/^image/i.test(e)||/^application\/pdf/.test(e):!1};


}).call(this,require("buffer").Buffer)
},{"./helpers":4,"buffer":14,"js-yaml":19,"lodash-compat/lang/isObject":144,"lodash-compat/object/keys":149,"superagent":158}],6:[function(require,module,exports){
"use strict";function splitUrl(e){var i={},t=/[a-z]+:\/\//i.exec(e);t&&(i.proto=t[0].slice(0,-3),e=e.slice(i.proto.length+1)),"//"===e.slice(0,2)&&(i.domain=e.slice(2).split("/")[0],e=e.slice(2+i.domain.length));var r=e.split("#");return r[0].length&&(i.path=r[0]),r.length>1&&(i.fragment=r.slice(1).join("#")),i}function unsplitUrl(e){var i=e.path;return void 0===i&&(i=""),void 0!==e.fragment&&(i+="#"+e.fragment),void 0!==e.domain&&("/"===i.slice(0,1)&&(i=i.slice(1)),i="//"+e.domain+"/"+i,void 0!==e.proto&&(i=e.proto+":"+i)),i}function joinUrl(e,i){var t=splitUrl(i);if(void 0!==t.domain)return i;var r=splitUrl(e);if(void 0===t.path)r.fragment=t.fragment;else if("/"===t.path.slice(0,1))r.path=t.path,r.fragment=t.fragment;else{var o=void 0===r.path?[]:r.path.split("/"),s=t.path.split("/");for(o.length&&o.pop();".."===s[0]||"."===s[0];)".."===s[0]&&o.pop(),s.shift();r.path=o.concat(s).join("/"),r.fragment=t.fragment}return unsplitUrl(r)}var SwaggerHttp=require("./http"),_={isObject:require("lodash-compat/lang/isObject"),cloneDeep:require("lodash-compat/lang/cloneDeep"),isArray:require("lodash-compat/lang/isArray"),isString:require("lodash-compat/lang/isString")},Resolver=module.exports=function(){this.failedUrls=[],this.resolverCache={},this.pendingUrls={}};Resolver.prototype.processAllOf=function(e,i,t,r,o,s){var n,l,f;t["x-resolved-from"]=["#/definitions/"+i];var a=t.allOf;for(a.sort(function(e,i){return e.$ref&&i.$ref?0:e.$ref?-1:1}),n=0;n<a.length;n++)f=a[n],l="/definitions/"+i+"/allOf",this.resolveInline(e,s,f,r,o,l)},Resolver.prototype.resolve=function(e,i,t,r){this.spec=e;var o,s,n=i,l=t,f=r,a={};"function"==typeof i&&(n=null,l=i,f=t);var p,h=n;this.scope=f||this,this.iteration=this.iteration||0,this.scope.options&&this.scope.options.requestInterceptor&&(a.requestInterceptor=this.scope.options.requestInterceptor),this.scope.options&&this.scope.options.responseInterceptor&&(a.responseInterceptor=this.scope.options.responseInterceptor);var c,d,v,u,m,g,y,O=0,b={},x={},j=[];e.definitions=e.definitions||{};for(c in e.definitions){var A=e.definitions[c];if(A.$ref)this.resolveInline(n,e,A,j,x,A);else{for(u in A.properties)v=A.properties[u],_.isArray(v.allOf)?this.processAllOf(n,c,v,j,x,e):this.resolveTo(n,v,j,"/definitions");A.allOf&&this.processAllOf(n,c,A,j,x,e)}}e.parameters=e.parameters||{};for(c in e.parameters){if(m=e.parameters[c],"body"===m["in"]&&m.schema)if(_.isArray(m.schema.allOf)){p="inline_model";var k=p;for(g=!1,y=0;!g;){if("undefined"==typeof e.definitions[k]){g=!0;break}k=p+"_"+y,y++}e.definitions[k]={allOf:m.schema.allOf},delete m.schema.allOf,m.schema.$ref="#/definitions/"+k,this.processAllOf(n,k,e.definitions[k],j,x,e)}else this.resolveTo(n,m.schema,j,o);m.$ref&&this.resolveInline(n,e,m,j,x,m.$ref)}for(c in e.paths){var $,R,I;if(d=e.paths[c],"object"==typeof d){for($ in d)if("$ref"===$)o="/paths"+c,this.resolveInline(n,e,d,j,x,o);else{R=d[$];var q=d.parameters||[],U=R.parameters||[];for(s in q)m=q[s],U.unshift(m);"parameters"!==$&&_.isObject(R)&&(R.parameters=R.parameters||U);for(s in U){if(m=U[s],o="/paths"+c+"/"+$+"/parameters","body"===m["in"]&&m.schema)if(_.isArray(m.schema.allOf)){for(p="inline_model",c=p,g=!1,y=0;!g;){if("undefined"==typeof e.definitions[c]){g=!0;break}c=p+"_"+y,y++}e.definitions[c]={allOf:m.schema.allOf},delete m.schema.allOf,m.schema.$ref="#/definitions/"+c,this.processAllOf(n,c,e.definitions[c],j,x,e)}else this.resolveTo(n,m.schema,j,o);m.$ref&&this.resolveInline(n,e,m,j,x,m.$ref)}for(I in R.responses){var w=R.responses[I];if(o="/paths"+c+"/"+$+"/responses/"+I,_.isObject(w)&&(w.$ref&&this.resolveInline(n,e,w,j,x,o),w.schema)){var T=w;if(_.isArray(T.schema.allOf)){for(p="inline_model",c=p,g=!1,y=0;!g;){if("undefined"==typeof e.definitions[c]){g=!0;break}c=p+"_"+y,y++}e.definitions[c]={allOf:T.schema.allOf},delete T.schema.allOf,delete T.schema.type,T.schema.$ref="#/definitions/"+c,this.processAllOf(n,c,e.definitions[c],j,x,e)}else"array"===T.schema.type?T.schema.items&&T.schema.items.$ref&&this.resolveInline(n,e,T.schema.items,j,x,o):this.resolveTo(n,w.schema,j,o)}}}d.parameters=[]}}var S,D=0,C=[],P=j;for(s=0;s<P.length;s++){var z=P[s];if(n===z.root){if("ref"===z.resolveAs){var H,N=((z.root||"")+"/"+z.key).split("/"),E=[],J="";if(z.key.indexOf("../")>=0){for(var Q=0;Q<N.length;Q++)".."===N[Q]?E=E.slice(0,E.length-1):E.push(N[Q]);for(H=0;H<E.length;H++)H>0&&(J+="/"),J+=E[H];z.root=J,C.push(z)}else if(S=z.key.split("#"),2===S.length){0!==S[0].indexOf("http:")&&0!==S[0].indexOf("https:")||(z.root=S[0]),o=S[1].split("/");var B,F=e;for(H=0;H<o.length;H++){var G=o[H];if(""!==G){if(F=F[G],"undefined"==typeof F){B=null;break}B=F}}null===B&&C.push(z)}}else if("inline"===z.resolveAs){if(z.key&&-1===z.key.indexOf("#")&&"/"!==z.key.charAt(0)){for(S=z.root.split("/"),o="",s=0;s<S.length-1;s++)o+=S[s]+"/";o+=z.key,z.root=o,z.location=""}C.push(z)}}else C.push(z)}D=C.length;for(var K={},L=0;L<C.length;L++)!function(e,i,t,r,o){if(e.root&&e.root!==n)if(-1===t.failedUrls.indexOf(e.root)){var s={useJQuery:!1,url:e.root,method:"get",headers:{accept:t.scope.swaggerRequestHeaders||"application/json"},on:{error:function(o){O+=1,console.log("failed url: "+s.url),t.failedUrls.push(s.url),r&&delete r[e.root],x[e.key]={root:e.root,location:e.location},O===D&&t.finish(i,h,j,b,x,l)},response:function(o){var s=o.obj;r&&delete r[e.root],t.resolverCache&&(t.resolverCache[e.root]=s),t.resolveItem(s,e.root,j,b,x,e),O+=1,O===D&&t.finish(i,h,j,b,x,l)}}};f&&f.fetchSpecTimeout&&(s.timeout=f.fetchSpecTimeout),f&&f.clientAuthorizations&&f.clientAuthorizations.apply(s),function p(){setTimeout(function(){if(r[s.url])p();else{var e=t.resolverCache[s.url];_.isObject(e)?s.on.response({obj:e}):(r[s.url]=!0,(new SwaggerHttp).execute(s,a))}},0)}()}else O+=1,x[e.key]={root:e.root,location:e.location},O===D&&t.finish(i,h,j,b,x,l);else t.resolveItem(i,h,j,b,x,e),O+=1,O===D&&t.finish(i,n,j,b,x,l,!0)}(C[L],e,this,K,L);0===Object.keys(C).length&&this.finish(e,h,j,b,x,l)},Resolver.prototype.resolveItem=function(e,i,t,r,o,s){var n=s.location,l=e,f=n.split("/");if(""!==n)for(var a=0;a<f.length;a++){var p=f[a];if(-1!==p.indexOf("~1")&&(p=f[a].replace(/~0/g,"~").replace(/~1/g,"/"),"/"!==p.charAt(0)&&(p="/"+p)),"undefined"==typeof l||null===l)break;if(""===p&&a===f.length-1&&f.length>1){l=null;break}p.length>0&&(l=l[p])}var h=s.key;f=s.key.split("/");var c=f[f.length-1];c.indexOf("#")>=0&&(c=c.split("#")[1]),null!==l&&"undefined"!=typeof l?r[h]={name:c,obj:l,key:s.key,root:s.root}:o[h]={root:s.root,location:s.location}},Resolver.prototype.finish=function(e,i,t,r,o,s,n){var l,f;for(l in t){var a=t[l],p=a.key,h=r[p];if(h)if(e.definitions=e.definitions||{},"ref"===a.resolveAs){if(n!==!0)for(p in h.obj)f=this.retainRoot(p,h.obj[p],a.root),h.obj[p]=f;e.definitions[h.name]=h.obj,a.obj.$ref="#/definitions/"+h.name}else if("inline"===a.resolveAs){var c=a.obj;c["x-resolved-from"]=[a.key],delete c.$ref;for(p in h.obj)f=h.obj[p],n!==!0&&(f=this.retainRoot(p,h.obj[p],a.root)),c[p]=f}}var d=this.countUnresolvedRefs(e);0===d||this.iteration>5?(this.resolveAllOf(e.definitions),this.resolverCache=null,s.call(this.scope,e,o)):(this.iteration+=1,this.resolve(e,i,s,this.scope))},Resolver.prototype.countUnresolvedRefs=function(e){var i,t=this.getRefs(e),r=[],o=[];for(i in t)0===i.indexOf("#")?r.push(i.substring(1)):o.push(i);for(i=0;i<r.length;i++)for(var s=r[i],n=s.split("/"),l=e,f=0;f<n.length;f++){var a=n[f];if(""!==a&&(l=l[a],"undefined"==typeof l)){o.push(s);break}}return o.length},Resolver.prototype.getRefs=function(e,i){i=i||e;var t={};for(var r in i)if(i.hasOwnProperty(r)){var o=i[r];if("$ref"===r&&"string"==typeof o)t[o]=null;else if(_.isObject(o)){var s=this.getRefs(o);for(var n in s)t[n]=null}}return t},Resolver.prototype.retainRoot=function(e,i,t){if(_.isObject(i))for(var r in i){var o=i[r];"$ref"===r&&"string"==typeof o?i[r]=joinUrl(t,o):_.isObject(o)&&this.retainRoot(r,o,t)}else _.isString(i)&&"$ref"===e&&(i=joinUrl(t,i));return i},Resolver.prototype.resolveInline=function(e,i,t,r,o,s){var n,l,f,a,p=t.$ref,h=t.$ref,c=!1;if(e=e||"",h){if(0===h.indexOf("../")){for(l=h.split("../"),f=e.split("/"),h="",n=0;n<l.length;n++)""===l[n]?f=f.slice(0,f.length-1):h+=l[n];for(e="",n=0;n<f.length-1;n++)n>0&&(e+="/"),e+=f[n];c=!0}if(h.indexOf("#")>=0)if(0===h.indexOf("/"))a=h.split("#"),l=e.split("//"),f=l[1].split("/"),e=l[0]+"//"+f[0]+a[0],s=a[1];else{if(a=h.split("#"),""!==a[0]){if(f=e.split("/"),f=f.slice(0,f.length-1),!c){e="";for(var d=0;d<f.length;d++)d>0&&(e+="/"),e+=f[d]}e+="/"+h.split("#")[0]}s=a[1]}if(0===h.indexOf("http:")||0===h.indexOf("https:"))h.indexOf("#")>=0?(e=h.split("#")[0],s=h.split("#")[1]):(e=h,s=""),r.push({obj:t,resolveAs:"inline",root:e,key:p,location:s});else if(0===h.indexOf("#"))s=h.split("#")[1],r.push({obj:t,resolveAs:"inline",root:e,key:p,location:s});else if(0===h.indexOf("/")&&-1===h.indexOf("#")){s=h;var v=e.match(/^https?\:\/\/([^\/?#]+)(?:[\/?#]|$)/i);v&&(e=v[0]+h.substring(1),s=""),r.push({obj:t,resolveAs:"inline",root:e,key:p,location:s})}else r.push({obj:t,resolveAs:"inline",root:e,key:p,location:s})}else"array"===t.type&&this.resolveTo(e,t.items,r,s)},Resolver.prototype.resolveTo=function(e,i,t,r){var o,s,n=i.$ref,l=e;if("undefined"!=typeof n&&null!==n){if(n.indexOf("#")>=0){var f=n.split("#");if(f[0]&&0===n.indexOf("/"));else if(!f[0]||0!==f[0].indexOf("http:")&&0!==f[0].indexOf("https:")){if(f[0]&&f[0].length>0){for(o=e.split("/"),l="",s=0;s<o.length-1;s++)l+=o[s]+"/";l+=f[0]}}else l=f[0],n=f[1];r=f[1]}else if(0===n.indexOf("http:")||0===n.indexOf("https:"))l=n,r="";else{for(o=e.split("/"),l="",s=0;s<o.length-1;s++)l+=o[s]+"/";l+=n,r=""}t.push({obj:i,resolveAs:"ref",root:l,key:n,location:r})}else if("array"===i.type){var a=i.items;this.resolveTo(e,a,t,r)}else if(i&&(i.properties||i.additionalProperties)){var p=this.uniqueName("inline_model");i.title&&(p=this.uniqueName(i.title)),delete i.title,this.spec.definitions[p]=_.cloneDeep(i),i.$ref="#/definitions/"+p,delete i.type,delete i.properties}},Resolver.prototype.uniqueName=function(e){for(var i=e,t=0;;){if(!_.isObject(this.spec.definitions[i]))return i;i=e+"_"+t,t++}},Resolver.prototype.resolveAllOf=function(e,i,t){t=t||0,i=i||e;var r;for(var o in i)if(i.hasOwnProperty(o)){var s=i[o];if(null===s)throw new TypeError("Swagger 2.0 does not support null types ("+i+").  See https://github.com/swagger-api/swagger-spec/issues/229.");if("object"==typeof s&&this.resolveAllOf(e,s,t+1),s&&"undefined"!=typeof s.allOf){var n=s.allOf;if(_.isArray(n)){var l=_.cloneDeep(s);delete l.allOf,l["x-composed"]=!0,"undefined"!=typeof s["x-resolved-from"]&&(l["x-resolved-from"]=s["x-resolved-from"]);for(var f=0;f<n.length;f++){var a=n[f],p="self";"undefined"!=typeof a["x-resolved-from"]&&(p=a["x-resolved-from"][0]);for(var h in a)if(l.hasOwnProperty(h))if("properties"===h){var c=a[h];for(r in c){l.properties[r]=_.cloneDeep(c[r]);var d=c[r]["x-resolved-from"];"undefined"!=typeof d&&"self"!==d||(d=p),l.properties[r]["x-resolved-from"]=d}}else if("required"===h){for(var v=l.required.concat(a[h]),u=0;u<v.length;++u)for(var m=u+1;m<v.length;++m)v[u]===v[m]&&v.splice(m--,1);l.required=v}else"x-resolved-from"===h&&l["x-resolved-from"].push(p);else if(l[h]=_.cloneDeep(a[h]),"properties"===h)for(r in l[h])l[h][r]["x-resolved-from"]=p}i[o]=l}}}};


},{"./http":5,"lodash-compat/lang/cloneDeep":138,"lodash-compat/lang/isArray":140,"lodash-compat/lang/isObject":144,"lodash-compat/lang/isString":146}],7:[function(require,module,exports){
"use strict";var Helpers=require("./helpers"),_={isPlainObject:require("lodash-compat/lang/isPlainObject"),isUndefined:require("lodash-compat/lang/isUndefined"),isArray:require("lodash-compat/lang/isArray"),isObject:require("lodash-compat/lang/isObject"),isEmpty:require("lodash-compat/lang/isEmpty"),map:require("lodash-compat/collection/map"),indexOf:require("lodash-compat/array/indexOf"),cloneDeep:require("lodash-compat/lang/cloneDeep"),keys:require("lodash-compat/object/keys"),forEach:require("lodash-compat/collection/forEach")},optionHtml=module.exports.optionHtml=function(e,t){return'<tr><td class="optionName">'+e+":</td><td>"+t+"</td></tr>"};module.exports.typeFromJsonSchema=function(e,t){var i;return"integer"===e&&"int32"===t?i="integer":"integer"===e&&"int64"===t?i="long":"integer"===e&&"undefined"==typeof t?i="long":"string"===e&&"date-time"===t?i="date-time":"string"===e&&"date"===t?i="date":"number"===e&&"float"===t?i="float":"number"===e&&"double"===t?i="double":"number"===e&&"undefined"==typeof t?i="double":"boolean"===e?i="boolean":"string"===e&&(i="string"),i};var getStringSignature=module.exports.getStringSignature=function(e,t){var i="";return"undefined"!=typeof e.$ref?i+=Helpers.simpleRef(e.$ref):"undefined"==typeof e.type?i+="object":"array"===e.type?t?i+=getStringSignature(e.items||e.$ref||{}):(i+="Array[",i+=getStringSignature(e.items||e.$ref||{}),i+="]"):i+="integer"===e.type&&"int32"===e.format?"integer":"integer"===e.type&&"int64"===e.format?"long":"integer"===e.type&&"undefined"==typeof e.format?"long":"string"===e.type&&"date-time"===e.format?"date-time":"string"===e.type&&"date"===e.format?"date":"string"===e.type&&"undefined"==typeof e.format?"string":"number"===e.type&&"float"===e.format?"float":"number"===e.type&&"double"===e.format?"double":"number"===e.type&&"undefined"==typeof e.format?"double":"boolean"===e.type?"boolean":e.$ref?Helpers.simpleRef(e.$ref):e.type,i},schemaToJSON=module.exports.schemaToJSON=function(e,t,i,n){e=Helpers.resolveSchema(e),"function"!=typeof n&&(n=function(e){return(e||{})["default"]}),i=i||{};var r,o,s=e.type||"object",a=e.format;return _.isUndefined(e.example)?_.isUndefined(e.items)&&_.isArray(e["enum"])&&(o=e["enum"][0]):o=e.example,_.isUndefined(o)&&(e.$ref?(r=t[Helpers.simpleRef(e.$ref)],_.isUndefined(r)||(_.isUndefined(i[r.name])?(i[r.name]=r,o=schemaToJSON(r.definition,t,i,n),delete i[r.name]):o="array"===r.type?[]:{})):_.isUndefined(e["default"])?"string"===s?o="date-time"===a?(new Date).toISOString():"date"===a?(new Date).toISOString().split("T")[0]:"string":"integer"===s?o=0:"number"===s?o=0:"boolean"===s?o=!0:"object"===s?(o={},_.forEach(e.properties,function(e,r){var s=_.cloneDeep(e);s["default"]=n(e),o[r]=schemaToJSON(s,t,i,n)})):"array"===s&&(o=[],_.isArray(e.items)?_.forEach(e.items,function(e){o.push(schemaToJSON(e,t,i,n))}):_.isPlainObject(e.items)?o.push(schemaToJSON(e.items,t,i,n)):_.isUndefined(e.items)?o.push({}):Helpers.log("Array type's 'items' property is not an array or an object, cannot process")):o=e["default"]),o};module.exports.schemaToHTML=function(e,t,i,n){function r(e,t,n){var r,o=t;return e.$ref?(o=e.title||Helpers.simpleRef(e.$ref),r=i[o]):_.isUndefined(t)&&(o=e.title||"Inline Model "+ ++f,r={definition:e}),n!==!0&&(l[o]=_.isUndefined(r)?{}:r.definition),o}function o(e){var t='<span class="propType">',i=e.type||"object";return e.$ref?t+=r(e,Helpers.simpleRef(e.$ref)):"object"===i?t+=_.isUndefined(e.properties)?"object":r(e):"array"===i?(t+="Array[",_.isArray(e.items)?t+=_.map(e.items,r).join(","):_.isPlainObject(e.items)?t+=_.isUndefined(e.items.$ref)?_.isUndefined(e.items.type)||-1!==_.indexOf(["array","object"],e.items.type)?r(e.items):e.items.type:r(e.items,Helpers.simpleRef(e.items.$ref)):(Helpers.log("Array type's 'items' schema is not an array or an object, cannot process"),t+="object"),t+="]"):t+=e.type,t+="</span>"}function s(e,t){var i="",n=e.type||"object",r="array"===n;switch(r&&(n=_.isPlainObject(e.items)&&!_.isUndefined(e.items.type)?e.items.type:"object"),_.isUndefined(e["default"])||(i+=optionHtml("Default",e["default"])),n){case"string":e.minLength&&(i+=optionHtml("Min. Length",e.minLength)),e.maxLength&&(i+=optionHtml("Max. Length",e.maxLength)),e.pattern&&(i+=optionHtml("Reg. Exp.",e.pattern));break;case"integer":case"number":e.minimum&&(i+=optionHtml("Min. Value",e.minimum)),e.exclusiveMinimum&&(i+=optionHtml("Exclusive Min.","true")),e.maximum&&(i+=optionHtml("Max. Value",e.maximum)),e.exclusiveMaximum&&(i+=optionHtml("Exclusive Max.","true")),e.multipleOf&&(i+=optionHtml("Multiple Of",e.multipleOf))}if(r&&(e.minItems&&(i+=optionHtml("Min. Items",e.minItems)),e.maxItems&&(i+=optionHtml("Max. Items",e.maxItems)),e.uniqueItems&&(i+=optionHtml("Unique Items","true")),e.collectionFormat&&(i+=optionHtml("Coll. Format",e.collectionFormat))),_.isUndefined(e.items)&&_.isArray(e["enum"])){var o;o="number"===n||"integer"===n?e["enum"].join(", "):'"'+e["enum"].join('", "')+'"',i+=optionHtml("Enum",o)}return i.length>0&&(t='<span class="propWrap">'+t+'<table class="optionsWrapper"><tr><th colspan="2">'+n+"</th></tr>"+i+"</table></span>"),t}function a(e,t){var a=e.type||"object",l="array"===e.type,f=p+t+" "+(l?"[":"{")+m;if(t&&d.push(t),l)_.isArray(e.items)?f+="<div>"+_.map(e.items,function(e){var t=e.type||"object";return _.isUndefined(e.$ref)?_.indexOf(["array","object"],t)>-1?"object"===t&&_.isUndefined(e.properties)?"object":r(e):s(e,t):r(e,Helpers.simpleRef(e.$ref))}).join(",</div><div>"):_.isPlainObject(e.items)?f+=_.isUndefined(e.items.$ref)?_.indexOf(["array","object"],e.items.type||"object")>-1?(_.isUndefined(e.items.type)||"object"===e.items.type)&&_.isUndefined(e.items.properties)?"<div>object</div>":"<div>"+r(e.items)+"</div>":"<div>"+s(e.items,e.items.type)+"</div>":"<div>"+r(e.items,Helpers.simpleRef(e.items.$ref))+"</div>":(Helpers.log("Array type's 'items' property is not an array or an object, cannot process"),f+="<div>object</div>");else if(e.$ref)f+="<div>"+r(e,t)+"</div>";else if("object"===a){if(_.isPlainObject(e.properties)){var c=_.map(e.properties,function(t,r){var a,p,m=_.indexOf(e.required,r)>=0,l=_.cloneDeep(t),d=m?"required":"",f='<span class="propName '+d+'">'+r+"</span> (";return l["default"]=n(l),l=Helpers.resolveSchema(l),p=t.description||l.description,_.isUndefined(l.$ref)||(a=i[Helpers.simpleRef(l.$ref)],_.isUndefined(a)||-1!==_.indexOf([void 0,"array","object"],a.definition.type)||(l=Helpers.resolveSchema(a.definition))),f+=o(l),m||(f+=', <span class="propOptKey">optional</span>'),t.readOnly&&(f+=', <span class="propReadOnly">read only</span>'),f+=")",_.isUndefined(p)||(f+=': <span class="propDesc">'+p+"</span>"),l["enum"]&&(f+=' = <span class="propVals">[\''+l["enum"].join("', '")+"']</span>"),"<div"+(t.readOnly?' class="readOnly"':"")+">"+s(l,f)}).join(",</div>");c&&(f+=c+"</div>")}}else f+="<div>"+s(e,a)+"</div>";return f+p+(l?"]":"}")+m}var p='<span class="strong">',m="</span>";if(_.isObject(arguments[0])&&(e=void 0,t=arguments[0],i=arguments[1],n=arguments[2]),i=i||{},t=Helpers.resolveSchema(t),_.isEmpty(t))return p+"Empty"+m;if("string"==typeof t.$ref&&(e=Helpers.simpleRef(t.$ref),t=i[e],"undefined"==typeof t))return p+e+" is not defined!"+m;"string"!=typeof e&&(e=t.title||"Inline Model"),t.definition&&(t=t.definition),"function"!=typeof n&&(n=function(e){return(e||{})["default"]});for(var l={},d=[],f=0,c=a(t,e);_.keys(l).length>0;)_.forEach(l,function(e,t){var i=_.indexOf(d,t)>-1;delete l[t],i||(d.push(t),c+="<br />"+a(e,t))});return c};


},{"./helpers":4,"lodash-compat/array/indexOf":49,"lodash-compat/collection/forEach":54,"lodash-compat/collection/map":56,"lodash-compat/lang/cloneDeep":138,"lodash-compat/lang/isArray":140,"lodash-compat/lang/isEmpty":141,"lodash-compat/lang/isObject":144,"lodash-compat/lang/isPlainObject":145,"lodash-compat/lang/isUndefined":148,"lodash-compat/object/keys":149}],8:[function(require,module,exports){
"use strict";var SwaggerHttp=require("./http"),_={isObject:require("lodash-compat/lang/isObject")},SwaggerSpecConverter=module.exports=function(){this.errors=[],this.warnings=[],this.modelMap={}};SwaggerSpecConverter.prototype.setDocumentationLocation=function(e){this.docLocation=e},SwaggerSpecConverter.prototype.convert=function(e,t,r,i){if(!e||!Array.isArray(e.apis))return this.finish(i,null);this.clientAuthorizations=t;var s={swagger:"2.0"};s.originalVersion=e.swaggerVersion,this.apiInfo(e,s),this.securityDefinitions(e,s),e.basePath&&this.setDocumentationLocation(e.basePath);var n,o=!1;for(n=0;n<e.apis.length;n++){var a=e.apis[n];Array.isArray(a.operations)&&(o=!0)}o?(this.declaration(e,s),this.finish(i,s)):this.resourceListing(e,s,r,i)},SwaggerSpecConverter.prototype.declaration=function(e,t){var r,i,s,n;if(e.apis){0===e.basePath.indexOf("http://")?(s=e.basePath.substring("http://".length),n=s.indexOf("/"),n>0?(t.host=s.substring(0,n),t.basePath=s.substring(n)):(t.host=s,t.basePath="/")):0===e.basePath.indexOf("https://")?(s=e.basePath.substring("https://".length),n=s.indexOf("/"),n>0?(t.host=s.substring(0,n),t.basePath=s.substring(n)):(t.host=s,t.basePath="/")):t.basePath=e.basePath;var o;if(e.authorizations&&(o=e.authorizations),e.consumes&&(t.consumes=e.consumes),e.produces&&(t.produces=e.produces),_.isObject(e))for(r in e.models){var a=e.models[r],p=a.id||r;this.modelMap[p]=r}for(i=0;i<e.apis.length;i++){var u=e.apis[i],c=u.path,f=u.operations;this.operations(c,e.resourcePath,f,o,t)}var h=e.models||{};this.models(h,t)}},SwaggerSpecConverter.prototype.models=function(e,t){if(_.isObject(e)){var r;t.definitions=t.definitions||{};for(r in e){var i,s=e[r],n=[],o={properties:{}};for(i in s.properties){var a=s.properties[i],p={};this.dataType(a,p),a.description&&(p.description=a.description),a["enum"]&&(p["enum"]=a["enum"]),"boolean"==typeof a.required&&a.required===!0&&n.push(i),"string"==typeof a.required&&"true"===a.required&&n.push(i),o.properties[i]=p}n.length>0?o.required=n:o.required=s.required,t.definitions[r]=o}}},SwaggerSpecConverter.prototype.extractTag=function(e){var t=e||"default";return 0!==t.indexOf("http:")&&0!==t.indexOf("https:")||(t=t.split(["/"]),t=t[t.length-1].substring()),t.endsWith(".json")&&(t=t.substring(0,t.length-".json".length)),t.replace("/","")},SwaggerSpecConverter.prototype.operations=function(e,t,r,i,s){if(Array.isArray(r)){var n;s.paths||(s.paths={});var o=s.paths[e]||{},a=this.extractTag(t);s.tags=s.tags||[];var p=!1;for(n=0;n<s.tags.length;n++){var u=s.tags[n];u.name===a&&(p=!0)}for(p||s.tags.push({name:a}),n=0;n<r.length;n++){var c=r[n],f=(c.method||c.httpMethod).toLowerCase(),h={tags:[a]},l=c.authorizations;if(l&&0===Object.keys(l).length&&(l=i),"undefined"!=typeof l){var m;for(var d in l){h.security=h.security||[];var g=l[d];if(g){var y=[];for(var v in g)y.push(g[v].scope);m={},m[d]=y,h.security.push(m)}else m={},m[d]=[],h.security.push(m)}}c.consumes?h.consumes=c.consumes:s.consumes&&(h.consumes=s.consumes),c.produces?h.produces=c.produces:s.produces&&(h.produces=s.produces),c.summary&&(h.summary=c.summary),c.notes&&(h.description=c.notes),c.nickname&&(h.operationId=c.nickname),c.deprecated&&(h.deprecated=c.deprecated),this.authorizations(l,s),this.parameters(h,c.parameters,s),this.responseMessages(h,c,s),o[f]=h}s.paths[e]=o}},SwaggerSpecConverter.prototype.responseMessages=function(e,t){if(_.isObject(t)){var r={};this.dataType(t,r),!r.schema&&r.type&&(r={schema:r}),e.responses=e.responses||{};var i=!1;if(Array.isArray(t.responseMessages)){var s,n=t.responseMessages;for(s=0;s<n.length;s++){var o=n[s],a={description:o.message};200===o.code&&(i=!0),o.responseModel&&(a.schema={$ref:"#/definitions/"+o.responseModel}),e.responses[""+o.code]=a}}i?e.responses["default"]=r:e.responses[200]=r}},SwaggerSpecConverter.prototype.authorizations=function(e){!_.isObject(e)},SwaggerSpecConverter.prototype.parameters=function(e,t){if(Array.isArray(t)){var r;for(r=0;r<t.length;r++){var i=t[r],s={};if(s.name=i.name,s.description=i.description,s.required=i.required,s["in"]=i.paramType,"body"===s["in"]&&(s.name="body"),"form"===s["in"]&&(s["in"]="formData"),i["enum"]&&(s["enum"]=i["enum"]),i.allowMultiple===!0||"true"===i.allowMultiple){var n={};if(this.dataType(i,n),s.type="array",s.items=n,i.allowableValues){var o=i.allowableValues;"LIST"===o.valueType&&(s["enum"]=o.values)}}else this.dataType(i,s);"undefined"!=typeof i.defaultValue&&(s["default"]=i.defaultValue),e.parameters=e.parameters||[],e.parameters.push(s)}}},SwaggerSpecConverter.prototype.dataType=function(e,t){if(_.isObject(e)){e.minimum&&(t.minimum=e.minimum),e.maximum&&(t.maximum=e.maximum),e.format&&(t.format=e.format),"undefined"!=typeof e.defaultValue&&(t["default"]=e.defaultValue);var r=this.toJsonSchema(e);r&&(t=t||{},r.type&&(t.type=r.type),r.format&&(t.format=r.format),r.$ref&&(t.schema={$ref:r.$ref}),r.items&&(t.items=r.items))}},SwaggerSpecConverter.prototype.toJsonSchema=function(e){if(!e)return"object";var t=e.type||e.dataType||e.responseClass||"",r=t.toLowerCase(),i=(e.format||"").toLowerCase();if(0===r.indexOf("list[")){var s=t.substring(5,t.length-1),n=this.toJsonSchema({type:s});return{type:"array",items:n}}if("int"===r||"integer"===r&&"int32"===i)return{type:"integer",format:"int32"};if("long"===r||"integer"===r&&"int64"===i)return{type:"integer",format:"int64"};if("integer"===r)return{type:"integer",format:"int64"};if("float"===r||"number"===r&&"float"===i)return{type:"number",format:"float"};if("double"===r||"number"===r&&"double"===i)return{type:"number",format:"double"};if("string"===r&&"date-time"===i||"date"===r)return{type:"string",format:"date-time"};if("string"===r)return{type:"string"};if("file"===r)return{type:"file"};if("boolean"===r)return{type:"boolean"};if("boolean"===r)return{type:"boolean"};if("array"===r||"list"===r){if(e.items){var o=this.toJsonSchema(e.items);return{type:"array",items:o}}return{type:"array",items:{type:"object"}}}return e.$ref?{$ref:this.modelMap[e.$ref]?"#/definitions/"+this.modelMap[e.$ref]:e.$ref}:"void"===r||""===r?{}:this.modelMap[e.type]?{$ref:"#/definitions/"+this.modelMap[e.type]}:{type:e.type}},SwaggerSpecConverter.prototype.resourceListing=function(e,t,r,i){var s,n=0,o=this,a=e.apis.length,p=t,u={};r&&r.requestInterceptor&&(u.requestInterceptor=r.requestInterceptor),r&&r.responseInterceptor&&(u.responseInterceptor=r.responseInterceptor);var c="application/json";for(r&&r.swaggerRequestHeaders&&(c=r.swaggerRequestHeaders),0===a&&this.finish(i,t),s=0;a>s;s++){var f=e.apis[s],h=f.path,l=this.getAbsolutePath(e.swaggerVersion,this.docLocation,h);f.description&&(t.tags=t.tags||[],t.tags.push({name:this.extractTag(f.path),description:f.description||""}));var m={url:l,headers:{accept:c},on:{},method:"get",timeout:r.timeout};m.on.response=function(e){n+=1;var t=e.obj;t&&o.declaration(t,p),n===a&&o.finish(i,p)},m.on.error=function(e){console.error(e),n+=1,n===a&&o.finish(i,p)},this.clientAuthorizations&&"function"==typeof this.clientAuthorizations.apply&&this.clientAuthorizations.apply(m),(new SwaggerHttp).execute(m,u)}},SwaggerSpecConverter.prototype.getAbsolutePath=function(e,t,r){if("1.0"===e&&t.endsWith(".json")){var i=t.lastIndexOf("/");i>0&&(t=t.substring(0,i))}var s=t;return 0===r.indexOf("http:")||0===r.indexOf("https:")?s=r:(t.endsWith("/")&&(s=t.substring(0,t.length-1)),s+=r),s=s.replace("{format}","json")},SwaggerSpecConverter.prototype.securityDefinitions=function(e,t){if(e.authorizations){var r;for(r in e.authorizations){var i=!1,s={vendorExtensions:{}},n=e.authorizations[r];if("apiKey"===n.type)s.type="apiKey",s["in"]=n.passAs,s.name=n.keyname||r,i=!0;else if("basicAuth"===n.type)s.type="basicAuth",i=!0;else if("oauth2"===n.type){var o,a=n.scopes||[],p={};for(o in a){var u=a[o];p[u.scope]=u.description}if(s.type="oauth2",o>0&&(s.scopes=p),n.grantTypes){if(n.grantTypes.implicit){var c=n.grantTypes.implicit;s.flow="implicit",s.authorizationUrl=c.loginEndpoint,i=!0}if(n.grantTypes.authorization_code&&!s.flow){var f=n.grantTypes.authorization_code;s.flow="accessCode",s.authorizationUrl=f.tokenRequestEndpoint.url,s.tokenUrl=f.tokenEndpoint.url,i=!0}}}i&&(t.securityDefinitions=t.securityDefinitions||{},t.securityDefinitions[r]=s)}}},SwaggerSpecConverter.prototype.apiInfo=function(e,t){if(e.info){var r=e.info;t.info={},r.contact&&(t.info.contact={},t.info.contact.email=r.contact),r.description&&(t.info.description=r.description),r.title&&(t.info.title=r.title),r.termsOfServiceUrl&&(t.info.termsOfService=r.termsOfServiceUrl),(r.license||r.licenseUrl)&&(t.license={},r.license&&(t.license.name=r.license),r.licenseUrl&&(t.license.url=r.licenseUrl))}else this.warnings.push("missing info section")},SwaggerSpecConverter.prototype.finish=function(e,t){e(t)};


},{"./http":5,"lodash-compat/lang/isObject":144}],9:[function(require,module,exports){
"use strict";var log=require("../helpers").log,_={isPlainObject:require("lodash-compat/lang/isPlainObject"),isString:require("lodash-compat/lang/isString")},SchemaMarkup=require("../schema-markup.js"),jsyaml=require("js-yaml"),Model=module.exports=function(e,i,t,s){return this.definition=i||{},this.isArray="array"===i.type,this.models=t||{},this.name=e||i.title||"Inline Model",this.modelPropertyMacro=s||function(e){return e["default"]},this};Model.prototype.createJSONSample=Model.prototype.getSampleValue=function(e){return e=e||{},e[this.name]=this,this.examples&&_.isPlainObject(this.examples)&&this.examples["application/json"]?(this.definition.example=this.examples["application/json"],_.isString(this.definition.example)&&(this.definition.example=jsyaml.safeLoad(this.definition.example))):this.definition.example||(this.definition.example=this.examples),SchemaMarkup.schemaToJSON(this.definition,this.models,e,this.modelPropertyMacro)},Model.prototype.getMockSignature=function(){return SchemaMarkup.schemaToHTML(this.name,this.definition,this.models,this.modelPropertyMacro)};


},{"../helpers":4,"../schema-markup.js":7,"js-yaml":19,"lodash-compat/lang/isPlainObject":145,"lodash-compat/lang/isString":146}],10:[function(require,module,exports){
"use strict";function itemByPriority(e,t){if(_.isEmpty(t))return e[0];for(var r=0,i=t.length;i>r;r++)if(e.indexOf(t[r])>-1)return t[r];return e[0]}var _={cloneDeep:require("lodash-compat/lang/cloneDeep"),isUndefined:require("lodash-compat/lang/isUndefined"),isEmpty:require("lodash-compat/lang/isEmpty"),isObject:require("lodash-compat/lang/isObject")},helpers=require("../helpers"),Model=require("./model"),SwaggerHttp=require("../http"),Q=require("q"),Operation=module.exports=function(e,t,r,i,n,s,o,a,p){var l=[];e=e||{},s=s||{},e&&e.options&&(this.client=e.options.client||null,this.requestInterceptor=e.options.requestInterceptor||null,this.responseInterceptor=e.options.responseInterceptor||null),this.authorizations=s.security,this.basePath=e.basePath||"/",this.clientAuthorizations=p,this.consumes=s.consumes||e.consumes||["application/json"],this.produces=s.produces||e.produces||["application/json"],this.deprecated=s.deprecated,this.description=s.description,this.host=e.host,this.method=i||l.push("Operation "+r+" is missing method."),this.models=a||{},this.nickname=r||l.push("Operations must have a nickname."),this.operation=s,this.operations={},this.parameters=null!==s?s.parameters||[]:{},this.parent=e,this.path=n||l.push("Operation "+this.nickname+" is missing path."),this.responses=s.responses||{},this.scheme=t||e.scheme||"http",this.schemes=s.schemes||e.schemes,this.security=s.security||e.security,this.summary=s.summary||"",this.timeout=e.timeout,this.type=null,this.useJQuery=e.useJQuery,this.jqueryAjaxCache=e.jqueryAjaxCache,this.enableCookies=e.enableCookies;var u;if(this.host||("undefined"!=typeof window?this.host=window.location.host:this.host="localhost"),this.parameterMacro=e.parameterMacro||function(e,t){return t["default"]},this.inlineModels=[],"/"!==this.basePath&&"/"===this.basePath.slice(-1)&&(this.basePath=this.basePath.slice(0,-1)),"string"==typeof this.deprecated)switch(this.deprecated.toLowerCase()){case"true":case"yes":case"1":this.deprecated=!0;break;case"false":case"no":case"0":case null:this.deprecated=!1;break;default:this.deprecated=Boolean(this.deprecated)}var h,c;if(o)for(u in o)c=new Model(u,o[u],this.models,e.modelPropertyMacro),c&&(this.models[u]=c);else o={};for(h=0;h<this.parameters.length;h++){var d,f=this.parameters[h];f["default"]=this.parameterMacro(this,f),"array"===f.type&&(f.isList=!0,f.allowMultiple=!0);var m=this.getType(f);m&&"boolean"===m.toString().toLowerCase()&&(f.allowableValues={},f.isList=!0,f["enum"]=[!0,!1]);for(u in f)helpers.extractExtensions(u,f);"undefined"!=typeof f["x-example"]&&(d=f["x-example"],f["default"]=d),f["x-examples"]&&(d=f["x-examples"]["default"],"undefined"!=typeof d&&(f["default"]=d));var y=f["enum"]||f.items&&f.items["enum"];if("undefined"!=typeof y){var g;for(f.allowableValues={},f.allowableValues.values=[],f.allowableValues.descriptiveValues=[],g=0;g<y.length;g++){var v=y[g],b=v===f["default"]||v+""===f["default"];f.allowableValues.values.push(v),f.allowableValues.descriptiveValues.push({value:v+"",isDefault:b})}}"array"===f.type&&(m=[m],"undefined"==typeof f.allowableValues&&(delete f.isList,delete f.allowMultiple)),f.modelSignature={type:m,definitions:this.models},f.signature=this.getModelSignature(m,this.models).toString(),f.sampleJSON=this.getModelSampleJSON(m,this.models),f.responseClassSignature=f.signature}var x,O,C,w=this.responses;w[200]?(C=w[200],O="200"):w[201]?(C=w[201],O="201"):w[202]?(C=w[202],O="202"):w[203]?(C=w[203],O="203"):w[204]?(C=w[204],O="204"):w[205]?(C=w[205],O="205"):w[206]?(C=w[206],O="206"):w["default"]&&(C=w["default"],O="default");for(x in w)if(helpers.extractExtensions(x,w),"string"==typeof x&&-1===x.indexOf("x-")){var M=w[x];if("object"==typeof M&&"object"==typeof M.headers){var j=M.headers;for(var A in j){var P=j[A];if("object"==typeof P)for(var Q in P)helpers.extractExtensions(Q,P)}}}if(C)for(x in C)helpers.extractExtensions(x,C);if(C&&C.schema){var S,q=this.resolveModel(C.schema,o);delete w[O],q?(this.successResponse={},S=this.successResponse[O]=q):C.schema.type&&"object"!==C.schema.type&&"array"!==C.schema.type?(this.successResponse={},S=this.successResponse[O]=C.schema):(this.successResponse={},S=this.successResponse[O]=new Model(void 0,C.schema||{},this.models,e.modelPropertyMacro)),S&&(S.vendorExtensions=C.vendorExtensions,C.description&&(S.description=C.description),C.examples&&(S.examples=C.examples),C.headers&&(S.headers=C.headers)),this.type=C}return l.length>0&&this.resource&&this.resource.api&&this.resource.api.fail&&this.resource.api.fail(l),this};Operation.prototype.isDefaultArrayItemValue=function(e,t){return t["default"]&&Array.isArray(t["default"])?-1!==t["default"].indexOf(e):e===t["default"]},Operation.prototype.getType=function(e){var t,r=e.type,i=e.format,n=!1;"integer"===r&&"int32"===i?t="integer":"integer"===r&&"int64"===i?t="long":"integer"===r?t="integer":"string"===r?t="date-time"===i?"date-time":"date"===i?"date":"string":"number"===r&&"float"===i?t="float":"number"===r&&"double"===i?t="double":"number"===r?t="double":"boolean"===r?t="boolean":"array"===r?(n=!0,e.items&&(t=this.getType(e.items))):"file"===r&&(t="file"),e.$ref&&(t=helpers.simpleRef(e.$ref));var s=e.schema;if(s){var o=s.$ref;return o?(o=helpers.simpleRef(o),n?[o]:o):"object"===s.type?this.addInlineModel(s):this.getType(s)}return n?[t]:t},Operation.prototype.addInlineModel=function(e){var t=this.inlineModels.length,r=this.resolveModel(e,{});return r?(this.inlineModels.push(r),"Inline Model "+t):null},Operation.prototype.getInlineModel=function(e){if(/^Inline Model \d+$/.test(e)){var t=parseInt(e.substr("Inline Model".length).trim(),10),r=this.inlineModels[t];return r}return null},Operation.prototype.resolveModel=function(e,t){if("undefined"!=typeof e.$ref){var r=e.$ref;if(0===r.indexOf("#/definitions/")&&(r=r.substring("#/definitions/".length)),t[r])return new Model(r,t[r],this.models,this.parent.modelPropertyMacro)}else if(e&&"object"==typeof e&&("object"===e.type||_.isUndefined(e.type)))return new Model(void 0,e,this.models,this.parent.modelPropertyMacro);return null},Operation.prototype.help=function(e){for(var t=this.nickname+": "+this.summary+"\n",r=0;r<this.parameters.length;r++){var i=this.parameters[r],n=i.signature;t+="\n  * "+i.name+" ("+n+"): "+i.description}return"undefined"==typeof e&&helpers.log(t),t},Operation.prototype.getModelSignature=function(e,t){var r,i;return e instanceof Array&&(i=!0,e=e[0]),"undefined"==typeof e?(e="undefined",r=!0):t[e]?(e=t[e],r=!1):this.getInlineModel(e)?(e=this.getInlineModel(e),r=!1):r=!0,r?i?"Array["+e+"]":e.toString():i?"Array["+e.getMockSignature()+"]":e.getMockSignature()},Operation.prototype.supportHeaderParams=function(){return!0},Operation.prototype.supportedSubmitMethods=function(){return this.parent.supportedSubmitMethods},Operation.prototype.getHeaderParams=function(e){for(var t=this.setContentTypes(e,{}),r={},i=0;i<this.parameters.length;i++){var n=this.parameters[i];"header"===n["in"]&&(r[n.name.toLowerCase()]=n)}for(var s in e){var o=r[s.toLowerCase()];if("undefined"!=typeof o){var a=e[s];Array.isArray(a)&&(a=a.toString()),t[o.name]=a}}return t},Operation.prototype.urlify=function(e){for(var t={},r=this.path.replace(/#.*/,""),i="",n=0;n<this.parameters.length;n++){var s=this.parameters[n];if("undefined"!=typeof e[s.name])if("path"===s["in"]){var o=new RegExp("{"+s.name+"}","gi"),a=e[s.name];a=Array.isArray(a)?this.encodePathCollection(s.collectionFormat,s.name,a):this.encodePathParam(a),r=r.replace(o,a)}else if("query"===s["in"]&&"undefined"!=typeof e[s.name])if(i+=""===i&&r.indexOf("?")<0?"?":"&","undefined"!=typeof s.collectionFormat){var p=e[s.name];i+=Array.isArray(p)?this.encodeQueryCollection(s.collectionFormat,s.name,p):this.encodeQueryKey(s.name)+"="+this.encodeQueryParam(e[s.name])}else i+=this.encodeQueryKey(s.name)+"="+this.encodeQueryParam(e[s.name]);else"formData"===s["in"]&&(t[s.name]=e[s.name])}var l=this.scheme+"://"+this.host;return"/"!==this.basePath&&(l+=this.basePath),l+r+i},Operation.prototype.getMissingParams=function(e){var t,r=[];for(t=0;t<this.parameters.length;t++){var i=this.parameters[t];i.required===!0&&"undefined"==typeof e[i.name]&&(r=i.name)}return r},Operation.prototype.getBody=function(e,t){for(var r,i,n,s,o,a={},p=!1,l=0;l<this.parameters.length;l++)i=this.parameters[l],"undefined"!=typeof t[i.name]?"body"===i["in"]?n=t[i.name]:"formData"===i["in"]&&(a[i.name]={param:i,value:t[i.name]},r=!0):"body"===i["in"]&&(p=!0);if(p&&"undefined"==typeof n){var u=e["Content-Type"];u&&0===u.indexOf("application/json")&&(n="{}")}var h=!1;if(e["Content-Type"]&&e["Content-Type"].indexOf("multipart/form-data")>=0&&(h=!0),r&&!h){var c="";for(s in a)i=a[s].param,o=a[s].value,"undefined"!=typeof o&&(Array.isArray(o)?(""!==c&&(c+="&"),c+=this.encodeQueryCollection(i.collectionFormat,s,o)):(""!==c&&(c+="&"),c+=encodeURIComponent(s)+"="+encodeURIComponent(o)));n=c}else if(h){var d;if("function"==typeof FormData){d=new FormData,d.type="formData";for(s in a)if(i=a[s].param,o=t[s],"undefined"!=typeof o)if("[object File]"==={}.toString.apply(o))d.append(s,o);else if("file"===o.type&&o.value)d.append(s,o.value);else if(Array.isArray(o))if("multi"===i.collectionFormat){d["delete"](s);for(var f in o)d.append(s,o[f])}else d.append(s,this.encodeQueryCollection(i.collectionFormat,s,o).split("=").slice(1).join("="));else d.append(s,o);n=d}else{d={};for(s in a)if(o=t[s],Array.isArray(o)){var m,y=i.collectionFormat||"multi";if("ssv"===y)m=" ";else if("pipes"===y)m="|";else if("tsv"===y)m="	";else{if("multi"===y){d[s]=o;break}m=","}var g;o.forEach(function(e){g?g+=m:g="",g+=e}),d[s]=g}else d[s]=o;n=d}e["Content-Type"]="multipart/form-data"}return n},Operation.prototype.getModelSampleJSON=function(e,t){var r,i,n;if(t=t||{},r=e instanceof Array,n=r?e[0]:e,t[n]?i=t[n].createJSONSample():this.getInlineModel(n)&&(i=this.getInlineModel(n).createJSONSample()),i){if(i=r?[i]:i,"string"==typeof i)return i;if(_.isObject(i)){var s=i;if(i instanceof Array&&i.length>0&&(s=i[0]),s.nodeName&&"Node"==typeof s){var o=(new XMLSerializer).serializeToString(s);return this.formatXml(o)}return JSON.stringify(i,null,2)}return i}},Operation.prototype["do"]=function(e,t,r,i,n){return this.execute(e,t,r,i,n)},Operation.prototype.execute=function(e,t,r,i,n){var s,o,a,p,l=e||{},u={};_.isObject(t)&&(u=t,s=r,o=i),p="undefined"!=typeof u.timeout?u.timeout:this.timeout,this.client&&(u.client=this.client),!u.requestInterceptor&&this.requestInterceptor&&(u.requestInterceptor=this.requestInterceptor),!u.responseInterceptor&&this.responseInterceptor&&(u.responseInterceptor=this.responseInterceptor),"function"==typeof t&&(s=t,o=r),this.parent.usePromise?a=Q.defer():(s=s||this.parent.defaultSuccessCallback||helpers.log,o=o||this.parent.defaultErrorCallback||helpers.log),"undefined"==typeof u.useJQuery&&(u.useJQuery=this.useJQuery),"undefined"==typeof u.jqueryAjaxCache&&(u.jqueryAjaxCache=this.jqueryAjaxCache),"undefined"==typeof u.enableCookies&&(u.enableCookies=this.enableCookies);var h=this.getMissingParams(l);if(h.length>0){var c="missing required params: "+h;return helpers.fail(c),this.parent.usePromise?(a.reject(c),a.promise):(o(c,n),{})}var d,f=this.getHeaderParams(l),m=this.setContentTypes(l,u),y={};for(d in f)y[d]=f[d];for(d in m)y[d]=m[d];var g=this.getBody(m,l,u),v=this.urlify(l);if(v.indexOf(".{format}")>0&&y){var b=y.Accept||y.accept;b&&b.indexOf("json")>0?v=v.replace(".{format}",".json"):b&&b.indexOf("xml")>0&&(v=v.replace(".{format}",".xml"))}var x={url:v,method:this.method.toUpperCase(),body:g,enableCookies:u.enableCookies,useJQuery:u.useJQuery,jqueryAjaxCache:u.jqueryAjaxCache,deferred:a,headers:y,clientAuthorizations:u.clientAuthorizations,on:{response:function(e){return a?(a.resolve(e),a.promise):s(e,n)},error:function(e){return a?(a.reject(e),a.promise):o(e,n)}}};return p&&(x.timeout=p),this.clientAuthorizations.apply(x,this.operation.security),u.mock===!0?x:(new SwaggerHttp).execute(x,u)},Operation.prototype.setContentTypes=function(e,t){var r,i,n=this.parameters,s=e.parameterContentType||itemByPriority(this.consumes,["application/json","application/yaml"]),o=t.responseContentType||itemByPriority(this.produces,["application/json","application/yaml"]),a=[],p=[],l={};for(i=0;i<n.length;i++){var u=n[i];if("formData"===u["in"])"file"===u.type?a.push(u):p.push(u);else if("header"===u["in"]&&t){var h=u.name,c=t[u.name];"undefined"!=typeof t[u.name]&&(l[h]=c)}else"body"===u["in"]&&"undefined"!=typeof e[u.name]&&(r=e[u.name])}var d=r||a.length||p.length;if("post"===this.method||"put"===this.method||"patch"===this.method||("delete"===this.method||"get"===this.method)&&d){if(t.requestContentType&&(s=t.requestContentType),p.length>0){if(s=void 0,t.requestContentType)s=t.requestContentType;else if(a.length>0)s="multipart/form-data";else if(this.consumes&&this.consumes.length>0)for(var f in this.consumes){var m=this.consumes[f];0!==m.indexOf("application/x-www-form-urlencoded")&&0!==m.indexOf("multipart/form-data")||(s=m)}"undefined"==typeof s&&(s="application/x-www-form-urlencoded")}}else s=null;return s&&this.consumes&&-1===this.consumes.indexOf(s)&&helpers.log("server doesn't consume "+s+", try "+JSON.stringify(this.consumes)),this.matchesAccept(o)||helpers.log("server can't produce "+o),s&&""!==r||"application/x-www-form-urlencoded"===s?l["Content-Type"]=s:this.consumes&&this.consumes.length>0&&"application/x-www-form-urlencoded"===this.consumes[0]&&(l["Content-Type"]=this.consumes[0]),o&&(l.Accept=o),l},Operation.prototype.matchesAccept=function(e){return e&&this.produces?-1!==this.produces.indexOf(e)||-1!==this.produces.indexOf("*/*"):!0},Operation.prototype.asCurl=function(e,t){var r={mock:!0};if("object"==typeof t)for(var i in t)r[i]=t[i];var n=this.execute(e,r);this.clientAuthorizations.apply(n,this.operation.security);var s=[];if(s.push("-X "+this.method.toUpperCase()),"undefined"!=typeof n.headers){var o;for(o in n.headers){var a=n.headers[o];"string"==typeof a&&(a=a.replace(/\'/g,"\\u0027")),s.push("--header '"+o+": "+a+"'")}}var p=!1,l=!1,u=n.headers["Content-Type"];if(u&&0===u.indexOf("application/x-www-form-urlencoded")?p=!0:u&&0===u.indexOf("multipart/form-data")&&(p=!0,l=!0),n.body){var h;if(_.isObject(n.body)){if(l){l=!0;for(var c=0;c<this.parameters.length;c++){var d=this.parameters[c];if("formData"===d["in"]){h||(h="");var f;if(f="function"==typeof FormData&&n.body instanceof FormData?n.body.getAll(d.name):n.body[d.name])if("file"===d.type)f.name&&(h+="-F "+d.name+'=@"'+f.name+'" ');else if(Array.isArray(f))if("multi"===d.collectionFormat)for(var m in f)h+="-F "+this.encodeQueryKey(d.name)+"="+f[m]+" ";else h+="-F "+this.encodeQueryCollection(d.collectionFormat,d.name,f)+" ";else h+="-F "+this.encodeQueryKey(d.name)+"="+f+" "}}}h||(h=JSON.stringify(n.body))}else h=n.body;h=h.replace(/\'/g,"%27").replace(/\n/g," \\ \n "),p||(h=h.replace(/&/g,"%26")),l?s.push(h):s.push("-d '"+h.replace(/@/g,"%40")+"'")}return"curl "+s.join(" ")+" '"+n.url+"'"},Operation.prototype.encodePathCollection=function(e,t,r){var i,n="",s="";for(s="ssv"===e?"%20":"tsv"===e?"%09":"pipes"===e?"|":",",i=0;i<r.length;i++)0===i?n=this.encodeQueryParam(r[i]):n+=s+this.encodeQueryParam(r[i]);return n},Operation.prototype.encodeQueryCollection=function(e,t,r){var i,n="";if(e=e||"default","default"===e||"multi"===e)for(i=0;i<r.length;i++)i>0&&(n+="&"),n+=this.encodeQueryKey(t)+"="+this.encodeQueryParam(r[i]);else{var s="";if("csv"===e)s=",";else if("ssv"===e)s="%20";else if("tsv"===e)s="%09";else if("pipes"===e)s="|";else if("brackets"===e)for(i=0;i<r.length;i++)0!==i&&(n+="&"),n+=this.encodeQueryKey(t)+"[]="+this.encodeQueryParam(r[i]);if(""!==s)for(i=0;i<r.length;i++)0===i?n=this.encodeQueryKey(t)+"="+this.encodeQueryParam(r[i]):n+=s+this.encodeQueryParam(r[i])}return n},Operation.prototype.encodeQueryKey=function(e){return encodeURIComponent(e).replace("%5B","[").replace("%5D","]").replace("%24","$")},Operation.prototype.encodeQueryParam=function(e){return encodeURIComponent(e)},Operation.prototype.encodePathParam=function(e){return encodeURIComponent(e)};


},{"../helpers":4,"../http":5,"./model":9,"lodash-compat/lang/cloneDeep":138,"lodash-compat/lang/isEmpty":141,"lodash-compat/lang/isObject":144,"lodash-compat/lang/isUndefined":148,"q":157}],11:[function(require,module,exports){
"use strict";var OperationGroup=module.exports=function(t,o,i,r){this.description=o,this.externalDocs=i,this.name=t,this.operation=r,this.operationsArray=[],this.path=t,this.tag=t};OperationGroup.prototype.sort=function(){};


},{}],12:[function(require,module,exports){
function drainQueue(){if(!draining){draining=!0;for(var e,o=queue.length;o;){e=queue,queue=[];for(var r=-1;++r<o;)e[r]();o=queue.length}draining=!1}}function noop(){}var process=module.exports={},queue=[],draining=!1;process.nextTick=function(e){queue.push(e),draining||setTimeout(drainQueue,0)},process.title="browser",process.browser=!0,process.env={},process.argv=[],process.version="",process.versions={},process.on=noop,process.addListener=noop,process.once=noop,process.off=noop,process.removeListener=noop,process.removeAllListeners=noop,process.emit=noop,process.binding=function(e){throw new Error("process.binding is not supported")},process.cwd=function(){return"/"},process.chdir=function(e){throw new Error("process.chdir is not supported")},process.umask=function(){return 0};


},{}],13:[function(require,module,exports){
(function (Buffer){
!function(){"use strict";function n(n){var t;return t=n instanceof Buffer?n:new Buffer(n.toString(),"binary"),t.toString("base64")}module.exports=n}();


}).call(this,require("buffer").Buffer)
},{"buffer":14}],14:[function(require,module,exports){
function kMaxLength(){return Buffer.TYPED_ARRAY_SUPPORT?2147483647:1073741823}function Buffer(t){return this instanceof Buffer?(this.length=0,this.parent=void 0,"number"==typeof t?fromNumber(this,t):"string"==typeof t?fromString(this,t,arguments.length>1?arguments[1]:"utf8"):fromObject(this,t)):arguments.length>1?new Buffer(t,arguments[1]):new Buffer(t)}function fromNumber(t,e){if(t=allocate(t,0>e?0:0|checked(e)),!Buffer.TYPED_ARRAY_SUPPORT)for(var r=0;e>r;r++)t[r]=0;return t}function fromString(t,e,r){"string"==typeof r&&""!==r||(r="utf8");var n=0|byteLength(e,r);return t=allocate(t,n),t.write(e,r),t}function fromObject(t,e){if(Buffer.isBuffer(e))return fromBuffer(t,e);if(isArray(e))return fromArray(t,e);if(null==e)throw new TypeError("must start with number, buffer, array or string");if("undefined"!=typeof ArrayBuffer){if(e.buffer instanceof ArrayBuffer)return fromTypedArray(t,e);if(e instanceof ArrayBuffer)return fromArrayBuffer(t,e)}return e.length?fromArrayLike(t,e):fromJsonObject(t,e)}function fromBuffer(t,e){var r=0|checked(e.length);return t=allocate(t,r),e.copy(t,0,0,r),t}function fromArray(t,e){var r=0|checked(e.length);t=allocate(t,r);for(var n=0;r>n;n+=1)t[n]=255&e[n];return t}function fromTypedArray(t,e){var r=0|checked(e.length);t=allocate(t,r);for(var n=0;r>n;n+=1)t[n]=255&e[n];return t}function fromArrayBuffer(t,e){return Buffer.TYPED_ARRAY_SUPPORT?(e.byteLength,t=Buffer._augment(new Uint8Array(e))):t=fromTypedArray(t,new Uint8Array(e)),t}function fromArrayLike(t,e){var r=0|checked(e.length);t=allocate(t,r);for(var n=0;r>n;n+=1)t[n]=255&e[n];return t}function fromJsonObject(t,e){var r,n=0;"Buffer"===e.type&&isArray(e.data)&&(r=e.data,n=0|checked(r.length)),t=allocate(t,n);for(var i=0;n>i;i+=1)t[i]=255&r[i];return t}function allocate(t,e){Buffer.TYPED_ARRAY_SUPPORT?t=Buffer._augment(new Uint8Array(e)):(t.length=e,t._isBuffer=!0);var r=0!==e&&e<=Buffer.poolSize>>>1;return r&&(t.parent=rootParent),t}function checked(t){if(t>=kMaxLength())throw new RangeError("Attempt to allocate Buffer larger than maximum size: 0x"+kMaxLength().toString(16)+" bytes");return 0|t}function SlowBuffer(t,e){if(!(this instanceof SlowBuffer))return new SlowBuffer(t,e);var r=new Buffer(t,e);return delete r.parent,r}function byteLength(t,e){"string"!=typeof t&&(t=""+t);var r=t.length;if(0===r)return 0;for(var n=!1;;)switch(e){case"ascii":case"binary":case"raw":case"raws":return r;case"utf8":case"utf-8":return utf8ToBytes(t).length;case"ucs2":case"ucs-2":case"utf16le":case"utf-16le":return 2*r;case"hex":return r>>>1;case"base64":return base64ToBytes(t).length;default:if(n)return utf8ToBytes(t).length;e=(""+e).toLowerCase(),n=!0}}function slowToString(t,e,r){var n=!1;if(e=0|e,r=void 0===r||r===1/0?this.length:0|r,t||(t="utf8"),0>e&&(e=0),r>this.length&&(r=this.length),e>=r)return"";for(;;)switch(t){case"hex":return hexSlice(this,e,r);case"utf8":case"utf-8":return utf8Slice(this,e,r);case"ascii":return asciiSlice(this,e,r);case"binary":return binarySlice(this,e,r);case"base64":return base64Slice(this,e,r);case"ucs2":case"ucs-2":case"utf16le":case"utf-16le":return utf16leSlice(this,e,r);default:if(n)throw new TypeError("Unknown encoding: "+t);t=(t+"").toLowerCase(),n=!0}}function hexWrite(t,e,r,n){r=Number(r)||0;var i=t.length-r;n?(n=Number(n),n>i&&(n=i)):n=i;var f=e.length;if(f%2!==0)throw new Error("Invalid hex string");n>f/2&&(n=f/2);for(var o=0;n>o;o++){var u=parseInt(e.substr(2*o,2),16);if(isNaN(u))throw new Error("Invalid hex string");t[r+o]=u}return o}function utf8Write(t,e,r,n){return blitBuffer(utf8ToBytes(e,t.length-r),t,r,n)}function asciiWrite(t,e,r,n){return blitBuffer(asciiToBytes(e),t,r,n)}function binaryWrite(t,e,r,n){return asciiWrite(t,e,r,n)}function base64Write(t,e,r,n){return blitBuffer(base64ToBytes(e),t,r,n)}function ucs2Write(t,e,r,n){return blitBuffer(utf16leToBytes(e,t.length-r),t,r,n)}function base64Slice(t,e,r){return 0===e&&r===t.length?base64.fromByteArray(t):base64.fromByteArray(t.slice(e,r))}function utf8Slice(t,e,r){r=Math.min(t.length,r);for(var n=[],i=e;r>i;){var f=t[i],o=null,u=f>239?4:f>223?3:f>191?2:1;if(r>=i+u){var s,a,h,c;switch(u){case 1:128>f&&(o=f);break;case 2:s=t[i+1],128===(192&s)&&(c=(31&f)<<6|63&s,c>127&&(o=c));break;case 3:s=t[i+1],a=t[i+2],128===(192&s)&&128===(192&a)&&(c=(15&f)<<12|(63&s)<<6|63&a,c>2047&&(55296>c||c>57343)&&(o=c));break;case 4:s=t[i+1],a=t[i+2],h=t[i+3],128===(192&s)&&128===(192&a)&&128===(192&h)&&(c=(15&f)<<18|(63&s)<<12|(63&a)<<6|63&h,c>65535&&1114112>c&&(o=c))}}null===o?(o=65533,u=1):o>65535&&(o-=65536,n.push(o>>>10&1023|55296),o=56320|1023&o),n.push(o),i+=u}return decodeCodePointsArray(n)}function decodeCodePointsArray(t){var e=t.length;if(MAX_ARGUMENTS_LENGTH>=e)return String.fromCharCode.apply(String,t);for(var r="",n=0;e>n;)r+=String.fromCharCode.apply(String,t.slice(n,n+=MAX_ARGUMENTS_LENGTH));return r}function asciiSlice(t,e,r){var n="";r=Math.min(t.length,r);for(var i=e;r>i;i++)n+=String.fromCharCode(127&t[i]);return n}function binarySlice(t,e,r){var n="";r=Math.min(t.length,r);for(var i=e;r>i;i++)n+=String.fromCharCode(t[i]);return n}function hexSlice(t,e,r){var n=t.length;(!e||0>e)&&(e=0),(!r||0>r||r>n)&&(r=n);for(var i="",f=e;r>f;f++)i+=toHex(t[f]);return i}function utf16leSlice(t,e,r){for(var n=t.slice(e,r),i="",f=0;f<n.length;f+=2)i+=String.fromCharCode(n[f]+256*n[f+1]);return i}function checkOffset(t,e,r){if(t%1!==0||0>t)throw new RangeError("offset is not uint");if(t+e>r)throw new RangeError("Trying to access beyond buffer length")}function checkInt(t,e,r,n,i,f){if(!Buffer.isBuffer(t))throw new TypeError("buffer must be a Buffer instance");if(e>i||f>e)throw new RangeError("value is out of bounds");if(r+n>t.length)throw new RangeError("index out of range")}function objectWriteUInt16(t,e,r,n){0>e&&(e=65535+e+1);for(var i=0,f=Math.min(t.length-r,2);f>i;i++)t[r+i]=(e&255<<8*(n?i:1-i))>>>8*(n?i:1-i)}function objectWriteUInt32(t,e,r,n){0>e&&(e=4294967295+e+1);for(var i=0,f=Math.min(t.length-r,4);f>i;i++)t[r+i]=e>>>8*(n?i:3-i)&255}function checkIEEE754(t,e,r,n,i,f){if(e>i||f>e)throw new RangeError("value is out of bounds");if(r+n>t.length)throw new RangeError("index out of range");if(0>r)throw new RangeError("index out of range")}function writeFloat(t,e,r,n,i){return i||checkIEEE754(t,e,r,4,3.4028234663852886e38,-3.4028234663852886e38),ieee754.write(t,e,r,n,23,4),r+4}function writeDouble(t,e,r,n,i){return i||checkIEEE754(t,e,r,8,1.7976931348623157e308,-1.7976931348623157e308),ieee754.write(t,e,r,n,52,8),r+8}function base64clean(t){if(t=stringtrim(t).replace(INVALID_BASE64_RE,""),t.length<2)return"";for(;t.length%4!==0;)t+="=";return t}function stringtrim(t){return t.trim?t.trim():t.replace(/^\s+|\s+$/g,"")}function toHex(t){return 16>t?"0"+t.toString(16):t.toString(16)}function utf8ToBytes(t,e){e=e||1/0;for(var r,n=t.length,i=null,f=[],o=0;n>o;o++){if(r=t.charCodeAt(o),r>55295&&57344>r){if(!i){if(r>56319){(e-=3)>-1&&f.push(239,191,189);continue}if(o+1===n){(e-=3)>-1&&f.push(239,191,189);continue}i=r;continue}if(56320>r){(e-=3)>-1&&f.push(239,191,189),i=r;continue}r=i-55296<<10|r-56320|65536}else i&&(e-=3)>-1&&f.push(239,191,189);if(i=null,128>r){if((e-=1)<0)break;f.push(r)}else if(2048>r){if((e-=2)<0)break;f.push(r>>6|192,63&r|128)}else if(65536>r){if((e-=3)<0)break;f.push(r>>12|224,r>>6&63|128,63&r|128)}else{if(!(1114112>r))throw new Error("Invalid code point");if((e-=4)<0)break;f.push(r>>18|240,r>>12&63|128,r>>6&63|128,63&r|128)}}return f}function asciiToBytes(t){for(var e=[],r=0;r<t.length;r++)e.push(255&t.charCodeAt(r));return e}function utf16leToBytes(t,e){for(var r,n,i,f=[],o=0;o<t.length&&!((e-=2)<0);o++)r=t.charCodeAt(o),n=r>>8,i=r%256,f.push(i),f.push(n);return f}function base64ToBytes(t){return base64.toByteArray(base64clean(t))}function blitBuffer(t,e,r,n){for(var i=0;n>i&&!(i+r>=e.length||i>=t.length);i++)e[i+r]=t[i];return i}var base64=require("base64-js"),ieee754=require("ieee754"),isArray=require("is-array");exports.Buffer=Buffer,exports.SlowBuffer=SlowBuffer,exports.INSPECT_MAX_BYTES=50,Buffer.poolSize=8192;var rootParent={};Buffer.TYPED_ARRAY_SUPPORT=function(){function t(){}try{var e=new Uint8Array(1);return e.foo=function(){return 42},e.constructor=t,42===e.foo()&&e.constructor===t&&"function"==typeof e.subarray&&0===e.subarray(1,1).byteLength}catch(r){return!1}}(),Buffer.isBuffer=function(t){return!(null==t||!t._isBuffer)},Buffer.compare=function(t,e){if(!Buffer.isBuffer(t)||!Buffer.isBuffer(e))throw new TypeError("Arguments must be Buffers");if(t===e)return 0;for(var r=t.length,n=e.length,i=0,f=Math.min(r,n);f>i&&t[i]===e[i];)++i;return i!==f&&(r=t[i],n=e[i]),n>r?-1:r>n?1:0},Buffer.isEncoding=function(t){switch(String(t).toLowerCase()){case"hex":case"utf8":case"utf-8":case"ascii":case"binary":case"base64":case"raw":case"ucs2":case"ucs-2":case"utf16le":case"utf-16le":return!0;default:return!1}},Buffer.concat=function(t,e){if(!isArray(t))throw new TypeError("list argument must be an Array of Buffers.");if(0===t.length)return new Buffer(0);var r;if(void 0===e)for(e=0,r=0;r<t.length;r++)e+=t[r].length;var n=new Buffer(e),i=0;for(r=0;r<t.length;r++){var f=t[r];f.copy(n,i),i+=f.length}return n},Buffer.byteLength=byteLength,Buffer.prototype.length=void 0,Buffer.prototype.parent=void 0,Buffer.prototype.toString=function(){var t=0|this.length;return 0===t?"":0===arguments.length?utf8Slice(this,0,t):slowToString.apply(this,arguments)},Buffer.prototype.equals=function(t){if(!Buffer.isBuffer(t))throw new TypeError("Argument must be a Buffer");return this===t?!0:0===Buffer.compare(this,t)},Buffer.prototype.inspect=function(){var t="",e=exports.INSPECT_MAX_BYTES;return this.length>0&&(t=this.toString("hex",0,e).match(/.{2}/g).join(" "),this.length>e&&(t+=" ... ")),"<Buffer "+t+">"},Buffer.prototype.compare=function(t){if(!Buffer.isBuffer(t))throw new TypeError("Argument must be a Buffer");return this===t?0:Buffer.compare(this,t)},Buffer.prototype.indexOf=function(t,e){function r(t,e,r){for(var n=-1,i=0;r+i<t.length;i++)if(t[r+i]===e[-1===n?0:i-n]){if(-1===n&&(n=i),i-n+1===e.length)return r+n}else n=-1;return-1}if(e>2147483647?e=2147483647:-2147483648>e&&(e=-2147483648),e>>=0,0===this.length)return-1;if(e>=this.length)return-1;if(0>e&&(e=Math.max(this.length+e,0)),"string"==typeof t)return 0===t.length?-1:String.prototype.indexOf.call(this,t,e);if(Buffer.isBuffer(t))return r(this,t,e);if("number"==typeof t)return Buffer.TYPED_ARRAY_SUPPORT&&"function"===Uint8Array.prototype.indexOf?Uint8Array.prototype.indexOf.call(this,t,e):r(this,[t],e);throw new TypeError("val must be string, number or Buffer")},Buffer.prototype.get=function(t){return console.log(".get() is deprecated. Access using array indexes instead."),this.readUInt8(t)},Buffer.prototype.set=function(t,e){return console.log(".set() is deprecated. Access using array indexes instead."),this.writeUInt8(t,e)},Buffer.prototype.write=function(t,e,r,n){if(void 0===e)n="utf8",r=this.length,e=0;else if(void 0===r&&"string"==typeof e)n=e,r=this.length,e=0;else if(isFinite(e))e=0|e,isFinite(r)?(r=0|r,void 0===n&&(n="utf8")):(n=r,r=void 0);else{var i=n;n=e,e=0|r,r=i}var f=this.length-e;if((void 0===r||r>f)&&(r=f),t.length>0&&(0>r||0>e)||e>this.length)throw new RangeError("attempt to write outside buffer bounds");n||(n="utf8");for(var o=!1;;)switch(n){case"hex":return hexWrite(this,t,e,r);case"utf8":case"utf-8":return utf8Write(this,t,e,r);case"ascii":return asciiWrite(this,t,e,r);case"binary":return binaryWrite(this,t,e,r);case"base64":return base64Write(this,t,e,r);case"ucs2":case"ucs-2":case"utf16le":case"utf-16le":return ucs2Write(this,t,e,r);default:if(o)throw new TypeError("Unknown encoding: "+n);n=(""+n).toLowerCase(),o=!0}},Buffer.prototype.toJSON=function(){return{type:"Buffer",data:Array.prototype.slice.call(this._arr||this,0)}};var MAX_ARGUMENTS_LENGTH=4096;Buffer.prototype.slice=function(t,e){var r=this.length;t=~~t,e=void 0===e?r:~~e,0>t?(t+=r,0>t&&(t=0)):t>r&&(t=r),0>e?(e+=r,0>e&&(e=0)):e>r&&(e=r),t>e&&(e=t);var n;if(Buffer.TYPED_ARRAY_SUPPORT)n=Buffer._augment(this.subarray(t,e));else{var i=e-t;n=new Buffer(i,void 0);for(var f=0;i>f;f++)n[f]=this[f+t]}return n.length&&(n.parent=this.parent||this),n},Buffer.prototype.readUIntLE=function(t,e,r){t=0|t,e=0|e,r||checkOffset(t,e,this.length);for(var n=this[t],i=1,f=0;++f<e&&(i*=256);)n+=this[t+f]*i;return n},Buffer.prototype.readUIntBE=function(t,e,r){t=0|t,e=0|e,r||checkOffset(t,e,this.length);for(var n=this[t+--e],i=1;e>0&&(i*=256);)n+=this[t+--e]*i;return n},Buffer.prototype.readUInt8=function(t,e){return e||checkOffset(t,1,this.length),this[t]},Buffer.prototype.readUInt16LE=function(t,e){return e||checkOffset(t,2,this.length),this[t]|this[t+1]<<8},Buffer.prototype.readUInt16BE=function(t,e){return e||checkOffset(t,2,this.length),this[t]<<8|this[t+1]},Buffer.prototype.readUInt32LE=function(t,e){return e||checkOffset(t,4,this.length),(this[t]|this[t+1]<<8|this[t+2]<<16)+16777216*this[t+3]},Buffer.prototype.readUInt32BE=function(t,e){return e||checkOffset(t,4,this.length),16777216*this[t]+(this[t+1]<<16|this[t+2]<<8|this[t+3])},Buffer.prototype.readIntLE=function(t,e,r){t=0|t,e=0|e,r||checkOffset(t,e,this.length);for(var n=this[t],i=1,f=0;++f<e&&(i*=256);)n+=this[t+f]*i;return i*=128,n>=i&&(n-=Math.pow(2,8*e)),n},Buffer.prototype.readIntBE=function(t,e,r){t=0|t,e=0|e,r||checkOffset(t,e,this.length);for(var n=e,i=1,f=this[t+--n];n>0&&(i*=256);)f+=this[t+--n]*i;return i*=128,f>=i&&(f-=Math.pow(2,8*e)),f},Buffer.prototype.readInt8=function(t,e){return e||checkOffset(t,1,this.length),128&this[t]?-1*(255-this[t]+1):this[t]},Buffer.prototype.readInt16LE=function(t,e){e||checkOffset(t,2,this.length);var r=this[t]|this[t+1]<<8;return 32768&r?4294901760|r:r},Buffer.prototype.readInt16BE=function(t,e){e||checkOffset(t,2,this.length);var r=this[t+1]|this[t]<<8;return 32768&r?4294901760|r:r},Buffer.prototype.readInt32LE=function(t,e){return e||checkOffset(t,4,this.length),this[t]|this[t+1]<<8|this[t+2]<<16|this[t+3]<<24},Buffer.prototype.readInt32BE=function(t,e){return e||checkOffset(t,4,this.length),this[t]<<24|this[t+1]<<16|this[t+2]<<8|this[t+3]},Buffer.prototype.readFloatLE=function(t,e){return e||checkOffset(t,4,this.length),ieee754.read(this,t,!0,23,4)},Buffer.prototype.readFloatBE=function(t,e){return e||checkOffset(t,4,this.length),ieee754.read(this,t,!1,23,4)},Buffer.prototype.readDoubleLE=function(t,e){return e||checkOffset(t,8,this.length),ieee754.read(this,t,!0,52,8)},Buffer.prototype.readDoubleBE=function(t,e){return e||checkOffset(t,8,this.length),ieee754.read(this,t,!1,52,8)},Buffer.prototype.writeUIntLE=function(t,e,r,n){t=+t,e=0|e,r=0|r,n||checkInt(this,t,e,r,Math.pow(2,8*r),0);var i=1,f=0;for(this[e]=255&t;++f<r&&(i*=256);)this[e+f]=t/i&255;return e+r},Buffer.prototype.writeUIntBE=function(t,e,r,n){t=+t,e=0|e,r=0|r,n||checkInt(this,t,e,r,Math.pow(2,8*r),0);var i=r-1,f=1;for(this[e+i]=255&t;--i>=0&&(f*=256);)this[e+i]=t/f&255;return e+r},Buffer.prototype.writeUInt8=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,1,255,0),Buffer.TYPED_ARRAY_SUPPORT||(t=Math.floor(t)),this[e]=t,e+1},Buffer.prototype.writeUInt16LE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,2,65535,0),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t,this[e+1]=t>>>8):objectWriteUInt16(this,t,e,!0),e+2},Buffer.prototype.writeUInt16BE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,2,65535,0),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t>>>8,this[e+1]=t):objectWriteUInt16(this,t,e,!1),e+2},Buffer.prototype.writeUInt32LE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,4,4294967295,0),Buffer.TYPED_ARRAY_SUPPORT?(this[e+3]=t>>>24,this[e+2]=t>>>16,this[e+1]=t>>>8,this[e]=t):objectWriteUInt32(this,t,e,!0),e+4},Buffer.prototype.writeUInt32BE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,4,4294967295,0),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t>>>24,this[e+1]=t>>>16,this[e+2]=t>>>8,this[e+3]=t):objectWriteUInt32(this,t,e,!1),e+4},Buffer.prototype.writeIntLE=function(t,e,r,n){if(t=+t,e=0|e,!n){var i=Math.pow(2,8*r-1);checkInt(this,t,e,r,i-1,-i)}var f=0,o=1,u=0>t?1:0;for(this[e]=255&t;++f<r&&(o*=256);)this[e+f]=(t/o>>0)-u&255;return e+r},Buffer.prototype.writeIntBE=function(t,e,r,n){if(t=+t,e=0|e,!n){var i=Math.pow(2,8*r-1);checkInt(this,t,e,r,i-1,-i)}var f=r-1,o=1,u=0>t?1:0;for(this[e+f]=255&t;--f>=0&&(o*=256);)this[e+f]=(t/o>>0)-u&255;return e+r},Buffer.prototype.writeInt8=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,1,127,-128),Buffer.TYPED_ARRAY_SUPPORT||(t=Math.floor(t)),0>t&&(t=255+t+1),this[e]=t,e+1},Buffer.prototype.writeInt16LE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,2,32767,-32768),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t,this[e+1]=t>>>8):objectWriteUInt16(this,t,e,!0),e+2},Buffer.prototype.writeInt16BE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,2,32767,-32768),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t>>>8,this[e+1]=t):objectWriteUInt16(this,t,e,!1),e+2},Buffer.prototype.writeInt32LE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,4,2147483647,-2147483648),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t,this[e+1]=t>>>8,this[e+2]=t>>>16,this[e+3]=t>>>24):objectWriteUInt32(this,t,e,!0),e+4},Buffer.prototype.writeInt32BE=function(t,e,r){return t=+t,e=0|e,r||checkInt(this,t,e,4,2147483647,-2147483648),0>t&&(t=4294967295+t+1),Buffer.TYPED_ARRAY_SUPPORT?(this[e]=t>>>24,this[e+1]=t>>>16,this[e+2]=t>>>8,this[e+3]=t):objectWriteUInt32(this,t,e,!1),e+4},Buffer.prototype.writeFloatLE=function(t,e,r){return writeFloat(this,t,e,!0,r)},Buffer.prototype.writeFloatBE=function(t,e,r){return writeFloat(this,t,e,!1,r)},Buffer.prototype.writeDoubleLE=function(t,e,r){return writeDouble(this,t,e,!0,r)},Buffer.prototype.writeDoubleBE=function(t,e,r){return writeDouble(this,t,e,!1,r)},Buffer.prototype.copy=function(t,e,r,n){if(r||(r=0),n||0===n||(n=this.length),e>=t.length&&(e=t.length),e||(e=0),n>0&&r>n&&(n=r),n===r)return 0;if(0===t.length||0===this.length)return 0;if(0>e)throw new RangeError("targetStart out of bounds");if(0>r||r>=this.length)throw new RangeError("sourceStart out of bounds");if(0>n)throw new RangeError("sourceEnd out of bounds");n>this.length&&(n=this.length),t.length-e<n-r&&(n=t.length-e+r);var i,f=n-r;if(this===t&&e>r&&n>e)for(i=f-1;i>=0;i--)t[i+e]=this[i+r];else if(1e3>f||!Buffer.TYPED_ARRAY_SUPPORT)for(i=0;f>i;i++)t[i+e]=this[i+r];else t._set(this.subarray(r,r+f),e);return f},Buffer.prototype.fill=function(t,e,r){if(t||(t=0),e||(e=0),r||(r=this.length),e>r)throw new RangeError("end < start");if(r!==e&&0!==this.length){if(0>e||e>=this.length)throw new RangeError("start out of bounds");if(0>r||r>this.length)throw new RangeError("end out of bounds");var n;if("number"==typeof t)for(n=e;r>n;n++)this[n]=t;else{var i=utf8ToBytes(t.toString()),f=i.length;for(n=e;r>n;n++)this[n]=i[n%f]}return this}},Buffer.prototype.toArrayBuffer=function(){if("undefined"!=typeof Uint8Array){if(Buffer.TYPED_ARRAY_SUPPORT)return new Buffer(this).buffer;for(var t=new Uint8Array(this.length),e=0,r=t.length;r>e;e+=1)t[e]=this[e];return t.buffer}throw new TypeError("Buffer.toArrayBuffer not supported in this browser")};var BP=Buffer.prototype;Buffer._augment=function(t){return t.constructor=Buffer,t._isBuffer=!0,t._set=t.set,t.get=BP.get,t.set=BP.set,t.write=BP.write,t.toString=BP.toString,t.toLocaleString=BP.toString,t.toJSON=BP.toJSON,t.equals=BP.equals,t.compare=BP.compare,t.indexOf=BP.indexOf,t.copy=BP.copy,t.slice=BP.slice,t.readUIntLE=BP.readUIntLE,t.readUIntBE=BP.readUIntBE,t.readUInt8=BP.readUInt8,t.readUInt16LE=BP.readUInt16LE,t.readUInt16BE=BP.readUInt16BE,t.readUInt32LE=BP.readUInt32LE,t.readUInt32BE=BP.readUInt32BE,t.readIntLE=BP.readIntLE,t.readIntBE=BP.readIntBE,t.readInt8=BP.readInt8,t.readInt16LE=BP.readInt16LE,t.readInt16BE=BP.readInt16BE,t.readInt32LE=BP.readInt32LE,t.readInt32BE=BP.readInt32BE,t.readFloatLE=BP.readFloatLE,t.readFloatBE=BP.readFloatBE,t.readDoubleLE=BP.readDoubleLE,t.readDoubleBE=BP.readDoubleBE,t.writeUInt8=BP.writeUInt8,t.writeUIntLE=BP.writeUIntLE,t.writeUIntBE=BP.writeUIntBE,t.writeUInt16LE=BP.writeUInt16LE,t.writeUInt16BE=BP.writeUInt16BE,t.writeUInt32LE=BP.writeUInt32LE,t.writeUInt32BE=BP.writeUInt32BE,t.writeIntLE=BP.writeIntLE,t.writeIntBE=BP.writeIntBE,t.writeInt8=BP.writeInt8,t.writeInt16LE=BP.writeInt16LE,t.writeInt16BE=BP.writeInt16BE,t.writeInt32LE=BP.writeInt32LE,t.writeInt32BE=BP.writeInt32BE,t.writeFloatLE=BP.writeFloatLE,t.writeFloatBE=BP.writeFloatBE,t.writeDoubleLE=BP.writeDoubleLE,t.writeDoubleBE=BP.writeDoubleBE,t.fill=BP.fill,t.inspect=BP.inspect,t.toArrayBuffer=BP.toArrayBuffer,t};var INVALID_BASE64_RE=/[^+\/0-9A-Za-z-_]/g;


},{"base64-js":15,"ieee754":16,"is-array":17}],15:[function(require,module,exports){
var lookup="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";!function(t){"use strict";function r(t){var r=t.charCodeAt(0);return r===h||r===u?62:r===c||r===f?63:o>r?-1:o+10>r?r-o+26+26:i+26>r?r-i:A+26>r?r-A+26:void 0}function e(t){function e(t){i[f++]=t}var n,h,c,o,A,i;if(t.length%4>0)throw new Error("Invalid string. Length must be a multiple of 4");var u=t.length;A="="===t.charAt(u-2)?2:"="===t.charAt(u-1)?1:0,i=new a(3*t.length/4-A),c=A>0?t.length-4:t.length;var f=0;for(n=0,h=0;c>n;n+=4,h+=3)o=r(t.charAt(n))<<18|r(t.charAt(n+1))<<12|r(t.charAt(n+2))<<6|r(t.charAt(n+3)),e((16711680&o)>>16),e((65280&o)>>8),e(255&o);return 2===A?(o=r(t.charAt(n))<<2|r(t.charAt(n+1))>>4,e(255&o)):1===A&&(o=r(t.charAt(n))<<10|r(t.charAt(n+1))<<4|r(t.charAt(n+2))>>2,e(o>>8&255),e(255&o)),i}function n(t){function r(t){return lookup.charAt(t)}function e(t){return r(t>>18&63)+r(t>>12&63)+r(t>>6&63)+r(63&t)}var n,a,h,c=t.length%3,o="";for(n=0,h=t.length-c;h>n;n+=3)a=(t[n]<<16)+(t[n+1]<<8)+t[n+2],o+=e(a);switch(c){case 1:a=t[t.length-1],o+=r(a>>2),o+=r(a<<4&63),o+="==";break;case 2:a=(t[t.length-2]<<8)+t[t.length-1],o+=r(a>>10),o+=r(a>>4&63),o+=r(a<<2&63),o+="="}return o}var a="undefined"!=typeof Uint8Array?Uint8Array:Array,h="+".charCodeAt(0),c="/".charCodeAt(0),o="0".charCodeAt(0),A="a".charCodeAt(0),i="A".charCodeAt(0),u="-".charCodeAt(0),f="_".charCodeAt(0);t.toByteArray=e,t.fromByteArray=n}("undefined"==typeof exports?this.base64js={}:exports);


},{}],16:[function(require,module,exports){
exports.read=function(a,o,t,r,h){var M,p,w=8*h-r-1,f=(1<<w)-1,e=f>>1,i=-7,N=t?h-1:0,n=t?-1:1,s=a[o+N];for(N+=n,M=s&(1<<-i)-1,s>>=-i,i+=w;i>0;M=256*M+a[o+N],N+=n,i-=8);for(p=M&(1<<-i)-1,M>>=-i,i+=r;i>0;p=256*p+a[o+N],N+=n,i-=8);if(0===M)M=1-e;else{if(M===f)return p?NaN:(s?-1:1)*(1/0);p+=Math.pow(2,r),M-=e}return(s?-1:1)*p*Math.pow(2,M-r)},exports.write=function(a,o,t,r,h,M){var p,w,f,e=8*M-h-1,i=(1<<e)-1,N=i>>1,n=23===h?Math.pow(2,-24)-Math.pow(2,-77):0,s=r?0:M-1,u=r?1:-1,l=0>o||0===o&&0>1/o?1:0;for(o=Math.abs(o),isNaN(o)||o===1/0?(w=isNaN(o)?1:0,p=i):(p=Math.floor(Math.log(o)/Math.LN2),o*(f=Math.pow(2,-p))<1&&(p--,f*=2),o+=p+N>=1?n/f:n*Math.pow(2,1-N),o*f>=2&&(p++,f/=2),p+N>=i?(w=0,p=i):p+N>=1?(w=(o*f-1)*Math.pow(2,h),p+=N):(w=o*Math.pow(2,N-1)*Math.pow(2,h),p=0));h>=8;a[t+s]=255&w,s+=u,w/=256,h-=8);for(p=p<<h|w,e+=h;e>0;a[t+s]=255&p,s+=u,p/=256,e-=8);a[t+s-u]|=128*l};


},{}],17:[function(require,module,exports){
var isArray=Array.isArray,str=Object.prototype.toString;module.exports=isArray||function(r){return!!r&&"[object Array]"==str.call(r)};


},{}],18:[function(require,module,exports){
!function(){"use strict";function t(i,e,n,s){return this instanceof t?(this.domain=i||void 0,this.path=e||"/",this.secure=!!n,this.script=!!s,this):new t(i,e,n,s)}function i(t,e,n){return t instanceof i?t:this instanceof i?(this.name=null,this.value=null,this.expiration_date=1/0,this.path=String(n||"/"),this.explicit_path=!1,this.domain=e||null,this.explicit_domain=!1,this.secure=!1,this.noscript=!1,t&&this.parse(t,e,n),this):new i(t,e,n)}function e(){var t,n,s;return this instanceof e?(t=Object.create(null),this.setCookie=function(e,r,a){var o,h;if(e=new i(e,r,a),o=e.expiration_date<=Date.now(),void 0!==t[e.name]){for(n=t[e.name],h=0;h<n.length;h+=1)if(s=n[h],s.collidesWith(e))return o?(n.splice(h,1),0===n.length&&delete t[e.name],!1):(n[h]=e,e);return o?!1:(n.push(e),e)}return o?!1:(t[e.name]=[e],t[e.name])},this.getCookie=function(i,e){var s,r;if(n=t[i])for(r=0;r<n.length;r+=1)if(s=n[r],s.expiration_date<=Date.now())0===n.length&&delete t[s.name];else if(s.matches(e))return s},this.getCookies=function(i){var e,n,s=[];for(e in t)n=this.getCookie(e,i),n&&s.push(n);return s.toString=function(){return s.join(":")},s.toValueString=function(){return s.map(function(t){return t.toValueString()}).join(";")},s},this):new e}exports.CookieAccessInfo=t,exports.Cookie=i,i.prototype.toString=function(){var t=[this.name+"="+this.value];return this.expiration_date!==1/0&&t.push("expires="+new Date(this.expiration_date).toGMTString()),this.domain&&t.push("domain="+this.domain),this.path&&t.push("path="+this.path),this.secure&&t.push("secure"),this.noscript&&t.push("httponly"),t.join("; ")},i.prototype.toValueString=function(){return this.name+"="+this.value};var n=/[:](?=\s*[a-zA-Z0-9_\-]+\s*[=])/g;i.prototype.parse=function(t,e,n){if(this instanceof i){var s,r=t.split(";").filter(function(t){return!!t}),a=r[0].match(/([^=]+)=([\s\S]*)/),o=a[1],h=a[2];for(this.name=o,this.value=h,s=1;s<r.length;s+=1)switch(a=r[s].match(/([^=]+)(?:=([\s\S]*))?/),o=a[1].trim().toLowerCase(),h=a[2],o){case"httponly":this.noscript=!0;break;case"expires":this.expiration_date=h?Number(Date.parse(h)):1/0;break;case"path":this.path=h?h.trim():"",this.explicit_path=!0;break;case"domain":this.domain=h?h.trim():"",this.explicit_domain=!!this.domain;break;case"secure":this.secure=!0}return this.explicit_path||(this.path=n||"/"),this.explicit_domain||(this.domain=e),this}return(new i).parse(t,e,n)},i.prototype.matches=function(t){return!(this.noscript&&t.script||this.secure&&!t.secure)&&this.collidesWith(t)},i.prototype.collidesWith=function(t){if(this.path&&!t.path||this.domain&&!t.domain)return!1;if(this.path&&0!==t.path.indexOf(this.path))return!1;if(this.explicit_path&&0!==t.path.indexOf(this.path))return!1;var i=t.domain&&t.domain.replace(/^[\.]/,""),e=this.domain&&this.domain.replace(/^[\.]/,"");if(e===i)return!0;if(e){if(!this.explicit_domain)return!1;var n=i.indexOf(e);return-1!==n&&n===i.length-e.length}return!0},exports.CookieJar=e,e.prototype.setCookies=function(t,e,s){t=Array.isArray(t)?t:t.split(n);var r,a,o=[];for(t=t.map(function(t){return new i(t,e,s)}),r=0;r<t.length;r+=1)a=t[r],this.setCookie(a,e,s)&&o.push(a);return o}}();


},{}],19:[function(require,module,exports){
"use strict";var yaml=require("./lib/js-yaml.js");module.exports=yaml;


},{"./lib/js-yaml.js":20}],20:[function(require,module,exports){
"use strict";function deprecated(e){return function(){throw new Error("Function "+e+" is deprecated and cannot be used.")}}var loader=require("./js-yaml/loader"),dumper=require("./js-yaml/dumper");module.exports.Type=require("./js-yaml/type"),module.exports.Schema=require("./js-yaml/schema"),module.exports.FAILSAFE_SCHEMA=require("./js-yaml/schema/failsafe"),module.exports.JSON_SCHEMA=require("./js-yaml/schema/json"),module.exports.CORE_SCHEMA=require("./js-yaml/schema/core"),module.exports.DEFAULT_SAFE_SCHEMA=require("./js-yaml/schema/default_safe"),module.exports.DEFAULT_FULL_SCHEMA=require("./js-yaml/schema/default_full"),module.exports.load=loader.load,module.exports.loadAll=loader.loadAll,module.exports.safeLoad=loader.safeLoad,module.exports.safeLoadAll=loader.safeLoadAll,module.exports.dump=dumper.dump,module.exports.safeDump=dumper.safeDump,module.exports.YAMLException=require("./js-yaml/exception"),module.exports.MINIMAL_SCHEMA=require("./js-yaml/schema/failsafe"),module.exports.SAFE_SCHEMA=require("./js-yaml/schema/default_safe"),module.exports.DEFAULT_SCHEMA=require("./js-yaml/schema/default_full"),module.exports.scan=deprecated("scan"),module.exports.parse=deprecated("parse"),module.exports.compose=deprecated("compose"),module.exports.addConstructor=deprecated("addConstructor");


},{"./js-yaml/dumper":22,"./js-yaml/exception":23,"./js-yaml/loader":24,"./js-yaml/schema":26,"./js-yaml/schema/core":27,"./js-yaml/schema/default_full":28,"./js-yaml/schema/default_safe":29,"./js-yaml/schema/failsafe":30,"./js-yaml/schema/json":31,"./js-yaml/type":32}],21:[function(require,module,exports){
"use strict";function isNothing(e){return"undefined"==typeof e||null===e}function isObject(e){return"object"==typeof e&&null!==e}function toArray(e){return Array.isArray(e)?e:isNothing(e)?[]:[e]}function extend(e,t){var r,o,n,i;if(t)for(i=Object.keys(t),r=0,o=i.length;o>r;r+=1)n=i[r],e[n]=t[n];return e}function repeat(e,t){var r,o="";for(r=0;t>r;r+=1)o+=e;return o}function isNegativeZero(e){return 0===e&&Number.NEGATIVE_INFINITY===1/e}module.exports.isNothing=isNothing,module.exports.isObject=isObject,module.exports.toArray=toArray,module.exports.repeat=repeat,module.exports.isNegativeZero=isNegativeZero,module.exports.extend=extend;


},{}],22:[function(require,module,exports){
"use strict";function compileStyleMap(e,t){var n,i,r,E,o,l,a;if(null===t)return{};for(n={},i=Object.keys(t),r=0,E=i.length;E>r;r+=1)o=i[r],l=String(t[o]),"!!"===o.slice(0,2)&&(o="tag:yaml.org,2002:"+o.slice(2)),a=e.compiledTypeMap[o],a&&_hasOwnProperty.call(a.styleAliases,l)&&(l=a.styleAliases[l]),n[o]=l;return n}function encodeHex(e){var t,n,i;if(t=e.toString(16).toUpperCase(),255>=e)n="x",i=2;else if(65535>=e)n="u",i=4;else{if(!(4294967295>=e))throw new YAMLException("code point within a string may not be greater than 0xFFFFFFFF");n="U",i=8}return"\\"+n+common.repeat("0",i-t.length)+t}function State(e){this.schema=e.schema||DEFAULT_FULL_SCHEMA,this.indent=Math.max(1,e.indent||2),this.skipInvalid=e.skipInvalid||!1,this.flowLevel=common.isNothing(e.flowLevel)?-1:e.flowLevel,this.styleMap=compileStyleMap(this.schema,e.styles||null),this.sortKeys=e.sortKeys||!1,this.lineWidth=e.lineWidth||80,this.noRefs=e.noRefs||!1,this.noCompatMode=e.noCompatMode||!1,this.implicitTypes=this.schema.compiledImplicit,this.explicitTypes=this.schema.compiledExplicit,this.tag=null,this.result="",this.duplicates=[],this.usedDuplicates=null}function indentString(e,t){for(var n,i=common.repeat(" ",t),r=0,E=-1,o="",l=e.length;l>r;)E=e.indexOf("\n",r),-1===E?(n=e.slice(r),r=l):(n=e.slice(r,E+1),r=E+1),n.length&&"\n"!==n&&(o+=i),o+=n;return o}function generateNextLine(e,t){return"\n"+common.repeat(" ",e.indent*t)}function testImplicitResolving(e,t){var n,i,r;for(n=0,i=e.implicitTypes.length;i>n;n+=1)if(r=e.implicitTypes[n],r.resolve(t))return!0;return!1}function isWhitespace(e){return e===CHAR_SPACE||e===CHAR_TAB}function isPrintable(e){return e>=32&&126>=e||e>=161&&55295>=e&&8232!==e&&8233!==e||e>=57344&&65533>=e&&65279!==e||e>=65536&&1114111>=e}function isPlainSafe(e){return isPrintable(e)&&65279!==e&&e!==CHAR_COMMA&&e!==CHAR_LEFT_SQUARE_BRACKET&&e!==CHAR_RIGHT_SQUARE_BRACKET&&e!==CHAR_LEFT_CURLY_BRACKET&&e!==CHAR_RIGHT_CURLY_BRACKET&&e!==CHAR_COLON&&e!==CHAR_SHARP}function isPlainSafeFirst(e){return isPrintable(e)&&65279!==e&&!isWhitespace(e)&&e!==CHAR_MINUS&&e!==CHAR_QUESTION&&e!==CHAR_COLON&&e!==CHAR_COMMA&&e!==CHAR_LEFT_SQUARE_BRACKET&&e!==CHAR_RIGHT_SQUARE_BRACKET&&e!==CHAR_LEFT_CURLY_BRACKET&&e!==CHAR_RIGHT_CURLY_BRACKET&&e!==CHAR_SHARP&&e!==CHAR_AMPERSAND&&e!==CHAR_ASTERISK&&e!==CHAR_EXCLAMATION&&e!==CHAR_VERTICAL_LINE&&e!==CHAR_GREATER_THAN&&e!==CHAR_SINGLE_QUOTE&&e!==CHAR_DOUBLE_QUOTE&&e!==CHAR_PERCENT&&e!==CHAR_COMMERCIAL_AT&&e!==CHAR_GRAVE_ACCENT}function chooseScalarStyle(e,t,n,i,r){var E,o,l=!1,a=!1,s=-1!==i,c=-1,A=isPlainSafeFirst(e.charCodeAt(0))&&!isWhitespace(e.charCodeAt(e.length-1));if(t)for(E=0;E<e.length;E++){if(o=e.charCodeAt(E),!isPrintable(o))return STYLE_DOUBLE;A=A&&isPlainSafe(o)}else{for(E=0;E<e.length;E++){if(o=e.charCodeAt(E),o===CHAR_LINE_FEED)l=!0,s&&(a=a||E-c-1>i&&" "!==e[c+1],c=E);else if(!isPrintable(o))return STYLE_DOUBLE;A=A&&isPlainSafe(o)}a=a||s&&E-c-1>i&&" "!==e[c+1]}return l||a?" "===e[0]&&n>9?STYLE_DOUBLE:a?STYLE_FOLDED:STYLE_LITERAL:A&&!r(e)?STYLE_PLAIN:STYLE_SINGLE}function writeScalar(e,t,n,i){e.dump=function(){function r(t){return testImplicitResolving(e,t)}if(0===t.length)return"''";if(!e.noCompatMode&&-1!==DEPRECATED_BOOLEANS_SYNTAX.indexOf(t))return"'"+t+"'";var E=e.indent*Math.max(1,n),o=-1===e.lineWidth?-1:Math.max(Math.min(e.lineWidth,40),e.lineWidth-E),l=i||e.flowLevel>-1&&n>=e.flowLevel;switch(chooseScalarStyle(t,l,e.indent,o,r)){case STYLE_PLAIN:return t;case STYLE_SINGLE:return"'"+t.replace(/'/g,"''")+"'";case STYLE_LITERAL:return"|"+blockHeader(t,e.indent)+dropEndingNewline(indentString(t,E));case STYLE_FOLDED:return">"+blockHeader(t,e.indent)+dropEndingNewline(indentString(foldString(t,o),E));case STYLE_DOUBLE:return'"'+escapeString(t,o)+'"';default:throw new YAMLException("impossible error: invalid scalar style")}}()}function blockHeader(e,t){var n=" "===e[0]?String(t):"",i="\n"===e[e.length-1],r=i&&("\n"===e[e.length-2]||"\n"===e),E=r?"+":i?"":"-";return n+E+"\n"}function dropEndingNewline(e){return"\n"===e[e.length-1]?e.slice(0,-1):e}function foldString(e,t){for(var n,i,r=/(\n+)([^\n]*)/g,E=function(){var n=e.indexOf("\n");return n=-1!==n?n:e.length,r.lastIndex=n,foldLine(e.slice(0,n),t)}(),o="\n"===e[0]||" "===e[0];i=r.exec(e);){var l=i[1],a=i[2];n=" "===a[0],E+=l+(o||n||""===a?"":"\n")+foldLine(a,t),o=n}return E}function foldLine(e,t){if(""===e||" "===e[0])return e;for(var n,i,r=/ [^ ]/g,E=0,o=0,l=0,a="";n=r.exec(e);)l=n.index,l-E>t&&(i=o>E?o:l,a+="\n"+e.slice(E,i),E=i+1),o=l;return a+="\n",a+=e.length-E>t&&o>E?e.slice(E,o)+"\n"+e.slice(o+1):e.slice(E),a.slice(1)}function escapeString(e){for(var t,n,i="",r=0;r<e.length;r++)t=e.charCodeAt(r),n=ESCAPE_SEQUENCES[t],i+=!n&&isPrintable(t)?e[r]:n||encodeHex(t);return i}function writeFlowSequence(e,t,n){var i,r,E="",o=e.tag;for(i=0,r=n.length;r>i;i+=1)writeNode(e,t,n[i],!1,!1)&&(0!==i&&(E+=", "),E+=e.dump);e.tag=o,e.dump="["+E+"]"}function writeBlockSequence(e,t,n,i){var r,E,o="",l=e.tag;for(r=0,E=n.length;E>r;r+=1)writeNode(e,t+1,n[r],!0,!0)&&(i&&0===r||(o+=generateNextLine(e,t)),o+="- "+e.dump);e.tag=l,e.dump=o||"[]"}function writeFlowMapping(e,t,n){var i,r,E,o,l,a="",s=e.tag,c=Object.keys(n);for(i=0,r=c.length;r>i;i+=1)l="",0!==i&&(l+=", "),E=c[i],o=n[E],writeNode(e,t,E,!1,!1)&&(e.dump.length>1024&&(l+="? "),l+=e.dump+": ",writeNode(e,t,o,!1,!1)&&(l+=e.dump,a+=l));e.tag=s,e.dump="{"+a+"}"}function writeBlockMapping(e,t,n,i){var r,E,o,l,a,s,c="",A=e.tag,u=Object.keys(n);if(e.sortKeys===!0)u.sort();else if("function"==typeof e.sortKeys)u.sort(e.sortKeys);else if(e.sortKeys)throw new YAMLException("sortKeys must be a boolean or a function");for(r=0,E=u.length;E>r;r+=1)s="",i&&0===r||(s+=generateNextLine(e,t)),o=u[r],l=n[o],writeNode(e,t+1,o,!0,!0,!0)&&(a=null!==e.tag&&"?"!==e.tag||e.dump&&e.dump.length>1024,a&&(s+=e.dump&&CHAR_LINE_FEED===e.dump.charCodeAt(0)?"?":"? "),s+=e.dump,a&&(s+=generateNextLine(e,t)),writeNode(e,t+1,l,!0,a)&&(s+=e.dump&&CHAR_LINE_FEED===e.dump.charCodeAt(0)?":":": ",s+=e.dump,c+=s));e.tag=A,e.dump=c||"{}"}function detectType(e,t,n){var i,r,E,o,l,a;for(r=n?e.explicitTypes:e.implicitTypes,E=0,o=r.length;o>E;E+=1)if(l=r[E],(l.instanceOf||l.predicate)&&(!l.instanceOf||"object"==typeof t&&t instanceof l.instanceOf)&&(!l.predicate||l.predicate(t))){if(e.tag=n?l.tag:"?",l.represent){if(a=e.styleMap[l.tag]||l.defaultStyle,"[object Function]"===_toString.call(l.represent))i=l.represent(t,a);else{if(!_hasOwnProperty.call(l.represent,a))throw new YAMLException("!<"+l.tag+'> tag resolver accepts not "'+a+'" style');i=l.represent[a](t,a)}e.dump=i}return!0}return!1}function writeNode(e,t,n,i,r,E){e.tag=null,e.dump=n,detectType(e,n,!1)||detectType(e,n,!0);var o=_toString.call(e.dump);i&&(i=e.flowLevel<0||e.flowLevel>t);var l,a,s="[object Object]"===o||"[object Array]"===o;if(s&&(l=e.duplicates.indexOf(n),a=-1!==l),(null!==e.tag&&"?"!==e.tag||a||2!==e.indent&&t>0)&&(r=!1),a&&e.usedDuplicates[l])e.dump="*ref_"+l;else{if(s&&a&&!e.usedDuplicates[l]&&(e.usedDuplicates[l]=!0),"[object Object]"===o)i&&0!==Object.keys(e.dump).length?(writeBlockMapping(e,t,e.dump,r),a&&(e.dump="&ref_"+l+e.dump)):(writeFlowMapping(e,t,e.dump),a&&(e.dump="&ref_"+l+" "+e.dump));else if("[object Array]"===o)i&&0!==e.dump.length?(writeBlockSequence(e,t,e.dump,r),a&&(e.dump="&ref_"+l+e.dump)):(writeFlowSequence(e,t,e.dump),a&&(e.dump="&ref_"+l+" "+e.dump));else{if("[object String]"!==o){if(e.skipInvalid)return!1;throw new YAMLException("unacceptable kind of an object to dump "+o)}"?"!==e.tag&&writeScalar(e,e.dump,t,E)}null!==e.tag&&"?"!==e.tag&&(e.dump="!<"+e.tag+"> "+e.dump)}return!0}function getDuplicateReferences(e,t){var n,i,r=[],E=[];for(inspectNode(e,r,E),n=0,i=E.length;i>n;n+=1)t.duplicates.push(r[E[n]]);t.usedDuplicates=new Array(i)}function inspectNode(e,t,n){var i,r,E;if(null!==e&&"object"==typeof e)if(r=t.indexOf(e),-1!==r)-1===n.indexOf(r)&&n.push(r);else if(t.push(e),Array.isArray(e))for(r=0,E=e.length;E>r;r+=1)inspectNode(e[r],t,n);else for(i=Object.keys(e),r=0,E=i.length;E>r;r+=1)inspectNode(e[i[r]],t,n)}function dump(e,t){t=t||{};var n=new State(t);return n.noRefs||getDuplicateReferences(e,n),writeNode(n,0,e,!0,!0)?n.dump+"\n":""}function safeDump(e,t){return dump(e,common.extend({schema:DEFAULT_SAFE_SCHEMA},t))}var common=require("./common"),YAMLException=require("./exception"),DEFAULT_FULL_SCHEMA=require("./schema/default_full"),DEFAULT_SAFE_SCHEMA=require("./schema/default_safe"),_toString=Object.prototype.toString,_hasOwnProperty=Object.prototype.hasOwnProperty,CHAR_TAB=9,CHAR_LINE_FEED=10,CHAR_SPACE=32,CHAR_EXCLAMATION=33,CHAR_DOUBLE_QUOTE=34,CHAR_SHARP=35,CHAR_PERCENT=37,CHAR_AMPERSAND=38,CHAR_SINGLE_QUOTE=39,CHAR_ASTERISK=42,CHAR_COMMA=44,CHAR_MINUS=45,CHAR_COLON=58,CHAR_GREATER_THAN=62,CHAR_QUESTION=63,CHAR_COMMERCIAL_AT=64,CHAR_LEFT_SQUARE_BRACKET=91,CHAR_RIGHT_SQUARE_BRACKET=93,CHAR_GRAVE_ACCENT=96,CHAR_LEFT_CURLY_BRACKET=123,CHAR_VERTICAL_LINE=124,CHAR_RIGHT_CURLY_BRACKET=125,ESCAPE_SEQUENCES={};ESCAPE_SEQUENCES[0]="\\0",ESCAPE_SEQUENCES[7]="\\a",ESCAPE_SEQUENCES[8]="\\b",ESCAPE_SEQUENCES[9]="\\t",ESCAPE_SEQUENCES[10]="\\n",ESCAPE_SEQUENCES[11]="\\v",ESCAPE_SEQUENCES[12]="\\f",ESCAPE_SEQUENCES[13]="\\r",ESCAPE_SEQUENCES[27]="\\e",ESCAPE_SEQUENCES[34]='\\"',ESCAPE_SEQUENCES[92]="\\\\",ESCAPE_SEQUENCES[133]="\\N",ESCAPE_SEQUENCES[160]="\\_",ESCAPE_SEQUENCES[8232]="\\L",ESCAPE_SEQUENCES[8233]="\\P";var DEPRECATED_BOOLEANS_SYNTAX=["y","Y","yes","Yes","YES","on","On","ON","n","N","no","No","NO","off","Off","OFF"],STYLE_PLAIN=1,STYLE_SINGLE=2,STYLE_LITERAL=3,STYLE_FOLDED=4,STYLE_DOUBLE=5;module.exports.dump=dump,module.exports.safeDump=safeDump;


},{"./common":21,"./exception":23,"./schema/default_full":28,"./schema/default_safe":29}],23:[function(require,module,exports){
"use strict";function YAMLException(t,r){Error.call(this),Error.captureStackTrace?Error.captureStackTrace(this,this.constructor):this.stack=(new Error).stack||"",this.name="YAMLException",this.reason=t,this.mark=r,this.message=(this.reason||"(unknown reason)")+(this.mark?" "+this.mark.toString():"")}YAMLException.prototype=Object.create(Error.prototype),YAMLException.prototype.constructor=YAMLException,YAMLException.prototype.toString=function(t){var r=this.name+": ";return r+=this.reason||"(unknown reason)",!t&&this.mark&&(r+=" "+this.mark.toString()),r},module.exports=YAMLException;


},{}],24:[function(require,module,exports){
"use strict";function is_EOL(e){return 10===e||13===e}function is_WHITE_SPACE(e){return 9===e||32===e}function is_WS_OR_EOL(e){return 9===e||32===e||10===e||13===e}function is_FLOW_INDICATOR(e){return 44===e||91===e||93===e||123===e||125===e}function fromHexCode(e){var t;return e>=48&&57>=e?e-48:(t=32|e,t>=97&&102>=t?t-97+10:-1)}function escapedHexLen(e){return 120===e?2:117===e?4:85===e?8:0}function fromDecimalCode(e){return e>=48&&57>=e?e-48:-1}function simpleEscapeSequence(e){return 48===e?"\x00":97===e?"":98===e?"\b":116===e?"	":9===e?"	":110===e?"\n":118===e?"\x0B":102===e?"\f":114===e?"\r":101===e?"":32===e?" ":34===e?'"':47===e?"/":92===e?"\\":78===e?"":95===e?" ":76===e?"\u2028":80===e?"\u2029":""}function charFromCodepoint(e){return 65535>=e?String.fromCharCode(e):String.fromCharCode((e-65536>>10)+55296,(e-65536&1023)+56320)}function State(e,t){this.input=e,this.filename=t.filename||null,this.schema=t.schema||DEFAULT_FULL_SCHEMA,this.onWarning=t.onWarning||null,this.legacy=t.legacy||!1,this.json=t.json||!1,this.listener=t.listener||null,this.implicitTypes=this.schema.compiledImplicit,this.typeMap=this.schema.compiledTypeMap,this.length=e.length,this.position=0,this.line=0,this.lineStart=0,this.lineIndent=0,this.documents=[]}function generateError(e,t){return new YAMLException(t,new Mark(e.filename,e.input,e.position,e.line,e.position-e.lineStart))}function throwError(e,t){throw generateError(e,t)}function throwWarning(e,t){e.onWarning&&e.onWarning.call(null,generateError(e,t))}function captureSegment(e,t,n,i){var o,r,a,s;if(n>t){if(s=e.input.slice(t,n),i)for(o=0,r=s.length;r>o;o+=1)a=s.charCodeAt(o),9===a||a>=32&&1114111>=a||throwError(e,"expected valid JSON character");else PATTERN_NON_PRINTABLE.test(s)&&throwError(e,"the stream contains non-printable characters");e.result+=s}}function mergeMappings(e,t,n,i){var o,r,a,s;for(common.isObject(n)||throwError(e,"cannot merge mappings; the provided source object is unacceptable"),o=Object.keys(n),a=0,s=o.length;s>a;a+=1)r=o[a],_hasOwnProperty.call(t,r)||(t[r]=n[r],i[r]=!0)}function storeMappingPair(e,t,n,i,o,r){var a,s;if(o=String(o),null===t&&(t={}),"tag:yaml.org,2002:merge"===i)if(Array.isArray(r))for(a=0,s=r.length;s>a;a+=1)mergeMappings(e,t,r[a],n);else mergeMappings(e,t,r,n);else e.json||_hasOwnProperty.call(n,o)||!_hasOwnProperty.call(t,o)||throwError(e,"duplicated mapping key"),t[o]=r,delete n[o];return t}function readLineBreak(e){var t;t=e.input.charCodeAt(e.position),10===t?e.position++:13===t?(e.position++,10===e.input.charCodeAt(e.position)&&e.position++):throwError(e,"a line break is expected"),e.line+=1,e.lineStart=e.position}function skipSeparationSpace(e,t,n){for(var i=0,o=e.input.charCodeAt(e.position);0!==o;){for(;is_WHITE_SPACE(o);)o=e.input.charCodeAt(++e.position);if(t&&35===o)do o=e.input.charCodeAt(++e.position);while(10!==o&&13!==o&&0!==o);if(!is_EOL(o))break;for(readLineBreak(e),o=e.input.charCodeAt(e.position),i++,e.lineIndent=0;32===o;)e.lineIndent++,o=e.input.charCodeAt(++e.position)}return-1!==n&&0!==i&&e.lineIndent<n&&throwWarning(e,"deficient indentation"),i}function testDocumentSeparator(e){var t,n=e.position;return t=e.input.charCodeAt(n),(45===t||46===t)&&t===e.input.charCodeAt(n+1)&&t===e.input.charCodeAt(n+2)&&(n+=3,t=e.input.charCodeAt(n),0===t||is_WS_OR_EOL(t))}function writeFoldedLines(e,t){1===t?e.result+=" ":t>1&&(e.result+=common.repeat("\n",t-1))}function readPlainScalar(e,t,n){var i,o,r,a,s,p,c,l,u,d=e.kind,h=e.result;if(u=e.input.charCodeAt(e.position),is_WS_OR_EOL(u)||is_FLOW_INDICATOR(u)||35===u||38===u||42===u||33===u||124===u||62===u||39===u||34===u||37===u||64===u||96===u)return!1;if((63===u||45===u)&&(o=e.input.charCodeAt(e.position+1),is_WS_OR_EOL(o)||n&&is_FLOW_INDICATOR(o)))return!1;for(e.kind="scalar",e.result="",r=a=e.position,s=!1;0!==u;){if(58===u){if(o=e.input.charCodeAt(e.position+1),is_WS_OR_EOL(o)||n&&is_FLOW_INDICATOR(o))break}else if(35===u){if(i=e.input.charCodeAt(e.position-1),is_WS_OR_EOL(i))break}else{if(e.position===e.lineStart&&testDocumentSeparator(e)||n&&is_FLOW_INDICATOR(u))break;if(is_EOL(u)){if(p=e.line,c=e.lineStart,l=e.lineIndent,skipSeparationSpace(e,!1,-1),e.lineIndent>=t){s=!0,u=e.input.charCodeAt(e.position);continue}e.position=a,e.line=p,e.lineStart=c,e.lineIndent=l;break}}s&&(captureSegment(e,r,a,!1),writeFoldedLines(e,e.line-p),r=a=e.position,s=!1),is_WHITE_SPACE(u)||(a=e.position+1),u=e.input.charCodeAt(++e.position)}return captureSegment(e,r,a,!1),e.result?!0:(e.kind=d,e.result=h,!1)}function readSingleQuotedScalar(e,t){var n,i,o;if(n=e.input.charCodeAt(e.position),39!==n)return!1;for(e.kind="scalar",e.result="",e.position++,i=o=e.position;0!==(n=e.input.charCodeAt(e.position));)if(39===n){if(captureSegment(e,i,e.position,!0),n=e.input.charCodeAt(++e.position),39!==n)return!0;i=o=e.position,e.position++}else is_EOL(n)?(captureSegment(e,i,o,!0),writeFoldedLines(e,skipSeparationSpace(e,!1,t)),i=o=e.position):e.position===e.lineStart&&testDocumentSeparator(e)?throwError(e,"unexpected end of the document within a single quoted scalar"):(e.position++,o=e.position);throwError(e,"unexpected end of the stream within a single quoted scalar")}function readDoubleQuotedScalar(e,t){var n,i,o,r,a,s;if(s=e.input.charCodeAt(e.position),34!==s)return!1;for(e.kind="scalar",e.result="",e.position++,n=i=e.position;0!==(s=e.input.charCodeAt(e.position));){if(34===s)return captureSegment(e,n,e.position,!0),e.position++,!0;if(92===s){if(captureSegment(e,n,e.position,!0),s=e.input.charCodeAt(++e.position),is_EOL(s))skipSeparationSpace(e,!1,t);else if(256>s&&simpleEscapeCheck[s])e.result+=simpleEscapeMap[s],e.position++;else if((a=escapedHexLen(s))>0){for(o=a,r=0;o>0;o--)s=e.input.charCodeAt(++e.position),(a=fromHexCode(s))>=0?r=(r<<4)+a:throwError(e,"expected hexadecimal character");e.result+=charFromCodepoint(r),e.position++}else throwError(e,"unknown escape sequence");n=i=e.position}else is_EOL(s)?(captureSegment(e,n,i,!0),writeFoldedLines(e,skipSeparationSpace(e,!1,t)),n=i=e.position):e.position===e.lineStart&&testDocumentSeparator(e)?throwError(e,"unexpected end of the document within a double quoted scalar"):(e.position++,i=e.position)}throwError(e,"unexpected end of the stream within a double quoted scalar")}function readFlowCollection(e,t){var n,i,o,r,a,s,p,c,l,u,d,h=!0,f=e.tag,_=e.anchor,A={};if(d=e.input.charCodeAt(e.position),91===d)r=93,p=!1,i=[];else{if(123!==d)return!1;r=125,p=!0,i={}}for(null!==e.anchor&&(e.anchorMap[e.anchor]=i),d=e.input.charCodeAt(++e.position);0!==d;){if(skipSeparationSpace(e,!0,t),d=e.input.charCodeAt(e.position),d===r)return e.position++,e.tag=f,e.anchor=_,e.kind=p?"mapping":"sequence",e.result=i,!0;h||throwError(e,"missed comma between flow collection entries"),l=c=u=null,a=s=!1,63===d&&(o=e.input.charCodeAt(e.position+1),is_WS_OR_EOL(o)&&(a=s=!0,e.position++,skipSeparationSpace(e,!0,t))),n=e.line,composeNode(e,t,CONTEXT_FLOW_IN,!1,!0),l=e.tag,c=e.result,skipSeparationSpace(e,!0,t),d=e.input.charCodeAt(e.position),!s&&e.line!==n||58!==d||(a=!0,d=e.input.charCodeAt(++e.position),skipSeparationSpace(e,!0,t),composeNode(e,t,CONTEXT_FLOW_IN,!1,!0),u=e.result),p?storeMappingPair(e,i,A,l,c,u):a?i.push(storeMappingPair(e,null,A,l,c,u)):i.push(c),skipSeparationSpace(e,!0,t),d=e.input.charCodeAt(e.position),44===d?(h=!0,d=e.input.charCodeAt(++e.position)):h=!1}throwError(e,"unexpected end of the stream within a flow collection")}function readBlockScalar(e,t){var n,i,o,r,a=CHOMPING_CLIP,s=!1,p=!1,c=t,l=0,u=!1;if(r=e.input.charCodeAt(e.position),124===r)i=!1;else{if(62!==r)return!1;i=!0}for(e.kind="scalar",e.result="";0!==r;)if(r=e.input.charCodeAt(++e.position),43===r||45===r)CHOMPING_CLIP===a?a=43===r?CHOMPING_KEEP:CHOMPING_STRIP:throwError(e,"repeat of a chomping mode identifier");else{if(!((o=fromDecimalCode(r))>=0))break;0===o?throwError(e,"bad explicit indentation width of a block scalar; it cannot be less than one"):p?throwError(e,"repeat of an indentation width identifier"):(c=t+o-1,p=!0)}if(is_WHITE_SPACE(r)){do r=e.input.charCodeAt(++e.position);while(is_WHITE_SPACE(r));if(35===r)do r=e.input.charCodeAt(++e.position);while(!is_EOL(r)&&0!==r)}for(;0!==r;){for(readLineBreak(e),e.lineIndent=0,r=e.input.charCodeAt(e.position);(!p||e.lineIndent<c)&&32===r;)e.lineIndent++,r=e.input.charCodeAt(++e.position);if(!p&&e.lineIndent>c&&(c=e.lineIndent),is_EOL(r))l++;else{if(e.lineIndent<c){a===CHOMPING_KEEP?e.result+=common.repeat("\n",s?1+l:l):a===CHOMPING_CLIP&&s&&(e.result+="\n");break}for(i?is_WHITE_SPACE(r)?(u=!0,e.result+=common.repeat("\n",s?1+l:l)):u?(u=!1,e.result+=common.repeat("\n",l+1)):0===l?s&&(e.result+=" "):e.result+=common.repeat("\n",l):e.result+=common.repeat("\n",s?1+l:l),s=!0,p=!0,l=0,n=e.position;!is_EOL(r)&&0!==r;)r=e.input.charCodeAt(++e.position);captureSegment(e,n,e.position,!1)}}return!0}function readBlockSequence(e,t){var n,i,o,r=e.tag,a=e.anchor,s=[],p=!1;for(null!==e.anchor&&(e.anchorMap[e.anchor]=s),o=e.input.charCodeAt(e.position);0!==o&&45===o&&(i=e.input.charCodeAt(e.position+1),is_WS_OR_EOL(i));)if(p=!0,e.position++,skipSeparationSpace(e,!0,-1)&&e.lineIndent<=t)s.push(null),o=e.input.charCodeAt(e.position);else if(n=e.line,composeNode(e,t,CONTEXT_BLOCK_IN,!1,!0),s.push(e.result),skipSeparationSpace(e,!0,-1),o=e.input.charCodeAt(e.position),(e.line===n||e.lineIndent>t)&&0!==o)throwError(e,"bad indentation of a sequence entry");else if(e.lineIndent<t)break;return p?(e.tag=r,e.anchor=a,e.kind="sequence",e.result=s,!0):!1}function readBlockMapping(e,t,n){var i,o,r,a,s=e.tag,p=e.anchor,c={},l={},u=null,d=null,h=null,f=!1,_=!1;for(null!==e.anchor&&(e.anchorMap[e.anchor]=c),a=e.input.charCodeAt(e.position);0!==a;){if(i=e.input.charCodeAt(e.position+1),r=e.line,63!==a&&58!==a||!is_WS_OR_EOL(i)){if(!composeNode(e,n,CONTEXT_FLOW_OUT,!1,!0))break;if(e.line===r){for(a=e.input.charCodeAt(e.position);is_WHITE_SPACE(a);)a=e.input.charCodeAt(++e.position);if(58===a)a=e.input.charCodeAt(++e.position),is_WS_OR_EOL(a)||throwError(e,"a whitespace character is expected after the key-value separator within a block mapping"),f&&(storeMappingPair(e,c,l,u,d,null),u=d=h=null),_=!0,f=!1,o=!1,u=e.tag,d=e.result;else{if(!_)return e.tag=s,e.anchor=p,!0;throwError(e,"can not read an implicit mapping pair; a colon is missed")}}else{if(!_)return e.tag=s,e.anchor=p,!0;throwError(e,"can not read a block mapping entry; a multiline key may not be an implicit key")}}else 63===a?(f&&(storeMappingPair(e,c,l,u,d,null),u=d=h=null),_=!0,f=!0,o=!0):f?(f=!1,o=!0):throwError(e,"incomplete explicit mapping pair; a key node is missed"),e.position+=1,a=i;if((e.line===r||e.lineIndent>t)&&(composeNode(e,t,CONTEXT_BLOCK_OUT,!0,o)&&(f?d=e.result:h=e.result),f||(storeMappingPair(e,c,l,u,d,h),u=d=h=null),skipSeparationSpace(e,!0,-1),a=e.input.charCodeAt(e.position)),e.lineIndent>t&&0!==a)throwError(e,"bad indentation of a mapping entry");else if(e.lineIndent<t)break}return f&&storeMappingPair(e,c,l,u,d,null),_&&(e.tag=s,e.anchor=p,e.kind="mapping",e.result=c),_}function readTagProperty(e){var t,n,i,o,r=!1,a=!1;if(o=e.input.charCodeAt(e.position),33!==o)return!1;if(null!==e.tag&&throwError(e,"duplication of a tag property"),o=e.input.charCodeAt(++e.position),60===o?(r=!0,o=e.input.charCodeAt(++e.position)):33===o?(a=!0,n="!!",o=e.input.charCodeAt(++e.position)):n="!",t=e.position,r){do o=e.input.charCodeAt(++e.position);while(0!==o&&62!==o);e.position<e.length?(i=e.input.slice(t,e.position),o=e.input.charCodeAt(++e.position)):throwError(e,"unexpected end of the stream within a verbatim tag")}else{for(;0!==o&&!is_WS_OR_EOL(o);)33===o&&(a?throwError(e,"tag suffix cannot contain exclamation marks"):(n=e.input.slice(t-1,e.position+1),PATTERN_TAG_HANDLE.test(n)||throwError(e,"named tag handle cannot contain such characters"),a=!0,t=e.position+1)),o=e.input.charCodeAt(++e.position);i=e.input.slice(t,e.position),PATTERN_FLOW_INDICATORS.test(i)&&throwError(e,"tag suffix cannot contain flow indicator characters")}return i&&!PATTERN_TAG_URI.test(i)&&throwError(e,"tag name cannot contain such characters: "+i),r?e.tag=i:_hasOwnProperty.call(e.tagMap,n)?e.tag=e.tagMap[n]+i:"!"===n?e.tag="!"+i:"!!"===n?e.tag="tag:yaml.org,2002:"+i:throwError(e,'undeclared tag handle "'+n+'"'),!0}function readAnchorProperty(e){var t,n;if(n=e.input.charCodeAt(e.position),38!==n)return!1;for(null!==e.anchor&&throwError(e,"duplication of an anchor property"),n=e.input.charCodeAt(++e.position),t=e.position;0!==n&&!is_WS_OR_EOL(n)&&!is_FLOW_INDICATOR(n);)n=e.input.charCodeAt(++e.position);return e.position===t&&throwError(e,"name of an anchor node must contain at least one character"),e.anchor=e.input.slice(t,e.position),!0}function readAlias(e){var t,n,i;if(i=e.input.charCodeAt(e.position),42!==i)return!1;for(i=e.input.charCodeAt(++e.position),t=e.position;0!==i&&!is_WS_OR_EOL(i)&&!is_FLOW_INDICATOR(i);)i=e.input.charCodeAt(++e.position);return e.position===t&&throwError(e,"name of an alias node must contain at least one character"),n=e.input.slice(t,e.position),e.anchorMap.hasOwnProperty(n)||throwError(e,'unidentified alias "'+n+'"'),e.result=e.anchorMap[n],skipSeparationSpace(e,!0,-1),!0}function composeNode(e,t,n,i,o){var r,a,s,p,c,l,u,d,h=1,f=!1,_=!1;if(null!==e.listener&&e.listener("open",e),e.tag=null,e.anchor=null,e.kind=null,e.result=null,r=a=s=CONTEXT_BLOCK_OUT===n||CONTEXT_BLOCK_IN===n,i&&skipSeparationSpace(e,!0,-1)&&(f=!0,e.lineIndent>t?h=1:e.lineIndent===t?h=0:e.lineIndent<t&&(h=-1)),1===h)for(;readTagProperty(e)||readAnchorProperty(e);)skipSeparationSpace(e,!0,-1)?(f=!0,s=r,e.lineIndent>t?h=1:e.lineIndent===t?h=0:e.lineIndent<t&&(h=-1)):s=!1;if(s&&(s=f||o),1!==h&&CONTEXT_BLOCK_OUT!==n||(u=CONTEXT_FLOW_IN===n||CONTEXT_FLOW_OUT===n?t:t+1,d=e.position-e.lineStart,1===h?s&&(readBlockSequence(e,d)||readBlockMapping(e,d,u))||readFlowCollection(e,u)?_=!0:(a&&readBlockScalar(e,u)||readSingleQuotedScalar(e,u)||readDoubleQuotedScalar(e,u)?_=!0:readAlias(e)?(_=!0,null===e.tag&&null===e.anchor||throwError(e,"alias node should not have any properties")):readPlainScalar(e,u,CONTEXT_FLOW_IN===n)&&(_=!0,null===e.tag&&(e.tag="?")),null!==e.anchor&&(e.anchorMap[e.anchor]=e.result)):0===h&&(_=s&&readBlockSequence(e,d))),null!==e.tag&&"!"!==e.tag)if("?"===e.tag){for(p=0,c=e.implicitTypes.length;c>p;p+=1)if(l=e.implicitTypes[p],l.resolve(e.result)){e.result=l.construct(e.result),e.tag=l.tag,null!==e.anchor&&(e.anchorMap[e.anchor]=e.result);break}}else _hasOwnProperty.call(e.typeMap,e.tag)?(l=e.typeMap[e.tag],null!==e.result&&l.kind!==e.kind&&throwError(e,"unacceptable node kind for !<"+e.tag+'> tag; it should be "'+l.kind+'", not "'+e.kind+'"'),l.resolve(e.result)?(e.result=l.construct(e.result),null!==e.anchor&&(e.anchorMap[e.anchor]=e.result)):throwError(e,"cannot resolve a node with !<"+e.tag+"> explicit tag")):throwError(e,"unknown tag !<"+e.tag+">");return null!==e.listener&&e.listener("close",e),null!==e.tag||null!==e.anchor||_}function readDocument(e){var t,n,i,o,r=e.position,a=!1;for(e.version=null,e.checkLineBreaks=e.legacy,e.tagMap={},e.anchorMap={};0!==(o=e.input.charCodeAt(e.position))&&(skipSeparationSpace(e,!0,-1),o=e.input.charCodeAt(e.position),!(e.lineIndent>0||37!==o));){for(a=!0,o=e.input.charCodeAt(++e.position),t=e.position;0!==o&&!is_WS_OR_EOL(o);)o=e.input.charCodeAt(++e.position);for(n=e.input.slice(t,e.position),i=[],n.length<1&&throwError(e,"directive name must not be less than one character in length");0!==o;){for(;is_WHITE_SPACE(o);)o=e.input.charCodeAt(++e.position);if(35===o){do o=e.input.charCodeAt(++e.position);while(0!==o&&!is_EOL(o));break}if(is_EOL(o))break;for(t=e.position;0!==o&&!is_WS_OR_EOL(o);)o=e.input.charCodeAt(++e.position);i.push(e.input.slice(t,e.position))}0!==o&&readLineBreak(e),_hasOwnProperty.call(directiveHandlers,n)?directiveHandlers[n](e,n,i):throwWarning(e,'unknown document directive "'+n+'"')}return skipSeparationSpace(e,!0,-1),0===e.lineIndent&&45===e.input.charCodeAt(e.position)&&45===e.input.charCodeAt(e.position+1)&&45===e.input.charCodeAt(e.position+2)?(e.position+=3,skipSeparationSpace(e,!0,-1)):a&&throwError(e,"directives end mark is expected"),composeNode(e,e.lineIndent-1,CONTEXT_BLOCK_OUT,!1,!0),skipSeparationSpace(e,!0,-1),e.checkLineBreaks&&PATTERN_NON_ASCII_LINE_BREAKS.test(e.input.slice(r,e.position))&&throwWarning(e,"non-ASCII line breaks are interpreted as content"),e.documents.push(e.result),e.position===e.lineStart&&testDocumentSeparator(e)?void(46===e.input.charCodeAt(e.position)&&(e.position+=3,skipSeparationSpace(e,!0,-1))):void(e.position<e.length-1&&throwError(e,"end of the stream or a document separator is expected"))}function loadDocuments(e,t){e=String(e),t=t||{},0!==e.length&&(10!==e.charCodeAt(e.length-1)&&13!==e.charCodeAt(e.length-1)&&(e+="\n"),65279===e.charCodeAt(0)&&(e=e.slice(1)));var n=new State(e,t);for(n.input+="\x00";32===n.input.charCodeAt(n.position);)n.lineIndent+=1,n.position+=1;for(;n.position<n.length-1;)readDocument(n);return n.documents}function loadAll(e,t,n){var i,o,r=loadDocuments(e,n);for(i=0,o=r.length;o>i;i+=1)t(r[i])}function load(e,t){var n=loadDocuments(e,t);if(0!==n.length){if(1===n.length)return n[0];throw new YAMLException("expected a single document in the stream, but found more")}}function safeLoadAll(e,t,n){loadAll(e,t,common.extend({schema:DEFAULT_SAFE_SCHEMA},n))}function safeLoad(e,t){return load(e,common.extend({schema:DEFAULT_SAFE_SCHEMA},t))}for(var common=require("./common"),YAMLException=require("./exception"),Mark=require("./mark"),DEFAULT_SAFE_SCHEMA=require("./schema/default_safe"),DEFAULT_FULL_SCHEMA=require("./schema/default_full"),_hasOwnProperty=Object.prototype.hasOwnProperty,CONTEXT_FLOW_IN=1,CONTEXT_FLOW_OUT=2,CONTEXT_BLOCK_IN=3,CONTEXT_BLOCK_OUT=4,CHOMPING_CLIP=1,CHOMPING_STRIP=2,CHOMPING_KEEP=3,PATTERN_NON_PRINTABLE=/[\x00-\x08\x0B\x0C\x0E-\x1F\x7F-\x84\x86-\x9F\uFFFE\uFFFF]|[\uD800-\uDBFF](?![\uDC00-\uDFFF])|(?:[^\uD800-\uDBFF]|^)[\uDC00-\uDFFF]/,PATTERN_NON_ASCII_LINE_BREAKS=/[\x85\u2028\u2029]/,PATTERN_FLOW_INDICATORS=/[,\[\]\{\}]/,PATTERN_TAG_HANDLE=/^(?:!|!!|![a-z\-]+!)$/i,PATTERN_TAG_URI=/^(?:!|[^,\[\]\{\}])(?:%[0-9a-f]{2}|[0-9a-z\-#;\/\?:@&=\+\$,_\.!~\*'\(\)\[\]])*$/i,simpleEscapeCheck=new Array(256),simpleEscapeMap=new Array(256),i=0;256>i;i++)simpleEscapeCheck[i]=simpleEscapeSequence(i)?1:0,simpleEscapeMap[i]=simpleEscapeSequence(i);var directiveHandlers={YAML:function(e,t,n){var i,o,r;null!==e.version&&throwError(e,"duplication of %YAML directive"),1!==n.length&&throwError(e,"YAML directive accepts exactly one argument"),i=/^([0-9]+)\.([0-9]+)$/.exec(n[0]),null===i&&throwError(e,"ill-formed argument of the YAML directive"),o=parseInt(i[1],10),r=parseInt(i[2],10),1!==o&&throwError(e,"unacceptable YAML version of the document"),e.version=n[0],e.checkLineBreaks=2>r,1!==r&&2!==r&&throwWarning(e,"unsupported YAML version of the document")},TAG:function(e,t,n){var i,o;2!==n.length&&throwError(e,"TAG directive accepts exactly two arguments"),i=n[0],o=n[1],PATTERN_TAG_HANDLE.test(i)||throwError(e,"ill-formed tag handle (first argument) of the TAG directive"),_hasOwnProperty.call(e.tagMap,i)&&throwError(e,'there is a previously declared suffix for "'+i+'" tag handle'),PATTERN_TAG_URI.test(o)||throwError(e,"ill-formed tag prefix (second argument) of the TAG directive"),e.tagMap[i]=o}};module.exports.loadAll=loadAll,module.exports.load=load,module.exports.safeLoadAll=safeLoadAll,module.exports.safeLoad=safeLoad;


},{"./common":21,"./exception":23,"./mark":25,"./schema/default_full":28,"./schema/default_safe":29}],25:[function(require,module,exports){
"use strict";function Mark(t,i,n,e,r){this.name=t,this.buffer=i,this.position=n,this.line=e,this.column=r}var common=require("./common");Mark.prototype.getSnippet=function(t,i){var n,e,r,o,s;if(!this.buffer)return null;for(t=t||4,i=i||75,n="",e=this.position;e>0&&-1==="\x00\r\n\u2028\u2029".indexOf(this.buffer.charAt(e-1));)if(e-=1,this.position-e>i/2-1){n=" ... ",e+=5;break}for(r="",o=this.position;o<this.buffer.length&&-1==="\x00\r\n\u2028\u2029".indexOf(this.buffer.charAt(o));)if(o+=1,o-this.position>i/2-1){r=" ... ",o-=5;break}return s=this.buffer.slice(e,o),common.repeat(" ",t)+n+s+r+"\n"+common.repeat(" ",t+this.position-e+n.length)+"^"},Mark.prototype.toString=function(t){var i,n="";return this.name&&(n+='in "'+this.name+'" '),n+="at line "+(this.line+1)+", column "+(this.column+1),t||(i=this.getSnippet(),i&&(n+=":\n"+i)),n},module.exports=Mark;


},{"./common":21}],26:[function(require,module,exports){
"use strict";function compileList(i,e,t){var c=[];return i.include.forEach(function(i){t=compileList(i,e,t)}),i[e].forEach(function(i){t.forEach(function(e,t){e.tag===i.tag&&c.push(t)}),t.push(i)}),t.filter(function(i,e){return-1===c.indexOf(e)})}function compileMap(){function i(i){c[i.tag]=i}var e,t,c={};for(e=0,t=arguments.length;t>e;e+=1)arguments[e].forEach(i);return c}function Schema(i){this.include=i.include||[],this.implicit=i.implicit||[],this.explicit=i.explicit||[],this.implicit.forEach(function(i){if(i.loadKind&&"scalar"!==i.loadKind)throw new YAMLException("There is a non-scalar type in the implicit list of a schema. Implicit resolving of such types is not supported.")}),this.compiledImplicit=compileList(this,"implicit",[]),this.compiledExplicit=compileList(this,"explicit",[]),this.compiledTypeMap=compileMap(this.compiledImplicit,this.compiledExplicit)}var common=require("./common"),YAMLException=require("./exception"),Type=require("./type");Schema.DEFAULT=null,Schema.create=function(){var i,e;switch(arguments.length){case 1:i=Schema.DEFAULT,e=arguments[0];break;case 2:i=arguments[0],e=arguments[1];break;default:throw new YAMLException("Wrong number of arguments for Schema.create function")}if(i=common.toArray(i),e=common.toArray(e),!i.every(function(i){return i instanceof Schema}))throw new YAMLException("Specified list of super schemas (or a single Schema object) contains a non-Schema object.");if(!e.every(function(i){return i instanceof Type}))throw new YAMLException("Specified list of YAML types (or a single Type object) contains a non-Type object.");return new Schema({include:i,explicit:e})},module.exports=Schema;


},{"./common":21,"./exception":23,"./type":32}],27:[function(require,module,exports){
"use strict";var Schema=require("../schema");module.exports=new Schema({include:[require("./json")]});


},{"../schema":26,"./json":31}],28:[function(require,module,exports){
"use strict";var Schema=require("../schema");module.exports=Schema.DEFAULT=new Schema({include:[require("./default_safe")],explicit:[require("../type/js/undefined"),require("../type/js/regexp"),require("../type/js/function")]});


},{"../schema":26,"../type/js/function":37,"../type/js/regexp":38,"../type/js/undefined":39,"./default_safe":29}],29:[function(require,module,exports){
"use strict";var Schema=require("../schema");module.exports=new Schema({include:[require("./core")],implicit:[require("../type/timestamp"),require("../type/merge")],explicit:[require("../type/binary"),require("../type/omap"),require("../type/pairs"),require("../type/set")]});


},{"../schema":26,"../type/binary":33,"../type/merge":41,"../type/omap":43,"../type/pairs":44,"../type/set":46,"../type/timestamp":48,"./core":27}],30:[function(require,module,exports){
"use strict";var Schema=require("../schema");module.exports=new Schema({explicit:[require("../type/str"),require("../type/seq"),require("../type/map")]});


},{"../schema":26,"../type/map":40,"../type/seq":45,"../type/str":47}],31:[function(require,module,exports){
"use strict";var Schema=require("../schema");module.exports=new Schema({include:[require("./failsafe")],implicit:[require("../type/null"),require("../type/bool"),require("../type/int"),require("../type/float")]});


},{"../schema":26,"../type/bool":34,"../type/float":35,"../type/int":36,"../type/null":42,"./failsafe":30}],32:[function(require,module,exports){
"use strict";function compileStyleAliases(e){var t={};return null!==e&&Object.keys(e).forEach(function(n){e[n].forEach(function(e){t[String(e)]=n})}),t}function Type(e,t){if(t=t||{},Object.keys(t).forEach(function(t){if(-1===TYPE_CONSTRUCTOR_OPTIONS.indexOf(t))throw new YAMLException('Unknown option "'+t+'" is met in definition of "'+e+'" YAML type.')}),this.tag=e,this.kind=t.kind||null,this.resolve=t.resolve||function(){return!0},this.construct=t.construct||function(e){return e},this.instanceOf=t.instanceOf||null,this.predicate=t.predicate||null,this.represent=t.represent||null,this.defaultStyle=t.defaultStyle||null,this.styleAliases=compileStyleAliases(t.styleAliases||null),-1===YAML_NODE_KINDS.indexOf(this.kind))throw new YAMLException('Unknown kind "'+this.kind+'" is specified for "'+e+'" YAML type.')}var YAMLException=require("./exception"),TYPE_CONSTRUCTOR_OPTIONS=["kind","resolve","construct","instanceOf","predicate","represent","defaultStyle","styleAliases"],YAML_NODE_KINDS=["scalar","sequence","mapping"];module.exports=Type;


},{"./exception":23}],33:[function(require,module,exports){
"use strict";function resolveYamlBinary(r){if(null===r)return!1;var e,n,u=0,t=r.length,a=BASE64_MAP;for(n=0;t>n;n++)if(e=a.indexOf(r.charAt(n)),!(e>64)){if(0>e)return!1;u+=6}return u%8===0}function constructYamlBinary(r){var e,n,u=r.replace(/[\r\n=]/g,""),t=u.length,a=BASE64_MAP,f=0,i=[];for(e=0;t>e;e++)e%4===0&&e&&(i.push(f>>16&255),i.push(f>>8&255),i.push(255&f)),f=f<<6|a.indexOf(u.charAt(e));return n=t%4*6,0===n?(i.push(f>>16&255),i.push(f>>8&255),i.push(255&f)):18===n?(i.push(f>>10&255),i.push(f>>2&255)):12===n&&i.push(f>>4&255),NodeBuffer?new NodeBuffer(i):i}function representYamlBinary(r){var e,n,u="",t=0,a=r.length,f=BASE64_MAP;for(e=0;a>e;e++)e%3===0&&e&&(u+=f[t>>18&63],u+=f[t>>12&63],u+=f[t>>6&63],u+=f[63&t]),t=(t<<8)+r[e];return n=a%3,0===n?(u+=f[t>>18&63],u+=f[t>>12&63],u+=f[t>>6&63],u+=f[63&t]):2===n?(u+=f[t>>10&63],u+=f[t>>4&63],u+=f[t<<2&63],u+=f[64]):1===n&&(u+=f[t>>2&63],u+=f[t<<4&63],u+=f[64],u+=f[64]),u}function isBinary(r){return NodeBuffer&&NodeBuffer.isBuffer(r)}var NodeBuffer;try{var _require=require;NodeBuffer=_require("buffer").Buffer}catch(__){}var Type=require("../type"),BASE64_MAP="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\n\r";module.exports=new Type("tag:yaml.org,2002:binary",{kind:"scalar",resolve:resolveYamlBinary,construct:constructYamlBinary,predicate:isBinary,represent:representYamlBinary});


},{"../type":32}],34:[function(require,module,exports){
"use strict";function resolveYamlBoolean(e){if(null===e)return!1;var r=e.length;return 4===r&&("true"===e||"True"===e||"TRUE"===e)||5===r&&("false"===e||"False"===e||"FALSE"===e)}function constructYamlBoolean(e){return"true"===e||"True"===e||"TRUE"===e}function isBoolean(e){return"[object Boolean]"===Object.prototype.toString.call(e)}var Type=require("../type");module.exports=new Type("tag:yaml.org,2002:bool",{kind:"scalar",resolve:resolveYamlBoolean,construct:constructYamlBoolean,predicate:isBoolean,represent:{lowercase:function(e){return e?"true":"false"},uppercase:function(e){return e?"TRUE":"FALSE"},camelcase:function(e){return e?"True":"False"}},defaultStyle:"lowercase"});


},{"../type":32}],35:[function(require,module,exports){
"use strict";function resolveYamlFloat(e){return null===e?!1:!!YAML_FLOAT_PATTERN.test(e)}function constructYamlFloat(e){var r,t,a,n;return r=e.replace(/_/g,"").toLowerCase(),t="-"===r[0]?-1:1,n=[],"+-".indexOf(r[0])>=0&&(r=r.slice(1)),".inf"===r?1===t?Number.POSITIVE_INFINITY:Number.NEGATIVE_INFINITY:".nan"===r?NaN:r.indexOf(":")>=0?(r.split(":").forEach(function(e){n.unshift(parseFloat(e,10))}),r=0,a=1,n.forEach(function(e){r+=e*a,a*=60}),t*r):t*parseFloat(r,10)}function representYamlFloat(e,r){var t;if(isNaN(e))switch(r){case"lowercase":return".nan";case"uppercase":return".NAN";case"camelcase":return".NaN"}else if(Number.POSITIVE_INFINITY===e)switch(r){case"lowercase":return".inf";case"uppercase":return".INF";case"camelcase":return".Inf"}else if(Number.NEGATIVE_INFINITY===e)switch(r){case"lowercase":return"-.inf";case"uppercase":return"-.INF";case"camelcase":return"-.Inf"}else if(common.isNegativeZero(e))return"-0.0";return t=e.toString(10),SCIENTIFIC_WITHOUT_DOT.test(t)?t.replace("e",".e"):t}function isFloat(e){return"[object Number]"===Object.prototype.toString.call(e)&&(e%1!==0||common.isNegativeZero(e))}var common=require("../common"),Type=require("../type"),YAML_FLOAT_PATTERN=new RegExp("^(?:[-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+][0-9]+)?|\\.[0-9_]+(?:[eE][-+][0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$"),SCIENTIFIC_WITHOUT_DOT=/^[-+]?[0-9]+e/;module.exports=new Type("tag:yaml.org,2002:float",{kind:"scalar",resolve:resolveYamlFloat,construct:constructYamlFloat,predicate:isFloat,represent:representYamlFloat,defaultStyle:"lowercase"});


},{"../common":21,"../type":32}],36:[function(require,module,exports){
"use strict";function isHexCode(e){return e>=48&&57>=e||e>=65&&70>=e||e>=97&&102>=e}function isOctCode(e){return e>=48&&55>=e}function isDecCode(e){return e>=48&&57>=e}function resolveYamlInteger(e){if(null===e)return!1;var r,t=e.length,n=0,i=!1;if(!t)return!1;if(r=e[n],"-"!==r&&"+"!==r||(r=e[++n]),"0"===r){if(n+1===t)return!0;if(r=e[++n],"b"===r){for(n++;t>n;n++)if(r=e[n],"_"!==r){if("0"!==r&&"1"!==r)return!1;i=!0}return i}if("x"===r){for(n++;t>n;n++)if(r=e[n],"_"!==r){if(!isHexCode(e.charCodeAt(n)))return!1;i=!0}return i}for(;t>n;n++)if(r=e[n],"_"!==r){if(!isOctCode(e.charCodeAt(n)))return!1;i=!0}return i}for(;t>n;n++)if(r=e[n],"_"!==r){if(":"===r)break;if(!isDecCode(e.charCodeAt(n)))return!1;i=!0}return i?":"!==r?!0:/^(:[0-5]?[0-9])+$/.test(e.slice(n)):!1}function constructYamlInteger(e){var r,t,n=e,i=1,o=[];return-1!==n.indexOf("_")&&(n=n.replace(/_/g,"")),r=n[0],"-"!==r&&"+"!==r||("-"===r&&(i=-1),n=n.slice(1),r=n[0]),"0"===n?0:"0"===r?"b"===n[1]?i*parseInt(n.slice(2),2):"x"===n[1]?i*parseInt(n,16):i*parseInt(n,8):-1!==n.indexOf(":")?(n.split(":").forEach(function(e){o.unshift(parseInt(e,10))}),n=0,t=1,o.forEach(function(e){n+=e*t,t*=60}),i*n):i*parseInt(n,10)}function isInteger(e){return"[object Number]"===Object.prototype.toString.call(e)&&e%1===0&&!common.isNegativeZero(e)}var common=require("../common"),Type=require("../type");module.exports=new Type("tag:yaml.org,2002:int",{kind:"scalar",resolve:resolveYamlInteger,construct:constructYamlInteger,predicate:isInteger,represent:{binary:function(e){return"0b"+e.toString(2)},octal:function(e){return"0"+e.toString(8)},decimal:function(e){return e.toString(10)},hexadecimal:function(e){return"0x"+e.toString(16).toUpperCase()}},defaultStyle:"decimal",styleAliases:{binary:[2,"bin"],octal:[8,"oct"],decimal:[10,"dec"],hexadecimal:[16,"hex"]}});


},{"../common":21,"../type":32}],37:[function(require,module,exports){
"use strict";function resolveJavascriptFunction(e){if(null===e)return!1;try{var r="("+e+")",n=esprima.parse(r,{range:!0});return"Program"===n.type&&1===n.body.length&&"ExpressionStatement"===n.body[0].type&&"FunctionExpression"===n.body[0].expression.type}catch(t){return!1}}function constructJavascriptFunction(e){var r,n="("+e+")",t=esprima.parse(n,{range:!0}),o=[];if("Program"!==t.type||1!==t.body.length||"ExpressionStatement"!==t.body[0].type||"FunctionExpression"!==t.body[0].expression.type)throw new Error("Failed to resolve function");return t.body[0].expression.params.forEach(function(e){o.push(e.name)}),r=t.body[0].expression.body.range,new Function(o,n.slice(r[0]+1,r[1]-1))}function representJavascriptFunction(e){return e.toString()}function isFunction(e){return"[object Function]"===Object.prototype.toString.call(e)}var esprima;try{var _require=require;esprima=_require("esprima")}catch(_){"undefined"!=typeof window&&(esprima=window.esprima)}var Type=require("../../type");module.exports=new Type("tag:yaml.org,2002:js/function",{kind:"scalar",resolve:resolveJavascriptFunction,construct:constructJavascriptFunction,predicate:isFunction,represent:representJavascriptFunction});


},{"../../type":32}],38:[function(require,module,exports){
"use strict";function resolveJavascriptRegExp(e){if(null===e)return!1;if(0===e.length)return!1;var r=e,t=/\/([gim]*)$/.exec(e),n="";if("/"===r[0]){if(t&&(n=t[1]),n.length>3)return!1;if("/"!==r[r.length-n.length-1])return!1}return!0}function constructJavascriptRegExp(e){var r=e,t=/\/([gim]*)$/.exec(e),n="";return"/"===r[0]&&(t&&(n=t[1]),r=r.slice(1,r.length-n.length-1)),new RegExp(r,n)}function representJavascriptRegExp(e){var r="/"+e.source+"/";return e.global&&(r+="g"),e.multiline&&(r+="m"),e.ignoreCase&&(r+="i"),r}function isRegExp(e){return"[object RegExp]"===Object.prototype.toString.call(e)}var Type=require("../../type");module.exports=new Type("tag:yaml.org,2002:js/regexp",{kind:"scalar",resolve:resolveJavascriptRegExp,construct:constructJavascriptRegExp,predicate:isRegExp,represent:representJavascriptRegExp});


},{"../../type":32}],39:[function(require,module,exports){
"use strict";function resolveJavascriptUndefined(){return!0}function constructJavascriptUndefined(){}function representJavascriptUndefined(){return""}function isUndefined(e){return"undefined"==typeof e}var Type=require("../../type");module.exports=new Type("tag:yaml.org,2002:js/undefined",{kind:"scalar",resolve:resolveJavascriptUndefined,construct:constructJavascriptUndefined,predicate:isUndefined,represent:representJavascriptUndefined});


},{"../../type":32}],40:[function(require,module,exports){
"use strict";var Type=require("../type");module.exports=new Type("tag:yaml.org,2002:map",{kind:"mapping",construct:function(e){return null!==e?e:{}}});


},{"../type":32}],41:[function(require,module,exports){
"use strict";function resolveYamlMerge(e){return"<<"===e||null===e}var Type=require("../type");module.exports=new Type("tag:yaml.org,2002:merge",{kind:"scalar",resolve:resolveYamlMerge});


},{"../type":32}],42:[function(require,module,exports){
"use strict";function resolveYamlNull(l){if(null===l)return!0;var e=l.length;return 1===e&&"~"===l||4===e&&("null"===l||"Null"===l||"NULL"===l)}function constructYamlNull(){return null}function isNull(l){return null===l}var Type=require("../type");module.exports=new Type("tag:yaml.org,2002:null",{kind:"scalar",resolve:resolveYamlNull,construct:constructYamlNull,predicate:isNull,represent:{canonical:function(){return"~"},lowercase:function(){return"null"},uppercase:function(){return"NULL"},camelcase:function(){return"Null"}},defaultStyle:"lowercase"});


},{"../type":32}],43:[function(require,module,exports){
"use strict";function resolveYamlOmap(r){if(null===r)return!0;var t,e,n,o,u,a=[],l=r;for(t=0,e=l.length;e>t;t+=1){if(n=l[t],u=!1,"[object Object]"!==_toString.call(n))return!1;for(o in n)if(_hasOwnProperty.call(n,o)){if(u)return!1;u=!0}if(!u)return!1;if(-1!==a.indexOf(o))return!1;a.push(o)}return!0}function constructYamlOmap(r){return null!==r?r:[]}var Type=require("../type"),_hasOwnProperty=Object.prototype.hasOwnProperty,_toString=Object.prototype.toString;module.exports=new Type("tag:yaml.org,2002:omap",{kind:"sequence",resolve:resolveYamlOmap,construct:constructYamlOmap});


},{"../type":32}],44:[function(require,module,exports){
"use strict";function resolveYamlPairs(r){if(null===r)return!0;var e,t,n,l,o,a=r;for(o=new Array(a.length),e=0,t=a.length;t>e;e+=1){if(n=a[e],"[object Object]"!==_toString.call(n))return!1;if(l=Object.keys(n),1!==l.length)return!1;o[e]=[l[0],n[l[0]]]}return!0}function constructYamlPairs(r){if(null===r)return[];var e,t,n,l,o,a=r;for(o=new Array(a.length),e=0,t=a.length;t>e;e+=1)n=a[e],l=Object.keys(n),o[e]=[l[0],n[l[0]]];return o}var Type=require("../type"),_toString=Object.prototype.toString;module.exports=new Type("tag:yaml.org,2002:pairs",{kind:"sequence",resolve:resolveYamlPairs,construct:constructYamlPairs});


},{"../type":32}],45:[function(require,module,exports){
"use strict";var Type=require("../type");module.exports=new Type("tag:yaml.org,2002:seq",{kind:"sequence",construct:function(e){return null!==e?e:[]}});


},{"../type":32}],46:[function(require,module,exports){
"use strict";function resolveYamlSet(e){if(null===e)return!0;var r,t=e;for(r in t)if(_hasOwnProperty.call(t,r)&&null!==t[r])return!1;return!0}function constructYamlSet(e){return null!==e?e:{}}var Type=require("../type"),_hasOwnProperty=Object.prototype.hasOwnProperty;module.exports=new Type("tag:yaml.org,2002:set",{kind:"mapping",resolve:resolveYamlSet,construct:constructYamlSet});


},{"../type":32}],47:[function(require,module,exports){
"use strict";var Type=require("../type");module.exports=new Type("tag:yaml.org,2002:str",{kind:"scalar",construct:function(r){return null!==r?r:""}});


},{"../type":32}],48:[function(require,module,exports){
"use strict";function resolveYamlTimestamp(e){return null===e?!1:null!==YAML_DATE_REGEXP.exec(e)?!0:null!==YAML_TIMESTAMP_REGEXP.exec(e)}function constructYamlTimestamp(e){var t,r,n,l,a,m,s,T,i,E,u=0,o=null;if(t=YAML_DATE_REGEXP.exec(e),null===t&&(t=YAML_TIMESTAMP_REGEXP.exec(e)),null===t)throw new Error("Date resolve error");if(r=+t[1],n=+t[2]-1,l=+t[3],!t[4])return new Date(Date.UTC(r,n,l));if(a=+t[4],m=+t[5],s=+t[6],t[7]){for(u=t[7].slice(0,3);u.length<3;)u+="0";u=+u}return t[9]&&(T=+t[10],i=+(t[11]||0),o=6e4*(60*T+i),"-"===t[9]&&(o=-o)),E=new Date(Date.UTC(r,n,l,a,m,s,u)),o&&E.setTime(E.getTime()-o),E}function representYamlTimestamp(e){return e.toISOString()}var Type=require("../type"),YAML_DATE_REGEXP=new RegExp("^([0-9][0-9][0-9][0-9])-([0-9][0-9])-([0-9][0-9])$"),YAML_TIMESTAMP_REGEXP=new RegExp("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:[Tt]|[ \\t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \\t]*(Z|([-+])([0-9][0-9]?)(?::([0-9][0-9]))?))?$");module.exports=new Type("tag:yaml.org,2002:timestamp",{kind:"scalar",resolve:resolveYamlTimestamp,construct:constructYamlTimestamp,instanceOf:Date,represent:representYamlTimestamp});


},{"../type":32}],49:[function(require,module,exports){
function indexOf(e,n,r){var a=e?e.length:0;if(!a)return-1;if("number"==typeof r)r=0>r?nativeMax(a+r,0):r;else if(r){var i=binaryIndex(e,n);return a>i&&(n===n?n===e[i]:e[i]!==e[i])?i:-1}return baseIndexOf(e,n,r||0)}var baseIndexOf=require("../internal/baseIndexOf"),binaryIndex=require("../internal/binaryIndex"),nativeMax=Math.max;module.exports=indexOf;


},{"../internal/baseIndexOf":78,"../internal/binaryIndex":92}],50:[function(require,module,exports){
function last(t){var e=t?t.length:0;return e?t[e-1]:void 0}module.exports=last;


},{}],51:[function(require,module,exports){
function lodash(r){if(isObjectLike(r)&&!isArray(r)&&!(r instanceof LazyWrapper)){if(r instanceof LodashWrapper)return r;if(hasOwnProperty.call(r,"__chain__")&&hasOwnProperty.call(r,"__wrapped__"))return wrapperClone(r)}return new LodashWrapper(r)}var LazyWrapper=require("../internal/LazyWrapper"),LodashWrapper=require("../internal/LodashWrapper"),baseLodash=require("../internal/baseLodash"),isArray=require("../lang/isArray"),isObjectLike=require("../internal/isObjectLike"),wrapperClone=require("../internal/wrapperClone"),objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty;lodash.prototype=baseLodash.prototype,module.exports=lodash;


},{"../internal/LazyWrapper":60,"../internal/LodashWrapper":61,"../internal/baseLodash":82,"../internal/isObjectLike":126,"../internal/wrapperClone":137,"../lang/isArray":140}],52:[function(require,module,exports){
module.exports=require("./forEach");


},{"./forEach":54}],53:[function(require,module,exports){
var baseEach=require("../internal/baseEach"),createFind=require("../internal/createFind"),find=createFind(baseEach);module.exports=find;


},{"../internal/baseEach":71,"../internal/createFind":102}],54:[function(require,module,exports){
var arrayEach=require("../internal/arrayEach"),baseEach=require("../internal/baseEach"),createForEach=require("../internal/createForEach"),forEach=createForEach(arrayEach,baseEach);module.exports=forEach;


},{"../internal/arrayEach":63,"../internal/baseEach":71,"../internal/createForEach":103}],55:[function(require,module,exports){
function includes(e,r,i,n){var t=e?getLength(e):0;return isLength(t)||(e=values(e),t=e.length),i="number"!=typeof i||n&&isIterateeCall(r,i,n)?0:0>i?nativeMax(t+i,0):i||0,"string"==typeof e||!isArray(e)&&isString(e)?t>=i&&e.indexOf(r,i)>-1:!!t&&baseIndexOf(e,r,i)>-1}var baseIndexOf=require("../internal/baseIndexOf"),getLength=require("../internal/getLength"),isArray=require("../lang/isArray"),isIterateeCall=require("../internal/isIterateeCall"),isLength=require("../internal/isLength"),isString=require("../lang/isString"),values=require("../object/values"),nativeMax=Math.max;module.exports=includes;


},{"../internal/baseIndexOf":78,"../internal/getLength":112,"../internal/isIterateeCall":122,"../internal/isLength":125,"../lang/isArray":140,"../lang/isString":146,"../object/values":152}],56:[function(require,module,exports){
function map(a,r,e){var i=isArray(a)?arrayMap:baseMap;return r=baseCallback(r,e,3),i(a,r)}var arrayMap=require("../internal/arrayMap"),baseCallback=require("../internal/baseCallback"),baseMap=require("../internal/baseMap"),isArray=require("../lang/isArray");module.exports=map;


},{"../internal/arrayMap":64,"../internal/baseCallback":67,"../internal/baseMap":83,"../lang/isArray":140}],57:[function(require,module,exports){
var getNative=require("../internal/getNative"),nativeNow=getNative(Date,"now"),now=nativeNow||function(){return(new Date).getTime()};module.exports=now;


},{"../internal/getNative":114}],58:[function(require,module,exports){
var createWrapper=require("../internal/createWrapper"),replaceHolders=require("../internal/replaceHolders"),restParam=require("./restParam"),BIND_FLAG=1,PARTIAL_FLAG=32,bind=restParam(function(e,r,a){var l=BIND_FLAG;if(a.length){var n=replaceHolders(a,bind.placeholder);l|=PARTIAL_FLAG}return createWrapper(e,l,r,a,n)});bind.placeholder={},module.exports=bind;


},{"../internal/createWrapper":106,"../internal/replaceHolders":132,"./restParam":59}],59:[function(require,module,exports){
function restParam(r,t){if("function"!=typeof r)throw new TypeError(FUNC_ERROR_TEXT);return t=nativeMax(void 0===t?r.length-1:+t||0,0),function(){for(var a=arguments,e=-1,n=nativeMax(a.length-t,0),i=Array(n);++e<n;)i[e]=a[t+e];switch(t){case 0:return r.call(this,i);case 1:return r.call(this,a[0],i);case 2:return r.call(this,a[0],a[1],i)}var c=Array(t+1);for(e=-1;++e<t;)c[e]=a[e];return c[t]=i,r.apply(this,c)}}var FUNC_ERROR_TEXT="Expected a function",nativeMax=Math.max;module.exports=restParam;


},{}],60:[function(require,module,exports){
function LazyWrapper(e){this.__wrapped__=e,this.__actions__=[],this.__dir__=1,this.__filtered__=!1,this.__iteratees__=[],this.__takeCount__=POSITIVE_INFINITY,this.__views__=[]}var baseCreate=require("./baseCreate"),baseLodash=require("./baseLodash"),POSITIVE_INFINITY=Number.POSITIVE_INFINITY;LazyWrapper.prototype=baseCreate(baseLodash.prototype),LazyWrapper.prototype.constructor=LazyWrapper,module.exports=LazyWrapper;


},{"./baseCreate":70,"./baseLodash":82}],61:[function(require,module,exports){
function LodashWrapper(e,a,r){this.__wrapped__=e,this.__actions__=r||[],this.__chain__=!!a}var baseCreate=require("./baseCreate"),baseLodash=require("./baseLodash");LodashWrapper.prototype=baseCreate(baseLodash.prototype),LodashWrapper.prototype.constructor=LodashWrapper,module.exports=LodashWrapper;


},{"./baseCreate":70,"./baseLodash":82}],62:[function(require,module,exports){
function arrayCopy(r,a){var o=-1,y=r.length;for(a||(a=Array(y));++o<y;)a[o]=r[o];return a}module.exports=arrayCopy;


},{}],63:[function(require,module,exports){
function arrayEach(r,a){for(var e=-1,n=r.length;++e<n&&a(r[e],e,r)!==!1;);return r}module.exports=arrayEach;


},{}],64:[function(require,module,exports){
function arrayMap(r,a){for(var e=-1,n=r.length,o=Array(n);++e<n;)o[e]=a(r[e],e,r);return o}module.exports=arrayMap;


},{}],65:[function(require,module,exports){
function arraySome(r,e){for(var o=-1,a=r.length;++o<a;)if(e(r[o],o,r))return!0;return!1}module.exports=arraySome;


},{}],66:[function(require,module,exports){
function baseAssign(e,s){return null==s?e:baseCopy(s,keys(s),e)}var baseCopy=require("./baseCopy"),keys=require("../object/keys");module.exports=baseAssign;


},{"../object/keys":149,"./baseCopy":69}],67:[function(require,module,exports){
function baseCallback(e,t,r){var a=typeof e;return"function"==a?void 0===t?e:bindCallback(e,t,r):null==e?identity:"object"==a?baseMatches(e):void 0===t?property(e):baseMatchesProperty(e,t)}var baseMatches=require("./baseMatches"),baseMatchesProperty=require("./baseMatchesProperty"),bindCallback=require("./bindCallback"),identity=require("../utility/identity"),property=require("../utility/property");module.exports=baseCallback;


},{"../utility/identity":154,"../utility/property":156,"./baseMatches":84,"./baseMatchesProperty":85,"./bindCallback":94}],68:[function(require,module,exports){
function baseClone(a,e,r,t,o,n,g){var l;if(r&&(l=o?r(a,t,o):r(a)),void 0!==l)return l;if(!isObject(a))return a;var b=isArray(a);if(b){if(l=initCloneArray(a),!e)return arrayCopy(a,l)}else{var T=objToString.call(a),i=T==funcTag;if(T!=objectTag&&T!=argsTag&&(!i||o))return cloneableTags[T]?initCloneByTag(a,T,e):o?a:{};if(isHostObject(a))return o?a:{};if(l=initCloneObject(i?{}:a),!e)return baseAssign(l,a)}n||(n=[]),g||(g=[]);for(var c=n.length;c--;)if(n[c]==a)return g[c];return n.push(a),g.push(l),(b?arrayEach:baseForOwn)(a,function(t,o){l[o]=baseClone(t,e,r,o,a,n,g)}),l}var arrayCopy=require("./arrayCopy"),arrayEach=require("./arrayEach"),baseAssign=require("./baseAssign"),baseForOwn=require("./baseForOwn"),initCloneArray=require("./initCloneArray"),initCloneByTag=require("./initCloneByTag"),initCloneObject=require("./initCloneObject"),isArray=require("../lang/isArray"),isHostObject=require("./isHostObject"),isObject=require("../lang/isObject"),argsTag="[object Arguments]",arrayTag="[object Array]",boolTag="[object Boolean]",dateTag="[object Date]",errorTag="[object Error]",funcTag="[object Function]",mapTag="[object Map]",numberTag="[object Number]",objectTag="[object Object]",regexpTag="[object RegExp]",setTag="[object Set]",stringTag="[object String]",weakMapTag="[object WeakMap]",arrayBufferTag="[object ArrayBuffer]",float32Tag="[object Float32Array]",float64Tag="[object Float64Array]",int8Tag="[object Int8Array]",int16Tag="[object Int16Array]",int32Tag="[object Int32Array]",uint8Tag="[object Uint8Array]",uint8ClampedTag="[object Uint8ClampedArray]",uint16Tag="[object Uint16Array]",uint32Tag="[object Uint32Array]",cloneableTags={};cloneableTags[argsTag]=cloneableTags[arrayTag]=cloneableTags[arrayBufferTag]=cloneableTags[boolTag]=cloneableTags[dateTag]=cloneableTags[float32Tag]=cloneableTags[float64Tag]=cloneableTags[int8Tag]=cloneableTags[int16Tag]=cloneableTags[int32Tag]=cloneableTags[numberTag]=cloneableTags[objectTag]=cloneableTags[regexpTag]=cloneableTags[stringTag]=cloneableTags[uint8Tag]=cloneableTags[uint8ClampedTag]=cloneableTags[uint16Tag]=cloneableTags[uint32Tag]=!0,cloneableTags[errorTag]=cloneableTags[funcTag]=cloneableTags[mapTag]=cloneableTags[setTag]=cloneableTags[weakMapTag]=!1;var objectProto=Object.prototype,objToString=objectProto.toString;module.exports=baseClone;


},{"../lang/isArray":140,"../lang/isObject":144,"./arrayCopy":62,"./arrayEach":63,"./baseAssign":66,"./baseForOwn":76,"./initCloneArray":116,"./initCloneByTag":117,"./initCloneObject":118,"./isHostObject":120}],69:[function(require,module,exports){
function baseCopy(e,o,r){r||(r={});for(var a=-1,n=o.length;++a<n;){var t=o[a];r[t]=e[t]}return r}module.exports=baseCopy;


},{}],70:[function(require,module,exports){
var isObject=require("../lang/isObject"),baseCreate=function(){function e(){}return function(t){if(isObject(t)){e.prototype=t;var r=new e;e.prototype=void 0}return r||{}}}();module.exports=baseCreate;


},{"../lang/isObject":144}],71:[function(require,module,exports){
var baseForOwn=require("./baseForOwn"),createBaseEach=require("./createBaseEach"),baseEach=createBaseEach(baseForOwn);module.exports=baseEach;


},{"./baseForOwn":76,"./createBaseEach":98}],72:[function(require,module,exports){
function baseFind(n,e,r,i){var o;return r(n,function(n,r,t){return e(n,r,t)?(o=i?r:n,!1):void 0}),o}module.exports=baseFind;


},{}],73:[function(require,module,exports){
function baseFindIndex(e,n,r){for(var d=e.length,t=r?d:-1;r?t--:++t<d;)if(n(e[t],t,e))return t;return-1}module.exports=baseFindIndex;


},{}],74:[function(require,module,exports){
var createBaseFor=require("./createBaseFor"),baseFor=createBaseFor();module.exports=baseFor;


},{"./createBaseFor":99}],75:[function(require,module,exports){
function baseForIn(e,r){return baseFor(e,r,keysIn)}var baseFor=require("./baseFor"),keysIn=require("../object/keysIn");module.exports=baseForIn;


},{"../object/keysIn":150,"./baseFor":74}],76:[function(require,module,exports){
function baseForOwn(e,r){return baseFor(e,r,keys)}var baseFor=require("./baseFor"),keys=require("../object/keys");module.exports=baseForOwn;


},{"../object/keys":149,"./baseFor":74}],77:[function(require,module,exports){
function baseGet(e,t,o){if(null!=e){e=toObject(e),void 0!==o&&o in e&&(t=[o]);for(var r=0,n=t.length;null!=e&&n>r;)e=toObject(e)[t[r++]];return r&&r==n?e:void 0}}var toObject=require("./toObject");module.exports=baseGet;


},{"./toObject":135}],78:[function(require,module,exports){
function baseIndexOf(e,r,n){if(r!==r)return indexOfNaN(e,n);for(var f=n-1,a=e.length;++f<a;)if(e[f]===r)return f;return-1}var indexOfNaN=require("./indexOfNaN");module.exports=baseIndexOf;


},{"./indexOfNaN":115}],79:[function(require,module,exports){
function baseIsEqual(e,s,a,u,i,b){return e===s?!0:null==e||null==s||!isObject(e)&&!isObjectLike(s)?e!==e&&s!==s:baseIsEqualDeep(e,s,baseIsEqual,a,u,i,b)}var baseIsEqualDeep=require("./baseIsEqualDeep"),isObject=require("../lang/isObject"),isObjectLike=require("./isObjectLike");module.exports=baseIsEqual;


},{"../lang/isObject":144,"./baseIsEqualDeep":80,"./isObjectLike":126}],80:[function(require,module,exports){
function baseIsEqualDeep(r,e,a,t,o,s,u){var i=isArray(r),b=isArray(e),c=arrayTag,g=arrayTag;i||(c=objToString.call(r),c==argsTag?c=objectTag:c!=objectTag&&(i=isTypedArray(r))),b||(g=objToString.call(e),g==argsTag?g=objectTag:g!=objectTag&&(b=isTypedArray(e)));var y=c==objectTag&&!isHostObject(r),j=g==objectTag&&!isHostObject(e),l=c==g;if(l&&!i&&!y)return equalByTag(r,e,c);if(!o){var p=y&&hasOwnProperty.call(r,"__wrapped__"),T=j&&hasOwnProperty.call(e,"__wrapped__");if(p||T)return a(p?r.value():r,T?e.value():e,t,o,s,u)}if(!l)return!1;s||(s=[]),u||(u=[]);for(var n=s.length;n--;)if(s[n]==r)return u[n]==e;s.push(r),u.push(e);var q=(i?equalArrays:equalObjects)(r,e,a,t,o,s,u);return s.pop(),u.pop(),q}var equalArrays=require("./equalArrays"),equalByTag=require("./equalByTag"),equalObjects=require("./equalObjects"),isArray=require("../lang/isArray"),isHostObject=require("./isHostObject"),isTypedArray=require("../lang/isTypedArray"),argsTag="[object Arguments]",arrayTag="[object Array]",objectTag="[object Object]",objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty,objToString=objectProto.toString;module.exports=baseIsEqualDeep;


},{"../lang/isArray":140,"../lang/isTypedArray":147,"./equalArrays":107,"./equalByTag":108,"./equalObjects":109,"./isHostObject":120}],81:[function(require,module,exports){
function baseIsMatch(e,r,t){var a=r.length,i=a,u=!t;if(null==e)return!i;for(e=toObject(e);a--;){var s=r[a];if(u&&s[2]?s[1]!==e[s[0]]:!(s[0]in e))return!1}for(;++a<i;){s=r[a];var n=s[0],o=e[n],b=s[1];if(u&&s[2]){if(void 0===o&&!(n in e))return!1}else{var f=t?t(o,b,n):void 0;if(!(void 0===f?baseIsEqual(b,o,t,!0):f))return!1}}return!0}var baseIsEqual=require("./baseIsEqual"),toObject=require("./toObject");module.exports=baseIsMatch;


},{"./baseIsEqual":79,"./toObject":135}],82:[function(require,module,exports){
function baseLodash(){}module.exports=baseLodash;


},{}],83:[function(require,module,exports){
function baseMap(r,a){var e=-1,i=isArrayLike(r)?Array(r.length):[];return baseEach(r,function(r,s,n){i[++e]=a(r,s,n)}),i}var baseEach=require("./baseEach"),isArrayLike=require("./isArrayLike");module.exports=baseMap;


},{"./baseEach":71,"./isArrayLike":119}],84:[function(require,module,exports){
function baseMatches(t){var e=getMatchData(t);if(1==e.length&&e[0][2]){var a=e[0][0],r=e[0][1];return function(t){return null==t?!1:(t=toObject(t),t[a]===r&&(void 0!==r||a in t))}}return function(t){return baseIsMatch(t,e)}}var baseIsMatch=require("./baseIsMatch"),getMatchData=require("./getMatchData"),toObject=require("./toObject");module.exports=baseMatches;


},{"./baseIsMatch":81,"./getMatchData":113,"./toObject":135}],85:[function(require,module,exports){
function baseMatchesProperty(e,r){var t=isArray(e),a=isKey(e)&&isStrictComparable(r),i=e+"";return e=toPath(e),function(s){if(null==s)return!1;var u=i;if(s=toObject(s),(t||!a)&&!(u in s)){if(s=1==e.length?s:baseGet(s,baseSlice(e,0,-1)),null==s)return!1;u=last(e),s=toObject(s)}return s[u]===r?void 0!==r||u in s:baseIsEqual(r,s[u],void 0,!0)}}var baseGet=require("./baseGet"),baseIsEqual=require("./baseIsEqual"),baseSlice=require("./baseSlice"),isArray=require("../lang/isArray"),isKey=require("./isKey"),isStrictComparable=require("./isStrictComparable"),last=require("../array/last"),toObject=require("./toObject"),toPath=require("./toPath");module.exports=baseMatchesProperty;


},{"../array/last":50,"../lang/isArray":140,"./baseGet":77,"./baseIsEqual":79,"./baseSlice":89,"./isKey":123,"./isStrictComparable":127,"./toObject":135,"./toPath":136}],86:[function(require,module,exports){
function baseProperty(e){return function(t){return null==t?void 0:toObject(t)[e]}}var toObject=require("./toObject");module.exports=baseProperty;


},{"./toObject":135}],87:[function(require,module,exports){
function basePropertyDeep(e){var t=e+"";return e=toPath(e),function(r){return baseGet(r,e,t)}}var baseGet=require("./baseGet"),toPath=require("./toPath");module.exports=basePropertyDeep;


},{"./baseGet":77,"./toPath":136}],88:[function(require,module,exports){
var identity=require("../utility/identity"),metaMap=require("./metaMap"),baseSetData=metaMap?function(t,e){return metaMap.set(t,e),t}:identity;module.exports=baseSetData;


},{"../utility/identity":154,"./metaMap":129}],89:[function(require,module,exports){
function baseSlice(e,r,l){var a=-1,n=e.length;r=null==r?0:+r||0,0>r&&(r=-r>n?0:n+r),l=void 0===l||l>n?n:+l||0,0>l&&(l+=n),n=r>l?0:l-r>>>0,r>>>=0;for(var o=Array(n);++a<n;)o[a]=e[a+r];return o}module.exports=baseSlice;


},{}],90:[function(require,module,exports){
function baseToString(n){return null==n?"":n+""}module.exports=baseToString;


},{}],91:[function(require,module,exports){
function baseValues(e,r){for(var a=-1,s=r.length,u=Array(s);++a<s;)u[a]=e[r[a]];return u}module.exports=baseValues;


},{}],92:[function(require,module,exports){
function binaryIndex(n,e,r){var i=0,t=n?n.length:i;if("number"==typeof e&&e===e&&HALF_MAX_ARRAY_LENGTH>=t){for(;t>i;){var A=i+t>>>1,y=n[A];(r?e>=y:e>y)&&null!==y?i=A+1:t=A}return t}return binaryIndexBy(n,e,identity,r)}var binaryIndexBy=require("./binaryIndexBy"),identity=require("../utility/identity"),MAX_ARRAY_LENGTH=4294967295,HALF_MAX_ARRAY_LENGTH=MAX_ARRAY_LENGTH>>>1;module.exports=binaryIndex;


},{"../utility/identity":154,"./binaryIndexBy":93}],93:[function(require,module,exports){
function binaryIndexBy(n,i,r,a){i=r(i);for(var e=0,l=n?n.length:0,o=i!==i,A=null===i,t=void 0===i;l>e;){var v=nativeFloor((e+l)/2),M=r(n[v]),R=void 0!==M,_=M===M;if(o)var u=_||a;else u=A?_&&R&&(a||null!=M):t?_&&(a||R):null==M?!1:a?i>=M:i>M;u?e=v+1:l=v}return nativeMin(l,MAX_ARRAY_INDEX)}var nativeFloor=Math.floor,nativeMin=Math.min,MAX_ARRAY_LENGTH=4294967295,MAX_ARRAY_INDEX=MAX_ARRAY_LENGTH-1;module.exports=binaryIndexBy;


},{}],94:[function(require,module,exports){
function bindCallback(n,t,r){if("function"!=typeof n)return identity;if(void 0===t)return n;switch(r){case 1:return function(r){return n.call(t,r)};case 3:return function(r,e,i){return n.call(t,r,e,i)};case 4:return function(r,e,i,u){return n.call(t,r,e,i,u)};case 5:return function(r,e,i,u,c){return n.call(t,r,e,i,u,c)}}return function(){return n.apply(t,arguments)}}var identity=require("../utility/identity");module.exports=bindCallback;


},{"../utility/identity":154}],95:[function(require,module,exports){
(function (global){
function bufferClone(r){var e=new ArrayBuffer(r.byteLength),n=new Uint8Array(e);return n.set(new Uint8Array(r)),e}var ArrayBuffer=global.ArrayBuffer,Uint8Array=global.Uint8Array;module.exports=bufferClone;


}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{}],96:[function(require,module,exports){
function composeArgs(r,e,o){for(var a=o.length,t=-1,n=nativeMax(r.length-a,0),g=-1,s=e.length,f=Array(s+n);++g<s;)f[g]=e[g];for(;++t<a;)f[o[t]]=r[t];for(;n--;)f[g++]=r[t++];return f}var nativeMax=Math.max;module.exports=composeArgs;


},{}],97:[function(require,module,exports){
function composeArgsRight(r,t,a){for(var e=-1,o=a.length,n=-1,g=nativeMax(r.length-o,0),h=-1,i=t.length,s=Array(g+i);++n<g;)s[n]=r[n];for(var v=n;++h<i;)s[v+h]=t[h];for(;++e<o;)s[v+a[e]]=r[n++];return s}var nativeMax=Math.max;module.exports=composeArgsRight;


},{}],98:[function(require,module,exports){
function createBaseEach(e,t){return function(r,n){var a=r?getLength(r):0;if(!isLength(a))return e(r,n);for(var c=t?a:-1,g=toObject(r);(t?c--:++c<a)&&n(g[c],c,g)!==!1;);return r}}var getLength=require("./getLength"),isLength=require("./isLength"),toObject=require("./toObject");module.exports=createBaseEach;


},{"./getLength":112,"./isLength":125,"./toObject":135}],99:[function(require,module,exports){
function createBaseFor(e){return function(r,t,o){for(var a=toObject(r),c=o(r),n=c.length,u=e?n:-1;e?u--:++u<n;){var b=c[u];if(t(a[b],b,a)===!1)break}return r}}var toObject=require("./toObject");module.exports=createBaseFor;


},{"./toObject":135}],100:[function(require,module,exports){
(function (global){
function createBindWrapper(r,e){function t(){var p=this&&this!==global&&this instanceof t?a:r;return p.apply(e,arguments)}var a=createCtorWrapper(r);return t}var createCtorWrapper=require("./createCtorWrapper");module.exports=createBindWrapper;


}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{"./createCtorWrapper":101}],101:[function(require,module,exports){
function createCtorWrapper(e){return function(){var r=arguments;switch(r.length){case 0:return new e;case 1:return new e(r[0]);case 2:return new e(r[0],r[1]);case 3:return new e(r[0],r[1],r[2]);case 4:return new e(r[0],r[1],r[2],r[3]);case 5:return new e(r[0],r[1],r[2],r[3],r[4]);case 6:return new e(r[0],r[1],r[2],r[3],r[4],r[5]);case 7:return new e(r[0],r[1],r[2],r[3],r[4],r[5],r[6])}var t=baseCreate(e.prototype),n=e.apply(t,r);return isObject(n)?n:t}}var baseCreate=require("./baseCreate"),isObject=require("../lang/isObject");module.exports=createCtorWrapper;


},{"../lang/isObject":144,"./baseCreate":70}],102:[function(require,module,exports){
function createFind(e,r){return function(a,i,n){if(i=baseCallback(i,n,3),isArray(a)){var d=baseFindIndex(a,i,r);return d>-1?a[d]:void 0}return baseFind(a,i,e)}}var baseCallback=require("./baseCallback"),baseFind=require("./baseFind"),baseFindIndex=require("./baseFindIndex"),isArray=require("../lang/isArray");module.exports=createFind;


},{"../lang/isArray":140,"./baseCallback":67,"./baseFind":72,"./baseFindIndex":73}],103:[function(require,module,exports){
function createForEach(r,a){return function(e,i,n){return"function"==typeof i&&void 0===n&&isArray(e)?r(e,i):a(e,bindCallback(i,n,3))}}var bindCallback=require("./bindCallback"),isArray=require("../lang/isArray");module.exports=createForEach;


},{"../lang/isArray":140,"./bindCallback":94}],104:[function(require,module,exports){
(function (global){
function createHybridWrapper(r,e,a,o,A,i,t,p,_,L){function R(){for(var v=arguments.length,n=v,g=Array(v);n--;)g[n]=arguments[n];if(o&&(g=composeArgs(g,o,A)),i&&(g=composeArgsRight(g,i,t)),c||d){var h=R.placeholder,u=replaceHolders(g,h);if(v-=u.length,L>v){var C=p?arrayCopy(p):void 0,y=nativeMax(L-v,0),D=c?u:void 0,H=c?void 0:u,T=c?g:void 0,Y=c?void 0:g;e|=c?PARTIAL_FLAG:PARTIAL_RIGHT_FLAG,e&=~(c?PARTIAL_RIGHT_FLAG:PARTIAL_FLAG),F||(e&=~(BIND_FLAG|BIND_KEY_FLAG));var m=[r,e,a,T,D,Y,H,C,_,y],q=createHybridWrapper.apply(void 0,m);return isLaziable(r)&&setData(q,m),q.placeholder=h,q}}var B=G?a:this,N=l?B[r]:r;return p&&(g=reorder(g,p)),s&&_<g.length&&(g.length=_),this&&this!==global&&this instanceof R&&(N=I||createCtorWrapper(r)),N.apply(B,g)}var s=e&ARY_FLAG,G=e&BIND_FLAG,l=e&BIND_KEY_FLAG,c=e&CURRY_FLAG,F=e&CURRY_BOUND_FLAG,d=e&CURRY_RIGHT_FLAG,I=l?void 0:createCtorWrapper(r);return R}var arrayCopy=require("./arrayCopy"),composeArgs=require("./composeArgs"),composeArgsRight=require("./composeArgsRight"),createCtorWrapper=require("./createCtorWrapper"),isLaziable=require("./isLaziable"),reorder=require("./reorder"),replaceHolders=require("./replaceHolders"),setData=require("./setData"),BIND_FLAG=1,BIND_KEY_FLAG=2,CURRY_BOUND_FLAG=4,CURRY_FLAG=8,CURRY_RIGHT_FLAG=16,PARTIAL_FLAG=32,PARTIAL_RIGHT_FLAG=64,ARY_FLAG=128,nativeMax=Math.max;module.exports=createHybridWrapper;


}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{"./arrayCopy":62,"./composeArgs":96,"./composeArgsRight":97,"./createCtorWrapper":101,"./isLaziable":124,"./reorder":131,"./replaceHolders":132,"./setData":133}],105:[function(require,module,exports){
(function (global){
function createPartialWrapper(r,e,a,t){function p(){for(var e=-1,n=arguments.length,c=-1,l=t.length,h=Array(l+n);++c<l;)h[c]=t[c];for(;n--;)h[c++]=arguments[++e];var s=this&&this!==global&&this instanceof p?i:r;return s.apply(o?a:this,h)}var o=e&BIND_FLAG,i=createCtorWrapper(r);return p}var createCtorWrapper=require("./createCtorWrapper"),BIND_FLAG=1;module.exports=createPartialWrapper;


}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{"./createCtorWrapper":101}],106:[function(require,module,exports){
function createWrapper(e,a,r,t,p,i,A,_){var L=a&BIND_KEY_FLAG;if(!L&&"function"!=typeof e)throw new TypeError(FUNC_ERROR_TEXT);var n=t?t.length:0;if(n||(a&=~(PARTIAL_FLAG|PARTIAL_RIGHT_FLAG),t=p=void 0),n-=p?p.length:0,a&PARTIAL_RIGHT_FLAG){var D=t,R=p;t=p=void 0}var c=L?void 0:getData(e),G=[e,a,r,t,p,D,R,i,A,_];if(c&&(mergeData(G,c),a=G[1],_=G[9]),G[9]=null==_?L?0:e.length:nativeMax(_-n,0)||0,a==BIND_FLAG)var I=createBindWrapper(G[0],G[2]);else I=a!=PARTIAL_FLAG&&a!=(BIND_FLAG|PARTIAL_FLAG)||G[4].length?createHybridWrapper.apply(void 0,G):createPartialWrapper.apply(void 0,G);var T=c?baseSetData:setData;return T(I,G)}var baseSetData=require("./baseSetData"),createBindWrapper=require("./createBindWrapper"),createHybridWrapper=require("./createHybridWrapper"),createPartialWrapper=require("./createPartialWrapper"),getData=require("./getData"),mergeData=require("./mergeData"),setData=require("./setData"),BIND_FLAG=1,BIND_KEY_FLAG=2,PARTIAL_FLAG=32,PARTIAL_RIGHT_FLAG=64,FUNC_ERROR_TEXT="Expected a function",nativeMax=Math.max;module.exports=createWrapper;


},{"./baseSetData":88,"./createBindWrapper":100,"./createHybridWrapper":104,"./createPartialWrapper":105,"./getData":110,"./mergeData":128,"./setData":133}],107:[function(require,module,exports){
function equalArrays(r,e,n,a,u,i,t){var o=-1,f=r.length,l=e.length;if(f!=l&&!(u&&l>f))return!1;for(;++o<f;){var v=r[o],y=e[o],m=a?a(u?y:v,u?v:y,o):void 0;if(void 0!==m){if(m)continue;return!1}if(u){if(!arraySome(e,function(r){return v===r||n(v,r,a,u,i,t)}))return!1}else if(v!==y&&!n(v,y,a,u,i,t))return!1}return!0}var arraySome=require("./arraySome");module.exports=equalArrays;


},{"./arraySome":65}],108:[function(require,module,exports){
function equalByTag(e,a,r){switch(r){case boolTag:case dateTag:return+e==+a;case errorTag:return e.name==a.name&&e.message==a.message;case numberTag:return e!=+e?a!=+a:e==+a;case regexpTag:case stringTag:return e==a+""}return!1}var boolTag="[object Boolean]",dateTag="[object Date]",errorTag="[object Error]",numberTag="[object Number]",regexpTag="[object RegExp]",stringTag="[object String]";module.exports=equalByTag;


},{}],109:[function(require,module,exports){
function equalObjects(r,t,o,e,n,c,s){var u=keys(r),i=u.length,a=keys(t),f=a.length;if(i!=f&&!n)return!1;for(var y=i;y--;){var v=u[y];if(!(n?v in t:hasOwnProperty.call(t,v)))return!1}for(var p=n;++y<i;){v=u[y];var l=r[v],b=t[v],j=e?e(n?b:l,n?l:b,v):void 0;if(!(void 0===j?o(l,b,e,n,c,s):j))return!1;p||(p="constructor"==v)}if(!p){var O=r.constructor,h=t.constructor;if(O!=h&&"constructor"in r&&"constructor"in t&&!("function"==typeof O&&O instanceof O&&"function"==typeof h&&h instanceof h))return!1}return!0}var keys=require("../object/keys"),objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty;module.exports=equalObjects;


},{"../object/keys":149}],110:[function(require,module,exports){
var metaMap=require("./metaMap"),noop=require("../utility/noop"),getData=metaMap?function(e){return metaMap.get(e)}:noop;module.exports=getData;


},{"../utility/noop":155,"./metaMap":129}],111:[function(require,module,exports){
function getFuncName(e){for(var r=e.name+"",a=realNames[r],n=a?a.length:0;n--;){var u=a[n],m=u.func;if(null==m||m==e)return u.name}return r}var realNames=require("./realNames");module.exports=getFuncName;


},{"./realNames":130}],112:[function(require,module,exports){
var baseProperty=require("./baseProperty"),getLength=baseProperty("length");module.exports=getLength;


},{"./baseProperty":86}],113:[function(require,module,exports){
function getMatchData(r){for(var a=pairs(r),t=a.length;t--;)a[t][2]=isStrictComparable(a[t][1]);return a}var isStrictComparable=require("./isStrictComparable"),pairs=require("../object/pairs");module.exports=getMatchData;


},{"../object/pairs":151,"./isStrictComparable":127}],114:[function(require,module,exports){
function getNative(e,i){var t=null==e?void 0:e[i];return isNative(t)?t:void 0}var isNative=require("../lang/isNative");module.exports=getNative;


},{"../lang/isNative":143}],115:[function(require,module,exports){
function indexOfNaN(r,e,n){for(var f=r.length,t=e+(n?0:-1);n?t--:++t<f;){var a=r[t];if(a!==a)return t}return-1}module.exports=indexOfNaN;


},{}],116:[function(require,module,exports){
function initCloneArray(t){var r=t.length,n=new t.constructor(r);return r&&"string"==typeof t[0]&&hasOwnProperty.call(t,"index")&&(n.index=t.index,n.input=t.input),n}var objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty;module.exports=initCloneArray;


},{}],117:[function(require,module,exports){
(function (global){
function initCloneByTag(a,t,r){var e=a.constructor;switch(t){case arrayBufferTag:return bufferClone(a);case boolTag:case dateTag:return new e(+a);case float32Tag:case float64Tag:case int8Tag:case int16Tag:case int32Tag:case uint8Tag:case uint8ClampedTag:case uint16Tag:case uint32Tag:e instanceof e&&(e=ctorByTag[t]);var g=a.buffer;return new e(r?bufferClone(g):g,a.byteOffset,a.length);case numberTag:case stringTag:return new e(a);case regexpTag:var n=new e(a.source,reFlags.exec(a));n.lastIndex=a.lastIndex}return n}var bufferClone=require("./bufferClone"),boolTag="[object Boolean]",dateTag="[object Date]",numberTag="[object Number]",regexpTag="[object RegExp]",stringTag="[object String]",arrayBufferTag="[object ArrayBuffer]",float32Tag="[object Float32Array]",float64Tag="[object Float64Array]",int8Tag="[object Int8Array]",int16Tag="[object Int16Array]",int32Tag="[object Int32Array]",uint8Tag="[object Uint8Array]",uint8ClampedTag="[object Uint8ClampedArray]",uint16Tag="[object Uint16Array]",uint32Tag="[object Uint32Array]",reFlags=/\w*$/,Uint8Array=global.Uint8Array,ctorByTag={};ctorByTag[float32Tag]=global.Float32Array,ctorByTag[float64Tag]=global.Float64Array,ctorByTag[int8Tag]=global.Int8Array,ctorByTag[int16Tag]=global.Int16Array,ctorByTag[int32Tag]=global.Int32Array,ctorByTag[uint8Tag]=Uint8Array,ctorByTag[uint8ClampedTag]=global.Uint8ClampedArray,ctorByTag[uint16Tag]=global.Uint16Array,ctorByTag[uint32Tag]=global.Uint32Array,module.exports=initCloneByTag;


}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{"./bufferClone":95}],118:[function(require,module,exports){
function initCloneObject(n){var t=n.constructor;return"function"==typeof t&&t instanceof t||(t=Object),new t}module.exports=initCloneObject;


},{}],119:[function(require,module,exports){
function isArrayLike(e){return null!=e&&isLength(getLength(e))}var getLength=require("./getLength"),isLength=require("./isLength");module.exports=isArrayLike;


},{"./getLength":112,"./isLength":125}],120:[function(require,module,exports){
var isHostObject=function(){try{Object({toString:0}+"")}catch(t){return function(){return!1}}return function(t){return"function"!=typeof t.toString&&"string"==typeof(t+"")}}();module.exports=isHostObject;


},{}],121:[function(require,module,exports){
function isIndex(e,n){return e="number"==typeof e||reIsUint.test(e)?+e:-1,n=null==n?MAX_SAFE_INTEGER:n,e>-1&&e%1==0&&n>e}var reIsUint=/^\d+$/,MAX_SAFE_INTEGER=9007199254740991;module.exports=isIndex;


},{}],122:[function(require,module,exports){
function isIterateeCall(e,r,i){if(!isObject(i))return!1;var t=typeof r;if("number"==t?isArrayLike(i)&&isIndex(r,i.length):"string"==t&&r in i){var n=i[r];return e===e?e===n:n!==n}return!1}var isArrayLike=require("./isArrayLike"),isIndex=require("./isIndex"),isObject=require("../lang/isObject");module.exports=isIterateeCall;


},{"../lang/isObject":144,"./isArrayLike":119,"./isIndex":121}],123:[function(require,module,exports){
function isKey(r,e){var t=typeof r;if("string"==t&&reIsPlainProp.test(r)||"number"==t)return!0;if(isArray(r))return!1;var i=!reIsDeepProp.test(r);return i||null!=e&&r in toObject(e)}var isArray=require("../lang/isArray"),toObject=require("./toObject"),reIsDeepProp=/\.|\[(?:[^[\]]*|(["'])(?:(?!\1)[^\n\\]|\\.)*?\1)\]/,reIsPlainProp=/^\w*$/;module.exports=isKey;


},{"../lang/isArray":140,"./toObject":135}],124:[function(require,module,exports){
function isLaziable(e){var a=getFuncName(e),r=lodash[a];if("function"!=typeof r||!(a in LazyWrapper.prototype))return!1;if(e===r)return!0;var t=getData(r);return!!t&&e===t[0]}var LazyWrapper=require("./LazyWrapper"),getData=require("./getData"),getFuncName=require("./getFuncName"),lodash=require("../chain/lodash");module.exports=isLaziable;


},{"../chain/lodash":51,"./LazyWrapper":60,"./getData":110,"./getFuncName":111}],125:[function(require,module,exports){
function isLength(e){return"number"==typeof e&&e>-1&&e%1==0&&MAX_SAFE_INTEGER>=e}var MAX_SAFE_INTEGER=9007199254740991;module.exports=isLength;


},{}],126:[function(require,module,exports){
function isObjectLike(e){return!!e&&"object"==typeof e}module.exports=isObjectLike;


},{}],127:[function(require,module,exports){
function isStrictComparable(e){return e===e&&!isObject(e)}var isObject=require("../lang/isObject");module.exports=isStrictComparable;


},{"../lang/isObject":144}],128:[function(require,module,exports){
function mergeData(r,e){var A=r[1],a=e[1],o=A|a,R=ARY_FLAG>o,_=a==ARY_FLAG&&A==CURRY_FLAG||a==ARY_FLAG&&A==REARG_FLAG&&r[7].length<=e[8]||a==(ARY_FLAG|REARG_FLAG)&&A==CURRY_FLAG;if(!R&&!_)return r;a&BIND_FLAG&&(r[2]=e[2],o|=A&BIND_FLAG?0:CURRY_BOUND_FLAG);var L=e[3];if(L){var G=r[3];r[3]=G?composeArgs(G,L,e[4]):arrayCopy(L),r[4]=G?replaceHolders(r[3],PLACEHOLDER):arrayCopy(e[4])}return L=e[5],L&&(G=r[5],r[5]=G?composeArgsRight(G,L,e[6]):arrayCopy(L),r[6]=G?replaceHolders(r[5],PLACEHOLDER):arrayCopy(e[6])),L=e[7],L&&(r[7]=arrayCopy(L)),a&ARY_FLAG&&(r[8]=null==r[8]?e[8]:nativeMin(r[8],e[8])),null==r[9]&&(r[9]=e[9]),r[0]=e[0],r[1]=o,r}var arrayCopy=require("./arrayCopy"),composeArgs=require("./composeArgs"),composeArgsRight=require("./composeArgsRight"),replaceHolders=require("./replaceHolders"),BIND_FLAG=1,CURRY_BOUND_FLAG=4,CURRY_FLAG=8,ARY_FLAG=128,REARG_FLAG=256,PLACEHOLDER="__lodash_placeholder__",nativeMin=Math.min;module.exports=mergeData;


},{"./arrayCopy":62,"./composeArgs":96,"./composeArgsRight":97,"./replaceHolders":132}],129:[function(require,module,exports){
(function (global){
var getNative=require("./getNative"),WeakMap=getNative(global,"WeakMap"),metaMap=WeakMap&&new WeakMap;module.exports=metaMap;


}).call(this,typeof global !== "undefined" ? global : typeof self !== "undefined" ? self : typeof window !== "undefined" ? window : {})
},{"./getNative":114}],130:[function(require,module,exports){
var realNames={};module.exports=realNames;


},{}],131:[function(require,module,exports){
function reorder(r,e){for(var n=r.length,a=nativeMin(e.length,n),i=arrayCopy(r);a--;){var o=e[a];r[a]=isIndex(o,n)?i[o]:void 0}return r}var arrayCopy=require("./arrayCopy"),isIndex=require("./isIndex"),nativeMin=Math.min;module.exports=reorder;


},{"./arrayCopy":62,"./isIndex":121}],132:[function(require,module,exports){
function replaceHolders(e,r){for(var l=-1,o=e.length,a=-1,d=[];++l<o;)e[l]===r&&(e[l]=PLACEHOLDER,d[++a]=l);return d}var PLACEHOLDER="__lodash_placeholder__";module.exports=replaceHolders;


},{}],133:[function(require,module,exports){
var baseSetData=require("./baseSetData"),now=require("../date/now"),HOT_COUNT=150,HOT_SPAN=16,setData=function(){var e=0,a=0;return function(t,r){var n=now(),u=HOT_SPAN-(n-a);if(a=n,u>0){if(++e>=HOT_COUNT)return t}else e=0;return baseSetData(t,r)}}();module.exports=setData;


},{"../date/now":57,"./baseSetData":88}],134:[function(require,module,exports){
function shimKeys(r){for(var e=keysIn(r),s=e.length,i=s&&r.length,n=!!i&&isLength(i)&&(isArray(r)||isArguments(r)||isString(r)),t=-1,o=[];++t<s;){var g=e[t];(n&&isIndex(g,i)||hasOwnProperty.call(r,g))&&o.push(g)}return o}var isArguments=require("../lang/isArguments"),isArray=require("../lang/isArray"),isIndex=require("./isIndex"),isLength=require("./isLength"),isString=require("../lang/isString"),keysIn=require("../object/keysIn"),objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty;module.exports=shimKeys;


},{"../lang/isArguments":139,"../lang/isArray":140,"../lang/isString":146,"../object/keysIn":150,"./isIndex":121,"./isLength":125}],135:[function(require,module,exports){
function toObject(r){if(support.unindexedChars&&isString(r)){for(var t=-1,e=r.length,i=Object(r);++t<e;)i[t]=r.charAt(t);return i}return isObject(r)?r:Object(r)}var isObject=require("../lang/isObject"),isString=require("../lang/isString"),support=require("../support");module.exports=toObject;


},{"../lang/isObject":144,"../lang/isString":146,"../support":153}],136:[function(require,module,exports){
function toPath(r){if(isArray(r))return r;var e=[];return baseToString(r).replace(rePropName,function(r,a,t,i){e.push(t?i.replace(reEscapeChar,"$1"):a||r)}),e}var baseToString=require("./baseToString"),isArray=require("../lang/isArray"),rePropName=/[^.[\]]+|\[(?:(-?\d+(?:\.\d+)?)|(["'])((?:(?!\2)[^\n\\]|\\.)*?)\2)\]/g,reEscapeChar=/\\(\\)?/g;module.exports=toPath;


},{"../lang/isArray":140,"./baseToString":90}],137:[function(require,module,exports){
function wrapperClone(r){return r instanceof LazyWrapper?r.clone():new LodashWrapper(r.__wrapped__,r.__chain__,arrayCopy(r.__actions__))}var LazyWrapper=require("./LazyWrapper"),LodashWrapper=require("./LodashWrapper"),arrayCopy=require("./arrayCopy");module.exports=wrapperClone;


},{"./LazyWrapper":60,"./LodashWrapper":61,"./arrayCopy":62}],138:[function(require,module,exports){
function cloneDeep(e,n,l){return"function"==typeof n?baseClone(e,!0,bindCallback(n,l,3)):baseClone(e,!0)}var baseClone=require("../internal/baseClone"),bindCallback=require("../internal/bindCallback");module.exports=cloneDeep;


},{"../internal/baseClone":68,"../internal/bindCallback":94}],139:[function(require,module,exports){
function isArguments(e){return isObjectLike(e)&&isArrayLike(e)&&hasOwnProperty.call(e,"callee")&&!propertyIsEnumerable.call(e,"callee")}var isArrayLike=require("../internal/isArrayLike"),isObjectLike=require("../internal/isObjectLike"),objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty,propertyIsEnumerable=objectProto.propertyIsEnumerable;module.exports=isArguments;


},{"../internal/isArrayLike":119,"../internal/isObjectLike":126}],140:[function(require,module,exports){
var getNative=require("../internal/getNative"),isLength=require("../internal/isLength"),isObjectLike=require("../internal/isObjectLike"),arrayTag="[object Array]",objectProto=Object.prototype,objToString=objectProto.toString,nativeIsArray=getNative(Array,"isArray"),isArray=nativeIsArray||function(r){return isObjectLike(r)&&isLength(r.length)&&objToString.call(r)==arrayTag};module.exports=isArray;


},{"../internal/getNative":114,"../internal/isLength":125,"../internal/isObjectLike":126}],141:[function(require,module,exports){
function isEmpty(i){return null==i?!0:isArrayLike(i)&&(isArray(i)||isString(i)||isArguments(i)||isObjectLike(i)&&isFunction(i.splice))?!i.length:!keys(i).length}var isArguments=require("./isArguments"),isArray=require("./isArray"),isArrayLike=require("../internal/isArrayLike"),isFunction=require("./isFunction"),isObjectLike=require("../internal/isObjectLike"),isString=require("./isString"),keys=require("../object/keys");module.exports=isEmpty;


},{"../internal/isArrayLike":119,"../internal/isObjectLike":126,"../object/keys":149,"./isArguments":139,"./isArray":140,"./isFunction":142,"./isString":146}],142:[function(require,module,exports){
function isFunction(t){return isObject(t)&&objToString.call(t)==funcTag}var isObject=require("./isObject"),funcTag="[object Function]",objectProto=Object.prototype,objToString=objectProto.toString;module.exports=isFunction;


},{"./isObject":144}],143:[function(require,module,exports){
function isNative(t){return null==t?!1:isFunction(t)?reIsNative.test(fnToString.call(t)):isObjectLike(t)&&(isHostObject(t)?reIsNative:reIsHostCtor).test(t)}var isFunction=require("./isFunction"),isHostObject=require("../internal/isHostObject"),isObjectLike=require("../internal/isObjectLike"),reIsHostCtor=/^\[object .+?Constructor\]$/,objectProto=Object.prototype,fnToString=Function.prototype.toString,hasOwnProperty=objectProto.hasOwnProperty,reIsNative=RegExp("^"+fnToString.call(hasOwnProperty).replace(/[\\^$.*+?()[\]{}|]/g,"\\$&").replace(/hasOwnProperty|(function).*?(?=\\\()| for .+?(?=\\\])/g,"$1.*?")+"$");module.exports=isNative;


},{"../internal/isHostObject":120,"../internal/isObjectLike":126,"./isFunction":142}],144:[function(require,module,exports){
function isObject(t){var e=typeof t;return!!t&&("object"==e||"function"==e)}module.exports=isObject;


},{}],145:[function(require,module,exports){
function isPlainObject(t){var r;if(!isObjectLike(t)||objToString.call(t)!=objectTag||isHostObject(t)||isArguments(t)||!hasOwnProperty.call(t,"constructor")&&(r=t.constructor,"function"==typeof r&&!(r instanceof r)))return!1;var e;return support.ownLast?(baseForIn(t,function(t,r,o){return e=hasOwnProperty.call(o,r),!1}),e!==!1):(baseForIn(t,function(t,r){e=r}),void 0===e||hasOwnProperty.call(t,e))}var baseForIn=require("../internal/baseForIn"),isArguments=require("./isArguments"),isHostObject=require("../internal/isHostObject"),isObjectLike=require("../internal/isObjectLike"),support=require("../support"),objectTag="[object Object]",objectProto=Object.prototype,hasOwnProperty=objectProto.hasOwnProperty,objToString=objectProto.toString;module.exports=isPlainObject;


},{"../internal/baseForIn":75,"../internal/isHostObject":120,"../internal/isObjectLike":126,"../support":153,"./isArguments":139}],146:[function(require,module,exports){
function isString(t){return"string"==typeof t||isObjectLike(t)&&objToString.call(t)==stringTag}var isObjectLike=require("../internal/isObjectLike"),stringTag="[object String]",objectProto=Object.prototype,objToString=objectProto.toString;module.exports=isString;


},{"../internal/isObjectLike":126}],147:[function(require,module,exports){
function isTypedArray(a){return isObjectLike(a)&&isLength(a.length)&&!!typedArrayTags[objToString.call(a)]}var isLength=require("../internal/isLength"),isObjectLike=require("../internal/isObjectLike"),argsTag="[object Arguments]",arrayTag="[object Array]",boolTag="[object Boolean]",dateTag="[object Date]",errorTag="[object Error]",funcTag="[object Function]",mapTag="[object Map]",numberTag="[object Number]",objectTag="[object Object]",regexpTag="[object RegExp]",setTag="[object Set]",stringTag="[object String]",weakMapTag="[object WeakMap]",arrayBufferTag="[object ArrayBuffer]",float32Tag="[object Float32Array]",float64Tag="[object Float64Array]",int8Tag="[object Int8Array]",int16Tag="[object Int16Array]",int32Tag="[object Int32Array]",uint8Tag="[object Uint8Array]",uint8ClampedTag="[object Uint8ClampedArray]",uint16Tag="[object Uint16Array]",uint32Tag="[object Uint32Array]",typedArrayTags={};typedArrayTags[float32Tag]=typedArrayTags[float64Tag]=typedArrayTags[int8Tag]=typedArrayTags[int16Tag]=typedArrayTags[int32Tag]=typedArrayTags[uint8Tag]=typedArrayTags[uint8ClampedTag]=typedArrayTags[uint16Tag]=typedArrayTags[uint32Tag]=!0,typedArrayTags[argsTag]=typedArrayTags[arrayTag]=typedArrayTags[arrayBufferTag]=typedArrayTags[boolTag]=typedArrayTags[dateTag]=typedArrayTags[errorTag]=typedArrayTags[funcTag]=typedArrayTags[mapTag]=typedArrayTags[numberTag]=typedArrayTags[objectTag]=typedArrayTags[regexpTag]=typedArrayTags[setTag]=typedArrayTags[stringTag]=typedArrayTags[weakMapTag]=!1;var objectProto=Object.prototype,objToString=objectProto.toString;module.exports=isTypedArray;


},{"../internal/isLength":125,"../internal/isObjectLike":126}],148:[function(require,module,exports){
function isUndefined(e){return void 0===e}module.exports=isUndefined;


},{}],149:[function(require,module,exports){
var getNative=require("../internal/getNative"),isArrayLike=require("../internal/isArrayLike"),isObject=require("../lang/isObject"),shimKeys=require("../internal/shimKeys"),support=require("../support"),nativeKeys=getNative(Object,"keys"),keys=nativeKeys?function(e){var t=null==e?void 0:e.constructor;return"function"==typeof t&&t.prototype===e||("function"==typeof e?support.enumPrototypes:isArrayLike(e))?shimKeys(e):isObject(e)?nativeKeys(e):[]}:shimKeys;module.exports=keys;


},{"../internal/getNative":114,"../internal/isArrayLike":119,"../internal/shimKeys":134,"../lang/isObject":144,"../support":153}],150:[function(require,module,exports){
function keysIn(r){if(null==r)return[];isObject(r)||(r=Object(r));var o=r.length;o=o&&isLength(o)&&(isArray(r)||isArguments(r)||isString(r))&&o||0;for(var n=r.constructor,t=-1,e=isFunction(n)&&n.prototype||objectProto,a=e===r,s=Array(o),i=o>0,u=support.enumErrorProps&&(r===errorProto||r instanceof Error),c=support.enumPrototypes&&isFunction(r);++t<o;)s[t]=t+"";for(var g in r)c&&"prototype"==g||u&&("message"==g||"name"==g)||i&&isIndex(g,o)||"constructor"==g&&(a||!hasOwnProperty.call(r,g))||s.push(g);if(support.nonEnumShadows&&r!==objectProto){var p=r===stringProto?stringTag:r===errorProto?errorTag:objToString.call(r),P=nonEnumProps[p]||nonEnumProps[objectTag];for(p==objectTag&&(e=objectProto),o=shadowProps.length;o--;){g=shadowProps[o];var b=P[g];a&&b||(b?!hasOwnProperty.call(r,g):r[g]===e[g])||s.push(g)}}return s}var arrayEach=require("../internal/arrayEach"),isArguments=require("../lang/isArguments"),isArray=require("../lang/isArray"),isFunction=require("../lang/isFunction"),isIndex=require("../internal/isIndex"),isLength=require("../internal/isLength"),isObject=require("../lang/isObject"),isString=require("../lang/isString"),support=require("../support"),arrayTag="[object Array]",boolTag="[object Boolean]",dateTag="[object Date]",errorTag="[object Error]",funcTag="[object Function]",numberTag="[object Number]",objectTag="[object Object]",regexpTag="[object RegExp]",stringTag="[object String]",shadowProps=["constructor","hasOwnProperty","isPrototypeOf","propertyIsEnumerable","toLocaleString","toString","valueOf"],errorProto=Error.prototype,objectProto=Object.prototype,stringProto=String.prototype,hasOwnProperty=objectProto.hasOwnProperty,objToString=objectProto.toString,nonEnumProps={};nonEnumProps[arrayTag]=nonEnumProps[dateTag]=nonEnumProps[numberTag]={constructor:!0,toLocaleString:!0,toString:!0,valueOf:!0},nonEnumProps[boolTag]=nonEnumProps[stringTag]={constructor:!0,toString:!0,valueOf:!0},nonEnumProps[errorTag]=nonEnumProps[funcTag]=nonEnumProps[regexpTag]={constructor:!0,toString:!0},nonEnumProps[objectTag]={constructor:!0},arrayEach(shadowProps,function(r){for(var o in nonEnumProps)if(hasOwnProperty.call(nonEnumProps,o)){var n=nonEnumProps[o];n[r]=hasOwnProperty.call(n,r)}}),module.exports=keysIn;


},{"../internal/arrayEach":63,"../internal/isIndex":121,"../internal/isLength":125,"../lang/isArguments":139,"../lang/isArray":140,"../lang/isFunction":142,"../lang/isObject":144,"../lang/isString":146,"../support":153}],151:[function(require,module,exports){
function pairs(r){r=toObject(r);for(var e=-1,t=keys(r),a=t.length,o=Array(a);++e<a;){var i=t[e];o[e]=[i,r[i]]}return o}var keys=require("./keys"),toObject=require("../internal/toObject");module.exports=pairs;


},{"../internal/toObject":135,"./keys":149}],152:[function(require,module,exports){
function values(e){return baseValues(e,keys(e))}var baseValues=require("../internal/baseValues"),keys=require("./keys");module.exports=values;


},{"../internal/baseValues":91,"./keys":149}],153:[function(require,module,exports){
var arrayProto=Array.prototype,errorProto=Error.prototype,objectProto=Object.prototype,propertyIsEnumerable=objectProto.propertyIsEnumerable,splice=arrayProto.splice,support={};!function(r){var o=function(){this.x=r},e={0:r,length:r},t=[];o.prototype={valueOf:r,y:r};for(var p in new o)t.push(p);support.enumErrorProps=propertyIsEnumerable.call(errorProto,"message")||propertyIsEnumerable.call(errorProto,"name"),support.enumPrototypes=propertyIsEnumerable.call(o,"prototype"),support.nonEnumShadows=!/valueOf/.test(t),support.ownLast="x"!=t[0],support.spliceObjects=(splice.call(e,0,1),!e[0]),support.unindexedChars="x"[0]+Object("x")[0]!="xx"}(1,0),module.exports=support;


},{}],154:[function(require,module,exports){
function identity(t){return t}module.exports=identity;


},{}],155:[function(require,module,exports){
function noop(){}module.exports=noop;


},{}],156:[function(require,module,exports){
function property(e){return isKey(e)?baseProperty(e):basePropertyDeep(e)}var baseProperty=require("../internal/baseProperty"),basePropertyDeep=require("../internal/basePropertyDeep"),isKey=require("../internal/isKey");module.exports=property;


},{"../internal/baseProperty":86,"../internal/basePropertyDeep":87,"../internal/isKey":123}],157:[function(require,module,exports){
(function (process){
!function(t){"use strict";if("function"==typeof bootstrap)bootstrap("promise",t);else if("object"==typeof exports&&"object"==typeof module)module.exports=t();else if("function"==typeof define&&define.amd)define(t);else if("undefined"!=typeof ses){if(!ses.ok())return;ses.makeQ=t}else{if("undefined"==typeof window&&"undefined"==typeof self)throw new Error("This environment was not anticipated by Q. Please file a bug.");var n="undefined"!=typeof window?window:self,e=n.Q;n.Q=t(),n.Q.noConflict=function(){return n.Q=e,this}}}(function(){"use strict";function t(t){return function(){return K.apply(t,arguments)}}function n(t){return t===Object(t)}function e(t){return"[object StopIteration]"===et(t)||t instanceof _}function r(t,n){if(V&&n.stack&&"object"==typeof t&&null!==t&&t.stack&&-1===t.stack.indexOf(rt)){for(var e=[],r=n;r;r=r.source)r.stack&&e.unshift(r.stack);e.unshift(t.stack);var i=e.join("\n"+rt+"\n");t.stack=o(i)}}function o(t){for(var n=t.split("\n"),e=[],r=0;r<n.length;++r){var o=n[r];c(o)||i(o)||!o||e.push(o)}return e.join("\n")}function i(t){return-1!==t.indexOf("(module.js:")||-1!==t.indexOf("(node.js:")}function u(t){var n=/at .+ \((.+):(\d+):(?:\d+)\)$/.exec(t);if(n)return[n[1],Number(n[2])];var e=/at ([^ ]+):(\d+):(?:\d+)$/.exec(t);if(e)return[e[1],Number(e[2])];var r=/.*@(.+):(\d+)$/.exec(t);return r?[r[1],Number(r[2])]:void 0}function c(t){var n=u(t);if(!n)return!1;var e=n[0],r=n[1];return e===H&&r>=q&&ft>=r}function f(){if(V)try{throw new Error}catch(t){var n=t.stack.split("\n"),e=n[0].indexOf("@")>0?n[1]:n[2],r=u(e);if(!r)return;return H=r[0],r[1]}}function s(t,n,e){return function(){return"undefined"!=typeof console&&"function"==typeof console.warn&&console.warn(n+" is deprecated, use "+e+" instead.",new Error("").stack),t.apply(t,arguments)}}function p(t){return t instanceof h?t:k(t)?O(t):E(t)}function a(){function t(t){n=t,i.source=t,W(e,function(n,e){p.nextTick(function(){t.promiseDispatch.apply(t,e)})},void 0),e=void 0,r=void 0}var n,e=[],r=[],o=Z(a.prototype),i=Z(h.prototype);if(i.promiseDispatch=function(t,o,i){var u=L(arguments);e?(e.push(u),"when"===o&&i[1]&&r.push(i[1])):p.nextTick(function(){n.promiseDispatch.apply(n,u)})},i.valueOf=function(){if(e)return i;var t=v(n);return m(t)&&(n=t),t},i.inspect=function(){return n?n.inspect():{state:"pending"}},p.longStackSupport&&V)try{throw new Error}catch(u){i.stack=u.stack.substring(u.stack.indexOf("\n")+1)}return o.promise=i,o.resolve=function(e){n||t(p(e))},o.fulfill=function(e){n||t(E(e))},o.reject=function(e){n||t(R(e))},o.notify=function(t){n||W(r,function(n,e){p.nextTick(function(){e(t)})},void 0)},o}function l(t){if("function"!=typeof t)throw new TypeError("resolver must be a function.");var n=a();try{t(n.resolve,n.reject,n.notify)}catch(e){n.reject(e)}return n.promise}function d(t){return l(function(n,e){for(var r=0,o=t.length;o>r;r++)p(t[r]).then(n,e)})}function h(t,n,e){void 0===n&&(n=function(t){return R(new Error("Promise does not support operation: "+t))}),void 0===e&&(e=function(){return{state:"unknown"}});var r=Z(h.prototype);if(r.promiseDispatch=function(e,o,i){var u;try{u=t[o]?t[o].apply(r,i):n.call(r,o,i)}catch(c){u=R(c)}e&&e(u)},r.inspect=e,e){var o=e();"rejected"===o.state&&(r.exception=o.reason),r.valueOf=function(){var t=e();return"pending"===t.state||"rejected"===t.state?r:t.value}}return r}function y(t,n,e,r){return p(t).then(n,e,r)}function v(t){if(m(t)){var n=t.inspect();if("fulfilled"===n.state)return n.value}return t}function m(t){return t instanceof h}function k(t){return n(t)&&"function"==typeof t.then}function j(t){return m(t)&&"pending"===t.inspect().state}function w(t){return!m(t)||"fulfilled"===t.inspect().state}function g(t){return m(t)&&"rejected"===t.inspect().state}function b(){ot.length=0,it.length=0,ct||(ct=!0)}function x(t,n){ct&&("object"==typeof process&&"function"==typeof process.emit&&p.nextTick.runAfter(function(){-1!==X(it,t)&&(process.emit("unhandledRejection",n,t),ut.push(t))}),it.push(t),n&&"undefined"!=typeof n.stack?ot.push(n.stack):ot.push("(no stack) "+n))}function T(t){if(ct){var n=X(it,t);-1!==n&&("object"==typeof process&&"function"==typeof process.emit&&p.nextTick.runAfter(function(){var e=X(ut,t);-1!==e&&(process.emit("rejectionHandled",ot[n],t),ut.splice(e,1))}),it.splice(n,1),ot.splice(n,1))}}function R(t){var n=h({when:function(n){return n&&T(this),n?n(t):this}},function(){return this},function(){return{state:"rejected",reason:t}});return x(n,t),n}function E(t){return h({when:function(){return t},get:function(n){return t[n]},set:function(n,e){t[n]=e},"delete":function(n){delete t[n]},post:function(n,e){return null===n||void 0===n?t.apply(void 0,e):t[n].apply(t,e)},apply:function(n,e){return t.apply(n,e)},keys:function(){return nt(t)}},void 0,function(){return{state:"fulfilled",value:t}})}function O(t){var n=a();return p.nextTick(function(){try{t.then(n.resolve,n.reject,n.notify)}catch(e){n.reject(e)}}),n.promise}function S(t){return h({isDef:function(){}},function(n,e){return A(t,n,e)},function(){return p(t).inspect()})}function N(t,n,e){return p(t).spread(n,e)}function D(t){return function(){function n(t,n){var u;if("undefined"==typeof StopIteration){try{u=r[t](n)}catch(c){return R(c)}return u.done?p(u.value):y(u.value,o,i)}try{u=r[t](n)}catch(c){return e(c)?p(c.value):R(c)}return y(u,o,i)}var r=t.apply(this,arguments),o=n.bind(n,"next"),i=n.bind(n,"throw");return o()}}function P(t){p.done(p.async(t)())}function C(t){throw new _(t)}function Q(t){return function(){return N([this,I(arguments)],function(n,e){return t.apply(n,e)})}}function A(t,n,e){return p(t).dispatch(n,e)}function I(t){return y(t,function(t){var n=0,e=a();return W(t,function(r,o,i){var u;m(o)&&"fulfilled"===(u=o.inspect()).state?t[i]=u.value:(++n,y(o,function(r){t[i]=r,0===--n&&e.resolve(t)},e.reject,function(t){e.notify({index:i,value:t})}))},void 0),0===n&&e.resolve(t),e.promise})}function U(t){if(0===t.length)return p.resolve();var n=p.defer(),e=0;return W(t,function(r,o,i){function u(t){n.resolve(t)}function c(){e--,0===e&&n.reject(new Error("Can't get fulfillment value from any promise, all promises were rejected."))}function f(t){n.notify({index:i,value:t})}var s=t[i];e++,y(s,u,c,f)},void 0),n.promise}function F(t){return y(t,function(t){return t=Y(t,p),y(I(Y(t,function(t){return y(t,z,z)})),function(){return t})})}function M(t){return p(t).allSettled()}function B(t,n){return p(t).then(void 0,void 0,n)}function $(t,n){return p(t).nodeify(n)}var V=!1;try{throw new Error}catch(G){V=!!G.stack}var H,_,q=f(),z=function(){},J=function(){function t(){for(var t,r;e.next;)e=e.next,t=e.task,e.task=void 0,r=e.domain,r&&(e.domain=void 0,r.enter()),n(t,r);for(;c.length;)t=c.pop(),n(t);o=!1}function n(n,e){try{n()}catch(r){if(u)throw e&&e.exit(),setTimeout(t,0),e&&e.enter(),r;setTimeout(function(){throw r},0)}e&&e.exit()}var e={task:void 0,next:null},r=e,o=!1,i=void 0,u=!1,c=[];if(J=function(t){r=r.next={task:t,domain:u&&process.domain,next:null},o||(o=!0,i())},"object"==typeof process&&"[object process]"===process.toString()&&process.nextTick)u=!0,i=function(){process.nextTick(t)};else if("function"==typeof setImmediate)i="undefined"!=typeof window?setImmediate.bind(window,t):function(){setImmediate(t)};else if("undefined"!=typeof MessageChannel){var f=new MessageChannel;f.port1.onmessage=function(){i=s,f.port1.onmessage=t,t()};var s=function(){f.port2.postMessage(0)};i=function(){setTimeout(t,0),s()}}else i=function(){setTimeout(t,0)};return J.runAfter=function(t){c.push(t),o||(o=!0,i())},J}(),K=Function.call,L=t(Array.prototype.slice),W=t(Array.prototype.reduce||function(t,n){var e=0,r=this.length;if(1===arguments.length)for(;;){if(e in this){n=this[e++];break}if(++e>=r)throw new TypeError}for(;r>e;e++)e in this&&(n=t(n,this[e],e));return n}),X=t(Array.prototype.indexOf||function(t){for(var n=0;n<this.length;n++)if(this[n]===t)return n;return-1}),Y=t(Array.prototype.map||function(t,n){var e=this,r=[];return W(e,function(o,i,u){r.push(t.call(n,i,u,e))},void 0),r}),Z=Object.create||function(t){function n(){}return n.prototype=t,new n},tt=t(Object.prototype.hasOwnProperty),nt=Object.keys||function(t){var n=[];for(var e in t)tt(t,e)&&n.push(e);return n},et=t(Object.prototype.toString);_="undefined"!=typeof ReturnValue?ReturnValue:function(t){this.value=t};var rt="From previous event:";p.resolve=p,p.nextTick=J,p.longStackSupport=!1,"object"==typeof process&&process&&process.env&&process.env.Q_DEBUG&&(p.longStackSupport=!0),p.defer=a,a.prototype.makeNodeResolver=function(){var t=this;return function(n,e){n?t.reject(n):arguments.length>2?t.resolve(L(arguments,1)):t.resolve(e)}},p.Promise=l,p.promise=l,l.race=d,l.all=I,l.reject=R,l.resolve=p,p.passByCopy=function(t){return t},h.prototype.passByCopy=function(){return this},p.join=function(t,n){return p(t).join(n)},h.prototype.join=function(t){return p([this,t]).spread(function(t,n){if(t===n)return t;throw new Error("Can't join: not the same: "+t+" "+n)})},p.race=d,h.prototype.race=function(){return this.then(p.race)},p.makePromise=h,h.prototype.toString=function(){return"[object Promise]"},h.prototype.then=function(t,n,e){function o(n){try{return"function"==typeof t?t(n):n}catch(e){return R(e)}}function i(t){if("function"==typeof n){r(t,c);try{return n(t)}catch(e){return R(e)}}return R(t)}function u(t){return"function"==typeof e?e(t):t}var c=this,f=a(),s=!1;return p.nextTick(function(){c.promiseDispatch(function(t){s||(s=!0,f.resolve(o(t)))},"when",[function(t){s||(s=!0,f.resolve(i(t)))}])}),c.promiseDispatch(void 0,"when",[void 0,function(t){var n,e=!1;try{n=u(t)}catch(r){if(e=!0,!p.onerror)throw r;p.onerror(r)}e||f.notify(n)}]),f.promise},p.tap=function(t,n){return p(t).tap(n)},h.prototype.tap=function(t){return t=p(t),this.then(function(n){return t.fcall(n).thenResolve(n)})},p.when=y,h.prototype.thenResolve=function(t){return this.then(function(){return t})},p.thenResolve=function(t,n){return p(t).thenResolve(n)},h.prototype.thenReject=function(t){return this.then(function(){throw t})},p.thenReject=function(t,n){return p(t).thenReject(n)},p.nearer=v,p.isPromise=m,p.isPromiseAlike=k,p.isPending=j,h.prototype.isPending=function(){return"pending"===this.inspect().state},p.isFulfilled=w,h.prototype.isFulfilled=function(){return"fulfilled"===this.inspect().state},p.isRejected=g,h.prototype.isRejected=function(){return"rejected"===this.inspect().state};var ot=[],it=[],ut=[],ct=!0;p.resetUnhandledRejections=b,p.getUnhandledReasons=function(){return ot.slice()},p.stopUnhandledRejectionTracking=function(){b(),ct=!1},b(),p.reject=R,p.fulfill=E,p.master=S,p.spread=N,h.prototype.spread=function(t,n){return this.all().then(function(n){return t.apply(void 0,n)},n)},p.async=D,p.spawn=P,p["return"]=C,p.promised=Q,p.dispatch=A,h.prototype.dispatch=function(t,n){var e=this,r=a();return p.nextTick(function(){e.promiseDispatch(r.resolve,t,n)}),r.promise},p.get=function(t,n){return p(t).dispatch("get",[n])},h.prototype.get=function(t){return this.dispatch("get",[t])},p.set=function(t,n,e){return p(t).dispatch("set",[n,e])},h.prototype.set=function(t,n){return this.dispatch("set",[t,n])},p.del=p["delete"]=function(t,n){return p(t).dispatch("delete",[n])},h.prototype.del=h.prototype["delete"]=function(t){return this.dispatch("delete",[t])},p.mapply=p.post=function(t,n,e){return p(t).dispatch("post",[n,e])},h.prototype.mapply=h.prototype.post=function(t,n){return this.dispatch("post",[t,n])},p.send=p.mcall=p.invoke=function(t,n){return p(t).dispatch("post",[n,L(arguments,2)])},h.prototype.send=h.prototype.mcall=h.prototype.invoke=function(t){return this.dispatch("post",[t,L(arguments,1)])},p.fapply=function(t,n){return p(t).dispatch("apply",[void 0,n])},h.prototype.fapply=function(t){return this.dispatch("apply",[void 0,t])},p["try"]=p.fcall=function(t){return p(t).dispatch("apply",[void 0,L(arguments,1)])},h.prototype.fcall=function(){return this.dispatch("apply",[void 0,L(arguments)])},p.fbind=function(t){var n=p(t),e=L(arguments,1);return function(){return n.dispatch("apply",[this,e.concat(L(arguments))])}},h.prototype.fbind=function(){var t=this,n=L(arguments);return function(){return t.dispatch("apply",[this,n.concat(L(arguments))])}},p.keys=function(t){return p(t).dispatch("keys",[])},h.prototype.keys=function(){return this.dispatch("keys",[])},p.all=I,h.prototype.all=function(){return I(this)},p.any=U,h.prototype.any=function(){return U(this)},p.allResolved=s(F,"allResolved","allSettled"),h.prototype.allResolved=function(){return F(this)},p.allSettled=M,h.prototype.allSettled=function(){return this.then(function(t){return I(Y(t,function(t){function n(){return t.inspect()}return t=p(t),t.then(n,n)}))})},p.fail=p["catch"]=function(t,n){return p(t).then(void 0,n)},h.prototype.fail=h.prototype["catch"]=function(t){return this.then(void 0,t)},p.progress=B,h.prototype.progress=function(t){return this.then(void 0,void 0,t)},p.fin=p["finally"]=function(t,n){return p(t)["finally"](n)},h.prototype.fin=h.prototype["finally"]=function(t){return t=p(t),this.then(function(n){return t.fcall().then(function(){return n})},function(n){return t.fcall().then(function(){throw n})})},p.done=function(t,n,e,r){return p(t).done(n,e,r)},h.prototype.done=function(t,n,e){var o=function(t){p.nextTick(function(){if(r(t,i),!p.onerror)throw t;p.onerror(t)})},i=t||n||e?this.then(t,n,e):this;"object"==typeof process&&process&&process.domain&&(o=process.domain.bind(o)),i.then(void 0,o)},p.timeout=function(t,n,e){return p(t).timeout(n,e)},h.prototype.timeout=function(t,n){var e=a(),r=setTimeout(function(){n&&"string"!=typeof n||(n=new Error(n||"Timed out after "+t+" ms"),n.code="ETIMEDOUT"),e.reject(n)},t);return this.then(function(t){clearTimeout(r),e.resolve(t)},function(t){clearTimeout(r),e.reject(t)},e.notify),e.promise},p.delay=function(t,n){return void 0===n&&(n=t,t=void 0),p(t).delay(n)},h.prototype.delay=function(t){return this.then(function(n){var e=a();return setTimeout(function(){e.resolve(n)},t),e.promise})},p.nfapply=function(t,n){return p(t).nfapply(n)},h.prototype.nfapply=function(t){var n=a(),e=L(t);return e.push(n.makeNodeResolver()),this.fapply(e).fail(n.reject),n.promise},p.nfcall=function(t){var n=L(arguments,1);return p(t).nfapply(n)},h.prototype.nfcall=function(){var t=L(arguments),n=a();return t.push(n.makeNodeResolver()),this.fapply(t).fail(n.reject),n.promise},p.nfbind=p.denodeify=function(t){var n=L(arguments,1);return function(){var e=n.concat(L(arguments)),r=a();return e.push(r.makeNodeResolver()),p(t).fapply(e).fail(r.reject),r.promise}},h.prototype.nfbind=h.prototype.denodeify=function(){var t=L(arguments);return t.unshift(this),p.denodeify.apply(void 0,t)},p.nbind=function(t,n){var e=L(arguments,2);return function(){function r(){return t.apply(n,arguments)}var o=e.concat(L(arguments)),i=a();return o.push(i.makeNodeResolver()),p(r).fapply(o).fail(i.reject),i.promise}},h.prototype.nbind=function(){var t=L(arguments,0);return t.unshift(this),p.nbind.apply(void 0,t)},p.nmapply=p.npost=function(t,n,e){return p(t).npost(n,e)},h.prototype.nmapply=h.prototype.npost=function(t,n){var e=L(n||[]),r=a();return e.push(r.makeNodeResolver()),this.dispatch("post",[t,e]).fail(r.reject),r.promise},p.nsend=p.nmcall=p.ninvoke=function(t,n){var e=L(arguments,2),r=a();return e.push(r.makeNodeResolver()),p(t).dispatch("post",[n,e]).fail(r.reject),r.promise},h.prototype.nsend=h.prototype.nmcall=h.prototype.ninvoke=function(t){var n=L(arguments,1),e=a();return n.push(e.makeNodeResolver()),this.dispatch("post",[t,n]).fail(e.reject),e.promise},p.nodeify=$,h.prototype.nodeify=function(t){return t?void this.then(function(n){p.nextTick(function(){t(null,n)})},function(n){p.nextTick(function(){t(n)})}):this},p.noConflict=function(){throw new Error("Q.noConflict only works when Q is used as a global")};var ft=f();return p});


}).call(this,require('_process'))
},{"_process":12}],158:[function(require,module,exports){
function noop(){}function serialize(e){if(!isObject(e))return e;var t=[];for(var r in e)pushEncodedKeyValuePair(t,r,e[r]);return t.join("&")}function pushEncodedKeyValuePair(e,t,r){if(null!=r)if(Array.isArray(r))r.forEach(function(r){pushEncodedKeyValuePair(e,t,r)});else if(isObject(r))for(var s in r)pushEncodedKeyValuePair(e,t+"["+s+"]",r[s]);else e.push(encodeURIComponent(t)+"="+encodeURIComponent(r));else null===r&&e.push(encodeURIComponent(t))}function parseString(e){for(var t,r,s={},n=e.split("&"),o=0,i=n.length;i>o;++o)t=n[o],r=t.indexOf("="),-1==r?s[decodeURIComponent(t)]="":s[decodeURIComponent(t.slice(0,r))]=decodeURIComponent(t.slice(r+1));return s}function parseHeader(e){var t,r,s,n,o=e.split(/\r?\n/),i={};o.pop();for(var u=0,a=o.length;a>u;++u)r=o[u],t=r.indexOf(":"),s=r.slice(0,t).toLowerCase(),n=trim(r.slice(t+1)),i[s]=n;return i}function isJSON(e){return/[\/+]json\b/.test(e)}function type(e){return e.split(/ *; */).shift()}function params(e){return e.split(/ *; */).reduce(function(e,t){var r=t.split(/ *= */),s=r.shift(),n=r.shift();return s&&n&&(e[s]=n),e},{})}function Response(e,t){t=t||{},this.req=e,this.xhr=this.req.xhr,this.text="HEAD"!=this.req.method&&(""===this.xhr.responseType||"text"===this.xhr.responseType)||"undefined"==typeof this.xhr.responseType?this.xhr.responseText:null,this.statusText=this.req.xhr.statusText,this._setStatusProperties(this.xhr.status),this.header=this.headers=parseHeader(this.xhr.getAllResponseHeaders()),this.header["content-type"]=this.xhr.getResponseHeader("content-type"),this._setHeaderProperties(this.header),this.body="HEAD"!=this.req.method?this._parseBody(this.text?this.text:this.xhr.response):null}function Request(e,t){var r=this;this._query=this._query||[],this.method=e,this.url=t,this.header={},this._header={},this.on("end",function(){var e=null,t=null;try{t=new Response(r)}catch(s){return e=new Error("Parser is unable to parse the response"),e.parse=!0,e.original=s,e.rawResponse=r.xhr&&r.xhr.responseText?r.xhr.responseText:null,e.statusCode=r.xhr&&r.xhr.status?r.xhr.status:null,r.callback(e)}r.emit("response",t);var n;try{(t.status<200||t.status>=300)&&(n=new Error(t.statusText||"Unsuccessful HTTP response"),n.original=e,n.response=t,n.status=t.status)}catch(s){n=s}n?r.callback(n,t):r.callback(null,t)})}function del(e,t){var r=request("DELETE",e);return t&&r.end(t),r}var root;"undefined"!=typeof window?root=window:"undefined"!=typeof self?root=self:(console.warn("Using browser-only version of superagent in non-browser environment"),root=this);var Emitter=require("emitter"),requestBase=require("./request-base"),isObject=require("./is-object"),request=module.exports=require("./request").bind(null,Request);request.getXHR=function(){if(!(!root.XMLHttpRequest||root.location&&"file:"==root.location.protocol&&root.ActiveXObject))return new XMLHttpRequest;try{return new ActiveXObject("Microsoft.XMLHTTP")}catch(e){}try{return new ActiveXObject("Msxml2.XMLHTTP.6.0")}catch(e){}try{return new ActiveXObject("Msxml2.XMLHTTP.3.0")}catch(e){}try{return new ActiveXObject("Msxml2.XMLHTTP")}catch(e){}throw Error("Browser-only verison of superagent could not find XHR")};var trim="".trim?function(e){return e.trim()}:function(e){return e.replace(/(^\s*|\s*$)/g,"")};request.serializeObject=serialize,request.parseString=parseString,request.types={html:"text/html",json:"application/json",xml:"application/xml",urlencoded:"application/x-www-form-urlencoded",form:"application/x-www-form-urlencoded","form-data":"application/x-www-form-urlencoded"},request.serialize={"application/x-www-form-urlencoded":serialize,"application/json":JSON.stringify},request.parse={"application/x-www-form-urlencoded":parseString,"application/json":JSON.parse},Response.prototype.get=function(e){return this.header[e.toLowerCase()]},Response.prototype._setHeaderProperties=function(e){var t=this.header["content-type"]||"";this.type=type(t);var r=params(t);for(var s in r)this[s]=r[s]},Response.prototype._parseBody=function(e){var t=request.parse[this.type];return!t&&isJSON(this.type)&&(t=request.parse["application/json"]),t&&e&&(e.length||e instanceof Object)?t(e):null},Response.prototype._setStatusProperties=function(e){1223===e&&(e=204);var t=e/100|0;this.status=this.statusCode=e,this.statusType=t,this.info=1==t,this.ok=2==t,this.clientError=4==t,this.serverError=5==t,this.error=4==t||5==t?this.toError():!1,this.accepted=202==e,this.noContent=204==e,this.badRequest=400==e,this.unauthorized=401==e,this.notAcceptable=406==e,this.notFound=404==e,this.forbidden=403==e},Response.prototype.toError=function(){var e=this.req,t=e.method,r=e.url,s="cannot "+t+" "+r+" ("+this.status+")",n=new Error(s);return n.status=this.status,n.method=t,n.url=r,n},request.Response=Response,Emitter(Request.prototype);for(var key in requestBase)Request.prototype[key]=requestBase[key];Request.prototype.type=function(e){return this.set("Content-Type",request.types[e]||e),this},Request.prototype.responseType=function(e){return this._responseType=e,this},Request.prototype.accept=function(e){return this.set("Accept",request.types[e]||e),this},Request.prototype.auth=function(e,t,r){switch(r||(r={type:"basic"}),r.type){case"basic":var s=btoa(e+":"+t);this.set("Authorization","Basic "+s);break;case"auto":this.username=e,this.password=t}return this},Request.prototype.query=function(e){return"string"!=typeof e&&(e=serialize(e)),e&&this._query.push(e),this},Request.prototype.attach=function(e,t,r){return this._getFormData().append(e,t,r||t.name),this},Request.prototype._getFormData=function(){return this._formData||(this._formData=new root.FormData),this._formData},Request.prototype.callback=function(e,t){var r=this._callback;this.clearTimeout(),r(e,t)},Request.prototype.crossDomainError=function(){var e=new Error("Request has been terminated\nPossible causes: the network is offline, Origin is not allowed by Access-Control-Allow-Origin, the page is being unloaded, etc.");e.crossDomain=!0,e.status=this.status,e.method=this.method,e.url=this.url,this.callback(e)},Request.prototype._timeoutError=function(){var e=this._timeout,t=new Error("timeout of "+e+"ms exceeded");t.timeout=e,this.callback(t)},Request.prototype._appendQueryString=function(){var e=this._query.join("&");e&&(this.url+=~this.url.indexOf("?")?"&"+e:"?"+e)},Request.prototype.end=function(e){var t=this,r=this.xhr=request.getXHR(),s=this._timeout,n=this._formData||this._data;this._callback=e||noop,r.onreadystatechange=function(){if(4==r.readyState){var e;try{e=r.status}catch(s){e=0}if(0==e){if(t.timedout)return t._timeoutError();if(t._aborted)return;return t.crossDomainError()}t.emit("end")}};var o=function(e){e.total>0&&(e.percent=e.loaded/e.total*100),e.direction="download",t.emit("progress",e)};this.hasListeners("progress")&&(r.onprogress=o);try{r.upload&&this.hasListeners("progress")&&(r.upload.onprogress=o)}catch(i){}if(s&&!this._timer&&(this._timer=setTimeout(function(){t.timedout=!0,t.abort()},s)),this._appendQueryString(),this.username&&this.password?r.open(this.method,this.url,!0,this.username,this.password):r.open(this.method,this.url,!0),this._withCredentials&&(r.withCredentials=!0),"GET"!=this.method&&"HEAD"!=this.method&&"string"!=typeof n&&!this._isHost(n)){var u=this._header["content-type"],a=this._serializer||request.serialize[u?u.split(";")[0]:""];!a&&isJSON(u)&&(a=request.serialize["application/json"]),a&&(n=a(n))}for(var h in this.header)null!=this.header[h]&&r.setRequestHeader(h,this.header[h]);return this._responseType&&(r.responseType=this._responseType),this.emit("request",this),r.send("undefined"!=typeof n?n:null),this},request.Request=Request,request.get=function(e,t,r){var s=request("GET",e);return"function"==typeof t&&(r=t,t=null),t&&s.query(t),r&&s.end(r),s},request.head=function(e,t,r){var s=request("HEAD",e);return"function"==typeof t&&(r=t,t=null),t&&s.send(t),r&&s.end(r),s},request.options=function(e,t,r){var s=request("OPTIONS",e);return"function"==typeof t&&(r=t,t=null),t&&s.send(t),r&&s.end(r),s},request.del=del,request["delete"]=del,request.patch=function(e,t,r){var s=request("PATCH",e);return"function"==typeof t&&(r=t,t=null),t&&s.send(t),r&&s.end(r),s},request.post=function(e,t,r){var s=request("POST",e);return"function"==typeof t&&(r=t,t=null),t&&s.send(t),r&&s.end(r),s},request.put=function(e,t,r){var s=request("PUT",e);return"function"==typeof t&&(r=t,t=null),t&&s.send(t),r&&s.end(r),s};


},{"./is-object":159,"./request":161,"./request-base":160,"emitter":162}],159:[function(require,module,exports){
function isObject(e){return null!==e&&"object"==typeof e}module.exports=isObject;


},{}],160:[function(require,module,exports){
var isObject=require("./is-object");exports.clearTimeout=function(){return this._timeout=0,clearTimeout(this._timer),this},exports.parse=function(t){return this._parser=t,this},exports.serialize=function(t){return this._serializer=t,this},exports.timeout=function(t){return this._timeout=t,this},exports.then=function(t,e){if(!this._fullfilledPromise){var i=this;this._fullfilledPromise=new Promise(function(t,e){i.end(function(i,r){i?e(i):t(r)})})}return this._fullfilledPromise.then(t,e)},exports.use=function(t){return t(this),this},exports.get=function(t){return this._header[t.toLowerCase()]},exports.getHeader=exports.get,exports.set=function(t,e){if(isObject(t)){for(var i in t)this.set(i,t[i]);return this}return this._header[t.toLowerCase()]=e,this.header[t]=e,this},exports.unset=function(t){return delete this._header[t.toLowerCase()],delete this.header[t],this},exports.field=function(t,e){return this._getFormData().append(t,e),this},exports.abort=function(){return this._aborted?this:(this._aborted=!0,this.xhr&&this.xhr.abort(),this.req&&this.req.abort(),this.clearTimeout(),this.emit("abort"),this)},exports.withCredentials=function(){return this._withCredentials=!0,this},exports.redirects=function(t){return this._maxRedirects=t,this},exports.toJSON=function(){return{method:this.method,url:this.url,data:this._data,headers:this._header}},exports._isHost=function(t){var e={}.toString.call(t);switch(e){case"[object File]":case"[object Blob]":case"[object FormData]":return!0;default:return!1}},exports.send=function(t){var e=isObject(t),i=this._header["content-type"];if(e&&isObject(this._data))for(var r in t)this._data[r]=t[r];else"string"==typeof t?(i||this.type("form"),i=this._header["content-type"],"application/x-www-form-urlencoded"==i?this._data=this._data?this._data+"&"+t:t:this._data=(this._data||"")+t):this._data=t;return!e||this._isHost(t)?this:(i||this.type("json"),this)};


},{"./is-object":159}],161:[function(require,module,exports){
function request(e,n,t){return"function"==typeof t?new e("GET",n).end(t):2==arguments.length?new e("GET",n):new e(n,t)}module.exports=request;


},{}],162:[function(require,module,exports){
function Emitter(t){return t?mixin(t):void 0}function mixin(t){for(var e in Emitter.prototype)t[e]=Emitter.prototype[e];return t}"undefined"!=typeof module&&(module.exports=Emitter),Emitter.prototype.on=Emitter.prototype.addEventListener=function(t,e){return this._callbacks=this._callbacks||{},(this._callbacks["$"+t]=this._callbacks["$"+t]||[]).push(e),this},Emitter.prototype.once=function(t,e){function i(){this.off(t,i),e.apply(this,arguments)}return i.fn=e,this.on(t,i),this},Emitter.prototype.off=Emitter.prototype.removeListener=Emitter.prototype.removeAllListeners=Emitter.prototype.removeEventListener=function(t,e){if(this._callbacks=this._callbacks||{},0==arguments.length)return this._callbacks={},this;var i=this._callbacks["$"+t];if(!i)return this;if(1==arguments.length)return delete this._callbacks["$"+t],this;for(var r,s=0;s<i.length;s++)if(r=i[s],r===e||r.fn===e){i.splice(s,1);break}return this},Emitter.prototype.emit=function(t){this._callbacks=this._callbacks||{};var e=[].slice.call(arguments,1),i=this._callbacks["$"+t];if(i){i=i.slice(0);for(var r=0,s=i.length;s>r;++r)i[r].apply(this,e)}return this},Emitter.prototype.listeners=function(t){return this._callbacks=this._callbacks||{},this._callbacks["$"+t]||[]},Emitter.prototype.hasListeners=function(t){return!!this.listeners(t).length};


},{}]},{},[1])(1)
});
/*
 * angular-ui-bootstrap
 * http://angular-ui.github.io/bootstrap/

 * Version: 2.4.0 - 2016-12-29
 * License: MIT
 */angular.module("ui.bootstrap", ["ui.bootstrap.tpls", "ui.bootstrap.collapse","ui.bootstrap.tabindex","ui.bootstrap.accordion","ui.bootstrap.alert","ui.bootstrap.buttons","ui.bootstrap.carousel","ui.bootstrap.dateparser","ui.bootstrap.isClass","ui.bootstrap.datepicker","ui.bootstrap.position","ui.bootstrap.datepickerPopup","ui.bootstrap.debounce","ui.bootstrap.multiMap","ui.bootstrap.dropdown","ui.bootstrap.stackedMap","ui.bootstrap.modal","ui.bootstrap.paging","ui.bootstrap.pager","ui.bootstrap.pagination","ui.bootstrap.tooltip","ui.bootstrap.popover","ui.bootstrap.progressbar","ui.bootstrap.rating","ui.bootstrap.tabs","ui.bootstrap.timepicker","ui.bootstrap.typeahead"]);
angular.module("ui.bootstrap.tpls", ["uib/template/accordion/accordion-group.html","uib/template/accordion/accordion.html","uib/template/alert/alert.html","uib/template/carousel/carousel.html","uib/template/carousel/slide.html","uib/template/datepicker/datepicker.html","uib/template/datepicker/day.html","uib/template/datepicker/month.html","uib/template/datepicker/year.html","uib/template/datepickerPopup/popup.html","uib/template/modal/window.html","uib/template/pager/pager.html","uib/template/pagination/pagination.html","uib/template/tooltip/tooltip-html-popup.html","uib/template/tooltip/tooltip-popup.html","uib/template/tooltip/tooltip-template-popup.html","uib/template/popover/popover-html.html","uib/template/popover/popover-template.html","uib/template/popover/popover.html","uib/template/progressbar/bar.html","uib/template/progressbar/progress.html","uib/template/progressbar/progressbar.html","uib/template/rating/rating.html","uib/template/tabs/tab.html","uib/template/tabs/tabset.html","uib/template/timepicker/timepicker.html","uib/template/typeahead/typeahead-match.html","uib/template/typeahead/typeahead-popup.html"]);
angular.module('ui.bootstrap.collapse', [])

  .directive('uibCollapse', ['$animate', '$q', '$parse', '$injector', function($animate, $q, $parse, $injector) {
    var $animateCss = $injector.has('$animateCss') ? $injector.get('$animateCss') : null;
    return {
      link: function(scope, element, attrs) {
        var expandingExpr = $parse(attrs.expanding),
          expandedExpr = $parse(attrs.expanded),
          collapsingExpr = $parse(attrs.collapsing),
          collapsedExpr = $parse(attrs.collapsed),
          horizontal = false,
          css = {},
          cssTo = {};

        init();

        function init() {
          horizontal = !!('horizontal' in attrs);
          if (horizontal) {
            css = {
              width: ''
            };
            cssTo = {width: '0'};
          } else {
            css = {
              height: ''
            };
            cssTo = {height: '0'};
          }
          if (!scope.$eval(attrs.uibCollapse)) {
            element.addClass('in')
              .addClass('collapse')
              .attr('aria-expanded', true)
              .attr('aria-hidden', false)
              .css(css);
          }
        }

        function getScrollFromElement(element) {
          if (horizontal) {
            return {width: element.scrollWidth + 'px'};
          }
          return {height: element.scrollHeight + 'px'};
        }

        function expand() {
          if (element.hasClass('collapse') && element.hasClass('in')) {
            return;
          }

          $q.resolve(expandingExpr(scope))
            .then(function() {
              element.removeClass('collapse')
                .addClass('collapsing')
                .attr('aria-expanded', true)
                .attr('aria-hidden', false);

              if ($animateCss) {
                $animateCss(element, {
                  addClass: 'in',
                  easing: 'ease',
                  css: {
                    overflow: 'hidden'
                  },
                  to: getScrollFromElement(element[0])
                }).start()['finally'](expandDone);
              } else {
                $animate.addClass(element, 'in', {
                  css: {
                    overflow: 'hidden'
                  },
                  to: getScrollFromElement(element[0])
                }).then(expandDone);
              }
            });
        }

        function expandDone() {
          element.removeClass('collapsing')
            .addClass('collapse')
            .css(css);
          expandedExpr(scope);
        }

        function collapse() {
          if (!element.hasClass('collapse') && !element.hasClass('in')) {
            return collapseDone();
          }

          $q.resolve(collapsingExpr(scope))
            .then(function() {
              element
              // IMPORTANT: The width must be set before adding "collapsing" class.
              // Otherwise, the browser attempts to animate from width 0 (in
              // collapsing class) to the given width here.
                .css(getScrollFromElement(element[0]))
                // initially all panel collapse have the collapse class, this removal
                // prevents the animation from jumping to collapsed state
                .removeClass('collapse')
                .addClass('collapsing')
                .attr('aria-expanded', false)
                .attr('aria-hidden', true);

              if ($animateCss) {
                $animateCss(element, {
                  removeClass: 'in',
                  to: cssTo
                }).start()['finally'](collapseDone);
              } else {
                $animate.removeClass(element, 'in', {
                  to: cssTo
                }).then(collapseDone);
              }
            });
        }

        function collapseDone() {
          element.css(cssTo); // Required so that collapse works when animation is disabled
          element.removeClass('collapsing')
            .addClass('collapse');
          collapsedExpr(scope);
        }

        scope.$watch(attrs.uibCollapse, function(shouldCollapse) {
          if (shouldCollapse) {
            collapse();
          } else {
            expand();
          }
        });
      }
    };
  }]);

angular.module('ui.bootstrap.tabindex', [])

.directive('uibTabindexToggle', function() {
  return {
    restrict: 'A',
    link: function(scope, elem, attrs) {
      attrs.$observe('disabled', function(disabled) {
        attrs.$set('tabindex', disabled ? -1 : null);
      });
    }
  };
});

angular.module('ui.bootstrap.accordion', ['ui.bootstrap.collapse', 'ui.bootstrap.tabindex'])

.constant('uibAccordionConfig', {
  closeOthers: true
})

.controller('UibAccordionController', ['$scope', '$attrs', 'uibAccordionConfig', function($scope, $attrs, accordionConfig) {
  // This array keeps track of the accordion groups
  this.groups = [];

  // Ensure that all the groups in this accordion are closed, unless close-others explicitly says not to
  this.closeOthers = function(openGroup) {
    var closeOthers = angular.isDefined($attrs.closeOthers) ?
      $scope.$eval($attrs.closeOthers) : accordionConfig.closeOthers;
    if (closeOthers) {
      angular.forEach(this.groups, function(group) {
        if (group !== openGroup) {
          group.isOpen = false;
        }
      });
    }
  };

  // This is called from the accordion-group directive to add itself to the accordion
  this.addGroup = function(groupScope) {
    var that = this;
    this.groups.push(groupScope);

    groupScope.$on('$destroy', function(event) {
      that.removeGroup(groupScope);
    });
  };

  // This is called from the accordion-group directive when to remove itself
  this.removeGroup = function(group) {
    var index = this.groups.indexOf(group);
    if (index !== -1) {
      this.groups.splice(index, 1);
    }
  };
}])

// The accordion directive simply sets up the directive controller
// and adds an accordion CSS class to itself element.
.directive('uibAccordion', function() {
  return {
    controller: 'UibAccordionController',
    controllerAs: 'accordion',
    transclude: true,
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/accordion/accordion.html';
    }
  };
})

// The accordion-group directive indicates a block of html that will expand and collapse in an accordion
.directive('uibAccordionGroup', function() {
  return {
    require: '^uibAccordion',         // We need this directive to be inside an accordion
    transclude: true,              // It transcludes the contents of the directive into the template
    restrict: 'A',
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/accordion/accordion-group.html';
    },
    scope: {
      heading: '@',               // Interpolate the heading attribute onto this scope
      panelClass: '@?',           // Ditto with panelClass
      isOpen: '=?',
      isDisabled: '=?'
    },
    controller: function() {
      this.setHeading = function(element) {
        this.heading = element;
      };
    },
    link: function(scope, element, attrs, accordionCtrl) {
      element.addClass('panel');
      accordionCtrl.addGroup(scope);

      scope.openClass = attrs.openClass || 'panel-open';
      scope.panelClass = attrs.panelClass || 'panel-default';
      scope.$watch('isOpen', function(value) {
        element.toggleClass(scope.openClass, !!value);
        if (value) {
          accordionCtrl.closeOthers(scope);
        }
      });

      scope.toggleOpen = function($event) {
        if (!scope.isDisabled) {
          if (!$event || $event.which === 32) {
            scope.isOpen = !scope.isOpen;
          }
        }
      };

      var id = 'accordiongroup-' + scope.$id + '-' + Math.floor(Math.random() * 10000);
      scope.headingId = id + '-tab';
      scope.panelId = id + '-panel';
    }
  };
})

// Use accordion-heading below an accordion-group to provide a heading containing HTML
.directive('uibAccordionHeading', function() {
  return {
    transclude: true,   // Grab the contents to be used as the heading
    template: '',       // In effect remove this element!
    replace: true,
    require: '^uibAccordionGroup',
    link: function(scope, element, attrs, accordionGroupCtrl, transclude) {
      // Pass the heading to the accordion-group controller
      // so that it can be transcluded into the right place in the template
      // [The second parameter to transclude causes the elements to be cloned so that they work in ng-repeat]
      accordionGroupCtrl.setHeading(transclude(scope, angular.noop));
    }
  };
})

// Use in the accordion-group template to indicate where you want the heading to be transcluded
// You must provide the property on the accordion-group controller that will hold the transcluded element
.directive('uibAccordionTransclude', function() {
  return {
    require: '^uibAccordionGroup',
    link: function(scope, element, attrs, controller) {
      scope.$watch(function() { return controller[attrs.uibAccordionTransclude]; }, function(heading) {
        if (heading) {
          var elem = angular.element(element[0].querySelector(getHeaderSelectors()));
          elem.html('');
          elem.append(heading);
        }
      });
    }
  };

  function getHeaderSelectors() {
      return 'uib-accordion-header,' +
          'data-uib-accordion-header,' +
          'x-uib-accordion-header,' +
          'uib\\:accordion-header,' +
          '[uib-accordion-header],' +
          '[data-uib-accordion-header],' +
          '[x-uib-accordion-header]';
  }
});

angular.module('ui.bootstrap.alert', [])

.controller('UibAlertController', ['$scope', '$element', '$attrs', '$interpolate', '$timeout', function($scope, $element, $attrs, $interpolate, $timeout) {
  $scope.closeable = !!$attrs.close;
  $element.addClass('alert');
  $attrs.$set('role', 'alert');
  if ($scope.closeable) {
    $element.addClass('alert-dismissible');
  }

  var dismissOnTimeout = angular.isDefined($attrs.dismissOnTimeout) ?
    $interpolate($attrs.dismissOnTimeout)($scope.$parent) : null;

  if (dismissOnTimeout) {
    $timeout(function() {
      $scope.close();
    }, parseInt(dismissOnTimeout, 10));
  }
}])

.directive('uibAlert', function() {
  return {
    controller: 'UibAlertController',
    controllerAs: 'alert',
    restrict: 'A',
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/alert/alert.html';
    },
    transclude: true,
    scope: {
      close: '&'
    }
  };
});

angular.module('ui.bootstrap.buttons', [])

.constant('uibButtonConfig', {
  activeClass: 'active',
  toggleEvent: 'click'
})

.controller('UibButtonsController', ['uibButtonConfig', function(buttonConfig) {
  this.activeClass = buttonConfig.activeClass || 'active';
  this.toggleEvent = buttonConfig.toggleEvent || 'click';
}])

.directive('uibBtnRadio', ['$parse', function($parse) {
  return {
    require: ['uibBtnRadio', 'ngModel'],
    controller: 'UibButtonsController',
    controllerAs: 'buttons',
    link: function(scope, element, attrs, ctrls) {
      var buttonsCtrl = ctrls[0], ngModelCtrl = ctrls[1];
      var uncheckableExpr = $parse(attrs.uibUncheckable);

      element.find('input').css({display: 'none'});

      //model -> UI
      ngModelCtrl.$render = function() {
        element.toggleClass(buttonsCtrl.activeClass, angular.equals(ngModelCtrl.$modelValue, scope.$eval(attrs.uibBtnRadio)));
      };

      //ui->model
      element.on(buttonsCtrl.toggleEvent, function() {
        if (attrs.disabled) {
          return;
        }

        var isActive = element.hasClass(buttonsCtrl.activeClass);

        if (!isActive || angular.isDefined(attrs.uncheckable)) {
          scope.$apply(function() {
            ngModelCtrl.$setViewValue(isActive ? null : scope.$eval(attrs.uibBtnRadio));
            ngModelCtrl.$render();
          });
        }
      });

      if (attrs.uibUncheckable) {
        scope.$watch(uncheckableExpr, function(uncheckable) {
          attrs.$set('uncheckable', uncheckable ? '' : undefined);
        });
      }
    }
  };
}])

.directive('uibBtnCheckbox', function() {
  return {
    require: ['uibBtnCheckbox', 'ngModel'],
    controller: 'UibButtonsController',
    controllerAs: 'button',
    link: function(scope, element, attrs, ctrls) {
      var buttonsCtrl = ctrls[0], ngModelCtrl = ctrls[1];

      element.find('input').css({display: 'none'});

      function getTrueValue() {
        return getCheckboxValue(attrs.btnCheckboxTrue, true);
      }

      function getFalseValue() {
        return getCheckboxValue(attrs.btnCheckboxFalse, false);
      }

      function getCheckboxValue(attribute, defaultValue) {
        return angular.isDefined(attribute) ? scope.$eval(attribute) : defaultValue;
      }

      //model -> UI
      ngModelCtrl.$render = function() {
        element.toggleClass(buttonsCtrl.activeClass, angular.equals(ngModelCtrl.$modelValue, getTrueValue()));
      };

      //ui->model
      element.on(buttonsCtrl.toggleEvent, function() {
        if (attrs.disabled) {
          return;
        }

        scope.$apply(function() {
          ngModelCtrl.$setViewValue(element.hasClass(buttonsCtrl.activeClass) ? getFalseValue() : getTrueValue());
          ngModelCtrl.$render();
        });
      });
    }
  };
});

angular.module('ui.bootstrap.carousel', [])

.controller('UibCarouselController', ['$scope', '$element', '$interval', '$timeout', '$animate', function($scope, $element, $interval, $timeout, $animate) {
  var self = this,
    slides = self.slides = $scope.slides = [],
    SLIDE_DIRECTION = 'uib-slideDirection',
    currentIndex = $scope.active,
    currentInterval, isPlaying, bufferedTransitions = [];

  var destroyed = false;
  $element.addClass('carousel');

  self.addSlide = function(slide, element) {
    slides.push({
      slide: slide,
      element: element
    });
    slides.sort(function(a, b) {
      return +a.slide.index - +b.slide.index;
    });
    //if this is the first slide or the slide is set to active, select it
    if (slide.index === $scope.active || slides.length === 1 && !angular.isNumber($scope.active)) {
      if ($scope.$currentTransition) {
        $scope.$currentTransition = null;
      }

      currentIndex = slide.index;
      $scope.active = slide.index;
      setActive(currentIndex);
      self.select(slides[findSlideIndex(slide)]);
      if (slides.length === 1) {
        $scope.play();
      }
    }
  };

  self.getCurrentIndex = function() {
    for (var i = 0; i < slides.length; i++) {
      if (slides[i].slide.index === currentIndex) {
        return i;
      }
    }
  };

  self.next = $scope.next = function() {
    var newIndex = (self.getCurrentIndex() + 1) % slides.length;

    if (newIndex === 0 && $scope.noWrap()) {
      $scope.pause();
      return;
    }

    return self.select(slides[newIndex], 'next');
  };

  self.prev = $scope.prev = function() {
    var newIndex = self.getCurrentIndex() - 1 < 0 ? slides.length - 1 : self.getCurrentIndex() - 1;

    if ($scope.noWrap() && newIndex === slides.length - 1) {
      $scope.pause();
      return;
    }

    return self.select(slides[newIndex], 'prev');
  };

  self.removeSlide = function(slide) {
    var index = findSlideIndex(slide);

    var bufferedIndex = bufferedTransitions.indexOf(slides[index]);
    if (bufferedIndex !== -1) {
      bufferedTransitions.splice(bufferedIndex, 1);
    }

    //get the index of the slide inside the carousel
    slides.splice(index, 1);
    if (slides.length > 0 && currentIndex === index) {
      if (index >= slides.length) {
        currentIndex = slides.length - 1;
        $scope.active = currentIndex;
        setActive(currentIndex);
        self.select(slides[slides.length - 1]);
      } else {
        currentIndex = index;
        $scope.active = currentIndex;
        setActive(currentIndex);
        self.select(slides[index]);
      }
    } else if (currentIndex > index) {
      currentIndex--;
      $scope.active = currentIndex;
    }

    //clean the active value when no more slide
    if (slides.length === 0) {
      currentIndex = null;
      $scope.active = null;
      clearBufferedTransitions();
    }
  };

  /* direction: "prev" or "next" */
  self.select = $scope.select = function(nextSlide, direction) {
    var nextIndex = findSlideIndex(nextSlide.slide);
    //Decide direction if it's not given
    if (direction === undefined) {
      direction = nextIndex > self.getCurrentIndex() ? 'next' : 'prev';
    }
    //Prevent this user-triggered transition from occurring if there is already one in progress
    if (nextSlide.slide.index !== currentIndex &&
      !$scope.$currentTransition) {
      goNext(nextSlide.slide, nextIndex, direction);
    } else if (nextSlide && nextSlide.slide.index !== currentIndex && $scope.$currentTransition) {
      bufferedTransitions.push(slides[nextIndex]);
    }
  };

  /* Allow outside people to call indexOf on slides array */
  $scope.indexOfSlide = function(slide) {
    return +slide.slide.index;
  };

  $scope.isActive = function(slide) {
    return $scope.active === slide.slide.index;
  };

  $scope.isPrevDisabled = function() {
    return $scope.active === 0 && $scope.noWrap();
  };

  $scope.isNextDisabled = function() {
    return $scope.active === slides.length - 1 && $scope.noWrap();
  };

  $scope.pause = function() {
    if (!$scope.noPause) {
      isPlaying = false;
      resetTimer();
    }
  };

  $scope.play = function() {
    if (!isPlaying) {
      isPlaying = true;
      restartTimer();
    }
  };

  $element.on('mouseenter', $scope.pause);
  $element.on('mouseleave', $scope.play);

  $scope.$on('$destroy', function() {
    destroyed = true;
    resetTimer();
  });

  $scope.$watch('noTransition', function(noTransition) {
    $animate.enabled($element, !noTransition);
  });

  $scope.$watch('interval', restartTimer);

  $scope.$watchCollection('slides', resetTransition);

  $scope.$watch('active', function(index) {
    if (angular.isNumber(index) && currentIndex !== index) {
      for (var i = 0; i < slides.length; i++) {
        if (slides[i].slide.index === index) {
          index = i;
          break;
        }
      }

      var slide = slides[index];
      if (slide) {
        setActive(index);
        self.select(slides[index]);
        currentIndex = index;
      }
    }
  });

  function clearBufferedTransitions() {
    while (bufferedTransitions.length) {
      bufferedTransitions.shift();
    }
  }

  function getSlideByIndex(index) {
    for (var i = 0, l = slides.length; i < l; ++i) {
      if (slides[i].index === index) {
        return slides[i];
      }
    }
  }

  function setActive(index) {
    for (var i = 0; i < slides.length; i++) {
      slides[i].slide.active = i === index;
    }
  }

  function goNext(slide, index, direction) {
    if (destroyed) {
      return;
    }

    angular.extend(slide, {direction: direction});
    angular.extend(slides[currentIndex].slide || {}, {direction: direction});
    if ($animate.enabled($element) && !$scope.$currentTransition &&
      slides[index].element && self.slides.length > 1) {
      slides[index].element.data(SLIDE_DIRECTION, slide.direction);
      var currentIdx = self.getCurrentIndex();

      if (angular.isNumber(currentIdx) && slides[currentIdx].element) {
        slides[currentIdx].element.data(SLIDE_DIRECTION, slide.direction);
      }

      $scope.$currentTransition = true;
      $animate.on('addClass', slides[index].element, function(element, phase) {
        if (phase === 'close') {
          $scope.$currentTransition = null;
          $animate.off('addClass', element);
          if (bufferedTransitions.length) {
            var nextSlide = bufferedTransitions.pop().slide;
            var nextIndex = nextSlide.index;
            var nextDirection = nextIndex > self.getCurrentIndex() ? 'next' : 'prev';
            clearBufferedTransitions();

            goNext(nextSlide, nextIndex, nextDirection);
          }
        }
      });
    }

    $scope.active = slide.index;
    currentIndex = slide.index;
    setActive(index);

    //every time you change slides, reset the timer
    restartTimer();
  }

  function findSlideIndex(slide) {
    for (var i = 0; i < slides.length; i++) {
      if (slides[i].slide === slide) {
        return i;
      }
    }
  }

  function resetTimer() {
    if (currentInterval) {
      $interval.cancel(currentInterval);
      currentInterval = null;
    }
  }

  function resetTransition(slides) {
    if (!slides.length) {
      $scope.$currentTransition = null;
      clearBufferedTransitions();
    }
  }

  function restartTimer() {
    resetTimer();
    var interval = +$scope.interval;
    if (!isNaN(interval) && interval > 0) {
      currentInterval = $interval(timerFn, interval);
    }
  }

  function timerFn() {
    var interval = +$scope.interval;
    if (isPlaying && !isNaN(interval) && interval > 0 && slides.length) {
      $scope.next();
    } else {
      $scope.pause();
    }
  }
}])

.directive('uibCarousel', function() {
  return {
    transclude: true,
    controller: 'UibCarouselController',
    controllerAs: 'carousel',
    restrict: 'A',
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/carousel/carousel.html';
    },
    scope: {
      active: '=',
      interval: '=',
      noTransition: '=',
      noPause: '=',
      noWrap: '&'
    }
  };
})

.directive('uibSlide', ['$animate', function($animate) {
  return {
    require: '^uibCarousel',
    restrict: 'A',
    transclude: true,
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/carousel/slide.html';
    },
    scope: {
      actual: '=?',
      index: '=?'
    },
    link: function (scope, element, attrs, carouselCtrl) {
      element.addClass('item');
      carouselCtrl.addSlide(scope, element);
      //when the scope is destroyed then remove the slide from the current slides array
      scope.$on('$destroy', function() {
        carouselCtrl.removeSlide(scope);
      });

      scope.$watch('active', function(active) {
        $animate[active ? 'addClass' : 'removeClass'](element, 'active');
      });
    }
  };
}])

.animation('.item', ['$animateCss',
function($animateCss) {
  var SLIDE_DIRECTION = 'uib-slideDirection';

  function removeClass(element, className, callback) {
    element.removeClass(className);
    if (callback) {
      callback();
    }
  }

  return {
    beforeAddClass: function(element, className, done) {
      if (className === 'active') {
        var stopped = false;
        var direction = element.data(SLIDE_DIRECTION);
        var directionClass = direction === 'next' ? 'left' : 'right';
        var removeClassFn = removeClass.bind(this, element,
          directionClass + ' ' + direction, done);
        element.addClass(direction);

        $animateCss(element, {addClass: directionClass})
          .start()
          .done(removeClassFn);

        return function() {
          stopped = true;
        };
      }
      done();
    },
    beforeRemoveClass: function (element, className, done) {
      if (className === 'active') {
        var stopped = false;
        var direction = element.data(SLIDE_DIRECTION);
        var directionClass = direction === 'next' ? 'left' : 'right';
        var removeClassFn = removeClass.bind(this, element, directionClass, done);

        $animateCss(element, {addClass: directionClass})
          .start()
          .done(removeClassFn);

        return function() {
          stopped = true;
        };
      }
      done();
    }
  };
}]);

angular.module('ui.bootstrap.dateparser', [])

.service('uibDateParser', ['$log', '$locale', 'dateFilter', 'orderByFilter', 'filterFilter', function($log, $locale, dateFilter, orderByFilter, filterFilter) {
  // Pulled from https://github.com/mbostock/d3/blob/master/src/format/requote.js
  var SPECIAL_CHARACTERS_REGEXP = /[\\\^\$\*\+\?\|\[\]\(\)\.\{\}]/g;

  var localeId;
  var formatCodeToRegex;

  this.init = function() {
    localeId = $locale.id;

    this.parsers = {};
    this.formatters = {};

    formatCodeToRegex = [
      {
        key: 'yyyy',
        regex: '\\d{4}',
        apply: function(value) { this.year = +value; },
        formatter: function(date) {
          var _date = new Date();
          _date.setFullYear(Math.abs(date.getFullYear()));
          return dateFilter(_date, 'yyyy');
        }
      },
      {
        key: 'yy',
        regex: '\\d{2}',
        apply: function(value) { value = +value; this.year = value < 69 ? value + 2000 : value + 1900; },
        formatter: function(date) {
          var _date = new Date();
          _date.setFullYear(Math.abs(date.getFullYear()));
          return dateFilter(_date, 'yy');
        }
      },
      {
        key: 'y',
        regex: '\\d{1,4}',
        apply: function(value) { this.year = +value; },
        formatter: function(date) {
          var _date = new Date();
          _date.setFullYear(Math.abs(date.getFullYear()));
          return dateFilter(_date, 'y');
        }
      },
      {
        key: 'M!',
        regex: '0?[1-9]|1[0-2]',
        apply: function(value) { this.month = value - 1; },
        formatter: function(date) {
          var value = date.getMonth();
          if (/^[0-9]$/.test(value)) {
            return dateFilter(date, 'MM');
          }

          return dateFilter(date, 'M');
        }
      },
      {
        key: 'MMMM',
        regex: $locale.DATETIME_FORMATS.MONTH.join('|'),
        apply: function(value) { this.month = $locale.DATETIME_FORMATS.MONTH.indexOf(value); },
        formatter: function(date) { return dateFilter(date, 'MMMM'); }
      },
      {
        key: 'MMM',
        regex: $locale.DATETIME_FORMATS.SHORTMONTH.join('|'),
        apply: function(value) { this.month = $locale.DATETIME_FORMATS.SHORTMONTH.indexOf(value); },
        formatter: function(date) { return dateFilter(date, 'MMM'); }
      },
      {
        key: 'MM',
        regex: '0[1-9]|1[0-2]',
        apply: function(value) { this.month = value - 1; },
        formatter: function(date) { return dateFilter(date, 'MM'); }
      },
      {
        key: 'M',
        regex: '[1-9]|1[0-2]',
        apply: function(value) { this.month = value - 1; },
        formatter: function(date) { return dateFilter(date, 'M'); }
      },
      {
        key: 'd!',
        regex: '[0-2]?[0-9]{1}|3[0-1]{1}',
        apply: function(value) { this.date = +value; },
        formatter: function(date) {
          var value = date.getDate();
          if (/^[1-9]$/.test(value)) {
            return dateFilter(date, 'dd');
          }

          return dateFilter(date, 'd');
        }
      },
      {
        key: 'dd',
        regex: '[0-2][0-9]{1}|3[0-1]{1}',
        apply: function(value) { this.date = +value; },
        formatter: function(date) { return dateFilter(date, 'dd'); }
      },
      {
        key: 'd',
        regex: '[1-2]?[0-9]{1}|3[0-1]{1}',
        apply: function(value) { this.date = +value; },
        formatter: function(date) { return dateFilter(date, 'd'); }
      },
      {
        key: 'EEEE',
        regex: $locale.DATETIME_FORMATS.DAY.join('|'),
        formatter: function(date) { return dateFilter(date, 'EEEE'); }
      },
      {
        key: 'EEE',
        regex: $locale.DATETIME_FORMATS.SHORTDAY.join('|'),
        formatter: function(date) { return dateFilter(date, 'EEE'); }
      },
      {
        key: 'HH',
        regex: '(?:0|1)[0-9]|2[0-3]',
        apply: function(value) { this.hours = +value; },
        formatter: function(date) { return dateFilter(date, 'HH'); }
      },
      {
        key: 'hh',
        regex: '0[0-9]|1[0-2]',
        apply: function(value) { this.hours = +value; },
        formatter: function(date) { return dateFilter(date, 'hh'); }
      },
      {
        key: 'H',
        regex: '1?[0-9]|2[0-3]',
        apply: function(value) { this.hours = +value; },
        formatter: function(date) { return dateFilter(date, 'H'); }
      },
      {
        key: 'h',
        regex: '[0-9]|1[0-2]',
        apply: function(value) { this.hours = +value; },
        formatter: function(date) { return dateFilter(date, 'h'); }
      },
      {
        key: 'mm',
        regex: '[0-5][0-9]',
        apply: function(value) { this.minutes = +value; },
        formatter: function(date) { return dateFilter(date, 'mm'); }
      },
      {
        key: 'm',
        regex: '[0-9]|[1-5][0-9]',
        apply: function(value) { this.minutes = +value; },
        formatter: function(date) { return dateFilter(date, 'm'); }
      },
      {
        key: 'sss',
        regex: '[0-9][0-9][0-9]',
        apply: function(value) { this.milliseconds = +value; },
        formatter: function(date) { return dateFilter(date, 'sss'); }
      },
      {
        key: 'ss',
        regex: '[0-5][0-9]',
        apply: function(value) { this.seconds = +value; },
        formatter: function(date) { return dateFilter(date, 'ss'); }
      },
      {
        key: 's',
        regex: '[0-9]|[1-5][0-9]',
        apply: function(value) { this.seconds = +value; },
        formatter: function(date) { return dateFilter(date, 's'); }
      },
      {
        key: 'a',
        regex: $locale.DATETIME_FORMATS.AMPMS.join('|'),
        apply: function(value) {
          if (this.hours === 12) {
            this.hours = 0;
          }

          if (value === 'PM') {
            this.hours += 12;
          }
        },
        formatter: function(date) { return dateFilter(date, 'a'); }
      },
      {
        key: 'Z',
        regex: '[+-]\\d{4}',
        apply: function(value) {
          var matches = value.match(/([+-])(\d{2})(\d{2})/),
            sign = matches[1],
            hours = matches[2],
            minutes = matches[3];
          this.hours += toInt(sign + hours);
          this.minutes += toInt(sign + minutes);
        },
        formatter: function(date) {
          return dateFilter(date, 'Z');
        }
      },
      {
        key: 'ww',
        regex: '[0-4][0-9]|5[0-3]',
        formatter: function(date) { return dateFilter(date, 'ww'); }
      },
      {
        key: 'w',
        regex: '[0-9]|[1-4][0-9]|5[0-3]',
        formatter: function(date) { return dateFilter(date, 'w'); }
      },
      {
        key: 'GGGG',
        regex: $locale.DATETIME_FORMATS.ERANAMES.join('|').replace(/\s/g, '\\s'),
        formatter: function(date) { return dateFilter(date, 'GGGG'); }
      },
      {
        key: 'GGG',
        regex: $locale.DATETIME_FORMATS.ERAS.join('|'),
        formatter: function(date) { return dateFilter(date, 'GGG'); }
      },
      {
        key: 'GG',
        regex: $locale.DATETIME_FORMATS.ERAS.join('|'),
        formatter: function(date) { return dateFilter(date, 'GG'); }
      },
      {
        key: 'G',
        regex: $locale.DATETIME_FORMATS.ERAS.join('|'),
        formatter: function(date) { return dateFilter(date, 'G'); }
      }
    ];

    if (angular.version.major >= 1 && angular.version.minor > 4) {
      formatCodeToRegex.push({
        key: 'LLLL',
        regex: $locale.DATETIME_FORMATS.STANDALONEMONTH.join('|'),
        apply: function(value) { this.month = $locale.DATETIME_FORMATS.STANDALONEMONTH.indexOf(value); },
        formatter: function(date) { return dateFilter(date, 'LLLL'); }
      });
    }
  };

  this.init();

  function getFormatCodeToRegex(key) {
    return filterFilter(formatCodeToRegex, {key: key}, true)[0];
  }

  this.getParser = function (key) {
    var f = getFormatCodeToRegex(key);
    return f && f.apply || null;
  };

  this.overrideParser = function (key, parser) {
    var f = getFormatCodeToRegex(key);
    if (f && angular.isFunction(parser)) {
      this.parsers = {};
      f.apply = parser;
    }
  }.bind(this);

  function createParser(format) {
    var map = [], regex = format.split('');

    // check for literal values
    var quoteIndex = format.indexOf('\'');
    if (quoteIndex > -1) {
      var inLiteral = false;
      format = format.split('');
      for (var i = quoteIndex; i < format.length; i++) {
        if (inLiteral) {
          if (format[i] === '\'') {
            if (i + 1 < format.length && format[i+1] === '\'') { // escaped single quote
              format[i+1] = '$';
              regex[i+1] = '';
            } else { // end of literal
              regex[i] = '';
              inLiteral = false;
            }
          }
          format[i] = '$';
        } else {
          if (format[i] === '\'') { // start of literal
            format[i] = '$';
            regex[i] = '';
            inLiteral = true;
          }
        }
      }

      format = format.join('');
    }

    angular.forEach(formatCodeToRegex, function(data) {
      var index = format.indexOf(data.key);

      if (index > -1) {
        format = format.split('');

        regex[index] = '(' + data.regex + ')';
        format[index] = '$'; // Custom symbol to define consumed part of format
        for (var i = index + 1, n = index + data.key.length; i < n; i++) {
          regex[i] = '';
          format[i] = '$';
        }
        format = format.join('');

        map.push({
          index: index,
          key: data.key,
          apply: data.apply,
          matcher: data.regex
        });
      }
    });

    return {
      regex: new RegExp('^' + regex.join('') + '$'),
      map: orderByFilter(map, 'index')
    };
  }

  function createFormatter(format) {
    var formatters = [];
    var i = 0;
    var formatter, literalIdx;
    while (i < format.length) {
      if (angular.isNumber(literalIdx)) {
        if (format.charAt(i) === '\'') {
          if (i + 1 >= format.length || format.charAt(i + 1) !== '\'') {
            formatters.push(constructLiteralFormatter(format, literalIdx, i));
            literalIdx = null;
          }
        } else if (i === format.length) {
          while (literalIdx < format.length) {
            formatter = constructFormatterFromIdx(format, literalIdx);
            formatters.push(formatter);
            literalIdx = formatter.endIdx;
          }
        }

        i++;
        continue;
      }

      if (format.charAt(i) === '\'') {
        literalIdx = i;
        i++;
        continue;
      }

      formatter = constructFormatterFromIdx(format, i);

      formatters.push(formatter.parser);
      i = formatter.endIdx;
    }

    return formatters;
  }

  function constructLiteralFormatter(format, literalIdx, endIdx) {
    return function() {
      return format.substr(literalIdx + 1, endIdx - literalIdx - 1);
    };
  }

  function constructFormatterFromIdx(format, i) {
    var currentPosStr = format.substr(i);
    for (var j = 0; j < formatCodeToRegex.length; j++) {
      if (new RegExp('^' + formatCodeToRegex[j].key).test(currentPosStr)) {
        var data = formatCodeToRegex[j];
        return {
          endIdx: i + data.key.length,
          parser: data.formatter
        };
      }
    }

    return {
      endIdx: i + 1,
      parser: function() {
        return currentPosStr.charAt(0);
      }
    };
  }

  this.filter = function(date, format) {
    if (!angular.isDate(date) || isNaN(date) || !format) {
      return '';
    }

    format = $locale.DATETIME_FORMATS[format] || format;

    if ($locale.id !== localeId) {
      this.init();
    }

    if (!this.formatters[format]) {
      this.formatters[format] = createFormatter(format);
    }

    var formatters = this.formatters[format];

    return formatters.reduce(function(str, formatter) {
      return str + formatter(date);
    }, '');
  };

  this.parse = function(input, format, baseDate) {
    if (!angular.isString(input) || !format) {
      return input;
    }

    format = $locale.DATETIME_FORMATS[format] || format;
    format = format.replace(SPECIAL_CHARACTERS_REGEXP, '\\$&');

    if ($locale.id !== localeId) {
      this.init();
    }

    if (!this.parsers[format]) {
      this.parsers[format] = createParser(format, 'apply');
    }

    var parser = this.parsers[format],
        regex = parser.regex,
        map = parser.map,
        results = input.match(regex),
        tzOffset = false;
    if (results && results.length) {
      var fields, dt;
      if (angular.isDate(baseDate) && !isNaN(baseDate.getTime())) {
        fields = {
          year: baseDate.getFullYear(),
          month: baseDate.getMonth(),
          date: baseDate.getDate(),
          hours: baseDate.getHours(),
          minutes: baseDate.getMinutes(),
          seconds: baseDate.getSeconds(),
          milliseconds: baseDate.getMilliseconds()
        };
      } else {
        if (baseDate) {
          $log.warn('dateparser:', 'baseDate is not a valid date');
        }
        fields = { year: 1900, month: 0, date: 1, hours: 0, minutes: 0, seconds: 0, milliseconds: 0 };
      }

      for (var i = 1, n = results.length; i < n; i++) {
        var mapper = map[i - 1];
        if (mapper.matcher === 'Z') {
          tzOffset = true;
        }

        if (mapper.apply) {
          mapper.apply.call(fields, results[i]);
        }
      }

      var datesetter = tzOffset ? Date.prototype.setUTCFullYear :
        Date.prototype.setFullYear;
      var timesetter = tzOffset ? Date.prototype.setUTCHours :
        Date.prototype.setHours;

      if (isValid(fields.year, fields.month, fields.date)) {
        if (angular.isDate(baseDate) && !isNaN(baseDate.getTime()) && !tzOffset) {
          dt = new Date(baseDate);
          datesetter.call(dt, fields.year, fields.month, fields.date);
          timesetter.call(dt, fields.hours, fields.minutes,
            fields.seconds, fields.milliseconds);
        } else {
          dt = new Date(0);
          datesetter.call(dt, fields.year, fields.month, fields.date);
          timesetter.call(dt, fields.hours || 0, fields.minutes || 0,
            fields.seconds || 0, fields.milliseconds || 0);
        }
      }

      return dt;
    }
  };

  // Check if date is valid for specific month (and year for February).
  // Month: 0 = Jan, 1 = Feb, etc
  function isValid(year, month, date) {
    if (date < 1) {
      return false;
    }

    if (month === 1 && date > 28) {
      return date === 29 && (year % 4 === 0 && year % 100 !== 0 || year % 400 === 0);
    }

    if (month === 3 || month === 5 || month === 8 || month === 10) {
      return date < 31;
    }

    return true;
  }

  function toInt(str) {
    return parseInt(str, 10);
  }

  this.toTimezone = toTimezone;
  this.fromTimezone = fromTimezone;
  this.timezoneToOffset = timezoneToOffset;
  this.addDateMinutes = addDateMinutes;
  this.convertTimezoneToLocal = convertTimezoneToLocal;

  function toTimezone(date, timezone) {
    return date && timezone ? convertTimezoneToLocal(date, timezone) : date;
  }

  function fromTimezone(date, timezone) {
    return date && timezone ? convertTimezoneToLocal(date, timezone, true) : date;
  }

  //https://github.com/angular/angular.js/blob/622c42169699ec07fc6daaa19fe6d224e5d2f70e/src/Angular.js#L1207
  function timezoneToOffset(timezone, fallback) {
    timezone = timezone.replace(/:/g, '');
    var requestedTimezoneOffset = Date.parse('Jan 01, 1970 00:00:00 ' + timezone) / 60000;
    return isNaN(requestedTimezoneOffset) ? fallback : requestedTimezoneOffset;
  }

  function addDateMinutes(date, minutes) {
    date = new Date(date.getTime());
    date.setMinutes(date.getMinutes() + minutes);
    return date;
  }

  function convertTimezoneToLocal(date, timezone, reverse) {
    reverse = reverse ? -1 : 1;
    var dateTimezoneOffset = date.getTimezoneOffset();
    var timezoneOffset = timezoneToOffset(timezone, dateTimezoneOffset);
    return addDateMinutes(date, reverse * (timezoneOffset - dateTimezoneOffset));
  }
}]);

// Avoiding use of ng-class as it creates a lot of watchers when a class is to be applied to
// at most one element.
angular.module('ui.bootstrap.isClass', [])
.directive('uibIsClass', [
         '$animate',
function ($animate) {
  //                    11111111          22222222
  var ON_REGEXP = /^\s*([\s\S]+?)\s+on\s+([\s\S]+?)\s*$/;
  //                    11111111           22222222
  var IS_REGEXP = /^\s*([\s\S]+?)\s+for\s+([\s\S]+?)\s*$/;

  var dataPerTracked = {};

  return {
    restrict: 'A',
    compile: function(tElement, tAttrs) {
      var linkedScopes = [];
      var instances = [];
      var expToData = {};
      var lastActivated = null;
      var onExpMatches = tAttrs.uibIsClass.match(ON_REGEXP);
      var onExp = onExpMatches[2];
      var expsStr = onExpMatches[1];
      var exps = expsStr.split(',');

      return linkFn;

      function linkFn(scope, element, attrs) {
        linkedScopes.push(scope);
        instances.push({
          scope: scope,
          element: element
        });

        exps.forEach(function(exp, k) {
          addForExp(exp, scope);
        });

        scope.$on('$destroy', removeScope);
      }

      function addForExp(exp, scope) {
        var matches = exp.match(IS_REGEXP);
        var clazz = scope.$eval(matches[1]);
        var compareWithExp = matches[2];
        var data = expToData[exp];
        if (!data) {
          var watchFn = function(compareWithVal) {
            var newActivated = null;
            instances.some(function(instance) {
              var thisVal = instance.scope.$eval(onExp);
              if (thisVal === compareWithVal) {
                newActivated = instance;
                return true;
              }
            });
            if (data.lastActivated !== newActivated) {
              if (data.lastActivated) {
                $animate.removeClass(data.lastActivated.element, clazz);
              }
              if (newActivated) {
                $animate.addClass(newActivated.element, clazz);
              }
              data.lastActivated = newActivated;
            }
          };
          expToData[exp] = data = {
            lastActivated: null,
            scope: scope,
            watchFn: watchFn,
            compareWithExp: compareWithExp,
            watcher: scope.$watch(compareWithExp, watchFn)
          };
        }
        data.watchFn(scope.$eval(compareWithExp));
      }

      function removeScope(e) {
        var removedScope = e.targetScope;
        var index = linkedScopes.indexOf(removedScope);
        linkedScopes.splice(index, 1);
        instances.splice(index, 1);
        if (linkedScopes.length) {
          var newWatchScope = linkedScopes[0];
          angular.forEach(expToData, function(data) {
            if (data.scope === removedScope) {
              data.watcher = newWatchScope.$watch(data.compareWithExp, data.watchFn);
              data.scope = newWatchScope;
            }
          });
        } else {
          expToData = {};
        }
      }
    }
  };
}]);
angular.module('ui.bootstrap.datepicker', ['ui.bootstrap.dateparser', 'ui.bootstrap.isClass'])

.value('$datepickerSuppressError', false)

.value('$datepickerLiteralWarning', true)

.constant('uibDatepickerConfig', {
  datepickerMode: 'day',
  formatDay: 'dd',
  formatMonth: 'MMMM',
  formatYear: 'yyyy',
  formatDayHeader: 'EEE',
  formatDayTitle: 'MMMM yyyy',
  formatMonthTitle: 'yyyy',
  maxDate: null,
  maxMode: 'year',
  minDate: null,
  minMode: 'day',
  monthColumns: 3,
  ngModelOptions: {},
  shortcutPropagation: false,
  showWeeks: true,
  yearColumns: 5,
  yearRows: 4
})

.controller('UibDatepickerController', ['$scope', '$element', '$attrs', '$parse', '$interpolate', '$locale', '$log', 'dateFilter', 'uibDatepickerConfig', '$datepickerLiteralWarning', '$datepickerSuppressError', 'uibDateParser',
  function($scope, $element, $attrs, $parse, $interpolate, $locale, $log, dateFilter, datepickerConfig, $datepickerLiteralWarning, $datepickerSuppressError, dateParser) {
  var self = this,
      ngModelCtrl = { $setViewValue: angular.noop }, // nullModelCtrl;
      ngModelOptions = {},
      watchListeners = [];

  $element.addClass('uib-datepicker');
  $attrs.$set('role', 'application');

  if (!$scope.datepickerOptions) {
    $scope.datepickerOptions = {};
  }

  // Modes chain
  this.modes = ['day', 'month', 'year'];

  [
    'customClass',
    'dateDisabled',
    'datepickerMode',
    'formatDay',
    'formatDayHeader',
    'formatDayTitle',
    'formatMonth',
    'formatMonthTitle',
    'formatYear',
    'maxDate',
    'maxMode',
    'minDate',
    'minMode',
    'monthColumns',
    'showWeeks',
    'shortcutPropagation',
    'startingDay',
    'yearColumns',
    'yearRows'
  ].forEach(function(key) {
    switch (key) {
      case 'customClass':
      case 'dateDisabled':
        $scope[key] = $scope.datepickerOptions[key] || angular.noop;
        break;
      case 'datepickerMode':
        $scope.datepickerMode = angular.isDefined($scope.datepickerOptions.datepickerMode) ?
          $scope.datepickerOptions.datepickerMode : datepickerConfig.datepickerMode;
        break;
      case 'formatDay':
      case 'formatDayHeader':
      case 'formatDayTitle':
      case 'formatMonth':
      case 'formatMonthTitle':
      case 'formatYear':
        self[key] = angular.isDefined($scope.datepickerOptions[key]) ?
          $interpolate($scope.datepickerOptions[key])($scope.$parent) :
          datepickerConfig[key];
        break;
      case 'monthColumns':
      case 'showWeeks':
      case 'shortcutPropagation':
      case 'yearColumns':
      case 'yearRows':
        self[key] = angular.isDefined($scope.datepickerOptions[key]) ?
          $scope.datepickerOptions[key] : datepickerConfig[key];
        break;
      case 'startingDay':
        if (angular.isDefined($scope.datepickerOptions.startingDay)) {
          self.startingDay = $scope.datepickerOptions.startingDay;
        } else if (angular.isNumber(datepickerConfig.startingDay)) {
          self.startingDay = datepickerConfig.startingDay;
        } else {
          self.startingDay = ($locale.DATETIME_FORMATS.FIRSTDAYOFWEEK + 8) % 7;
        }

        break;
      case 'maxDate':
      case 'minDate':
        $scope.$watch('datepickerOptions.' + key, function(value) {
          if (value) {
            if (angular.isDate(value)) {
              self[key] = dateParser.fromTimezone(new Date(value), ngModelOptions.timezone);
            } else {
              if ($datepickerLiteralWarning) {
                $log.warn('Literal date support has been deprecated, please switch to date object usage');
              }

              self[key] = new Date(dateFilter(value, 'medium'));
            }
          } else {
            self[key] = datepickerConfig[key] ?
              dateParser.fromTimezone(new Date(datepickerConfig[key]), ngModelOptions.timezone) :
              null;
          }

          self.refreshView();
        });

        break;
      case 'maxMode':
      case 'minMode':
        if ($scope.datepickerOptions[key]) {
          $scope.$watch(function() { return $scope.datepickerOptions[key]; }, function(value) {
            self[key] = $scope[key] = angular.isDefined(value) ? value : $scope.datepickerOptions[key];
            if (key === 'minMode' && self.modes.indexOf($scope.datepickerOptions.datepickerMode) < self.modes.indexOf(self[key]) ||
              key === 'maxMode' && self.modes.indexOf($scope.datepickerOptions.datepickerMode) > self.modes.indexOf(self[key])) {
              $scope.datepickerMode = self[key];
              $scope.datepickerOptions.datepickerMode = self[key];
            }
          });
        } else {
          self[key] = $scope[key] = datepickerConfig[key] || null;
        }

        break;
    }
  });

  $scope.uniqueId = 'datepicker-' + $scope.$id + '-' + Math.floor(Math.random() * 10000);

  $scope.disabled = angular.isDefined($attrs.disabled) || false;
  if (angular.isDefined($attrs.ngDisabled)) {
    watchListeners.push($scope.$parent.$watch($attrs.ngDisabled, function(disabled) {
      $scope.disabled = disabled;
      self.refreshView();
    }));
  }

  $scope.isActive = function(dateObject) {
    if (self.compare(dateObject.date, self.activeDate) === 0) {
      $scope.activeDateId = dateObject.uid;
      return true;
    }
    return false;
  };

  this.init = function(ngModelCtrl_) {
    ngModelCtrl = ngModelCtrl_;
    ngModelOptions = ngModelCtrl_.$options ||
      $scope.datepickerOptions.ngModelOptions ||
      datepickerConfig.ngModelOptions;
    if ($scope.datepickerOptions.initDate) {
      self.activeDate = dateParser.fromTimezone($scope.datepickerOptions.initDate, ngModelOptions.timezone) || new Date();
      $scope.$watch('datepickerOptions.initDate', function(initDate) {
        if (initDate && (ngModelCtrl.$isEmpty(ngModelCtrl.$modelValue) || ngModelCtrl.$invalid)) {
          self.activeDate = dateParser.fromTimezone(initDate, ngModelOptions.timezone);
          self.refreshView();
        }
      });
    } else {
      self.activeDate = new Date();
    }

    var date = ngModelCtrl.$modelValue ? new Date(ngModelCtrl.$modelValue) : new Date();
    this.activeDate = !isNaN(date) ?
      dateParser.fromTimezone(date, ngModelOptions.timezone) :
      dateParser.fromTimezone(new Date(), ngModelOptions.timezone);

    ngModelCtrl.$render = function() {
      self.render();
    };
  };

  this.render = function() {
    if (ngModelCtrl.$viewValue) {
      var date = new Date(ngModelCtrl.$viewValue),
          isValid = !isNaN(date);

      if (isValid) {
        this.activeDate = dateParser.fromTimezone(date, ngModelOptions.timezone);
      } else if (!$datepickerSuppressError) {
        $log.error('Datepicker directive: "ng-model" value must be a Date object');
      }
    }
    this.refreshView();
  };

  this.refreshView = function() {
    if (this.element) {
      $scope.selectedDt = null;
      this._refreshView();
      if ($scope.activeDt) {
        $scope.activeDateId = $scope.activeDt.uid;
      }

      var date = ngModelCtrl.$viewValue ? new Date(ngModelCtrl.$viewValue) : null;
      date = dateParser.fromTimezone(date, ngModelOptions.timezone);
      ngModelCtrl.$setValidity('dateDisabled', !date ||
        this.element && !this.isDisabled(date));
    }
  };

  this.createDateObject = function(date, format) {
    var model = ngModelCtrl.$viewValue ? new Date(ngModelCtrl.$viewValue) : null;
    model = dateParser.fromTimezone(model, ngModelOptions.timezone);
    var today = new Date();
    today = dateParser.fromTimezone(today, ngModelOptions.timezone);
    var time = this.compare(date, today);
    var dt = {
      date: date,
      label: dateParser.filter(date, format),
      selected: model && this.compare(date, model) === 0,
      disabled: this.isDisabled(date),
      past: time < 0,
      current: time === 0,
      future: time > 0,
      customClass: this.customClass(date) || null
    };

    if (model && this.compare(date, model) === 0) {
      $scope.selectedDt = dt;
    }

    if (self.activeDate && this.compare(dt.date, self.activeDate) === 0) {
      $scope.activeDt = dt;
    }

    return dt;
  };

  this.isDisabled = function(date) {
    return $scope.disabled ||
      this.minDate && this.compare(date, this.minDate) < 0 ||
      this.maxDate && this.compare(date, this.maxDate) > 0 ||
      $scope.dateDisabled && $scope.dateDisabled({date: date, mode: $scope.datepickerMode});
  };

  this.customClass = function(date) {
    return $scope.customClass({date: date, mode: $scope.datepickerMode});
  };

  // Split array into smaller arrays
  this.split = function(arr, size) {
    var arrays = [];
    while (arr.length > 0) {
      arrays.push(arr.splice(0, size));
    }
    return arrays;
  };

  $scope.select = function(date) {
    if ($scope.datepickerMode === self.minMode) {
      var dt = ngModelCtrl.$viewValue ? dateParser.fromTimezone(new Date(ngModelCtrl.$viewValue), ngModelOptions.timezone) : new Date(0, 0, 0, 0, 0, 0, 0);
      dt.setFullYear(date.getFullYear(), date.getMonth(), date.getDate());
      dt = dateParser.toTimezone(dt, ngModelOptions.timezone);
      ngModelCtrl.$setViewValue(dt);
      ngModelCtrl.$render();
    } else {
      self.activeDate = date;
      setMode(self.modes[self.modes.indexOf($scope.datepickerMode) - 1]);

      $scope.$emit('uib:datepicker.mode');
    }

    $scope.$broadcast('uib:datepicker.focus');
  };

  $scope.move = function(direction) {
    var year = self.activeDate.getFullYear() + direction * (self.step.years || 0),
        month = self.activeDate.getMonth() + direction * (self.step.months || 0);
    self.activeDate.setFullYear(year, month, 1);
    self.refreshView();
  };

  $scope.toggleMode = function(direction) {
    direction = direction || 1;

    if ($scope.datepickerMode === self.maxMode && direction === 1 ||
      $scope.datepickerMode === self.minMode && direction === -1) {
      return;
    }

    setMode(self.modes[self.modes.indexOf($scope.datepickerMode) + direction]);

    $scope.$emit('uib:datepicker.mode');
  };

  // Key event mapper
  $scope.keys = { 13: 'enter', 32: 'space', 33: 'pageup', 34: 'pagedown', 35: 'end', 36: 'home', 37: 'left', 38: 'up', 39: 'right', 40: 'down' };

  var focusElement = function() {
    self.element[0].focus();
  };

  // Listen for focus requests from popup directive
  $scope.$on('uib:datepicker.focus', focusElement);

  $scope.keydown = function(evt) {
    var key = $scope.keys[evt.which];

    if (!key || evt.shiftKey || evt.altKey || $scope.disabled) {
      return;
    }

    evt.preventDefault();
    if (!self.shortcutPropagation) {
      evt.stopPropagation();
    }

    if (key === 'enter' || key === 'space') {
      if (self.isDisabled(self.activeDate)) {
        return; // do nothing
      }
      $scope.select(self.activeDate);
    } else if (evt.ctrlKey && (key === 'up' || key === 'down')) {
      $scope.toggleMode(key === 'up' ? 1 : -1);
    } else {
      self.handleKeyDown(key, evt);
      self.refreshView();
    }
  };

  $element.on('keydown', function(evt) {
    $scope.$apply(function() {
      $scope.keydown(evt);
    });
  });

  $scope.$on('$destroy', function() {
    //Clear all watch listeners on destroy
    while (watchListeners.length) {
      watchListeners.shift()();
    }
  });

  function setMode(mode) {
    $scope.datepickerMode = mode;
    $scope.datepickerOptions.datepickerMode = mode;
  }
}])

.controller('UibDaypickerController', ['$scope', '$element', 'dateFilter', function(scope, $element, dateFilter) {
  var DAYS_IN_MONTH = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

  this.step = { months: 1 };
  this.element = $element;
  function getDaysInMonth(year, month) {
    return month === 1 && year % 4 === 0 &&
      (year % 100 !== 0 || year % 400 === 0) ? 29 : DAYS_IN_MONTH[month];
  }

  this.init = function(ctrl) {
    angular.extend(ctrl, this);
    scope.showWeeks = ctrl.showWeeks;
    ctrl.refreshView();
  };

  this.getDates = function(startDate, n) {
    var dates = new Array(n), current = new Date(startDate), i = 0, date;
    while (i < n) {
      date = new Date(current);
      dates[i++] = date;
      current.setDate(current.getDate() + 1);
    }
    return dates;
  };

  this._refreshView = function() {
    var year = this.activeDate.getFullYear(),
      month = this.activeDate.getMonth(),
      firstDayOfMonth = new Date(this.activeDate);

    firstDayOfMonth.setFullYear(year, month, 1);

    var difference = this.startingDay - firstDayOfMonth.getDay(),
      numDisplayedFromPreviousMonth = difference > 0 ?
        7 - difference : - difference,
      firstDate = new Date(firstDayOfMonth);

    if (numDisplayedFromPreviousMonth > 0) {
      firstDate.setDate(-numDisplayedFromPreviousMonth + 1);
    }

    // 42 is the number of days on a six-week calendar
    var days = this.getDates(firstDate, 42);
    for (var i = 0; i < 42; i ++) {
      days[i] = angular.extend(this.createDateObject(days[i], this.formatDay), {
        secondary: days[i].getMonth() !== month,
        uid: scope.uniqueId + '-' + i
      });
    }

    scope.labels = new Array(7);
    for (var j = 0; j < 7; j++) {
      scope.labels[j] = {
        abbr: dateFilter(days[j].date, this.formatDayHeader),
        full: dateFilter(days[j].date, 'EEEE')
      };
    }

    scope.title = dateFilter(this.activeDate, this.formatDayTitle);
    scope.rows = this.split(days, 7);

    if (scope.showWeeks) {
      scope.weekNumbers = [];
      var thursdayIndex = (4 + 7 - this.startingDay) % 7,
          numWeeks = scope.rows.length;
      for (var curWeek = 0; curWeek < numWeeks; curWeek++) {
        scope.weekNumbers.push(
          getISO8601WeekNumber(scope.rows[curWeek][thursdayIndex].date));
      }
    }
  };

  this.compare = function(date1, date2) {
    var _date1 = new Date(date1.getFullYear(), date1.getMonth(), date1.getDate());
    var _date2 = new Date(date2.getFullYear(), date2.getMonth(), date2.getDate());
    _date1.setFullYear(date1.getFullYear());
    _date2.setFullYear(date2.getFullYear());
    return _date1 - _date2;
  };

  function getISO8601WeekNumber(date) {
    var checkDate = new Date(date);
    checkDate.setDate(checkDate.getDate() + 4 - (checkDate.getDay() || 7)); // Thursday
    var time = checkDate.getTime();
    checkDate.setMonth(0); // Compare with Jan 1
    checkDate.setDate(1);
    return Math.floor(Math.round((time - checkDate) / 86400000) / 7) + 1;
  }

  this.handleKeyDown = function(key, evt) {
    var date = this.activeDate.getDate();

    if (key === 'left') {
      date = date - 1;
    } else if (key === 'up') {
      date = date - 7;
    } else if (key === 'right') {
      date = date + 1;
    } else if (key === 'down') {
      date = date + 7;
    } else if (key === 'pageup' || key === 'pagedown') {
      var month = this.activeDate.getMonth() + (key === 'pageup' ? - 1 : 1);
      this.activeDate.setMonth(month, 1);
      date = Math.min(getDaysInMonth(this.activeDate.getFullYear(), this.activeDate.getMonth()), date);
    } else if (key === 'home') {
      date = 1;
    } else if (key === 'end') {
      date = getDaysInMonth(this.activeDate.getFullYear(), this.activeDate.getMonth());
    }
    this.activeDate.setDate(date);
  };
}])

.controller('UibMonthpickerController', ['$scope', '$element', 'dateFilter', function(scope, $element, dateFilter) {
  this.step = { years: 1 };
  this.element = $element;

  this.init = function(ctrl) {
    angular.extend(ctrl, this);
    ctrl.refreshView();
  };

  this._refreshView = function() {
    var months = new Array(12),
        year = this.activeDate.getFullYear(),
        date;

    for (var i = 0; i < 12; i++) {
      date = new Date(this.activeDate);
      date.setFullYear(year, i, 1);
      months[i] = angular.extend(this.createDateObject(date, this.formatMonth), {
        uid: scope.uniqueId + '-' + i
      });
    }

    scope.title = dateFilter(this.activeDate, this.formatMonthTitle);
    scope.rows = this.split(months, this.monthColumns);
    scope.yearHeaderColspan = this.monthColumns > 3 ? this.monthColumns - 2 : 1;
  };

  this.compare = function(date1, date2) {
    var _date1 = new Date(date1.getFullYear(), date1.getMonth());
    var _date2 = new Date(date2.getFullYear(), date2.getMonth());
    _date1.setFullYear(date1.getFullYear());
    _date2.setFullYear(date2.getFullYear());
    return _date1 - _date2;
  };

  this.handleKeyDown = function(key, evt) {
    var date = this.activeDate.getMonth();

    if (key === 'left') {
      date = date - 1;
    } else if (key === 'up') {
      date = date - this.monthColumns;
    } else if (key === 'right') {
      date = date + 1;
    } else if (key === 'down') {
      date = date + this.monthColumns;
    } else if (key === 'pageup' || key === 'pagedown') {
      var year = this.activeDate.getFullYear() + (key === 'pageup' ? - 1 : 1);
      this.activeDate.setFullYear(year);
    } else if (key === 'home') {
      date = 0;
    } else if (key === 'end') {
      date = 11;
    }
    this.activeDate.setMonth(date);
  };
}])

.controller('UibYearpickerController', ['$scope', '$element', 'dateFilter', function(scope, $element, dateFilter) {
  var columns, range;
  this.element = $element;

  function getStartingYear(year) {
    return parseInt((year - 1) / range, 10) * range + 1;
  }

  this.yearpickerInit = function() {
    columns = this.yearColumns;
    range = this.yearRows * columns;
    this.step = { years: range };
  };

  this._refreshView = function() {
    var years = new Array(range), date;

    for (var i = 0, start = getStartingYear(this.activeDate.getFullYear()); i < range; i++) {
      date = new Date(this.activeDate);
      date.setFullYear(start + i, 0, 1);
      years[i] = angular.extend(this.createDateObject(date, this.formatYear), {
        uid: scope.uniqueId + '-' + i
      });
    }

    scope.title = [years[0].label, years[range - 1].label].join(' - ');
    scope.rows = this.split(years, columns);
    scope.columns = columns;
  };

  this.compare = function(date1, date2) {
    return date1.getFullYear() - date2.getFullYear();
  };

  this.handleKeyDown = function(key, evt) {
    var date = this.activeDate.getFullYear();

    if (key === 'left') {
      date = date - 1;
    } else if (key === 'up') {
      date = date - columns;
    } else if (key === 'right') {
      date = date + 1;
    } else if (key === 'down') {
      date = date + columns;
    } else if (key === 'pageup' || key === 'pagedown') {
      date += (key === 'pageup' ? - 1 : 1) * range;
    } else if (key === 'home') {
      date = getStartingYear(this.activeDate.getFullYear());
    } else if (key === 'end') {
      date = getStartingYear(this.activeDate.getFullYear()) + range - 1;
    }
    this.activeDate.setFullYear(date);
  };
}])

.directive('uibDatepicker', function() {
  return {
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/datepicker/datepicker.html';
    },
    scope: {
      datepickerOptions: '=?'
    },
    require: ['uibDatepicker', '^ngModel'],
    restrict: 'A',
    controller: 'UibDatepickerController',
    controllerAs: 'datepicker',
    link: function(scope, element, attrs, ctrls) {
      var datepickerCtrl = ctrls[0], ngModelCtrl = ctrls[1];

      datepickerCtrl.init(ngModelCtrl);
    }
  };
})

.directive('uibDaypicker', function() {
  return {
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/datepicker/day.html';
    },
    require: ['^uibDatepicker', 'uibDaypicker'],
    restrict: 'A',
    controller: 'UibDaypickerController',
    link: function(scope, element, attrs, ctrls) {
      var datepickerCtrl = ctrls[0],
        daypickerCtrl = ctrls[1];

      daypickerCtrl.init(datepickerCtrl);
    }
  };
})

.directive('uibMonthpicker', function() {
  return {
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/datepicker/month.html';
    },
    require: ['^uibDatepicker', 'uibMonthpicker'],
    restrict: 'A',
    controller: 'UibMonthpickerController',
    link: function(scope, element, attrs, ctrls) {
      var datepickerCtrl = ctrls[0],
        monthpickerCtrl = ctrls[1];

      monthpickerCtrl.init(datepickerCtrl);
    }
  };
})

.directive('uibYearpicker', function() {
  return {
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/datepicker/year.html';
    },
    require: ['^uibDatepicker', 'uibYearpicker'],
    restrict: 'A',
    controller: 'UibYearpickerController',
    link: function(scope, element, attrs, ctrls) {
      var ctrl = ctrls[0];
      angular.extend(ctrl, ctrls[1]);
      ctrl.yearpickerInit();

      ctrl.refreshView();
    }
  };
});

angular.module('ui.bootstrap.position', [])

/**
 * A set of utility methods for working with the DOM.
 * It is meant to be used where we need to absolute-position elements in
 * relation to another element (this is the case for tooltips, popovers,
 * typeahead suggestions etc.).
 */
  .factory('$uibPosition', ['$document', '$window', function($document, $window) {
    /**
     * Used by scrollbarWidth() function to cache scrollbar's width.
     * Do not access this variable directly, use scrollbarWidth() instead.
     */
    var SCROLLBAR_WIDTH;
    /**
     * scrollbar on body and html element in IE and Edge overlay
     * content and should be considered 0 width.
     */
    var BODY_SCROLLBAR_WIDTH;
    var OVERFLOW_REGEX = {
      normal: /(auto|scroll)/,
      hidden: /(auto|scroll|hidden)/
    };
    var PLACEMENT_REGEX = {
      auto: /\s?auto?\s?/i,
      primary: /^(top|bottom|left|right)$/,
      secondary: /^(top|bottom|left|right|center)$/,
      vertical: /^(top|bottom)$/
    };
    var BODY_REGEX = /(HTML|BODY)/;

    return {

      /**
       * Provides a raw DOM element from a jQuery/jQLite element.
       *
       * @param {element} elem - The element to convert.
       *
       * @returns {element} A HTML element.
       */
      getRawNode: function(elem) {
        return elem.nodeName ? elem : elem[0] || elem;
      },

      /**
       * Provides a parsed number for a style property.  Strips
       * units and casts invalid numbers to 0.
       *
       * @param {string} value - The style value to parse.
       *
       * @returns {number} A valid number.
       */
      parseStyle: function(value) {
        value = parseFloat(value);
        return isFinite(value) ? value : 0;
      },

      /**
       * Provides the closest positioned ancestor.
       *
       * @param {element} element - The element to get the offest parent for.
       *
       * @returns {element} The closest positioned ancestor.
       */
      offsetParent: function(elem) {
        elem = this.getRawNode(elem);

        var offsetParent = elem.offsetParent || $document[0].documentElement;

        function isStaticPositioned(el) {
          return ($window.getComputedStyle(el).position || 'static') === 'static';
        }

        while (offsetParent && offsetParent !== $document[0].documentElement && isStaticPositioned(offsetParent)) {
          offsetParent = offsetParent.offsetParent;
        }

        return offsetParent || $document[0].documentElement;
      },

      /**
       * Provides the scrollbar width, concept from TWBS measureScrollbar()
       * function in https://github.com/twbs/bootstrap/blob/master/js/modal.js
       * In IE and Edge, scollbar on body and html element overlay and should
       * return a width of 0.
       *
       * @returns {number} The width of the browser scollbar.
       */
      scrollbarWidth: function(isBody) {
        if (isBody) {
          if (angular.isUndefined(BODY_SCROLLBAR_WIDTH)) {
            var bodyElem = $document.find('body');
            bodyElem.addClass('uib-position-body-scrollbar-measure');
            BODY_SCROLLBAR_WIDTH = $window.innerWidth - bodyElem[0].clientWidth;
            BODY_SCROLLBAR_WIDTH = isFinite(BODY_SCROLLBAR_WIDTH) ? BODY_SCROLLBAR_WIDTH : 0;
            bodyElem.removeClass('uib-position-body-scrollbar-measure');
          }
          return BODY_SCROLLBAR_WIDTH;
        }

        if (angular.isUndefined(SCROLLBAR_WIDTH)) {
          var scrollElem = angular.element('<div class="uib-position-scrollbar-measure"></div>');
          $document.find('body').append(scrollElem);
          SCROLLBAR_WIDTH = scrollElem[0].offsetWidth - scrollElem[0].clientWidth;
          SCROLLBAR_WIDTH = isFinite(SCROLLBAR_WIDTH) ? SCROLLBAR_WIDTH : 0;
          scrollElem.remove();
        }

        return SCROLLBAR_WIDTH;
      },

      /**
       * Provides the padding required on an element to replace the scrollbar.
       *
       * @returns {object} An object with the following properties:
       *   <ul>
       *     <li>**scrollbarWidth**: the width of the scrollbar</li>
       *     <li>**widthOverflow**: whether the the width is overflowing</li>
       *     <li>**right**: the amount of right padding on the element needed to replace the scrollbar</li>
       *     <li>**rightOriginal**: the amount of right padding currently on the element</li>
       *     <li>**heightOverflow**: whether the the height is overflowing</li>
       *     <li>**bottom**: the amount of bottom padding on the element needed to replace the scrollbar</li>
       *     <li>**bottomOriginal**: the amount of bottom padding currently on the element</li>
       *   </ul>
       */
      scrollbarPadding: function(elem) {
        elem = this.getRawNode(elem);

        var elemStyle = $window.getComputedStyle(elem);
        var paddingRight = this.parseStyle(elemStyle.paddingRight);
        var paddingBottom = this.parseStyle(elemStyle.paddingBottom);
        var scrollParent = this.scrollParent(elem, false, true);
        var scrollbarWidth = this.scrollbarWidth(BODY_REGEX.test(scrollParent.tagName));

        return {
          scrollbarWidth: scrollbarWidth,
          widthOverflow: scrollParent.scrollWidth > scrollParent.clientWidth,
          right: paddingRight + scrollbarWidth,
          originalRight: paddingRight,
          heightOverflow: scrollParent.scrollHeight > scrollParent.clientHeight,
          bottom: paddingBottom + scrollbarWidth,
          originalBottom: paddingBottom
         };
      },

      /**
       * Checks to see if the element is scrollable.
       *
       * @param {element} elem - The element to check.
       * @param {boolean=} [includeHidden=false] - Should scroll style of 'hidden' be considered,
       *   default is false.
       *
       * @returns {boolean} Whether the element is scrollable.
       */
      isScrollable: function(elem, includeHidden) {
        elem = this.getRawNode(elem);

        var overflowRegex = includeHidden ? OVERFLOW_REGEX.hidden : OVERFLOW_REGEX.normal;
        var elemStyle = $window.getComputedStyle(elem);
        return overflowRegex.test(elemStyle.overflow + elemStyle.overflowY + elemStyle.overflowX);
      },

      /**
       * Provides the closest scrollable ancestor.
       * A port of the jQuery UI scrollParent method:
       * https://github.com/jquery/jquery-ui/blob/master/ui/scroll-parent.js
       *
       * @param {element} elem - The element to find the scroll parent of.
       * @param {boolean=} [includeHidden=false] - Should scroll style of 'hidden' be considered,
       *   default is false.
       * @param {boolean=} [includeSelf=false] - Should the element being passed be
       * included in the scrollable llokup.
       *
       * @returns {element} A HTML element.
       */
      scrollParent: function(elem, includeHidden, includeSelf) {
        elem = this.getRawNode(elem);

        var overflowRegex = includeHidden ? OVERFLOW_REGEX.hidden : OVERFLOW_REGEX.normal;
        var documentEl = $document[0].documentElement;
        var elemStyle = $window.getComputedStyle(elem);
        if (includeSelf && overflowRegex.test(elemStyle.overflow + elemStyle.overflowY + elemStyle.overflowX)) {
          return elem;
        }
        var excludeStatic = elemStyle.position === 'absolute';
        var scrollParent = elem.parentElement || documentEl;

        if (scrollParent === documentEl || elemStyle.position === 'fixed') {
          return documentEl;
        }

        while (scrollParent.parentElement && scrollParent !== documentEl) {
          var spStyle = $window.getComputedStyle(scrollParent);
          if (excludeStatic && spStyle.position !== 'static') {
            excludeStatic = false;
          }

          if (!excludeStatic && overflowRegex.test(spStyle.overflow + spStyle.overflowY + spStyle.overflowX)) {
            break;
          }
          scrollParent = scrollParent.parentElement;
        }

        return scrollParent;
      },

      /**
       * Provides read-only equivalent of jQuery's position function:
       * http://api.jquery.com/position/ - distance to closest positioned
       * ancestor.  Does not account for margins by default like jQuery position.
       *
       * @param {element} elem - The element to caclulate the position on.
       * @param {boolean=} [includeMargins=false] - Should margins be accounted
       * for, default is false.
       *
       * @returns {object} An object with the following properties:
       *   <ul>
       *     <li>**width**: the width of the element</li>
       *     <li>**height**: the height of the element</li>
       *     <li>**top**: distance to top edge of offset parent</li>
       *     <li>**left**: distance to left edge of offset parent</li>
       *   </ul>
       */
      position: function(elem, includeMagins) {
        elem = this.getRawNode(elem);

        var elemOffset = this.offset(elem);
        if (includeMagins) {
          var elemStyle = $window.getComputedStyle(elem);
          elemOffset.top -= this.parseStyle(elemStyle.marginTop);
          elemOffset.left -= this.parseStyle(elemStyle.marginLeft);
        }
        var parent = this.offsetParent(elem);
        var parentOffset = {top: 0, left: 0};

        if (parent !== $document[0].documentElement) {
          parentOffset = this.offset(parent);
          parentOffset.top += parent.clientTop - parent.scrollTop;
          parentOffset.left += parent.clientLeft - parent.scrollLeft;
        }

        return {
          width: Math.round(angular.isNumber(elemOffset.width) ? elemOffset.width : elem.offsetWidth),
          height: Math.round(angular.isNumber(elemOffset.height) ? elemOffset.height : elem.offsetHeight),
          top: Math.round(elemOffset.top - parentOffset.top),
          left: Math.round(elemOffset.left - parentOffset.left)
        };
      },

      /**
       * Provides read-only equivalent of jQuery's offset function:
       * http://api.jquery.com/offset/ - distance to viewport.  Does
       * not account for borders, margins, or padding on the body
       * element.
       *
       * @param {element} elem - The element to calculate the offset on.
       *
       * @returns {object} An object with the following properties:
       *   <ul>
       *     <li>**width**: the width of the element</li>
       *     <li>**height**: the height of the element</li>
       *     <li>**top**: distance to top edge of viewport</li>
       *     <li>**right**: distance to bottom edge of viewport</li>
       *   </ul>
       */
      offset: function(elem) {
        elem = this.getRawNode(elem);

        var elemBCR = elem.getBoundingClientRect();
        return {
          width: Math.round(angular.isNumber(elemBCR.width) ? elemBCR.width : elem.offsetWidth),
          height: Math.round(angular.isNumber(elemBCR.height) ? elemBCR.height : elem.offsetHeight),
          top: Math.round(elemBCR.top + ($window.pageYOffset || $document[0].documentElement.scrollTop)),
          left: Math.round(elemBCR.left + ($window.pageXOffset || $document[0].documentElement.scrollLeft))
        };
      },

      /**
       * Provides offset distance to the closest scrollable ancestor
       * or viewport.  Accounts for border and scrollbar width.
       *
       * Right and bottom dimensions represent the distance to the
       * respective edge of the viewport element.  If the element
       * edge extends beyond the viewport, a negative value will be
       * reported.
       *
       * @param {element} elem - The element to get the viewport offset for.
       * @param {boolean=} [useDocument=false] - Should the viewport be the document element instead
       * of the first scrollable element, default is false.
       * @param {boolean=} [includePadding=true] - Should the padding on the offset parent element
       * be accounted for, default is true.
       *
       * @returns {object} An object with the following properties:
       *   <ul>
       *     <li>**top**: distance to the top content edge of viewport element</li>
       *     <li>**bottom**: distance to the bottom content edge of viewport element</li>
       *     <li>**left**: distance to the left content edge of viewport element</li>
       *     <li>**right**: distance to the right content edge of viewport element</li>
       *   </ul>
       */
      viewportOffset: function(elem, useDocument, includePadding) {
        elem = this.getRawNode(elem);
        includePadding = includePadding !== false ? true : false;

        var elemBCR = elem.getBoundingClientRect();
        var offsetBCR = {top: 0, left: 0, bottom: 0, right: 0};

        var offsetParent = useDocument ? $document[0].documentElement : this.scrollParent(elem);
        var offsetParentBCR = offsetParent.getBoundingClientRect();

        offsetBCR.top = offsetParentBCR.top + offsetParent.clientTop;
        offsetBCR.left = offsetParentBCR.left + offsetParent.clientLeft;
        if (offsetParent === $document[0].documentElement) {
          offsetBCR.top += $window.pageYOffset;
          offsetBCR.left += $window.pageXOffset;
        }
        offsetBCR.bottom = offsetBCR.top + offsetParent.clientHeight;
        offsetBCR.right = offsetBCR.left + offsetParent.clientWidth;

        if (includePadding) {
          var offsetParentStyle = $window.getComputedStyle(offsetParent);
          offsetBCR.top += this.parseStyle(offsetParentStyle.paddingTop);
          offsetBCR.bottom -= this.parseStyle(offsetParentStyle.paddingBottom);
          offsetBCR.left += this.parseStyle(offsetParentStyle.paddingLeft);
          offsetBCR.right -= this.parseStyle(offsetParentStyle.paddingRight);
        }

        return {
          top: Math.round(elemBCR.top - offsetBCR.top),
          bottom: Math.round(offsetBCR.bottom - elemBCR.bottom),
          left: Math.round(elemBCR.left - offsetBCR.left),
          right: Math.round(offsetBCR.right - elemBCR.right)
        };
      },

      /**
       * Provides an array of placement values parsed from a placement string.
       * Along with the 'auto' indicator, supported placement strings are:
       *   <ul>
       *     <li>top: element on top, horizontally centered on host element.</li>
       *     <li>top-left: element on top, left edge aligned with host element left edge.</li>
       *     <li>top-right: element on top, lerightft edge aligned with host element right edge.</li>
       *     <li>bottom: element on bottom, horizontally centered on host element.</li>
       *     <li>bottom-left: element on bottom, left edge aligned with host element left edge.</li>
       *     <li>bottom-right: element on bottom, right edge aligned with host element right edge.</li>
       *     <li>left: element on left, vertically centered on host element.</li>
       *     <li>left-top: element on left, top edge aligned with host element top edge.</li>
       *     <li>left-bottom: element on left, bottom edge aligned with host element bottom edge.</li>
       *     <li>right: element on right, vertically centered on host element.</li>
       *     <li>right-top: element on right, top edge aligned with host element top edge.</li>
       *     <li>right-bottom: element on right, bottom edge aligned with host element bottom edge.</li>
       *   </ul>
       * A placement string with an 'auto' indicator is expected to be
       * space separated from the placement, i.e: 'auto bottom-left'  If
       * the primary and secondary placement values do not match 'top,
       * bottom, left, right' then 'top' will be the primary placement and
       * 'center' will be the secondary placement.  If 'auto' is passed, true
       * will be returned as the 3rd value of the array.
       *
       * @param {string} placement - The placement string to parse.
       *
       * @returns {array} An array with the following values
       * <ul>
       *   <li>**[0]**: The primary placement.</li>
       *   <li>**[1]**: The secondary placement.</li>
       *   <li>**[2]**: If auto is passed: true, else undefined.</li>
       * </ul>
       */
      parsePlacement: function(placement) {
        var autoPlace = PLACEMENT_REGEX.auto.test(placement);
        if (autoPlace) {
          placement = placement.replace(PLACEMENT_REGEX.auto, '');
        }

        placement = placement.split('-');

        placement[0] = placement[0] || 'top';
        if (!PLACEMENT_REGEX.primary.test(placement[0])) {
          placement[0] = 'top';
        }

        placement[1] = placement[1] || 'center';
        if (!PLACEMENT_REGEX.secondary.test(placement[1])) {
          placement[1] = 'center';
        }

        if (autoPlace) {
          placement[2] = true;
        } else {
          placement[2] = false;
        }

        return placement;
      },

      /**
       * Provides coordinates for an element to be positioned relative to
       * another element.  Passing 'auto' as part of the placement parameter
       * will enable smart placement - where the element fits. i.e:
       * 'auto left-top' will check to see if there is enough space to the left
       * of the hostElem to fit the targetElem, if not place right (same for secondary
       * top placement).  Available space is calculated using the viewportOffset
       * function.
       *
       * @param {element} hostElem - The element to position against.
       * @param {element} targetElem - The element to position.
       * @param {string=} [placement=top] - The placement for the targetElem,
       *   default is 'top'. 'center' is assumed as secondary placement for
       *   'top', 'left', 'right', and 'bottom' placements.  Available placements are:
       *   <ul>
       *     <li>top</li>
       *     <li>top-right</li>
       *     <li>top-left</li>
       *     <li>bottom</li>
       *     <li>bottom-left</li>
       *     <li>bottom-right</li>
       *     <li>left</li>
       *     <li>left-top</li>
       *     <li>left-bottom</li>
       *     <li>right</li>
       *     <li>right-top</li>
       *     <li>right-bottom</li>
       *   </ul>
       * @param {boolean=} [appendToBody=false] - Should the top and left values returned
       *   be calculated from the body element, default is false.
       *
       * @returns {object} An object with the following properties:
       *   <ul>
       *     <li>**top**: Value for targetElem top.</li>
       *     <li>**left**: Value for targetElem left.</li>
       *     <li>**placement**: The resolved placement.</li>
       *   </ul>
       */
      positionElements: function(hostElem, targetElem, placement, appendToBody) {
        hostElem = this.getRawNode(hostElem);
        targetElem = this.getRawNode(targetElem);

        // need to read from prop to support tests.
        var targetWidth = angular.isDefined(targetElem.offsetWidth) ? targetElem.offsetWidth : targetElem.prop('offsetWidth');
        var targetHeight = angular.isDefined(targetElem.offsetHeight) ? targetElem.offsetHeight : targetElem.prop('offsetHeight');

        placement = this.parsePlacement(placement);

        var hostElemPos = appendToBody ? this.offset(hostElem) : this.position(hostElem);
        var targetElemPos = {top: 0, left: 0, placement: ''};

        if (placement[2]) {
          var viewportOffset = this.viewportOffset(hostElem, appendToBody);

          var targetElemStyle = $window.getComputedStyle(targetElem);
          var adjustedSize = {
            width: targetWidth + Math.round(Math.abs(this.parseStyle(targetElemStyle.marginLeft) + this.parseStyle(targetElemStyle.marginRight))),
            height: targetHeight + Math.round(Math.abs(this.parseStyle(targetElemStyle.marginTop) + this.parseStyle(targetElemStyle.marginBottom)))
          };

          placement[0] = placement[0] === 'top' && adjustedSize.height > viewportOffset.top && adjustedSize.height <= viewportOffset.bottom ? 'bottom' :
                         placement[0] === 'bottom' && adjustedSize.height > viewportOffset.bottom && adjustedSize.height <= viewportOffset.top ? 'top' :
                         placement[0] === 'left' && adjustedSize.width > viewportOffset.left && adjustedSize.width <= viewportOffset.right ? 'right' :
                         placement[0] === 'right' && adjustedSize.width > viewportOffset.right && adjustedSize.width <= viewportOffset.left ? 'left' :
                         placement[0];

          placement[1] = placement[1] === 'top' && adjustedSize.height - hostElemPos.height > viewportOffset.bottom && adjustedSize.height - hostElemPos.height <= viewportOffset.top ? 'bottom' :
                         placement[1] === 'bottom' && adjustedSize.height - hostElemPos.height > viewportOffset.top && adjustedSize.height - hostElemPos.height <= viewportOffset.bottom ? 'top' :
                         placement[1] === 'left' && adjustedSize.width - hostElemPos.width > viewportOffset.right && adjustedSize.width - hostElemPos.width <= viewportOffset.left ? 'right' :
                         placement[1] === 'right' && adjustedSize.width - hostElemPos.width > viewportOffset.left && adjustedSize.width - hostElemPos.width <= viewportOffset.right ? 'left' :
                         placement[1];

          if (placement[1] === 'center') {
            if (PLACEMENT_REGEX.vertical.test(placement[0])) {
              var xOverflow = hostElemPos.width / 2 - targetWidth / 2;
              if (viewportOffset.left + xOverflow < 0 && adjustedSize.width - hostElemPos.width <= viewportOffset.right) {
                placement[1] = 'left';
              } else if (viewportOffset.right + xOverflow < 0 && adjustedSize.width - hostElemPos.width <= viewportOffset.left) {
                placement[1] = 'right';
              }
            } else {
              var yOverflow = hostElemPos.height / 2 - adjustedSize.height / 2;
              if (viewportOffset.top + yOverflow < 0 && adjustedSize.height - hostElemPos.height <= viewportOffset.bottom) {
                placement[1] = 'top';
              } else if (viewportOffset.bottom + yOverflow < 0 && adjustedSize.height - hostElemPos.height <= viewportOffset.top) {
                placement[1] = 'bottom';
              }
            }
          }
        }

        switch (placement[0]) {
          case 'top':
            targetElemPos.top = hostElemPos.top - targetHeight;
            break;
          case 'bottom':
            targetElemPos.top = hostElemPos.top + hostElemPos.height;
            break;
          case 'left':
            targetElemPos.left = hostElemPos.left - targetWidth;
            break;
          case 'right':
            targetElemPos.left = hostElemPos.left + hostElemPos.width;
            break;
        }

        switch (placement[1]) {
          case 'top':
            targetElemPos.top = hostElemPos.top;
            break;
          case 'bottom':
            targetElemPos.top = hostElemPos.top + hostElemPos.height - targetHeight;
            break;
          case 'left':
            targetElemPos.left = hostElemPos.left;
            break;
          case 'right':
            targetElemPos.left = hostElemPos.left + hostElemPos.width - targetWidth;
            break;
          case 'center':
            if (PLACEMENT_REGEX.vertical.test(placement[0])) {
              targetElemPos.left = hostElemPos.left + hostElemPos.width / 2 - targetWidth / 2;
            } else {
              targetElemPos.top = hostElemPos.top + hostElemPos.height / 2 - targetHeight / 2;
            }
            break;
        }

        targetElemPos.top = Math.round(targetElemPos.top);
        targetElemPos.left = Math.round(targetElemPos.left);
        targetElemPos.placement = placement[1] === 'center' ? placement[0] : placement[0] + '-' + placement[1];

        return targetElemPos;
      },

      /**
       * Provides a way to adjust the top positioning after first
       * render to correctly align element to top after content
       * rendering causes resized element height
       *
       * @param {array} placementClasses - The array of strings of classes
       * element should have.
       * @param {object} containerPosition - The object with container
       * position information
       * @param {number} initialHeight - The initial height for the elem.
       * @param {number} currentHeight - The current height for the elem.
       */
      adjustTop: function(placementClasses, containerPosition, initialHeight, currentHeight) {
        if (placementClasses.indexOf('top') !== -1 && initialHeight !== currentHeight) {
          return {
            top: containerPosition.top - currentHeight + 'px'
          };
        }
      },

      /**
       * Provides a way for positioning tooltip & dropdown
       * arrows when using placement options beyond the standard
       * left, right, top, or bottom.
       *
       * @param {element} elem - The tooltip/dropdown element.
       * @param {string} placement - The placement for the elem.
       */
      positionArrow: function(elem, placement) {
        elem = this.getRawNode(elem);

        var innerElem = elem.querySelector('.tooltip-inner, .popover-inner');
        if (!innerElem) {
          return;
        }

        var isTooltip = angular.element(innerElem).hasClass('tooltip-inner');

        var arrowElem = isTooltip ? elem.querySelector('.tooltip-arrow') : elem.querySelector('.arrow');
        if (!arrowElem) {
          return;
        }

        var arrowCss = {
          top: '',
          bottom: '',
          left: '',
          right: ''
        };

        placement = this.parsePlacement(placement);
        if (placement[1] === 'center') {
          // no adjustment necessary - just reset styles
          angular.element(arrowElem).css(arrowCss);
          return;
        }

        var borderProp = 'border-' + placement[0] + '-width';
        var borderWidth = $window.getComputedStyle(arrowElem)[borderProp];

        var borderRadiusProp = 'border-';
        if (PLACEMENT_REGEX.vertical.test(placement[0])) {
          borderRadiusProp += placement[0] + '-' + placement[1];
        } else {
          borderRadiusProp += placement[1] + '-' + placement[0];
        }
        borderRadiusProp += '-radius';
        var borderRadius = $window.getComputedStyle(isTooltip ? innerElem : elem)[borderRadiusProp];

        switch (placement[0]) {
          case 'top':
            arrowCss.bottom = isTooltip ? '0' : '-' + borderWidth;
            break;
          case 'bottom':
            arrowCss.top = isTooltip ? '0' : '-' + borderWidth;
            break;
          case 'left':
            arrowCss.right = isTooltip ? '0' : '-' + borderWidth;
            break;
          case 'right':
            arrowCss.left = isTooltip ? '0' : '-' + borderWidth;
            break;
        }

        arrowCss[placement[1]] = borderRadius;

        angular.element(arrowElem).css(arrowCss);
      }
    };
  }]);

angular.module('ui.bootstrap.datepickerPopup', ['ui.bootstrap.datepicker', 'ui.bootstrap.position'])

.value('$datepickerPopupLiteralWarning', true)

.constant('uibDatepickerPopupConfig', {
  altInputFormats: [],
  appendToBody: false,
  clearText: 'Clear',
  closeOnDateSelection: true,
  closeText: 'Done',
  currentText: 'Today',
  datepickerPopup: 'yyyy-MM-dd',
  datepickerPopupTemplateUrl: 'uib/template/datepickerPopup/popup.html',
  datepickerTemplateUrl: 'uib/template/datepicker/datepicker.html',
  html5Types: {
    date: 'yyyy-MM-dd',
    'datetime-local': 'yyyy-MM-ddTHH:mm:ss.sss',
    'month': 'yyyy-MM'
  },
  onOpenFocus: true,
  showButtonBar: true,
  placement: 'auto bottom-left'
})

.controller('UibDatepickerPopupController', ['$scope', '$element', '$attrs', '$compile', '$log', '$parse', '$window', '$document', '$rootScope', '$uibPosition', 'dateFilter', 'uibDateParser', 'uibDatepickerPopupConfig', '$timeout', 'uibDatepickerConfig', '$datepickerPopupLiteralWarning',
function($scope, $element, $attrs, $compile, $log, $parse, $window, $document, $rootScope, $position, dateFilter, dateParser, datepickerPopupConfig, $timeout, datepickerConfig, $datepickerPopupLiteralWarning) {
  var cache = {},
    isHtml5DateInput = false;
  var dateFormat, closeOnDateSelection, appendToBody, onOpenFocus,
    datepickerPopupTemplateUrl, datepickerTemplateUrl, popupEl, datepickerEl, scrollParentEl,
    ngModel, ngModelOptions, $popup, altInputFormats, watchListeners = [];

  this.init = function(_ngModel_) {
    ngModel = _ngModel_;
    ngModelOptions = angular.isObject(_ngModel_.$options) ?
      _ngModel_.$options :
      {
        timezone: null
      };
    closeOnDateSelection = angular.isDefined($attrs.closeOnDateSelection) ?
      $scope.$parent.$eval($attrs.closeOnDateSelection) :
      datepickerPopupConfig.closeOnDateSelection;
    appendToBody = angular.isDefined($attrs.datepickerAppendToBody) ?
      $scope.$parent.$eval($attrs.datepickerAppendToBody) :
      datepickerPopupConfig.appendToBody;
    onOpenFocus = angular.isDefined($attrs.onOpenFocus) ?
      $scope.$parent.$eval($attrs.onOpenFocus) : datepickerPopupConfig.onOpenFocus;
    datepickerPopupTemplateUrl = angular.isDefined($attrs.datepickerPopupTemplateUrl) ?
      $attrs.datepickerPopupTemplateUrl :
      datepickerPopupConfig.datepickerPopupTemplateUrl;
    datepickerTemplateUrl = angular.isDefined($attrs.datepickerTemplateUrl) ?
      $attrs.datepickerTemplateUrl : datepickerPopupConfig.datepickerTemplateUrl;
    altInputFormats = angular.isDefined($attrs.altInputFormats) ?
      $scope.$parent.$eval($attrs.altInputFormats) :
      datepickerPopupConfig.altInputFormats;

    $scope.showButtonBar = angular.isDefined($attrs.showButtonBar) ?
      $scope.$parent.$eval($attrs.showButtonBar) :
      datepickerPopupConfig.showButtonBar;

    if (datepickerPopupConfig.html5Types[$attrs.type]) {
      dateFormat = datepickerPopupConfig.html5Types[$attrs.type];
      isHtml5DateInput = true;
    } else {
      dateFormat = $attrs.uibDatepickerPopup || datepickerPopupConfig.datepickerPopup;
      $attrs.$observe('uibDatepickerPopup', function(value, oldValue) {
        var newDateFormat = value || datepickerPopupConfig.datepickerPopup;
        // Invalidate the $modelValue to ensure that formatters re-run
        // FIXME: Refactor when PR is merged: https://github.com/angular/angular.js/pull/10764
        if (newDateFormat !== dateFormat) {
          dateFormat = newDateFormat;
          ngModel.$modelValue = null;

          if (!dateFormat) {
            throw new Error('uibDatepickerPopup must have a date format specified.');
          }
        }
      });
    }

    if (!dateFormat) {
      throw new Error('uibDatepickerPopup must have a date format specified.');
    }

    if (isHtml5DateInput && $attrs.uibDatepickerPopup) {
      throw new Error('HTML5 date input types do not support custom formats.');
    }

    // popup element used to display calendar
    popupEl = angular.element('<div uib-datepicker-popup-wrap><div uib-datepicker></div></div>');

    popupEl.attr({
      'ng-model': 'date',
      'ng-change': 'dateSelection(date)',
      'template-url': datepickerPopupTemplateUrl
    });

    // datepicker element
    datepickerEl = angular.element(popupEl.children()[0]);
    datepickerEl.attr('template-url', datepickerTemplateUrl);

    if (!$scope.datepickerOptions) {
      $scope.datepickerOptions = {};
    }

    if (isHtml5DateInput) {
      if ($attrs.type === 'month') {
        $scope.datepickerOptions.datepickerMode = 'month';
        $scope.datepickerOptions.minMode = 'month';
      }
    }

    datepickerEl.attr('datepicker-options', 'datepickerOptions');

    if (!isHtml5DateInput) {
      // Internal API to maintain the correct ng-invalid-[key] class
      ngModel.$$parserName = 'date';
      ngModel.$validators.date = validator;
      ngModel.$parsers.unshift(parseDate);
      ngModel.$formatters.push(function(value) {
        if (ngModel.$isEmpty(value)) {
          $scope.date = value;
          return value;
        }

        if (angular.isNumber(value)) {
          value = new Date(value);
        }

        $scope.date = dateParser.fromTimezone(value, ngModelOptions.timezone);

        return dateParser.filter($scope.date, dateFormat);
      });
    } else {
      ngModel.$formatters.push(function(value) {
        $scope.date = dateParser.fromTimezone(value, ngModelOptions.timezone);
        return value;
      });
    }

    // Detect changes in the view from the text box
    ngModel.$viewChangeListeners.push(function() {
      $scope.date = parseDateString(ngModel.$viewValue);
    });

    $element.on('keydown', inputKeydownBind);

    $popup = $compile(popupEl)($scope);
    // Prevent jQuery cache memory leak (template is now redundant after linking)
    popupEl.remove();

    if (appendToBody) {
      $document.find('body').append($popup);
    } else {
      $element.after($popup);
    }

    $scope.$on('$destroy', function() {
      if ($scope.isOpen === true) {
        if (!$rootScope.$$phase) {
          $scope.$apply(function() {
            $scope.isOpen = false;
          });
        }
      }

      $popup.remove();
      $element.off('keydown', inputKeydownBind);
      $document.off('click', documentClickBind);
      if (scrollParentEl) {
        scrollParentEl.off('scroll', positionPopup);
      }
      angular.element($window).off('resize', positionPopup);

      //Clear all watch listeners on destroy
      while (watchListeners.length) {
        watchListeners.shift()();
      }
    });
  };

  $scope.getText = function(key) {
    return $scope[key + 'Text'] || datepickerPopupConfig[key + 'Text'];
  };

  $scope.isDisabled = function(date) {
    if (date === 'today') {
      date = dateParser.fromTimezone(new Date(), ngModelOptions.timezone);
    }

    var dates = {};
    angular.forEach(['minDate', 'maxDate'], function(key) {
      if (!$scope.datepickerOptions[key]) {
        dates[key] = null;
      } else if (angular.isDate($scope.datepickerOptions[key])) {
        dates[key] = new Date($scope.datepickerOptions[key]);
      } else {
        if ($datepickerPopupLiteralWarning) {
          $log.warn('Literal date support has been deprecated, please switch to date object usage');
        }

        dates[key] = new Date(dateFilter($scope.datepickerOptions[key], 'medium'));
      }
    });

    return $scope.datepickerOptions &&
      dates.minDate && $scope.compare(date, dates.minDate) < 0 ||
      dates.maxDate && $scope.compare(date, dates.maxDate) > 0;
  };

  $scope.compare = function(date1, date2) {
    return new Date(date1.getFullYear(), date1.getMonth(), date1.getDate()) - new Date(date2.getFullYear(), date2.getMonth(), date2.getDate());
  };

  // Inner change
  $scope.dateSelection = function(dt) {
    $scope.date = dt;
    var date = $scope.date ? dateParser.filter($scope.date, dateFormat) : null; // Setting to NULL is necessary for form validators to function
    $element.val(date);
    ngModel.$setViewValue(date);

    if (closeOnDateSelection) {
      $scope.isOpen = false;
      $element[0].focus();
    }
  };

  $scope.keydown = function(evt) {
    if (evt.which === 27) {
      evt.stopPropagation();
      $scope.isOpen = false;
      $element[0].focus();
    }
  };

  $scope.select = function(date, evt) {
    evt.stopPropagation();

    if (date === 'today') {
      var today = new Date();
      if (angular.isDate($scope.date)) {
        date = new Date($scope.date);
        date.setFullYear(today.getFullYear(), today.getMonth(), today.getDate());
      } else {
        date = dateParser.fromTimezone(today, ngModelOptions.timezone);
        date.setHours(0, 0, 0, 0);
      }
    }
    $scope.dateSelection(date);
  };

  $scope.close = function(evt) {
    evt.stopPropagation();

    $scope.isOpen = false;
    $element[0].focus();
  };

  $scope.disabled = angular.isDefined($attrs.disabled) || false;
  if ($attrs.ngDisabled) {
    watchListeners.push($scope.$parent.$watch($parse($attrs.ngDisabled), function(disabled) {
      $scope.disabled = disabled;
    }));
  }

  $scope.$watch('isOpen', function(value) {
    if (value) {
      if (!$scope.disabled) {
        $timeout(function() {
          positionPopup();

          if (onOpenFocus) {
            $scope.$broadcast('uib:datepicker.focus');
          }

          $document.on('click', documentClickBind);

          var placement = $attrs.popupPlacement ? $attrs.popupPlacement : datepickerPopupConfig.placement;
          if (appendToBody || $position.parsePlacement(placement)[2]) {
            scrollParentEl = scrollParentEl || angular.element($position.scrollParent($element));
            if (scrollParentEl) {
              scrollParentEl.on('scroll', positionPopup);
            }
          } else {
            scrollParentEl = null;
          }

          angular.element($window).on('resize', positionPopup);
        }, 0, false);
      } else {
        $scope.isOpen = false;
      }
    } else {
      $document.off('click', documentClickBind);
      if (scrollParentEl) {
        scrollParentEl.off('scroll', positionPopup);
      }
      angular.element($window).off('resize', positionPopup);
    }
  });

  function cameltoDash(string) {
    return string.replace(/([A-Z])/g, function($1) { return '-' + $1.toLowerCase(); });
  }

  function parseDateString(viewValue) {
    var date = dateParser.parse(viewValue, dateFormat, $scope.date);
    if (isNaN(date)) {
      for (var i = 0; i < altInputFormats.length; i++) {
        date = dateParser.parse(viewValue, altInputFormats[i], $scope.date);
        if (!isNaN(date)) {
          return date;
        }
      }
    }
    return date;
  }

  function parseDate(viewValue) {
    if (angular.isNumber(viewValue)) {
      // presumably timestamp to date object
      viewValue = new Date(viewValue);
    }

    if (!viewValue) {
      return null;
    }

    if (angular.isDate(viewValue) && !isNaN(viewValue)) {
      return viewValue;
    }

    if (angular.isString(viewValue)) {
      var date = parseDateString(viewValue);
      if (!isNaN(date)) {
        return dateParser.toTimezone(date, ngModelOptions.timezone);
      }
    }

    return ngModel.$options && ngModel.$options.allowInvalid ? viewValue : undefined;
  }

  function validator(modelValue, viewValue) {
    var value = modelValue || viewValue;

    if (!$attrs.ngRequired && !value) {
      return true;
    }

    if (angular.isNumber(value)) {
      value = new Date(value);
    }

    if (!value) {
      return true;
    }

    if (angular.isDate(value) && !isNaN(value)) {
      return true;
    }

    if (angular.isString(value)) {
      return !isNaN(parseDateString(value));
    }

    return false;
  }

  function documentClickBind(event) {
    if (!$scope.isOpen && $scope.disabled) {
      return;
    }

    var popup = $popup[0];
    var dpContainsTarget = $element[0].contains(event.target);
    // The popup node may not be an element node
    // In some browsers (IE) only element nodes have the 'contains' function
    var popupContainsTarget = popup.contains !== undefined && popup.contains(event.target);
    if ($scope.isOpen && !(dpContainsTarget || popupContainsTarget)) {
      $scope.$apply(function() {
        $scope.isOpen = false;
      });
    }
  }

  function inputKeydownBind(evt) {
    if (evt.which === 27 && $scope.isOpen) {
      evt.preventDefault();
      evt.stopPropagation();
      $scope.$apply(function() {
        $scope.isOpen = false;
      });
      $element[0].focus();
    } else if (evt.which === 40 && !$scope.isOpen) {
      evt.preventDefault();
      evt.stopPropagation();
      $scope.$apply(function() {
        $scope.isOpen = true;
      });
    }
  }

  function positionPopup() {
    if ($scope.isOpen) {
      var dpElement = angular.element($popup[0].querySelector('.uib-datepicker-popup'));
      var placement = $attrs.popupPlacement ? $attrs.popupPlacement : datepickerPopupConfig.placement;
      var position = $position.positionElements($element, dpElement, placement, appendToBody);
      dpElement.css({top: position.top + 'px', left: position.left + 'px'});
      if (dpElement.hasClass('uib-position-measure')) {
        dpElement.removeClass('uib-position-measure');
      }
    }
  }

  $scope.$on('uib:datepicker.mode', function() {
    $timeout(positionPopup, 0, false);
  });
}])

.directive('uibDatepickerPopup', function() {
  return {
    require: ['ngModel', 'uibDatepickerPopup'],
    controller: 'UibDatepickerPopupController',
    scope: {
      datepickerOptions: '=?',
      isOpen: '=?',
      currentText: '@',
      clearText: '@',
      closeText: '@'
    },
    link: function(scope, element, attrs, ctrls) {
      var ngModel = ctrls[0],
        ctrl = ctrls[1];

      ctrl.init(ngModel);
    }
  };
})

.directive('uibDatepickerPopupWrap', function() {
  return {
    restrict: 'A',
    transclude: true,
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/datepickerPopup/popup.html';
    }
  };
});

angular.module('ui.bootstrap.debounce', [])
/**
 * A helper, internal service that debounces a function
 */
  .factory('$$debounce', ['$timeout', function($timeout) {
    return function(callback, debounceTime) {
      var timeoutPromise;

      return function() {
        var self = this;
        var args = Array.prototype.slice.call(arguments);
        if (timeoutPromise) {
          $timeout.cancel(timeoutPromise);
        }

        timeoutPromise = $timeout(function() {
          callback.apply(self, args);
        }, debounceTime);
      };
    };
  }]);

angular.module('ui.bootstrap.multiMap', [])
/**
 * A helper, internal data structure that stores all references attached to key
 */
  .factory('$$multiMap', function() {
    return {
      createNew: function() {
        var map = {};

        return {
          entries: function() {
            return Object.keys(map).map(function(key) {
              return {
                key: key,
                value: map[key]
              };
            });
          },
          get: function(key) {
            return map[key];
          },
          hasKey: function(key) {
            return !!map[key];
          },
          keys: function() {
            return Object.keys(map);
          },
          put: function(key, value) {
            if (!map[key]) {
              map[key] = [];
            }

            map[key].push(value);
          },
          remove: function(key, value) {
            var values = map[key];

            if (!values) {
              return;
            }

            var idx = values.indexOf(value);

            if (idx !== -1) {
              values.splice(idx, 1);
            }

            if (!values.length) {
              delete map[key];
            }
          }
        };
      }
    };
  });

angular.module('ui.bootstrap.dropdown', ['ui.bootstrap.multiMap', 'ui.bootstrap.position'])

.constant('uibDropdownConfig', {
  appendToOpenClass: 'uib-dropdown-open',
  openClass: 'open'
})

.service('uibDropdownService', ['$document', '$rootScope', '$$multiMap', function($document, $rootScope, $$multiMap) {
  var openScope = null;
  var openedContainers = $$multiMap.createNew();

  this.isOnlyOpen = function(dropdownScope, appendTo) {
    var openedDropdowns = openedContainers.get(appendTo);
    if (openedDropdowns) {
      var openDropdown = openedDropdowns.reduce(function(toClose, dropdown) {
        if (dropdown.scope === dropdownScope) {
          return dropdown;
        }

        return toClose;
      }, {});
      if (openDropdown) {
        return openedDropdowns.length === 1;
      }
    }

    return false;
  };

  this.open = function(dropdownScope, element, appendTo) {
    if (!openScope) {
      $document.on('click', closeDropdown);
    }

    if (openScope && openScope !== dropdownScope) {
      openScope.isOpen = false;
    }

    openScope = dropdownScope;

    if (!appendTo) {
      return;
    }

    var openedDropdowns = openedContainers.get(appendTo);
    if (openedDropdowns) {
      var openedScopes = openedDropdowns.map(function(dropdown) {
        return dropdown.scope;
      });
      if (openedScopes.indexOf(dropdownScope) === -1) {
        openedContainers.put(appendTo, {
          scope: dropdownScope
        });
      }
    } else {
      openedContainers.put(appendTo, {
        scope: dropdownScope
      });
    }
  };

  this.close = function(dropdownScope, element, appendTo) {
    if (openScope === dropdownScope) {
      $document.off('click', closeDropdown);
      $document.off('keydown', this.keybindFilter);
      openScope = null;
    }

    if (!appendTo) {
      return;
    }

    var openedDropdowns = openedContainers.get(appendTo);
    if (openedDropdowns) {
      var dropdownToClose = openedDropdowns.reduce(function(toClose, dropdown) {
        if (dropdown.scope === dropdownScope) {
          return dropdown;
        }

        return toClose;
      }, {});
      if (dropdownToClose) {
        openedContainers.remove(appendTo, dropdownToClose);
      }
    }
  };

  var closeDropdown = function(evt) {
    // This method may still be called during the same mouse event that
    // unbound this event handler. So check openScope before proceeding.
    if (!openScope) { return; }

    if (evt && openScope.getAutoClose() === 'disabled') { return; }

    if (evt && evt.which === 3) { return; }

    var toggleElement = openScope.getToggleElement();
    if (evt && toggleElement && toggleElement[0].contains(evt.target)) {
      return;
    }

    var dropdownElement = openScope.getDropdownElement();
    if (evt && openScope.getAutoClose() === 'outsideClick' &&
      dropdownElement && dropdownElement[0].contains(evt.target)) {
      return;
    }

    openScope.focusToggleElement();
    openScope.isOpen = false;

    if (!$rootScope.$$phase) {
      openScope.$apply();
    }
  };

  this.keybindFilter = function(evt) {
    if (!openScope) {
      // see this.close as ESC could have been pressed which kills the scope so we can not proceed
      return;
    }

    var dropdownElement = openScope.getDropdownElement();
    var toggleElement = openScope.getToggleElement();
    var dropdownElementTargeted = dropdownElement && dropdownElement[0].contains(evt.target);
    var toggleElementTargeted = toggleElement && toggleElement[0].contains(evt.target);
    if (evt.which === 27) {
      evt.stopPropagation();
      openScope.focusToggleElement();
      closeDropdown();
    } else if (openScope.isKeynavEnabled() && [38, 40].indexOf(evt.which) !== -1 && openScope.isOpen && (dropdownElementTargeted || toggleElementTargeted)) {
      evt.preventDefault();
      evt.stopPropagation();
      openScope.focusDropdownEntry(evt.which);
    }
  };
}])

.controller('UibDropdownController', ['$scope', '$element', '$attrs', '$parse', 'uibDropdownConfig', 'uibDropdownService', '$animate', '$uibPosition', '$document', '$compile', '$templateRequest', function($scope, $element, $attrs, $parse, dropdownConfig, uibDropdownService, $animate, $position, $document, $compile, $templateRequest) {
  var self = this,
    scope = $scope.$new(), // create a child scope so we are not polluting original one
    templateScope,
    appendToOpenClass = dropdownConfig.appendToOpenClass,
    openClass = dropdownConfig.openClass,
    getIsOpen,
    setIsOpen = angular.noop,
    toggleInvoker = $attrs.onToggle ? $parse($attrs.onToggle) : angular.noop,
    appendToBody = false,
    appendTo = null,
    keynavEnabled = false,
    selectedOption = null,
    body = $document.find('body');

  $element.addClass('dropdown');

  this.init = function() {
    if ($attrs.isOpen) {
      getIsOpen = $parse($attrs.isOpen);
      setIsOpen = getIsOpen.assign;

      $scope.$watch(getIsOpen, function(value) {
        scope.isOpen = !!value;
      });
    }

    if (angular.isDefined($attrs.dropdownAppendTo)) {
      var appendToEl = $parse($attrs.dropdownAppendTo)(scope);
      if (appendToEl) {
        appendTo = angular.element(appendToEl);
      }
    }

    appendToBody = angular.isDefined($attrs.dropdownAppendToBody);
    keynavEnabled = angular.isDefined($attrs.keyboardNav);

    if (appendToBody && !appendTo) {
      appendTo = body;
    }

    if (appendTo && self.dropdownMenu) {
      appendTo.append(self.dropdownMenu);
      $element.on('$destroy', function handleDestroyEvent() {
        self.dropdownMenu.remove();
      });
    }
  };

  this.toggle = function(open) {
    scope.isOpen = arguments.length ? !!open : !scope.isOpen;
    if (angular.isFunction(setIsOpen)) {
      setIsOpen(scope, scope.isOpen);
    }

    return scope.isOpen;
  };

  // Allow other directives to watch status
  this.isOpen = function() {
    return scope.isOpen;
  };

  scope.getToggleElement = function() {
    return self.toggleElement;
  };

  scope.getAutoClose = function() {
    return $attrs.autoClose || 'always'; //or 'outsideClick' or 'disabled'
  };

  scope.getElement = function() {
    return $element;
  };

  scope.isKeynavEnabled = function() {
    return keynavEnabled;
  };

  scope.focusDropdownEntry = function(keyCode) {
    var elems = self.dropdownMenu ? //If append to body is used.
      angular.element(self.dropdownMenu).find('a') :
      $element.find('ul').eq(0).find('a');

    switch (keyCode) {
      case 40: {
        if (!angular.isNumber(self.selectedOption)) {
          self.selectedOption = 0;
        } else {
          self.selectedOption = self.selectedOption === elems.length - 1 ?
            self.selectedOption :
            self.selectedOption + 1;
        }
        break;
      }
      case 38: {
        if (!angular.isNumber(self.selectedOption)) {
          self.selectedOption = elems.length - 1;
        } else {
          self.selectedOption = self.selectedOption === 0 ?
            0 : self.selectedOption - 1;
        }
        break;
      }
    }
    elems[self.selectedOption].focus();
  };

  scope.getDropdownElement = function() {
    return self.dropdownMenu;
  };

  scope.focusToggleElement = function() {
    if (self.toggleElement) {
      self.toggleElement[0].focus();
    }
  };

  scope.$watch('isOpen', function(isOpen, wasOpen) {
    if (appendTo && self.dropdownMenu) {
      var pos = $position.positionElements($element, self.dropdownMenu, 'bottom-left', true),
        css,
        rightalign,
        scrollbarPadding,
        scrollbarWidth = 0;

      css = {
        top: pos.top + 'px',
        display: isOpen ? 'block' : 'none'
      };

      rightalign = self.dropdownMenu.hasClass('dropdown-menu-right');
      if (!rightalign) {
        css.left = pos.left + 'px';
        css.right = 'auto';
      } else {
        css.left = 'auto';
        scrollbarPadding = $position.scrollbarPadding(appendTo);

        if (scrollbarPadding.heightOverflow && scrollbarPadding.scrollbarWidth) {
          scrollbarWidth = scrollbarPadding.scrollbarWidth;
        }

        css.right = window.innerWidth - scrollbarWidth -
          (pos.left + $element.prop('offsetWidth')) + 'px';
      }

      // Need to adjust our positioning to be relative to the appendTo container
      // if it's not the body element
      if (!appendToBody) {
        var appendOffset = $position.offset(appendTo);

        css.top = pos.top - appendOffset.top + 'px';

        if (!rightalign) {
          css.left = pos.left - appendOffset.left + 'px';
        } else {
          css.right = window.innerWidth -
            (pos.left - appendOffset.left + $element.prop('offsetWidth')) + 'px';
        }
      }

      self.dropdownMenu.css(css);
    }

    var openContainer = appendTo ? appendTo : $element;
    var dropdownOpenClass = appendTo ? appendToOpenClass : openClass;
    var hasOpenClass = openContainer.hasClass(dropdownOpenClass);
    var isOnlyOpen = uibDropdownService.isOnlyOpen($scope, appendTo);

    if (hasOpenClass === !isOpen) {
      var toggleClass;
      if (appendTo) {
        toggleClass = !isOnlyOpen ? 'addClass' : 'removeClass';
      } else {
        toggleClass = isOpen ? 'addClass' : 'removeClass';
      }
      $animate[toggleClass](openContainer, dropdownOpenClass).then(function() {
        if (angular.isDefined(isOpen) && isOpen !== wasOpen) {
          toggleInvoker($scope, { open: !!isOpen });
        }
      });
    }

    if (isOpen) {
      if (self.dropdownMenuTemplateUrl) {
        $templateRequest(self.dropdownMenuTemplateUrl).then(function(tplContent) {
          templateScope = scope.$new();
          $compile(tplContent.trim())(templateScope, function(dropdownElement) {
            var newEl = dropdownElement;
            self.dropdownMenu.replaceWith(newEl);
            self.dropdownMenu = newEl;
            $document.on('keydown', uibDropdownService.keybindFilter);
          });
        });
      } else {
        $document.on('keydown', uibDropdownService.keybindFilter);
      }

      scope.focusToggleElement();
      uibDropdownService.open(scope, $element, appendTo);
    } else {
      uibDropdownService.close(scope, $element, appendTo);
      if (self.dropdownMenuTemplateUrl) {
        if (templateScope) {
          templateScope.$destroy();
        }
        var newEl = angular.element('<ul class="dropdown-menu"></ul>');
        self.dropdownMenu.replaceWith(newEl);
        self.dropdownMenu = newEl;
      }

      self.selectedOption = null;
    }

    if (angular.isFunction(setIsOpen)) {
      setIsOpen($scope, isOpen);
    }
  });
}])

.directive('uibDropdown', function() {
  return {
    controller: 'UibDropdownController',
    link: function(scope, element, attrs, dropdownCtrl) {
      dropdownCtrl.init();
    }
  };
})

.directive('uibDropdownMenu', function() {
  return {
    restrict: 'A',
    require: '?^uibDropdown',
    link: function(scope, element, attrs, dropdownCtrl) {
      if (!dropdownCtrl || angular.isDefined(attrs.dropdownNested)) {
        return;
      }

      element.addClass('dropdown-menu');

      var tplUrl = attrs.templateUrl;
      if (tplUrl) {
        dropdownCtrl.dropdownMenuTemplateUrl = tplUrl;
      }

      if (!dropdownCtrl.dropdownMenu) {
        dropdownCtrl.dropdownMenu = element;
      }
    }
  };
})

.directive('uibDropdownToggle', function() {
  return {
    require: '?^uibDropdown',
    link: function(scope, element, attrs, dropdownCtrl) {
      if (!dropdownCtrl) {
        return;
      }

      element.addClass('dropdown-toggle');

      dropdownCtrl.toggleElement = element;

      var toggleDropdown = function(event) {
        event.preventDefault();

        if (!element.hasClass('disabled') && !attrs.disabled) {
          scope.$apply(function() {
            dropdownCtrl.toggle();
          });
        }
      };

      element.on('click', toggleDropdown);

      // WAI-ARIA
      element.attr({ 'aria-haspopup': true, 'aria-expanded': false });
      scope.$watch(dropdownCtrl.isOpen, function(isOpen) {
        element.attr('aria-expanded', !!isOpen);
      });

      scope.$on('$destroy', function() {
        element.off('click', toggleDropdown);
      });
    }
  };
});

angular.module('ui.bootstrap.stackedMap', [])
/**
 * A helper, internal data structure that acts as a map but also allows getting / removing
 * elements in the LIFO order
 */
  .factory('$$stackedMap', function() {
    return {
      createNew: function() {
        var stack = [];

        return {
          add: function(key, value) {
            stack.push({
              key: key,
              value: value
            });
          },
          get: function(key) {
            for (var i = 0; i < stack.length; i++) {
              if (key === stack[i].key) {
                return stack[i];
              }
            }
          },
          keys: function() {
            var keys = [];
            for (var i = 0; i < stack.length; i++) {
              keys.push(stack[i].key);
            }
            return keys;
          },
          top: function() {
            return stack[stack.length - 1];
          },
          remove: function(key) {
            var idx = -1;
            for (var i = 0; i < stack.length; i++) {
              if (key === stack[i].key) {
                idx = i;
                break;
              }
            }
            return stack.splice(idx, 1)[0];
          },
          removeTop: function() {
            return stack.pop();
          },
          length: function() {
            return stack.length;
          }
        };
      }
    };
  });
angular.module('ui.bootstrap.modal', ['ui.bootstrap.multiMap', 'ui.bootstrap.stackedMap', 'ui.bootstrap.position'])
/**
 * Pluggable resolve mechanism for the modal resolve resolution
 * Supports UI Router's $resolve service
 */
  .provider('$uibResolve', function() {
    var resolve = this;
    this.resolver = null;

    this.setResolver = function(resolver) {
      this.resolver = resolver;
    };

    this.$get = ['$injector', '$q', function($injector, $q) {
      var resolver = resolve.resolver ? $injector.get(resolve.resolver) : null;
      return {
        resolve: function(invocables, locals, parent, self) {
          if (resolver) {
            return resolver.resolve(invocables, locals, parent, self);
          }

          var promises = [];

          angular.forEach(invocables, function(value) {
            if (angular.isFunction(value) || angular.isArray(value)) {
              promises.push($q.resolve($injector.invoke(value)));
            } else if (angular.isString(value)) {
              promises.push($q.resolve($injector.get(value)));
            } else {
              promises.push($q.resolve(value));
            }
          });

          return $q.all(promises).then(function(resolves) {
            var resolveObj = {};
            var resolveIter = 0;
            angular.forEach(invocables, function(value, key) {
              resolveObj[key] = resolves[resolveIter++];
            });

            return resolveObj;
          });
        }
      };
    }];
  })

/**
 * A helper directive for the $modal service. It creates a backdrop element.
 */
  .directive('uibModalBackdrop', ['$animate', '$injector', '$uibModalStack',
  function($animate, $injector, $modalStack) {
    return {
      restrict: 'A',
      compile: function(tElement, tAttrs) {
        tElement.addClass(tAttrs.backdropClass);
        return linkFn;
      }
    };

    function linkFn(scope, element, attrs) {
      if (attrs.modalInClass) {
        $animate.addClass(element, attrs.modalInClass);

        scope.$on($modalStack.NOW_CLOSING_EVENT, function(e, setIsAsync) {
          var done = setIsAsync();
          if (scope.modalOptions.animation) {
            $animate.removeClass(element, attrs.modalInClass).then(done);
          } else {
            done();
          }
        });
      }
    }
  }])

  .directive('uibModalWindow', ['$uibModalStack', '$q', '$animateCss', '$document',
  function($modalStack, $q, $animateCss, $document) {
    return {
      scope: {
        index: '@'
      },
      restrict: 'A',
      transclude: true,
      templateUrl: function(tElement, tAttrs) {
        return tAttrs.templateUrl || 'uib/template/modal/window.html';
      },
      link: function(scope, element, attrs) {
        element.addClass(attrs.windowTopClass || '');
        scope.size = attrs.size;

        scope.close = function(evt) {
          var modal = $modalStack.getTop();
          if (modal && modal.value.backdrop &&
            modal.value.backdrop !== 'static' &&
            evt.target === evt.currentTarget) {
            evt.preventDefault();
            evt.stopPropagation();
            $modalStack.dismiss(modal.key, 'backdrop click');
          }
        };

        // moved from template to fix issue #2280
        element.on('click', scope.close);

        // This property is only added to the scope for the purpose of detecting when this directive is rendered.
        // We can detect that by using this property in the template associated with this directive and then use
        // {@link Attribute#$observe} on it. For more details please see {@link TableColumnResize}.
        scope.$isRendered = true;

        // Deferred object that will be resolved when this modal is rendered.
        var modalRenderDeferObj = $q.defer();
        // Resolve render promise post-digest
        scope.$$postDigest(function() {
          modalRenderDeferObj.resolve();
        });

        modalRenderDeferObj.promise.then(function() {
          var animationPromise = null;

          if (attrs.modalInClass) {
            animationPromise = $animateCss(element, {
              addClass: attrs.modalInClass
            }).start();

            scope.$on($modalStack.NOW_CLOSING_EVENT, function(e, setIsAsync) {
              var done = setIsAsync();
              $animateCss(element, {
                removeClass: attrs.modalInClass
              }).start().then(done);
            });
          }


          $q.when(animationPromise).then(function() {
            // Notify {@link $modalStack} that modal is rendered.
            var modal = $modalStack.getTop();
            if (modal) {
              $modalStack.modalRendered(modal.key);
            }

            /**
             * If something within the freshly-opened modal already has focus (perhaps via a
             * directive that causes focus) then there's no need to try to focus anything.
             */
            if (!($document[0].activeElement && element[0].contains($document[0].activeElement))) {
              var inputWithAutofocus = element[0].querySelector('[autofocus]');
              /**
               * Auto-focusing of a freshly-opened modal element causes any child elements
               * with the autofocus attribute to lose focus. This is an issue on touch
               * based devices which will show and then hide the onscreen keyboard.
               * Attempts to refocus the autofocus element via JavaScript will not reopen
               * the onscreen keyboard. Fixed by updated the focusing logic to only autofocus
               * the modal element if the modal does not contain an autofocus element.
               */
              if (inputWithAutofocus) {
                inputWithAutofocus.focus();
              } else {
                element[0].focus();
              }
            }
          });
        });
      }
    };
  }])

  .directive('uibModalAnimationClass', function() {
    return {
      compile: function(tElement, tAttrs) {
        if (tAttrs.modalAnimation) {
          tElement.addClass(tAttrs.uibModalAnimationClass);
        }
      }
    };
  })

  .directive('uibModalTransclude', ['$animate', function($animate) {
    return {
      link: function(scope, element, attrs, controller, transclude) {
        transclude(scope.$parent, function(clone) {
          element.empty();
          $animate.enter(clone, element);
        });
      }
    };
  }])

  .factory('$uibModalStack', ['$animate', '$animateCss', '$document',
    '$compile', '$rootScope', '$q', '$$multiMap', '$$stackedMap', '$uibPosition',
    function($animate, $animateCss, $document, $compile, $rootScope, $q, $$multiMap, $$stackedMap, $uibPosition) {
      var OPENED_MODAL_CLASS = 'modal-open';

      var backdropDomEl, backdropScope;
      var openedWindows = $$stackedMap.createNew();
      var openedClasses = $$multiMap.createNew();
      var $modalStack = {
        NOW_CLOSING_EVENT: 'modal.stack.now-closing'
      };
      var topModalIndex = 0;
      var previousTopOpenedModal = null;
      var ARIA_HIDDEN_ATTRIBUTE_NAME = 'data-bootstrap-modal-aria-hidden-count';

      //Modal focus behavior
      var tabbableSelector = 'a[href], area[href], input:not([disabled]):not([tabindex=\'-1\']), ' +
        'button:not([disabled]):not([tabindex=\'-1\']),select:not([disabled]):not([tabindex=\'-1\']), textarea:not([disabled]):not([tabindex=\'-1\']), ' +
        'iframe, object, embed, *[tabindex]:not([tabindex=\'-1\']), *[contenteditable=true]';
      var scrollbarPadding;
      var SNAKE_CASE_REGEXP = /[A-Z]/g;

      // TODO: extract into common dependency with tooltip
      function snake_case(name) {
        var separator = '-';
        return name.replace(SNAKE_CASE_REGEXP, function(letter, pos) {
          return (pos ? separator : '') + letter.toLowerCase();
        });
      }

      function isVisible(element) {
        return !!(element.offsetWidth ||
          element.offsetHeight ||
          element.getClientRects().length);
      }

      function backdropIndex() {
        var topBackdropIndex = -1;
        var opened = openedWindows.keys();
        for (var i = 0; i < opened.length; i++) {
          if (openedWindows.get(opened[i]).value.backdrop) {
            topBackdropIndex = i;
          }
        }

        // If any backdrop exist, ensure that it's index is always
        // right below the top modal
        if (topBackdropIndex > -1 && topBackdropIndex < topModalIndex) {
          topBackdropIndex = topModalIndex;
        }
        return topBackdropIndex;
      }

      $rootScope.$watch(backdropIndex, function(newBackdropIndex) {
        if (backdropScope) {
          backdropScope.index = newBackdropIndex;
        }
      });

      function removeModalWindow(modalInstance, elementToReceiveFocus) {
        var modalWindow = openedWindows.get(modalInstance).value;
        var appendToElement = modalWindow.appendTo;

        //clean up the stack
        openedWindows.remove(modalInstance);
        previousTopOpenedModal = openedWindows.top();
        if (previousTopOpenedModal) {
          topModalIndex = parseInt(previousTopOpenedModal.value.modalDomEl.attr('index'), 10);
        }

        removeAfterAnimate(modalWindow.modalDomEl, modalWindow.modalScope, function() {
          var modalBodyClass = modalWindow.openedClass || OPENED_MODAL_CLASS;
          openedClasses.remove(modalBodyClass, modalInstance);
          var areAnyOpen = openedClasses.hasKey(modalBodyClass);
          appendToElement.toggleClass(modalBodyClass, areAnyOpen);
          if (!areAnyOpen && scrollbarPadding && scrollbarPadding.heightOverflow && scrollbarPadding.scrollbarWidth) {
            if (scrollbarPadding.originalRight) {
              appendToElement.css({paddingRight: scrollbarPadding.originalRight + 'px'});
            } else {
              appendToElement.css({paddingRight: ''});
            }
            scrollbarPadding = null;
          }
          toggleTopWindowClass(true);
        }, modalWindow.closedDeferred);
        checkRemoveBackdrop();

        //move focus to specified element if available, or else to body
        if (elementToReceiveFocus && elementToReceiveFocus.focus) {
          elementToReceiveFocus.focus();
        } else if (appendToElement.focus) {
          appendToElement.focus();
        }
      }

      // Add or remove "windowTopClass" from the top window in the stack
      function toggleTopWindowClass(toggleSwitch) {
        var modalWindow;

        if (openedWindows.length() > 0) {
          modalWindow = openedWindows.top().value;
          modalWindow.modalDomEl.toggleClass(modalWindow.windowTopClass || '', toggleSwitch);
        }
      }

      function checkRemoveBackdrop() {
        //remove backdrop if no longer needed
        if (backdropDomEl && backdropIndex() === -1) {
          var backdropScopeRef = backdropScope;
          removeAfterAnimate(backdropDomEl, backdropScope, function() {
            backdropScopeRef = null;
          });
          backdropDomEl = undefined;
          backdropScope = undefined;
        }
      }

      function removeAfterAnimate(domEl, scope, done, closedDeferred) {
        var asyncDeferred;
        var asyncPromise = null;
        var setIsAsync = function() {
          if (!asyncDeferred) {
            asyncDeferred = $q.defer();
            asyncPromise = asyncDeferred.promise;
          }

          return function asyncDone() {
            asyncDeferred.resolve();
          };
        };
        scope.$broadcast($modalStack.NOW_CLOSING_EVENT, setIsAsync);

        // Note that it's intentional that asyncPromise might be null.
        // That's when setIsAsync has not been called during the
        // NOW_CLOSING_EVENT broadcast.
        return $q.when(asyncPromise).then(afterAnimating);

        function afterAnimating() {
          if (afterAnimating.done) {
            return;
          }
          afterAnimating.done = true;

          $animate.leave(domEl).then(function() {
            if (done) {
              done();
            }

            domEl.remove();
            if (closedDeferred) {
              closedDeferred.resolve();
            }
          });

          scope.$destroy();
        }
      }

      $document.on('keydown', keydownListener);

      $rootScope.$on('$destroy', function() {
        $document.off('keydown', keydownListener);
      });

      function keydownListener(evt) {
        if (evt.isDefaultPrevented()) {
          return evt;
        }

        var modal = openedWindows.top();
        if (modal) {
          switch (evt.which) {
            case 27: {
              if (modal.value.keyboard) {
                evt.preventDefault();
                $rootScope.$apply(function() {
                  $modalStack.dismiss(modal.key, 'escape key press');
                });
              }
              break;
            }
            case 9: {
              var list = $modalStack.loadFocusElementList(modal);
              var focusChanged = false;
              if (evt.shiftKey) {
                if ($modalStack.isFocusInFirstItem(evt, list) || $modalStack.isModalFocused(evt, modal)) {
                  focusChanged = $modalStack.focusLastFocusableElement(list);
                }
              } else {
                if ($modalStack.isFocusInLastItem(evt, list)) {
                  focusChanged = $modalStack.focusFirstFocusableElement(list);
                }
              }

              if (focusChanged) {
                evt.preventDefault();
                evt.stopPropagation();
              }

              break;
            }
          }
        }
      }

      $modalStack.open = function(modalInstance, modal) {
        var modalOpener = $document[0].activeElement,
          modalBodyClass = modal.openedClass || OPENED_MODAL_CLASS;

        toggleTopWindowClass(false);

        // Store the current top first, to determine what index we ought to use
        // for the current top modal
        previousTopOpenedModal = openedWindows.top();

        openedWindows.add(modalInstance, {
          deferred: modal.deferred,
          renderDeferred: modal.renderDeferred,
          closedDeferred: modal.closedDeferred,
          modalScope: modal.scope,
          backdrop: modal.backdrop,
          keyboard: modal.keyboard,
          openedClass: modal.openedClass,
          windowTopClass: modal.windowTopClass,
          animation: modal.animation,
          appendTo: modal.appendTo
        });

        openedClasses.put(modalBodyClass, modalInstance);

        var appendToElement = modal.appendTo,
            currBackdropIndex = backdropIndex();

        if (!appendToElement.length) {
          throw new Error('appendTo element not found. Make sure that the element passed is in DOM.');
        }

        if (currBackdropIndex >= 0 && !backdropDomEl) {
          backdropScope = $rootScope.$new(true);
          backdropScope.modalOptions = modal;
          backdropScope.index = currBackdropIndex;
          backdropDomEl = angular.element('<div uib-modal-backdrop="modal-backdrop"></div>');
          backdropDomEl.attr({
            'class': 'modal-backdrop',
            'ng-style': '{\'z-index\': 1040 + (index && 1 || 0) + index*10}',
            'uib-modal-animation-class': 'fade',
            'modal-in-class': 'in'
          });
          if (modal.backdropClass) {
            backdropDomEl.addClass(modal.backdropClass);
          }

          if (modal.animation) {
            backdropDomEl.attr('modal-animation', 'true');
          }
          $compile(backdropDomEl)(backdropScope);
          $animate.enter(backdropDomEl, appendToElement);
          if ($uibPosition.isScrollable(appendToElement)) {
            scrollbarPadding = $uibPosition.scrollbarPadding(appendToElement);
            if (scrollbarPadding.heightOverflow && scrollbarPadding.scrollbarWidth) {
              appendToElement.css({paddingRight: scrollbarPadding.right + 'px'});
            }
          }
        }

        var content;
        if (modal.component) {
          content = document.createElement(snake_case(modal.component.name));
          content = angular.element(content);
          content.attr({
            resolve: '$resolve',
            'modal-instance': '$uibModalInstance',
            close: '$close($value)',
            dismiss: '$dismiss($value)'
          });
        } else {
          content = modal.content;
        }

        // Set the top modal index based on the index of the previous top modal
        topModalIndex = previousTopOpenedModal ? parseInt(previousTopOpenedModal.value.modalDomEl.attr('index'), 10) + 1 : 0;
        var angularDomEl = angular.element('<div uib-modal-window="modal-window"></div>');
        angularDomEl.attr({
          'class': 'modal',
          'template-url': modal.windowTemplateUrl,
          'window-top-class': modal.windowTopClass,
          'role': 'dialog',
          'aria-labelledby': modal.ariaLabelledBy,
          'aria-describedby': modal.ariaDescribedBy,
          'size': modal.size,
          'index': topModalIndex,
          'animate': 'animate',
          'ng-style': '{\'z-index\': 1050 + $$topModalIndex*10, display: \'block\'}',
          'tabindex': -1,
          'uib-modal-animation-class': 'fade',
          'modal-in-class': 'in'
        }).append(content);
        if (modal.windowClass) {
          angularDomEl.addClass(modal.windowClass);
        }

        if (modal.animation) {
          angularDomEl.attr('modal-animation', 'true');
        }

        appendToElement.addClass(modalBodyClass);
        if (modal.scope) {
          // we need to explicitly add the modal index to the modal scope
          // because it is needed by ngStyle to compute the zIndex property.
          modal.scope.$$topModalIndex = topModalIndex;
        }
        $animate.enter($compile(angularDomEl)(modal.scope), appendToElement);

        openedWindows.top().value.modalDomEl = angularDomEl;
        openedWindows.top().value.modalOpener = modalOpener;

        applyAriaHidden(angularDomEl);

        function applyAriaHidden(el) {
          if (!el || el[0].tagName === 'BODY') {
            return;
          }

          getSiblings(el).forEach(function(sibling) {
            var elemIsAlreadyHidden = sibling.getAttribute('aria-hidden') === 'true',
              ariaHiddenCount = parseInt(sibling.getAttribute(ARIA_HIDDEN_ATTRIBUTE_NAME), 10);

            if (!ariaHiddenCount) {
              ariaHiddenCount = elemIsAlreadyHidden ? 1 : 0;
            }

            sibling.setAttribute(ARIA_HIDDEN_ATTRIBUTE_NAME, ariaHiddenCount + 1);
            sibling.setAttribute('aria-hidden', 'true');
          });

          return applyAriaHidden(el.parent());

          function getSiblings(el) {
            var children = el.parent() ? el.parent().children() : [];

            return Array.prototype.filter.call(children, function(child) {
              return child !== el[0];
            });
          }
        }
      };

      function broadcastClosing(modalWindow, resultOrReason, closing) {
        return !modalWindow.value.modalScope.$broadcast('modal.closing', resultOrReason, closing).defaultPrevented;
      }

      function unhideBackgroundElements() {
        Array.prototype.forEach.call(
          document.querySelectorAll('[' + ARIA_HIDDEN_ATTRIBUTE_NAME + ']'),
          function(hiddenEl) {
            var ariaHiddenCount = parseInt(hiddenEl.getAttribute(ARIA_HIDDEN_ATTRIBUTE_NAME), 10),
              newHiddenCount = ariaHiddenCount - 1;
            hiddenEl.setAttribute(ARIA_HIDDEN_ATTRIBUTE_NAME, newHiddenCount);

            if (!newHiddenCount) {
              hiddenEl.removeAttribute(ARIA_HIDDEN_ATTRIBUTE_NAME);
              hiddenEl.removeAttribute('aria-hidden');
            }
          }
        );
      }

      $modalStack.close = function(modalInstance, result) {
        var modalWindow = openedWindows.get(modalInstance);
        unhideBackgroundElements();
        if (modalWindow && broadcastClosing(modalWindow, result, true)) {
          modalWindow.value.modalScope.$$uibDestructionScheduled = true;
          modalWindow.value.deferred.resolve(result);
          removeModalWindow(modalInstance, modalWindow.value.modalOpener);
          return true;
        }

        return !modalWindow;
      };

      $modalStack.dismiss = function(modalInstance, reason) {
        var modalWindow = openedWindows.get(modalInstance);
        unhideBackgroundElements();
        if (modalWindow && broadcastClosing(modalWindow, reason, false)) {
          modalWindow.value.modalScope.$$uibDestructionScheduled = true;
          modalWindow.value.deferred.reject(reason);
          removeModalWindow(modalInstance, modalWindow.value.modalOpener);
          return true;
        }
        return !modalWindow;
      };

      $modalStack.dismissAll = function(reason) {
        var topModal = this.getTop();
        while (topModal && this.dismiss(topModal.key, reason)) {
          topModal = this.getTop();
        }
      };

      $modalStack.getTop = function() {
        return openedWindows.top();
      };

      $modalStack.modalRendered = function(modalInstance) {
        var modalWindow = openedWindows.get(modalInstance);
        if (modalWindow) {
          modalWindow.value.renderDeferred.resolve();
        }
      };

      $modalStack.focusFirstFocusableElement = function(list) {
        if (list.length > 0) {
          list[0].focus();
          return true;
        }
        return false;
      };

      $modalStack.focusLastFocusableElement = function(list) {
        if (list.length > 0) {
          list[list.length - 1].focus();
          return true;
        }
        return false;
      };

      $modalStack.isModalFocused = function(evt, modalWindow) {
        if (evt && modalWindow) {
          var modalDomEl = modalWindow.value.modalDomEl;
          if (modalDomEl && modalDomEl.length) {
            return (evt.target || evt.srcElement) === modalDomEl[0];
          }
        }
        return false;
      };

      $modalStack.isFocusInFirstItem = function(evt, list) {
        if (list.length > 0) {
          return (evt.target || evt.srcElement) === list[0];
        }
        return false;
      };

      $modalStack.isFocusInLastItem = function(evt, list) {
        if (list.length > 0) {
          return (evt.target || evt.srcElement) === list[list.length - 1];
        }
        return false;
      };

      $modalStack.loadFocusElementList = function(modalWindow) {
        if (modalWindow) {
          var modalDomE1 = modalWindow.value.modalDomEl;
          if (modalDomE1 && modalDomE1.length) {
            var elements = modalDomE1[0].querySelectorAll(tabbableSelector);
            return elements ?
              Array.prototype.filter.call(elements, function(element) {
                return isVisible(element);
              }) : elements;
          }
        }
      };

      return $modalStack;
    }])

  .provider('$uibModal', function() {
    var $modalProvider = {
      options: {
        animation: true,
        backdrop: true, //can also be false or 'static'
        keyboard: true
      },
      $get: ['$rootScope', '$q', '$document', '$templateRequest', '$controller', '$uibResolve', '$uibModalStack',
        function ($rootScope, $q, $document, $templateRequest, $controller, $uibResolve, $modalStack) {
          var $modal = {};

          function getTemplatePromise(options) {
            return options.template ? $q.when(options.template) :
              $templateRequest(angular.isFunction(options.templateUrl) ?
                options.templateUrl() : options.templateUrl);
          }

          var promiseChain = null;
          $modal.getPromiseChain = function() {
            return promiseChain;
          };

          $modal.open = function(modalOptions) {
            var modalResultDeferred = $q.defer();
            var modalOpenedDeferred = $q.defer();
            var modalClosedDeferred = $q.defer();
            var modalRenderDeferred = $q.defer();

            //prepare an instance of a modal to be injected into controllers and returned to a caller
            var modalInstance = {
              result: modalResultDeferred.promise,
              opened: modalOpenedDeferred.promise,
              closed: modalClosedDeferred.promise,
              rendered: modalRenderDeferred.promise,
              close: function (result) {
                return $modalStack.close(modalInstance, result);
              },
              dismiss: function (reason) {
                return $modalStack.dismiss(modalInstance, reason);
              }
            };

            //merge and clean up options
            modalOptions = angular.extend({}, $modalProvider.options, modalOptions);
            modalOptions.resolve = modalOptions.resolve || {};
            modalOptions.appendTo = modalOptions.appendTo || $document.find('body').eq(0);

            //verify options
            if (!modalOptions.component && !modalOptions.template && !modalOptions.templateUrl) {
              throw new Error('One of component or template or templateUrl options is required.');
            }

            var templateAndResolvePromise;
            if (modalOptions.component) {
              templateAndResolvePromise = $q.when($uibResolve.resolve(modalOptions.resolve, {}, null, null));
            } else {
              templateAndResolvePromise =
                $q.all([getTemplatePromise(modalOptions), $uibResolve.resolve(modalOptions.resolve, {}, null, null)]);
            }

            function resolveWithTemplate() {
              return templateAndResolvePromise;
            }

            // Wait for the resolution of the existing promise chain.
            // Then switch to our own combined promise dependency (regardless of how the previous modal fared).
            // Then add to $modalStack and resolve opened.
            // Finally clean up the chain variable if no subsequent modal has overwritten it.
            var samePromise;
            samePromise = promiseChain = $q.all([promiseChain])
              .then(resolveWithTemplate, resolveWithTemplate)
              .then(function resolveSuccess(tplAndVars) {
                var providedScope = modalOptions.scope || $rootScope;

                var modalScope = providedScope.$new();
                modalScope.$close = modalInstance.close;
                modalScope.$dismiss = modalInstance.dismiss;

                modalScope.$on('$destroy', function() {
                  if (!modalScope.$$uibDestructionScheduled) {
                    modalScope.$dismiss('$uibUnscheduledDestruction');
                  }
                });

                var modal = {
                  scope: modalScope,
                  deferred: modalResultDeferred,
                  renderDeferred: modalRenderDeferred,
                  closedDeferred: modalClosedDeferred,
                  animation: modalOptions.animation,
                  backdrop: modalOptions.backdrop,
                  keyboard: modalOptions.keyboard,
                  backdropClass: modalOptions.backdropClass,
                  windowTopClass: modalOptions.windowTopClass,
                  windowClass: modalOptions.windowClass,
                  windowTemplateUrl: modalOptions.windowTemplateUrl,
                  ariaLabelledBy: modalOptions.ariaLabelledBy,
                  ariaDescribedBy: modalOptions.ariaDescribedBy,
                  size: modalOptions.size,
                  openedClass: modalOptions.openedClass,
                  appendTo: modalOptions.appendTo
                };

                var component = {};
                var ctrlInstance, ctrlInstantiate, ctrlLocals = {};

                if (modalOptions.component) {
                  constructLocals(component, false, true, false);
                  component.name = modalOptions.component;
                  modal.component = component;
                } else if (modalOptions.controller) {
                  constructLocals(ctrlLocals, true, false, true);

                  // the third param will make the controller instantiate later,private api
                  // @see https://github.com/angular/angular.js/blob/master/src/ng/controller.js#L126
                  ctrlInstantiate = $controller(modalOptions.controller, ctrlLocals, true, modalOptions.controllerAs);
                  if (modalOptions.controllerAs && modalOptions.bindToController) {
                    ctrlInstance = ctrlInstantiate.instance;
                    ctrlInstance.$close = modalScope.$close;
                    ctrlInstance.$dismiss = modalScope.$dismiss;
                    angular.extend(ctrlInstance, {
                      $resolve: ctrlLocals.$scope.$resolve
                    }, providedScope);
                  }

                  ctrlInstance = ctrlInstantiate();

                  if (angular.isFunction(ctrlInstance.$onInit)) {
                    ctrlInstance.$onInit();
                  }
                }

                if (!modalOptions.component) {
                  modal.content = tplAndVars[0];
                }

                $modalStack.open(modalInstance, modal);
                modalOpenedDeferred.resolve(true);

                function constructLocals(obj, template, instanceOnScope, injectable) {
                  obj.$scope = modalScope;
                  obj.$scope.$resolve = {};
                  if (instanceOnScope) {
                    obj.$scope.$uibModalInstance = modalInstance;
                  } else {
                    obj.$uibModalInstance = modalInstance;
                  }

                  var resolves = template ? tplAndVars[1] : tplAndVars;
                  angular.forEach(resolves, function(value, key) {
                    if (injectable) {
                      obj[key] = value;
                    }

                    obj.$scope.$resolve[key] = value;
                  });
                }
            }, function resolveError(reason) {
              modalOpenedDeferred.reject(reason);
              modalResultDeferred.reject(reason);
            })['finally'](function() {
              if (promiseChain === samePromise) {
                promiseChain = null;
              }
            });

            return modalInstance;
          };

          return $modal;
        }
      ]
    };

    return $modalProvider;
  });

angular.module('ui.bootstrap.paging', [])
/**
 * Helper internal service for generating common controller code between the
 * pager and pagination components
 */
.factory('uibPaging', ['$parse', function($parse) {
  return {
    create: function(ctrl, $scope, $attrs) {
      ctrl.setNumPages = $attrs.numPages ? $parse($attrs.numPages).assign : angular.noop;
      ctrl.ngModelCtrl = { $setViewValue: angular.noop }; // nullModelCtrl
      ctrl._watchers = [];

      ctrl.init = function(ngModelCtrl, config) {
        ctrl.ngModelCtrl = ngModelCtrl;
        ctrl.config = config;

        ngModelCtrl.$render = function() {
          ctrl.render();
        };

        if ($attrs.itemsPerPage) {
          ctrl._watchers.push($scope.$parent.$watch($attrs.itemsPerPage, function(value) {
            ctrl.itemsPerPage = parseInt(value, 10);
            $scope.totalPages = ctrl.calculateTotalPages();
            ctrl.updatePage();
          }));
        } else {
          ctrl.itemsPerPage = config.itemsPerPage;
        }

        $scope.$watch('totalItems', function(newTotal, oldTotal) {
          if (angular.isDefined(newTotal) || newTotal !== oldTotal) {
            $scope.totalPages = ctrl.calculateTotalPages();
            ctrl.updatePage();
          }
        });
      };

      ctrl.calculateTotalPages = function() {
        var totalPages = ctrl.itemsPerPage < 1 ? 1 : Math.ceil($scope.totalItems / ctrl.itemsPerPage);
        return Math.max(totalPages || 0, 1);
      };

      ctrl.render = function() {
        $scope.page = parseInt(ctrl.ngModelCtrl.$viewValue, 10) || 1;
      };

      $scope.selectPage = function(page, evt) {
        if (evt) {
          evt.preventDefault();
        }

        var clickAllowed = !$scope.ngDisabled || !evt;
        if (clickAllowed && $scope.page !== page && page > 0 && page <= $scope.totalPages) {
          if (evt && evt.target) {
            evt.target.blur();
          }
          ctrl.ngModelCtrl.$setViewValue(page);
          ctrl.ngModelCtrl.$render();
        }
      };

      $scope.getText = function(key) {
        return $scope[key + 'Text'] || ctrl.config[key + 'Text'];
      };

      $scope.noPrevious = function() {
        return $scope.page === 1;
      };

      $scope.noNext = function() {
        return $scope.page === $scope.totalPages;
      };

      ctrl.updatePage = function() {
        ctrl.setNumPages($scope.$parent, $scope.totalPages); // Readonly variable

        if ($scope.page > $scope.totalPages) {
          $scope.selectPage($scope.totalPages);
        } else {
          ctrl.ngModelCtrl.$render();
        }
      };

      $scope.$on('$destroy', function() {
        while (ctrl._watchers.length) {
          ctrl._watchers.shift()();
        }
      });
    }
  };
}]);

angular.module('ui.bootstrap.pager', ['ui.bootstrap.paging', 'ui.bootstrap.tabindex'])

.controller('UibPagerController', ['$scope', '$attrs', 'uibPaging', 'uibPagerConfig', function($scope, $attrs, uibPaging, uibPagerConfig) {
  $scope.align = angular.isDefined($attrs.align) ? $scope.$parent.$eval($attrs.align) : uibPagerConfig.align;

  uibPaging.create(this, $scope, $attrs);
}])

.constant('uibPagerConfig', {
  itemsPerPage: 10,
  previousText: '« Previous',
  nextText: 'Next »',
  align: true
})

.directive('uibPager', ['uibPagerConfig', function(uibPagerConfig) {
  return {
    scope: {
      totalItems: '=',
      previousText: '@',
      nextText: '@',
      ngDisabled: '='
    },
    require: ['uibPager', '?ngModel'],
    restrict: 'A',
    controller: 'UibPagerController',
    controllerAs: 'pager',
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/pager/pager.html';
    },
    link: function(scope, element, attrs, ctrls) {
      element.addClass('pager');
      var paginationCtrl = ctrls[0], ngModelCtrl = ctrls[1];

      if (!ngModelCtrl) {
        return; // do nothing if no ng-model
      }

      paginationCtrl.init(ngModelCtrl, uibPagerConfig);
    }
  };
}]);

angular.module('ui.bootstrap.pagination', ['ui.bootstrap.paging', 'ui.bootstrap.tabindex'])
.controller('UibPaginationController', ['$scope', '$attrs', '$parse', 'uibPaging', 'uibPaginationConfig', function($scope, $attrs, $parse, uibPaging, uibPaginationConfig) {
  var ctrl = this;
  // Setup configuration parameters
  var maxSize = angular.isDefined($attrs.maxSize) ? $scope.$parent.$eval($attrs.maxSize) : uibPaginationConfig.maxSize,
    rotate = angular.isDefined($attrs.rotate) ? $scope.$parent.$eval($attrs.rotate) : uibPaginationConfig.rotate,
    forceEllipses = angular.isDefined($attrs.forceEllipses) ? $scope.$parent.$eval($attrs.forceEllipses) : uibPaginationConfig.forceEllipses,
    boundaryLinkNumbers = angular.isDefined($attrs.boundaryLinkNumbers) ? $scope.$parent.$eval($attrs.boundaryLinkNumbers) : uibPaginationConfig.boundaryLinkNumbers,
    pageLabel = angular.isDefined($attrs.pageLabel) ? function(idx) { return $scope.$parent.$eval($attrs.pageLabel, {$page: idx}); } : angular.identity;
  $scope.boundaryLinks = angular.isDefined($attrs.boundaryLinks) ? $scope.$parent.$eval($attrs.boundaryLinks) : uibPaginationConfig.boundaryLinks;
  $scope.directionLinks = angular.isDefined($attrs.directionLinks) ? $scope.$parent.$eval($attrs.directionLinks) : uibPaginationConfig.directionLinks;

  uibPaging.create(this, $scope, $attrs);

  if ($attrs.maxSize) {
    ctrl._watchers.push($scope.$parent.$watch($parse($attrs.maxSize), function(value) {
      maxSize = parseInt(value, 10);
      ctrl.render();
    }));
  }

  // Create page object used in template
  function makePage(number, text, isActive) {
    return {
      number: number,
      text: text,
      active: isActive
    };
  }

  function getPages(currentPage, totalPages) {
    var pages = [];

    // Default page limits
    var startPage = 1, endPage = totalPages;
    var isMaxSized = angular.isDefined(maxSize) && maxSize < totalPages;

    // recompute if maxSize
    if (isMaxSized) {
      if (rotate) {
        // Current page is displayed in the middle of the visible ones
        startPage = Math.max(currentPage - Math.floor(maxSize / 2), 1);
        endPage = startPage + maxSize - 1;

        // Adjust if limit is exceeded
        if (endPage > totalPages) {
          endPage = totalPages;
          startPage = endPage - maxSize + 1;
        }
      } else {
        // Visible pages are paginated with maxSize
        startPage = (Math.ceil(currentPage / maxSize) - 1) * maxSize + 1;

        // Adjust last page if limit is exceeded
        endPage = Math.min(startPage + maxSize - 1, totalPages);
      }
    }

    // Add page number links
    for (var number = startPage; number <= endPage; number++) {
      var page = makePage(number, pageLabel(number), number === currentPage);
      pages.push(page);
    }

    // Add links to move between page sets
    if (isMaxSized && maxSize > 0 && (!rotate || forceEllipses || boundaryLinkNumbers)) {
      if (startPage > 1) {
        if (!boundaryLinkNumbers || startPage > 3) { //need ellipsis for all options unless range is too close to beginning
        var previousPageSet = makePage(startPage - 1, '...', false);
        pages.unshift(previousPageSet);
      }
        if (boundaryLinkNumbers) {
          if (startPage === 3) { //need to replace ellipsis when the buttons would be sequential
            var secondPageLink = makePage(2, '2', false);
            pages.unshift(secondPageLink);
          }
          //add the first page
          var firstPageLink = makePage(1, '1', false);
          pages.unshift(firstPageLink);
        }
      }

      if (endPage < totalPages) {
        if (!boundaryLinkNumbers || endPage < totalPages - 2) { //need ellipsis for all options unless range is too close to end
        var nextPageSet = makePage(endPage + 1, '...', false);
        pages.push(nextPageSet);
      }
        if (boundaryLinkNumbers) {
          if (endPage === totalPages - 2) { //need to replace ellipsis when the buttons would be sequential
            var secondToLastPageLink = makePage(totalPages - 1, totalPages - 1, false);
            pages.push(secondToLastPageLink);
          }
          //add the last page
          var lastPageLink = makePage(totalPages, totalPages, false);
          pages.push(lastPageLink);
        }
      }
    }
    return pages;
  }

  var originalRender = this.render;
  this.render = function() {
    originalRender();
    if ($scope.page > 0 && $scope.page <= $scope.totalPages) {
      $scope.pages = getPages($scope.page, $scope.totalPages);
    }
  };
}])

.constant('uibPaginationConfig', {
  itemsPerPage: 10,
  boundaryLinks: false,
  boundaryLinkNumbers: false,
  directionLinks: true,
  firstText: 'First',
  previousText: 'Previous',
  nextText: 'Next',
  lastText: 'Last',
  rotate: true,
  forceEllipses: false
})

.directive('uibPagination', ['$parse', 'uibPaginationConfig', function($parse, uibPaginationConfig) {
  return {
    scope: {
      totalItems: '=',
      firstText: '@',
      previousText: '@',
      nextText: '@',
      lastText: '@',
      ngDisabled:'='
    },
    require: ['uibPagination', '?ngModel'],
    restrict: 'A',
    controller: 'UibPaginationController',
    controllerAs: 'pagination',
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/pagination/pagination.html';
    },
    link: function(scope, element, attrs, ctrls) {
      element.addClass('pagination');
      var paginationCtrl = ctrls[0], ngModelCtrl = ctrls[1];

      if (!ngModelCtrl) {
         return; // do nothing if no ng-model
      }

      paginationCtrl.init(ngModelCtrl, uibPaginationConfig);
    }
  };
}]);

/**
 * The following features are still outstanding: animation as a
 * function, placement as a function, inside, support for more triggers than
 * just mouse enter/leave, html tooltips, and selector delegation.
 */
angular.module('ui.bootstrap.tooltip', ['ui.bootstrap.position', 'ui.bootstrap.stackedMap'])

/**
 * The $tooltip service creates tooltip- and popover-like directives as well as
 * houses global options for them.
 */
.provider('$uibTooltip', function() {
  // The default options tooltip and popover.
  var defaultOptions = {
    placement: 'top',
    placementClassPrefix: '',
    animation: true,
    popupDelay: 0,
    popupCloseDelay: 0,
    useContentExp: false
  };

  // Default hide triggers for each show trigger
  var triggerMap = {
    'mouseenter': 'mouseleave',
    'click': 'click',
    'outsideClick': 'outsideClick',
    'focus': 'blur',
    'none': ''
  };

  // The options specified to the provider globally.
  var globalOptions = {};

  /**
   * `options({})` allows global configuration of all tooltips in the
   * application.
   *
   *   var app = angular.module( 'App', ['ui.bootstrap.tooltip'], function( $tooltipProvider ) {
   *     // place tooltips left instead of top by default
   *     $tooltipProvider.options( { placement: 'left' } );
   *   });
   */
	this.options = function(value) {
		angular.extend(globalOptions, value);
	};

  /**
   * This allows you to extend the set of trigger mappings available. E.g.:
   *
   *   $tooltipProvider.setTriggers( { 'openTrigger': 'closeTrigger' } );
   */
  this.setTriggers = function setTriggers(triggers) {
    angular.extend(triggerMap, triggers);
  };

  /**
   * This is a helper function for translating camel-case to snake_case.
   */
  function snake_case(name) {
    var regexp = /[A-Z]/g;
    var separator = '-';
    return name.replace(regexp, function(letter, pos) {
      return (pos ? separator : '') + letter.toLowerCase();
    });
  }

  /**
   * Returns the actual instance of the $tooltip service.
   * TODO support multiple triggers
   */
  this.$get = ['$window', '$compile', '$timeout', '$document', '$uibPosition', '$interpolate', '$rootScope', '$parse', '$$stackedMap', function($window, $compile, $timeout, $document, $position, $interpolate, $rootScope, $parse, $$stackedMap) {
    var openedTooltips = $$stackedMap.createNew();
    $document.on('keyup', keypressListener);

    $rootScope.$on('$destroy', function() {
      $document.off('keyup', keypressListener);
    });

    function keypressListener(e) {
      if (e.which === 27) {
        var last = openedTooltips.top();
        if (last) {
          last.value.close();
          last = null;
        }
      }
    }

    return function $tooltip(ttType, prefix, defaultTriggerShow, options) {
      options = angular.extend({}, defaultOptions, globalOptions, options);

      /**
       * Returns an object of show and hide triggers.
       *
       * If a trigger is supplied,
       * it is used to show the tooltip; otherwise, it will use the `trigger`
       * option passed to the `$tooltipProvider.options` method; else it will
       * default to the trigger supplied to this directive factory.
       *
       * The hide trigger is based on the show trigger. If the `trigger` option
       * was passed to the `$tooltipProvider.options` method, it will use the
       * mapped trigger from `triggerMap` or the passed trigger if the map is
       * undefined; otherwise, it uses the `triggerMap` value of the show
       * trigger; else it will just use the show trigger.
       */
      function getTriggers(trigger) {
        var show = (trigger || options.trigger || defaultTriggerShow).split(' ');
        var hide = show.map(function(trigger) {
          return triggerMap[trigger] || trigger;
        });
        return {
          show: show,
          hide: hide
        };
      }

      var directiveName = snake_case(ttType);

      var startSym = $interpolate.startSymbol();
      var endSym = $interpolate.endSymbol();
      var template =
        '<div '+ directiveName + '-popup ' +
          'uib-title="' + startSym + 'title' + endSym + '" ' +
          (options.useContentExp ?
            'content-exp="contentExp()" ' :
            'content="' + startSym + 'content' + endSym + '" ') +
          'origin-scope="origScope" ' +
          'class="uib-position-measure ' + prefix + '" ' +
          'tooltip-animation-class="fade"' +
          'uib-tooltip-classes ' +
          'ng-class="{ in: isOpen }" ' +
          '>' +
        '</div>';

      return {
        compile: function(tElem, tAttrs) {
          var tooltipLinker = $compile(template);

          return function link(scope, element, attrs, tooltipCtrl) {
            var tooltip;
            var tooltipLinkedScope;
            var transitionTimeout;
            var showTimeout;
            var hideTimeout;
            var positionTimeout;
            var adjustmentTimeout;
            var appendToBody = angular.isDefined(options.appendToBody) ? options.appendToBody : false;
            var triggers = getTriggers(undefined);
            var hasEnableExp = angular.isDefined(attrs[prefix + 'Enable']);
            var ttScope = scope.$new(true);
            var repositionScheduled = false;
            var isOpenParse = angular.isDefined(attrs[prefix + 'IsOpen']) ? $parse(attrs[prefix + 'IsOpen']) : false;
            var contentParse = options.useContentExp ? $parse(attrs[ttType]) : false;
            var observers = [];
            var lastPlacement;

            var positionTooltip = function() {
              // check if tooltip exists and is not empty
              if (!tooltip || !tooltip.html()) { return; }

              if (!positionTimeout) {
                positionTimeout = $timeout(function() {
                  var ttPosition = $position.positionElements(element, tooltip, ttScope.placement, appendToBody);
                  var initialHeight = angular.isDefined(tooltip.offsetHeight) ? tooltip.offsetHeight : tooltip.prop('offsetHeight');
                  var elementPos = appendToBody ? $position.offset(element) : $position.position(element);
                  tooltip.css({ top: ttPosition.top + 'px', left: ttPosition.left + 'px' });
                  var placementClasses = ttPosition.placement.split('-');

                  if (!tooltip.hasClass(placementClasses[0])) {
                    tooltip.removeClass(lastPlacement.split('-')[0]);
                    tooltip.addClass(placementClasses[0]);
                  }

                  if (!tooltip.hasClass(options.placementClassPrefix + ttPosition.placement)) {
                    tooltip.removeClass(options.placementClassPrefix + lastPlacement);
                    tooltip.addClass(options.placementClassPrefix + ttPosition.placement);
                  }

                  adjustmentTimeout = $timeout(function() {
                    var currentHeight = angular.isDefined(tooltip.offsetHeight) ? tooltip.offsetHeight : tooltip.prop('offsetHeight');
                    var adjustment = $position.adjustTop(placementClasses, elementPos, initialHeight, currentHeight);
                    if (adjustment) {
                      tooltip.css(adjustment);
                    }
                    adjustmentTimeout = null;
                  }, 0, false);

                  // first time through tt element will have the
                  // uib-position-measure class or if the placement
                  // has changed we need to position the arrow.
                  if (tooltip.hasClass('uib-position-measure')) {
                    $position.positionArrow(tooltip, ttPosition.placement);
                    tooltip.removeClass('uib-position-measure');
                  } else if (lastPlacement !== ttPosition.placement) {
                    $position.positionArrow(tooltip, ttPosition.placement);
                  }
                  lastPlacement = ttPosition.placement;

                  positionTimeout = null;
                }, 0, false);
              }
            };

            // Set up the correct scope to allow transclusion later
            ttScope.origScope = scope;

            // By default, the tooltip is not open.
            // TODO add ability to start tooltip opened
            ttScope.isOpen = false;

            function toggleTooltipBind() {
              if (!ttScope.isOpen) {
                showTooltipBind();
              } else {
                hideTooltipBind();
              }
            }

            // Show the tooltip with delay if specified, otherwise show it immediately
            function showTooltipBind() {
              if (hasEnableExp && !scope.$eval(attrs[prefix + 'Enable'])) {
                return;
              }

              cancelHide();
              prepareTooltip();

              if (ttScope.popupDelay) {
                // Do nothing if the tooltip was already scheduled to pop-up.
                // This happens if show is triggered multiple times before any hide is triggered.
                if (!showTimeout) {
                  showTimeout = $timeout(show, ttScope.popupDelay, false);
                }
              } else {
                show();
              }
            }

            function hideTooltipBind() {
              cancelShow();

              if (ttScope.popupCloseDelay) {
                if (!hideTimeout) {
                  hideTimeout = $timeout(hide, ttScope.popupCloseDelay, false);
                }
              } else {
                hide();
              }
            }

            // Show the tooltip popup element.
            function show() {
              cancelShow();
              cancelHide();

              // Don't show empty tooltips.
              if (!ttScope.content) {
                return angular.noop;
              }

              createTooltip();

              // And show the tooltip.
              ttScope.$evalAsync(function() {
                ttScope.isOpen = true;
                assignIsOpen(true);
                positionTooltip();
              });
            }

            function cancelShow() {
              if (showTimeout) {
                $timeout.cancel(showTimeout);
                showTimeout = null;
              }

              if (positionTimeout) {
                $timeout.cancel(positionTimeout);
                positionTimeout = null;
              }
            }

            // Hide the tooltip popup element.
            function hide() {
              if (!ttScope) {
                return;
              }

              // First things first: we don't show it anymore.
              ttScope.$evalAsync(function() {
                if (ttScope) {
                  ttScope.isOpen = false;
                  assignIsOpen(false);
                  // And now we remove it from the DOM. However, if we have animation, we
                  // need to wait for it to expire beforehand.
                  // FIXME: this is a placeholder for a port of the transitions library.
                  // The fade transition in TWBS is 150ms.
                  if (ttScope.animation) {
                    if (!transitionTimeout) {
                      transitionTimeout = $timeout(removeTooltip, 150, false);
                    }
                  } else {
                    removeTooltip();
                  }
                }
              });
            }

            function cancelHide() {
              if (hideTimeout) {
                $timeout.cancel(hideTimeout);
                hideTimeout = null;
              }

              if (transitionTimeout) {
                $timeout.cancel(transitionTimeout);
                transitionTimeout = null;
              }
            }

            function createTooltip() {
              // There can only be one tooltip element per directive shown at once.
              if (tooltip) {
                return;
              }

              tooltipLinkedScope = ttScope.$new();
              tooltip = tooltipLinker(tooltipLinkedScope, function(tooltip) {
                if (appendToBody) {
                  $document.find('body').append(tooltip);
                } else {
                  element.after(tooltip);
                }
              });

              openedTooltips.add(ttScope, {
                close: hide
              });

              prepObservers();
            }

            function removeTooltip() {
              cancelShow();
              cancelHide();
              unregisterObservers();

              if (tooltip) {
                tooltip.remove();
                
                tooltip = null;
                if (adjustmentTimeout) {
                  $timeout.cancel(adjustmentTimeout);
                }
              }

              openedTooltips.remove(ttScope);
              
              if (tooltipLinkedScope) {
                tooltipLinkedScope.$destroy();
                tooltipLinkedScope = null;
              }
            }

            /**
             * Set the initial scope values. Once
             * the tooltip is created, the observers
             * will be added to keep things in sync.
             */
            function prepareTooltip() {
              ttScope.title = attrs[prefix + 'Title'];
              if (contentParse) {
                ttScope.content = contentParse(scope);
              } else {
                ttScope.content = attrs[ttType];
              }

              ttScope.popupClass = attrs[prefix + 'Class'];
              ttScope.placement = angular.isDefined(attrs[prefix + 'Placement']) ? attrs[prefix + 'Placement'] : options.placement;
              var placement = $position.parsePlacement(ttScope.placement);
              lastPlacement = placement[1] ? placement[0] + '-' + placement[1] : placement[0];

              var delay = parseInt(attrs[prefix + 'PopupDelay'], 10);
              var closeDelay = parseInt(attrs[prefix + 'PopupCloseDelay'], 10);
              ttScope.popupDelay = !isNaN(delay) ? delay : options.popupDelay;
              ttScope.popupCloseDelay = !isNaN(closeDelay) ? closeDelay : options.popupCloseDelay;
            }

            function assignIsOpen(isOpen) {
              if (isOpenParse && angular.isFunction(isOpenParse.assign)) {
                isOpenParse.assign(scope, isOpen);
              }
            }

            ttScope.contentExp = function() {
              return ttScope.content;
            };

            /**
             * Observe the relevant attributes.
             */
            attrs.$observe('disabled', function(val) {
              if (val) {
                cancelShow();
              }

              if (val && ttScope.isOpen) {
                hide();
              }
            });

            if (isOpenParse) {
              scope.$watch(isOpenParse, function(val) {
                if (ttScope && !val === ttScope.isOpen) {
                  toggleTooltipBind();
                }
              });
            }

            function prepObservers() {
              observers.length = 0;

              if (contentParse) {
                observers.push(
                  scope.$watch(contentParse, function(val) {
                    ttScope.content = val;
                    if (!val && ttScope.isOpen) {
                      hide();
                    }
                  })
                );

                observers.push(
                  tooltipLinkedScope.$watch(function() {
                    if (!repositionScheduled) {
                      repositionScheduled = true;
                      tooltipLinkedScope.$$postDigest(function() {
                        repositionScheduled = false;
                        if (ttScope && ttScope.isOpen) {
                          positionTooltip();
                        }
                      });
                    }
                  })
                );
              } else {
                observers.push(
                  attrs.$observe(ttType, function(val) {
                    ttScope.content = val;
                    if (!val && ttScope.isOpen) {
                      hide();
                    } else {
                      positionTooltip();
                    }
                  })
                );
              }

              observers.push(
                attrs.$observe(prefix + 'Title', function(val) {
                  ttScope.title = val;
                  if (ttScope.isOpen) {
                    positionTooltip();
                  }
                })
              );

              observers.push(
                attrs.$observe(prefix + 'Placement', function(val) {
                  ttScope.placement = val ? val : options.placement;
                  if (ttScope.isOpen) {
                    positionTooltip();
                  }
                })
              );
            }

            function unregisterObservers() {
              if (observers.length) {
                angular.forEach(observers, function(observer) {
                  observer();
                });
                observers.length = 0;
              }
            }

            // hide tooltips/popovers for outsideClick trigger
            function bodyHideTooltipBind(e) {
              if (!ttScope || !ttScope.isOpen || !tooltip) {
                return;
              }
              // make sure the tooltip/popover link or tool tooltip/popover itself were not clicked
              if (!element[0].contains(e.target) && !tooltip[0].contains(e.target)) {
                hideTooltipBind();
              }
            }

            var unregisterTriggers = function() {
              triggers.show.forEach(function(trigger) {
                if (trigger === 'outsideClick') {
                  element.off('click', toggleTooltipBind);
                } else {
                  element.off(trigger, showTooltipBind);
                  element.off(trigger, toggleTooltipBind);
                }
              });
              triggers.hide.forEach(function(trigger) {
                if (trigger === 'outsideClick') {
                  $document.off('click', bodyHideTooltipBind);
                } else {
                  element.off(trigger, hideTooltipBind);
                }
              });
            };

            function prepTriggers() {
              var showTriggers = [], hideTriggers = [];
              var val = scope.$eval(attrs[prefix + 'Trigger']);
              unregisterTriggers();

              if (angular.isObject(val)) {
                Object.keys(val).forEach(function(key) {
                  showTriggers.push(key);
                  hideTriggers.push(val[key]);
                });
                triggers = {
                  show: showTriggers,
                  hide: hideTriggers
                };
              } else {
                triggers = getTriggers(val);
              }

              if (triggers.show !== 'none') {
                triggers.show.forEach(function(trigger, idx) {
                  if (trigger === 'outsideClick') {
                    element.on('click', toggleTooltipBind);
                    $document.on('click', bodyHideTooltipBind);
                  } else if (trigger === triggers.hide[idx]) {
                    element.on(trigger, toggleTooltipBind);
                  } else if (trigger) {
                    element.on(trigger, showTooltipBind);
                    element.on(triggers.hide[idx], hideTooltipBind);
                  }

                  element.on('keypress', function(e) {
                    if (e.which === 27) {
                      hideTooltipBind();
                    }
                  });
                });
              }
            }

            prepTriggers();

            var animation = scope.$eval(attrs[prefix + 'Animation']);
            ttScope.animation = angular.isDefined(animation) ? !!animation : options.animation;

            var appendToBodyVal;
            var appendKey = prefix + 'AppendToBody';
            if (appendKey in attrs && attrs[appendKey] === undefined) {
              appendToBodyVal = true;
            } else {
              appendToBodyVal = scope.$eval(attrs[appendKey]);
            }

            appendToBody = angular.isDefined(appendToBodyVal) ? appendToBodyVal : appendToBody;

            // Make sure tooltip is destroyed and removed.
            scope.$on('$destroy', function onDestroyTooltip() {
              unregisterTriggers();
              removeTooltip();
              ttScope = null;
            });
          };
        }
      };
    };
  }];
})

// This is mostly ngInclude code but with a custom scope
.directive('uibTooltipTemplateTransclude', [
         '$animate', '$sce', '$compile', '$templateRequest',
function ($animate, $sce, $compile, $templateRequest) {
  return {
    link: function(scope, elem, attrs) {
      var origScope = scope.$eval(attrs.tooltipTemplateTranscludeScope);

      var changeCounter = 0,
        currentScope,
        previousElement,
        currentElement;

      var cleanupLastIncludeContent = function() {
        if (previousElement) {
          previousElement.remove();
          previousElement = null;
        }

        if (currentScope) {
          currentScope.$destroy();
          currentScope = null;
        }

        if (currentElement) {
          $animate.leave(currentElement).then(function() {
            previousElement = null;
          });
          previousElement = currentElement;
          currentElement = null;
        }
      };

      scope.$watch($sce.parseAsResourceUrl(attrs.uibTooltipTemplateTransclude), function(src) {
        var thisChangeId = ++changeCounter;

        if (src) {
          //set the 2nd param to true to ignore the template request error so that the inner
          //contents and scope can be cleaned up.
          $templateRequest(src, true).then(function(response) {
            if (thisChangeId !== changeCounter) { return; }
            var newScope = origScope.$new();
            var template = response;

            var clone = $compile(template)(newScope, function(clone) {
              cleanupLastIncludeContent();
              $animate.enter(clone, elem);
            });

            currentScope = newScope;
            currentElement = clone;

            currentScope.$emit('$includeContentLoaded', src);
          }, function() {
            if (thisChangeId === changeCounter) {
              cleanupLastIncludeContent();
              scope.$emit('$includeContentError', src);
            }
          });
          scope.$emit('$includeContentRequested', src);
        } else {
          cleanupLastIncludeContent();
        }
      });

      scope.$on('$destroy', cleanupLastIncludeContent);
    }
  };
}])

/**
 * Note that it's intentional that these classes are *not* applied through $animate.
 * They must not be animated as they're expected to be present on the tooltip on
 * initialization.
 */
.directive('uibTooltipClasses', ['$uibPosition', function($uibPosition) {
  return {
    restrict: 'A',
    link: function(scope, element, attrs) {
      // need to set the primary position so the
      // arrow has space during position measure.
      // tooltip.positionTooltip()
      if (scope.placement) {
        // // There are no top-left etc... classes
        // // in TWBS, so we need the primary position.
        var position = $uibPosition.parsePlacement(scope.placement);
        element.addClass(position[0]);
      }

      if (scope.popupClass) {
        element.addClass(scope.popupClass);
      }

      if (scope.animation) {
        element.addClass(attrs.tooltipAnimationClass);
      }
    }
  };
}])

.directive('uibTooltipPopup', function() {
  return {
    restrict: 'A',
    scope: { content: '@' },
    templateUrl: 'uib/template/tooltip/tooltip-popup.html'
  };
})

.directive('uibTooltip', [ '$uibTooltip', function($uibTooltip) {
  return $uibTooltip('uibTooltip', 'tooltip', 'mouseenter');
}])

.directive('uibTooltipTemplatePopup', function() {
  return {
    restrict: 'A',
    scope: { contentExp: '&', originScope: '&' },
    templateUrl: 'uib/template/tooltip/tooltip-template-popup.html'
  };
})

.directive('uibTooltipTemplate', ['$uibTooltip', function($uibTooltip) {
  return $uibTooltip('uibTooltipTemplate', 'tooltip', 'mouseenter', {
    useContentExp: true
  });
}])

.directive('uibTooltipHtmlPopup', function() {
  return {
    restrict: 'A',
    scope: { contentExp: '&' },
    templateUrl: 'uib/template/tooltip/tooltip-html-popup.html'
  };
})

.directive('uibTooltipHtml', ['$uibTooltip', function($uibTooltip) {
  return $uibTooltip('uibTooltipHtml', 'tooltip', 'mouseenter', {
    useContentExp: true
  });
}]);

/**
 * The following features are still outstanding: popup delay, animation as a
 * function, placement as a function, inside, support for more triggers than
 * just mouse enter/leave, and selector delegatation.
 */
angular.module('ui.bootstrap.popover', ['ui.bootstrap.tooltip'])

.directive('uibPopoverTemplatePopup', function() {
  return {
    restrict: 'A',
    scope: { uibTitle: '@', contentExp: '&', originScope: '&' },
    templateUrl: 'uib/template/popover/popover-template.html'
  };
})

.directive('uibPopoverTemplate', ['$uibTooltip', function($uibTooltip) {
  return $uibTooltip('uibPopoverTemplate', 'popover', 'click', {
    useContentExp: true
  });
}])

.directive('uibPopoverHtmlPopup', function() {
  return {
    restrict: 'A',
    scope: { contentExp: '&', uibTitle: '@' },
    templateUrl: 'uib/template/popover/popover-html.html'
  };
})

.directive('uibPopoverHtml', ['$uibTooltip', function($uibTooltip) {
  return $uibTooltip('uibPopoverHtml', 'popover', 'click', {
    useContentExp: true
  });
}])

.directive('uibPopoverPopup', function() {
  return {
    restrict: 'A',
    scope: { uibTitle: '@', content: '@' },
    templateUrl: 'uib/template/popover/popover.html'
  };
})

.directive('uibPopover', ['$uibTooltip', function($uibTooltip) {
  return $uibTooltip('uibPopover', 'popover', 'click');
}]);

angular.module('ui.bootstrap.progressbar', [])

.constant('uibProgressConfig', {
  animate: true,
  max: 100
})

.controller('UibProgressController', ['$scope', '$attrs', 'uibProgressConfig', function($scope, $attrs, progressConfig) {
  var self = this,
      animate = angular.isDefined($attrs.animate) ? $scope.$parent.$eval($attrs.animate) : progressConfig.animate;

  this.bars = [];
  $scope.max = getMaxOrDefault();

  this.addBar = function(bar, element, attrs) {
    if (!animate) {
      element.css({'transition': 'none'});
    }

    this.bars.push(bar);

    bar.max = getMaxOrDefault();
    bar.title = attrs && angular.isDefined(attrs.title) ? attrs.title : 'progressbar';

    bar.$watch('value', function(value) {
      bar.recalculatePercentage();
    });

    bar.recalculatePercentage = function() {
      var totalPercentage = self.bars.reduce(function(total, bar) {
        bar.percent = +(100 * bar.value / bar.max).toFixed(2);
        return total + bar.percent;
      }, 0);

      if (totalPercentage > 100) {
        bar.percent -= totalPercentage - 100;
      }
    };

    bar.$on('$destroy', function() {
      element = null;
      self.removeBar(bar);
    });
  };

  this.removeBar = function(bar) {
    this.bars.splice(this.bars.indexOf(bar), 1);
    this.bars.forEach(function (bar) {
      bar.recalculatePercentage();
    });
  };

  //$attrs.$observe('maxParam', function(maxParam) {
  $scope.$watch('maxParam', function(maxParam) {
    self.bars.forEach(function(bar) {
      bar.max = getMaxOrDefault();
      bar.recalculatePercentage();
    });
  });

  function getMaxOrDefault () {
    return angular.isDefined($scope.maxParam) ? $scope.maxParam : progressConfig.max;
  }
}])

.directive('uibProgress', function() {
  return {
    replace: true,
    transclude: true,
    controller: 'UibProgressController',
    require: 'uibProgress',
    scope: {
      maxParam: '=?max'
    },
    templateUrl: 'uib/template/progressbar/progress.html'
  };
})

.directive('uibBar', function() {
  return {
    replace: true,
    transclude: true,
    require: '^uibProgress',
    scope: {
      value: '=',
      type: '@'
    },
    templateUrl: 'uib/template/progressbar/bar.html',
    link: function(scope, element, attrs, progressCtrl) {
      progressCtrl.addBar(scope, element, attrs);
    }
  };
})

.directive('uibProgressbar', function() {
  return {
    replace: true,
    transclude: true,
    controller: 'UibProgressController',
    scope: {
      value: '=',
      maxParam: '=?max',
      type: '@'
    },
    templateUrl: 'uib/template/progressbar/progressbar.html',
    link: function(scope, element, attrs, progressCtrl) {
      progressCtrl.addBar(scope, angular.element(element.children()[0]), {title: attrs.title});
    }
  };
});

angular.module('ui.bootstrap.rating', [])

.constant('uibRatingConfig', {
  max: 5,
  stateOn: null,
  stateOff: null,
  enableReset: true,
  titles: ['one', 'two', 'three', 'four', 'five']
})

.controller('UibRatingController', ['$scope', '$attrs', 'uibRatingConfig', function($scope, $attrs, ratingConfig) {
  var ngModelCtrl = { $setViewValue: angular.noop },
    self = this;

  this.init = function(ngModelCtrl_) {
    ngModelCtrl = ngModelCtrl_;
    ngModelCtrl.$render = this.render;

    ngModelCtrl.$formatters.push(function(value) {
      if (angular.isNumber(value) && value << 0 !== value) {
        value = Math.round(value);
      }

      return value;
    });

    this.stateOn = angular.isDefined($attrs.stateOn) ? $scope.$parent.$eval($attrs.stateOn) : ratingConfig.stateOn;
    this.stateOff = angular.isDefined($attrs.stateOff) ? $scope.$parent.$eval($attrs.stateOff) : ratingConfig.stateOff;
    this.enableReset = angular.isDefined($attrs.enableReset) ?
      $scope.$parent.$eval($attrs.enableReset) : ratingConfig.enableReset;
    var tmpTitles = angular.isDefined($attrs.titles) ? $scope.$parent.$eval($attrs.titles) : ratingConfig.titles;
    this.titles = angular.isArray(tmpTitles) && tmpTitles.length > 0 ?
      tmpTitles : ratingConfig.titles;

    var ratingStates = angular.isDefined($attrs.ratingStates) ?
      $scope.$parent.$eval($attrs.ratingStates) :
      new Array(angular.isDefined($attrs.max) ? $scope.$parent.$eval($attrs.max) : ratingConfig.max);
    $scope.range = this.buildTemplateObjects(ratingStates);
  };

  this.buildTemplateObjects = function(states) {
    for (var i = 0, n = states.length; i < n; i++) {
      states[i] = angular.extend({ index: i }, { stateOn: this.stateOn, stateOff: this.stateOff, title: this.getTitle(i) }, states[i]);
    }
    return states;
  };

  this.getTitle = function(index) {
    if (index >= this.titles.length) {
      return index + 1;
    }

    return this.titles[index];
  };

  $scope.rate = function(value) {
    if (!$scope.readonly && value >= 0 && value <= $scope.range.length) {
      var newViewValue = self.enableReset && ngModelCtrl.$viewValue === value ? 0 : value;
      ngModelCtrl.$setViewValue(newViewValue);
      ngModelCtrl.$render();
    }
  };

  $scope.enter = function(value) {
    if (!$scope.readonly) {
      $scope.value = value;
    }
    $scope.onHover({value: value});
  };

  $scope.reset = function() {
    $scope.value = ngModelCtrl.$viewValue;
    $scope.onLeave();
  };

  $scope.onKeydown = function(evt) {
    if (/(37|38|39|40)/.test(evt.which)) {
      evt.preventDefault();
      evt.stopPropagation();
      $scope.rate($scope.value + (evt.which === 38 || evt.which === 39 ? 1 : -1));
    }
  };

  this.render = function() {
    $scope.value = ngModelCtrl.$viewValue;
    $scope.title = self.getTitle($scope.value - 1);
  };
}])

.directive('uibRating', function() {
  return {
    require: ['uibRating', 'ngModel'],
    restrict: 'A',
    scope: {
      readonly: '=?readOnly',
      onHover: '&',
      onLeave: '&'
    },
    controller: 'UibRatingController',
    templateUrl: 'uib/template/rating/rating.html',
    link: function(scope, element, attrs, ctrls) {
      var ratingCtrl = ctrls[0], ngModelCtrl = ctrls[1];
      ratingCtrl.init(ngModelCtrl);
    }
  };
});

angular.module('ui.bootstrap.tabs', [])

.controller('UibTabsetController', ['$scope', function ($scope) {
  var ctrl = this,
    oldIndex;
  ctrl.tabs = [];

  ctrl.select = function(index, evt) {
    if (!destroyed) {
      var previousIndex = findTabIndex(oldIndex);
      var previousSelected = ctrl.tabs[previousIndex];
      if (previousSelected) {
        previousSelected.tab.onDeselect({
          $event: evt,
          $selectedIndex: index
        });
        if (evt && evt.isDefaultPrevented()) {
          return;
        }
        previousSelected.tab.active = false;
      }

      var selected = ctrl.tabs[index];
      if (selected) {
        selected.tab.onSelect({
          $event: evt
        });
        selected.tab.active = true;
        ctrl.active = selected.index;
        oldIndex = selected.index;
      } else if (!selected && angular.isDefined(oldIndex)) {
        ctrl.active = null;
        oldIndex = null;
      }
    }
  };

  ctrl.addTab = function addTab(tab) {
    ctrl.tabs.push({
      tab: tab,
      index: tab.index
    });
    ctrl.tabs.sort(function(t1, t2) {
      if (t1.index > t2.index) {
        return 1;
      }

      if (t1.index < t2.index) {
        return -1;
      }

      return 0;
    });

    if (tab.index === ctrl.active || !angular.isDefined(ctrl.active) && ctrl.tabs.length === 1) {
      var newActiveIndex = findTabIndex(tab.index);
      ctrl.select(newActiveIndex);
    }
  };

  ctrl.removeTab = function removeTab(tab) {
    var index;
    for (var i = 0; i < ctrl.tabs.length; i++) {
      if (ctrl.tabs[i].tab === tab) {
        index = i;
        break;
      }
    }

    if (ctrl.tabs[index].index === ctrl.active) {
      var newActiveTabIndex = index === ctrl.tabs.length - 1 ?
        index - 1 : index + 1 % ctrl.tabs.length;
      ctrl.select(newActiveTabIndex);
    }

    ctrl.tabs.splice(index, 1);
  };

  $scope.$watch('tabset.active', function(val) {
    if (angular.isDefined(val) && val !== oldIndex) {
      ctrl.select(findTabIndex(val));
    }
  });

  var destroyed;
  $scope.$on('$destroy', function() {
    destroyed = true;
  });

  function findTabIndex(index) {
    for (var i = 0; i < ctrl.tabs.length; i++) {
      if (ctrl.tabs[i].index === index) {
        return i;
      }
    }
  }
}])

.directive('uibTabset', function() {
  return {
    transclude: true,
    replace: true,
    scope: {},
    bindToController: {
      active: '=?',
      type: '@'
    },
    controller: 'UibTabsetController',
    controllerAs: 'tabset',
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/tabs/tabset.html';
    },
    link: function(scope, element, attrs) {
      scope.vertical = angular.isDefined(attrs.vertical) ?
        scope.$parent.$eval(attrs.vertical) : false;
      scope.justified = angular.isDefined(attrs.justified) ?
        scope.$parent.$eval(attrs.justified) : false;
    }
  };
})

.directive('uibTab', ['$parse', function($parse) {
  return {
    require: '^uibTabset',
    replace: true,
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || 'uib/template/tabs/tab.html';
    },
    transclude: true,
    scope: {
      heading: '@',
      index: '=?',
      classes: '@?',
      onSelect: '&select', //This callback is called in contentHeadingTransclude
                          //once it inserts the tab's content into the dom
      onDeselect: '&deselect'
    },
    controller: function() {
      //Empty controller so other directives can require being 'under' a tab
    },
    controllerAs: 'tab',
    link: function(scope, elm, attrs, tabsetCtrl, transclude) {
      scope.disabled = false;
      if (attrs.disable) {
        scope.$parent.$watch($parse(attrs.disable), function(value) {
          scope.disabled = !! value;
        });
      }

      if (angular.isUndefined(attrs.index)) {
        if (tabsetCtrl.tabs && tabsetCtrl.tabs.length) {
          scope.index = Math.max.apply(null, tabsetCtrl.tabs.map(function(t) { return t.index; })) + 1;
        } else {
          scope.index = 0;
        }
      }

      if (angular.isUndefined(attrs.classes)) {
        scope.classes = '';
      }

      scope.select = function(evt) {
        if (!scope.disabled) {
          var index;
          for (var i = 0; i < tabsetCtrl.tabs.length; i++) {
            if (tabsetCtrl.tabs[i].tab === scope) {
              index = i;
              break;
            }
          }

          tabsetCtrl.select(index, evt);
        }
      };

      tabsetCtrl.addTab(scope);
      scope.$on('$destroy', function() {
        tabsetCtrl.removeTab(scope);
      });

      //We need to transclude later, once the content container is ready.
      //when this link happens, we're inside a tab heading.
      scope.$transcludeFn = transclude;
    }
  };
}])

.directive('uibTabHeadingTransclude', function() {
  return {
    restrict: 'A',
    require: '^uibTab',
    link: function(scope, elm) {
      scope.$watch('headingElement', function updateHeadingElement(heading) {
        if (heading) {
          elm.html('');
          elm.append(heading);
        }
      });
    }
  };
})

.directive('uibTabContentTransclude', function() {
  return {
    restrict: 'A',
    require: '^uibTabset',
    link: function(scope, elm, attrs) {
      var tab = scope.$eval(attrs.uibTabContentTransclude).tab;

      //Now our tab is ready to be transcluded: both the tab heading area
      //and the tab content area are loaded.  Transclude 'em both.
      tab.$transcludeFn(tab.$parent, function(contents) {
        angular.forEach(contents, function(node) {
          if (isTabHeading(node)) {
            //Let tabHeadingTransclude know.
            tab.headingElement = node;
          } else {
            elm.append(node);
          }
        });
      });
    }
  };

  function isTabHeading(node) {
    return node.tagName && (
      node.hasAttribute('uib-tab-heading') ||
      node.hasAttribute('data-uib-tab-heading') ||
      node.hasAttribute('x-uib-tab-heading') ||
      node.tagName.toLowerCase() === 'uib-tab-heading' ||
      node.tagName.toLowerCase() === 'data-uib-tab-heading' ||
      node.tagName.toLowerCase() === 'x-uib-tab-heading' ||
      node.tagName.toLowerCase() === 'uib:tab-heading'
    );
  }
});

angular.module('ui.bootstrap.timepicker', [])

.constant('uibTimepickerConfig', {
  hourStep: 1,
  minuteStep: 1,
  secondStep: 1,
  showMeridian: true,
  showSeconds: false,
  meridians: null,
  readonlyInput: false,
  mousewheel: true,
  arrowkeys: true,
  showSpinners: true,
  templateUrl: 'uib/template/timepicker/timepicker.html'
})

.controller('UibTimepickerController', ['$scope', '$element', '$attrs', '$parse', '$log', '$locale', 'uibTimepickerConfig', function($scope, $element, $attrs, $parse, $log, $locale, timepickerConfig) {
  var hoursModelCtrl, minutesModelCtrl, secondsModelCtrl;
  var selected = new Date(),
    watchers = [],
    ngModelCtrl = { $setViewValue: angular.noop }, // nullModelCtrl
    meridians = angular.isDefined($attrs.meridians) ? $scope.$parent.$eval($attrs.meridians) : timepickerConfig.meridians || $locale.DATETIME_FORMATS.AMPMS,
    padHours = angular.isDefined($attrs.padHours) ? $scope.$parent.$eval($attrs.padHours) : true;

  $scope.tabindex = angular.isDefined($attrs.tabindex) ? $attrs.tabindex : 0;
  $element.removeAttr('tabindex');

  this.init = function(ngModelCtrl_, inputs) {
    ngModelCtrl = ngModelCtrl_;
    ngModelCtrl.$render = this.render;

    ngModelCtrl.$formatters.unshift(function(modelValue) {
      return modelValue ? new Date(modelValue) : null;
    });

    var hoursInputEl = inputs.eq(0),
        minutesInputEl = inputs.eq(1),
        secondsInputEl = inputs.eq(2);

    hoursModelCtrl = hoursInputEl.controller('ngModel');
    minutesModelCtrl = minutesInputEl.controller('ngModel');
    secondsModelCtrl = secondsInputEl.controller('ngModel');

    var mousewheel = angular.isDefined($attrs.mousewheel) ? $scope.$parent.$eval($attrs.mousewheel) : timepickerConfig.mousewheel;

    if (mousewheel) {
      this.setupMousewheelEvents(hoursInputEl, minutesInputEl, secondsInputEl);
    }

    var arrowkeys = angular.isDefined($attrs.arrowkeys) ? $scope.$parent.$eval($attrs.arrowkeys) : timepickerConfig.arrowkeys;
    if (arrowkeys) {
      this.setupArrowkeyEvents(hoursInputEl, minutesInputEl, secondsInputEl);
    }

    $scope.readonlyInput = angular.isDefined($attrs.readonlyInput) ? $scope.$parent.$eval($attrs.readonlyInput) : timepickerConfig.readonlyInput;
    this.setupInputEvents(hoursInputEl, minutesInputEl, secondsInputEl);
  };

  var hourStep = timepickerConfig.hourStep;
  if ($attrs.hourStep) {
    watchers.push($scope.$parent.$watch($parse($attrs.hourStep), function(value) {
      hourStep = +value;
    }));
  }

  var minuteStep = timepickerConfig.minuteStep;
  if ($attrs.minuteStep) {
    watchers.push($scope.$parent.$watch($parse($attrs.minuteStep), function(value) {
      minuteStep = +value;
    }));
  }

  var min;
  watchers.push($scope.$parent.$watch($parse($attrs.min), function(value) {
    var dt = new Date(value);
    min = isNaN(dt) ? undefined : dt;
  }));

  var max;
  watchers.push($scope.$parent.$watch($parse($attrs.max), function(value) {
    var dt = new Date(value);
    max = isNaN(dt) ? undefined : dt;
  }));

  var disabled = false;
  if ($attrs.ngDisabled) {
    watchers.push($scope.$parent.$watch($parse($attrs.ngDisabled), function(value) {
      disabled = value;
    }));
  }

  $scope.noIncrementHours = function() {
    var incrementedSelected = addMinutes(selected, hourStep * 60);
    return disabled || incrementedSelected > max ||
      incrementedSelected < selected && incrementedSelected < min;
  };

  $scope.noDecrementHours = function() {
    var decrementedSelected = addMinutes(selected, -hourStep * 60);
    return disabled || decrementedSelected < min ||
      decrementedSelected > selected && decrementedSelected > max;
  };

  $scope.noIncrementMinutes = function() {
    var incrementedSelected = addMinutes(selected, minuteStep);
    return disabled || incrementedSelected > max ||
      incrementedSelected < selected && incrementedSelected < min;
  };

  $scope.noDecrementMinutes = function() {
    var decrementedSelected = addMinutes(selected, -minuteStep);
    return disabled || decrementedSelected < min ||
      decrementedSelected > selected && decrementedSelected > max;
  };

  $scope.noIncrementSeconds = function() {
    var incrementedSelected = addSeconds(selected, secondStep);
    return disabled || incrementedSelected > max ||
      incrementedSelected < selected && incrementedSelected < min;
  };

  $scope.noDecrementSeconds = function() {
    var decrementedSelected = addSeconds(selected, -secondStep);
    return disabled || decrementedSelected < min ||
      decrementedSelected > selected && decrementedSelected > max;
  };

  $scope.noToggleMeridian = function() {
    if (selected.getHours() < 12) {
      return disabled || addMinutes(selected, 12 * 60) > max;
    }

    return disabled || addMinutes(selected, -12 * 60) < min;
  };

  var secondStep = timepickerConfig.secondStep;
  if ($attrs.secondStep) {
    watchers.push($scope.$parent.$watch($parse($attrs.secondStep), function(value) {
      secondStep = +value;
    }));
  }

  $scope.showSeconds = timepickerConfig.showSeconds;
  if ($attrs.showSeconds) {
    watchers.push($scope.$parent.$watch($parse($attrs.showSeconds), function(value) {
      $scope.showSeconds = !!value;
    }));
  }

  // 12H / 24H mode
  $scope.showMeridian = timepickerConfig.showMeridian;
  if ($attrs.showMeridian) {
    watchers.push($scope.$parent.$watch($parse($attrs.showMeridian), function(value) {
      $scope.showMeridian = !!value;

      if (ngModelCtrl.$error.time) {
        // Evaluate from template
        var hours = getHoursFromTemplate(), minutes = getMinutesFromTemplate();
        if (angular.isDefined(hours) && angular.isDefined(minutes)) {
          selected.setHours(hours);
          refresh();
        }
      } else {
        updateTemplate();
      }
    }));
  }

  // Get $scope.hours in 24H mode if valid
  function getHoursFromTemplate() {
    var hours = +$scope.hours;
    var valid = $scope.showMeridian ? hours > 0 && hours < 13 :
      hours >= 0 && hours < 24;
    if (!valid || $scope.hours === '') {
      return undefined;
    }

    if ($scope.showMeridian) {
      if (hours === 12) {
        hours = 0;
      }
      if ($scope.meridian === meridians[1]) {
        hours = hours + 12;
      }
    }
    return hours;
  }

  function getMinutesFromTemplate() {
    var minutes = +$scope.minutes;
    var valid = minutes >= 0 && minutes < 60;
    if (!valid || $scope.minutes === '') {
      return undefined;
    }
    return minutes;
  }

  function getSecondsFromTemplate() {
    var seconds = +$scope.seconds;
    return seconds >= 0 && seconds < 60 ? seconds : undefined;
  }

  function pad(value, noPad) {
    if (value === null) {
      return '';
    }

    return angular.isDefined(value) && value.toString().length < 2 && !noPad ?
      '0' + value : value.toString();
  }

  // Respond on mousewheel spin
  this.setupMousewheelEvents = function(hoursInputEl, minutesInputEl, secondsInputEl) {
    var isScrollingUp = function(e) {
      if (e.originalEvent) {
        e = e.originalEvent;
      }
      //pick correct delta variable depending on event
      var delta = e.wheelDelta ? e.wheelDelta : -e.deltaY;
      return e.detail || delta > 0;
    };

    hoursInputEl.on('mousewheel wheel', function(e) {
      if (!disabled) {
        $scope.$apply(isScrollingUp(e) ? $scope.incrementHours() : $scope.decrementHours());
      }
      e.preventDefault();
    });

    minutesInputEl.on('mousewheel wheel', function(e) {
      if (!disabled) {
        $scope.$apply(isScrollingUp(e) ? $scope.incrementMinutes() : $scope.decrementMinutes());
      }
      e.preventDefault();
    });

     secondsInputEl.on('mousewheel wheel', function(e) {
      if (!disabled) {
        $scope.$apply(isScrollingUp(e) ? $scope.incrementSeconds() : $scope.decrementSeconds());
      }
      e.preventDefault();
    });
  };

  // Respond on up/down arrowkeys
  this.setupArrowkeyEvents = function(hoursInputEl, minutesInputEl, secondsInputEl) {
    hoursInputEl.on('keydown', function(e) {
      if (!disabled) {
        if (e.which === 38) { // up
          e.preventDefault();
          $scope.incrementHours();
          $scope.$apply();
        } else if (e.which === 40) { // down
          e.preventDefault();
          $scope.decrementHours();
          $scope.$apply();
        }
      }
    });

    minutesInputEl.on('keydown', function(e) {
      if (!disabled) {
        if (e.which === 38) { // up
          e.preventDefault();
          $scope.incrementMinutes();
          $scope.$apply();
        } else if (e.which === 40) { // down
          e.preventDefault();
          $scope.decrementMinutes();
          $scope.$apply();
        }
      }
    });

    secondsInputEl.on('keydown', function(e) {
      if (!disabled) {
        if (e.which === 38) { // up
          e.preventDefault();
          $scope.incrementSeconds();
          $scope.$apply();
        } else if (e.which === 40) { // down
          e.preventDefault();
          $scope.decrementSeconds();
          $scope.$apply();
        }
      }
    });
  };

  this.setupInputEvents = function(hoursInputEl, minutesInputEl, secondsInputEl) {
    if ($scope.readonlyInput) {
      $scope.updateHours = angular.noop;
      $scope.updateMinutes = angular.noop;
      $scope.updateSeconds = angular.noop;
      return;
    }

    var invalidate = function(invalidHours, invalidMinutes, invalidSeconds) {
      ngModelCtrl.$setViewValue(null);
      ngModelCtrl.$setValidity('time', false);
      if (angular.isDefined(invalidHours)) {
        $scope.invalidHours = invalidHours;
        if (hoursModelCtrl) {
          hoursModelCtrl.$setValidity('hours', false);
        }
      }

      if (angular.isDefined(invalidMinutes)) {
        $scope.invalidMinutes = invalidMinutes;
        if (minutesModelCtrl) {
          minutesModelCtrl.$setValidity('minutes', false);
        }
      }

      if (angular.isDefined(invalidSeconds)) {
        $scope.invalidSeconds = invalidSeconds;
        if (secondsModelCtrl) {
          secondsModelCtrl.$setValidity('seconds', false);
        }
      }
    };

    $scope.updateHours = function() {
      var hours = getHoursFromTemplate(),
        minutes = getMinutesFromTemplate();

      ngModelCtrl.$setDirty();

      if (angular.isDefined(hours) && angular.isDefined(minutes)) {
        selected.setHours(hours);
        selected.setMinutes(minutes);
        if (selected < min || selected > max) {
          invalidate(true);
        } else {
          refresh('h');
        }
      } else {
        invalidate(true);
      }
    };

    hoursInputEl.on('blur', function(e) {
      ngModelCtrl.$setTouched();
      if (modelIsEmpty()) {
        makeValid();
      } else if ($scope.hours === null || $scope.hours === '') {
        invalidate(true);
      } else if (!$scope.invalidHours && $scope.hours < 10) {
        $scope.$apply(function() {
          $scope.hours = pad($scope.hours, !padHours);
        });
      }
    });

    $scope.updateMinutes = function() {
      var minutes = getMinutesFromTemplate(),
        hours = getHoursFromTemplate();

      ngModelCtrl.$setDirty();

      if (angular.isDefined(minutes) && angular.isDefined(hours)) {
        selected.setHours(hours);
        selected.setMinutes(minutes);
        if (selected < min || selected > max) {
          invalidate(undefined, true);
        } else {
          refresh('m');
        }
      } else {
        invalidate(undefined, true);
      }
    };

    minutesInputEl.on('blur', function(e) {
      ngModelCtrl.$setTouched();
      if (modelIsEmpty()) {
        makeValid();
      } else if ($scope.minutes === null) {
        invalidate(undefined, true);
      } else if (!$scope.invalidMinutes && $scope.minutes < 10) {
        $scope.$apply(function() {
          $scope.minutes = pad($scope.minutes);
        });
      }
    });

    $scope.updateSeconds = function() {
      var seconds = getSecondsFromTemplate();

      ngModelCtrl.$setDirty();

      if (angular.isDefined(seconds)) {
        selected.setSeconds(seconds);
        refresh('s');
      } else {
        invalidate(undefined, undefined, true);
      }
    };

    secondsInputEl.on('blur', function(e) {
      if (modelIsEmpty()) {
        makeValid();
      } else if (!$scope.invalidSeconds && $scope.seconds < 10) {
        $scope.$apply( function() {
          $scope.seconds = pad($scope.seconds);
        });
      }
    });

  };

  this.render = function() {
    var date = ngModelCtrl.$viewValue;

    if (isNaN(date)) {
      ngModelCtrl.$setValidity('time', false);
      $log.error('Timepicker directive: "ng-model" value must be a Date object, a number of milliseconds since 01.01.1970 or a string representing an RFC2822 or ISO 8601 date.');
    } else {
      if (date) {
        selected = date;
      }

      if (selected < min || selected > max) {
        ngModelCtrl.$setValidity('time', false);
        $scope.invalidHours = true;
        $scope.invalidMinutes = true;
      } else {
        makeValid();
      }
      updateTemplate();
    }
  };

  // Call internally when we know that model is valid.
  function refresh(keyboardChange) {
    makeValid();
    ngModelCtrl.$setViewValue(new Date(selected));
    updateTemplate(keyboardChange);
  }

  function makeValid() {
    if (hoursModelCtrl) {
      hoursModelCtrl.$setValidity('hours', true);
    }

    if (minutesModelCtrl) {
      minutesModelCtrl.$setValidity('minutes', true);
    }

    if (secondsModelCtrl) {
      secondsModelCtrl.$setValidity('seconds', true);
    }

    ngModelCtrl.$setValidity('time', true);
    $scope.invalidHours = false;
    $scope.invalidMinutes = false;
    $scope.invalidSeconds = false;
  }

  function updateTemplate(keyboardChange) {
    if (!ngModelCtrl.$modelValue) {
      $scope.hours = null;
      $scope.minutes = null;
      $scope.seconds = null;
      $scope.meridian = meridians[0];
    } else {
      var hours = selected.getHours(),
        minutes = selected.getMinutes(),
        seconds = selected.getSeconds();

      if ($scope.showMeridian) {
        hours = hours === 0 || hours === 12 ? 12 : hours % 12; // Convert 24 to 12 hour system
      }

      $scope.hours = keyboardChange === 'h' ? hours : pad(hours, !padHours);
      if (keyboardChange !== 'm') {
        $scope.minutes = pad(minutes);
      }
      $scope.meridian = selected.getHours() < 12 ? meridians[0] : meridians[1];

      if (keyboardChange !== 's') {
        $scope.seconds = pad(seconds);
      }
      $scope.meridian = selected.getHours() < 12 ? meridians[0] : meridians[1];
    }
  }

  function addSecondsToSelected(seconds) {
    selected = addSeconds(selected, seconds);
    refresh();
  }

  function addMinutes(selected, minutes) {
    return addSeconds(selected, minutes*60);
  }

  function addSeconds(date, seconds) {
    var dt = new Date(date.getTime() + seconds * 1000);
    var newDate = new Date(date);
    newDate.setHours(dt.getHours(), dt.getMinutes(), dt.getSeconds());
    return newDate;
  }

  function modelIsEmpty() {
    return ($scope.hours === null || $scope.hours === '') &&
      ($scope.minutes === null || $scope.minutes === '') &&
      (!$scope.showSeconds || $scope.showSeconds && ($scope.seconds === null || $scope.seconds === ''));
  }

  $scope.showSpinners = angular.isDefined($attrs.showSpinners) ?
    $scope.$parent.$eval($attrs.showSpinners) : timepickerConfig.showSpinners;

  $scope.incrementHours = function() {
    if (!$scope.noIncrementHours()) {
      addSecondsToSelected(hourStep * 60 * 60);
    }
  };

  $scope.decrementHours = function() {
    if (!$scope.noDecrementHours()) {
      addSecondsToSelected(-hourStep * 60 * 60);
    }
  };

  $scope.incrementMinutes = function() {
    if (!$scope.noIncrementMinutes()) {
      addSecondsToSelected(minuteStep * 60);
    }
  };

  $scope.decrementMinutes = function() {
    if (!$scope.noDecrementMinutes()) {
      addSecondsToSelected(-minuteStep * 60);
    }
  };

  $scope.incrementSeconds = function() {
    if (!$scope.noIncrementSeconds()) {
      addSecondsToSelected(secondStep);
    }
  };

  $scope.decrementSeconds = function() {
    if (!$scope.noDecrementSeconds()) {
      addSecondsToSelected(-secondStep);
    }
  };

  $scope.toggleMeridian = function() {
    var minutes = getMinutesFromTemplate(),
        hours = getHoursFromTemplate();

    if (!$scope.noToggleMeridian()) {
      if (angular.isDefined(minutes) && angular.isDefined(hours)) {
        addSecondsToSelected(12 * 60 * (selected.getHours() < 12 ? 60 : -60));
      } else {
        $scope.meridian = $scope.meridian === meridians[0] ? meridians[1] : meridians[0];
      }
    }
  };

  $scope.blur = function() {
    ngModelCtrl.$setTouched();
  };

  $scope.$on('$destroy', function() {
    while (watchers.length) {
      watchers.shift()();
    }
  });
}])

.directive('uibTimepicker', ['uibTimepickerConfig', function(uibTimepickerConfig) {
  return {
    require: ['uibTimepicker', '?^ngModel'],
    restrict: 'A',
    controller: 'UibTimepickerController',
    controllerAs: 'timepicker',
    scope: {},
    templateUrl: function(element, attrs) {
      return attrs.templateUrl || uibTimepickerConfig.templateUrl;
    },
    link: function(scope, element, attrs, ctrls) {
      var timepickerCtrl = ctrls[0], ngModelCtrl = ctrls[1];

      if (ngModelCtrl) {
        timepickerCtrl.init(ngModelCtrl, element.find('input'));
      }
    }
  };
}]);

angular.module('ui.bootstrap.typeahead', ['ui.bootstrap.debounce', 'ui.bootstrap.position'])

/**
 * A helper service that can parse typeahead's syntax (string provided by users)
 * Extracted to a separate service for ease of unit testing
 */
  .factory('uibTypeaheadParser', ['$parse', function($parse) {
    //                      000001111111100000000000002222222200000000000000003333333333333330000000000044444444000
    var TYPEAHEAD_REGEXP = /^\s*([\s\S]+?)(?:\s+as\s+([\s\S]+?))?\s+for\s+(?:([\$\w][\$\w\d]*))\s+in\s+([\s\S]+?)$/;
    return {
      parse: function(input) {
        var match = input.match(TYPEAHEAD_REGEXP);
        if (!match) {
          throw new Error(
            'Expected typeahead specification in form of "_modelValue_ (as _label_)? for _item_ in _collection_"' +
              ' but got "' + input + '".');
        }

        return {
          itemName: match[3],
          source: $parse(match[4]),
          viewMapper: $parse(match[2] || match[1]),
          modelMapper: $parse(match[1])
        };
      }
    };
  }])

  .controller('UibTypeaheadController', ['$scope', '$element', '$attrs', '$compile', '$parse', '$q', '$timeout', '$document', '$window', '$rootScope', '$$debounce', '$uibPosition', 'uibTypeaheadParser',
    function(originalScope, element, attrs, $compile, $parse, $q, $timeout, $document, $window, $rootScope, $$debounce, $position, typeaheadParser) {
    var HOT_KEYS = [9, 13, 27, 38, 40];
    var eventDebounceTime = 200;
    var modelCtrl, ngModelOptions;
    //SUPPORTED ATTRIBUTES (OPTIONS)

    //minimal no of characters that needs to be entered before typeahead kicks-in
    var minLength = originalScope.$eval(attrs.typeaheadMinLength);
    if (!minLength && minLength !== 0) {
      minLength = 1;
    }

    originalScope.$watch(attrs.typeaheadMinLength, function (newVal) {
        minLength = !newVal && newVal !== 0 ? 1 : newVal;
    });

    //minimal wait time after last character typed before typeahead kicks-in
    var waitTime = originalScope.$eval(attrs.typeaheadWaitMs) || 0;

    //should it restrict model values to the ones selected from the popup only?
    var isEditable = originalScope.$eval(attrs.typeaheadEditable) !== false;
    originalScope.$watch(attrs.typeaheadEditable, function (newVal) {
      isEditable = newVal !== false;
    });

    //binding to a variable that indicates if matches are being retrieved asynchronously
    var isLoadingSetter = $parse(attrs.typeaheadLoading).assign || angular.noop;

    //a function to determine if an event should cause selection
    var isSelectEvent = attrs.typeaheadShouldSelect ? $parse(attrs.typeaheadShouldSelect) : function(scope, vals) {
      var evt = vals.$event;
      return evt.which === 13 || evt.which === 9;
    };

    //a callback executed when a match is selected
    var onSelectCallback = $parse(attrs.typeaheadOnSelect);

    //should it select highlighted popup value when losing focus?
    var isSelectOnBlur = angular.isDefined(attrs.typeaheadSelectOnBlur) ? originalScope.$eval(attrs.typeaheadSelectOnBlur) : false;

    //binding to a variable that indicates if there were no results after the query is completed
    var isNoResultsSetter = $parse(attrs.typeaheadNoResults).assign || angular.noop;

    var inputFormatter = attrs.typeaheadInputFormatter ? $parse(attrs.typeaheadInputFormatter) : undefined;

    var appendToBody = attrs.typeaheadAppendToBody ? originalScope.$eval(attrs.typeaheadAppendToBody) : false;

    var appendTo = attrs.typeaheadAppendTo ?
      originalScope.$eval(attrs.typeaheadAppendTo) : null;

    var focusFirst = originalScope.$eval(attrs.typeaheadFocusFirst) !== false;

    //If input matches an item of the list exactly, select it automatically
    var selectOnExact = attrs.typeaheadSelectOnExact ? originalScope.$eval(attrs.typeaheadSelectOnExact) : false;

    //binding to a variable that indicates if dropdown is open
    var isOpenSetter = $parse(attrs.typeaheadIsOpen).assign || angular.noop;

    var showHint = originalScope.$eval(attrs.typeaheadShowHint) || false;

    //INTERNAL VARIABLES

    //model setter executed upon match selection
    var parsedModel = $parse(attrs.ngModel);
    var invokeModelSetter = $parse(attrs.ngModel + '($$$p)');
    var $setModelValue = function(scope, newValue) {
      if (angular.isFunction(parsedModel(originalScope)) &&
        ngModelOptions && ngModelOptions.$options && ngModelOptions.$options.getterSetter) {
        return invokeModelSetter(scope, {$$$p: newValue});
      }

      return parsedModel.assign(scope, newValue);
    };

    //expressions used by typeahead
    var parserResult = typeaheadParser.parse(attrs.uibTypeahead);

    var hasFocus;

    //Used to avoid bug in iOS webview where iOS keyboard does not fire
    //mousedown & mouseup events
    //Issue #3699
    var selected;

    //create a child scope for the typeahead directive so we are not polluting original scope
    //with typeahead-specific data (matches, query etc.)
    var scope = originalScope.$new();
    var offDestroy = originalScope.$on('$destroy', function() {
      scope.$destroy();
    });
    scope.$on('$destroy', offDestroy);

    // WAI-ARIA
    var popupId = 'typeahead-' + scope.$id + '-' + Math.floor(Math.random() * 10000);
    element.attr({
      'aria-autocomplete': 'list',
      'aria-expanded': false,
      'aria-owns': popupId
    });

    var inputsContainer, hintInputElem;
    //add read-only input to show hint
    if (showHint) {
      inputsContainer = angular.element('<div></div>');
      inputsContainer.css('position', 'relative');
      element.after(inputsContainer);
      hintInputElem = element.clone();
      hintInputElem.attr('placeholder', '');
      hintInputElem.attr('tabindex', '-1');
      hintInputElem.val('');
      hintInputElem.css({
        'position': 'absolute',
        'top': '0px',
        'left': '0px',
        'border-color': 'transparent',
        'box-shadow': 'none',
        'opacity': 1,
        'background': 'none 0% 0% / auto repeat scroll padding-box border-box rgb(255, 255, 255)',
        'color': '#999'
      });
      element.css({
        'position': 'relative',
        'vertical-align': 'top',
        'background-color': 'transparent'
      });

      if (hintInputElem.attr('id')) {
        hintInputElem.removeAttr('id'); // remove duplicate id if present.
      }
      inputsContainer.append(hintInputElem);
      hintInputElem.after(element);
    }

    //pop-up element used to display matches
    var popUpEl = angular.element('<div uib-typeahead-popup></div>');
    popUpEl.attr({
      id: popupId,
      matches: 'matches',
      active: 'activeIdx',
      select: 'select(activeIdx, evt)',
      'move-in-progress': 'moveInProgress',
      query: 'query',
      position: 'position',
      'assign-is-open': 'assignIsOpen(isOpen)',
      debounce: 'debounceUpdate'
    });
    //custom item template
    if (angular.isDefined(attrs.typeaheadTemplateUrl)) {
      popUpEl.attr('template-url', attrs.typeaheadTemplateUrl);
    }

    if (angular.isDefined(attrs.typeaheadPopupTemplateUrl)) {
      popUpEl.attr('popup-template-url', attrs.typeaheadPopupTemplateUrl);
    }

    var resetHint = function() {
      if (showHint) {
        hintInputElem.val('');
      }
    };

    var resetMatches = function() {
      scope.matches = [];
      scope.activeIdx = -1;
      element.attr('aria-expanded', false);
      resetHint();
    };

    var getMatchId = function(index) {
      return popupId + '-option-' + index;
    };

    // Indicate that the specified match is the active (pre-selected) item in the list owned by this typeahead.
    // This attribute is added or removed automatically when the `activeIdx` changes.
    scope.$watch('activeIdx', function(index) {
      if (index < 0) {
        element.removeAttr('aria-activedescendant');
      } else {
        element.attr('aria-activedescendant', getMatchId(index));
      }
    });

    var inputIsExactMatch = function(inputValue, index) {
      if (scope.matches.length > index && inputValue) {
        return inputValue.toUpperCase() === scope.matches[index].label.toUpperCase();
      }

      return false;
    };

    var getMatchesAsync = function(inputValue, evt) {
      var locals = {$viewValue: inputValue};
      isLoadingSetter(originalScope, true);
      isNoResultsSetter(originalScope, false);
      $q.when(parserResult.source(originalScope, locals)).then(function(matches) {
        //it might happen that several async queries were in progress if a user were typing fast
        //but we are interested only in responses that correspond to the current view value
        var onCurrentRequest = inputValue === modelCtrl.$viewValue;
        if (onCurrentRequest && hasFocus) {
          if (matches && matches.length > 0) {
            scope.activeIdx = focusFirst ? 0 : -1;
            isNoResultsSetter(originalScope, false);
            scope.matches.length = 0;

            //transform labels
            for (var i = 0; i < matches.length; i++) {
              locals[parserResult.itemName] = matches[i];
              scope.matches.push({
                id: getMatchId(i),
                label: parserResult.viewMapper(scope, locals),
                model: matches[i]
              });
            }

            scope.query = inputValue;
            //position pop-up with matches - we need to re-calculate its position each time we are opening a window
            //with matches as a pop-up might be absolute-positioned and position of an input might have changed on a page
            //due to other elements being rendered
            recalculatePosition();

            element.attr('aria-expanded', true);

            //Select the single remaining option if user input matches
            if (selectOnExact && scope.matches.length === 1 && inputIsExactMatch(inputValue, 0)) {
              if (angular.isNumber(scope.debounceUpdate) || angular.isObject(scope.debounceUpdate)) {
                $$debounce(function() {
                  scope.select(0, evt);
                }, angular.isNumber(scope.debounceUpdate) ? scope.debounceUpdate : scope.debounceUpdate['default']);
              } else {
                scope.select(0, evt);
              }
            }

            if (showHint) {
              var firstLabel = scope.matches[0].label;
              if (angular.isString(inputValue) &&
                inputValue.length > 0 &&
                firstLabel.slice(0, inputValue.length).toUpperCase() === inputValue.toUpperCase()) {
                hintInputElem.val(inputValue + firstLabel.slice(inputValue.length));
              } else {
                hintInputElem.val('');
              }
            }
          } else {
            resetMatches();
            isNoResultsSetter(originalScope, true);
          }
        }
        if (onCurrentRequest) {
          isLoadingSetter(originalScope, false);
        }
      }, function() {
        resetMatches();
        isLoadingSetter(originalScope, false);
        isNoResultsSetter(originalScope, true);
      });
    };

    // bind events only if appendToBody params exist - performance feature
    if (appendToBody) {
      angular.element($window).on('resize', fireRecalculating);
      $document.find('body').on('scroll', fireRecalculating);
    }

    // Declare the debounced function outside recalculating for
    // proper debouncing
    var debouncedRecalculate = $$debounce(function() {
      // if popup is visible
      if (scope.matches.length) {
        recalculatePosition();
      }

      scope.moveInProgress = false;
    }, eventDebounceTime);

    // Default progress type
    scope.moveInProgress = false;

    function fireRecalculating() {
      if (!scope.moveInProgress) {
        scope.moveInProgress = true;
        scope.$digest();
      }

      debouncedRecalculate();
    }

    // recalculate actual position and set new values to scope
    // after digest loop is popup in right position
    function recalculatePosition() {
      scope.position = appendToBody ? $position.offset(element) : $position.position(element);
      scope.position.top += element.prop('offsetHeight');
    }

    //we need to propagate user's query so we can higlight matches
    scope.query = undefined;

    //Declare the timeout promise var outside the function scope so that stacked calls can be cancelled later
    var timeoutPromise;

    var scheduleSearchWithTimeout = function(inputValue) {
      timeoutPromise = $timeout(function() {
        getMatchesAsync(inputValue);
      }, waitTime);
    };

    var cancelPreviousTimeout = function() {
      if (timeoutPromise) {
        $timeout.cancel(timeoutPromise);
      }
    };

    resetMatches();

    scope.assignIsOpen = function (isOpen) {
      isOpenSetter(originalScope, isOpen);
    };

    scope.select = function(activeIdx, evt) {
      //called from within the $digest() cycle
      var locals = {};
      var model, item;

      selected = true;
      locals[parserResult.itemName] = item = scope.matches[activeIdx].model;
      model = parserResult.modelMapper(originalScope, locals);
      $setModelValue(originalScope, model);
      modelCtrl.$setValidity('editable', true);
      modelCtrl.$setValidity('parse', true);

      onSelectCallback(originalScope, {
        $item: item,
        $model: model,
        $label: parserResult.viewMapper(originalScope, locals),
        $event: evt
      });

      resetMatches();

      //return focus to the input element if a match was selected via a mouse click event
      // use timeout to avoid $rootScope:inprog error
      if (scope.$eval(attrs.typeaheadFocusOnSelect) !== false) {
        $timeout(function() { element[0].focus(); }, 0, false);
      }
    };

    //bind keyboard events: arrows up(38) / down(40), enter(13) and tab(9), esc(27)
    element.on('keydown', function(evt) {
      //typeahead is open and an "interesting" key was pressed
      if (scope.matches.length === 0 || HOT_KEYS.indexOf(evt.which) === -1) {
        return;
      }

      var shouldSelect = isSelectEvent(originalScope, {$event: evt});

      /**
       * if there's nothing selected (i.e. focusFirst) and enter or tab is hit
       * or
       * shift + tab is pressed to bring focus to the previous element
       * then clear the results
       */
      if (scope.activeIdx === -1 && shouldSelect || evt.which === 9 && !!evt.shiftKey) {
        resetMatches();
        scope.$digest();
        return;
      }

      evt.preventDefault();
      var target;
      switch (evt.which) {
        case 27: // escape
          evt.stopPropagation();

          resetMatches();
          originalScope.$digest();
          break;
        case 38: // up arrow
          scope.activeIdx = (scope.activeIdx > 0 ? scope.activeIdx : scope.matches.length) - 1;
          scope.$digest();
          target = popUpEl[0].querySelectorAll('.uib-typeahead-match')[scope.activeIdx];
          target.parentNode.scrollTop = target.offsetTop;
          break;
        case 40: // down arrow
          scope.activeIdx = (scope.activeIdx + 1) % scope.matches.length;
          scope.$digest();
          target = popUpEl[0].querySelectorAll('.uib-typeahead-match')[scope.activeIdx];
          target.parentNode.scrollTop = target.offsetTop;
          break;
        default:
          if (shouldSelect) {
            scope.$apply(function() {
              if (angular.isNumber(scope.debounceUpdate) || angular.isObject(scope.debounceUpdate)) {
                $$debounce(function() {
                  scope.select(scope.activeIdx, evt);
                }, angular.isNumber(scope.debounceUpdate) ? scope.debounceUpdate : scope.debounceUpdate['default']);
              } else {
                scope.select(scope.activeIdx, evt);
              }
            });
          }
      }
    });

    element.on('focus', function (evt) {
      hasFocus = true;
      if (minLength === 0 && !modelCtrl.$viewValue) {
        $timeout(function() {
          getMatchesAsync(modelCtrl.$viewValue, evt);
        }, 0);
      }
    });

    element.on('blur', function(evt) {
      if (isSelectOnBlur && scope.matches.length && scope.activeIdx !== -1 && !selected) {
        selected = true;
        scope.$apply(function() {
          if (angular.isObject(scope.debounceUpdate) && angular.isNumber(scope.debounceUpdate.blur)) {
            $$debounce(function() {
              scope.select(scope.activeIdx, evt);
            }, scope.debounceUpdate.blur);
          } else {
            scope.select(scope.activeIdx, evt);
          }
        });
      }
      if (!isEditable && modelCtrl.$error.editable) {
        modelCtrl.$setViewValue();
        scope.$apply(function() {
          // Reset validity as we are clearing
          modelCtrl.$setValidity('editable', true);
          modelCtrl.$setValidity('parse', true);
        });
        element.val('');
      }
      hasFocus = false;
      selected = false;
    });

    // Keep reference to click handler to unbind it.
    var dismissClickHandler = function(evt) {
      // Issue #3973
      // Firefox treats right click as a click on document
      if (element[0] !== evt.target && evt.which !== 3 && scope.matches.length !== 0) {
        resetMatches();
        if (!$rootScope.$$phase) {
          originalScope.$digest();
        }
      }
    };

    $document.on('click', dismissClickHandler);

    originalScope.$on('$destroy', function() {
      $document.off('click', dismissClickHandler);
      if (appendToBody || appendTo) {
        $popup.remove();
      }

      if (appendToBody) {
        angular.element($window).off('resize', fireRecalculating);
        $document.find('body').off('scroll', fireRecalculating);
      }
      // Prevent jQuery cache memory leak
      popUpEl.remove();

      if (showHint) {
          inputsContainer.remove();
      }
    });

    var $popup = $compile(popUpEl)(scope);

    if (appendToBody) {
      $document.find('body').append($popup);
    } else if (appendTo) {
      angular.element(appendTo).eq(0).append($popup);
    } else {
      element.after($popup);
    }

    this.init = function(_modelCtrl, _ngModelOptions) {
      modelCtrl = _modelCtrl;
      ngModelOptions = _ngModelOptions;

      scope.debounceUpdate = modelCtrl.$options && $parse(modelCtrl.$options.debounce)(originalScope);

      //plug into $parsers pipeline to open a typeahead on view changes initiated from DOM
      //$parsers kick-in on all the changes coming from the view as well as manually triggered by $setViewValue
      modelCtrl.$parsers.unshift(function(inputValue) {
        hasFocus = true;

        if (minLength === 0 || inputValue && inputValue.length >= minLength) {
          if (waitTime > 0) {
            cancelPreviousTimeout();
            scheduleSearchWithTimeout(inputValue);
          } else {
            getMatchesAsync(inputValue);
          }
        } else {
          isLoadingSetter(originalScope, false);
          cancelPreviousTimeout();
          resetMatches();
        }

        if (isEditable) {
          return inputValue;
        }

        if (!inputValue) {
          // Reset in case user had typed something previously.
          modelCtrl.$setValidity('editable', true);
          return null;
        }

        modelCtrl.$setValidity('editable', false);
        return undefined;
      });

      modelCtrl.$formatters.push(function(modelValue) {
        var candidateViewValue, emptyViewValue;
        var locals = {};

        // The validity may be set to false via $parsers (see above) if
        // the model is restricted to selected values. If the model
        // is set manually it is considered to be valid.
        if (!isEditable) {
          modelCtrl.$setValidity('editable', true);
        }

        if (inputFormatter) {
          locals.$model = modelValue;
          return inputFormatter(originalScope, locals);
        }

        //it might happen that we don't have enough info to properly render input value
        //we need to check for this situation and simply return model value if we can't apply custom formatting
        locals[parserResult.itemName] = modelValue;
        candidateViewValue = parserResult.viewMapper(originalScope, locals);
        locals[parserResult.itemName] = undefined;
        emptyViewValue = parserResult.viewMapper(originalScope, locals);

        return candidateViewValue !== emptyViewValue ? candidateViewValue : modelValue;
      });
    };
  }])

  .directive('uibTypeahead', function() {
    return {
      controller: 'UibTypeaheadController',
      require: ['ngModel', '^?ngModelOptions', 'uibTypeahead'],
      link: function(originalScope, element, attrs, ctrls) {
        ctrls[2].init(ctrls[0], ctrls[1]);
      }
    };
  })

  .directive('uibTypeaheadPopup', ['$$debounce', function($$debounce) {
    return {
      scope: {
        matches: '=',
        query: '=',
        active: '=',
        position: '&',
        moveInProgress: '=',
        select: '&',
        assignIsOpen: '&',
        debounce: '&'
      },
      replace: true,
      templateUrl: function(element, attrs) {
        return attrs.popupTemplateUrl || 'uib/template/typeahead/typeahead-popup.html';
      },
      link: function(scope, element, attrs) {
        scope.templateUrl = attrs.templateUrl;

        scope.isOpen = function() {
          var isDropdownOpen = scope.matches.length > 0;
          scope.assignIsOpen({ isOpen: isDropdownOpen });
          return isDropdownOpen;
        };

        scope.isActive = function(matchIdx) {
          return scope.active === matchIdx;
        };

        scope.selectActive = function(matchIdx) {
          scope.active = matchIdx;
        };

        scope.selectMatch = function(activeIdx, evt) {
          var debounce = scope.debounce();
          if (angular.isNumber(debounce) || angular.isObject(debounce)) {
            $$debounce(function() {
              scope.select({activeIdx: activeIdx, evt: evt});
            }, angular.isNumber(debounce) ? debounce : debounce['default']);
          } else {
            scope.select({activeIdx: activeIdx, evt: evt});
          }
        };
      }
    };
  }])

  .directive('uibTypeaheadMatch', ['$templateRequest', '$compile', '$parse', function($templateRequest, $compile, $parse) {
    return {
      scope: {
        index: '=',
        match: '=',
        query: '='
      },
      link: function(scope, element, attrs) {
        var tplUrl = $parse(attrs.templateUrl)(scope.$parent) || 'uib/template/typeahead/typeahead-match.html';
        $templateRequest(tplUrl).then(function(tplContent) {
          var tplEl = angular.element(tplContent.trim());
          element.replaceWith(tplEl);
          $compile(tplEl)(scope);
        });
      }
    };
  }])

  .filter('uibTypeaheadHighlight', ['$sce', '$injector', '$log', function($sce, $injector, $log) {
    var isSanitizePresent;
    isSanitizePresent = $injector.has('$sanitize');

    function escapeRegexp(queryToEscape) {
      // Regex: capture the whole query string and replace it with the string that will be used to match
      // the results, for example if the capture is "a" the result will be \a
      return queryToEscape.replace(/([.?*+^$[\]\\(){}|-])/g, '\\$1');
    }

    function containsHtml(matchItem) {
      return /<.*>/g.test(matchItem);
    }

    return function(matchItem, query) {
      if (!isSanitizePresent && containsHtml(matchItem)) {
        $log.warn('Unsafe use of typeahead please use ngSanitize'); // Warn the user about the danger
      }
      matchItem = query ? ('' + matchItem).replace(new RegExp(escapeRegexp(query), 'gi'), '<strong>$&</strong>') : matchItem; // Replaces the capture string with a the same string inside of a "strong" tag
      if (!isSanitizePresent) {
        matchItem = $sce.trustAsHtml(matchItem); // If $sanitize is not present we pack the string in a $sce object for the ng-bind-html directive
      }
      return matchItem;
    };
  }]);

angular.module("uib/template/accordion/accordion-group.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/accordion/accordion-group.html",
    "<div role=\"tab\" id=\"{{::headingId}}\" aria-selected=\"{{isOpen}}\" class=\"panel-heading\" ng-keypress=\"toggleOpen($event)\">\n" +
    "  <h4 class=\"panel-title\">\n" +
    "    <a role=\"button\" data-toggle=\"collapse\" href aria-expanded=\"{{isOpen}}\" aria-controls=\"{{::panelId}}\" tabindex=\"0\" class=\"accordion-toggle\" ng-click=\"toggleOpen()\" uib-accordion-transclude=\"heading\" ng-disabled=\"isDisabled\" uib-tabindex-toggle><span uib-accordion-header ng-class=\"{'text-muted': isDisabled}\">{{heading}}</span></a>\n" +
    "  </h4>\n" +
    "</div>\n" +
    "<div id=\"{{::panelId}}\" aria-labelledby=\"{{::headingId}}\" aria-hidden=\"{{!isOpen}}\" role=\"tabpanel\" class=\"panel-collapse collapse\" uib-collapse=\"!isOpen\">\n" +
    "  <div class=\"panel-body\" ng-transclude></div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/accordion/accordion.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/accordion/accordion.html",
    "<div role=\"tablist\" class=\"panel-group\" ng-transclude></div>");
}]);

angular.module("uib/template/alert/alert.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/alert/alert.html",
    "<button ng-show=\"closeable\" type=\"button\" class=\"close\" ng-click=\"close({$event: $event})\">\n" +
    "  <span aria-hidden=\"true\">&times;</span>\n" +
    "  <span class=\"sr-only\">Close</span>\n" +
    "</button>\n" +
    "<div ng-transclude></div>\n" +
    "");
}]);

angular.module("uib/template/carousel/carousel.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/carousel/carousel.html",
    "<div class=\"carousel-inner\" ng-transclude></div>\n" +
    "<a role=\"button\" href class=\"left carousel-control\" ng-click=\"prev()\" ng-class=\"{ disabled: isPrevDisabled() }\" ng-show=\"slides.length > 1\">\n" +
    "  <span aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-left\"></span>\n" +
    "  <span class=\"sr-only\">previous</span>\n" +
    "</a>\n" +
    "<a role=\"button\" href class=\"right carousel-control\" ng-click=\"next()\" ng-class=\"{ disabled: isNextDisabled() }\" ng-show=\"slides.length > 1\">\n" +
    "  <span aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-right\"></span>\n" +
    "  <span class=\"sr-only\">next</span>\n" +
    "</a>\n" +
    "<ol class=\"carousel-indicators\" ng-show=\"slides.length > 1\">\n" +
    "  <li ng-repeat=\"slide in slides | orderBy:indexOfSlide track by $index\" ng-class=\"{ active: isActive(slide) }\" ng-click=\"select(slide)\">\n" +
    "    <span class=\"sr-only\">slide {{ $index + 1 }} of {{ slides.length }}<span ng-if=\"isActive(slide)\">, currently active</span></span>\n" +
    "  </li>\n" +
    "</ol>\n" +
    "");
}]);

angular.module("uib/template/carousel/slide.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/carousel/slide.html",
    "<div class=\"text-center\" ng-transclude></div>\n" +
    "");
}]);

angular.module("uib/template/datepicker/datepicker.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/datepicker/datepicker.html",
    "<div ng-switch=\"datepickerMode\">\n" +
    "  <div uib-daypicker ng-switch-when=\"day\" tabindex=\"0\" class=\"uib-daypicker\"></div>\n" +
    "  <div uib-monthpicker ng-switch-when=\"month\" tabindex=\"0\" class=\"uib-monthpicker\"></div>\n" +
    "  <div uib-yearpicker ng-switch-when=\"year\" tabindex=\"0\" class=\"uib-yearpicker\"></div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/datepicker/day.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/datepicker/day.html",
    "<table role=\"grid\" aria-labelledby=\"{{::uniqueId}}-title\" aria-activedescendant=\"{{activeDateId}}\">\n" +
    "  <thead>\n" +
    "    <tr>\n" +
    "      <th><button type=\"button\" class=\"btn btn-default btn-sm pull-left uib-left\" ng-click=\"move(-1)\" tabindex=\"-1\"><i aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-left\"></i><span class=\"sr-only\">previous</span></button></th>\n" +
    "      <th colspan=\"{{::5 + showWeeks}}\"><button id=\"{{::uniqueId}}-title\" role=\"heading\" aria-live=\"assertive\" aria-atomic=\"true\" type=\"button\" class=\"btn btn-default btn-sm uib-title\" ng-click=\"toggleMode()\" ng-disabled=\"datepickerMode === maxMode\" tabindex=\"-1\"><strong>{{title}}</strong></button></th>\n" +
    "      <th><button type=\"button\" class=\"btn btn-default btn-sm pull-right uib-right\" ng-click=\"move(1)\" tabindex=\"-1\"><i aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-right\"></i><span class=\"sr-only\">next</span></button></th>\n" +
    "    </tr>\n" +
    "    <tr>\n" +
    "      <th ng-if=\"showWeeks\" class=\"text-center\"></th>\n" +
    "      <th ng-repeat=\"label in ::labels track by $index\" class=\"text-center\"><small aria-label=\"{{::label.full}}\">{{::label.abbr}}</small></th>\n" +
    "    </tr>\n" +
    "  </thead>\n" +
    "  <tbody>\n" +
    "    <tr class=\"uib-weeks\" ng-repeat=\"row in rows track by $index\" role=\"row\">\n" +
    "      <td ng-if=\"showWeeks\" class=\"text-center h6\"><em>{{ weekNumbers[$index] }}</em></td>\n" +
    "      <td ng-repeat=\"dt in row\" class=\"uib-day text-center\" role=\"gridcell\"\n" +
    "        id=\"{{::dt.uid}}\"\n" +
    "        ng-class=\"::dt.customClass\">\n" +
    "        <button type=\"button\" class=\"btn btn-default btn-sm\"\n" +
    "          uib-is-class=\"\n" +
    "            'btn-info' for selectedDt,\n" +
    "            'active' for activeDt\n" +
    "            on dt\"\n" +
    "          ng-click=\"select(dt.date)\"\n" +
    "          ng-disabled=\"::dt.disabled\"\n" +
    "          tabindex=\"-1\"><span ng-class=\"::{'text-muted': dt.secondary, 'text-info': dt.current}\">{{::dt.label}}</span></button>\n" +
    "      </td>\n" +
    "    </tr>\n" +
    "  </tbody>\n" +
    "</table>\n" +
    "");
}]);

angular.module("uib/template/datepicker/month.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/datepicker/month.html",
    "<table role=\"grid\" aria-labelledby=\"{{::uniqueId}}-title\" aria-activedescendant=\"{{activeDateId}}\">\n" +
    "  <thead>\n" +
    "    <tr>\n" +
    "      <th><button type=\"button\" class=\"btn btn-default btn-sm pull-left uib-left\" ng-click=\"move(-1)\" tabindex=\"-1\"><i aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-left\"></i><span class=\"sr-only\">previous</span></button></th>\n" +
    "      <th colspan=\"{{::yearHeaderColspan}}\"><button id=\"{{::uniqueId}}-title\" role=\"heading\" aria-live=\"assertive\" aria-atomic=\"true\" type=\"button\" class=\"btn btn-default btn-sm uib-title\" ng-click=\"toggleMode()\" ng-disabled=\"datepickerMode === maxMode\" tabindex=\"-1\"><strong>{{title}}</strong></button></th>\n" +
    "      <th><button type=\"button\" class=\"btn btn-default btn-sm pull-right uib-right\" ng-click=\"move(1)\" tabindex=\"-1\"><i aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-right\"></i><span class=\"sr-only\">next</span></i></button></th>\n" +
    "    </tr>\n" +
    "  </thead>\n" +
    "  <tbody>\n" +
    "    <tr class=\"uib-months\" ng-repeat=\"row in rows track by $index\" role=\"row\">\n" +
    "      <td ng-repeat=\"dt in row\" class=\"uib-month text-center\" role=\"gridcell\"\n" +
    "        id=\"{{::dt.uid}}\"\n" +
    "        ng-class=\"::dt.customClass\">\n" +
    "        <button type=\"button\" class=\"btn btn-default\"\n" +
    "          uib-is-class=\"\n" +
    "            'btn-info' for selectedDt,\n" +
    "            'active' for activeDt\n" +
    "            on dt\"\n" +
    "          ng-click=\"select(dt.date)\"\n" +
    "          ng-disabled=\"::dt.disabled\"\n" +
    "          tabindex=\"-1\"><span ng-class=\"::{'text-info': dt.current}\">{{::dt.label}}</span></button>\n" +
    "      </td>\n" +
    "    </tr>\n" +
    "  </tbody>\n" +
    "</table>\n" +
    "");
}]);

angular.module("uib/template/datepicker/year.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/datepicker/year.html",
    "<table role=\"grid\" aria-labelledby=\"{{::uniqueId}}-title\" aria-activedescendant=\"{{activeDateId}}\">\n" +
    "  <thead>\n" +
    "    <tr>\n" +
    "      <th><button type=\"button\" class=\"btn btn-default btn-sm pull-left uib-left\" ng-click=\"move(-1)\" tabindex=\"-1\"><i aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-left\"></i><span class=\"sr-only\">previous</span></button></th>\n" +
    "      <th colspan=\"{{::columns - 2}}\"><button id=\"{{::uniqueId}}-title\" role=\"heading\" aria-live=\"assertive\" aria-atomic=\"true\" type=\"button\" class=\"btn btn-default btn-sm uib-title\" ng-click=\"toggleMode()\" ng-disabled=\"datepickerMode === maxMode\" tabindex=\"-1\"><strong>{{title}}</strong></button></th>\n" +
    "      <th><button type=\"button\" class=\"btn btn-default btn-sm pull-right uib-right\" ng-click=\"move(1)\" tabindex=\"-1\"><i aria-hidden=\"true\" class=\"glyphicon glyphicon-chevron-right\"></i><span class=\"sr-only\">next</span></button></th>\n" +
    "    </tr>\n" +
    "  </thead>\n" +
    "  <tbody>\n" +
    "    <tr class=\"uib-years\" ng-repeat=\"row in rows track by $index\" role=\"row\">\n" +
    "      <td ng-repeat=\"dt in row\" class=\"uib-year text-center\" role=\"gridcell\"\n" +
    "        id=\"{{::dt.uid}}\"\n" +
    "        ng-class=\"::dt.customClass\">\n" +
    "        <button type=\"button\" class=\"btn btn-default\"\n" +
    "          uib-is-class=\"\n" +
    "            'btn-info' for selectedDt,\n" +
    "            'active' for activeDt\n" +
    "            on dt\"\n" +
    "          ng-click=\"select(dt.date)\"\n" +
    "          ng-disabled=\"::dt.disabled\"\n" +
    "          tabindex=\"-1\"><span ng-class=\"::{'text-info': dt.current}\">{{::dt.label}}</span></button>\n" +
    "      </td>\n" +
    "    </tr>\n" +
    "  </tbody>\n" +
    "</table>\n" +
    "");
}]);

angular.module("uib/template/datepickerPopup/popup.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/datepickerPopup/popup.html",
    "<ul role=\"presentation\" class=\"uib-datepicker-popup dropdown-menu uib-position-measure\" dropdown-nested ng-if=\"isOpen\" ng-keydown=\"keydown($event)\" ng-click=\"$event.stopPropagation()\">\n" +
    "  <li ng-transclude></li>\n" +
    "  <li ng-if=\"showButtonBar\" class=\"uib-button-bar\">\n" +
    "    <span class=\"btn-group pull-left\">\n" +
    "      <button type=\"button\" class=\"btn btn-sm btn-info uib-datepicker-current\" ng-click=\"select('today', $event)\" ng-disabled=\"isDisabled('today')\">{{ getText('current') }}</button>\n" +
    "      <button type=\"button\" class=\"btn btn-sm btn-danger uib-clear\" ng-click=\"select(null, $event)\">{{ getText('clear') }}</button>\n" +
    "    </span>\n" +
    "    <button type=\"button\" class=\"btn btn-sm btn-success pull-right uib-close\" ng-click=\"close($event)\">{{ getText('close') }}</button>\n" +
    "  </li>\n" +
    "</ul>\n" +
    "");
}]);

angular.module("uib/template/modal/window.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/modal/window.html",
    "<div class=\"modal-dialog {{size ? 'modal-' + size : ''}}\"><div class=\"modal-content\" uib-modal-transclude></div></div>\n" +
    "");
}]);

angular.module("uib/template/pager/pager.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/pager/pager.html",
    "<li ng-class=\"{disabled: noPrevious()||ngDisabled, previous: align}\"><a href ng-click=\"selectPage(page - 1, $event)\" ng-disabled=\"noPrevious()||ngDisabled\" uib-tabindex-toggle>{{::getText('previous')}}</a></li>\n" +
    "<li ng-class=\"{disabled: noNext()||ngDisabled, next: align}\"><a href ng-click=\"selectPage(page + 1, $event)\" ng-disabled=\"noNext()||ngDisabled\" uib-tabindex-toggle>{{::getText('next')}}</a></li>\n" +
    "");
}]);

angular.module("uib/template/pagination/pagination.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/pagination/pagination.html",
    "<li ng-if=\"::boundaryLinks\" ng-class=\"{disabled: noPrevious()||ngDisabled}\" class=\"pagination-first\"><a href ng-click=\"selectPage(1, $event)\" ng-disabled=\"noPrevious()||ngDisabled\" uib-tabindex-toggle>{{::getText('first')}}</a></li>\n" +
    "<li ng-if=\"::directionLinks\" ng-class=\"{disabled: noPrevious()||ngDisabled}\" class=\"pagination-prev\"><a href ng-click=\"selectPage(page - 1, $event)\" ng-disabled=\"noPrevious()||ngDisabled\" uib-tabindex-toggle>{{::getText('previous')}}</a></li>\n" +
    "<li ng-repeat=\"page in pages track by $index\" ng-class=\"{active: page.active,disabled: ngDisabled&&!page.active}\" class=\"pagination-page\"><a href ng-click=\"selectPage(page.number, $event)\" ng-disabled=\"ngDisabled&&!page.active\" uib-tabindex-toggle>{{page.text}}</a></li>\n" +
    "<li ng-if=\"::directionLinks\" ng-class=\"{disabled: noNext()||ngDisabled}\" class=\"pagination-next\"><a href ng-click=\"selectPage(page + 1, $event)\" ng-disabled=\"noNext()||ngDisabled\" uib-tabindex-toggle>{{::getText('next')}}</a></li>\n" +
    "<li ng-if=\"::boundaryLinks\" ng-class=\"{disabled: noNext()||ngDisabled}\" class=\"pagination-last\"><a href ng-click=\"selectPage(totalPages, $event)\" ng-disabled=\"noNext()||ngDisabled\" uib-tabindex-toggle>{{::getText('last')}}</a></li>\n" +
    "");
}]);

angular.module("uib/template/tooltip/tooltip-html-popup.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/tooltip/tooltip-html-popup.html",
    "<div class=\"tooltip-arrow\"></div>\n" +
    "<div class=\"tooltip-inner\" ng-bind-html=\"contentExp()\"></div>\n" +
    "");
}]);

angular.module("uib/template/tooltip/tooltip-popup.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/tooltip/tooltip-popup.html",
    "<div class=\"tooltip-arrow\"></div>\n" +
    "<div class=\"tooltip-inner\" ng-bind=\"content\"></div>\n" +
    "");
}]);

angular.module("uib/template/tooltip/tooltip-template-popup.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/tooltip/tooltip-template-popup.html",
    "<div class=\"tooltip-arrow\"></div>\n" +
    "<div class=\"tooltip-inner\"\n" +
    "  uib-tooltip-template-transclude=\"contentExp()\"\n" +
    "  tooltip-template-transclude-scope=\"originScope()\"></div>\n" +
    "");
}]);

angular.module("uib/template/popover/popover-html.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/popover/popover-html.html",
    "<div class=\"arrow\"></div>\n" +
    "\n" +
    "<div class=\"popover-inner\">\n" +
    "    <h3 class=\"popover-title\" ng-bind=\"uibTitle\" ng-if=\"uibTitle\"></h3>\n" +
    "    <div class=\"popover-content\" ng-bind-html=\"contentExp()\"></div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/popover/popover-template.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/popover/popover-template.html",
    "<div class=\"arrow\"></div>\n" +
    "\n" +
    "<div class=\"popover-inner\">\n" +
    "    <h3 class=\"popover-title\" ng-bind=\"uibTitle\" ng-if=\"uibTitle\"></h3>\n" +
    "    <div class=\"popover-content\"\n" +
    "      uib-tooltip-template-transclude=\"contentExp()\"\n" +
    "      tooltip-template-transclude-scope=\"originScope()\"></div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/popover/popover.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/popover/popover.html",
    "<div class=\"arrow\"></div>\n" +
    "\n" +
    "<div class=\"popover-inner\">\n" +
    "    <h3 class=\"popover-title\" ng-bind=\"uibTitle\" ng-if=\"uibTitle\"></h3>\n" +
    "    <div class=\"popover-content\" ng-bind=\"content\"></div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/progressbar/bar.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/progressbar/bar.html",
    "<div class=\"progress-bar\" ng-class=\"type && 'progress-bar-' + type\" role=\"progressbar\" aria-valuenow=\"{{value}}\" aria-valuemin=\"0\" aria-valuemax=\"{{max}}\" ng-style=\"{width: (percent < 100 ? percent : 100) + '%'}\" aria-valuetext=\"{{percent | number:0}}%\" aria-labelledby=\"{{::title}}\" ng-transclude></div>\n" +
    "");
}]);

angular.module("uib/template/progressbar/progress.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/progressbar/progress.html",
    "<div class=\"progress\" ng-transclude aria-labelledby=\"{{::title}}\"></div>");
}]);

angular.module("uib/template/progressbar/progressbar.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/progressbar/progressbar.html",
    "<div class=\"progress\">\n" +
    "  <div class=\"progress-bar\" ng-class=\"type && 'progress-bar-' + type\" role=\"progressbar\" aria-valuenow=\"{{value}}\" aria-valuemin=\"0\" aria-valuemax=\"{{max}}\" ng-style=\"{width: (percent < 100 ? percent : 100) + '%'}\" aria-valuetext=\"{{percent | number:0}}%\" aria-labelledby=\"{{::title}}\" ng-transclude></div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/rating/rating.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/rating/rating.html",
    "<span ng-mouseleave=\"reset()\" ng-keydown=\"onKeydown($event)\" tabindex=\"0\" role=\"slider\" aria-valuemin=\"0\" aria-valuemax=\"{{range.length}}\" aria-valuenow=\"{{value}}\" aria-valuetext=\"{{title}}\">\n" +
    "    <span ng-repeat-start=\"r in range track by $index\" class=\"sr-only\">({{ $index < value ? '*' : ' ' }})</span>\n" +
    "    <i ng-repeat-end ng-mouseenter=\"enter($index + 1)\" ng-click=\"rate($index + 1)\" class=\"glyphicon\" ng-class=\"$index < value && (r.stateOn || 'glyphicon-star') || (r.stateOff || 'glyphicon-star-empty')\" ng-attr-title=\"{{r.title}}\"></i>\n" +
    "</span>\n" +
    "");
}]);

angular.module("uib/template/tabs/tab.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/tabs/tab.html",
    "<li ng-class=\"[{active: active, disabled: disabled}, classes]\" class=\"uib-tab nav-item\">\n" +
    "  <a href ng-click=\"select($event)\" class=\"nav-link\" uib-tab-heading-transclude>{{heading}}</a>\n" +
    "</li>\n" +
    "");
}]);

angular.module("uib/template/tabs/tabset.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/tabs/tabset.html",
    "<div>\n" +
    "  <ul class=\"nav nav-{{tabset.type || 'tabs'}}\" ng-class=\"{'nav-stacked': vertical, 'nav-justified': justified}\" ng-transclude></ul>\n" +
    "  <div class=\"tab-content\">\n" +
    "    <div class=\"tab-pane\"\n" +
    "         ng-repeat=\"tab in tabset.tabs\"\n" +
    "         ng-class=\"{active: tabset.active === tab.index}\"\n" +
    "         uib-tab-content-transclude=\"tab\">\n" +
    "    </div>\n" +
    "  </div>\n" +
    "</div>\n" +
    "");
}]);

angular.module("uib/template/timepicker/timepicker.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/timepicker/timepicker.html",
    "<table class=\"uib-timepicker\">\n" +
    "  <tbody>\n" +
    "    <tr class=\"text-center\" ng-show=\"::showSpinners\">\n" +
    "      <td class=\"uib-increment hours\"><a ng-click=\"incrementHours()\" ng-class=\"{disabled: noIncrementHours()}\" class=\"btn btn-link\" ng-disabled=\"noIncrementHours()\" tabindex=\"-1\"><span class=\"glyphicon glyphicon-chevron-up\"></span></a></td>\n" +
    "      <td>&nbsp;</td>\n" +
    "      <td class=\"uib-increment minutes\"><a ng-click=\"incrementMinutes()\" ng-class=\"{disabled: noIncrementMinutes()}\" class=\"btn btn-link\" ng-disabled=\"noIncrementMinutes()\" tabindex=\"-1\"><span class=\"glyphicon glyphicon-chevron-up\"></span></a></td>\n" +
    "      <td ng-show=\"showSeconds\">&nbsp;</td>\n" +
    "      <td ng-show=\"showSeconds\" class=\"uib-increment seconds\"><a ng-click=\"incrementSeconds()\" ng-class=\"{disabled: noIncrementSeconds()}\" class=\"btn btn-link\" ng-disabled=\"noIncrementSeconds()\" tabindex=\"-1\"><span class=\"glyphicon glyphicon-chevron-up\"></span></a></td>\n" +
    "      <td ng-show=\"showMeridian\"></td>\n" +
    "    </tr>\n" +
    "    <tr>\n" +
    "      <td class=\"form-group uib-time hours\" ng-class=\"{'has-error': invalidHours}\">\n" +
    "        <input type=\"text\" placeholder=\"HH\" ng-model=\"hours\" ng-change=\"updateHours()\" class=\"form-control text-center\" ng-readonly=\"::readonlyInput\" maxlength=\"2\" tabindex=\"{{::tabindex}}\" ng-disabled=\"noIncrementHours()\" ng-blur=\"blur()\">\n" +
    "      </td>\n" +
    "      <td class=\"uib-separator\">:</td>\n" +
    "      <td class=\"form-group uib-time minutes\" ng-class=\"{'has-error': invalidMinutes}\">\n" +
    "        <input type=\"text\" placeholder=\"MM\" ng-model=\"minutes\" ng-change=\"updateMinutes()\" class=\"form-control text-center\" ng-readonly=\"::readonlyInput\" maxlength=\"2\" tabindex=\"{{::tabindex}}\" ng-disabled=\"noIncrementMinutes()\" ng-blur=\"blur()\">\n" +
    "      </td>\n" +
    "      <td ng-show=\"showSeconds\" class=\"uib-separator\">:</td>\n" +
    "      <td class=\"form-group uib-time seconds\" ng-class=\"{'has-error': invalidSeconds}\" ng-show=\"showSeconds\">\n" +
    "        <input type=\"text\" placeholder=\"SS\" ng-model=\"seconds\" ng-change=\"updateSeconds()\" class=\"form-control text-center\" ng-readonly=\"readonlyInput\" maxlength=\"2\" tabindex=\"{{::tabindex}}\" ng-disabled=\"noIncrementSeconds()\" ng-blur=\"blur()\">\n" +
    "      </td>\n" +
    "      <td ng-show=\"showMeridian\" class=\"uib-time am-pm\"><button type=\"button\" ng-class=\"{disabled: noToggleMeridian()}\" class=\"btn btn-default text-center\" ng-click=\"toggleMeridian()\" ng-disabled=\"noToggleMeridian()\" tabindex=\"{{::tabindex}}\">{{meridian}}</button></td>\n" +
    "    </tr>\n" +
    "    <tr class=\"text-center\" ng-show=\"::showSpinners\">\n" +
    "      <td class=\"uib-decrement hours\"><a ng-click=\"decrementHours()\" ng-class=\"{disabled: noDecrementHours()}\" class=\"btn btn-link\" ng-disabled=\"noDecrementHours()\" tabindex=\"-1\"><span class=\"glyphicon glyphicon-chevron-down\"></span></a></td>\n" +
    "      <td>&nbsp;</td>\n" +
    "      <td class=\"uib-decrement minutes\"><a ng-click=\"decrementMinutes()\" ng-class=\"{disabled: noDecrementMinutes()}\" class=\"btn btn-link\" ng-disabled=\"noDecrementMinutes()\" tabindex=\"-1\"><span class=\"glyphicon glyphicon-chevron-down\"></span></a></td>\n" +
    "      <td ng-show=\"showSeconds\">&nbsp;</td>\n" +
    "      <td ng-show=\"showSeconds\" class=\"uib-decrement seconds\"><a ng-click=\"decrementSeconds()\" ng-class=\"{disabled: noDecrementSeconds()}\" class=\"btn btn-link\" ng-disabled=\"noDecrementSeconds()\" tabindex=\"-1\"><span class=\"glyphicon glyphicon-chevron-down\"></span></a></td>\n" +
    "      <td ng-show=\"showMeridian\"></td>\n" +
    "    </tr>\n" +
    "  </tbody>\n" +
    "</table>\n" +
    "");
}]);

angular.module("uib/template/typeahead/typeahead-match.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/typeahead/typeahead-match.html",
    "<a href\n" +
    "   tabindex=\"-1\"\n" +
    "   ng-bind-html=\"match.label | uibTypeaheadHighlight:query\"\n" +
    "   ng-attr-title=\"{{match.label}}\"></a>\n" +
    "");
}]);

angular.module("uib/template/typeahead/typeahead-popup.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("uib/template/typeahead/typeahead-popup.html",
    "<ul class=\"dropdown-menu\" ng-show=\"isOpen() && !moveInProgress\" ng-style=\"{top: position().top+'px', left: position().left+'px'}\" role=\"listbox\" aria-hidden=\"{{!isOpen()}}\">\n" +
    "    <li class=\"uib-typeahead-match\" ng-repeat=\"match in matches track by $index\" ng-class=\"{active: isActive($index) }\" ng-mouseenter=\"selectActive($index)\" ng-click=\"selectMatch($index, $event)\" role=\"option\" id=\"{{::match.id}}\">\n" +
    "        <div uib-typeahead-match index=\"$index\" match=\"match\" query=\"query\" template-url=\"templateUrl\"></div>\n" +
    "    </li>\n" +
    "</ul>\n" +
    "");
}]);
angular.module('ui.bootstrap.carousel').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibCarouselCss && angular.element(document).find('head').prepend('<style type="text/css">.ng-animate.item:not(.left):not(.right){-webkit-transition:0s ease-in-out left;transition:0s ease-in-out left}</style>'); angular.$$uibCarouselCss = true; });
angular.module('ui.bootstrap.datepicker').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibDatepickerCss && angular.element(document).find('head').prepend('<style type="text/css">.uib-datepicker .uib-title{width:100%;}.uib-day button,.uib-month button,.uib-year button{min-width:100%;}.uib-left,.uib-right{width:100%}</style>'); angular.$$uibDatepickerCss = true; });
angular.module('ui.bootstrap.position').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibPositionCss && angular.element(document).find('head').prepend('<style type="text/css">.uib-position-measure{display:block !important;visibility:hidden !important;position:absolute !important;top:-9999px !important;left:-9999px !important;}.uib-position-scrollbar-measure{position:absolute !important;top:-9999px !important;width:50px !important;height:50px !important;overflow:scroll !important;}.uib-position-body-scrollbar-measure{overflow:scroll !important;}</style>'); angular.$$uibPositionCss = true; });
angular.module('ui.bootstrap.datepickerPopup').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibDatepickerpopupCss && angular.element(document).find('head').prepend('<style type="text/css">.uib-datepicker-popup.dropdown-menu{display:block;float:none;margin:0;}.uib-button-bar{padding:10px 9px 2px;}</style>'); angular.$$uibDatepickerpopupCss = true; });
angular.module('ui.bootstrap.tooltip').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibTooltipCss && angular.element(document).find('head').prepend('<style type="text/css">[uib-tooltip-popup].tooltip.top-left > .tooltip-arrow,[uib-tooltip-popup].tooltip.top-right > .tooltip-arrow,[uib-tooltip-popup].tooltip.bottom-left > .tooltip-arrow,[uib-tooltip-popup].tooltip.bottom-right > .tooltip-arrow,[uib-tooltip-popup].tooltip.left-top > .tooltip-arrow,[uib-tooltip-popup].tooltip.left-bottom > .tooltip-arrow,[uib-tooltip-popup].tooltip.right-top > .tooltip-arrow,[uib-tooltip-popup].tooltip.right-bottom > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.top-left > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.top-right > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.bottom-left > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.bottom-right > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.left-top > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.left-bottom > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.right-top > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.right-bottom > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.top-left > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.top-right > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.bottom-left > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.bottom-right > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.left-top > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.left-bottom > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.right-top > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.right-bottom > .tooltip-arrow,[uib-popover-popup].popover.top-left > .arrow,[uib-popover-popup].popover.top-right > .arrow,[uib-popover-popup].popover.bottom-left > .arrow,[uib-popover-popup].popover.bottom-right > .arrow,[uib-popover-popup].popover.left-top > .arrow,[uib-popover-popup].popover.left-bottom > .arrow,[uib-popover-popup].popover.right-top > .arrow,[uib-popover-popup].popover.right-bottom > .arrow,[uib-popover-html-popup].popover.top-left > .arrow,[uib-popover-html-popup].popover.top-right > .arrow,[uib-popover-html-popup].popover.bottom-left > .arrow,[uib-popover-html-popup].popover.bottom-right > .arrow,[uib-popover-html-popup].popover.left-top > .arrow,[uib-popover-html-popup].popover.left-bottom > .arrow,[uib-popover-html-popup].popover.right-top > .arrow,[uib-popover-html-popup].popover.right-bottom > .arrow,[uib-popover-template-popup].popover.top-left > .arrow,[uib-popover-template-popup].popover.top-right > .arrow,[uib-popover-template-popup].popover.bottom-left > .arrow,[uib-popover-template-popup].popover.bottom-right > .arrow,[uib-popover-template-popup].popover.left-top > .arrow,[uib-popover-template-popup].popover.left-bottom > .arrow,[uib-popover-template-popup].popover.right-top > .arrow,[uib-popover-template-popup].popover.right-bottom > .arrow{top:auto;bottom:auto;left:auto;right:auto;margin:0;}[uib-popover-popup].popover,[uib-popover-html-popup].popover,[uib-popover-template-popup].popover{display:block !important;}</style>'); angular.$$uibTooltipCss = true; });
angular.module('ui.bootstrap.timepicker').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibTimepickerCss && angular.element(document).find('head').prepend('<style type="text/css">.uib-time input{width:50px;}</style>'); angular.$$uibTimepickerCss = true; });
angular.module('ui.bootstrap.typeahead').run(function() {!angular.$$csp().noInlineStyle && !angular.$$uibTypeaheadCss && angular.element(document).find('head').prepend('<style type="text/css">[uib-typeahead-popup].dropdown-menu{display:block;}</style>'); angular.$$uibTypeaheadCss = true; });

//# sourceMappingURL=vendor.js.map