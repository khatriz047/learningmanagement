<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="formcontainer">
	<div class="row">
		<div class="col-md-12 col-sm-6 col-xs-12">

			<div class="panel-body">
				<form:form method="POST" action="profile/savephoto"
					modelAttribute="user">
					<form:hidden path="id" value="${user.id}" />
					<div class="form-group">
						<img src="resources/${empty user.imageUrl?'no_image.jpg':user.imageUrl}" class="img-thumbnail"
							alt="${user.firstname}" width="120"
							style="float: left; margin-right: 10px;">
						<div id="photoDragDropHandler" class="dragDropHandler">Drag
							& Drop!</div>
						<form:hidden path="imageUrl" class="form-control"
							value="${user.imageUrl}" />
						<div id="statusPhoto"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">

							<button type="submit" id="bth-search"
								class="btn btn-primary btn-sm">Upload</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var photo = $("#photoDragDropHandler");
		initializeDragDrop(photo);

		/* initializeTask(); */
	});

	function initializeDragDrop(obj) {

		obj.on('dragenter', function(e) {
			e.stopPropagation();
			e.preventDefault();
			$(this).css('border', '2px solid #0B85A1');
		});
		obj.on('dragover', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		obj.on('drop', function(e) {

			$(this).css('border', '2px dotted #0B85A1');
			e.preventDefault();
			var files = e.originalEvent.dataTransfer.files;

			//We need to send dropped files to Server
			handleFileUpload(files, obj);
		});
		$(document).on('dragenter', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
		$(document).on('dragover', function(e) {
			e.stopPropagation();
			e.preventDefault();
			obj.css('border', '2px dotted #0B85A1');
		});
		$(document).on('drop', function(e) {
			e.stopPropagation();
			e.preventDefault();
		});
	}

	function handleFileUpload(files, obj) {
		for (var i = 0; i < files.length && 1; i++) {
			var fd = new FormData();
			fd.append('file', files[i]);

			var status = new createStatusbar(obj); //Using this we can set progress.
			status.setFileNameSize(files[i].name, files[i].size);

			sendFileToServer(fd, status, obj);

		}
	}

	function sendFileToServer(formData, status, obj) {

		var uploadURL = "profile/upload"; //Upload URL
		var jqXHR = $.ajax({
			xhr : function() {
				var xhrobj = $.ajaxSettings.xhr();
				if (xhrobj.upload) {
					xhrobj.upload.addEventListener('progress', function(event) {
						var percent = 0;
						var position = event.loaded || event.position;
						var total = event.total;
						if (event.lengthComputable) {
							percent = Math.ceil(position / total * 100);
						}
						//Set progress
						status.setProgress(percent);
					}, false);
				}
				return xhrobj;
			},
			url : uploadURL,
			type : "POST",
			contentType : false,
			processData : false,
			cache : false,
			data : formData,
			success : function(data) {
				status.setProgress(100);

				var objstring = JSON.stringify(data[0]);
				var result = JSON.parse(objstring);

				if (obj.attr('id') == 'photoDragDropHandler')
					$('#imageUrl').val(result.fileName);
			}
		});

		status.setAbort(jqXHR);
	}

	var rowCount = 0;

	function createStatusbar(obj) {
		rowCount++;
		var row = "odd";
		if (rowCount % 2 == 0)
			row = "even";
		this.statusbar = $("<div class='statusbar "+row+"'></div>");
		this.filename = $("<div class='filename'></div>").appendTo(
				this.statusbar);
		this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
		this.progressBar = $("<div class='progressBar'><div></div></div>")
				.appendTo(this.statusbar);
		this.abort = $("<div class='abort'>Abort</div>").appendTo(
				this.statusbar);
		obj.after(this.statusbar);

		this.setFileNameSize = function(name, size) {
			var sizeStr = "";
			var sizeKB = size / 1024;
			if (parseInt(sizeKB) > 1024) {
				var sizeMB = sizeKB / 1024;
				sizeStr = sizeMB.toFixed(2) + " MB";
			} else {
				sizeStr = sizeKB.toFixed(2) + " KB";
			}

			this.filename.html(name);
			this.size.html(sizeStr);
		}
		this.setProgress = function(progress) {
			var progressBarWidth = progress * this.progressBar.width() / 100;
			this.progressBar.find('div').animate({
				width : progressBarWidth
			}, 10).html(progress + "%&nbsp;");
			if (parseInt(progress) >= 100) {
				this.abort.hide();
			}
		}
		this.setAbort = function(jqxhr) {
			var sb = this.statusbar;
			this.abort.click(function() {
				jqxhr.abort();
				sb.hide();
			});
		}
	}
</script>
<script src="<c:url value='/resources/js/myuploadfunction.js' />"></script>