<%@include file="header.jsp"%>
  
   <div id="form">
      <form  method="POST" action="${pageContext.request.contextPath}/admin}">
         
        <fieldset>
          
          <label>Comment</label>
          <textarea id="comment" name="comment" />

          <label>Key</label>
          <input type="text" name="key" id="key" />
          
          <label>Value("," separated) </label>
          <textarea id="value" name="value" / >
          
          <label>Select the Operation</label>
          <input type="radio" name="create" value="c"/> <label>Create</label> 
          <input type="radio name="append" value="a"/><label>Append</label> 
          <input type="radio" name="delete" value="d"><label>Delete an Entry</label> 
          <fieldset id="dEntry">
          <legend>Delete an entry </legend>
           <label>Select a key</label>
           <select>
             <option value="">--Select a Key---</option>
             <c:forEach items="${applicationScope.keys}" var="key" >   
                <option value="${key}"> ${key}</option>
              </c:forEach>
           </select>
          
          </fieldset>
 
          <input type="submit" value="submit"/> 
        </fieldset>
      
      
      </form>
   
   
   
   </div>




<%@include file="footer.jsp"%>