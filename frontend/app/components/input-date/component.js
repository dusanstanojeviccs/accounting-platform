import Ember from 'ember';

export default Ember.Component.extend({
	init() {
		this._super(...arguments);
	},

	didInsertElement() {
		this._super(...arguments);

		if(!this.get("disabled")) {
			this.$("input").datetimepicker({
				format: "DD/MM/YYYY",
				ignoreReadonly: true,
				inline: true,
				icons: {
					time: 'fa fa-clock-o',
					date: 'fa fa-calendar',
					up: 'fa fa-chevron-up',
					down: 'fa fa-chevron-down',
					previous: 'fa fa-chevron-left',
					next: 'fa fa-chevron-right',
					today: 'fa fa-calendar-check-o',
					clear: 'fa fa-trash-o',
					close: 'fa fa-times'
				}
			});
		}

		this.$(".input-group-addon").on('click', () => {
			this.$("input").focus().click();
		});
	},

	willDestroyElement() {
		this.$("input").data("DateTimePicker").destroy();	
	
		this.$(".input-group-addon").off('click');
	},

	actions: {
		onKeyDown(t, e) {
			e.preventDefault();
			return false;
		}
	}

});
