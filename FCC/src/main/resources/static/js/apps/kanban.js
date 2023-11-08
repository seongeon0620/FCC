$(function () {
  // ----------------------------------------------------------------------
  // 드래그
  // ----------------------------------------------------------------------
	function kanbanSortable() {
		$('[data-sortable="true"]').sortable({
		connectWith: ".connect-sorting-content",
		items: ".card",
		cursor: "move",
		placeholder: "ui-state-highlight",
		refreshPosition: true,
		stop: function (event, ui) {
			let parent_ui1 =ui.item.closest('[data-item]');
			let parent_ui = ui.item.closest('[data-item]').data('item');
			let storageName = parent_ui;
			let frigoSeq = ui.item.find('h4').attr('data-item-title');
			
			$.ajax({
				url : "/frigo/updateStatus",
				data : {
					"frigo_seq" : frigoSeq,
					"frigo_storage" : storageName
				},
				dataType : 'json',
				method : 'post'
			})
			.done((res) => {
				console.log(res);
				if (res.message == "success") {
					console.log(parent_ui1.find('.empty-text'));
//					console.log(ui.item.closest('[data-item]').children().find('.empty-text'));
//					console.log(ui.item.closest('[data-item]').find('.empty-text'));
					
				}
			})
			.fail((res, error, status) => {
				console.log(error);
			})
			console.log(event);
		},
		update: function (event, ui) {
//			if (event.target.length)
			console.log(event.target);
			let targetElements = event.target;
			
//			if (targetElements.innerHTML.trim() == "") {
//				let parentName = ui.item.closest('[data-item]').data('item');
//				let new_pTag = document.createElement('p');
//					new_pTag.setAttribute('class', 'text-center');
//					new_pTag.innerHTML = parentName + "에 보관중인 재료가 없습니다.";
//					targetElements.appendChild(new_pTag);
//			}
//			console.log(targetElements.innerHTML.trim() == "");
//			console.log(targetElements.querySelectorAll('class'));
//			console.log(targetElements.getElementsByClassName('empty-text'));
////			console.log(event.target.children().find('.empty-text'));
//			console.log(ui);
//			console.log(ui.item.parent());
////			console.log(ui.item.closest('[data-item]').children().find('.empty-text'));
		},
	});
	}

  // ----------------------------------------------------------------------
  // 전부 삭제
  // ----------------------------------------------------------------------
	function clearItem() {
		$(".list-clear-all")
			.on("click", function (event) {
				event.preventDefault();

				let targetStorage = $(this).closest('.task-container-header').find('.item-head').attr('data-item-title');
				console.log(targetStorage);
				$.ajax({
					url : `/frigo/deleteAll/${targetStorage}`,
					method : 'post'
				})
				.done((res) => {
					if (res.response == 'success') {
						alert(`${targetStorage}을(를) 전부 비웠습니다.`);
						location.reload();
					}
					
				})
				.fail((res, error, status) => {
					console.log(error);
				})
		});
	}

  // ----------------------------------------------------------------------
  // 저장공간 추가
  // ----------------------------------------------------------------------
	function addKanbanItem() {
		$(".addTask").on("click", function (event) {
			event.preventDefault();
			getParentElement = $(this)
				.parents('[data-action="sorting"]')
				.attr("data-item");
			$("#storage-type").val(getParentElement)
			$(".edit-task-title").hide();
			$(".add-task-title").show();
			$('[data-btn-action="addTask"]').show();
			$('[data-btn-action="editTask"]').hide();
			$("#addItemModal").modal("show");
			kanban_add(getParentElement);
		});
	}

  // ----------------------------------------------------------------------
  //   add default item
  // ----------------------------------------------------------------------
	function kanban_add(getParent) {
		$('[data-btn-action="addTask"]')
		.off("click")
		.on("click", function (event) {
			
		let itemTitle = document.getElementById("kanban-title");
		let itemText = document.getElementById("kanban-text");
		let itemEdate = document.getElementById("kanban-edate");
		
		let tmpDate = new Date(itemEdate.value);

		let year = tmpDate.getFullYear().toString().substr(-2);
		let month = (tmpDate.getMonth() + 1).toString().padStart(2, '0');
		let day = tmpDate.getDate().toString().padStart(2, '0');
		
		let formattedDate = year + '/' + month + '/' + day;
		
		if (itemTitle.value == "") {
			alert("재료명을 입력하세요.");
			itemTitle.focus();
			return false;
		}
		if (itemText.value == "") {
			alert("상세 재료명을 선택하세요.");
			return false;
		}
		
		if (itemEdate.value == "") {
			alert("유통기한을 선택하세요.");
			return false;
		}
		
		
		$.ajax({
			url : "/frigo/save",
			method : "post",
			data : {
				"ingre_seq" : itemText.value,
				"frigo_expiration" : formattedDate,
				"frigo_storage" : $("#storage-type").val()
			},
			dataType : "json"
			
		})
		.done((res) => {
			 if (res.response == 'success')
				 location.reload();
		})
		.fail((res, error, status) => {
			console.log("등록 실패");
			console.log(error);
		})
			
		getAddBtnClass = $(this).attr("class").split(" ")[1];

		let today = new Date();
		console.log(today);
		let dd = String(today.getDate()).padStart(2, "0");
		let mm = String(today.getMonth() + 1);
		let yy = String(today.getFullYear()).slice(-2);
		let hh = String(today.getHours());
		let minutes = String(today.getMinutes());

		today = yy + "/" + mm + "/" + dd + " " + hh + ":" + minutes;

	});
}

  // ----------------------------------------------------------------------
  //   add item
  // ----------------------------------------------------------------------
  $("#add-list")
    .off("click")
    .on("click", function (event) {
      event.preventDefault();

      $(".add-list").show();
      $(".edit-list").hide();
      $(".edit-list-title").hide();
      $(".add-list-title").show();
      $("#addListModal").modal("show");
    });

  // ----------------------------------------------------------------------
  // edit item
  // ----------------------------------------------------------------------
  function editItem() {
    $(".list-edit")
      .off("click")
      .on("click", function (event) {
        event.preventDefault();

        var parentItem = $(this);

        $(".add-list").hide();
        $(".edit-list").show();

        $(".add-list-title").hide();
        $(".edit-list-title").show();

        var itemTitle = parentItem
          .parents('[data-action="sorting"]')
          .find(".item-head")
          .attr("data-item-title");
        $("#item-name").val(itemTitle);

        $(".edit-list")
          .off("click")
          .on("click", function (event) {
            var $_innerThis = $(this);
            var $_getListTitle = document.getElementById("item-name").value;

            var $_editedListTitle = parentItem
              .parents('[data-action="sorting"]')
              .find(".item-head")
              .html($_getListTitle);
            var $_editedListTitleDataAttr = parentItem
              .parents('[data-action="sorting"]')
              .find(".item-head")
              .attr("data-item-title", $_getListTitle);

            $("#addListModal").modal("hide");
            $("#item-name").val("");
          });
        $("#addListModal").modal("show");
        $("#addListModal").on("hidden.bs.modal", function (e) {
          $("#item-name").val("");
        });
      });
  }

  // ----------------------------------------------------------------------
  // Delete item on click
  // ----------------------------------------------------------------------
	function kanbanDelete() {
		$(".card .kanban-item-delete").on("click", function (event) {
			event.preventDefault();

			// get_card_parent = $(this).parents(".card");
			console.log($(this).closest(".card").find('.task-header h4').attr('data-item-title'));			
			let targetFrigoId = $(this).closest(".card").find('.task-header h4').attr('data-item-title');

			$("#deleteConformation").modal("show");

			$('[data-remove="task"]').on("click", (event) => {
				event.preventDefault();
				
				$.ajax({
					url : `/frigo/delete/${targetFrigoId}`,
					method : 'post'
				})
				.done((res) => {
					if (res.response == 'success')
						location.reload();
				})
				.fail((res, error, status) => {
					console.log(error);
				})
			});
		});
	}

  // ----------------------------------------------------------------------
  // Edit item on click
  // ----------------------------------------------------------------------
  function kanbanEdit() {
	$(".card .kanban-item-edit").on("click", function (event) {
		event.preventDefault();
		$("#addItemModal").modal("show");

		let parentItem = $(this);

		$(".add-task-title").hide();
		$(".edit-task-title").show();

		$('[data-btn-action="addTask"]').hide();
		$('[data-btn-action="editTask"]').show();

		let itemKanbanTitle = parentItem.parents(".card").find("h4").text();
		let get_kanban_title = $(".task-text-progress #kanban-title").val(
			itemKanbanTitle
		);

		let itemText = parentItem.parents(".card").find('p').text();
		console.log(itemText);
		$("#kanban-text").append($('<option>', { value: itemText, text: itemText}));
		
		let frigoSeq = parentItem.parents(".card").find("h4").attr('data-item-title');
		let itemEdate = parentItem.parents(".card").find('#expiration').attr('data-item-date');
		console.log("----------" + itemEdate);
		
		var dateParts = itemEdate.split('/');
		var year = "20" + dateParts[0];
		var month = dateParts[1];
		var day = dateParts[2];
		
		// 'yyyy-mm-dd' 형식의 문자열로 포맷팅
		var isoDate = year + '-' + month + '-' + day;
		
		$("#kanban-edate").val(isoDate);
		
		$('[data-btn-action="editTask"]').on("click", () => {
			let ingreSeq = document.getElementById("kanban-text").value;
			let updateDate = document.getElementById("kanban-edate").value;
			$.ajax({
				url: "/frigo/modify",
				data: {
					"frigo_seq" : frigoSeq,
					"ingre_seq" : ingreSeq,
					"frigo_expiration" : updateDate
				},
				dataType: 'json',
				method: 'post'
			})
			.done((res) => {
				console.log(res);
				console.log(res.response);
				if (res.response == "success") {
					location.reload();
//					let kanbanValueTitle = document.getElementById("kanban-title").value;
//					let kanbanValueText = $("#kanban-text option:selected").text();
//		
//					let itemDataAttr = parentItem.parents(".card").find("h4").attr("data-item-title", kanbanValueTitle);
//					let itemKanbanTitle = parentItem.parents(".card").find("h4").html(kanbanValueTitle);
//					let itemTextDataAttr = parentItem.parents(".card").find('p:not(".progress-count")').attr("data-tasktext", kanbanValueText);
//					console.log(itemTextDataAttr);
//					let itemText = parentItem.parents(".card").find('p:not(".progress-count")').html(kanbanValueText);
//					
//					console.log("----------" + updateDate);
//		
//					$("#addItemModal").modal("hide");
//					var setDate = $(".taskDate").html("");
//					$(".taskDate").hide();
				}
			})
			.fail((res, error, status) => {
				console.log(error);
			})
			
			
			});
		
	});
}
  editItem();
  clearItem();
  addKanbanItem();
  kanbanEdit();
  kanbanDelete();
  kanbanSortable();
});
