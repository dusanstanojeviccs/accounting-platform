import MF from 'model-fragments';
import attr from 'ember-data/attr';

export default MF.Fragment.extend({

    itemName: attr("string", {defaultValue: ""}),
    accountNum: attr("string", {defaultValue: ""}),
    accountName: attr("string", {defaultValue: ""}),
    amount: attr("amount", {defaultValue: "0.00"}),

    setAccount(account) {
    	this.set("accountNum", account.get("accountNum"));
    	this.set("accountName", account.get("accountName"));
    }
});
