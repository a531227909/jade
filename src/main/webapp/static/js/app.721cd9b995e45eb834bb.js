webpackJsonp([26],{133:function(e,t,n){function a(e){n(528)}var o=n(38)(n(274),n(538),a,"data-v-2d84ac1b",null);e.exports=o.exports},135:function(e,t,n){"use strict";n.d(t,"b",function(){return c}),n.d(t,"c",function(){return u});var a=n(13),o=n(543),r=n(535),s=n.n(r),i=n(265);a.default.use(o.a);var c=[{path:"/login",component:i("login/index"),hidden:!0},{path:"/authredirect",component:i("login/authredirect"),hidden:!0},{path:"/404",component:i("error/404"),hidden:!0},{path:"/401",component:i("error/401"),hidden:!0},{path:"/",component:s.a,redirect:"/Layout",name:"首页",hidden:!0,children:[{path:"Layout",component:i("layout/greet"),hidden:"true"}]}];t.a=new o.a({scrollBehavior:function(){return{y:0}},routes:c});var u=[{path:"/order",component:s.a,name:"订单管理",redirect:"/order/send",iconCls:"el-icon-message",meta:{role:["0101"]},children:[{path:"send",component:i("order/send"),name:"等待发货",meta:{role:["010101"]}},{path:"delivery",component:i("order/delivery"),name:"等待收货",meta:{role:["010102"]}},{path:"trade",component:i("order/trade"),name:"交易完成",meta:{role:["010103"]}},{path:"comment",component:i("order/comment"),name:"完成评价",meta:{role:["010104"]}},{path:"close",component:i("order/close"),name:"自动关闭",meta:{role:["010105"]}}]},{path:"/goods",component:s.a,name:"商品管理",iconCls:"fa fa-address-card",meta:{role:["0102"]},children:[{path:"list",component:i("goods/list"),name:"上架列表",meta:{role:["010201"]}},{path:"store",component:i("goods/store"),name:"仓库列表",meta:{role:["010202"]}},{path:"add",component:i("goods/add"),name:"新增商品",meta:{role:["010202"]}},{path:"category",component:i("goods/category"),name:"类别设置",meta:{role:["010202"]}}]},{path:"/account",component:s.a,name:"账号管理",iconCls:"fa fa-address-card",meta:{role:["0103"]},children:[{path:"list",component:i("account/list"),name:"账号列表",meta:{role:["010301"]}},{path:"add",component:i("account/add"),name:"添加账号",meta:{role:["010302"]}}]},{path:"/notice",component:s.a,name:"公告管理",iconCls:"el-icon-message",redirect:"/notice/list",meta:{role:["0104"]},children:[{path:"list",component:i("notice/list"),name:"公告列表",meta:{role:["010401"]}},{path:"add",component:i("notice/add"),name:"新建公告",meta:{role:["010402"]}}]},{path:"/performance",component:s.a,name:"业绩管理",redirect:"/performance/list",iconCls:"el-icon-message",meta:{role:["0105"]},noDropdown:!0,children:[{path:"list",component:i("performance/list"),name:"业绩管理",meta:{role:["0105"]}}]},{path:"/rule",component:s.a,name:"权限管理",iconCls:"el-icon-message",redirect:"/rule/list",meta:{role:["0106"]},children:[{path:"list",component:i("rule/list"),name:"角色列表",meta:{role:["010601"]}},{path:"add",component:i("rule/add"),name:"添加角色",meta:{role:["010602"]}}]},{path:"/agent",component:s.a,name:"代理管理",iconCls:"el-icon-message",redirect:"/agent/list",meta:{role:["0107"]},children:[{path:"list",component:i("agent/list"),name:"代理商列表",meta:{role:["010701"]}},{path:"add",component:i("agent/add"),name:"添加代理",meta:{role:["010702"]}},{path:":id",component:i("agent/detail"),name:"代理商业绩",hidden:!0,meta:{role:["010703"]}}]},{path:"*",redirect:"/404",hidden:!0}]},201:function(e,t,n){var a=n(38)(n(273),n(541),null,null,null);e.exports=a.exports},202:function(e,t,n){function a(e){n(529)}var o=n(38)(n(275),n(539),a,"data-v-312feac8",null);e.exports=o.exports},203:function(e,t,n){function a(e){n(530)}var o=n(38)(n(276),n(540),a,"data-v-76b16a80",null);e.exports=o.exports},204:function(e,t,n){function a(e){n(526)}var o=n(38)(n(277),n(536),a,"data-v-03255433",null);e.exports=o.exports},205:function(e,t,n){"use strict";var a=n(13),o=n(91),r=n(267),s=n(271),i=n(268),c=n(270),u=n(269),l=n(266);a.default.use(o.a);var d=new o.a.Store({modules:{app:r.a,user:s.a,msg:i.a,performance:u.a,permission:c.a},getters:l.a});t.a=d},208:function(e,t){},209:function(e,t){},210:function(e,t,n){function a(e){n(527)}var o=n(38)(n(272),n(537),a,null,null);e.exports=o.exports},211:function(e,t,n){"use strict";n.d(t,"b",function(){return a}),n.d(t,"a",function(){return o});var a="http://localhost:8088",o="http://localhost:8088"},223:function(e,t,n){"use strict";n.d(t,"b",function(){return l}),n.d(t,"c",function(){return d}),n.d(t,"d",function(){return p}),n.d(t,"a",function(){return m});var a=n(136),o=n.n(a),r=n(65),s=n.n(r),i=n(212),c=n.n(i),u=n(211),l=function(e){return c.a.post(u.a+"/jade/user/loginManage.action",e,{withCredentials:!0,transformRequest:[function(e){var t="";for(var n in e)t+=encodeURIComponent(n)+"="+encodeURIComponent(e[n])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then(function(e){return sessionStorage.setItem("rules",e.data.result.data),s.a.resolve(e.data)},function(e){console.log(e)})},d=function(e){return c.a.post(u.a+"/jade/user/getUser.action",e,{withCredentials:!0,headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then(function(e){var t=o()(e.data.result,{rules:sessionStorage.getItem("rules")});return s.a.resolve(t)},function(e){console.log(e)})},p=function(e){return c.a.post(u.a+"/jade/user/outManageLogin.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return s.a.resolve(e.data)},function(e){console.log(e)})},m=function(e){return c.a.post(u.a+"/jade/uorerManage/selectIdea.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return s.a.resolve(e.data)},function(e){console.log(e)})}},224:function(e,t,n){"use strict";var a=n(202),o=n.n(a);n.d(t,"a",function(){return o.a});var r=n(203),s=n.n(r);n.d(t,"b",function(){return s.a});var i=n(133),c=(n.n(i),n(201)),u=n.n(c);n.d(t,"c",function(){return u.a})},264:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n(68),o=n.n(a),r=n(206),s=(n.n(r),n(13)),i=n(210),c=n.n(i),u=n(205),l=n(135),d=n(207),p=n.n(d),m=n(208),f=(n.n(m),n(209)),h=(n.n(f),n(92));s.default.use(p.a);var v=["/login"];l.a.beforeEach(function(e,t,a){n.i(h.a)()?"/login"===e.path?a({path:"/"}):u.a.getters.roles&&0===u.a.getters.roles.length?u.a.dispatch("GetInfo").then(function(t){if(t.rules){var n=t.rules.split(",");u.a.dispatch("GenerateRoutes",{roles:n}).then(function(){l.a.addRoutes(u.a.getters.addRouters),a(o()({},e))})}else a("/login")}):a():-1!==v.indexOf(e.path)?a():a("/login")}),new s.default({el:"#app",router:l.a,store:u.a,render:function(e){return e(c.a)}})},265:function(e,t,n){e.exports=function(e){return function(){return n(545)("./"+e+".vue")}}},266:function(e,t,n){"use strict";var a={sidebar:function(e){return e.app.sidebar},token:function(e){return e.user.token},avatar:function(e){return e.user.avatar},name:function(e){return e.user.name},roles:function(e){return e.user.roles},msg:function(e){return e.msgs},performanceId:function(e){return e.performance.performanceId},permission_routers:function(e){return e.permission.routers},addRouters:function(e){return e.permission.addRouters}};t.a=a},267:function(e,t,n){"use strict";var a=n(199),o=n.n(a),r={state:{sidebar:{opened:!+o.a.get("sidebarStatus")}},mutations:{TOGGLE_SIDEBAR:function(e){e.sidebar.opened?o.a.set("sidebarStatus",1):o.a.set("sidebarStatus",0),e.sidebar.opened=!e.sidebar.opened}},actions:{ToggleSideBar:function(e){(0,e.commit)("TOGGLE_SIDEBAR")}}};t.a=r},268:function(e,t,n){"use strict";var a={state:{messages:[],oldMsgLength:""},mutations:{ADD_MSG:function(e,t){e.messages.push(t)},SET_MSG:function(e,t){""===e.oldMsgLength&&(e.oldMsgLength=t?t.length||0:0),e.messages=t},CLEAR_MSG:function(e,t){e.oldMsgLength=0,e.messages=[]}},actions:{pushMsg:function(e,t){(0,e.commit)("ADD_MSG",t)},setMsg:function(e,t){(0,e.commit)("SET_MSG",t)},clearMsg:function(e,t){(0,e.commit)("CLEAR_MSG",t)}}};t.a=a},269:function(e,t,n){"use strict";var a=n(65),o=n.n(a),r={state:{id:""},mutations:{SET_ID:function(e,t){e.id=t}},actions:{setSid:function(e,t){var n=e.commit;return new o.a(function(e,a){n("SET_ID",t),e()})}}};t.a=r},270:function(e,t,n){"use strict";function a(e,t){return!t.meta||!t.meta.role||e.some(function(e){return t.meta.role.indexOf(e)>=0})}function o(e,t){return e.filter(function(e){return!!a(t,e)&&(e.children&&e.children.length&&(e.children=o(e.children,t)),!0)})}var r=n(65),s=n.n(r),i=n(135),c={state:{routers:i.b,addRouters:[]},mutations:{SET_ROUTERS:function(e,t){e.addRouters=t,e.routers=i.b.concat(t)}},actions:{GenerateRoutes:function(e,t){var n=e.commit;return new s.a(function(e){var a=t.roles,r=void 0;r=a.indexOf("admin")>=0?i.c:o(i.c,a),n("SET_ROUTERS",r),e()})}}};t.a=c},271:function(e,t,n){"use strict";var a=n(65),o=n.n(a),r=n(223),s=n(92),i={state:{token:n.i(s.a)(),name:"",avatar:"",roles:[]},mutations:{SET_TOKEN:function(e,t){e.token=t},SET_NAME:function(e,t){e.name=t},SET_AVATAR:function(e,t){e.avatar=t},SET_ROLES:function(e,t){e.roles=t}},actions:{Login:function(e,t){var a=e.commit,i=t.account,c=t.checkPass;return new o.a(function(e,t){var o={account:i,password:c};n.i(r.b)(o).then(function(t){var o=t.result;n.i(s.b)(o.sid),sessionStorage.setItem("accountType",o.accountType),a("SET_TOKEN",o.sid),e(t)}).catch(function(e){t(e)})})},GetInfo:function(e){var t=e.commit;return new o.a(function(e,a){n.i(r.c)().then(function(n){var a=n;t("SET_ROLES",a.rules),t("SET_NAME",a.name),t("SET_AVATAR",a.img),e(n)}).catch(function(e){a(e)})})},LogOut:function(e){var t=e.commit,a=e.state;return new o.a(function(e,o){n.i(r.d)(a.token).then(function(){t("SET_TOKEN",""),t("SET_ROLES",[]),n.i(s.c)(),e()}).catch(function(e){o(e)})})},FedLogOut:function(e){var t=e.commit;return new o.a(function(e){t("SET_TOKEN",""),n.i(s.c)(),e()})}}};t.a=i},272:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={}},273:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"AppMain",computed:{key:function(){return void 0!==this.$route.name?this.$route.name+ +new Date:this.$route+ +new Date}}}},274:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={created:function(){this.getBreadcrumb()},data:function(){return{levelList:null}},methods:{getBreadcrumb:function(){var e=this.$route.matched.filter(function(e){return e.name}),t=e[0];!t||"首页"===t.name&&""===t.path||(e=[{name:"首页",path:"/"}].concat(e)),this.levelList=e}},watch:{$route:function(){this.getBreadcrumb()}}}},275:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n(68),o=n.n(a),r=n(91),s=n(133),i=n.n(s);t.default={props:["sysName","collapsed"],data:function(){return{dialogVisible:!1,totalData:[],topics:[],page:1,total:0,pageSize:12}},components:{Levelbar:i.a},computed:o()({},n.i(r.b)(["sidebar","avatar","name"]),{sysUserAvatar:function(){return this.avatar},sysUserName:function(){return this.name||"未定义"},msgs:function(){var e=void 0;return this.$store.state.msg.messages?(e=this.$store.state.msg.messages,this.setTopics(e),this.$store.state.msg.messages.length-this.$store.state.msg.oldMsgLength):(e=[],this.setTopics(e),0)}}),methods:{toggleSideBar:function(){this.$store.dispatch("ToggleSideBar")},setTopics:function(e){this.totalData=e,this.total=Math.ceil(this.totalData.length/this.pageSize),this.topics=e.slice(this.page-1,10)},handleCurrentChange:function(e){this.page=e;for(var t=[],n=(e-1)*this.pageSize;n<this.pageSize*e;n++)this.totalData[n]&&t.push(this.totalData[n]);this.topics=t},logout:function(){this.$store.dispatch("LogOut").then(function(){location.reload()})},show:function(){this.setTopics(this.$store.state.msg.messages.reverse()),this.dialogVisible=!0},handleClose:function(){this.$store.dispatch("clearMsg"),this.dialogVisible=!1}}}},276:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n(68),o=n.n(a),r=n(91),s=n(204),i=n.n(s);t.default={components:{SidebarItem:i.a},computed:o()({},n.i(r.b)(["permission_routers"]))}},277:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"SidebarItem",props:{routes:{type:Array}}}},278:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n(224);t.default={name:"layout",data:function(){return{sysName:"翡翠后台",collapsed:!1}},components:{Navbar:a.a,Sidebar:a.b,AppMain:a.c},computed:{sidebar:function(){return this.$store.state.app.sidebar}}}},526:function(e,t){},527:function(e,t){},528:function(e,t){},529:function(e,t){},530:function(e,t){},531:function(e,t){},535:function(e,t,n){function a(e){n(531)}var o=n(38)(n(278),n(542),a,"data-v-dcd61ed4",null);e.exports=o.exports},536:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._l(e.routes,function(t){return[!t.hidden&&t.noDropdown&&t.children.length>0?n("router-link",{attrs:{to:t.path+"/"+t.children[0].path}},[n("el-menu-item",{attrs:{index:t.path+"/"+t.children[0].path}},[t.icon?n("icon-svg",{attrs:{"icon-class":t.icon}}):e._e(),e._v("\n        "+e._s(t.children[0].name)+"\n      ")],1)],1):e._e(),e._v(" "),t.noDropdown||t.hidden?e._e():n("el-submenu",{attrs:{index:t.name}},[n("template",{slot:"title"},[t.icon?n("icon-svg",{attrs:{"icon-class":t.icon}}):e._e(),e._v("\n        "+e._s(t.name)+"\n      ")],1),e._v(" "),e._l(t.children,function(a){return a.hidden?e._e():[a.children&&a.children.length>0?n("sidebar-item",{staticClass:"menu-indent",attrs:{routes:[a]}}):n("router-link",{staticClass:"menu-indent",attrs:{to:t.path+"/"+a.path}},[n("el-menu-item",{attrs:{index:t.path+"/"+a.path}},[e._v("\n            "+e._s(a.name)+"\n          ")])],1)]})],2)]})],2)},staticRenderFns:[]}},537:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("transition",{attrs:{name:"fade",mode:"out-in"}},[n("router-view")],1)],1)},staticRenderFns:[]}},538:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-breadcrumb",{staticClass:"app-levelbar",attrs:{separator:"/"}},e._l(e.levelList,function(t,a){return n("el-breadcrumb-item",{key:t},["noredirect"===t.redirect||a==e.levelList.length-1?n("router-link",{staticClass:"no-redirect",attrs:{to:""}},[e._v(e._s(t.name))]):n("router-link",{attrs:{to:t.redirect||t.path}},[e._v(e._s(t.name))])],1)}))},staticRenderFns:[]}},539:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-col",{staticClass:"header",attrs:{span:24}},[n("el-col",{staticClass:"logo",class:e.collapsed?"logo-collapse-width":"logo-width",attrs:{span:10}},[e._v("\n    "+e._s(e.collapsed?"":e.sysName)+"\n  ")]),e._v(" "),n("el-col",{staticClass:"userinfo",staticStyle:{position:"relative"},attrs:{span:4}},[n("el-badge",{staticStyle:{position:"relative",right:"24px"},attrs:{value:e.msgs}},[n("img",{staticStyle:{position:"relative",top:"6px"},attrs:{src:"/static/lingdang.png",alt:""},on:{click:e.show}})]),e._v(" "),n("el-dropdown",{attrs:{trigger:"hover"}},[n("span",{staticClass:"el-dropdown-link userinfo-inner"},[n("img",{attrs:{src:this.sysUserAvatar}}),e._v(e._s(e.sysUserName)+"\n      ")]),e._v(" "),n("el-dropdown-menu",{slot:"dropdown"},[n("router-link",{staticClass:"inlineBlock",attrs:{to:"/"}},[n("el-dropdown-item",[e._v("\n            首页\n          ")])],1),e._v(" "),n("el-dropdown-item",{attrs:{divided:""}},[n("span",{staticStyle:{display:"block"},on:{click:e.logout}},[e._v("登出")])])],1)],1)],1),e._v(" "),n("el-dialog",{staticClass:"msgs",attrs:{title:"信息",visible:e.dialogVisible,"before-close":e.handleClose,size:"small"},on:{"update:visible":function(t){e.dialogVisible=t}}},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:e.topics}},[n("el-table-column",{attrs:{prop:"accountName",label:"姓名",align:"center",width:"180"}}),e._v(" "),n("el-table-column",{attrs:{prop:"content",align:"center",label:"内容"}}),e._v(" "),n("el-table-column",{attrs:{label:"日期",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(t.row.createTime.slice(0,11))+"\n        ")]}}])})],1),e._v(" "),n("el-col",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],staticClass:"toolbar",staticStyle:{"line-height":"30px"},attrs:{span:24}},[n("el-pagination",{staticStyle:{float:"right"},attrs:{layout:"prev, pager, next","page-size":e.pageSize,total:e.total*e.pageSize},on:{"current-change":e.handleCurrentChange}})],1)],1)],1)},staticRenderFns:[]}},540:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{mode:"vertical","default-active":e.$route.path,"unique-opened":"",router:""}},[n("sidebar-item",{attrs:{routes:e.permission_routers}})],1)},staticRenderFns:[]}},541:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("section",{staticClass:"app-main"},[n("transition",{attrs:{name:"fade",mode:"out-in"}},[n("router-view",{key:e.key})],1)],1)},staticRenderFns:[]}},542:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-row",{staticClass:"container"},[n("el-col",{staticClass:"header",attrs:{span:24}},[n("navbar",{staticClass:"userinfo",attrs:{sysName:e.sysName,collapsed:e.collapsed}})],1),e._v(" "),n("el-col",{staticClass:"main",attrs:{span:24}},[n("aside",{class:e.collapsed?"menu-collapsed":"menu-expanded"},[n("sidebar",{staticClass:"sidebar-container"})],1),e._v(" "),n("section",{staticClass:"content-container"},[n("div",{staticClass:"grid-content bg-purple-light"},[n("el-col",{staticClass:"breadcrumb-container",attrs:{span:24}},[n("strong",{staticClass:"title"},[e._v(e._s(e.$route.name))])]),e._v(" "),n("el-col",{staticClass:"content-wrapper",attrs:{span:24}},[n("app-main")],1)],1)])])],1)},staticRenderFns:[]}},545:function(e,t,n){function a(e){var t=o[e];return t?Promise.all(t.slice(1).map(n.e)).then(function(){return n(t[0])}):Promise.reject(new Error("Cannot find module '"+e+"'."))}var o={"./account/add.vue":[548,18],"./account/list.vue":[549,2],"./agent/add.vue":[550,17],"./agent/detail.vue":[551,1],"./agent/list.vue":[552,13],"./error/401.vue":[553,23],"./error/404.vue":[554,22],"./goods/add.vue":[555,15],"./goods/category.vue":[556,11],"./goods/list.vue":[557,10],"./goods/store.vue":[558,9],"./layout/AppMain.vue":[201],"./layout/Layout.vue":[559,21],"./layout/Levelbar.vue":[133],"./layout/Navbar.vue":[202],"./layout/Sidebar.vue":[203],"./layout/SidebarItem.vue":[204],"./layout/greet.vue":[560,20],"./login/authredirect.vue":[561,24],"./login/index.vue":[562,19],"./notice/add.vue":[563,14],"./notice/list.vue":[564,8],"./order/close.vue":[565,7],"./order/comment.vue":[566,6],"./order/delivery.vue":[567,5],"./order/send.vue":[568,4],"./order/trade.vue":[569,3],"./performance/list.vue":[570,0],"./rule/add.vue":[571,16],"./rule/list.vue":[572,12]};a.keys=function(){return Object.keys(o)},e.exports=a,a.id=545},92:function(e,t,n){"use strict";function a(){return i.a.get(c)}function o(e){return i.a.set(c,e)}function r(){return i.a.remove(c)}t.a=a,t.b=o,t.c=r;var s=n(199),i=n.n(s),c="Admin-Token"}},[264]);
//# sourceMappingURL=app.721cd9b995e45eb834bb.js.map