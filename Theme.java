/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BudgetTracker;

/**
 *
 * @author Marquis
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Theme {
    // Color palette
    private static final Color DARK_BG = new Color(18, 18, 18);
    private static final Color DARK_PANEL = new Color(30, 30, 30);
    private static final Color ACCENT_INCOME = new Color(76, 175, 80);
    private static final Color ACCENT_EXPENSE = new Color(244, 67, 54);
    private static final Color TEXT_PRIMARY = new Color(240, 240, 240);
    
    public static void applyDarkTheme(JComponent component) {
        if (component instanceof JButton) {
            styleButton((JButton) component);
        } else if (component instanceof JTextField || component instanceof JPasswordField) {
            styleInputField(component);
        } else if (component instanceof JLabel) {
            styleLabel((JLabel) component);
        } else if (component instanceof JTextArea) {
            styleTextArea((JTextArea) component);
        }
        
        component.setOpaque(false);
        component.setBackground(DARK_PANEL);
        component.setForeground(TEXT_PRIMARY);
    }

    public static void styleTransactionComponent(JComponent component, String transactionType) {
        Color accent = transactionType.equalsIgnoreCase("Income") ? 
                      ACCENT_INCOME : ACCENT_EXPENSE;
        
        if (component instanceof JButton) {
            ((JButton) component).setBackground(accent);
        } else if (component instanceof JLabel) {
            ((JLabel) component).setForeground(accent);
        }
    }

    public static void applyGradientBackground(Container container) {
        container.setLayout(new BorderLayout());
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                   RenderingHints.VALUE_ANTIALIAS_ON);
                
                Color color1 = new Color(12, 12, 12);
                Color color2 = new Color(28, 28, 28);
                GradientPaint gp = new GradientPaint(
                    0, 0, color1, 
                    getWidth(), getHeight(), color2
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setLayout(container.getLayout());
        container.add(gradientPanel, BorderLayout.CENTER);
    }

    private static void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(8, 16, 8, 16));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
    }

    private static void styleInputField(JComponent field) {
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
            new EmptyBorder(8, 8, 8, 8)
        ));
        field.setBackground(DARK_PANEL);
    }

    private static void styleLabel(JLabel label) {
        label.setBorder(new EmptyBorder(4, 0, 4, 0));
    }

    private static void styleTextArea(JTextArea textArea) {
        textArea.setBorder(new EmptyBorder(8, 8, 8, 8));
        textArea.setEditable(false);
        textArea.setBackground(DARK_PANEL);
        textArea.setCaretColor(TEXT_PRIMARY);
    }
}