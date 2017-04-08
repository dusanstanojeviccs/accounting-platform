if (typeof EmberSortTableComparator === "undefined") {
	EmberSortTableComparator = {};
}
if (typeof EmberSortTableComparator.sortOptions === "undefined") {
    EmberSortTableComparator.sortOptions = {};
}

EmberSortTableComparator.sortOptions.date = {requiresOrdering: true};
EmberSortTableComparator.date = function(a, b, reverseOrdering) {
    if (!a && !b) return 0;
    if (!a) return -1;
    if (!b) return 1;

    if (a.indexOf("/") > -1) {
        a = moment(a, "DD/MM/YYYY");
        b = moment(b, "DD/MM/YYYY");
    } else {
        a = moment(a, "YYYY-MM-DD");
        b = moment(b, "YYYY-MM-DD");    
    }
	
	return (reverseOrdering?-1:1)*(a>b?-1:(a<b?1:0));
};



EmberSortTableComparator.sortOptions.boolean = {requiresOrdering: true};
EmberSortTableComparator.boolean = function(a, b, reverseOrdering) {
    return (reverseOrdering?-1:1)*(a>b?-1:(a<b?1:0));
};


EmberSortTableComparator.sortOptions.default = {requiresOrdering: true};
EmberSortTableComparator.default = function(a, b, reverseOrdering) {
    if (!a && !b) return 0;
    if (!a) return -1;
    if (!b) return 1;

    if (typeof a.toLowerCase === "function") {
        a = a.toLowerCase();
    }
    if (typeof b.toLowerCase === "function") {
        b = b.toLowerCase();
    }

    return (reverseOrdering?-1:1)*(a>b?-1:(a<b?1:0));
};


EmberSortTableComparator.sortOptions.number = {requiresOrdering: true};
EmberSortTableComparator.number = function(a, b, reverseOrdering) {
	a = (a+"").replace("%", "").replace("$", "").split(",").join("");
    b = (b+"").replace("%", "").replace("$", "").split(",").join("");
    
    a = parseFloat(a);
    b = parseFloat(b);

    a = isNaN(a) ? 0 : a;
    b = isNaN(b) ? 0 : b;

    return reverseOrdering?b - a:a - b;
};
