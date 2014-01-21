package arkaoid.view.action;

/**
 * Abstrakcyjna klasa bazowa hierarchi akcji wyst�puj�cych w grze.
 * @author Karol
 *
 */
public abstract class AbstractGameAction implements Comparable<Object>
{
	public abstract int hashCode();

	public abstract boolean equals(Object obj);
}
