webpackJsonp([4],{568:function(e,t,n){function r(e){n(663)}var o=n(38)(n(625),n(687),r,null,null);e.exports=o.exports},573:function(e,t,n){e.exports={default:n(574),__esModule:!0}},574:function(e,t,n){var r=n(39),o=r.JSON||(r.JSON={stringify:JSON.stringify});e.exports=function(e){return o.stringify.apply(o,arguments)}},577:function(e,t,n){"use strict";n.d(t,"a",function(){return l}),n.d(t,"c",function(){return c}),n.d(t,"b",function(){return u}),n.d(t,"d",function(){return d}),n.d(t,"e",function(){return m}),n.d(t,"f",function(){return f});var r=n(65),o=n.n(r),a=n(212),s=n.n(a),i=n(211),l=function(e){return s.a.post(i.a+"/jade/uorerManage/getMyAllUOrder.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return o.a.resolve(e.data)},function(e){console.log(e)})},c=function(e){return s.a.post(i.a+"/jade/uorerManage/returnedUOrder.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return o.a.resolve(e.data)},function(e){console.log(e)})},u=function(e){return s.a.post(i.a+"/jade/uorerManage/checkComAndRec.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return o.a.resolve(e.data)},function(e){console.log(e)})},d=function(e){return s.a.post(i.a+"/jade/uorerManage/changeUOrderType.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return o.a.resolve(e.data)},function(e){console.log(e)})},m=function(e){return console.log(e),s.a.post(i.a+"/jade/evaluate/selectEvaluate.action",e,{withCredentials:!0,transformRequest:[function(e){var t="";for(var n in e)t+=encodeURIComponent(n)+"="+encodeURIComponent(e[n])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then(function(e){return o.a.resolve(e.data)},function(e){console.log(e)})},f=function(e){return console.log(e),s.a.post(i.a+"/jade/uorerManage/restoreUOrder.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return o.a.resolve(e.data)},function(e){console.log(e)})}},581:function(e,t,n){"use strict";function r(e,t){for(var t=t-(e+"").length,n=0;n<t;n++)e="0"+e;return e}var o=/([yMdhsm])(\1*)/g;t.a={getQueryStringByName:function(e){var t=new RegExp("(^|&)"+e+"=([^&]*)(&|$)","i"),n=window.location.search.substr(1).match(t),r="";return null!=n&&(r=n[2]),t=null,n=null,null==r||""==r||"undefined"==r?"":r},formatDate:{format:function(e,t){return t=t||"yyyy-MM-dd",t.replace(o,function(t){switch(t.charAt(0)){case"y":return r(e.getFullYear(),t.length);case"M":return r(e.getMonth()+1,t.length);case"d":return r(e.getDate(),t.length);case"w":return e.getDay()+1;case"h":return r(e.getHours(),t.length);case"m":return r(e.getMinutes(),t.length);case"s":return r(e.getSeconds(),t.length)}})},parse:function(e,t){var n=t.match(o),r=e.match(/(\d)+/g);if(n.length==r.length){for(var a=new Date(1970,0,1),s=0;s<n.length;s++){var i=parseInt(r[s]);switch(n[s].charAt(0)){case"y":a.setFullYear(i);break;case"M":a.setMonth(i-1);break;case"d":a.setDate(i);break;case"h":a.setHours(i);break;case"m":a.setMinutes(i);break;case"s":a.setSeconds(i)}}return a}return null}}}},582:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{now:0}},props:["endtime"],methods:{formate:function(e){var t=parseInt(e/1e3/3600),n=parseInt((e/1e3-3600*t)/60),r=parseInt(e/1e3-3600*t-60*n);return n<0?"倒计时结束":t>24?(t/24|0)+"天"+n+"分"+r+"秒":n+"分"+r+"秒"}},computed:{time:function(){return this.formate(new Date(this.endtime).getTime()-this.now)}},created:function(){var e=this;e.now=(new Date).getTime(),setInterval(function(){e.now=(new Date).getTime()},1e3)}}},583:function(e,t,n){t=e.exports=n(546)(!0),t.push([e.i,".orange{color:orange}","",{version:3,sources:["C:/Users/crscr/Desktop/Projects/翡翠/Code_role/src/base/counter/counter.vue"],names:[],mappings:"AACA,QACE,YAAc,CACf",file:"counter.vue",sourcesContent:["\n.orange {\n  color: orange;\n}\n"],sourceRoot:""}])},584:function(e,t,n){var r=n(583);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);n(547)("468806f9",r,!0)},585:function(e,t,n){function r(e){n(584)}var o=n(38)(n(582),n(586),r,null,null);e.exports=o.exports},586:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement;return(e._self._c||t)("span",{staticClass:"orange"},[e._v(e._s(e.time))])},staticRenderFns:[]}},625:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n(136),o=n.n(r),a=n(68),s=n.n(a),i=n(573),l=n.n(i),c=n(577),u=n(91),d=n(581),m=n(585),f=n.n(m),p=l()({type:1});t.default={data:function(){return{filters:{name:""},totalData:[],orders:[],total:0,page:1,rules:sessionStorage.getItem("rules"),pageSize:10,listLoading:!1,showFormVisible:!1,showLoading:!1,addFormVisible:!1,addForm:{orderId:"",expressCompany:"",expressId:""},addFormRules:{expressCompany:[{required:!0,message:"请输入快递公司",trigger:"blur"}],expressId:[{required:!0,message:"请输入快递单号",trigger:"blur"}]},showForm:{cColor:"",rAddress:"",cName:"",rName:"",rTelephone:"",cPrice:"",rCity:"",cSize:"",cImg:""}}},computed:s()({},n.i(u.b)(["user"])),methods:{getTopics:function(){var e=this;this.listLoading=!0,n.i(c.a)(p).then(function(t){t.success?e.setTopics(t.result.data):e.$confirm(t.result.error,"提示",{type:"warning"}).then(function(){e.$router.push("/login")}),e.listLoading=!1})},setTopics:function(e){this.totalData=e.reverse(),e.map(function(t,n){var r=+new Date(t.orderTime)+36e5;e[n].endTime=d.a.formatDate.format(new Date(r),"yyyy/MM/dd hh:mm:ss")}),this.total=Math.ceil(this.totalData.length/10),this.orders=e.slice(this.page-1,10)},filterData:function(){var e=this,t=[];n.i(c.a)(p).then(function(n){if(n.success){if(e.setTopics(n.result.data),!e.filters.name)return;e.totalData.map(function(n,r){for(var o in n)if(t.indexOf(o)<0){var a=n[o]+"";if(a.indexOf(e.filters.name)>=0){t.push(n);break}}}),e.setTopics(t)}})},handleCurrentChange:function(e){this.page=e-1;for(var t=[],n=10*(e-1);n<10*e;n++)this.totalData[n]&&t.push(this.totalData[n]);this.orders=t},handelShow:function(e){var t=this,r=l()({orderId:e});n.i(c.b)(r).then(function(e){t.showForm=o()({},e.result),t.showFormVisible=!0},function(e){console.log(e)})},handleSend:function(e){this.addForm.orderId=e,this.addFormVisible=!0},handleDel:function(e){var t=this;this.$confirm("确认退单吗?","提示",{type:"warning"}).then(function(){t.listLoading=!0;var r={orderId:e};n.i(c.c)(r).then(function(e){t.listLoading=!1,e.success?t.$message({message:"退单成功",type:"success"}):t.$message.error("退单失败"),t.getTopics(),t.handleCurrentChange(t.page)})}).catch(function(){})},sendAction:function(){var e=this;this.$refs.addForm.validate(function(t){t&&e.$confirm("确认发货吗?","提示",{type:"success"}).then(function(){e.listLoading=!0;var t=l()(e.addForm);n.i(c.d)(t).then(function(t){e.listLoading=!1,t.success?e.$message({message:"发货成功",type:"success"}):e.$message.error("发货失败"),e.addFormVisible=!1,e.getTopics()})}).catch(function(){})})}},mounted:function(){this.getTopics()},components:{Counter:f.a}}},641:function(e,t,n){t=e.exports=n(546)(!0),t.push([e.i,"","",{version:3,sources:[],names:[],mappings:"",file:"send.vue",sourceRoot:""}])},663:function(e,t,n){var r=n(641);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);n(547)("4cbbe024",r,!0)},687:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("section",[n("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[n("el-form",{attrs:{inline:!0,model:e.filters}},[n("el-form-item",[n("el-input",{attrs:{placeholder:"搜索"},model:{value:e.filters.name,callback:function(t){e.filters.name=t},expression:"filters.name"}})],1),e._v(" "),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.filterData}},[e._v("查询")])],1)],1)],1),e._v(" "),n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%"},attrs:{data:e.orders,"highlight-current-row":""}},[n("el-table-column",{attrs:{prop:"oId",label:"订单编号",align:"center",width:"230"}}),e._v(" "),n("el-table-column",{attrs:{prop:"cName",label:"物品名称",align:"center",width:"140"}}),e._v(" "),n("el-table-column",{attrs:{prop:"rName",label:"买家名称",align:"center",width:"140"}}),e._v(" "),n("el-table-column",{attrs:{prop:"rTelephone",label:"买家电话",align:"center",width:"140"}}),e._v(" "),n("el-table-column",{attrs:{prop:"orderTime",label:"下单时间",align:"center",width:"200"}}),e._v(" "),n("el-table-column",{attrs:{label:"自动关闭倒计时",align:"center",width:"140"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.endTime?n("counter",{attrs:{endtime:t.row.endTime}}):e._e()]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"操作",align:"center","min-width":"220"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{directives:[{name:"show",rawName:"v-show",value:e.rules.indexOf("01010101")>=0,expression:"rules.indexOf('01010101') >= 0"}],attrs:{type:"info",size:"small"},on:{click:function(n){e.handelShow(t.row.oId)}}},[e._v("查看\n        ")]),e._v(" "),n("el-button",{directives:[{name:"show",rawName:"v-show",value:e.rules.indexOf("01010102")>=0,expression:"rules.indexOf('01010102') >= 0"}],attrs:{type:"success",size:"small"},on:{click:function(n){e.handleSend(t.row.oId)}}},[e._v("发货\n        ")]),e._v(" "),n("el-button",{directives:[{name:"show",rawName:"v-show",value:e.rules.indexOf("01010103")>=0,expression:"rules.indexOf('01010103') >= 0"}],attrs:{type:"danger",size:"small"},on:{click:function(n){e.handleDel(t.row.oId)}}},[e._v("退单\n        ")])]}}])})],1),e._v(" "),n("el-col",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],staticClass:"toolbar",attrs:{span:24}},[n("el-pagination",{staticStyle:{float:"right"},attrs:{layout:"prev, pager, next","current-page":e.page,"page-size":e.pageSize,total:e.total*e.pageSize},on:{"update:currentPage":function(t){e.page=t},"current-change":e.handleCurrentChange}})],1),e._v(" "),n("el-dialog",{attrs:{title:"查看","close-on-click-modal":!1},model:{value:e.showFormVisible,callback:function(t){e.showFormVisible=t},expression:"showFormVisible"}},[n("el-form",{ref:"editForm",attrs:{model:e.showForm,"label-width":"120px"}},[n("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"0"!==e.showForm.img,expression:"showForm.img!=='0'"}],attrs:{label:"图片："}},[n("div",{staticClass:"block",attrs:{width:"300",height:"300"}},[n("el-carousel",{attrs:{trigger:"click"}},e._l(e.showForm.img,function(e){return n("el-carousel-item",{key:e},[n("img",{staticStyle:{width:"100%",height:"100%"},attrs:{src:e}})])}))],1)]),e._v(" "),n("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"0"!==e.showForm.video,expression:"showForm.video !=='0'"}],attrs:{label:"视频："}},[n("video",{attrs:{src:e.showForm.video,controls:""}})]),e._v(" "),n("el-form-item",{attrs:{label:"名字："}},[n("div",[e._v(e._s(e.showForm.cName))])]),e._v(" "),n("el-form-item",{attrs:{label:"颜色："}},[n("div",[e._v(e._s(e.showForm.cColor))])]),e._v(" "),n("el-form-item",{attrs:{label:"价格："}},[n("div",[e._v(e._s(e.showForm.cPrice))])]),e._v(" "),n("el-form-item",{attrs:{label:"尺寸："}},[n("div",[e._v(e._s(e.showForm.cSize))])]),e._v(" "),n("el-form-item",{attrs:{label:"买家："}},[n("div",[e._v(e._s(e.showForm.rName))])]),e._v(" "),n("el-form-item",{attrs:{label:"买家电话："}},[n("div",[e._v(e._s(e.showForm.rTelephone))])]),e._v(" "),n("el-form-item",{attrs:{label:"买家地址："}},[n("div",[e._v(e._s(e.showForm.rCity)+e._s(e.showForm.rAddress))])])],1)],1),e._v(" "),n("el-dialog",{attrs:{title:"添加",size:"tiny","close-on-click-modal":!1},model:{value:e.addFormVisible,callback:function(t){e.addFormVisible=t},expression:"addFormVisible"}},[n("el-form",{ref:"addForm",attrs:{model:e.addForm,inline:!0,"label-width":"120px",rules:e.addFormRules}},[n("el-form-item",{attrs:{label:"快递公司：",prop:"expressCompany"}},[n("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addForm.expressCompany,callback:function(t){e.addForm.expressCompany=t},expression:"addForm.expressCompany"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"快递编号：",prop:"expressId"}},[n("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addForm.expressId,callback:function(t){e.addForm.expressId=t},expression:"addForm.expressId"}})],1)],1),e._v(" "),n("div",{staticStyle:{"text-align":"center"}},[n("el-button",{attrs:{type:"primary"},nativeOn:{click:function(t){e.sendAction(t)}}},[e._v("发货")])],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=4.26ff0298860d852dd508.js.map