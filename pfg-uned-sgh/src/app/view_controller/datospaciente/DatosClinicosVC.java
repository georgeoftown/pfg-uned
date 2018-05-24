/*
 * Copyright (C) 2017 Alberto Bausá Cano
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package app.view_controller.datospaciente;

import app.common.DataBase;
import app.common.Utils;
import app.model.datospaciente.DatosClinicosModel;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * Diálogo para los datos clínicos de un paciente.
 *
 * @author Alberto Bausá Cano
 */
public class DatosClinicosVC extends library.JIASimpleDialog {

    private DatosClinicosModel model;
    
    /**
     * Creates new form DatosClinicosVC
     * 
     * @param datosClinicosModel Modelo para el diálogo
     */
    public DatosClinicosVC(DatosClinicosModel datosClinicosModel) {
        model = datosClinicosModel;
        initComponents();
        printLabelsForSlider();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        tfDoctor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfMedication = new javax.swing.JTextField();
        cbRCP = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sliderTriaje = new javax.swing.JSlider();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAllergies = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(410, 300));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Doctor de cabecera:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 0);
        add(jLabel1, gridBagConstraints);

        tfDoctor.setColumns(20);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.asignedDoctor}"), tfDoctor, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        add(tfDoctor, gridBagConstraints);

        jLabel2.setText("Medicación actual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 0);
        add(jLabel2, gridBagConstraints);

        tfMedication.setColumns(20);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.currentMedication}"), tfMedication, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 20);
        add(tfMedication, gridBagConstraints);

        cbRCP.setText("Reanimación Cardio Pulmonar (RCP)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        add(cbRCP, gridBagConstraints);

        jLabel4.setText("Alergias conocidas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Prioridad triaje");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        add(jLabel5, gridBagConstraints);

        sliderTriaje.setBackground(new java.awt.Color(204, 204, 204));
        sliderTriaje.setMaximum(10);
        sliderTriaje.setPaintLabels(true);
        sliderTriaje.setPaintTrack(false);
        sliderTriaje.setToolTipText("Nivel de urgencia de atención del paciente");
        sliderTriaje.setValue(0);
        sliderTriaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                notificarCambioTriaje(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 20);
        add(sliderTriaje, gridBagConstraints);

        taAllergies.setColumns(20);
        taAllergies.setRows(3);
        jScrollPane2.setViewportView(taAllergies);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 15, 20);
        add(jScrollPane2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("<html><font color=\"#173266\">Datos clínicos</font></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 5, 0);
        add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        add(jSeparator1, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void notificarCambioTriaje(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_notificarCambioTriaje
        this.cambiaVal(DataBase.MessageCodes.ID_RESUMEN_SLIDER, ((JSlider) evt.getSource()).getModel().getValue());
    }//GEN-LAST:event_notificarCambioTriaje

    @Override
    public boolean validateThis() {
        // valida que el médico asignado no esté vacío, y que la
        // prioridad está comprendida entre el 0 y el 10, incluídos
        return Utils.validateString(tfDoctor.getText())
                && sliderTriaje.getValue() >= 0
                && sliderTriaje.getValue() <= 10;
    }

    @Override
    public void saveThis() {
        // guarda los datos en el modelo, y con ello, en la base de datos
        this.model.setAsignedDoctor(tfDoctor.getText());
        if(Utils.validateString(tfMedication.getText()))
            this.model.setCurrentMedication(tfMedication.getText());
        this.model.setRcp(cbRCP.isSelected());
        if(Utils.validateString(taAllergies.getText()))
            this.model.setAllergiesByLine(taAllergies.getText());
        this.model.setTriajePriority(sliderTriaje.getValue());
        
    }

    @Override
    public void cleanThis() { }
        
    @Override
    public void getExternVal(String id, Object value) { }

    private void printLabelsForSlider() {
        Hashtable<Integer,JLabel> labels = new Hashtable();
        labels.put(0, new JLabel("0"));
        labels.put(1, new JLabel("1"));
        labels.put(2, new JLabel("2"));
        labels.put(3, new JLabel("3"));
        labels.put(4, new JLabel("4"));
        labels.put(5, new JLabel("5"));
        labels.put(6, new JLabel("6"));
        labels.put(7, new JLabel("7"));
        labels.put(8, new JLabel("8"));
        labels.put(9, new JLabel("9"));
        labels.put(10, new JLabel("10"));
        sliderTriaje.setLabelTable(labels);
    }
    
    private void loadData() {
        if(model.getRcp() != null)              cbRCP.setSelected(model.getRcp());
        if(model.getAllergiesByLine() != null)  taAllergies.setText(model.getAllergiesByLine());
        if(model.getTriajePriority() != null)   sliderTriaje.setValue(model.getTriajePriority());
    }

    public DatosClinicosModel getModel() {
        return model;
    }

    public void setModel(DatosClinicosModel model) {
        this.model = model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbRCP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider sliderTriaje;
    private javax.swing.JTextArea taAllergies;
    private javax.swing.JTextField tfDoctor;
    private javax.swing.JTextField tfMedication;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}