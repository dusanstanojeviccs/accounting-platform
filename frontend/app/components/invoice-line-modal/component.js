import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		setAccount(index) {
			if (index === "-1") {
				this.set("line.accountName", "");
				this.set("line.accountNum", "");
			} else {
				this.get("line").setAccount(this.get("accounts").objectAt(index));
			}
		},
		backAction() {
			this.get("invoice.lines").removeObject(this.get("line"));
			
			Ember.$(".modal").modal("hide");
		},
		successAction() {
			this.get("invoice").save().then(() => {
				this.$(".modal").modal("hide");
			});
		}	
	}
});
