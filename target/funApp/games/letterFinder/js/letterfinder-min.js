var validated=false;
var width=(window.innerWidth>0)?window.innerWidth:screen.width;
function setValidate(a){if(a==null||""==a){validated=false
}else{validated=true
}}function setIcon(){if(width<=840||validated){document.getElementById("text").innerHTML='<h1>Fun App - Explore Urself <i class="fa fa-hand-o-down" style="font-size:36px;color:red"></i></h1><h3><i>Search By Letter(s) and Category<i></h3>'
}}function validate(b,e){var d,c,a;
var c=false;
if(validated){d=document.getElementById(b);
c=validateSC(d);
a=document.getElementById(e);
catValue=a.value;
if(catValue==null||catValue.trim()==""){c=c&&false
}if(!c){alert("Empty values not allowed. Please provide required input.")
}}else{alert("Don't run from maths...Please solve above math before proceeding.")
}return c
}function validateSC(f){var e,g,d;
e=f.value;
g=[];
d=[];
if(e!=null&&""!=e.trim()){g=e.split(",");
for(var b=0;
b<g.length;
b++){if(g[b].length>1){var c=(g[b]).split("");
for(var a=0;
a<c.length;
a++){d.push(c[a].trim())
}}else{d.push(g[b].trim())
}}}else{return false
}f.value=removeDups(d).toString();
return true
}function removeDups(b){var a={};
b.forEach(function(c){if(!a[c]){a[c]=true
}});
return Object.keys(a)
}var ans;
var tries=0;
var solve=false;
function generateNum(eleId){if(!validated){var ele=document.getElementById(eleId);
ele.innerHTML="";
if(tries<10){var num1=Math.floor(Math.random()*10+1);
var num2=Math.floor(Math.random()*10+1);
var operendArray=["*","+","-"];
var op=operendArray[Math.floor(Math.random()*operendArray.length)];
ans=eval(num1+op+num2);
var msg="Hey! not a robot? First, Solve the Math <br> <i style='color:red;padding:2px'>(This will enable the input boxes)</i>";
if(tries>=1&&tries<10){msg="That is not correct.Try Again!"
}ele.innerHTML=msg+"<br>"+num1+op+num2+"= <input type=\"text\" id='ans' name=\"ans\" style=\"width:62px\"> <input type='submit' value='Done' style='width:74px;' onClick=\"checkAns('ans')\">"
}else{ele.innerHTML="<H1>Hey! if u r not a robot, ur intentions are doubtful. Start afresh to explore. </H1>";
ele.style.position="absolute";
ele.style.width="450px";
ele.style.top="266px";
ele.style.left="8px";
ele.style.fontSize="8px";
var searchEle=document.getElementById("search");
search.style.display="none";
ele.style.border="2px solid"
}}else{document.getElementById("letters").disabled=false;
document.getElementById("category").disabled=false;
document.getElementById(eleId).style.display="none";
document.getElementById("heading").style.height="180px"
}}function checkAns(c){var b=document.getElementById(c);
if(b.value!=""&&ans==b.value){solve=true;
var a=document.getElementById("robot");
a.style.marginTop="33px";
a.innerHTML="<span style='padding:10px; text-align:center;color:#f000f0' ><i><b>That's correct. Continue exploring...</b></i></span><br><span style='color:red;font-size:14px;padding:10px;'>(<a link='/funApp/games/letterFinder/read.jsp' href='#' onClick='getInfo(this)'>Read Me </a>)  </span>";
document.getElementById("category").disabled=false;
document.getElementById("letters").disabled=false;
seedInfo()
}else{tries+=1;
generateNum("robot")
}}function prepareRefinements(a){document.getElementById("refinements").style.display="block"
}function displayRefinements(){var c=document.getElementById("category");
var b=c.options[c.selectedIndex].value;
var a=b.split(":");
document.getElementById("displayRefinements:"+a[0]).style.display="block"
}var popup=document.getElementById("popup");
function getInfo(b){var a=b.getAttribute("link");
document.getElementById("popup").style.display="block";
var c=new XMLHttpRequest();
c.onreadystatechange=function(){if(this.readyState==4&&this.status==200){validated=true;
document.getElementById("popup").innerHTML=this.responseText;
document.getElementById("popup").style.display="block"
}};
c.open("GET",a,true);
c.send()
}function closeOnClick(){document.getElementById("popup").style.display="none"
}window.onclick=function(a){if(a.target==document.getElementById("popup")){document.getElementById("popup").style.display="none"
}};
function seedInfo(){var a=new XMLHttpRequest();
a.onreadystatechange=function(){if(this.readyState==4&&this.status==200){validated=true;
document.getElementById("text").innerHTML='<h1>Fun App - Explore Urself <i class="fa fa-hand-o-down" style="font-size:36px;color:red"></i></h1><h3><i>Search By Letter(s) and Category<i></h3>'
}};
a.open("GET","/funApp/explore?v=true",true);
a.send()
};