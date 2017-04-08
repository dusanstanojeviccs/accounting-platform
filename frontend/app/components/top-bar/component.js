import Ember from 'ember';

export default Ember.Component.extend({
	auth: Ember.inject.service(),
	tagName: '',
	actions: {
		logout() {
			Ember.$.get("/logout").then(() => {
				this.get("auth").set("user", {});
				this.sendAction("transitionToSignIn");
			});
		},
		toggleSidebar() {
			let $html = Ember.$("html");
			if ($html.is(".nav-open")) {
				$html.removeClass("nav-open");
			} else {
				$html.addClass("nav-open");
			}
		}
	}
});
