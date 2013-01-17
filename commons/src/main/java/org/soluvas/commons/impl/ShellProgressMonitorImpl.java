/**
 */
package org.soluvas.commons.impl;

import static org.fusesource.jansi.Ansi.ansi;

import org.eclipse.emf.ecore.EClass;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.ShellProgressMonitor;

import com.google.common.base.Strings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shell Progress Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ShellProgressMonitorImpl extends ProgressMonitorImpl implements ShellProgressMonitor {
	protected double totalWork = 100.0;
	protected double worked = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShellProgressMonitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.SHELL_PROGRESS_MONITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void beginTask(String name, int totalWork) {
		this.worked = 0.0d;
		this.totalWork = totalWork;
		final String nameAnsi = NameUtils.shortenAnsi(name, 39);
		System.out.print(ansi().render(nameAnsi + " "));
		System.out.print(ansi().saveCursorPosition());
		renderProgressBar();
	}
	
	protected void renderProgressBar() {
		final int totalBlocks = 19;
		final int blocksWorked = Math.min((int)(worked / totalWork * totalBlocks), totalBlocks);
		final int blocksUnworked = Math.min(totalBlocks - blocksWorked, totalBlocks);
		System.out.print(ansi().restorCursorPosition());
		System.out.print(ansi().saveCursorPosition());
		System.out.print(ansi().render("@|bold,blue " + Strings.repeat("❱", blocksWorked) + "|@" +
			"@|bold,black " + Strings.repeat("▪", blocksUnworked) + "|@ "));
		System.out.flush();
	}

	@Override
	public void internalWorked(double work) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(ProgressStatus status) {
		worked = totalWork;
		renderProgressBar();
		switch (status) {
		case OK:
			System.out.println(ansi().render("@|bold,bg_green,white   OK   |@ "));
			break;
		case ERROR:
			System.out.println(ansi().render("@|bold,bg_red,yellow  ERROR |@ "));
			break;
		case WARNING:
			System.out.println(ansi().render("@|bold,bg_yellow,white  WARN  |@ "));
			break;
		case DELETED:
			System.out.println(ansi().render("@|bold,bg_blue,yellow   DEL  |@ "));
			break;
		case SKIPPED:
			System.out.println(ansi().render("@|bold,bg_cyan,white  SKIP  |@ "));
			break;
		}
	}

	@Override
	public void worked(int work, ProgressStatus status) {
		worked = worked + work;
		renderProgressBar();
	}

} //ShellProgressMonitorImpl
