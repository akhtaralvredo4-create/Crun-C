def run_code(code):
    import io
    import contextlib

    output = io.StringIO()

    try:
        with contextlib.redirect_stdout(output):
            exec(code, {})
        return output.getvalue() or "Code executed successfully."
    except Exception as error:
        return f"Error: {error}"
