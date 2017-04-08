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
			this.get("bill.lines").removeObject(this.get("line"));
			
			Ember.$(".modal").modal("hide");
		},
		successAction() {
			this.get("bill").save().then(() => {
				this.$(".modal").modal("hide");
			});
		}	
	}
});
