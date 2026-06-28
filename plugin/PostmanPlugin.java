//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.opencellsoft.plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(
    name = "create-postman",
    aggregator = true
)
public class PostmanPlugin extends AbstractMojo {
    @Parameter(
        property = "inputDir",
        required = true
    )
    private String inputDir;
    @Parameter(
        property = "javaFile"
    )
    private String javaFile;
    @Parameter(
        property = "postmanFilename",
        defaultValue = "${project.build.directory}/postman/postman.json"
    )
    private String postmanFilename;

    public PostmanPlugin() {
    }

    public void execute() throws MojoExecutionException, MojoFailureException {
        File postmanFile = new File(this.postmanFilename);
        this.getLog().info("Will scann " + this.inputDir + " and write postman collection to " + postmanFile.getAbsolutePath());
        int separatorPos = postmanFile.getAbsolutePath().lastIndexOf("/");
        int separatorPos2 = postmanFile.getAbsolutePath().lastIndexOf("\\");
        separatorPos = separatorPos > separatorPos2 ? separatorPos : separatorPos2;
        (new File(postmanFile.getAbsolutePath().substring(0, separatorPos))).mkdirs();
        URL postmanTemplateFile = this.getClass().getClassLoader().getResource("Postman.collection.template.json");
        String postmanTemplate = null;

        try {
            Scanner scanner = new Scanner(postmanTemplateFile.openStream());

            try {
                scanner.useDelimiter("\\Z");
                postmanTemplate = scanner.next();
                scanner.close();
            } catch (Throwable var22) {
                try {
                    scanner.close();
                } catch (Throwable var20) {
                    var22.addSuppressed(var20);
                }

                throw var22;
            }

            scanner.close();
        } catch (Exception e) {
            throw new MojoExecutionException("Failed to read Postman template file", e);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(postmanFile, false));

            try {
                int scriptStart = postmanTemplate.indexOf("\"---startScript---\"");
                int scriptEnd = postmanTemplate.indexOf("\"---endScript---\"");
                String postmanTemplateHeader = postmanTemplate.substring(0, scriptStart);
                String postmanScriptSection = postmanTemplate.substring(scriptStart + "\"---startScript---\"".length(), scriptEnd);
                String postmanTemplateFooter = postmanTemplate.substring(scriptEnd + "\"---endScript---\"".length());
                writer.write(postmanTemplateHeader);
                File sources = new File(this.inputDir);
                List<File> files = (List)FileUtils.listFiles(sources, new String[]{"java"}, true).stream().sorted(Comparator.comparing(File::getName)).collect(Collectors.toList());
                int i = 0;

                for(File file : files) {
                    String fileContent = FileUtils.readFileToString(file, "UTF-8");
                    String classname = this.getFullClassname(fileContent);
                    if (classname != null) {
                        String scriptSection = postmanScriptSection.replace("<---scriptClassName--->", classname).replace("<---simpleScriptClassName--->", classname.substring(classname.lastIndexOf(".") + 1, classname.length()));
                        scriptSection = scriptSection.replace("<---scriptContent--->", StringEscapeUtils.escapeJson(fileContent).replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n"));
                        if (i > 0) {
                            writer.write(",");
                        }

                        writer.write(scriptSection);
                        ++i;
                    }
                }

                writer.newLine();
                writer.write(postmanTemplateFooter);
                System.out.println("Finished writing postman collection to " + postmanFile.getAbsolutePath());
            } catch (Throwable var24) {
                try {
                    writer.close();
                } catch (Throwable var21) {
                    var24.addSuppressed(var21);
                }

                throw var24;
            }

            writer.close();
        } catch (Exception e) {
            this.getLog().error("Failed to produce Postman file " + postmanFile.getAbsolutePath(), e);
        }

    }

    private String getPackageName(String src) {
        return patternMacher("package (.*?);", src);
    }

    private String getClassName(String src) {
        String className = patternMacher("public class (.*) extends", src);
        if (className == null) {
            className = patternMacher("public class (.*) implements", src);
        }

        return className != null ? className.trim() : null;
    }

    private String getFullClassname(String script) {
        String packageName = this.getPackageName(script);
        String className = this.getClassName(script);
        return (packageName != null ? packageName.trim() + "." : "") + className;
    }

    private static String patternMacher(String regex, String text) {
        String result = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            result = matcher.group(1);
        }

        return result;
    }

    public String getInputDir() {
        return this.inputDir;
    }

    public String getPostmanFilename() {
        return this.postmanFilename;
    }

    public String getJavaFile() {
        return this.javaFile;
    }
}
