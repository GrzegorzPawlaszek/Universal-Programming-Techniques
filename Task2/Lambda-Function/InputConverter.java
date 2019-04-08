package zad1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputConverter<T> {

	public T field;

	public InputConverter(T arg) {
		field = arg;
	}

<R> R convertBy(Function<?, ?> ... funcs) {
        Function f = funcs[0];
        for (int i = 1; i < funcs.length ; i++)
            f = f.andThen(funcs[i]);
            return (R)(f.apply(field));
    }
}
