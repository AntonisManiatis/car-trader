function fillMakes() {
	$(() => {
		$.ajax({
			url: "/makes",
			success: (makes) => {
				makes.forEach(make => {
					let option = $('<option>', {
						value: make.id,
						text: make.name
					});

					$('#make').append(option);
				});
			}
		});

		let makeSelect = $('#make');
		makeSelect.change(() => {
			$('#model').empty();
			$('#model').append('<option selected>Οποιoδήποτε</option>');

			// if no make gets selected then erase everything.
			let selected = $('#make :selected');
			if (selected.text() !== 'Οποιαδήποτε') {
				$.ajax({
					url: '/makes/' + makeSelect.val() + '/models',
					success: (models) => {
						models.forEach(model => {
							let option = $('<option>', {
								value: model.id,
								text: model.name
							});

							$('#model').append(option);
						});
					}
				});
			}
		});
	});
}

function fillCategories() {
	$(() => {
		$.ajax({
			url: "/categories",
			success: (categories) => {
				let parentDiv = $('#categories');
				var r = $('<div class="row">');
				$.each(categories, (index, category) => {
					if (index % 4 == 0) {
						r = $('<div class="row">');
						parentDiv.append(r);
					}

					let c = $('<div class="col-sm-3">');
					let thumbnail = $('<div class="thumbnail text-center">');
					thumbnail.append('<input id="' + category.title + '" name="category" value="'+ category.id +'" type="checkbox"/>');
					thumbnail.append('<label for="'+ category.title +'"><img src="'+ category.picturePath +'" alt="Lights">' + category.title + '</></label>');
					c.append(thumbnail);
					r.append(c);
				});
				
				parentDiv.append(r);
			}
		});
	});	
}