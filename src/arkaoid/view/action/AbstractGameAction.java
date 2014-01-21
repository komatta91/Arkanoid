package arkaoid.view.action;

/**
 * Abstrakcyjna klasa bazowa hierarchi akcji wystêpuj¹cych w grze.
 * @author Karol
 *
 */
public abstract class AbstractGameAction implements Comparable<Object>
{
	public abstract int hashCode();

	public abstract boolean equals(Object obj);
}
