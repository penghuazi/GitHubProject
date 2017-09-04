/**
 * markdown 编辑器
 * author zdzDesigner
 * 2017.03.23
 */
(function(){
var scope = KS.pathScope('index.js')
define(['css!'+scope+'md.css'
        ,scope+'markdown.js'
        ,scope+'highlight.min.js'
        ],function(css,markdownit,highlight){

    var md = new markdownit({
        highlight: function(str, lang) {
            // console.log(lang)
          if (lang && hljs.getLanguage(lang)) {
            try {
              return '<pre class="ks-hljs"><code>' +
                hljs.highlight(lang, str, true).value +
                '</code></pre>';
            } catch (err) {}
          }

          return '<pre class="ks-hljs"><code>' + md.utils.escapeHtml(str) + '</code></pre>';
        }
    })

    
    md.renderer.rules.table_open = function(){
        return '<div class="table-striped"><table class="table-entity">';
    }
    md.renderer.rules.table_close = function(){
        return '</table></div>';
    }



    var originData = assetMD.value
    var originDataClone = originData
    
    execScript(originData)
    
    var result = md.render(originData);
    
    result = compileTag(result)

    renderMD.innerHTML = result

    assetMD.addEventListener('input',function(){
        // assetMD.value = originDataClone
        // console.log('ss')
        // return
        var originData = assetMD.value
        var originDataClone = originData
        
        execScript(originData)
        
        var result = md.render(originData);
        
        result = compileTag(result)
        // console.log(result)
        renderMD.innerHTML = result
    })

    setTimeout(function(){
        assetMD.value = originDataClone
    },1000)
    


    /**
     * [execScript 提出<script exec="true">.*</script>内容执行]
     * @param  {[type]} data [textarea.value]
     * @return {[type]}      [undefined]
     */
    function execScript(data){
        var reg = /<script.*exec="true"+.*>([\s\S]+?)<\/script>/gm
        var arr = data.match(reg)
        
        arr && arr.forEach(function(item){
            // console.log(item);
            data = data.replace(reg,'')
            var val = reg.exec(item)
            // console.log(val[0])
            if(val[1]){
                loadScript(val[1])
            }
        })

    }

    /**
     * [compileTag 编译节点]
     * @param  {[type]} data [markdown render 后的 data]
     * @return {[type]}      [替换后的值]
     */
    function compileTag(data){
        var index = 0 , temp = {}
        data = data.replace(/<code>([\s\S]+?)<\/code>/gm,function(){
            // console.log(arguments)
            var key = '_@@/'+index+'_@/@'
            temp[key] = arguments[0]
            index++
            return key
        })
        
        data = data.replace(/&lt;/g,'<')
                    .replace(/&gt;/g,'>')
                    .replace(/&quot;/g,'"')
        
        Object.keys(temp)
            .forEach(function(key){
                // console.log(key)
                data = data.replace(key,temp[key])
            })

        return data
    }
    
    function loadScript(innerHTML){
        var script  = document.createElement("script");
        script.text = innerHTML;
        document.body.appendChild(script)
    }

})  
})()