webpackJsonp([15],{555:function(e,t,o){function a(e){o(662)}var r=o(38)(o(612),o(686),a,null,null);e.exports=r.exports},580:function(e,t,o){"use strict";o.d(t,"f",function(){return l}),o.d(t,"i",function(){return d}),o.d(t,"a",function(){return u}),o.d(t,"b",function(){return c}),o.d(t,"g",function(){return p}),o.d(t,"e",function(){return m}),o.d(t,"n",function(){return h}),o.d(t,"o",function(){return f}),o.d(t,"c",function(){return g}),o.d(t,"l",function(){return v}),o.d(t,"m",function(){return C}),o.d(t,"j",function(){return y}),o.d(t,"k",function(){return A}),o.d(t,"q",function(){return b}),o.d(t,"r",function(){return x}),o.d(t,"d",function(){return w}),o.d(t,"h",function(){return F}),o.d(t,"p",function(){return _});var a=o(65),r=o.n(a),i=o(212),n=o.n(i),s=o(211),l=function(e){return n.a.post(s.a+"/jade/commodityManage/selectCommosityByCid.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},d=function(){return n.a.post(s.a+"/jade/commodityManage/getCommodityList.action",{},{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},u=function(){return n.a.post(s.a+"/jade/commodityManage/getCommoditysoldOut.action",{},{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},c=function(e){return n.a.post(s.a+"/jade/commodityManage/soldOutAndPutAway.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},p=function(e){return n.a.post(s.a+"/jade/commodityManage/delCommodity.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},m=function(e){return n.a.post(s.a+"/jade/commodityManage/getSecondByFirst.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},h=function(e){return n.a.post(s.a+"/jade/commodityManage/addCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},f=function(e){return n.a.post(s.a+"/jade/commodityManage/addSecondCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},g=function(e){return n.a.post(s.a+"/jade/commodityManage/getFirstCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},v=function(e){return n.a.post(s.a+"/jade/commodityManage/delCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},C=function(e){return n.a.post(s.a+"/jade/commodityManage/delSecondCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},y=function(e){return n.a.post(s.a+"/jade/commodityManage/getAllSecondCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},A=function(e){return n.a.post(s.a+"/jade/commodityManage/addSecondByFirst.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},b=function(e){return n.a.post(s.a+"/jade/commodityManage/updateSecond.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},x=function(e){return n.a.post(s.a+"/jade/commodityManage/addCommodity.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},w=function(e){return n.a.post(s.a+"/jade/commodity/getCondition.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},F=function(e){return n.a.post(s.a+"/jade/commodityManage/updataCommodity.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})},_=function(e){return n.a.post(s.a+"/jade/commodityManage/updateCategory.action",e,{withCredentials:!0,headers:{"Content-Type":"application/json"}}).then(function(e){return r.a.resolve(e.data)},function(e){console.log(e)})}},612:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=o(580),r=o(211);t.default={data:function(){return{total:0,page:1,pageSize:10,uploadServer:r.b,isPull:!1,options:[{value:"0",label:"管理员"},{value:"1",label:"代理账号"},{value:"3",label:"普通用户"}],dialogImageUrl:"",dialogVisible:!1,value:"",videoOrPhotos:"0",firstCategoryOption:[],sectionCategoryOption:[],waterOption:[],colorOption:[],ruleForm:{name:"",size:"",price:"",firstId:"",secondId:"",time:"",color:"",describe:"",imageText:"",img:"",video:"",status:"1"},uploadData:{},rules:{firstId:[{required:!0,message:"请输入一级类别",trigger:"blur"}],secondId:[{required:!0,message:"请输入二级类别",trigger:"blur"}],name:[{required:!0,message:"请输入商品名称",trigger:"blur"}],size:[{required:!0,message:"请输入圈口",trigger:"blur"}],price:[{required:!0,message:"请输入价格",trigger:"blur"},{min:1,max:8,message:"不能超过8位数",trigger:"blur"}],time:[{required:!0,message:"请输入上架时间",trigger:"blur"},{validator:function(e,t,o){t<0?o(new Error("不可以小于0")):o()},trigger:"blur"}],color:[{required:!0,message:"请选择颜色",trigger:"blur"}],describe:[{required:!0,message:"请输入内容",trigger:"change"}],status:[{required:!0,message:"请选择上下架",trigger:"change"}]},fileList:[],videoUrl:"",videoPostUrl:"",uploadVideoPost:"",videoLoading:!1,uploadImg:[]}},methods:{handleAvatarSuccess:function(e,t,o){this.uploadImg=o},beforeUpload:function(e){return e.size>6291456?(this.$message({type:"error",message:"图片不可以超过6MB一张",duration:1e3}),!1):this.uploadImg.length>9?(this.$message({type:"error",message:"最多上传9张图片",duration:1e3}),!1):void 0},handleRemove:function(e,t){this.ruleForm.img="",this.uploadImg=t},handleVideoPostSuccess:function(e,t){this.videoPostUrl=URL.createObjectURL(t.raw),this.uploadVideoPost=e.result.key},getFirst:function(){var e=this;this.listLoading=!0,o.i(a.c)({}).then(function(t){e.firstCategoryOption=t.result.data,e.listLoading=!1})},init:function(){this.getFirst(),this.getWaterAndColor()},getWaterAndColor:function(){var e=this;this.listLoading=!0,o.i(a.d)({}).then(function(t){e.waterOption=t.result.water,e.colorOption=t.result.color,e.listLoading=!1})},handleImageText:function(e,t,o){this.fileList=[];for(var a=0;a<o.length;a++)this.fileList.push(o[a].response.result.key);this.ruleForm.imageText=this.fileList.join(","),this.fileList.push(e.result.key)},handleRemoveImageText:function(e,t){this.fileList=[];for(var o=0;o<t.length;o++)this.fileList.push(t[o].response.result.key);this.ruleForm.imageText=this.fileList.join(","),this.ruleForm.imageText=""},addAction:function(){var e=this;if(this.validate()){if("1"===this.videoOrPhotos){if(!this.ruleForm.video)return void this.$message({showClose:!0,message:"请选择要上传的视频",type:"error"});if(!this.uploadVideoPost)return void this.$message.error("请先上传视频封面");this.ruleForm.video=this.ruleForm.video+","+this.uploadVideoPost}else this.ruleForm.video="0";this.$refs.ruleForm.validate(function(t){if(t){if(e.showLoading=!0,e.uploadData.size=(1*e.uploadData.size).toFixed("1"),e.uploadData.size>100)return void e.$message.error("size只能是1-100");var r=e.uploadData;o.i(a.r)(r).then(function(t){t.success?e.$confirm("新增商品成功","提示",{type:"success"}).then(function(){e.$router.push("/goods/list")}):e.$confirm(t.result.error,"提示",{type:"warning"}).then(function(){}),e.showLoading=!1})}})}},handleSuccess:function(e){this.ruleForm.img=e.result.key,this.ruleForm.video=""},handleSuccessVideo:function(e,t){this.videoLoading=!1,this.videoUrl=t.url,this.ruleForm.video=e.result.key,this.ruleForm.img="",this.isPull=!1},handleRemove1:function(){this.ruleForm.video="",this.videoUrl="",this.isPull=!1},firstCate:function(e){var t=this;this.listLoading=!0;var r={firstId:e};o.i(a.e)(r).then(function(e){t.sectionCategoryOption=e.result.data,t.listLoading=!1})},beforeVideoUpload:function(e){if(this.isPull||this.ruleForm.video)return this.$message.error("只能上传一个视频"),!1;this.isPull=!0;var t="video/mp4"===e.type,o=e.size/1024/1024<50;return t||this.$message.error("上传视频只能是MP4格式!"),o||this.$message.error("上传视频大小不能超过 50MB!"),t&&o&&(this.videoLoading=!0),t&&o},validate:function(){this.uploadData=this.ruleForm,this.uploadData.videoOrPhotos=this.videoOrPhotos;var e=[];return!this.uploadImg.length&&"0"===this.videoOrPhotos||this.uploadImg.length<3&&"0"===this.videoOrPhotos?(this.$message({type:"error",message:"至少上传3张商品照片",duration:1e3}),!1):this.ruleForm.imageText?(this.uploadImg&&this.uploadImg.map(function(t,o){o<9&&e.push(t.response.result.key)}),this.uploadData.img=e.join(","),!0):(this.$message({type:"error",message:"至少上传1张图文描述",duration:1e3}),!1)}},mounted:function(){this.init()}}},640:function(e,t,o){t=e.exports=o(546)(!0),t.push([e.i,".add{width:800px}.add .footer{text-align:center}.avatar-uploader .el-upload{border:1px dashed #d9d9d9;border-radius:6px;cursor:pointer;background:#fbfdff;position:relative;overflow:hidden}.avatar-uploader .el-upload:hover{border-color:#20a0ff}.avatar-uploader-icon{font-size:28px;color:#8c939d;width:148px;height:148px;line-height:148px;text-align:center}.avatar{width:148px;height:148px;display:block}","",{version:3,sources:["C:/Users/crscr/Desktop/Projects/翡翠/Code_role/src/components/goods/add.vue"],names:[],mappings:"AACA,KACE,WAAa,CACd,AACD,aACE,iBAAmB,CACpB,AACD,4BACE,0BAA2B,AAC3B,kBAAmB,AACnB,eAAgB,AAChB,mBAAoB,AACpB,kBAAmB,AACnB,eAAiB,CAClB,AACD,kCACE,oBAAsB,CACvB,AACD,sBACE,eAAgB,AAChB,cAAe,AACf,YAAa,AACb,aAAc,AACd,kBAAmB,AACnB,iBAAmB,CACpB,AACD,QACE,YAAa,AACb,aAAc,AACd,aAAe,CAChB",file:"add.vue",sourcesContent:["\n.add {\n  width: 800px;\n}\n.add .footer {\n  text-align: center;\n}\n.avatar-uploader .el-upload {\n  border: 1px dashed #d9d9d9;\n  border-radius: 6px;\n  cursor: pointer;\n  background: #fbfdff;\n  position: relative;\n  overflow: hidden;\n}\n.avatar-uploader .el-upload:hover {\n  border-color: #20a0ff;\n}\n.avatar-uploader-icon {\n  font-size: 28px;\n  color: #8c939d;\n  width: 148px;\n  height: 148px;\n  line-height: 148px;\n  text-align: center;\n}\n.avatar {\n  width: 148px;\n  height: 148px;\n  display: block;\n}"],sourceRoot:""}])},662:function(e,t,o){var a=o(640);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);o(547)("3981b898",a,!0)},686:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("section",{staticClass:"add"},[o("el-row",{attrs:{gutter:24}},[o("el-form",{ref:"ruleForm",attrs:{model:e.ruleForm,"label-width":"120px",rules:e.rules}},[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"一级类别",prop:"firstId"}},[o("el-select",{staticStyle:{width:"268px"},attrs:{placeholder:"请选择"},on:{change:e.firstCate},model:{value:e.ruleForm.firstId,callback:function(t){e.ruleForm.firstId=t},expression:"ruleForm.firstId"}},e._l(e.firstCategoryOption,function(e){return o("el-option",{key:e.firstId,attrs:{label:e.name,value:e.firstId}})}))],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"二级类别",prop:"secondId"}},[o("el-select",{staticStyle:{width:"268px"},attrs:{placeholder:"请先选择一级类别"},model:{value:e.ruleForm.secondId,callback:function(t){e.ruleForm.secondId=t},expression:"ruleForm.secondId"}},e._l(e.sectionCategoryOption,function(e){return o("el-option",{key:e.secondId,attrs:{label:e.name,value:e.secondId}})}))],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品名称",prop:"name"}},[o("el-input",{model:{value:e.ruleForm.name,callback:function(t){e.ruleForm.name=t},expression:"ruleForm.name"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品单价",prop:"price"}},[o("el-input",{model:{value:e.ruleForm.price,callback:function(t){e.ruleForm.price=t},expression:"ruleForm.price"}},[o("template",{slot:"append"},[e._v("元")])],2)],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"上架天数",prop:"time"}},[o("el-input",{model:{value:e.ruleForm.time,callback:function(t){e.ruleForm.time=t},expression:"ruleForm.time"}},[o("template",{slot:"append"},[e._v("天")])],2)],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"圈口",prop:"size"}},[o("el-input",{attrs:{type:"number"},model:{value:e.ruleForm.size,callback:function(t){e.ruleForm.size=t},expression:"ruleForm.size"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品颜色",prop:"color"}},[o("el-select",{staticStyle:{width:"268px"},attrs:{placeholder:"请选择"},model:{value:e.ruleForm.color,callback:function(t){e.ruleForm.color=t},expression:"ruleForm.color"}},e._l(e.colorOption,function(e){return o("el-option",{key:e,attrs:{label:e,value:e}})}))],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"是否上架"}},[o("el-radio",{staticClass:"radio",attrs:{label:"1"},model:{value:e.ruleForm.status,callback:function(t){e.ruleForm.status=t},expression:"ruleForm.status"}},[e._v("上架")]),e._v(" "),o("el-radio",{staticClass:"radio",attrs:{label:"0"},model:{value:e.ruleForm.status,callback:function(t){e.ruleForm.status=t},expression:"ruleForm.status"}},[e._v("下架")])],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"商品描述",prop:"describe"}},[o("el-input",{attrs:{type:"textarea",autosize:{minRows:3,maxRows:4},placeholder:"请输入内容"},model:{value:e.ruleForm.describe,callback:function(t){e.ruleForm.describe=t},expression:"ruleForm.describe"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"视频/图片",prop:"principal"}},[o("el-radio",{staticClass:"radio",attrs:{label:"0"},model:{value:e.videoOrPhotos,callback:function(t){e.videoOrPhotos=t},expression:"videoOrPhotos"}},[e._v("图片")]),e._v(" "),o("el-radio",{staticClass:"radio",attrs:{label:"1"},model:{value:e.videoOrPhotos,callback:function(t){e.videoOrPhotos=t},expression:"videoOrPhotos"}},[e._v("视频")])],1)],1),e._v(" "),o("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"!==e.videoOrPhotos,expression:"videoOrPhotos !== '1'"}],attrs:{span:24}},[o("el-form-item",{attrs:{label:"商品图片"}},[o("div",{staticStyle:{color:"#f00","font-weight":"600"}},[e._v("请上传750px * 750px 以上比例商品图片，图片和视频选一即可。")]),e._v(" "),o("el-upload",{attrs:{"list-type":"picture-card",name:"image",multiple:"",action:e.uploadServer+"/jade/image/uploadImage.action","before-upload":e.beforeUpload,"on-success":e.handleAvatarSuccess,"on-remove":e.handleRemove}},[o("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),o("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===e.videoOrPhotos,expression:"videoOrPhotos === '1'"}],attrs:{span:24}},[o("el-form-item",{attrs:{label:"商品视频",prop:"principal"}},[o("div",{staticStyle:{color:"#f00","font-weight":"600"}},[e._v("请上传播放时间为30s的商品视频，图片和视频选一即可")]),e._v(" "),o("el-upload",{staticClass:"upload-demo",staticStyle:{width:"300px"},attrs:{drag:"",action:e.uploadServer+"/jade/image/uploadVideo.action",name:"image","before-upload":e.beforeVideoUpload,"on-success":e.handleSuccessVideo,"on-remove":e.handleRemove1}},[o("i",{staticClass:"el-icon-upload"}),e._v(" "),o("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),o("em",[e._v("点击上传")])]),e._v(" "),o("div",{staticClass:"el-upload__tip",slot:"tip"},[e._v("只能上传mp4文件，且不超过50MB")])]),e._v(" "),e.videoUrl?o("video",{staticClass:"avatar",attrs:{src:e.videoUrl,controls:""}}):e._e()],1)],1),e._v(" "),o("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===e.videoOrPhotos,expression:"videoOrPhotos === '1'"}],attrs:{span:24}},[o("el-form-item",{attrs:{label:"视频封面"}},[o("el-upload",{staticClass:"avatar-uploader",attrs:{action:e.uploadServer+"/jade/image/uploadImage.action","show-file-list":!1,name:"image","on-success":e.handleVideoPostSuccess}},[e.videoPostUrl?o("img",{staticClass:"avatar",attrs:{src:e.videoPostUrl}}):o("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"图文描述",prop:"imageText"}},[o("el-upload",{attrs:{action:e.uploadServer+"/jade/image/uploadImage.action","list-type":"picture-card","on-success":e.handleImageText,name:"image",multiple:"","on-remove":e.handleRemoveImageText}},[o("i",{staticClass:"el-icon-plus"})]),e._v(" "),o("el-dialog",{attrs:{size:"tiny"},model:{value:e.dialogVisible,callback:function(t){e.dialogVisible=t},expression:"dialogVisible"}},[o("img",{attrs:{width:"100%",src:e.dialogImageUrl,alt:""}})])],1)],1)],1)],1),e._v(" "),o("div",{staticClass:"footer"},[o("el-button",{attrs:{type:"primary"},nativeOn:{click:function(t){e.addAction(t)}}},[e._v("提交")])],1),e._v(" "),o("el-row",{staticStyle:{"padding-bottom":"0px"},attrs:{gutter:24}})],1)},staticRenderFns:[]}}});
//# sourceMappingURL=15.c18a18610d4ca8119bb6.js.map