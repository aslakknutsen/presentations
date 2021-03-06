/**
 * slides2png plays a dzslides presentation using WebDriver, captures each
 * slide to a PNG and generates a shell script to collate the PNGs together
 * into a PDF using convert (from ImageMagick).
 *
 * The URL of the presentation is passed as the sole argument to the script.
 * If the presentation is local, specify the absolute path prefixed with the
 * file:// protocol.
 *
 * @author Dan Allen
 * @license ASLv2
 * @see https://github.com/mojavelinux/dzslides/blob/master/scripts/slides2png
 */

@Grapes([
    @Grab("org.codehaus.geb:geb-core:0.7.0"),
    //@Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.32.0"), 
    @Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.32.0"),
    @Grab("org.seleniumhq.selenium:selenium-support:2.32.0")
])
import geb.Browser
import org.openqa.selenium.Keys

System.setProperty('webdriver.chrome.driver', '/home/aslak/dev/tools/chromedriver')

if (args.length == 0) {
  println "Please specify the URL of the presentation"
  return
}

def url = args[0]

def reportsDir = '/tmp/geb-reports'
if (args.length > 1) {
  reportsDir = args[1]
}

Browser.drive {
    config.reportsDir = new File(reportsDir)
    cleanReportGroupDir()
    go url
 
    def idx = 1
    def body = $('body')
    body << 'f'
    sleep 6000
    def script = null
    def selected = null
    while (selected == null || !selected.lastElement().equals($('[aria-selected=true]').lastElement())) {
      selected = $('[aria-selected=true]').last()
      report "slide_" + idx
      if (script == null) {
        script = new File(getReportGroupDir(), 'to_pdf.sh')
        script.append("#!/bin/sh\n\ncd `dirname \$0`\nconvert")
      }
      script.append(' slide_' + idx + '.png')
      body << Keys.chord(Keys.RIGHT) 
      idx++
      sleep 500
    }
    script.append(' presentation.pdf')
    script.executable = true
    [script.absolutePath].execute().waitFor()
}.quit()
