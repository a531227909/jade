webpackJsonp([21],{559:function(n,a,e){function t(n){e(654)}var A=e(38)(e(616),e(677),t,"data-v-0866ccb6",null);n.exports=A.exports},616:function(n,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var t=e(224);a.default={name:"layout",data:function(){return{sysName:"翡翠后台",collapsed:!1}},components:{Navbar:t.a,Sidebar:t.b,AppMain:t.c},computed:{sidebar:function(){return this.$store.state.app.sidebar}}}},632:function(n,a,e){a=n.exports=e(546)(!0),a.push([n.i,".container[data-v-0866ccb6]{position:absolute;top:0;bottom:0;width:100%}.container .header[data-v-0866ccb6]{height:80px;line-height:80px;color:#fff;background-color:#008040}.container .header .userinfo[data-v-0866ccb6]{text-align:right;padding-right:35px;float:right}.container .header .userinfo .userinfo-inner[data-v-0866ccb6]{cursor:pointer;color:#fff}.container .header .userinfo .userinfo-inner img[data-v-0866ccb6]{width:40px;height:40px;border-radius:20px;margin:20px 10px;float:right}.container .header .logo[data-v-0866ccb6]{height:80px;font-size:22px;padding-left:20px;padding-right:20px;border-color:hsla(62,77%,76%,.3);border-right-width:1px;border-right-style:solid}.container .header .logo img[data-v-0866ccb6]{width:40px;float:left;margin:10px 10px 10px 18px}.container .header .logo .txt[data-v-0866ccb6]{color:#fff}.container .header .logo-width[data-v-0866ccb6]{width:230px}.container .header .logo-collapse-width[data-v-0866ccb6]{width:60px}.container .header .tools[data-v-0866ccb6]{padding:0 23px;width:14px;height:60px;line-height:60px;cursor:pointer}.container .main[data-v-0866ccb6]{display:-webkit-box;display:-ms-flexbox;display:flex;position:absolute;top:80px;bottom:0;overflow:hidden}.container .main aside[data-v-0866ccb6]{-webkit-box-flex:0;-ms-flex:0 0 230px;flex:0 0 230px;width:230px}.container .main aside .el-menu[data-v-0866ccb6]{height:100%}.container .main aside .collapsed[data-v-0866ccb6]{width:60px}.container .main aside .collapsed .item[data-v-0866ccb6]{position:relative}.container .main aside .collapsed .submenu[data-v-0866ccb6]{position:absolute;top:0;left:60px;z-index:99999;height:auto;display:none}.container .main .menu-collapsed[data-v-0866ccb6]{-webkit-box-flex:0;-ms-flex:0 0 60px;flex:0 0 60px;width:60px}.container .main .menu-expanded[data-v-0866ccb6]{-webkit-box-flex:0;-ms-flex:0 0 230px;flex:0 0 230px;width:230px}.container .main .content-container[data-v-0866ccb6]{-webkit-box-flex:1;-ms-flex:1;flex:1;overflow-y:scroll;padding:20px}.container .main .content-container .breadcrumb-container[data-v-0866ccb6]{margin-bottom:20px}.container .main .content-container .breadcrumb-container .title[data-v-0866ccb6]{width:200px;float:left;color:#475669}.container .main .content-container .breadcrumb-container .breadcrumb-inner[data-v-0866ccb6]{float:right}.container .main .content-container .content-wrapper[data-v-0866ccb6]{background-color:#fff;-webkit-box-sizing:border-box;box-sizing:border-box}","",{version:3,sources:["C:/Users/crscr/Desktop/Projects/翡翠/Code_role/src/components/layout/Layout.vue"],names:[],mappings:"AACA,4BACE,kBAAmB,AACnB,MAAS,AACT,SAAY,AACZ,UAAY,CACb,AACD,oCACE,YAAa,AACb,iBAAkB,AAClB,WAAY,AACZ,wBAA0B,CAC3B,AACD,8CACE,iBAAkB,AAClB,mBAAoB,AACpB,WAAa,CACd,AACD,8DACE,eAAgB,AAChB,UAAY,CACb,AACD,kEACE,WAAY,AACZ,YAAa,AACb,mBAAoB,AACpB,iBAAkB,AAClB,WAAa,CACd,AACD,0CACE,YAAa,AACb,eAAgB,AAChB,kBAAmB,AACnB,mBAAoB,AACpB,iCAAoC,AACpC,uBAAwB,AACxB,wBAA0B,CAC3B,AACD,8CACE,WAAY,AACZ,WAAY,AACZ,0BAA4B,CAC7B,AACD,+CACE,UAAY,CACb,AACD,gDACE,WAAa,CACd,AACD,yDACE,UAAY,CACb,AACD,2CACE,eAAkB,AAClB,WAAY,AACZ,YAAa,AACb,iBAAkB,AAClB,cAAgB,CACjB,AACD,kCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,kBAAmB,AACnB,SAAU,AACV,SAAY,AACZ,eAAiB,CAClB,AACD,wCACE,mBAAoB,AAChB,mBAAoB,AAChB,eAAgB,AACxB,WAAa,CACd,AACD,iDACE,WAAa,CACd,AACD,mDACE,UAAY,CACb,AACD,yDACE,iBAAmB,CACpB,AACD,4DACE,kBAAmB,AACnB,MAAS,AACT,UAAW,AACX,cAAe,AACf,YAAa,AACb,YAAc,CACf,AACD,kDACE,mBAAoB,AAChB,kBAAmB,AACf,cAAe,AACvB,UAAY,CACb,AACD,iDACE,mBAAoB,AAChB,mBAAoB,AAChB,eAAgB,AACxB,WAAa,CACd,AACD,qDACE,mBAAoB,AAChB,WAAY,AACR,OAAQ,AAChB,kBAAmB,AACnB,YAAc,CACf,AACD,2EACE,kBAAoB,CACrB,AACD,kFACE,YAAa,AACb,WAAY,AACZ,aAAe,CAChB,AACD,6FACE,WAAa,CACd,AACD,sEACE,sBAAuB,AACvB,8BAA+B,AACvB,qBAAuB,CAChC",file:"Layout.vue",sourcesContent:["\n.container[data-v-0866ccb6] {\n  position: absolute;\n  top: 0px;\n  bottom: 0px;\n  width: 100%;\n}\n.container .header[data-v-0866ccb6] {\n  height: 80px;\n  line-height: 80px;\n  color: #fff;\n  background-color: #008040;\n}\n.container .header .userinfo[data-v-0866ccb6] {\n  text-align: right;\n  padding-right: 35px;\n  float: right;\n}\n.container .header .userinfo .userinfo-inner[data-v-0866ccb6] {\n  cursor: pointer;\n  color: #fff;\n}\n.container .header .userinfo .userinfo-inner img[data-v-0866ccb6] {\n  width: 40px;\n  height: 40px;\n  border-radius: 20px;\n  margin: 20px 10px;\n  float: right;\n}\n.container .header .logo[data-v-0866ccb6] {\n  height: 80px;\n  font-size: 22px;\n  padding-left: 20px;\n  padding-right: 20px;\n  border-color: rgba(238,241,146,0.3);\n  border-right-width: 1px;\n  border-right-style: solid;\n}\n.container .header .logo img[data-v-0866ccb6] {\n  width: 40px;\n  float: left;\n  margin: 10px 10px 10px 18px;\n}\n.container .header .logo .txt[data-v-0866ccb6] {\n  color: #fff;\n}\n.container .header .logo-width[data-v-0866ccb6] {\n  width: 230px;\n}\n.container .header .logo-collapse-width[data-v-0866ccb6] {\n  width: 60px;\n}\n.container .header .tools[data-v-0866ccb6] {\n  padding: 0px 23px;\n  width: 14px;\n  height: 60px;\n  line-height: 60px;\n  cursor: pointer;\n}\n.container .main[data-v-0866ccb6] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  position: absolute;\n  top: 80px;\n  bottom: 0px;\n  overflow: hidden;\n}\n.container .main aside[data-v-0866ccb6] {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 230px;\n          flex: 0 0 230px;\n  width: 230px;\n}\n.container .main aside .el-menu[data-v-0866ccb6] {\n  height: 100%;\n}\n.container .main aside .collapsed[data-v-0866ccb6] {\n  width: 60px;\n}\n.container .main aside .collapsed .item[data-v-0866ccb6] {\n  position: relative;\n}\n.container .main aside .collapsed .submenu[data-v-0866ccb6] {\n  position: absolute;\n  top: 0px;\n  left: 60px;\n  z-index: 99999;\n  height: auto;\n  display: none;\n}\n.container .main .menu-collapsed[data-v-0866ccb6] {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 60px;\n          flex: 0 0 60px;\n  width: 60px;\n}\n.container .main .menu-expanded[data-v-0866ccb6] {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 230px;\n          flex: 0 0 230px;\n  width: 230px;\n}\n.container .main .content-container[data-v-0866ccb6] {\n  -webkit-box-flex: 1;\n      -ms-flex: 1;\n          flex: 1;\n  overflow-y: scroll;\n  padding: 20px;\n}\n.container .main .content-container .breadcrumb-container[data-v-0866ccb6] {\n  margin-bottom: 20px;\n}\n.container .main .content-container .breadcrumb-container .title[data-v-0866ccb6] {\n  width: 200px;\n  float: left;\n  color: #475669;\n}\n.container .main .content-container .breadcrumb-container .breadcrumb-inner[data-v-0866ccb6] {\n  float: right;\n}\n.container .main .content-container .content-wrapper[data-v-0866ccb6] {\n  background-color: #fff;\n  -webkit-box-sizing: border-box;\n          box-sizing: border-box;\n}"],sourceRoot:""}])},654:function(n,a,e){var t=e(632);"string"==typeof t&&(t=[[n.i,t,""]]),t.locals&&(n.exports=t.locals);e(547)("41e515d6",t,!0)},677:function(n,a){n.exports={render:function(){var n=this,a=n.$createElement,e=n._self._c||a;return e("el-row",{staticClass:"container"},[e("el-col",{staticClass:"header",attrs:{span:24}},[e("navbar",{staticClass:"userinfo",attrs:{sysName:n.sysName,collapsed:n.collapsed}})],1),n._v(" "),e("el-col",{staticClass:"main",attrs:{span:24}},[e("aside",{class:n.collapsed?"menu-collapsed":"menu-expanded"},[e("sidebar",{staticClass:"sidebar-container"})],1),n._v(" "),e("section",{staticClass:"content-container"},[e("div",{staticClass:"grid-content bg-purple-light"},[e("el-col",{staticClass:"breadcrumb-container",attrs:{span:24}},[e("strong",{staticClass:"title"},[n._v(n._s(n.$route.name))])]),n._v(" "),e("el-col",{staticClass:"content-wrapper",attrs:{span:24}},[e("app-main")],1)],1)])])],1)},staticRenderFns:[]}}});
//# sourceMappingURL=21.60f6c33e71b5cadb389c.js.map