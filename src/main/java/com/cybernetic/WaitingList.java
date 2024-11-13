package com.cybernetic;
class WaitingList {
    WaitingListNode head;

    public WaitingList() {
        head = null;
    }

    // Method to add a patient to the waiting list
    public void addPatient(Patient patient, int priority) {
        WaitingListNode newNode = new WaitingListNode(patient, priority);
        if (head == null || head.priority < priority) {
            newNode.next = head;
            head = newNode;
        } else {
            WaitingListNode current = head;
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public Patient removeHighestPriority() {
        if (head == null) return null;
        Patient highestPriorityPatient = head.patient;
        head = head.next;
        return highestPriorityPatient;
    }

    // Method to update the priority of a patient
    public void updatePriority(String patientId, int newPriority) {
        WaitingListNode current = head;
        WaitingListNode prev = null;

        while (current != null) {
            if (current.patient.getId().equals(patientId)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                addPatient(current.patient, newPriority);
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Method to display the waiting list
    public void displayWaitingList() {
        WaitingListNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient.getName() + " (Priority: " + current.priority + ")");
            current = current.next;
            position++;
        }
    }

    // Method to get the position of a patient in the waiting list
    public int getPosition(String patientId) {
        WaitingListNode current = head;
        int position = 1;
        while (current != null) {
            if (current.patient.getId().equals(patientId)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }



    public void removePatient(String patientId) {
        WaitingListNode current = head;
        WaitingListNode prev = null;

        while (current != null) {
            if (current.patient.getId().equals(patientId)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
