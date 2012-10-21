// TODO: make this dynamic
define(['uritemplate'], function(UriTemplate) {

var imageConfigs = {
	'person': {
		publicUriTemplate: 'http://dav.berbatik.annafi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}',
		publicUriExpander: UriTemplate.parse('http://dav.berbatik.annafi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}'),
	},
};

return imageConfigs;
});
