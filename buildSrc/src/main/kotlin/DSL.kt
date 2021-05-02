import de.itemis.mps.gradle.Plugin
import org.w3c.dom.Document
import org.w3c.dom.Node
import java.io.File
import java.util.zip.ZipFile
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

fun toPlugin(file: File): Plugin {
    return ZipFile(file).use { zipFile ->
        zipFile.entries().asSequence()
            .first { it.name.endsWith("META-INF/plugin.xml") }
            .let { entry ->
                val name = entry.name.substring(0, entry.name.indexOf('/'))
                val xmlDoc: Document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(zipFile.getInputStream(entry))
                xmlDoc.documentElement.normalize()
                val xPath: XPath = XPathFactory.newInstance().newXPath()
                val evaluate: Node =
                    xPath.compile("/idea-plugin/id")
                        .evaluate(xmlDoc, XPathConstants.NODE) as Node
                Plugin(evaluate.textContent, name)
            }
    }
}