import DS from 'ember-data';
import { fragmentArray } from 'model-fragments/attributes';

export default DS.Model.extend({
	userId: DS.attr("number", {defaultValue: 0}),
	deleted: DS.attr("boolean", {defaultValue: false}),

	creationDate: DS.attr("date", {defaultValue: moment().format("DD/MM/YYYY")}),
    dueDate: DS.attr("date", {defaultValue: moment().format("DD/MM/YYYY")}),
    lines: fragmentArray("billline"),

    vendorName: DS.attr("string", {defaultValue: ""}),
    payeeName: DS.attr("string", {defaultValue: ""}),
    payeeEmail: DS.attr("string", {defaultValue: ""}),
    phoneNumber: DS.attr("string", {defaultValue: ""}),

    setVendor(vendor) {
    	this.set("vendorName", vendor.get("vendorName"));
	    this.set("payeeName", vendor.get("payeeName"));
	    this.set("payeeEmail", vendor.get("payeeEmail"));
	    this.set("phoneNumber", vendor.get("phoneNumber"));
    }
});
