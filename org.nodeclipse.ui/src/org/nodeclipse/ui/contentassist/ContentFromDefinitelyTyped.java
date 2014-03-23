package org.nodeclipse.ui.contentassist;

/**
 * Taking some completions from TypeScript type defnitions files.
 * Example of .d.ts
<pre>
/**
 * Interface for the AJAX setting that will configure the AJAX request
 * /
interface JQueryAjaxSettings {
    /**
     * The content type sent in the request header that tells the server what kind of response it will accept in return. If the accepts setting needs modification, it is recommended to do so once in the $.ajaxSetup() method.
     * /
    accepts?: any;
    /**
     * By default, all requests are sent asynchronously (i.e. this is set to true by default). If you need synchronous requests, set this option to false. Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation. Note that synchronous requests may temporarily lock the browser, disabling any actions while the request is active. As of jQuery 1.8, the use of async: false with jqXHR ($.Deferred) is deprecated; you must use the success/error/complete callback options instead of the corresponding methods of the jqXHR object such as jqXHR.done() or the deprecated jqXHR.success().
     * /
    async?: boolean;

</pre> 
 * 
 * @author Paul Verest
 * @since 0.12
 */
public class ContentFromDefinitelyTyped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
