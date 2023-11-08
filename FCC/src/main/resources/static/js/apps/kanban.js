$(function () {
  // ----------------------------------------------------------------------
  // draggble item
  // ----------------------------------------------------------------------
  function kanbanSortable() {
    $('[data-sortable="true"]').sortable({
      connectWith: ".connect-sorting-content",
      items: ".card",
      cursor: "move",
      placeholder: "ui-state-highlight",
      refreshPosition: true,
      stop: function (event, ui) {
        var parent_ui = ui.item.parent().attr("data-item");
      },
      update: function (event, ui) {
        console.log(ui);
        console.log(ui.item);
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
		console.log(formattedDate);
		
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
    $(".card .kanban-item-edit")
      .off("click")
      .on("click", function (event) {
        event.preventDefault();

        var parentItem = $(this);

        $(".add-task-title").hide();
        $(".edit-task-title").show();

        $('[data-btn-action="addTask"]').hide();
        $('[data-btn-action="editTask"]').show();

        var itemKanbanTitle = parentItem
          .parents(".card")
          .find("h4")
          .attr("data-item-title");
        var get_kanban_title = $(".task-text-progress #kanban-title").val(
          itemKanbanTitle
        );

        var itemText = parentItem
          .parents(".card")
          .find('p:not(".progress-count")')
          .attr("data-item-text");
        var get_kanban_text = $(".task-text-progress #kanban-text").val(
          itemText
        );

        $('[data-btn-action="editTask"]')
          .off("click")
          .on("click", function (event) {
            var kanbanValueTitle =
              document.getElementById("kanban-title").value;
            var kanbanValueText = document.getElementById("kanban-text").value;

            var itemDataAttr = parentItem
              .parents(".card")
              .find("h4")
              .attr("data-item-title", kanbanValueTitle);
            var itemKanbanTitle = parentItem
              .parents(".card")
              .find("h4")
              .html(kanbanValueTitle);
            var itemTextDataAttr = parentItem
              .parents(".card")
              .find('p:not(".progress-count")')
              .attr("data-tasktext", kanbanValueText);
            var itemText = parentItem
              .parents(".card")
              .find('p:not(".progress-count")')
              .html(kanbanValueText);

            $("#addItemModal").modal("hide");
            var setDate = $(".taskDate").html("");
            $(".taskDate").hide();
          });
        $("#addItemModal").modal("show");
      });
  }

  editItem();
  clearItem();
  addKanbanItem();
  kanbanEdit();
  kanbanDelete();
  kanbanSortable();
});
