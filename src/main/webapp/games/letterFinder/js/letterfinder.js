var validated = false;
var width = (window.innerWidth > 0) ? window.innerWidth : screen.width;

function setValidate(value){
	if(value == null || ""==value){
		validated = false;
	}else{
		validated=true;
	}
	
}

function setIcon(){
  /* if(!validated){	*/
	if(width<=840 ||validated ){
		 document.getElementById("text").innerHTML = '<h1>Fun App - Explore Urself <i class="fa fa-hand-o-down" style="font-size:36px;color:red"></i></h1><h3><i>Search By Letter(s) and Category<i></h3>'
	     /* document.getElementById("withEle").stype.display="none";*/
	}
}

function validate(ele1,ele2){
	var sc,ret,cat;
	var ret = false;
    if(validated){
	sc = document.getElementById(ele1);
	ret = validateSC(sc);
	 
    cat = document.getElementById(ele2);
	  catValue = cat.value;
	 if(catValue == null || catValue.trim()=='' )
		 ret = ret && false;
	 if(!ret) alert("Empty values not allowed. Please provide required input.");
    }else{
    	alert("Don't run from maths...Please solve above math before proceeding.");
    }
	 return ret;
}

function validateSC(sc){
	var value,letters,newletters;
	value = sc.value;
	letters = []; 
	newletters=[];
	
	if(value!=null && ""!=value.trim()){
	   letters = value.split(',')
	   for(var i=0;i<letters.length;i++){
          if(letters[i].length>1){
        	var all =  (letters[i]).split('')
        	 for(var j=0;j<all.length;j++)
        	  newletters.push(all[j].trim());
          }else{
        	  newletters.push(letters[i].trim());
          }		   
	   } 	
	}else{
		return false;
	}
	sc.value = removeDups(newletters).toString();
    return true;
}

function removeDups(letters) {
	  var unique = {};
	 letters.forEach(function(i) {
	    if(!unique[i]) {
	      unique[i] = true;
	    }
	  });
	  return Object.keys(unique);
	}

var ans 
var tries = 0
var solve = false;
function generateNum(eleId){
	if(!validated){
  var ele = document.getElementById(eleId);
	ele.innerHTML = "";
 
  if(tries<10){	
	
  var num1 = Math.floor(Math.random()*10 +1)
  var num2 = Math.floor(Math.random()*10 +1)
  var operendArray = ["*","+","-" ]
  var op = operendArray[Math.floor(Math.random()*operendArray.length)]
  ans = eval(num1 + op + num2);
  var msg = "Hey! not a robot? First, Solve the Math <br> <i style='color:red;padding:2px'>(This will enable the input boxes)</i>"
  if(tries>=1 && tries<10){
	  msg =  "That is not correct.Try Again!"
  }
	   
  ele.innerHTML = msg + "<br>" + num1 + op + num2 + "= <input type=\"text\" id='ans' name=\"ans\" style=\"width:62px\"> <input type='submit' value='Done' style='width:74px;' onClick=\"checkAns(\'ans\')\">" 
  
  }else{
	 ele.innerHTML = "<H1>Hey! if u r not a robot, ur intentions are doubtful. Start afresh to explore. </H1>"
	 ele.style.position="absolute";
	 ele.style.width="450px";
	 ele.style.top="266px";
	 ele.style.left="8px";	 
	 ele.style.fontSize="8px";
     var searchEle = document.getElementById('search')
	  search.style.display="none";
	 ele.style.border = "2px solid";
  }
 } else{
	 
	 document.getElementById('letters').disabled = false;
	 document.getElementById('category').disabled =false;
	 document.getElementById(eleId).style.display="none";;
	 document.getElementById("heading").style.height="180px";;
	 
 }
}

function checkAns(ele){
	var inputEle = document.getElementById(ele);
	if(inputEle.value!="" && ans == inputEle.value){
		solve =true;
		
		var ele1 = document.getElementById("robot");
		    ele1.style.marginTop="33px" 
		    ele1.innerHTML="<span style='padding:10px; text-align:center;color:#f000f0' ><i><b>That's correct. Continue exploring...</b></i></span><br><span style='color:red;font-size:14px;padding:10px;'>(<a link='/funApp/games/letterFinder/read.jsp' href='#' onClick='getInfo(this)'>Read Me </a>)  </span>"
		    document.getElementById('category').disabled =false;
			document.getElementById('letters').disabled = false;
			
			
			/*document.getElementById('validated').value=true;*/
			seedInfo();   
	}else{
		tries +=1
		generateNum('robot');
	}
}

/*var inputele = document.getElementById("ans");
inputele.addEventListener("focusout", function() {
	alert("in");
   checkAns(this)
   
}); 
*/

function prepareRefinements(value){
	  
	   //alert(value);
	   //var split = value.split(":");
	   //alert(split[0]);
	  // var categories = '${categories}';
	   //alert(categories);
	   
	   //var something = categories[split[0]];
	   //alert(something);
	   document.getElementById('refinements').style.display = 'block';
	   
}

function displayRefinements(){
	   //alert("here");
	   var e = document.getElementById("category");
	   var selectedValue = e.options[e.selectedIndex].value;
	   var split = selectedValue.split(":");
	   //alert(split[0])
	   document.getElementById('displayRefinements:' + split[0]).style.display = 'block';
	   
	   //document.getElementById('displayRefinements:').style.display = 'block';
	   
}

 var popup = document.getElementById("popup");
function getInfo(ele){
    
	 var url = ele.getAttribute("link");
	 document.getElementById("popup").style.display="block"; 
	  
	 var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     //DO nothing
	    	validated = true;
	    	//TODO: get the info in a popup.
	    	document.getElementById("popup").innerHTML =  this.responseText;
	    	document.getElementById("popup").style.display="block";
	    }
	  };
	  xhttp.open("GET", url, true);
	  xhttp.send();
	
}



//var close = document.getElementById("close");

function closeOnClick() {
	document.getElementById("popup").style.display = "none";
}

window.onclick = function(event) {
	  if (event.target == document.getElementById("popup")) {
		  document.getElementById("popup").style.display = "none";
	  }
	}


function seedInfo() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     //DO nothing
	    	validated = true;
	        document.getElementById("text").innerHTML = '<h1>Fun App - Explore Urself <i class="fa fa-hand-o-down" style="font-size:36px;color:red"></i></h1><h3><i>Search By Letter(s) and Category<i></h3>'
	    }
	  };
	  xhttp.open("GET", "/funApp/explore?v=true", true);
	  xhttp.send();
	}