define(['org.soluvas.image/imageConfigs', 'uritemplate'], function(imageConfigs, UriTemplate) {

var Images = {
	getPublicUri: function(namespace, imageId, styleCode, variantCode, ext) {
		if (typeof(namespace) === 'undefined') {
			console.error('org.soluvas.web/Image: Namespace must be provided');
		}
		if (typeof(imageId) === 'undefined') {
			console.error('org.soluvas.web/Image: Namespace must be provided');
		}
		var styleCode = typeof styleCode !== 'undefined' ? styleCode : 't';
		var styleVariant = typeof variantCode !== 'undefined' ? styleCode + '_' + variantCode : styleCode;
		var ext = typeof ext !== 'undefined' ? ext : 'jpg';
		return imageConfigs[namespace].publicUriExpander.expand({namespace: namespace, imageId: imageId,
			styleCode: styleCode, variantCode: variantCode, styleVariant: styleVariant, ext: ext});
	},
};

return Images;
});
