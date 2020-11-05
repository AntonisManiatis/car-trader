let query = new URLSearchParams(location.search);

$(() => {
	let checkBoxFilterUsed = new CheckBoxFilter('Μεταχειρισμένο', $('#used'));
	checkBoxFilterUsed.attachBehavior();

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
