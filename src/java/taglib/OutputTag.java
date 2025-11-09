package taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Custom tag to output a message in JSP.
 */
public class OutputTag extends TagSupport {
    private String message;

    // Setter for the 'message' attribute
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            // Write the message to the JSP output
            JspWriter out = pageContext.getOut();
            out.print("<div style='color: green; font-size: 14px;'>" + message + "</div>");
        } catch (Exception e) {
            throw new JspException("Error in OutputTag", e);
        }
        return SKIP_BODY; // No body processing
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE; // Continue evaluating the JSP page
    }
}
