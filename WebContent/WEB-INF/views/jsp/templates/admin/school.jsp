<div class="container">
    
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
      <li class="active">
          <a href="#list" role="tab" data-toggle="tab">
              <icon class="glyphicon glyphicon-th-list"></icon> School List
          </a>
      </li>
      <li><a href="#add" role="tab" data-toggle="tab">
          <icon class="glyphicon glyphicon-plus"></icon> Add School
          </a>
      </li>
    </ul>
    
    <!-- Tab panes -->
    <div class="tab-content">
      <div class="tab-pane fade active in" id="list">
          <jsp:directive.include file="listSchool.jsp" />
      </div>
      <div class="tab-pane fade" id="add">
          <jsp:directive.include file="addSchool.jsp" />
      </div>
    </div>
    
</div>