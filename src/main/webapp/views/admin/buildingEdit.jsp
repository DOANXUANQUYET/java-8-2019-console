<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Building Edit</title>
</head>
<body>
	<div class="main-content" id="building-edit">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
					<li class="active">Dashboard</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>

			<div class="page-content">

				<div class="page-header">
					<h1>
						Dashboard <small> <i
							class="ace-icon fa fa-angle-double-right"></i> overview &amp;
							stats
						</small>
					</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<div class="form-horizontal" role="form" id="formEdit">
							<div class="form-group edit-form">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Tên tòa nhà </label>

								<div class="col-sm-9">
									<input type="text" id="name" class="form-control" name='name'>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Số tầng hầm </label>

								<div class="col-sm-9">
									<input type="text" id="numberOfBasement" class="form-control"
										name='numberOfBasement'>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Phí dịch vụ </label>

								<div class="col-sm-9">
									<input type="text" id="form-field-1" class="form-control"
										id="servicecost" name="servicecost">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Diện tích thuê </label>

								<div class="col-sm-9">
									<input type="text" id="rentArea" class="form-control"
										name="rentArea">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Hướng </label>

								<div class="col-sm-9">
									<input type="text" id="structure" class="form-control"
										name='structure'>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Đường </label>

								<div class="col-sm-9">
									<input type="text" id="street" class="form-control"
										name="street">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> Loại tòa nhà </label>

								<div class="col-sm-9">
									<label class='checkbox-inline'><input type="checkbox"
										value="TANG＿TRET" 　id="buildingTypes" name="buildingTypes">Tầng
										trệt</label> <label class='checkbox-inline'><input
										type="checkbox" value="NGUYEN_CAN" id="buildingTypes"
										name="buildingTypes">Nguyên căn</label> <label
										class='checkbox-inline'><input type="checkbox"
										value="NOI_THAT" id="buildingTypes" name="buildingTypes">Nội
										thất</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> </label>

								<div class="col-sm-9">
									<button type="button" class="btn btn-primary" id="addBuilding">Thêm
										tòa nhà</button>
									<button type="button" class="btn btn-primary">Hủy</button>
								</div>
							</div>

						</div>

					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</body>
</html>