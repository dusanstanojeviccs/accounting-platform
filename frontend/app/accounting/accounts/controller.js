import Ember from 'ember';
import SortBy from 'ember-sort-table/mixins/sort-by-d';


export default Ember.Controller.extend(SortBy, {
	store: Ember.inject.service(),
	tableId: "accountsList",
	dataForTable: Ember.computed("model", function() { return this.get("model").toArray(); }),

	notDeleted: Ember.computed("sortedData.@each.isDeleted", function() {
		return this.get("sortedData").filter(o => !o.get("isDeleted"));
	}),

	actions: {
		setupNewAccount() {
			let account = this.get("store").createRecord("account");
			
			this.get("sortedData").addObject(account);

			this.set("account", account);
		},
		setAccount(account) {
			this.set("account", account);
		}
	}
});
