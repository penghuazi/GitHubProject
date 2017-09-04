/**
 * 模块配置
 */
var scope = KS.pathScope('config.js')

define(function(){
    return function(kspath,ksroot){

        var kspath = kspath || scope
        return {

            // iconfont 字体样式
            'iconfont':scope+'font-icon/iconfont',
            'CSS': scope+'util/require-css',
            'Vue': scope+'util/vue.min',
            // 'axios':scope+'util/axios',
            // 'qs':scope+'util/qs',
            'jquery': scope+'util/jquery.min',
            'validator':scope+'util/validator/index',


            'component-KsDatePicker':{
                js:kspath+'components/ksdatepicker/index',
                css:kspath+'components/ksdatepicker/style'
            },
            'component-KsDateRangePicker':{
                js:kspath+'components/ksdaterangepicker/index.1.0.0',
                css:kspath+'components/ksdatepicker/style'
             },
            'component-KsPage': {
                js:kspath+'components/kspage/index',
                css:kspath+'components/kspage/style'
            },
            'component-KsPageGroup': {
                js:kspath+'components/kspagegroup/index.1.0.0',
                css:kspath+'components/kspagegroup/style'
            },
            'component-KsDialog': {
                js:kspath+'components/ksdialog/index',
                css:kspath+'components/ksdialog/style'
            },
            'component-KsModal': {
                js:kspath+'components/ksmodal/index',
                css:kspath+'components/ksmodal/style'
            },
            'component-KsModalEntity': {
                js:kspath+'components/ksmodalentity/index',
                css:kspath+'components/ksmodalentity/style'
            },
            'component-KsModalCenter': {
                js:kspath+'components/ksmodalcenter/index',
                css:kspath+'components/ksmodalcenter/style'
            },
            'component-KsNoticeCenter': {
                js:kspath+'components/ksnoticecenter/index',
                css:kspath+'components/ksnoticecenter/style'
            },
            'component-KsImage': {
                js:kspath+'components/ksimage/index',
                css:kspath+'components/ksimage/style'
            },
            'component-KsImgs': {
                js:kspath+'components/ksImgs/index.1.0.0',
                css:kspath+'components/ksImgs/style.1.0.0'
            },
            'directive-KsLimitNumberFixed':kspath+'directives/kslimitnumberfixed/index'
            
        }    

    }
 })