let query = new URLSearchParams(location.search);

$(() => {
	let sort = $('#sort');
	sort.change(() => {
		$('#search').click();
	});

	let by = query.get(sort.attr('id'));
	let option = $('#sort option[value="'+ by +'"]');
	option.prop('selected', true);
});

function onChangePage(page) {
	$('#page').val(page);
	$('#search').click();
}

function initFeaturesFilter() {
	let translations = new Map();
	translations.set('OTHER', 'Άλλο');
	translations.set('SAFETY', 'Ασφάλεια');

	$(() => {
		$.ajax({
			url: "/features",
			success: (features) => {
				let featuresDiv = $('#features');
				features.forEach((feature) => {
					let typeDiv = $("#" + feature.type);
					if (!typeDiv.length) {
						featuresDiv.append($(item(feature)));
					}

					let checked = query.getAll('feature').includes(feature.id.toString());
					let input = $(checkbox(feature, checked));
					let collapsible = $('#' + feature.type + '-collapse');
					collapsible.append(input);

					let expanded = collapsible.attr('aria-expanded');
					if (checked && !expanded) {
						collapsible.collapse();
					}
				});
			}
		});
	});

	let item = (feature) => `
		<div id="${feature.type}" class="list-group-item">
			<a data-toggle="collapse" href="#${feature.type}-collapse" aria-expanded="true" aria-controls="${feature.type}-collapse">
			   ${translations.get(feature.type)}
			</a>
			<div class="collapse" id="${feature.type}-collapse"></div>
		</div>
	`;

	let checkbox = (feature, checked = false) => `
		<div class="form-check">
			<input id="feature-${feature.id}" name="feature" type="checkbox" value="${feature.id}" class="form-check-input" ${checked && `checked`}/>
			<label for="feature-${feature.id}" class="form-check-label">${feature.name}</label>
		</div>
	`;
}

function initCategories() {
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
					/*
					let thumbnail = $('<div class="thumbnail text-center">');
					thumbnail.append('<input id="' + category.title + '" name="category" value="'+ category.id +'" type="checkbox"/>');
					thumbnail.append('<label for="'+ category.title +'"><img src="'+ category.picturePath +'" alt="Lights">' + category.title + '</></label>');
					*/
					c.append(figure(category));
					r.append(c);
				});
				
				parentDiv.append(r);
			}
		});
	});

	let figure = (category) => `
		<figure class="figure">
			<label for="${category.title}">
				<input id="${category.title}" name="category" value="${category.id}" type="checkbox">
				<img class="figure-img img-fluid" src="${category.picturePath}" alt="Lights">
				<figcaption class="figure-caption text-center">${category.title}</figcaption>
			</label>
		</figure>
	`;
}

class Filter {
	name;
	input;
	button;

	constructor(name, input) {
		this.name = name;
		this.input = input;
		this.button = $('<button type="button" class="btn btn-outline-primary btn-sm mr-2 rounded-pill">'+ name +'<span aria-hidden="true"> &times;</span></button>');
	}

	attachBehavior() {

	}
}

class CheckBoxFilter extends Filter {
	constructor(name, input) {
		super(name, input);
	}

	attachBehavior() {
		let buttons = $('#filters');
		/*
		this.input.change(() => {
			let checked = this.input.is(':checked');
			if (!checked) {
				this.button.detach();
			} else {
				buttons.append(this.button);
			}
		});
		*/

		this.button.on('click', (event) => {
			this.input.prop('checked', false).trigger('change');
			$('#search').click();
		});

		// Lets fix the initial state
		let all = query.getAll(this.input.attr('name'));
		if (all.includes(this.input.attr('id'))) {
			this.input.prop('checked', true);
			buttons.append(this.button);
		}
	}
}
