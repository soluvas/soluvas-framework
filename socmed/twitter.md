# Social Twitter

## Usage from Spring

	@Inject
	private TwitterUtils twitterUtils;

Java:

	List<HintPerson> hints = twitterUtils.findFriends("**ACCESS TOKEN**");
