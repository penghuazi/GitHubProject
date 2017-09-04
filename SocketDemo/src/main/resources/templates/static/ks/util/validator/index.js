// require(['jquery','validator'],function(validator) {
//                     require(['validator-cn'])    
//                     resolve(validator)
//                 })  

// console.log(scope)
(function(){
var scope = KS.pathScope('index.js')
define([scope+'validator.js','css!'+scope+'style.css'],function(validator){
    require([scope+'validator-cn.js'])    
    return validator
})
})()