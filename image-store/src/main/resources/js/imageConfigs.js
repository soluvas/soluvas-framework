// TODO: make this dynamic
define(['uritemplate'], function(UriTemplate) {

var imageConfigs = {
	'person': {
		publicUriTemplate: 'http://dav.berbatik.rudi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}',
		publicUriExpander: UriTemplate.parse('http://dav.berbatik.rudi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}'),
	},
	'product': {
		publicUriTemplate: 'http://dav.berbatik.rudi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}',
		publicUriExpander: UriTemplate.parse('http://dav.berbatik.rudi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}'),
	},
	'shop': {
		publicUriTemplate: 'http://dav.berbatik.rudi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}',
		publicUriExpander: UriTemplate.parse('http://dav.berbatik.rudi.dev/{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}'),
	},
};

return imageConfigs;
});
